package it.equitalia.gestorefascicolows.bl;

 

import java.io.File;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.client.Stub;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.log4j.Logger; 
 

import it.equitalia.gestorefascicolows.dao.CartellaDAO;
import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.impl.CartellaDAOImpl;
import it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest;
import it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse;
import it.equitalia.gestorefascicolows.dati.DataValue;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.GetRelateWSRequest;
import it.equitalia.gestorefascicolows.dati.GetRelateWSResponse; 
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Convertions;
import it.equitalia.gestorefascicolows.utils.DateUtil;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumFileBean;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumHandler;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumHandler.ContentType;
import it.equitalia.gestorefascicolows.utils.spazio.SpazioHandler;   
import it.equitalia.relatedocumentostandard.bpel.RelateDocumentoStandardPortType;
import it.equitalia.relatedocumentostandard.bpel.RelateDocumentoStandardPortTypeProxy;
import it.equitalia.relatedocumentostandard.bpel.xsd.GetRelateDocumentoRequestType;
import it.equitalia.relatedocumentostandard.bpel.xsd.GetRelateDocumentoResponseType;
import it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType;
import it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType;
import it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType;

public class RelateBl {
	static Logger logger = Logger.getLogger(RelateBl.class);
	
	private static final String getRelate_KO99 = "KO99";

	private static final String bpsRelateResult_OK = "OK";
	private static final String bpsRelateResult_KO99 = "KO99";
	
	private static final String ESITO_ELABORAZIONE_OK_PROCESSO_RELATE = "OK";  
	
	//inizio 22-05-2015 RelateDocumentoStandard
	private static List<String> listaEsitiCallBackRelateDocumentoConAvvenutaProduzioneDiFile = new ArrayList<String>();
	static{
		try {
			listaEsitiCallBackRelateDocumentoConAvvenutaProduzioneDiFile = MessagesClass.getMessagesListByPrefixKey("CALLBACK_RELATE_DOCUMENTO.ESITO_PRODUZIONE_FILE_AVVENNUTA");
		} catch (Exception e) { 
			logger.error("Errore in fase di inizializzazione della lista di proprietà con prefisso CALLBACK_RELATE_DOCUMENTO.ESITO_PRODUZIONE_FILE_AVVENNUTA", e);
		}
	} 
	//fine 22-05-2015 RelateDocumentoStandard

	
	
	// 22-05-2015 RelateDocumentoStandard
	
	private static final String ESITO_PROCESSO_RELATE_PC = "PC";      // 22-05-2015 RelateDocumentoStandard
	

	private static final String RICHIESTA_DOWNLOAD_SI= "S";	//viene richiesto il download delle relate
	private static final String RICHIESTA_DOWNLOAD_NO= "N";	//viene richiesto l'aggiornamento del file delle relate
	
	

	public static GetRelateWSResponse getRelate(GetRelateWSRequest in) { 

		logger.info("Inizio " + printGetRelate(in) +" download[" + in.getDownload() + "]" );
		
		GetRelateWSResponse response = new GetRelateWSResponse();
		
		String esitoBPS = "";
		String esito = "";

		EntityItem documentoItem = null;
		try {

			documentoItem = getEntityDocumento( in.getFascicoloId(), in.getCallerId(), in.getNumeroDocumento() );

			logger.info(  printGetRelate(in) + " stato relate[" +  getStatoRelate(documentoItem) + "]"); 
			
			if (in.getDownload().equals(RICHIESTA_DOWNLOAD_SI)) {

				//  se  lo stato del file di relate è disponibile, effettua il download da documentum
				if (equalsStatoDocumentum( documentoItem, CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE ) ) {

					esito = CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE; 
					response.setPdf(getPdfBytes(in));

					logger.info(  printGetRelate(in) + " scaricato il file delle relate"); 
					
				} else{
					esito = getStatoRelate(documentoItem); 
				}
				
			} else{

				//  se è lo stato del file di relate non è "Richiesto", effettua la chiamata al processo relate
				if (!equalsStatoDocumentum( documentoItem, CartellaDAOImpl.STATO_DOCUMENTUM_RICHIESTO  ) ){
					
					aggiornaStatoPdf(in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_RICHIESTO, in.getFascicoloId(), in.getCallerId(),
							documentoItem //2015-03-31 relate-doc-esattoriali 
							);

					//inizio 22-05-2015 RelateDocumentoStandard 
//					Chiama il processo relate da cui riceve un esito della presa in carico;
					GetRelateDocumentoResponseType getRelateDocumentoResponseType = callProcessoRelate(in);
					aggiornaCorrelationId(documentoItem, in.getNumeroDocumento(), getRelateDocumentoResponseType.getCorrelationId(), in.getFascicoloId(), in.getCallerId());
					esitoBPS = getRelateDocumentoResponseType.getEsito().getCodiceEsito();
					//fine 22-05-2015 RelateDocumentoStandard 
					
//					Se l’esito è non è OK, aggiorna il valore dello stato delle relate;
					if (esitoBPS.equals(ESITO_PROCESSO_RELATE_PC)) {
						esito = CartellaDAOImpl.STATO_DOCUMENTUM_RICHIESTO;
					} else{
						aggiornaStatoPdf(in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, in.getFascicoloId(), in.getCallerId(),
								documentoItem //2015-03-31 relate-doc-esattoriali 
								);
						esito = CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE;
					}
					
				} else{
					logger.info(  printGetRelate(in) + " documento in fase di richiesta"); 
					esito = CartellaDAOImpl.STATO_DOCUMENTUM_RICHIESTO; 
				}
			}
			response.setDataAggiornamento(getDataRelate(documentoItem));
					 
		} catch (SQLException e) {
			logger.error("",e);  
			esito = getRelate_KO99; 
		} catch (Exception e) { 
			if (documentoItem!=null) { 
				try {
					aggiornaStatoPdf(in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, in.getFascicoloId(), in.getCallerId(), documentoItem  
							);
				} catch (Exception e1) { 
					logger.error("",e); 
				}
			} 
			logger.error("",e);  
			esito = getRelate_KO99; 
		}
		  
		response.setEsito(esito); 

		logger.info("Fine " + printGetRelate(in) );
		
		return response ;
	}
	
	
	private static boolean equalsStatoDocumentum(EntityItem documentoItem, String statoDocumentum) {  
		return getStatoRelate(documentoItem).equals(statoDocumentum);
		
	}


	//inizio modifica 2015-03-31 relate-doc-esattoriali 
	private static String getStatoRelate(EntityItem documentoItem )  {  
		String res = null;
		int statoRelateDataTypeId;
		
		if (EntityBl.isCartella(documentoItem)) { 
			statoRelateDataTypeId = CartellaDAOImpl.STATO_RELATE ;
		} else{ 		//documento esattoriale
			statoRelateDataTypeId = CartellaDAOImpl.DOCUMENTO_ESATTORIALE_STATO_RELATE;
		}
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == statoRelateDataTypeId ) { 
				res = dataValue.getValue(); 
				break;
			} 
		}
		 
		return res;
	}
	//fine modifica 2015-03-31 relate-doc-esattoriali 
 

	//inizio modifica 2015-03-31 relate-doc-esattoriali 
	private static String getDataRelate(EntityItem documentoItem ) {  
		String res = null;
		
		int dataAggiornamentoRelateelateDataTypeId;
		
		if (EntityBl.isCartella(documentoItem)) { 
			dataAggiornamentoRelateelateDataTypeId = CartellaDAOImpl.DATA_AGGIORNAMENTO_RELATE ;
		} else{ 		//documento esattoriale
			dataAggiornamentoRelateelateDataTypeId = CartellaDAOImpl.DOCUMENTO_ESATTORIALE_DATA_AGGIORNAMENTO_RELATE;
		}
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == dataAggiornamentoRelateelateDataTypeId ) { 
				res = dataValue.getValue(); 
				break;
			} 
		}
		 
		return res;
	}
	//fine modifica 2015-03-31 relate-doc-esattoriali 


	private static String printGetRelate(GetRelateWSRequest in) {

		StringBuffer buf = new StringBuffer(); 

		buf.append("getRelate [");
		buf.append(" FascicoloId=" + in.getFascicoloId() );
		buf.append(", CallerId=" + in.getCallerId());
		buf.append(", NumeroDocumento=" + in.getNumeroDocumento());
		buf.append(", Cf=" + in.getCf()); 
		buf.append("]");
		return buf.toString();
	}
	

	private static String printBpsRelateResult(BpsRelateResultWSRequest in) {

		StringBuffer buf = new StringBuffer(); 

		buf.append("BpsRelateResult [");
		buf.append(" FascicoloId=" + in.getFascicoloId() );
		buf.append(", CallerId=" + in.getCallerId());
		buf.append(", NumeroDocumento=" + in.getNumeroDocumento());
		buf.append(", Cf=" + in.getCf()); 
		buf.append("]");
		return buf.toString();
	}


	@Deprecated
	public static BpsRelateResultWSResponse bpsRelateResult(BpsRelateResultWSRequest in) {
		logger.info("Inizio " + printBpsRelateResult(in) + " EsitoElaborazione[" + in.getEsitoElaborazione()+ "]  SpazioInternalNumber[" + in.getSpazioInternalNumber() + "]");
		BpsRelateResultWSResponse response = new BpsRelateResultWSResponse();
		

		EntityItem documentoItem; //2015-03-31 relate-doc-esattoriali  
		try { 
			documentoItem = getEntityDocumento( in.getFascicoloId(), in.getCallerId(), in.getNumeroDocumento() ); //2015-03-31 relate-doc-esattoriali  
			
			//Riceve in input l’esito dell’elaborazione e, se OK, l’internal number di Spazio;
			if (in.getEsitoElaborazione().trim().equals(ESITO_ELABORAZIONE_OK_PROCESSO_RELATE)) {
 
				try {

					//Scarica lo zip delle relate da Spazio;
					File file = getFileFromSpazio( in.getSpazioInternalNumber().trim() );
					
					logger.info(  printBpsRelateResult(in) + " caricato file[" + file.getAbsolutePath() + "] da Spazio" );
					
					//Cancella l'eventuale file salvato in precedenza e salva il nuovo in documentum
					replaceInDocumentum(
							in.getFascicoloId().trim(), 
							in.getCallerId().trim(), 
							in.getCf().trim(), 
							in.getNumeroDocumento().trim(), 
							file);

					
					logger.info(  printBpsRelateResult(in) + " effettuato il replace del file in Documentum" );
					
					//Aggiorna lo stato delle relate  nel db del fascicolo.
					aggiornaStatoPdf(in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE, in.getFascicoloId(), in.getCallerId(),
							documentoItem //2015-03-31 relate-doc-esattoriali 
							);
					aggiornaStatoDataAggiornamentoRelate(in.getNumeroDocumento(), in.getFascicoloId(), in.getCallerId(),
							documentoItem //2015-03-31 relate-doc-esattoriali 
							);
					response.setEsito(bpsRelateResult_OK);
				
				} catch (Exception e) {
					logger.error("Errore in bpsRelateResult ",e);
					aggiornaStatoPdf(in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, in.getFascicoloId(), in.getCallerId(),
							documentoItem //2015-03-31 relate-doc-esattoriali 
							);
					response.setEsito(bpsRelateResult_KO99);
				}
				
				
			} else{ 
				aggiornaStatoPdf(in.getNumeroDocumento(), CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, in.getFascicoloId(), in.getCallerId(),
						documentoItem //2015-03-31 relate-doc-esattoriali 
						);
				response.setEsito(bpsRelateResult_OK); 
			}
			 
		} catch (Exception e) {
			logger.error("", e);
			response.setEsito(bpsRelateResult_KO99); 
		}

		logger.info("Fine " + printBpsRelateResult(in) );
		
		return response;
	}


	private static File getFileFromSpazio(String spazioInternalNumber) throws Exception {

		File temp = File.createTempFile("Spazio_"+spazioInternalNumber, "");
  
		SpazioHandler spazioHandler = getSpazioHandler();
		
		FileOutputStream output = new FileOutputStream(temp); 
			
		spazioHandler.getFile(spazioInternalNumber,  output );
			 
		return temp;
	}
	
	
	@Deprecated
	/**
	 * le proprietà con prefisso SPAZIO. sono state eliminate
	 */
	private static SpazioHandler getSpazioHandler() throws Exception {
		
		if (MessagesClass.getMessage("SPAZIO.CIN.KIND")!= null &&  MessagesClass.getMessage("SPAZIO.CIN.KIND").trim().equalsIgnoreCase("JNDI") ) {
			return new SpazioHandler(
					MessagesClass.getMessage("SPAZIO.CIN.QUEUE_MANAGER").trim(),
					MessagesClass.getMessage("SPAZIO.CIN.QUEUE_NAME").trim(), false );
		} else{
			return new SpazioHandler(
						MessagesClass.getMessage("SPAZIO.CIN.DIRECT.HOST").trim(), //	String hostSpazio,
						Integer.parseInt( MessagesClass.getMessage("SPAZIO.CIN.DIRECT.PORT_RMI").trim() ), //	int portRMI,
						MessagesClass.getMessage("SPAZIO.CIN.QUEUE_MANAGER").trim(), //	String queueManager,
						MessagesClass.getMessage("SPAZIO.CIN.QUEUE_NAME").trim(),  //	String queueName 
														false
														);
			} 
	}
	//inizio modifica 2015-03-31 relate-doc-esattoriali 
	private static void aggiornaStatoPdf(String numeroDocumento, String stato, String fascicoloId, String CallerId, 
							EntityItem documentoItem  
							) throws Exception { 
		CartellaDAO dao = DAOFactory.getCartellaDAO(true,DBFactory.ORIGINE_ORACLE);

		if (EntityBl.isCartella(documentoItem)) { 
			dao.updateValue(numeroDocumento, CartellaDAOImpl.STATO_RELATE, stato, fascicoloId, CallerId, EntityBl.isCartella(documentoItem));
		} else{ //è un documento esattoriale
			dao.updateValue(numeroDocumento, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_STATO_RELATE, stato, fascicoloId, CallerId, EntityBl.isCartella(documentoItem)); 
		}
	
	}
	//fine modifica 2015-03-31 relate-doc-esattoriali 
	

	//inizio modifica 2015-03-31 relate-doc-esattoriali 
	private static void aggiornaStatoDataAggiornamentoRelate(String numeroDocumento, String fascicoloId, String CallerId, 
			EntityItem documentoItem  ) throws Exception {
		CartellaDAO dao = DAOFactory.getCartellaDAO(true,DBFactory.ORIGINE_ORACLE);

		if (EntityBl.isCartella(documentoItem)) {
			dao.updateValue(numeroDocumento, CartellaDAOImpl.DATA_AGGIORNAMENTO_RELATE, DateUtil.getActualDateValue(), fascicoloId, CallerId, 
											true );			
		} else {
			dao.updateValue(numeroDocumento, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_DATA_AGGIORNAMENTO_RELATE, DateUtil.getActualDateValue(), fascicoloId, CallerId, 
											false ); //BUG3926 mancato aggiornamento della data relate per i doc esattoriali
		}
	}
	//fine modifica 2015-03-31 relate-doc-esattoriali 

	private static void replaceInDocumentum( 
										String fascicoloId ,
										String callerId,
										String codiceFiscale, 
										String numeroDocumento , 
										File file ) throws Exception {

		DocumentumHandler  dh  =  new DocumentumHandler(
				MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  ,
				MessagesClass.getMessage("DOCUMENTUM.PASSWORD").trim()	,	   
				MessagesClass.getMessage("DOCUMENTUM.REPOSITORY").trim() );	 	
		
		dh.deleteObjectsFromFsc_document(codiceFiscale, callerId, fascicoloId, numeroDocumento, MessagesClass.getMessage("DOCUMENTUM.TIPO_RELATE"));
		
		
		
		DocumentumFileBean dfb = new DocumentumFileBean();
		  
		dfb.setFileName(        "relate_" + numeroDocumento + ".zip");
		dfb.setFilePath(        file.getAbsolutePath() ); 
		
		dfb.setClasseDcmt( MessagesClass.getMessage("DOCUMENTUM.CLASSE_DOCUMENTALE") ); 
		dfb.setContentType(ContentType.ZIP); 
		Map<String,Object> mapFile = new HashMap<String, Object>();
		mapFile.put("fsc_codice_fiscale",        codiceFiscale);
		mapFile.put("fsc_id_chiamante",          callerId);
		mapFile.put("fsc_id_fascicolo",          fascicoloId );
		mapFile.put("fsc_num_documento",         numeroDocumento);
		mapFile.put("fsc_tipo_documento",        MessagesClass.getMessage("DOCUMENTUM.TIPO_RELATE"));                
		mapFile.put("acl_domain",                MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  );  	 
		dfb.setAttributiFile(   mapFile); 
		dh.putFileInDocumentum(dfb);
		
		
	}
	
	
	private static byte[] getPdfBytes(GetRelateWSRequest in) throws Exception {
		DocumentumHandler  dh  = new DocumentumHandler(
				MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  ,
				MessagesClass.getMessage("DOCUMENTUM.PASSWORD").trim()	,	   
				MessagesClass.getMessage("DOCUMENTUM.REPOSITORY").trim() );		
		
		File outputFile = File.createTempFile("getRelate_temp", "");
		
		dh.getFileFromDocumentum( MessagesClass.getMessage("DOCUMENTUM.CLASSE_DOCUMENTALE") ,
				in.getCf().trim(), //Bug3656 
				in.getCallerId(), 
				in.getFascicoloId(), 
				in.getNumeroDocumento(), 
				MessagesClass.getMessage("DOCUMENTUM.TIPO_RELATE"), 
				outputFile);
		
		return Convertions.convertIntoBytes(outputFile);
	}
	
	//inizio 22-05-2015 RelateDocumentoStandard
	private static GetRelateDocumentoResponseType callProcessoRelate(GetRelateWSRequest in) throws  Exception {
		GetRelateDocumentoResponseType response;
		
		String BPS_RELATE_STANDARD_ENDPOINT = MessagesClass.getMessage("BPS_RELATE_STANDARD_ENDPOINT"); 
		String GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT = MessagesClass.getMessage("GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT");
		
		logger.info(printGetRelate(in)  + " BPS_RELATE_STANDARD_ENDPOINT[" + BPS_RELATE_STANDARD_ENDPOINT +"] " + 
		        " GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT[" + GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT + "]");	
		
		
		RelateDocumentoStandardPortTypeProxy proxy = new RelateDocumentoStandardPortTypeProxy();
		proxy.setEndpoint(BPS_RELATE_STANDARD_ENDPOINT);
		
		GetRelateDocumentoRequestType part1 = new GetRelateDocumentoRequestType(
													in.getCf().trim(),  
													in.getNumeroDocumento().trim()
													);

		//aggiungo l'header per l'endpoint di callback 
		RelateDocumentoStandardPortType portType = proxy.getRelateDocumentoStandardPortType();
		SOAPHeaderElement callBackTo = new SOAPHeaderElement("http://xsd.bpel.relatedocumentostandard.equitalia.it","CallBackTo");
		SOAPHeaderElement address = new SOAPHeaderElement("http://www.w3.org/2005/08/addressing","Address",  GESTORE_FASCICOLO_WS_CALLBACK_ENDPOINT);   
		callBackTo.addChild(address); 
		((Stub) portType).setHeader(callBackTo);
		
		response = portType.getRelateDocumentoStandard(part1);

		logger.info(  printGetRelate(in) + " chiamato processo relate con esitoBPS[" + response.getEsito().getCodiceEsito() + "] "); 
	 
		return response;
	}
	
	

	private static void aggiornaCorrelationId(EntityItem documentoItem,
			String numeroDocumento, String correlationId, String fascicoloId,
			String callerId) throws Exception {
		
		int dataTypeId = -1;
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.CORRELATION_ID_RELATE
					|| dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_CORRELATION_ID_RELATE ) {
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
	
	 
	public static CallBackRelateDocumentoResponseType callBackRelateDocumento( CallBackRelateDocumentoRequestType in) {

		logger.info("Inizio " + printCallBackRelateDocumento(in) + " EsitoElaborazione[" + 
				in.getCodiceEsito().getCodiceEsito() + " - " + in.getCodiceEsito().getDescrizioneEsito() + "] " +
						" SpazioInternalNumber[" + in.getFileReference().getInternalNumber() + "]" +
						" Queue[" + in.getFileReference().getQueue() + "]" +
						" QueueManager[" + in.getFileReference().getQueueManager() + "]" +
						" NomeFile[" + in.getFileReference().getNomeFile() + "]");
		
		CallBackRelateDocumentoResponseType response = new CallBackRelateDocumentoResponseType();
		

		EntityItem documentoItem = null; 
		Fascicolo fascicolo = null;
		String numeroDocumento = null;
		try { 
			

			fascicolo = CorrelationIdBl.getFascicoloDocumentoCallBackRelateDocumento(in.getCorrelationId()); 

			if (fascicolo!=null) {
				documentoItem = fascicolo.getCartelle(0); 
				numeroDocumento = getNumeroDocumento(documentoItem);

				logger.info( printCallBackRelateDocumento(in) + " trovato fascicolo id="+ fascicolo.getFascicoloId() + " callerId=" + fascicolo.getCallerId()) ;
				if (codiceEsitoValidoPerDownload(in)) {
					logger.info( printCallBackRelateDocumento(in) + " codice esito[" + in.getCodiceEsito().getCodiceEsito() + "] valido per il download");
	 
					try {

						//Scarica lo zip delle relate da Spazio;
						File file = getFileFromSpazio(in);
						
						logger.info(  printCallBackRelateDocumento(in) + " caricato file[" + file.getAbsolutePath() + "] da Spazio" );
						
						//Cancella l'eventuale file salvato in precedenza e salva il nuovo in documentum
						replaceInDocumentum(
								fascicolo.getFascicoloId(), 
								fascicolo.getCallerId(), 
								fascicolo.getAnagrafica().getCodiceFiscale().trim(), 
								numeroDocumento, 
								file);

						
						logger.info(  printCallBackRelateDocumento(in) + " effettuato il replace del file in Documentum" );
						
						//Aggiorna lo stato delle relate  nel db del fascicolo.
						aggiornaStatoPdf(numeroDocumento, CartellaDAOImpl.STATO_DOCUMENTUM_DISPONIBILE, fascicolo.getFascicoloId(), fascicolo.getCallerId(),
								documentoItem //2015-03-31 relate-doc-esattoriali 
								);
						aggiornaStatoDataAggiornamentoRelate(numeroDocumento, fascicolo.getFascicoloId(), fascicolo.getCallerId(),
								documentoItem //2015-03-31 relate-doc-esattoriali 
								);
						response = getCallBackRelateDocumentoResponseTypeOk();
					
					} catch (Exception e) {
						logger.error("Errore in bpsRelateResult ",e);
						aggiornaStatoPdf(numeroDocumento, CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, fascicolo.getFascicoloId(), fascicolo.getCallerId(),
								documentoItem //2015-03-31 relate-doc-esattoriali 
								);
						response = getCallBackRelateDocumentoResponseTypeKoGenerico();
					}
					
					
				} else{ 
					logger.info( printCallBackRelateDocumento(in) + " codice esito[" + in.getCodiceEsito().getCodiceEsito() + "] NON valido per il download");
					
					aggiornaStatoPdf(numeroDocumento, CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, fascicolo.getFascicoloId(), fascicolo.getCallerId(),
							documentoItem //2015-03-31 relate-doc-esattoriali 
							);
					response = getCallBackRelateDocumentoResponseTypeOk();
				}
				
			} else { //ci si trova in questo caso quando il correlation id con cui si sta lavorando è stato sovrascritto da una chiamata a getRelate più recente

				logger.info( printCallBackRelateDocumento(in) + " item documento NON trovato " );	
				
			}
			
			 
		} catch (SQLException e) {
			logger.error("", e);
			response = getCallBackRelateDocumentoResponseTypeKoGenerico();
		} catch (Exception e) {
			if (documentoItem!=null) {
				try {
					aggiornaStatoPdf(numeroDocumento, CartellaDAOImpl.STATO_DOCUMENTUM_NON_DISPONIBILE, fascicolo.getFascicoloId(), fascicolo.getCallerId(),documentoItem  );
				} catch (Exception e1) {
					logger.error("", e);
				}				
			}
			logger.error("", e);
			response = getCallBackRelateDocumentoResponseTypeKoGenerico();
		}

		logger.info("Fine " + printCallBackRelateDocumento(in) + " CodiceEsito=[" + response.getEsito().getCodiceEsito() + "] DescrizioneEsito=[" + response.getEsito().getDescrizioneEsito() + "]");
		
		return response;  
	}
	
	

	private static boolean codiceEsitoValidoPerDownload(CallBackRelateDocumentoRequestType in) {
		return listaEsitiCallBackRelateDocumentoConAvvenutaProduzioneDiFile.contains(in.getCodiceEsito().getCodiceEsito());
	}


	private static CallBackRelateDocumentoResponseType getCallBackRelateDocumentoResponseTypeKoGenerico() {

		CallBackRelateDocumentoResponseType res  = new CallBackRelateDocumentoResponseType();
		it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType esito = new it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType();
		
		try {
			esito.setCodiceEsito(MessagesClass.getMessage("CALLBACK_RELATE_DOCUMENTO.CODICE_ESITO.KO_GENERICO").trim());
			esito.setDescrizioneEsito(MessagesClass.getMessage("CALLBACK_RELATE_DOCUMENTO.DESCRIZIONE_ESITO.KO_GENERICO").trim());
		}  catch ( Exception e) { 
			esito.setCodiceEsito("KO99");
			esito.setDescrizioneEsito("Si è  verificato un errore generico"); 
		}
		
		res.setEsito(esito);
		 
		return res; 
	}


	private static CallBackRelateDocumentoResponseType getCallBackRelateDocumentoResponseTypeOk() throws FaultType, NumberFormatException {
		CallBackRelateDocumentoResponseType res  = new CallBackRelateDocumentoResponseType();
		it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType esito = new it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType();
		
		esito.setCodiceEsito(MessagesClass.getMessage("CALLBACK_RELATE_DOCUMENTO.CODICE_ESITO.OK").trim());
		esito.setDescrizioneEsito(MessagesClass.getMessage("CALLBACK_RELATE_DOCUMENTO.DESCRIZIONE_ESITO.OK").trim());
		
		res.setEsito(esito);
		 
		return res;
	}


	private static File getFileFromSpazio(CallBackRelateDocumentoRequestType in) throws Exception {
		String spazioInternalNumber = in.getFileReference().getInternalNumber();
		
		File temp = File.createTempFile("Spazio_"+spazioInternalNumber, "");
  
		SpazioHandler spazioHandler = getSpazioHandler(in);
		
		FileOutputStream output = new FileOutputStream(temp); 
			
		spazioHandler.getFile(spazioInternalNumber,  output );
			 
		return temp;
	}


	private static SpazioHandler getSpazioHandler(CallBackRelateDocumentoRequestType in) throws Exception { 
			return new SpazioHandler(
					in.getFileReference().getQueueManager().trim(),
					in.getFileReference().getQueue().trim(), false );
	}


	private static String printCallBackRelateDocumento(CallBackRelateDocumentoRequestType in) {

		StringBuffer buf = new StringBuffer(); 

		buf.append("callBackRelateDocumento [");
		buf.append(" CorrelationId=" + in.getCorrelationId() ); 
		buf.append("]");
		return buf.toString();
	}


	private static String getNumeroDocumento(EntityItem documentoItem) throws Exception {
		String result = "";
		
		for (int i = 0; i < documentoItem.getDataValues().length; i++) {
			DataValue dataValue = documentoItem.getDataValues()[i];
			
			if ( dataValue.getDataTypeId() == CartellaDAOImpl.N_CARTELLA 
						|| dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO  ){  //bug4033
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
	
	//fine 22-05-2015 RelateDocumentoStandard
	


	private static EntityItem getEntityDocumento(String fascicoloId, String callerId, String numeroDoc) throws Exception { 
		EntityDAO entityDAO = new EntityDAO();
		return entityDAO.getEntityDocumento(fascicoloId, callerId, numeroDoc, 1);
	}


}
