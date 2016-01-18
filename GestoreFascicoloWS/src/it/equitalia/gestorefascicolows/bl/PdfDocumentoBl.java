package it.equitalia.gestorefascicolows.bl;


 
import java.io.File;  
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis.client.Stub;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.log4j.Logger;

import com.ibm.ws.webservices.engine.transport.http.HTTPConstants;
 

import it.equitalia.gestorefascicolows.dao.CartellaDAO;
import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.impl.CartellaDAOImpl;
import it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest;
import it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse; 
import it.equitalia.gestorefascicolows.dati.DataValue;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest;
import it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse;  
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Convertions;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass; 
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumFileBean;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumHandler;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumHandler.ContentType; 
//import it.equitalia.pdfdocumentofascicolo.bpel.BPSPdfDocumentoFascicoloProxy;
//import it.equitalia.pdfdocumentofascicolo.bpel.BPSPdfDocumentoFascicoloRequest;
//import it.equitalia.pdfdocumentofascicolo.bpel.BPSPdfDocumentoFascicoloResponse;
import it.equitalia.pdfdocumentostandard.bpel.PdfDocumentoStandardPortType;
import it.equitalia.pdfdocumentostandard.bpel.PdfDocumentoStandardPortTypeProxy; 
import it.equitalia.pdfdocumentostandard.bpel.xsd.GetPdfDocumentoRequestType;
import it.equitalia.pdfdocumentostandard.bpel.xsd.GetPdfDocumentoResponseType;
import it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType;
import it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType;
import it.equitalia.pdfdocumentostandardcallback.bpel.xsd.EsitoType;


/**
 *
 * modifica 20-05-2015: cambiato il wsdl del WS con cui si dialoga per il download del PDF; prima era quello che in questo progetto 
 * si chiamava BPSPdfDocumentoFascicolo.wsdl e si riferiva al namespace http://bpel.pdfdocumentofascicolo.equitalia.it, adesso
 * si chiama PdfDocumentoStandard.wsdl e si riferisce al namespace http://bpel.pdfdocumentostandard.equitalia.it)
 *
 */
public class PdfDocumentoBl {
	static Logger logger = Logger.getLogger(PdfDocumentoBl.class); 
	static Logger errorLogger = Log4jFactory.getErrorLogger();
	

	private static final String getPdfDocumento_OK = "OK";
	private static final String getPdfDocumento_KO01 = "KO01";   //Non è stata trovata nessuna cartella per il numero documento passato come parametro
	private static final String getPdfDocumento_KO99 = "KO99";	 //errore generico

	private static final String bpsPdfDocumentoResult_OK = "OK";
	private static final String bpsPdfDocumentoResult_KO99 = "KO99";		 //errore generico
	
	//inizio modifica 20-05-2015 cambio Wsdl
//	private static final String ESITO_PROCESSO_PDF_DOCUMENTO_OK = "OK";
	private static final String ESITO_PROCESSO_PDF_DOCUMENTO_STANDARD_PC = "PC";  //presa in carico
	private static final String ESITO_ELABORAZIONE_OK_PROCESSO_PDF_DOCUMENTO = "OK";
	private static final String ESITO_ELABORAZIONE_PROCESSO_PDF_DOCUMENTO_STANDARD_DI = "DI"; 
	//fine modifica 20-05-2015 cambio Wsdl

	public static GetPdfDocumentoWSResponse getPdfDocumento(GetPdfDocumentoWSRequest in)  {
		GetPdfDocumentoWSResponse response = new GetPdfDocumentoWSResponse();
		String esito = "";
		String esitoBPS = "";
		logger.info("Inizio " + printGetPdfDocumento(in) );
		try { 
			
			EntityItem documentoItem = getEntityDocumento(in.getFascicoloId(), in.getCallerId(), in.getNumeroDocumento() );
			
			if(documentoItem!=null ){
				
				logger.info(printGetPdfDocumento(in) + " documento esistente");	
				
				if (!pdfEsistente(documentoItem) && !pdfRichiesto(documentoItem) ) {	//se già ho il PDF restituisco un esito di presa in carico "PDF già esistente"

					logger.info(printGetPdfDocumento(in) + " Pdf non esistente e non richiesto");	
					
					aggiornaStatoPdf(documentoItem, in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_RICHIESTO, in.getFascicoloId(), in.getCallerId());

					//inizio modifica 20-05-2015 cambio Wsdl
					//Chiama il processo pdfDocumento 
					GetPdfDocumentoResponseType getPdfDocumentoResponseType = callProcessoPdfDocumento(in);
					esitoBPS = getPdfDocumentoResponseType.getEsito().getCodiceEsito();
					aggiornaCorrelationId(documentoItem, in.getNumeroDocumento(), getPdfDocumentoResponseType.getCorrelationId() , in.getFascicoloId(), in.getCallerId());
					//fine modifica 20-05-2015 cambio Wsdl
					esito=CartellaDAOImpl.STATO_DOCUMENTUM_RICHIESTO;
					
					
					//Se l’esito NON è OK, aggiorna il valore dello stato del pdf
					if (!esitoBPS.startsWith(ESITO_PROCESSO_PDF_DOCUMENTO_STANDARD_PC)) {  // modifica 20-05-2015 cambio Wsd
						aggiornaStatoPdf(documentoItem, in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, in.getFascicoloId(), in.getCallerId());
						esito=CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE;
					}
					
					 
				} else{

					logger.info(printGetPdfDocumento(in) + " Pdf esistente");	
					
					esito = CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE;
					response.setPdf(getPdfBytes(in, getTipoDocumento(documentoItem) ));
				}
				
			} else{ 
				errorLogger.error("Non è stato trovato nessun documento per il numero documento " + in.getNumeroDocumento() );
				esito = getPdfDocumento_KO01;
			} 
			
		} catch (Exception e) {
			errorLogger.error("Errore in getPdfDocumento",e); 
			esito = getPdfDocumento_KO99;
		}
		
		response.setEsito(esito); 
		logger.info("Fine " + printGetPdfDocumento(in) + "]  con esito:" + esito);		
		return response;
	}


	//inizio modifica 20-05-2015 cambio Wsdl
	private static void aggiornaCorrelationId(EntityItem documentoItem,
			String numeroDocumento, String correlationId, String fascicoloId,
			String callerId) throws Exception {
		
		int dataTypeId = -1;
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.CORRELATION_ID_PDF
					|| dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_CORRELATION_ID_PDF ) {
					dataTypeId = dataValue.getDataTypeId();
					break;
			} 
		}  
		
		
		if (dataTypeId==-1) {
			logger.error("Per l'entity con entityId=[" + documentoItem.getEntityId() + "] non ci sono data value corrispondenti al correlation ID ");
			throw new Exception("Errore nella formattazione dei dati nel DB");
		}
		
		CartellaDAO dao = DAOFactory.getCartellaDAO(true,DBFactory.ORIGINE_ORACLE);
 
		dao.updateValue(numeroDocumento, dataTypeId, correlationId, fascicoloId, callerId, 
				EntityBl.isCartella(documentoItem) 
				); 
	
	}
	//fine modifica 20-05-2015 cambio Wsdl


	private static String printGetPdfDocumento(GetPdfDocumentoWSRequest in) { 
		StringBuffer buf = new StringBuffer(); 

		buf.append("getPdfDocumento [");
		buf.append(" FascicoloId=" + in.getFascicoloId() );
		buf.append(", CallerId=" + in.getCallerId());
		buf.append(", NumeroDocumento=" + in.getNumeroDocumento());
		buf.append(", Cf=" + in.getCf()); 
		buf.append("]");
		return buf.toString();
	}


	private static String printBpsPdfDocumentoResult( BpsPdfDocumentoResultWSRequest in) {
		StringBuffer buf = new StringBuffer(); 

		buf.append("bpsPdfDocumentoResult [");
		buf.append(" FascicoloId=" + in.getFascicoloId() );
		buf.append(", CallerId=" + in.getCallerId());
		buf.append(", NumeroDocumento=" + in.getNumeroDocumento());
		buf.append(", Cf=" + in.getCf());  
		buf.append("]");
		
		return buf.toString(); 
	}

	private static EntityItem getEntityDocumento(String fascicoloId, String callerId, String numeroDoc) throws Exception { 
		EntityDAO entityDAO = new EntityDAO();
		return entityDAO.getEntityDocumento(fascicoloId, callerId, numeroDoc, 1);
	}

	private static boolean pdfEsistente(EntityItem documentoItem) throws Exception {
		
		boolean res = false;
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.STATO_PDF  || dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_STATO_PDF ) {
					if (  dataValue.getValue().equals(CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE)) {
						res = true;
					}
					break;
			} 
		}
		 
		return res;
	}

	private static boolean pdfRichiesto(EntityItem documentoItem) throws Exception {
		
		boolean res = false;
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.STATO_PDF  || dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_STATO_PDF ) {
					if (  dataValue.getValue().equals(CartellaDAOImpl.STATO_DOCUMENTUM_RICHIESTO)) {
						res = true;
					}
					break;
			} 
		}
		 
		return res;
	}
	
	private static boolean pdfNonDisponibile(EntityItem documentoItem) throws Exception {
		
		boolean res = false;
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.STATO_PDF  || dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_STATO_PDF ) {
					if (  dataValue.getValue().equals(CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE)) {
						res = true;
					}
					break;
			} 
		}
		 
		return res;
	}

 

	private static void aggiornaStatoPdf(EntityItem documentoItem, String numeroDocumento, String stato, String fascicoloId, String callerId) throws Exception {
		
		int dataTypeId = -1;
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.STATO_PDF  
					|| dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_STATO_PDF ) {
					dataTypeId = dataValue.getDataTypeId();
					break;
			} 
		}   
		
		if (dataTypeId==-1) {
			logger.error("Per l'entity[" + documentoItem + "] non ci sono data value corrispondenti allo stato del pdf ");
			throw new Exception("Errore nella formattazione dei dati nel DB");
		}
		
		CartellaDAO dao = DAOFactory.getCartellaDAO(true,DBFactory.ORIGINE_ORACLE);

		
		//inizio 2015-03-31 relate-doc-esattoriali 
		dao.updateValue(numeroDocumento, dataTypeId, stato, fascicoloId, callerId, 
				EntityBl.isCartella(documentoItem) 
				);
		//fine 2015-03-31 relate-doc-esattoriali 
	
	}

	//inizio modifica 20-05-2015 cambio Wsdl
	private static GetPdfDocumentoResponseType callProcessoPdfDocumento(GetPdfDocumentoWSRequest in) throws  Exception {  

		String BPS_PDF_DOCUMENTO_STANDARD_ENDPOINT = MessagesClass.getMessage("BPS_PDF_DOCUMENTO_STANDARD_ENDPOINT");
		String PDF_DOCUMENTO_STANDARD_MODALITA_ESTRAZIONE = MessagesClass.getMessage("PDF_DOCUMENTO_STANDARD.MODALITA_ESTRAZIONE");
		String GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT = MessagesClass.getMessage("GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT");
		
		
		logger.info(printGetPdfDocumento(in) + " BPS_PDF_DOCUMENTO_STANDARD_ENDPOINT[" + BPS_PDF_DOCUMENTO_STANDARD_ENDPOINT +"] " +
				" PDF_DOCUMENTO_STANDARD.MODALITA_ESTRAZIONE[" + PDF_DOCUMENTO_STANDARD_MODALITA_ESTRAZIONE + "]" +
		        " GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT[" + GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT + "]");	
		
		PdfDocumentoStandardPortTypeProxy proxy = new PdfDocumentoStandardPortTypeProxy();
		proxy.setEndpoint( BPS_PDF_DOCUMENTO_STANDARD_ENDPOINT );  
		GetPdfDocumentoRequestType part1 = new GetPdfDocumentoRequestType(
														in.getCf().trim() ,  
														in.getNumeroDocumento() , 
											           	false,  	//lo teniamo fisso a false per attuare sempre la modalità asincrona
											           	PDF_DOCUMENTO_STANDARD_MODALITA_ESTRAZIONE  );   
	 
		//aggiungo l'header per l'endpoint di callback
		PdfDocumentoStandardPortType portType = proxy.getPdfDocumentoStandardPortType(); 
		SOAPHeaderElement callBackTo = new SOAPHeaderElement("http://xsd.bpel.pdfdocumentostandard.equitalia.it","CallBackTo");
		SOAPHeaderElement address = new SOAPHeaderElement("http://www.w3.org/2005/08/addressing","Address", GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT);   
		callBackTo.addChild(address); 
		((Stub) portType).setHeader(callBackTo);
		
		GetPdfDocumentoResponseType response = portType.getPdfDocumento(part1);
		
		logger.info(printGetPdfDocumento(in) + " chiamato processo pdfDocumento con esitoBPS[" + response.getEsito() +"]");	
	
		return response;
	}
	//fine modifica 20-05-2015 cambio Wsdl

	@Deprecated
	public static BpsPdfDocumentoResultWSResponse bpsPdfDocumentoResult( BpsPdfDocumentoResultWSRequest in){
		BpsPdfDocumentoResultWSResponse result = new BpsPdfDocumentoResultWSResponse();
		logger.info("Inizio " + printBpsPdfDocumentoResult(in) );		
		try {

			EntityItem documentoItem = getEntityDocumento( in.getFascicoloId(), in.getCallerId(), in.getNumeroDocumento() );

			logger.info(  printBpsPdfDocumentoResult(in) +" esitoElaborazione[" + in.getEsitoElaborazione() +"]");	
			
			//Riceve in input l’esito dell’elaborazione e, se OK, il link dove scaricare il documento;
			if (in.getEsitoElaborazione().equals(ESITO_ELABORAZIONE_OK_PROCESSO_PDF_DOCUMENTO)) {
				
				File file = getFile(in);  
 
				//Salva il pdf in documentum
				try { 

					salvaDocumentum(	in.getFascicoloId(), 
										in.getCallerId(), 
										in.getCf().trim(), //Bug3656 
										in.getNumeroDocumento(), 
										getTipoDocumento(documentoItem),
										file); 

					logger.info(  printBpsPdfDocumentoResult(in) + " salvato file in documentum con tipoDocumento[" + getTipoDocumento(documentoItem) + "]" );	
					
					aggiornaStatoPdf(documentoItem, in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE, in.getFascicoloId(), in.getCallerId());
				} catch (Exception e) {
					
					aggiornaStatoPdf(documentoItem, in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, in.getFascicoloId(), in.getCallerId());
					throw e;
				}

				 

			} else{
	 
				aggiornaStatoPdf(documentoItem, in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, in.getFascicoloId(), in.getCallerId());
			}
			

			result.setEsito(bpsPdfDocumentoResult_OK);  
		} catch (Exception e) {
			logger.error("", e);
			result.setEsito(bpsPdfDocumentoResult_KO99);  
		}
		
		logger.info("Fine " + printBpsPdfDocumentoResult(in) +" con esito:" + result.getEsito());		

		return result; 
	}
	
//2015-03-31 relate-doc-esattoriali 
//	public static boolean isCartella(EntityItem documentoItem) throws   Exception{
//		return getTipoDocumento(documentoItem).equals(  MessagesClass.getMessage( "DOCUMENTUM.TIPO_PDF_CARTELLA" ) );
//	}

	private static String getTipoDocumento(EntityItem documentoItem) throws Exception {
		String tipoDoc = "";
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.N_CARTELLA  ){
				tipoDoc = MessagesClass.getMessage( "DOCUMENTUM.TIPO_PDF_CARTELLA" );
				break;
			} else if ( dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_TIPO_MODELLO  ) {
				tipoDoc = dataValue.getValue();
				break;
			} 
		}   
		
		if (tipoDoc.equals("")) {
			logger.error("Per l'entity[" + documentoItem + "] non ci sono data value corrispondenti allo stato del pdf ");
			throw new Exception("Errore nella formattazione dei dati nel DB");
		}
		
		return tipoDoc;
	}
	

	private static String getNumeroDocumento(EntityItem documentoItem) throws Exception {
		String result = "";
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.N_CARTELLA 
						|| dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO){
				result = dataValue.getValue();
				break;
			}  
		}   
		
		if (result.equals("")) {
			logger.error("Per l'entity[" + documentoItem + "] non ci sono data value corrispondenti al numero documento ");
			throw new Exception("Errore nella formattazione dei dati nel DB");
		}
		
		return result;
	}

	@Deprecated
	private static File getFile(BpsPdfDocumentoResultWSRequest in) throws  Exception {
		File result;

		result = File.createTempFile("DocumentoPdf", ""); 
 
		byte[] bytes =in.getPdf();
		  
		UtilsClass.writeBytes(result, bytes);  
		
		return result;
	}
	

	private static byte[] getPdfBytes(GetPdfDocumentoWSRequest in, String tipoDocumento) throws Exception { 
		DocumentumHandler  dh  = new DocumentumHandler(
				MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  ,
				MessagesClass.getMessage("DOCUMENTUM.PASSWORD").trim()	,	   
				MessagesClass.getMessage("DOCUMENTUM.REPOSITORY").trim() );		
		
		File outputFile = File.createTempFile("getPdfDocumento_temp", "");
		
		dh.getFileFromDocumentum( MessagesClass.getMessage("DOCUMENTUM.CLASSE_DOCUMENTALE") ,
				in.getCf().trim(),  //Bug3656 
				in.getCallerId(), 
				in.getFascicoloId(), 
				in.getNumeroDocumento(), 
				tipoDocumento, 
				outputFile);
		byte[] result = Convertions.convertIntoBytes(outputFile);
		outputFile.delete();
		return result;
	}


	private static void salvaDocumentum( 
										String fascicoloId ,
										String callerId,
										String codiceFiscale, 
										String numeroDocumento , 
										String tipoDocumento,
										File file ) throws Exception {


		DocumentumHandler  dh  = new DocumentumHandler(
				MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  ,
				MessagesClass.getMessage("DOCUMENTUM.PASSWORD").trim()	,	   
				MessagesClass.getMessage("DOCUMENTUM.REPOSITORY").trim() );		 
  
		
		DocumentumFileBean dfb = new DocumentumFileBean();


		dfb.setFileName(        numeroDocumento + ".pdf");
		dfb.setFilePath(        file.getAbsolutePath() ); 
		
		dfb.setClasseDcmt( MessagesClass.getMessage("DOCUMENTUM.CLASSE_DOCUMENTALE") );
		
		dfb.setContentType(ContentType.PDF);

		Map<String,Object> mapFile = new HashMap<String, Object>();
		mapFile.put("fsc_codice_fiscale",        codiceFiscale);
		mapFile.put("fsc_id_chiamante",          callerId);
		mapFile.put("fsc_id_fascicolo",          fascicoloId );
		mapFile.put("fsc_num_documento",         numeroDocumento);
		mapFile.put("fsc_tipo_documento",        tipoDocumento ); 		              
		mapFile.put("acl_domain",                MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  );  	 
		dfb.setAttributiFile( mapFile);
		
		dh.putFileInDocumentum(dfb); 
		
	}


	//inizio modifica 20-05-2015 cambio Wsdl
	public static CallBackPdfDocumentoResponseType callBackPdfDocumento(CallBackPdfDocumentoRequestType part1) {
 
		logger.info("Inizio " + printCallBackPdfDocumento(part1) );	
		  
		CallBackPdfDocumentoResponseType result = new CallBackPdfDocumentoResponseType();
		
		try {

			Fascicolo fascicolo = CorrelationIdBl.getFascicoloDocumentoCallBackPdfDocumento(part1.getCorrelationId()); 

			if (fascicolo!=null) {
				EntityItem documentoItem = fascicolo.getCartelle(0);
				String numeroDocumento = getNumeroDocumento(documentoItem);
				
				logger.info( printCallBackPdfDocumento(part1) + " item documento trovato " );	
				
				//Riceve in input l’esito dell’elaborazione e, se OK, il link dove scaricare il documento;
				if (part1.getEsito().getCodiceEsito().equals(ESITO_ELABORAZIONE_PROCESSO_PDF_DOCUMENTO_STANDARD_DI)) {
					
					File file = getFile(part1);  
	 
					//Salva il pdf in documentum
					try { 

						salvaDocumentum(	fascicolo.getFascicoloId(), 
											fascicolo.getCallerId(), 
											fascicolo.getAnagrafica().getCodiceFiscale().trim(),
											numeroDocumento, 
											getTipoDocumento(documentoItem),
											file); 

						logger.info(  printCallBackPdfDocumento(part1) + " salvato file in documentum con tipoDocumento[" + getTipoDocumento(documentoItem) + "]" );	
						
						aggiornaStatoPdf(documentoItem, numeroDocumento, CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE, fascicolo.getFascicoloId(), fascicolo.getCallerId() );
					} catch (Exception e) { 
						aggiornaStatoPdf(documentoItem, numeroDocumento, CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, fascicolo.getFascicoloId(), fascicolo.getCallerId());
						throw e;
					}

					 

				} else{ 
					aggiornaStatoPdf(documentoItem, numeroDocumento, CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, fascicolo.getFascicoloId(), fascicolo.getCallerId());
				}

			
			} else{	 //ci si trova in questo caso quando il correlation id con cui si sta lavorando è stato sovrascritto da una chiamata a getPdfDocumento più recente

				logger.info( printCallBackPdfDocumento(part1) + " item documento NON trovato " );	
			}

			EsitoType esitoType =  new EsitoType(); 
			esitoType.setCodiceEsito(MessagesClass.getMessage("CALLBACK_PDF_DOCUMENTO.CODICE_ESITO.OK"));
			esitoType.setDescrizioneEsito(MessagesClass.getMessage("CALLBACK_PDF_DOCUMENTO.DESCRIZIONE_ESITO.OK"));
			result.setEsito(esitoType);
			
		} catch (Exception e) {
			logger.error("", e);

			EsitoType esitoType =  new EsitoType(); 
			esitoType.setCodiceEsito( getCallBackPdfDocumentoCodiceEsitoKoGenerico() );
			esitoType.setDescrizioneEsito( getCallBackPdfDocumentoDescrizioneEsitoKoGenerico() );
			result.setEsito(esitoType); 
		}
		
		logger.info("Fine " + printCallBackPdfDocumento(part1) +" con esito:" + result.getEsito().getCodiceEsito() );		

		return result; 
	
		 
	}

	private static String getCallBackPdfDocumentoDescrizioneEsitoKoGenerico() {
		try {
			return MessagesClass.getMessage("CALLBACK_PDF_DOCUMENTO.DESCRIZIONE_ESITO.KO_GENERICO")  ;
		} catch (Exception e) { 
			return "Si è  verificato un errore generico";
		}
	}


	private static String getCallBackPdfDocumentoCodiceEsitoKoGenerico() { 
		try {
			return MessagesClass.getMessage("CALLBACK_PDF_DOCUMENTO.CODICE_ESITO.KO_GENERICO");
		} catch (Exception e) { 
			return "KO99";
		}
	}


	private static File getFile(CallBackPdfDocumentoRequestType part1) throws Exception {
		File result;

		result = File.createTempFile("DocumentoPdf", ""); 
 
		byte[] bytes = part1.getMtomAttachment().getFile().get_value();
		  
		UtilsClass.writeBytes(result, bytes);  
		
		return result;
	}


	private static String printCallBackPdfDocumento(
			CallBackPdfDocumentoRequestType part1) {
		StringBuffer buf = new StringBuffer(); 

		buf.append("callBackPdfDocumento [");
		buf.append(" CorrelationId=" + part1.getCorrelationId() );
		buf.append(", CodiceEsito=" + part1.getEsito().getCodiceEsito());
		buf.append(", DescrizioneEsito=" + part1.getEsito().getDescrizioneEsito());  
		buf.append("]");
		
		return buf.toString(); 
	}
	//fine modifica 20-05-2015 cambio Wsdl

 
}
