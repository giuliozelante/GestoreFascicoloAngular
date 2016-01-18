package it.equitalia.gestorefascicolows.bl;


 
import it.equitalia.cartelleavvisi.wsdl.CartellaAvvisiRequestType;
import it.equitalia.cartelleavvisi.wsdl.CartelleAvvisiProxy;
import it.equitalia.cartelleavvisi.wsdl.CartelleAvvisiResponseType;
import it.equitalia.cartelleavvisi.wsdl.DocumentiAmbitoType;    
import it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoPortTypeProxy;
import it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoRequest;
import it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoResponse;
import it.equitalia.dettagliocartellaavviso.wsdl.PianiRateazioneType;
import it.equitalia.dettagliocartellaavviso.wsdl.ProcedureType;
import it.equitalia.dettagliocartellaavviso.wsdl.TributiType;
import it.equitalia.documentiesattoriali.bpel.BPSDocumentiEsattorialiRequest;
import it.equitalia.documentiesattoriali.bpel.BPSDocumentiEsattorialiResponse;
import it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortTypeProxy;
import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.FascicoloDAO;
import it.equitalia.gestorefascicolows.dao.PianoRateazioneDAO;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.ProceduraDAO;
import it.equitalia.gestorefascicolows.dao.QuietanzaDAO;
import it.equitalia.gestorefascicolows.dao.RataDAO;
import it.equitalia.gestorefascicolows.dao.TributoDAO; 
import it.equitalia.gestorefascicolows.dao.impl.CartellaDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.FascicoloDAOImpl;
import it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse;
import it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse;
import it.equitalia.gestorefascicolows.dati.DocumentoType;
import it.equitalia.gestorefascicolows.dati.EnteType;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.FascicoloList;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest;
import it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest;
import it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse;
import it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse;
import it.equitalia.gestorefascicolows.dati.IdentificativoDocumentoType;
import it.equitalia.gestorefascicolows.dati.PianoRateazioneType;
import it.equitalia.gestorefascicolows.dati.ProceduraType;
import it.equitalia.gestorefascicolows.dati.RataType;
import it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.TipoProceduraType;
import it.equitalia.gestorefascicolows.dati.TributoType;
import it.equitalia.gestorefascicolows.source.GestoreFascicoloWSSoapBindingImpl;
import it.equitalia.gestorefascicolows.srv.FaultType; 
import it.equitalia.gestorefascicolows.utils.DateUtil;
import it.equitalia.gestorefascicolows.utils.DocumentoEsattorialeComparator;
import it.equitalia.gestorefascicolows.utils.DocumentoEsattorialeEntityComparator;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.apache.log4j.Logger; 


// * modifica 2015-06-09 il client al processo cartelle è stato cambiato e il nuovo WSDL si chiama CartelleAvvisi.wsdl
// * modifica 2015-06-09 il client al processo dettaglioCartelle è stato cambiato e il nuovo WSDL si chiama DettaglioCartellaAvviso.wsdl
public class FascicoloBl {
	private static final String BPS_CARTELLE_ESITO_OK = "OK";
	private static final String BPS_CARTELLE_ESITO_AMBITI_NON_GESTITI = "AN"; //2015-06-04 ambiti-non-gestiti
	private static final String BPS_DETTAGLIO_CARTELLA_ESITO_OK = "OK";
	private static final String BPS_DOCUMENTI_ESATTORIALI_ESITO_OK = "OK";

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Log4jFactory.getLogger(FascicoloBl.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();   
	
	public static it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse creazioneFascicolo(it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
		logger.info("GestoreFascicoloWS - AperturaFascicolo: started.");
    	AperturaFascicoloWSResponse aperturaFascicoloWSResponse=new AperturaFascicoloWSResponse();
    	Date dataAccesso=new Date();
    	//**AB** inizio - bug produzione 07/05/2015 - eliminazione caratteri blank da fascicoloId
    	in.setFascicoloId(in.getFascicoloId().replaceAll(" ", ""));
    	in.setCallerId(in.getCallerId().replaceAll(" ", ""));
    	//**AB** inizio - bug produzione 07/05/2015 
    	String dataAccessoString=sdf.format(dataAccesso);
    	if (in.getDataApertura() == null)
    		in.setDataApertura(dataAccessoString);
   	
    	
    	if (checkAperturaFascicoloWSRequest(in,aperturaFascicoloWSResponse)) { 

        	try{ 
    	    	
    	    	FascicoloDAO fascicoloDAO = getFascicoloDao();
    	 		
    	 		FascicoloList[] list = fascicoloDAO.searchFascicolo(  in.getFascicoloId(), in.getCallerId(),
    	 				  null,   null,   null,
    	 				  null,   null,   null);
    	 		 
    	 		if (list.length>0) {  

    		 		aperturaFascicoloWSResponse.setEsito(MessagesClass.getMessage("ESITO_APERTURA_FASCICOLO_NOK_FASCICOLO_ESISTENTE"));
    		 		aperturaFascicoloWSResponse.setDescrizione(MessagesClass.getMessage("DESCRIZIONE_APERTURA_FASCICOLO_NOK_FASCICOLO_ESISTENTE"));
    		 		
    			} else{

    	 			fascicoloDAO = getFascicoloDao();
    		 		
    		 		String aperturafascicoloEsito=fascicoloDAO.aperturaFascicoloInsert(in);
    		 		if(aperturafascicoloEsito.split(";")[0]!=null&&aperturafascicoloEsito.split(";")[1]!=null){
    			 		aperturaFascicoloWSResponse.setEsito(aperturafascicoloEsito.split(";")[0]);
    			 		aperturaFascicoloWSResponse.setDescrizione(aperturafascicoloEsito.split(";")[1]);
    		 		}
    			}

    	 		
        	} catch (FaultType f) {
        		logger.error(MessagesClass.getMessage("ERROR_DAO_FACTORY_SELECTION ")+f.getMessage(), f);
        		errorLogger.error(MessagesClass.getMessage("ERROR_DAO_FACTORY_SELECTION ")+f.getMessage(), f);
    			throw f;
    		} catch(Exception e){
        		errorLogger.error(MessagesClass.getMessage("ERROR_DAO_FACTORY_SELECTION ")+e.getMessage(), e);
     			e.printStackTrace();
     			throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_0")),MessagesClass.getMessage("ERROR_CODE_0_DESCRIZIONE"));
        	}
    		
		} 
    	
    	logger.info("GestoreFascicoloWS -  AperturaFascicolo: invio response.");
        return aperturaFascicoloWSResponse;
	}

	private static boolean checkAperturaFascicoloWSRequest( AperturaFascicoloWSRequest in, AperturaFascicoloWSResponse aperturaFascicoloWSResponse) throws FaultType, NumberFormatException {
		StringBuffer sb = new StringBuffer();
		boolean result = true;
		
		 
		try { 
			sdf.parse(in.getDataApertura());
		} catch (Exception e) {
			sb.append( MessagesClass.getMessage("ERRORE_FORMATTAZIONE_DATA") + ";");
			result = false;
		}
		
		if (  ! UtilsClass.isCodiceFiscaleValido(in.getCodiceFiscale().trim()) ) {
			sb.append( MessagesClass.getMessage("ERRORE_CODICE_FISCALE_NON_VALIDO") + ";");
			result = false;
		}

		if (!result) { 
	 		aperturaFascicoloWSResponse.setEsito(MessagesClass.getMessage("ESITO_APERTURA_FASCICOLO_NOK"));
	 		aperturaFascicoloWSResponse.setDescrizione(sb.toString());
		} 
		
		return result;
	}

	public static ChiusuraFascicoloWSResponse chiusuraFascicolo( ChiusuraFascicoloWSRequest in) throws FaultType, NumberFormatException {
    	logger.info("GestoreFascicoloWS - ChiusuraFascicolo: started.");
    	ChiusuraFascicoloWSResponse chiusuraFascicoloWSResponse=new ChiusuraFascicoloWSResponse();
    	try{
	    	Date dataAccesso=new Date();
	    	String dataAccessoString=sdf.format(dataAccesso);
	    	in.setDataChiusura(dataAccessoString);
	    	
	    	FascicoloDAO fascicoloDAO  = getFascicoloDao();  
	
	
	 		Fascicolo fascicolo = fascicoloDAO.getFascicoloConEntityPrimoLivello(
										in.getFascicoloId() ,
										in.getCallerId(), EntityDAO.ENTITY_ID_CARTELLA ) ;
	    		
	    	if (fascicolo == null){

		    	chiusuraFascicoloWSResponse.setEsito(MessagesClass.getMessage("ESITO_CHIUSURA_FASCICOLO_NOK"));
		    	chiusuraFascicoloWSResponse.setDescrizione(MessagesClass.getMessage("DESCRIZIONE_CHIUSURA_FASCICOLO_NOK_FASCICOLO_INESISTENTE"));
	    	} else if(isChiuso(fascicolo)){

		    	chiusuraFascicoloWSResponse.setEsito(MessagesClass.getMessage("ESITO_CHIUSURA_FASCICOLO_NOK"));
		    	chiusuraFascicoloWSResponse.setDescrizione(MessagesClass.getMessage("DESCRIZIONE_CHIUSURA_FASCICOLO_NOK_FASCICOLO_CHIUSO"));
	    	} else{   
	    		
	     		fascicoloDAO = getFascicoloDao();  
	     		String chiusuraFascicoloEsito=fascicoloDAO.chiusuraFascicoloUpdate(in);
	     		if(chiusuraFascicoloEsito.split(";")[0]!=null&&chiusuraFascicoloEsito.split(";")[1]!=null){
	    	    	chiusuraFascicoloWSResponse.setEsito(chiusuraFascicoloEsito.split(";")[0]);
	    	    	chiusuraFascicoloWSResponse.setDescrizione(chiusuraFascicoloEsito.split(";")[1]);
	     		}
	     		
	    	} 


    	} catch (FaultType f) {
    		logger.error(MessagesClass.getMessage("ERROR_DAO_FACTORY_SELECTION ")+f.getMessage(), f);
    		errorLogger.error(MessagesClass.getMessage("ERROR_DAO_FACTORY_SELECTION ")+f.getMessage(), f);
			throw f;
		}  catch(Exception e){
    		errorLogger.error(MessagesClass.getMessage("ERROR_DAO_FACTORY_SELECTION ")+e.getMessage());
 			e.printStackTrace();
 			throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_0")),MessagesClass.getMessage("ERROR_CODE_0_DESCRIZIONE"));
    	}
    	
    	logger.info("GestoreFascicoloWS -  ChiusuraFascicolo: invio response.");
    	return chiusuraFascicoloWSResponse;
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

 
	private static CartelleAvvisiResponseType getBPSCartelleResponse( Fascicolo fascicolo) throws Exception {

		//leggo le cartelle del fascicolo da Esb
		
		CartellaAvvisiRequestType bpCartelleRequest = new CartellaAvvisiRequestType();   
		bpCartelleRequest.setTipologiaRichiesta(MessagesClass.getMessage("TIPOLOGIA_DOCUMENTI_TUTTI").trim()) ;	 
		bpCartelleRequest.setCodiceFiscale(fascicolo.getAnagrafica().getCodiceFiscale().trim());
		//il tipo documento (cartella od avviso), viene lasciato vuoto in modo da caricare entrambe le tipologie
		//bpCartelleRequest.setTipoDocumento(null); 
		
		//inizio modifiche Agosto
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		Date dataAttuale = new Date(); 
		logger.debug(dateFormat.format(dataAttuale)); 
		bpCartelleRequest.setDataRichiesta(dataAttuale );
		//fine modifiche Agosto
		
		return getBPSCartelleResponse(bpCartelleRequest);
	} 
	
	
	//inizio modifica_problema_transazioni 13/10/2014
	public static Fascicolo updateCartelleFascicolo(Fascicolo fascicolo, 
				CartelleAvvisiResponseType bpsCartelleResponse  
				) throws  Exception {
  

		Connection conn = null;
		Fascicolo result = null;
		try {
			
			//aggiorno le cartelle (senza i dettagli delle stesse)
			DocumentoType [] documentoTypeArray = convertBPSCartelleResponseIntoDocumentoTypeArray(bpsCartelleResponse);
 
			conn = DBFactory.connectionGet(DBFactory.ORIGINE_ORACLE, false); 
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED );
			logger.debug("INIZIATA TRANSAZIONE CON LIVELLO " + conn.getTransactionIsolation() );
			
			
			lockFascicolo(conn, fascicolo.getFascicoloId(), fascicolo.getCallerId() );	 
			
			FascicoloDAO  dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE); 
			
			//cancello i dati delle cartelle per il fascicolo dato  
			dao.svuotaFascicolo( fascicolo ); 
			
			it.equitalia.gestorefascicolows.dao.CartellaDAO cartellaDAO = DAOFactory.getCartellaDAO(true, DBFactory.ORIGINE_ORACLE);
			
			cartellaDAO.inserimentoCartellaInsert(
									fascicolo, //2041_08_18 modifica_2	
									documentoTypeArray,
									fascicolo.getFascicoloId(), 
									fascicolo.getCallerId()  );
			  
			

			//inizio FASCICOLO_2.1
			dao = DAOFactory.getFascicoloDAO();  
			dao.dataUltimoAggiornamentoUpdate(fascicolo, conn);
			//fine FASCICOLO_2.1
 
			dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);  
			result = dao.getFascicoloConEntityPrimoLivello(
				    				fascicolo.getFascicoloId() ,
				    				fascicolo.getCallerId(), EntityDAO.ENTITY_ID_CARTELLA ) ; 

			conn.commit();  
			logger.debug("TERMINATA TRANSAZIONE ");
		} catch (Exception e) { 
			if (conn != null) {
				conn.rollback();	
				logger.debug("TERMINATA TRANSAZIONE ");			
			}  
			throw e;  
		} finally{ 
			if (conn !=null) {
				conn.close(); 
			}
		} 
		
		return result;
		
	}
	//fine modifica_problema_transazioni 13/10/2014
	
	
	
	
 
 
 

	public static void lockFascicolo(Connection connection, String fascicoloId, String callerId) throws SQLException {

		
		PreparedStatementWrapper preparedStatement = null;
		ResultSet rs = null;
		try {
			String query = " select *  " +
							" FROM gestore_fascicolo.fascicolo  " +
						    " WHERE  fascicoloId = ?  " +
						    " AND  callerId = ? " +
						    " FOR UPDATE " ;
 
			preparedStatement =  new PreparedStatementWrapper(connection, query);  
			preparedStatement.setString(1, fascicoloId  );  
			preparedStatement.setString(2, callerId  ); 
			
			
			rs= preparedStatement.executeQuery();
		 
		
		}  finally{
			if (preparedStatement!=null) {
				preparedStatement.close();					
			}
			if (rs!=null) {
				rs.close();
			}
		} 
		
	
		
	}
 
	private static CartelleAvvisiResponseType getBPSCartelleResponse( CartellaAvvisiRequestType bpCartelleRequest) throws Exception {
		CartelleAvvisiResponseType response;
		CartelleAvvisiProxy proxy = new CartelleAvvisiProxy(MessagesClass.getMessage("CARTELLE_ESB_ENDPOINT"));
		response = proxy.getCartelleAvvisi_PortType() .process(bpCartelleRequest);
		
		//inizio  2015-06-04 ambiti-non-gestiti
		if (response.getEsito().equals(BPS_CARTELLE_ESITO_AMBITI_NON_GESTITI)) {
			logger.info("Ci sono ambiti non gestiti per la richiesta con codice fiscale[" 
					+ bpCartelleRequest.getCodiceFiscale() + "] tipologia[" +
					bpCartelleRequest.getTipologiaRichiesta()  + "] data richiesta[" +
					bpCartelleRequest.getDataRichiesta() + "] " +
							" TipoDocumento[" +  bpCartelleRequest.getTipoDocumento() + "]" ); 
		} else  	//fine 2015-06-04 ambiti-non-gestiti
			if (!response.getEsito().equals(BPS_CARTELLE_ESITO_OK)) {
				throw new Exception("Processo Cartelle KO: " + response.getDescrizioneEsito() );
			}

		return response;
	} 

	
	
 
	private static DocumentoType[] convertBPSCartelleResponseIntoDocumentoTypeArray( CartelleAvvisiResponseType bpsCartelleResponse) throws FaultType, NumberFormatException {
    	ArrayList<DocumentoType> result = new ArrayList<DocumentoType>();
    	
    	DocumentiAmbitoType[] documentiAmbitoType	= bpsCartelleResponse.getDocumentiAmbito();

        if (documentiAmbitoType!=null) {  //aggiunta 2015-06-04 ambiti-non-gestiti
            for (int iCartellaAmbito = 0; iCartellaAmbito < documentiAmbitoType.length; iCartellaAmbito++) {

            	it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType[] documentoTypeArray = documentiAmbitoType[iCartellaAmbito].getDocumenti().getDocumento();

                
                for (int iDocumentoType = 0; iDocumentoType< documentoTypeArray.length; iDocumentoType++) {
                		it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType documentoTypeResponse = documentoTypeArray[iDocumentoType]; 
                 		
                 		DocumentoType documentoType = new DocumentoType(); 

                 		IdentificativoDocumentoType identificativoDocumentoType = new IdentificativoDocumentoType();
                 		identificativoDocumentoType.setTipoDocumento(documentoTypeResponse.getIdDocumento().getTipoDocumento() );		//DATATYPEID=1   	Descrizione
                 		identificativoDocumentoType.setNumeroDocumento(documentoTypeResponse.getIdDocumento().getNumeroDocumento() );	  //DATATYPEID=2    		N° Cartella 
                 		documentoType.setIdDocumento(identificativoDocumentoType);
                 		
                 		it.equitalia.gestorefascicolows.dati.EnteType[] enti = new it.equitalia.gestorefascicolows.dati.EnteType[documentoTypeResponse.getEnte().length];
                 		                                                                                     
                 		       
                 		for (int iEnte = 0; iEnte < documentoTypeResponse.getEnte().length; iEnte++) {
                 			EnteType enteType = new EnteType();
                     		enteType.setDescrizione(documentoTypeResponse.getEnte()[iEnte].getDescrizione());   	//DATATYPEID=3      		Ente
                     		enti[iEnte] = enteType;
    					}
                 		
                 		documentoType.setEnte(enti);

                 		documentoType.setDataNotifica(documentoTypeResponse.getDataNotifica())   ;    //DATATYPEID=4    			Data Notifica
                 		documentoType.setImportoTotaleDocumento(documentoTypeResponse.getImportoTotaleDocumento()) ; //DATATYPEID=5    		Importo Iniziale
                 		documentoType.setImportoInizialeTributi(documentoTypeResponse.getImportoInizialeTributi()) ; //DATATYPEID=6     		Importo a ruolo
                 		documentoType.setImportoTotaleCompensi(documentoTypeResponse.getImportoTotaleCompensi());   // DATATYPEID=7   		Compensi entro le scadenze
                 		documentoType.setImportoTotaleNotifica(documentoTypeResponse.getImportoTotaleNotifica());              //DATATYPEID=8    		Diritti di Notifica

                 		documentoType.setImportoResiduoDocumento(documentoTypeResponse.getImportoResiduoDocumento());     // DATATYPEID=9     		Importo da Pagare    
                 		documentoType.setImportoResiduoTributi(documentoTypeResponse.getImportoResiduoTributi());        // DATATYPEID=10     		Importi a ruolo residui
                 		documentoType.setImportoResiduoCompensi(documentoTypeResponse.getImportoResiduoCompensi());  //DATATYPEID=11    		Compensi oltre le scadenze
                 		documentoType.setImportoResiduoNotifica(documentoTypeResponse.getImportoResiduoNotifica()); // DATATYPEID=12   		Diritti di Notifica
                 		documentoType.setImportoInteressiMora(documentoTypeResponse.getImportoInteressiMora());  // DATATYPEID=13   		Interessi di mora
                 		documentoType.setImportoSpeseProcedure(documentoTypeResponse.getImportoSpeseProcedure());  //DATATYPEID=14    		Spese di Procedura
                 		documentoType.setImportoAltreSpese(documentoTypeResponse.getImportoAltreSpese());  				//DATATYPEID=15    		Altre Spese
                 		documentoType.setFlagSospensione(documentoTypeResponse.getFlagSospensione());   //DATATYPEID=16   		Sospensioni
                 		documentoType.setFlagSgravio(documentoTypeResponse.getFlagSgravio());       // DATATYPEID=17   		Sgravi
                 		documentoType.setFlagRateazione(documentoTypeResponse.getFlagRateazione());       //DATATYPEID=18    		Rateazioni
                 		documentoType.setFlagProcedura(documentoTypeResponse.getFlagProcedura());       //DATATYPEID=19    		Procedure   
                 		
                 		documentoType.setNumeroRav(  documentoTypeResponse.getNumeroRav()   );       		//DATATYPEID=12    		Numero RAV      
               
                 		documentoType.setRObjectId("-") ;		//DATATYPEID=91    		
                 		documentoType.setStatoPdf(CartellaDAOImpl.STATO_DOCUMENTUM_NON_RICHIESTO) ;		//DATATYPEID=92    		
                 		documentoType.setStatoRelate(CartellaDAOImpl.STATO_DOCUMENTUM_NON_RICHIESTO) ;		//DATATYPEID=93    		 
                 		
                 		result.add(documentoType);
             	} 
            }
        }

    	
		return result.toArray(new DocumentoType[0]);
	} 

	
//	/**
//	 * metodo per concatenare i numeri rav in una stringa; in realtà attualmente ne dovrebbe arrivare soltanto uno
//	 */
//	private static String compattaRav(String[] numeroRav) throws FaultType, NumberFormatException {
//		StringBuffer result = new StringBuffer();
// 		String[] listaRav = numeroRav;
// 		for (int i = 0; i < listaRav.length; i++) {
//			if (i>0) {
//				result.append( MessagesClass.getMessage("CARATTERE_SEPARATORE_RAV") );
//			}
//			result.append( listaRav[i] );
//		}
// 		return result.toString();
//	}

	@Deprecated
	private static String getRav(String[] numeroRav) { 
		return numeroRav[0];
	}

	

	//inizio modifica_problema_transazioni 13/10/2014  
	public static Fascicolo updateCartella(Fascicolo fascicolo, int cartellaIndex,
			GetCartellaWSRequest in, 
			DettaglioCartellaAvvisoResponse response   
			) throws Exception {
		Fascicolo result;
		Connection conn = null; 
		try {  
			conn = DBFactory.connectionGet(DBFactory.ORIGINE_ORACLE, false); 
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED );
			logger.debug("INIZIATA TRANSAZIONE CON LIVELLO " + conn.getTransactionIsolation() ); 

 			lockFascicolo(conn, fascicolo.getFascicoloId(), fascicolo.getCallerId() );	  
	    	 
	    	TributoType [] tributoTypeArray = getTributoTypeFromBPSDettaglioCartellaResponse(response);  
	    	
			FascicoloDAO  dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE );
	    	dao.svuotaDettagliCartella(fascicolo.getFascicoloId(), fascicolo.getCallerId(), fascicolo.getCartelle(cartellaIndex).getEntityItemId()  );  
	    	
			new  EntityDAO(true, DBFactory.ORIGINE_ORACLE ).deleteDataValue(fascicolo.getCartelle(cartellaIndex).getEntityItemId(), true); 	//modifica mail 08/10/2014 10:38
	    	
			
	    	

	    	TributoDAO tributoDAO = DAOFactory.getTributoDAO(true, DBFactory.ORIGINE_ORACLE ); 
	    	tributoDAO.inserimentoTributoInsert(tributoTypeArray, in.getFascicoloId(), in.getCallerId(), 
	    					fascicolo.getCartelle(cartellaIndex)  ); //modifiche Agosto
	    	
	    	ProceduraType[] proceduraTypeArray = getProceduraTypeFromBPSDettaglioCartellaResponse(response);  

	    	ProceduraDAO proceduraDAO = DAOFactory.getProceduraDAO(true, DBFactory.ORIGINE_ORACLE );
	    	proceduraDAO.inserimentoProceduraInsert(proceduraTypeArray, in.getFascicoloId(), in.getCallerId(), 
							fascicolo.getCartelle(cartellaIndex)   ); 			//modifiche Agosto
	    	
	    	//inizio modifica_08/10/2014
	    	if ( isPianoRatezione(response) ) {

		    	PianoRateazioneDAO  pianoRateazioneDAO = DAOFactory.getPianoRateazioneDAO(true, DBFactory.ORIGINE_ORACLE); 
		    	PianoRateazioneType[] pianoRateazioneTypeArray = getPianoRateazioneTypeFromBPSDettaglioCartellaResponse(response);  
		    	pianoRateazioneDAO.inserimentoPianoRateazioneInsert(pianoRateazioneTypeArray, in.getFascicoloId(), in.getCallerId(),
								fascicolo.getCartelle(cartellaIndex)   ); 		//modifiche Agosto
		    	
			} else {
				RataType[] rateOrigine =  getRataTypeFromBPSDettaglioCartellaResponse(response); 
				RataDAO rataDAO = DAOFactory.getRataDAO(true, DBFactory.ORIGINE_ORACLE); 
				rataDAO.inserimentoRata(rateOrigine, in.getFascicoloId(), in.getCallerId(),
						fascicolo.getCartelle(cartellaIndex)  );
			}
	    	//fine modifica_08/10/2014
	    	
	    				
			
	    	//inizio modifica mail 08/10/2014 10:38 
	    	it.equitalia.gestorefascicolows.dati.DocumentoType[] documentoTypeArray = getDocumentoTypeFromBPSDettaglioCartellaResponse(response);
	    	
			it.equitalia.gestorefascicolows.dao.CartellaDAO cartellaDAO = DAOFactory.getCartellaDAO(true, DBFactory.ORIGINE_ORACLE);
	    	
			cartellaDAO.inserimentoCartellaInsert(
									fascicolo,  
									documentoTypeArray,
									fascicolo.getFascicoloId(), 
									fascicolo.getCallerId()  );
	    	//fine modifica mail 08/10/2014 10:38 
			
			//inizio FASCICOLO_2.1 
			//inserisco i dati relativi alle quietanze
			it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType [] quietanzaTypeArray = getQuietanzaTypeFromBPSDettaglioCartellaResponse(response);   
	    	QuietanzaDAO quietanzaDAO = DAOFactory.getQuietanzaDAO(true, DBFactory.ORIGINE_ORACLE );
	    	quietanzaDAO.inserimentoQuietanze(quietanzaTypeArray, in.getFascicoloId(), in.getCallerId(), 
							fascicolo.getCartelle(cartellaIndex)   ); 	 
			

	    	//inserisco o aggiorno la data di ultimo aggiornamento della cartella in questione.
			//Pur essendo un data value lo gestisco al di fuori del metodo inserimentoCartellaInsert(..) 
			//perchè deve essere inserito solo nel caso in cui si stia leggendo il dettaglio della cartella,
			//mentre il metodo suddetto viene invocato anche quando si legge l'intero fascicolo
			EntityItem cartellaEntityItem  = fascicolo.getCartelle(cartellaIndex);  
			cartellaDAO = DAOFactory.getCartellaDAO(true, DBFactory.ORIGINE_ORACLE); 
			cartellaDAO.insertOrUpdateDataUltimoAggiornamento(cartellaEntityItem, fascicolo); 
			//fine FASCICOLO_2.1
			
			dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE );
			result = dao.getCartella(
					in.getFascicoloId() ,
					in.getCallerId(),
					in.getNumeroCartella(),
					in.getCodiceAmbito()  );
			
			conn.commit();
			logger.debug("TERMINATA TRANSAZIONE ");
			
		} catch (Exception e) { 
			if (conn != null) {
				conn.rollback();		
				logger.debug("TERMINATA TRANSAZIONE ");		
			}
			throw e;  
		}
		
		finally{ 
			if (conn !=null) {
				conn.close();
			}
		} 
		
		return result;
	}
	//fine modifica_problema_transazioni 13/10/2014  
	 


	//inizio modifica_08/10/2014
	private static RataType[] getRataTypeFromBPSDettaglioCartellaResponse( DettaglioCartellaAvvisoResponse response) {
		RataType[] result =  new RataType[0];
		
		
		//inizio modifica  FASCICOLO_2.1 
		if (response.getCartellaAvviso().getPianoRateOrigine()!=null ) {
			it.equitalia.dettagliocartellaavviso.wsdl.RataType[] rate = response.getCartellaAvviso().getPianoRateOrigine();
			
			result =  new RataType[rate.length];
			
			for (int i = 0; i < rate.length; i++) {
				it.equitalia.dettagliocartellaavviso.wsdl.RataType rataResponse = rate[i];
				
				RataType rata = new RataType();

				rata.setProgressivoRata(rataResponse.getProgressivoRata() );
				rata.setDataScadenza(rataResponse.getDataScadenza());
				rata.setImportoRata(rataResponse.getImportoRata().doubleValue())  ;
				rata.setNumeroRav(rataResponse.getNumeroRav())  ;
				rata.setStatoRata(rataResponse.getStatoRata() )  ; 
				
				result[i] = rata;
			}
		}
		//fine  modifica  FASCICOLO_2.1
		 
		return result;
	}
	//fine modifica_08/10/2014
	
	
	
 
	/**
	 *   modifica_08/10/2014
	 * se il flag della reatezione è 
	 * 		-1:  la response contiene un numero indefinito di piani di reatezione valorizzati
	 * 		0: la response contiene un unico oggetto fittizio PianoRatezione che funge da contenitore per i dati veri e proprio che sono le rate origine
	 */		
	private static boolean isPianoRatezione( DettaglioCartellaAvvisoResponse response) {
		int flagRateazione = response.getCartellaAvviso().getDocumento().getFlagRateazione();
		
		if (flagRateazione == 0) {
			return false;
		} else{
			return true;
		} 
	} 

	//inizio modifica mail 08/10/2014 10:38
	private static DocumentoType[] getDocumentoTypeFromBPSDettaglioCartellaResponse( DettaglioCartellaAvvisoResponse response) {
		 
		it.equitalia.dettagliocartellaavviso.wsdl.DocumentoType bpelDocumentoType =  response.getCartellaAvviso().getDocumento();
		 
		DocumentoType[] result = new DocumentoType[1];
    	   
 		DocumentoType documentoType = new DocumentoType(); 
 		result[0] = documentoType;

 		IdentificativoDocumentoType identificativoDocumentoType = new IdentificativoDocumentoType();
 		identificativoDocumentoType.setTipoDocumento(bpelDocumentoType.getIdDocumento().getTipoDocumento() );		//DATATYPEID=1   	Descrizione
 		identificativoDocumentoType.setNumeroDocumento(bpelDocumentoType.getIdDocumento().getNumeroDocumento() );	  //DATATYPEID=2    		N° Cartella 
 		documentoType.setIdDocumento(identificativoDocumentoType);
 		
 		it.equitalia.gestorefascicolows.dati.EnteType[] enti = new it.equitalia.gestorefascicolows.dati.EnteType[bpelDocumentoType.getEnte().length];
 		                                                                                     
 		       
 		for (int iEnte = 0; iEnte < bpelDocumentoType.getEnte().length; iEnte++) {
 			EnteType enteType = new EnteType();
     		enteType.setDescrizione(bpelDocumentoType.getEnte()[iEnte].getDescrizione());   	//DATATYPEID=3      		Ente
     		enti[iEnte] = enteType;
		}
 		
 		documentoType.setEnte(enti);

 		documentoType.setDataNotifica(bpelDocumentoType.getDataNotifica())   ;    //DATATYPEID=4    			Data Notifica
 		documentoType.setImportoTotaleDocumento(bpelDocumentoType.getImportoTotaleDocumento().doubleValue()) ; //DATATYPEID=5    		Importo Iniziale
 		documentoType.setImportoInizialeTributi(bpelDocumentoType.getImportoInizialeTributi().doubleValue()) ; //DATATYPEID=6     		Importo a ruolo
 		documentoType.setImportoTotaleCompensi(bpelDocumentoType.getImportoTotaleCompensi().doubleValue());   // DATATYPEID=7   		Compensi entro le scadenze
 		documentoType.setImportoTotaleNotifica(bpelDocumentoType.getImportoTotaleNotifica().doubleValue());              //DATATYPEID=8    		Diritti di Notifica

 		documentoType.setImportoResiduoDocumento(bpelDocumentoType.getImportoResiduoDocumento().doubleValue());     // DATATYPEID=9     		Importo da Pagare    
 		documentoType.setImportoResiduoTributi(bpelDocumentoType.getImportoResiduoTributi().doubleValue());        // DATATYPEID=10     		Importi a ruolo residui
 		documentoType.setImportoResiduoCompensi(bpelDocumentoType.getImportoResiduoCompensi().doubleValue());  //DATATYPEID=11    		Compensi oltre le scadenze
 		documentoType.setImportoResiduoNotifica(bpelDocumentoType.getImportoResiduoNotifica().doubleValue()); // DATATYPEID=12   		Diritti di Notifica
 		documentoType.setImportoInteressiMora(bpelDocumentoType.getImportoInteressiMora().doubleValue());  // DATATYPEID=13   		Interessi di mora
 		documentoType.setImportoSpeseProcedure(bpelDocumentoType.getImportoSpeseProcedure().doubleValue());  //DATATYPEID=14    		Spese di Procedura
 		documentoType.setImportoAltreSpese(bpelDocumentoType.getImportoAltreSpese().doubleValue());  				//DATATYPEID=15    		Altre Spese
 		documentoType.setFlagSospensione(bpelDocumentoType.getFlagSospensione());   //DATATYPEID=16   		Sospensioni
 		documentoType.setFlagSgravio(bpelDocumentoType.getFlagSgravio());       // DATATYPEID=17   		Sgravi
 		documentoType.setFlagRateazione(bpelDocumentoType.getFlagRateazione());       //DATATYPEID=18    		Rateazioni
 		documentoType.setFlagProcedura(bpelDocumentoType.getFlagProcedura());       //DATATYPEID=19    		Procedure   
 		
 		documentoType.setNumeroRav(  bpelDocumentoType.getNumeroRav()   );       		//DATATYPEID=12    		Numero RAV      
   
     	documentoType.setRObjectId("-") ;		//DATATYPEID=91    		
 		documentoType.setStatoPdf(CartellaDAOImpl.STATO_DOCUMENTUM_NON_RICHIESTO) ;		//DATATYPEID=92    		
 		documentoType.setStatoRelate(CartellaDAOImpl.STATO_DOCUMENTUM_NON_RICHIESTO) ;		//DATATYPEID=93    		 
 		
    	
		return result ;
	
	}
	//fine modifica mail 08/10/2014 10:38
	
	

	static DettaglioCartellaAvvisoResponse getBPSDettaglioCartellaResponse( DettaglioCartellaAvvisoRequest request) throws Exception {
		DettaglioCartellaAvvisoResponse response;
		DettaglioCartellaAvvisoPortTypeProxy proxy = new DettaglioCartellaAvvisoPortTypeProxy( MessagesClass.getMessage("DETTAGLIO_CARTELLA_ESB_ENDPOINT") );
     	response = proxy.getDettaglioCartellaAvvisoPortType() .process(request);
     	
     	if (!response.getEsito().equals(BPS_DETTAGLIO_CARTELLA_ESITO_OK)) {
			throw new Exception("Processo Dettaglio Cartella KO: " + response.getDescrizioneEsito() );
		}
     	
		return response;
	}

	private static PianoRateazioneType[] getPianoRateazioneTypeFromBPSDettaglioCartellaResponse( DettaglioCartellaAvvisoResponse response) {
		PianoRateazioneType[] result  = new  PianoRateazioneType[0];;
		
		PianiRateazioneType pianiRateazioneType = response.getCartellaAvviso().getPianiRateazione();
		
		if (pianiRateazioneType!=null
				&& pianiRateazioneType.getListaPianiRateazione()!=null 
				&& pianiRateazioneType.getListaPianiRateazione().getPianoRateazione()!=null 
				&& pianiRateazioneType.getListaPianiRateazione().getPianoRateazione().length> 0) {

			int length = pianiRateazioneType.getListaPianiRateazione().getPianoRateazione().length;
			
			result = new  PianoRateazioneType[length];
			
			for (int i = 0; i < length; i++) {
				 
				it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType typeResponse = pianiRateazioneType.getListaPianiRateazione().getPianoRateazione()[i];
	  

		    	PianoRateazioneType pianoRateazioneType = new PianoRateazioneType();
		    	
		    	pianoRateazioneType.setProtocollo(typeResponse.getProtocollo());  //DATATYPEID=39     	N° Protocollo
		    	pianoRateazioneType.setDataApprovazione(typeResponse.getDataApprovazione());  //DATATYPEID=40     	Data Approvazione
		    	pianoRateazioneType.setCodiceFiscale(typeResponse.getCodiceFiscale().trim()) ;	//DATATYPEID=41     	Concesse da
		    	
		    	pianoRateazioneType.setStatoPiano(typeResponse.getStatoPiano());									//DATATYPEID=42     	Stato
		    	EnteType enteConcedente = new EnteType();
		    	enteConcedente.setDescrizione(typeResponse.getEnteConcedente().getDescrizione());
		    	enteConcedente.setCodiceEnte(typeResponse.getEnteConcedente().getCodiceEnte());
		    	enteConcedente.setCodiceUfficio(typeResponse.getEnteConcedente().getCodiceUfficio());
		    	enteConcedente.setTipoUfficio(typeResponse.getEnteConcedente().getTipoUfficio());
		    	pianoRateazioneType.setEnteConcedente(enteConcedente);
		    	
		    	pianoRateazioneType.setDocumentoAssociato(getDocumentiAssociatiPianoRateazione(typeResponse));	//ModDocumentiAssociati
		    	
		    	pianoRateazioneType.setRata(getRatePianoRateazione(typeResponse)); //Fascicolo 2.1 2015-05-07
		    	pianoRateazioneType.setEnteConcedente(getEnteConcedentePianoRateazione(typeResponse));  //Fascicolo 2.1 2015-05-07
		    	
		    	result[i] = pianoRateazioneType;
			 
			}
			
		}
		
		return result; 
	}


	//INIZIO Fascicolo 2.1 2015-05-07

	private static EnteType getEnteConcedentePianoRateazione(
			it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType typeResponse) {
		EnteType res =  new EnteType();

		res.setDescrizione(typeResponse.getEnteConcedente().getDescrizione());
		res.setCodiceEnte(typeResponse.getEnteConcedente().getCodiceEnte());
		res.setCodiceUfficio(typeResponse.getEnteConcedente().getCodiceUfficio());
		res.setTipoUfficio(typeResponse.getEnteConcedente().getTipoUfficio());
		
		return res;
	}
	
	private static RataType[] getRatePianoRateazione(it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType typeResponse) { 
		it.equitalia.dettagliocartellaavviso.wsdl.RataType[]  rateResponse = typeResponse.getRata();
		RataType[] res; 
		
		if (rateResponse!=null) {

			res = new RataType[rateResponse.length];

			for (int i = 0; i < rateResponse.length; i++) {
				RataType rata = new RataType();

				rata.setProgressivoRata(  rateResponse[i].getProgressivoRata()  );
				rata.setDataScadenza(  rateResponse[i].getDataScadenza()  );
				rata.setImportoRata( rateResponse[i].getImportoRata().doubleValue()  );
				rata.setNumeroRav(  rateResponse[i].getNumeroRav()  );
				rata.setStatoRata( rateResponse[i].getStatoRata()  );

				res[i]  = rata;
			}
		} else{
			res = new RataType[0];
		}
		
		return res;
	}
	//FINE Fascicolo 2.1 2015-05-07

	//inizio ModDocumentiAssociati
	private static IdentificativoDocumentoType[] getDocumentiAssociatiPianoRateazione( it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType typeResponse) {
		it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType[] documentoAssociatoTypeResponse = typeResponse.getDocumentoAssociato();
		IdentificativoDocumentoType[] res = new IdentificativoDocumentoType[documentoAssociatoTypeResponse.length];
		
		for (int i = 0; i < documentoAssociatoTypeResponse.length; i++) {
			IdentificativoDocumentoType doc = new IdentificativoDocumentoType();
			doc.setNumeroDocumento(documentoAssociatoTypeResponse[i].getNumeroDocumento());
			doc.setTipoDocumento(documentoAssociatoTypeResponse[i].getTipoDocumento());
			res[i] = doc;
		}
		return res;
	}
	

	private static IdentificativoDocumentoType[] getDocumentiAssociatiPianoRateazione( it.equitalia.dettagliocartellaavviso.wsdl.ProceduraType typeResponse) {
		it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType[] documentoAssociatoTypeResponse = typeResponse.getDocumentoAssociato();
		IdentificativoDocumentoType[] res = new IdentificativoDocumentoType[documentoAssociatoTypeResponse.length];
		
		for (int i = 0; i < documentoAssociatoTypeResponse.length; i++) {
			IdentificativoDocumentoType doc = new IdentificativoDocumentoType();
			doc.setNumeroDocumento(documentoAssociatoTypeResponse[i].getNumeroDocumento());
			doc.setTipoDocumento(documentoAssociatoTypeResponse[i].getTipoDocumento());
			res[i] = doc;
		}
		return res;
	}
	
	//fine ModDocumentiAssociati

 
	private static ProceduraType[] getProceduraTypeFromBPSDettaglioCartellaResponse( DettaglioCartellaAvvisoResponse response) {
		ProceduraType[] result = new  ProceduraType[0];
		
		ProcedureType procedureType = response.getCartellaAvviso().getProcedure();
		
		if (procedureType!=null
				&& procedureType.getListaProcedure()!=null
				&& procedureType.getListaProcedure().getProcedura()!=null
				&& procedureType.getListaProcedure().getProcedura().length>0) {
			
			int length = procedureType.getListaProcedure().getProcedura().length;
			
			result = new  ProceduraType[ length];
			
			for (int i = 0; i <  length; i++) {
				it.equitalia.dettagliocartellaavviso.wsdl.ProceduraType typeResponse = procedureType.getListaProcedure().getProcedura()[i];
	 
		    	 
		    	ProceduraType proceduraType = new ProceduraType();
		    	proceduraType.setDescrizioneProcedura(typeResponse.getDescrizioneProcedura());  //DATATYPEID=37     	Tipo Procedura
		    	proceduraType.setDataApertura(typeResponse.getDataApertura());  //DATATYPEID=38     	Data Attivazione
		    	proceduraType.setTipoProcedura( getTipoProceduraFromBPSDettaglioCartellaProceduraType(typeResponse) );
		    	
		    	proceduraType.setDocumentoAssociato( getDocumentiAssociatiPianoRateazione(typeResponse) );

				//INIZIO bug3991 - Fascicolo 2.1 2015-05-07
		    	proceduraType.setCodiceFiscale(typeResponse.getCodiceFiscale());
		    	proceduraType.setIdProcedura(typeResponse.getIdProcedura());
		    	proceduraType.setAnnoProcedura(typeResponse.getAnnoProcedura());
		    	proceduraType.setDataChiusura(typeResponse.getDataChiusura());
		    	proceduraType.setStatoProcedura(typeResponse.getStatoProcedura());
				//FINE  bug3991 - Fascicolo 2.1 2015-05-07

		    	
		    	
		    	result[i] = proceduraType;
			 
			}
			
		}
		return result; 
	} 

	

	//inizio FASCICOLO_2.1
	private static it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType[] getQuietanzaTypeFromBPSDettaglioCartellaResponse( DettaglioCartellaAvvisoResponse response) {
		if (response.getCartellaAvviso().getQuietanze()!=null
				&& response.getCartellaAvviso().getQuietanze().getListaQuietanze()!=null
				&& response.getCartellaAvviso().getQuietanze().getListaQuietanze().length>0) {
			return response.getCartellaAvviso().getQuietanze().getListaQuietanze();	
		} else{
			return new it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType[0];  
		}
		
	}	 
	//fine FASCICOLO_2.1 
	

 
	private static TipoProceduraType getTipoProceduraFromBPSDettaglioCartellaProceduraType( it.equitalia.dettagliocartellaavviso.wsdl.ProceduraType typeResponse) {
		TipoProceduraType result = new TipoProceduraType();
		result.setCodiceTipoProcedura(typeResponse.getTipoProcedura().getCodiceTipoProcedura()) ;
		result.setDescrizioneTipoProcedura(typeResponse.getTipoProcedura().getDescrizioneTipoProcedura()) ;
		return result;
	} 
	 
	private static TributoType[] getTributoTypeFromBPSDettaglioCartellaResponse( 
			DettaglioCartellaAvvisoResponse response  
			) {
		TributoType[] result =  new  TributoType[0];;
		
		TributiType tributiType = response.getCartellaAvviso().getTributi();
		
		if (tributiType!=null
				&& tributiType.getListaTributi()!=null
				&& tributiType.getListaTributi().getTributo()!=null
				&& tributiType.getListaTributi().getTributo().length>0) {
			
			int length = tributiType.getListaTributi().getTributo().length;
			
			result = new  TributoType[ length];
			
			for (int i = 0; i <  length; i++) {
				it.equitalia.dettagliocartellaavviso.wsdl.TributoType tributoTypeResponse = tributiType.getListaTributi().getTributo()[i];

		    	TributoType tributoType = new TributoType();

		    	
		    	tributoType.setCodiceTributo(tributoTypeResponse.getCodiceTributo() );				//DATATYPEID=21    	Codice Tributo					
		    	tributoType.setDescrizioneTributo(tributoTypeResponse.getDescrizioneTributo());           		 //DATATYPEID=22    	Descrizione Tributo / Ente
		    	if (tributoTypeResponse.getDescrizioneTributoRuolo()!= null)
		    		tributoType.setDescrizioneTributoRuolo(tributoTypeResponse.getDescrizioneTributoRuolo() );	      //DATATYPEID=22    	Descrizione Tributo / Ente
		    	else
		    		tributoType.setDescrizioneTributoRuolo("");
		    	tributoType.setEnte( getEnteTypeFromDettagliocartellaEnteType( tributoTypeResponse.getEnte() ) );             //DATATYPEID=23    	Ente impositore
		    	tributoType.setAnnoTributo(tributoTypeResponse.getAnnoTributo());             //DATATYPEID=24    	Anno
		    	tributoType.setRateizzabile(tributoTypeResponse.getRateizzabile());             //DATATYPEID=25    	Rateizzato
		    	tributoType.setImportoIniziale(tributoTypeResponse.getImportoIniziale().doubleValue());             //DATATYPEID=26    	Importo a ruolo iniziale
		    	tributoType.setImportoPagato(tributoTypeResponse.getImportoPagato().doubleValue());             //DATATYPEID=27    	Importo Pagato
		    	tributoType.setImportoSgravato(tributoTypeResponse.getImportoSgravato().doubleValue());             //DATATYPEID=28    	Importo Sgravato
		    	tributoType.setImportoSospeso(tributoTypeResponse.getImportoSospeso().doubleValue());             //DATATYPEID=29    	Importi Sospesi
		    	tributoType.setImportoResiduoCorrente(tributoTypeResponse.getImportoResiduoCorrente().doubleValue());             //Non utilizzato 27/11/2014 
		    	tributoType.setImportoResiduoTotale(tributoTypeResponse.getImportoResiduoTotale().doubleValue());             //DATATYPEID=30    	Importo Residuo 

		    	result[i] = tributoType;
			 
			}
			
		}
		return result; 
	
	} 

 
	private static EnteType getEnteTypeFromDettagliocartellaEnteType( it.equitalia.dettagliocartellaavviso.wsdl.EnteType dettagliocartellaEnte) {
		EnteType result = new EnteType();

		result.setCodiceEnte(dettagliocartellaEnte.getCodiceEnte()) ;
		result.setCodiceUfficio(dettagliocartellaEnte.getCodiceUfficio()) ;
		result.setDescrizione(dettagliocartellaEnte.getDescrizione() ) ;
		result.setTipoUfficio(dettagliocartellaEnte.getTipoUfficio() ) ;

		
		return result;
	} 

	public static boolean isChiuso(Fascicolo fascicolo) { 
		//inizio FASCICOLO_2.1
		boolean res = fascicolo.getStatoFascicoloId()== FascicoloDAOImpl.STATO_FASCICOLO_CHIUSO;
		if (res) { 
			logger.info("GestoreFascicoloWS - il fascicolo con FascicoloId[" + fascicolo.getFascicoloId() + "] CallerId[" + fascicolo.getCallerId() + "] è chiuso");
		} 
		return res;
		//fine  FASCICOLO_2.1
	}

	

	//inizio modifica_problema_transazioni 13/10/2014
	public static Fascicolo updateDocumentiEsattorialiNonCartelleFascicolo( Fascicolo fascicolo, GetDocumentiEsattorialiNonCartelleWSRequest in) throws Exception {
		Fascicolo result = null;
		
		//leggo i documenti esattoriali del fascicolo da Esb  
		BPSDocumentiEsattorialiRequest request = new BPSDocumentiEsattorialiRequest();
		request.setCodiceFiscale( fascicolo.getAnagrafica().getCodiceFiscale().trim() );
		
		BPSDocumentiEsattorialiResponse response = getBPSDocumentiEsattorialiResponse(request); 
		
		
		
		//filtro il risultato escludendo i documenti di tipo “CRT” e li ordina per tipo documento e data spedizione ;
		ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType> listaDocumentiEsattoriali = filtraDocumentiEsattorialiNonCartelle(response);


		Connection conn = null;
		try {

			conn = DBFactory.connectionGet(DBFactory.ORIGINE_ORACLE, false); 
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			logger.debug("INIZIATA TRANSAZIONE CON LIVELLO " + conn.getTransactionIsolation() ); 
			
			lockFascicolo(conn, fascicolo.getFascicoloId(), fascicolo.getCallerId() );
			
			//cancello i dati dei documenti esattoriali (non cartelle) per il fascicolo dato  
			FascicoloDAO  dao   = DAOFactory.getFascicoloDAO( true, DBFactory.ORIGINE_ORACLE );
			dao.svuotaFascicolo( fascicolo  );  	 
			
			it.equitalia.gestorefascicolows.dao.CartellaDAO cartellaDAO = DAOFactory.getCartellaDAO( true, DBFactory.ORIGINE_ORACLE);
			cartellaDAO.inserimentoDocumentoEsattorialeNonCartellaInsert(
									fascicolo, 
									listaDocumentiEsattoriali,
									fascicolo.getFascicoloId(), 
									fascicolo.getCallerId() );  
			

			dao   = DAOFactory.getFascicoloDAO();
			dao.dataUltimoAggiornamentoDocumentiEsattorialiUpdate(fascicolo, conn);
			
			
			dao   = DAOFactory.getFascicoloDAO( true, DBFactory.ORIGINE_ORACLE );
    		result = dao.getFascicoloConEntityPrimoLivello(
							in.getFascicoloId(), in.getCallerId(),  EntityDAO.ENTITY_ID_DOCUMENTO_ESATTORIALE  ) ; 
    		
//    		
//    		for (it.equitalia.gestorefascicolows.dati.EntityItem entityItem : result.getCartelle()) {
//    			for (it.equitalia.gestorefascicolows.dati.DataValue dataValue : entityItem.getDataValues()) {
//    			
//	    			if (dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_TIPO_MODELLO) { 
//	    				dataValue.setValue(MessagesClass.getMessage(dataValue.getValue()));
//	    			} 
//	    		}
//    		}
			

			conn.commit();
			logger.debug("TERMINATA TRANSAZIONE ");
			
		} catch (Exception e) { 
			if (conn != null) {
				conn.rollback();	
				logger.debug("TERMINATA TRANSAZIONE ");			
			}
			throw e;  
		} finally{ 
			if (conn !=null) {
				conn.close();
			}
		} 
		
		return result;
		
	}
	//fine modifica_problema_transazioni 13/10/2014
	
	private static void trascodificaDescrizioneDocumenti(it.equitalia.gestorefascicolows.dati.EntityItem[] documenti ) throws FaultType, NumberFormatException{
		for (it.equitalia.gestorefascicolows.dati.EntityItem entityItem : documenti) {
			for (it.equitalia.gestorefascicolows.dati.DataValue dataValue : entityItem.getDataValues()) {
			
    			if (dataValue.getDataTypeId() == CartellaDAOImpl.DOCUMENTO_ESATTORIALE_TIPO_MODELLO) { 
    				dataValue.setValue(MessagesClass.getMessage(dataValue.getValue()));
    			} 
    		}
		}
	}

	private static BPSDocumentiEsattorialiResponse getBPSDocumentiEsattorialiResponse( BPSDocumentiEsattorialiRequest request) throws Exception {
		BPSDocumentiEsattorialiResponse response;
		DocumentiEsattorialiPortTypeProxy proxy = new DocumentiEsattorialiPortTypeProxy(MessagesClass.getMessage("DOCUMENTI_ESATTORIALI_NON_CARTELLE_ESB_ENDPOINT"));
		response = proxy.getDocumentiEsattorialiPortType().process( request );
		
		if (!response.getEsito().equals(BPS_DOCUMENTI_ESATTORIALI_ESITO_OK)) {
			throw new Exception("Processo Documenti Esattoriali KO: " + response.getDescrizioneEsito() );
		}
		
		return response;
	}

	private static ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType> filtraDocumentiEsattorialiNonCartelle( BPSDocumentiEsattorialiResponse response) throws FaultType, NumberFormatException {
		ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType> lista = new ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType>();
		
		for (it.equitalia.documentiesattoriali.bpel.DocumentoType documentoEsattoriale : response.getDocumenti()) {
			
			if ( documentoEsattoriale!=null &&				//aggiunta bug 24/10/2014
					documentoEsattoriale.getTipoModello()!=null &&    //aggiunta bug 24/10/2014
						!documentoEsattoriale.getTipoModello().equals("CRT")) { 
				lista.add(documentoEsattoriale);
			} 
		}
		
		Collections.sort(lista, new DocumentoEsattorialeComparator() );
		
		return lista;
	}

	public static FascicoloList[] searchFascicolo(SearchFascicoloWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - searchFascicolo: started.");
		FascicoloList[] result = null;
		FascicoloDAO dao; 
    	
    	try {
    		dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		
    		result = dao.searchFascicolo(
    		    	//**AB** - bug produzione 07/05/2015 - eliminazione caratteri blank da fascicoloId
					in.getFascicoloId().replaceAll(" ", "") ,
					in.getCallerId().replaceAll(" ", "") ,
					in.getDataAperturaDa() ,
					in.getDataAperturaA() ,
					in.getDataChiusuraDa() ,
					in.getDataChiusuraA(),
					in.getStatoFascicolo(),
					in.getCodiceFiscale().trim().toUpperCase() );
		} catch (Exception e) { 
			logger.error("Errore in GestoreFascicoloWS - searchFascicolo", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  

		logger.info("GestoreFascicoloWS - searchFascicolo: end.");
		return result;
	}

	public static GetDocumentiEsattorialiNonCartelleWSResponse getDocumentiEsattorialiNonCartelle( GetDocumentiEsattorialiNonCartelleWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - getDocumentiEsattorialiNonCartelle: started");

    	FascicoloDAO dao;	 
		Fascicolo fascicolo;
		
    	try { 
    		dao  = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		
    		fascicolo = dao.getFascicoloConEntityPrimoLivello(
											in.getFascicoloId(), in.getCallerId(),  EntityDAO.ENTITY_ID_DOCUMENTO_ESATTORIALE ) ;
    		
    		if (fascicolo != null ) {
    			logger.info("GestoreFascicoloWS - getDocumentiEsattorialiNonCartelle: trovato fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "]");
    			
        		if (!FascicoloBl.isChiuso( fascicolo )
        				&& !FascicoloBl.isDocumentiEsattorialiAggiornati(fascicolo) ) { //FASCICOLO_2.1

        			logger.info("GestoreFascicoloWS - getDocumentiEsattorialiNonCartelle: il fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "] è aperto.");
        			
        			//inizio modifica_problema_transazioni 13/10/2014
        			fascicolo = FascicoloBl.updateDocumentiEsattorialiNonCartelleFascicolo(fascicolo, in);  
 
        			logger.info("GestoreFascicoloWS - getDocumentiEsattorialiNonCartelle: eseguito aggiornamento per fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "]");
        			 
    	    		//fine modifica_problema_transazioni 13/10/2014
    	    		
        		}  
			} 
    		
		}  catch (Exception e) { 
			logger.error("Errore in GestoreFascicoloWS - getDocumentiEsattorialiNonCartelle", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  
		
		if (fascicolo==null) {
			FaultType faultType = new FaultType(0, "Nessun fascicolo trovato");
			throw faultType; 
		} 

		//FIXME questa parte di codice andrebbe pulita
		fascicolo.setDocumenti(fascicolo.getCartelle().clone());
		fascicolo.setCartelle(null);
		
		trascodificaDescrizioneDocumenti(fascicolo.getDocumenti());

		sortDocumentiByTipoModello(fascicolo);//Bug3640 ordino i documenti per tipo modello e data spedizione
		
		logger.info("GestoreFascicoloWS - getDocumentiEsattorialiNonCartelle: end");
		
		return  new GetDocumentiEsattorialiNonCartelleWSResponse( fascicolo ); 
	}

	//inizio Bug3640 
	private static void sortDocumentiByTipoModello(Fascicolo fascicolo) {
		EntityItem[] documenti = fascicolo.getDocumenti();
		Arrays.sort(documenti, new DocumentoEsattorialeEntityComparator());
	}
	//fine Bug3640 
	
	public static GetFascicoloWSResponse getFascicolo(GetFascicoloWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - getFascicolo: started"); 
    	
    	FascicoloDAO dao;	   
		Fascicolo fascicolo;
		
    	try { 
    		dao  = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		
    		fascicolo = dao.getFascicoloConEntityPrimoLivello(
									in.getFascicoloId() ,
									in.getCallerId(), EntityDAO.ENTITY_ID_CARTELLA ) ;
    		
    		if (fascicolo != null ) {

    			logger.info("GestoreFascicoloWS - getFascicolo: trovato fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "]");
    			 
        		if (!FascicoloBl.isChiuso( fascicolo ) 
        				&& !FascicoloBl.isAggiornato( fascicolo ) ) { //FASCICOLO_2.1
        			
        			logger.info("GestoreFascicoloWS - getFascicolo: il fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "] è aperto.");
        			
        			//inizio modifica_problema_transazioni 13/10/2014  
        			CartelleAvvisiResponseType bpsCartelleResponse = FascicoloBl.getBPSCartelleResponse(fascicolo);  
    				
        			logger.info("GestoreFascicoloWS - getFascicolo: eseguita richiesta a BPSCartelle per fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "]");
        			 
        			fascicolo = FascicoloBl.updateCartelleFascicolo(fascicolo, bpsCartelleResponse); 
    	    		//fine modifica_problema_transazioni 13/10/2014  
    			}  
			} else{  
				Exception ex = new Exception("Nessun fascicolo trovato");
				throw ex;
			}

		}  catch (Exception e) { 
			logger.error("Errore in GestoreFascicoloWS - getFascicolo", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  

		logger.info("GestoreFascicoloWS - getFascicolo: end"); 
		return  new GetFascicoloWSResponse( fascicolo );
	}

	//inizio FASCICOLO_2.1
	private static boolean isAggiornato(Fascicolo fascicolo) {
		boolean res;
		Calendar dataUltimoAggiornamento =  DateUtil.fromDateToCalendar( fascicolo.getDataUltimoAggiornamento() );
		Calendar now = Calendar.getInstance();
		if (	dataUltimoAggiornamento!=null
				&& dataUltimoAggiornamento.get(Calendar.YEAR) == now.get(Calendar.YEAR)
				&& dataUltimoAggiornamento.get(Calendar.MONTH) == now.get(Calendar.MONTH)
				&& dataUltimoAggiornamento.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH) ) {
			res = true;
		} else{
			res = false;  
		}
		 
		if (res) { 
			logger.info("GestoreFascicoloWS - il fascicolo con FascicoloId[" + fascicolo.getFascicoloId() + "] CallerId[" + fascicolo.getCallerId() + "] è aggiornato");
		} 
		return res; 
	}
	
	
	private static boolean isDocumentiEsattorialiAggiornati(Fascicolo fascicolo) {  
		boolean res;
		Calendar dataUltimoAggiornamentoDocumentiEsattoriali = DateUtil.fromDateToCalendar( fascicolo.getDataUltimoAggiornamentoDocumentiEsattoriali() );
		Calendar now = Calendar.getInstance();
		if (	dataUltimoAggiornamentoDocumentiEsattoriali!=null
				&& dataUltimoAggiornamentoDocumentiEsattoriali.get(Calendar.YEAR) == now.get(Calendar.YEAR)
				&& dataUltimoAggiornamentoDocumentiEsattoriali.get(Calendar.MONTH) == now.get(Calendar.MONTH)
				&& dataUltimoAggiornamentoDocumentiEsattoriali.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH) ) {
			res = true;
		} else{
			res = false;  
		}
		 
		if (res) { 
			logger.info("GestoreFascicoloWS - il fascicolo con FascicoloId[" + fascicolo.getFascicoloId() + "] CallerId[" + fascicolo.getCallerId() + "] è aggiornato");
		} 
		return res; 
	}
	//fine FASCICOLO_2.1
	
	
}
