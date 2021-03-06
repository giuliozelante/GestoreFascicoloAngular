package it.equitalia.gestorefascicolows.bl;

import it.equitalia.estrattoconto.bpel.EstrattoContoProxy;
import it.equitalia.estrattoconto.bpel.EstrattoContoRequest;
import it.equitalia.estrattoconto.bpel.EstrattoContoResponse;
import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.FascicoloDAO;
import it.equitalia.gestorefascicolows.dao.impl.FascicoloDAOImpl;
import it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest;
import it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Convertions;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;
import it.equitalia.gestorefascicolows.utils.documentum.CheckedOutFile;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumFileBean;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumHandler;
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumHandler.ContentType;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class EstrattoContoBl {
	private static final String ESTRATTO_CONTO_ESITO_OK = "OK";
	private static final String ESTRATTO_CONTO_INPUT_TIPOLOGIA_INSOLUTI = "I";
	private static final String ESTRATTO_CONTO_INPUT_TIPOLOGIA_SALDATI = "S";


	private static Logger logger = Log4jFactory.getLogger(EstrattoContoBl.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();

	public static PdfEstrattoContoWSResponse pdfEstrattoConto( PdfEstrattoContoWSRequest in) throws FaultType {
		logger.info("Inizio " + printPdfEstrattoConto(in)  );
		PdfEstrattoContoWSResponse response = new PdfEstrattoContoWSResponse();

		try {
	    	FascicoloDAO fascicoloDAO = getFascicoloDao();
	    	int statoFascicolo = fascicoloDAO.getStatoFascicolo(in.getFascicoloId(), in.getCallerId());

	    	if (statoFascicolo == FascicoloDAOImpl.STATO_FASCICOLO_APERTO){
				EstrattoContoResponse estrattoContoResponse = callEstrattoConto(in);
				logger.info(  printPdfEstrattoConto(in) + " chiamato processo pdf estratto conto con esito[" + estrattoContoResponse.getEsito() + "]"  );
				if (estrattoContoResponse.getEsito().equals(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_OK"))) {
					//esegui inserimento con versionamento
					salvaConVersionamento(in, estrattoContoResponse.getEstrattoContoPdf() );
					response.setPdf(estrattoContoResponse.getEstrattoContoPdf());
					response.setEsito(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_OK"));
					response.setDescrizioneEsito(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_OK"));
				} else if (estrattoContoResponse.getEsito().equals(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_NC"))) {
					response.setPdf(null);
					response.setEsito(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_NC"));

					if (in.getTipologia().equals(ESTRATTO_CONTO_INPUT_TIPOLOGIA_INSOLUTI)) {
						response.setDescrizioneEsito(MessagesClass.getMessage("ESTRATTO_CONTO.DESCRIZIONE_ESITO_NC_INSOLUTI"));
					} else{
						response.setDescrizioneEsito(MessagesClass.getMessage("ESTRATTO_CONTO.DESCRIZIONE_ESITO_NC_SALDATI"));
					}

				} else{
					response.setPdf(null);
		    		response.setEsito(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_KO"));
					response.setDescrizioneEsito(MessagesClass.getMessage("ESTRATTO_CONTO.PROCESSO_FALLITO"));
					//throw new Exception("Il processo BPSEstrattoConto non � andato a buon fine; esito estrattoContoResponse[" +estrattoContoResponse.getEsito() + "]");
				}
	    	}else{
	    		response.setPdf(getPdfBytes(in));
	    		if (response.getPdf().length == 0){
	    			response.setEsito(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_NON_DISPONIBILE"));
	    			response.setDescrizioneEsito(MessagesClass.getMessage("ESTRATTO_CONTO.DESCRIZIONE_ESITO_NON_DISPONIBILE"));
	    		}else{
	    			response.setEsito(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_OK"));
	    			response.setDescrizioneEsito(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_OK"));
	    		}
	    	}

		} catch (Throwable e) {
			logger.error("Errore in " + printPdfEstrattoConto(in), e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}
		logger.info("Fine " + printPdfEstrattoConto(in)  );
		return response;
	}

	private static void salvaConVersionamento(PdfEstrattoContoWSRequest in, byte[] bytes) throws Exception {
		DocumentumHandler  dh  =  new DocumentumHandler(
				MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  ,
				MessagesClass.getMessage("DOCUMENTUM.PASSWORD").trim()	,
				MessagesClass.getMessage("DOCUMENTUM.REPOSITORY").trim() );


		File checkInOutDir = new File( MessagesClass.getMessage("DOCUMENTUM.CHECK_IN_OUT_DIR") );

		File tempDir = new File(
				checkInOutDir +
				File.separator +
				in.getCallerId().trim() + "_" +  in.getFascicoloId().trim()
				);

		try {

			if ( UtilsClass.mkdir(tempDir)) {

				//prendo in checkout il file se esiste
				CheckedOutFile checkedOutFile = dh.checkOutFromDocumentum(
									MessagesClass.getMessage("DOCUMENTUM.CLASSE_DOCUMENTALE") ,
									in.getCf().trim(),
									in.getCallerId().trim(),
									in.getFascicoloId().trim(),
									null,
									getTipoDocumento(in),
									tempDir.getAbsolutePath());

				getTipoDocumento(in);

				if (checkedOutFile!=null) {

					logger.info(  printPdfEstrattoConto(in) + " checkout del file[" +  checkedOutFile.getFilePath() + "]"  );


					try {
						if ( !sovrascriviFile(checkedOutFile, bytes) ) {
							throw new Exception("Impossibile sovrascrivere il file[" +  checkedOutFile.getFilePath() + "]");
						} else{
							logger.info(  printPdfEstrattoConto(in) + " file[" +  checkedOutFile.getFilePath() + "] sovrascritto correttamente ");
						}
					} finally{
						//questa operazione va sepre eseguite altrimenti il file su ducumentum resta lockato
						dh.checkInDocumentum(checkedOutFile);

						logger.info(  printPdfEstrattoConto(in) + " checkin del file[" +  checkedOutFile.getFilePath() + "]"  );
					}

				} else{

					File temp = File.createTempFile("EstrattoContoPdf", "");

					UtilsClass.writeBytes(temp, bytes);

					salvaDocumentum(in.getFascicoloId().trim(), in.getCallerId().trim(), in.getCf().trim(), null, getTipoDocumento(in), temp);

					logger.info(  printPdfEstrattoConto(in) + " salvato file in documentum "  );
				}


			} else{
				throw new Exception("Impossibile creare la directory[" +  tempDir.getAbsolutePath() + "]");
			}

		} finally {

			if (tempDir.exists()) {
				tempDir.delete();
			}
		}



	}

	private static String getTipoDocumento(PdfEstrattoContoWSRequest in) throws FaultType, NumberFormatException {
		if (in.getTipologia().equals(ESTRATTO_CONTO_INPUT_TIPOLOGIA_INSOLUTI)) {
			return MessagesClass.getMessage("DOCUMENTUM.TIPO_EC_INSOLUTI");
		} else{
			return MessagesClass.getMessage("DOCUMENTUM.TIPO_EC_SALDATI");
		}

	}

	private static boolean sovrascriviFile(CheckedOutFile checkedOutFile, byte[] bytes) throws Exception {

		File dest = new File(checkedOutFile.getFilePath());

		File temp = File.createTempFile("EstrattoContoPdf", "", dest.getParentFile());

		UtilsClass.writeBytes(temp, bytes);

		if (!dest.delete()) {
			throw new Exception("Impossibile cancellare [" + dest.getAbsoluteFile() + "]");
		}

		return temp.renameTo(dest);

	}

	private static String printPdfEstrattoConto(PdfEstrattoContoWSRequest in) {
		StringBuffer buf = new StringBuffer();
		buf.append("pdfEstrattoConto [");
		buf.append(" cf=" + in.getCf().trim() );  //Bug3656
		buf.append("]");
		return buf.toString();
	}

	private static EstrattoContoResponse callEstrattoConto( PdfEstrattoContoWSRequest in) throws  Exception {
		EstrattoContoResponse response;
		EstrattoContoProxy proxy = new EstrattoContoProxy(MessagesClass.getMessage("BPS_ESTRATTO_CONTO"));
		EstrattoContoRequest payload = new EstrattoContoRequest(
					in.getCf().trim(),
		           new Date(),
		           in.getTipologia() ); //Fascicolo del Contribuente 2.1 - nota 145
		response = proxy.getEstrattoConto_PortType().process(payload);

		if (!response.getEsito().equals(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_OK")) && !response.getEsito().equals(MessagesClass.getMessage("ESTRATTO_CONTO.ESITO_NC"))) {
			throw new Exception("Processo Estratto conto KO: " + response.getDescrizioneEsito() );
		}
		return response;
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


		dfb.setFileName(        codiceFiscale + "_" + fascicoloId + "_" + callerId +  ".pdf");
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

	private static byte[] getPdfBytes(PdfEstrattoContoWSRequest in) throws Exception {
		DocumentumHandler  dh  = new DocumentumHandler(
				MessagesClass.getMessage("DOCUMENTUM.USERNAME").trim()  ,
				MessagesClass.getMessage("DOCUMENTUM.PASSWORD").trim()	,
				MessagesClass.getMessage("DOCUMENTUM.REPOSITORY").trim() );

		File outputFile = File.createTempFile("getPdfEstrattoConto_temp", "");

		dh.getFileFromDocumentum( MessagesClass.getMessage("DOCUMENTUM.CLASSE_DOCUMENTALE") ,
				in.getCf().trim(),	//Bug3656
				in.getCallerId(),
				in.getFascicoloId(),
				null,
				getTipoDocumento(in),
				outputFile);
		byte[] result = Convertions.convertIntoBytes(outputFile);
		outputFile.delete();
		return result;
	}

	private static FascicoloDAO getFascicoloDao() throws FaultType {
		try {
 			return  DAOFactory.getFascicoloDAO(true,DBFactory.ORIGINE_ORACLE);
     	} catch (FaultType et) {
 			throw et;
 		} catch (Exception e) {
 			errorLogger.error(MessagesClass.getMessage("ERROR_DAO_FACTORY_SELECTION ")+e.getMessage());
 			e.printStackTrace();
 			throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
 		}
	}

}
