package it.equitalia.gestorefascicolows.dao.impl;

import java.sql.Connection; 
import java.sql.ResultSet; 
import org.apache.log4j.Logger;
 
import it.equitalia.gestorefascicolows.dao.DAOFactory; 
import it.equitalia.gestorefascicolows.dao.DocumentoAssociatoDAO;
import it.equitalia.gestorefascicolows.dao.PianoRateazioneDAO;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.RataPianoRateazioneDAO;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.InserimentoPianoRateazioneWSRequest;
import it.equitalia.gestorefascicolows.dati.PianoRateazioneType;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;




public class PianoRateazioneDAOImpl extends EntityItemClass implements
		PianoRateazioneDAO {
	public static final int  DATA_TYPE_ID_N_PROTOCOLLO =  410;
	public static final int  DATA_TYPE_ID_DATA_APPROVAZIONE =  415;
	public static final int  DATA_TYPE_ID_CONCESSE_DA =  420;
	public static final int  DATA_TYPE_ID_STATO =  425;
	
	//INIZIO  Fascicolo 2.1 2015-05-07
	public static final int  DATA_TYPE_ENTE_CONCEDENTE_DESCRIZIONE  =  421;
	public static final int  DATA_TYPE_ENTE_CONCEDENTE_CODICE_ENTE  =   422;
	public static final int  DATA_TYPE_ENTE_CONCEDENTE_CODICE_UFFICIO  =   423;
	public static final int  DATA_TYPE_ENTE_CONCEDENTE_TIPO_UFFICIO  =   424; 
	//FINE Fascicolo 2.1 2015-05-07
	 
	

	public PianoRateazioneDAOImpl(){
	}
	
	public PianoRateazioneDAOImpl(boolean autocommit, String origin)
			throws FaultType {
		super(autocommit, origin); 
	}
	private static Logger logger = Log4jFactory.getLogger(PianoRateazioneDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
//  2041_08_18 modifica_1  private String fascicoloID;
//  2041_08_18 modifica_1   private String callerID;
    private String INSERT_ENTITY_ITEM_QUERY;
    private String INSERT_DATA_VALUE_QUERY;

//	public String inserimentoPianoRateazioneInsert(InserimentoPianoRateazioneWSRequest request) throws FaultType {
//		return  inserimentoPianoRateazioneInsert(request.getPianoRateazione() , request.getFascicoloId(), request.getCallerId() );
//	}
    
	public void inserimentoPianoRateazioneInsert(
			PianoRateazioneType[] pianoRateazioneTypeArray, String fascicoloId,
			String callerId, EntityItem cartella, Connection connection) throws  Exception { 
	//inizio  2041_08_18 modifica_1
//		fascicoloID=fascicoloId;
//		callerID=callerId;
		setFascicoloId(fascicoloId);
		setCallerId(callerId);
	//fine  2041_08_18 modifica_1
		 
		boolean flagPresenzaPianiRateazioni=UtilsClass.isNotEmpty(pianoRateazioneTypeArray);
		if(!flagPresenzaPianiRateazioni){
			logger.info(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_PIANORATEAZIONE_VOID")); 
		}
		
		logger.debug("FascicoloId: "+getFascicoloId()+"\n");
		logger.debug("CAllerId: "+getCallerId()+"\n");
		
		
		
		
		logger.debug("Numero delle procedure da elaborare: "+pianoRateazioneTypeArray.length+"\n");


		for (int i = 0; i < pianoRateazioneTypeArray.length; i++) {
			entityItemInsert(connection, cartella.getEntityItemId());
			dataValueInsert(connection,pianoRateazioneTypeArray[i], cartella.getEntityItemId() );	
			
//INIZIO ModDocumentiAssociati
			if (pianoRateazioneTypeArray[i].getDocumentoAssociato()!=null 
					&& pianoRateazioneTypeArray[i].getDocumentoAssociato().length> 0 ) {
		    	DocumentoAssociatoDAO documentoAssociatoDAO = DAOFactory.getDocumentoAssociatoDAO(); 
		    	documentoAssociatoDAO.inserimentoDocumentoAssociatoPianoRateazioneInsert(pianoRateazioneTypeArray[i].getDocumentoAssociato(), fascicoloId, callerId, entityItemId, connection);				
			} 
//fine ModDocumentiAssociati 
			
//INIZIO Fascicolo 2.1 2015-05-07
			if (pianoRateazioneTypeArray[i].getRata()!=null 
					&& pianoRateazioneTypeArray[i].getRata().length> 0 ) {
				RataPianoRateazioneDAO rataPianoRateazioneDAO = DAOFactory.getRataPianoRateazioneDAO();
				rataPianoRateazioneDAO.inserimentoRatePianoRateazioneInsert(pianoRateazioneTypeArray[i].getRata(), fascicoloId, callerId, entityItemId, connection);				
			} 
//FINE Fascicolo 2.1 2015-05-07
			
		} 
 
	}
	
	private int entityItemId = 0;
	
	private void entityItemInsert(Connection connection, int parentEntityItemId) throws Exception{ 
		String entityItemeInsertQuery=buildEntityItemInsert(parentEntityItemId);
		PreparedStatementWrapper preparedStatement = null;
		try {
			preparedStatement = PreparedStatementWrapper.prepareStatement(connection, entityItemeInsertQuery,new String[]{"ENTITYITEMID"});
			preparedStatement.executeQuery();
			ResultSet rs =  preparedStatement.getGeneratedKeys();
			if(rs.next()){
				entityItemId=rs.getInt(1);
			} else{
				throw new Exception( MessagesClass.getMessage("ERROR_GENERATED_KEYS") );
			}
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT" )+ e.getMessage());
			e.printStackTrace();
			throw e;
		}  
	}
	
	private String buildEntityItemInsert( int parentEntityItemId) throws FaultType{
		INSERT_ENTITY_ITEM_QUERY=EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_PIANI_DI_REATEAZIONE, 
				getFascicoloId(), //2041_08_18 modifica_1
				getCallerId(), //2041_08_18 modifica_1
				//modifica 2041_08_18  0, 0,
				parentEntityItemId);
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + INSERT_ENTITY_ITEM_QUERY);
		return INSERT_ENTITY_ITEM_QUERY;
		
	}
	
	//inizio 06/11/2014	 sostituisco gli statement creati da stringa con i preparedstatement usati propriamente per il problema delle stringhe che includono apici
	public void dataValueInsert(Connection connection,PianoRateazioneType pianoRateazione, int cartellaEntityItemId) throws Exception{
 

		PreparedStatementWrapper preparedStatementWrapper = null;
		try {

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
			
			//N°Protocollo 
			executeInsertDatavalue(DATA_TYPE_ID_N_PROTOCOLLO, entityItemId, pianoRateazione.getProtocollo(), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			   
			//Data Approvazione 
			executeInsertDatavalue(DATA_TYPE_ID_DATA_APPROVAZIONE, entityItemId, UtilsClass.checkDataStandard(pianoRateazione.getDataApprovazione()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Concesse da 
			executeInsertDatavalue(DATA_TYPE_ID_CONCESSE_DA, entityItemId, CodificaDocumento.getConcesseDa(pianoRateazione), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			 
			//Stato 
			executeInsertDatavalue(DATA_TYPE_ID_STATO, entityItemId, CodificaDocumento.getStato(pianoRateazione), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
 

			//INIZIO  Fascicolo 2.1 2015-05-07 
			executeInsertDatavalue(DATA_TYPE_ENTE_CONCEDENTE_DESCRIZIONE , entityItemId, pianoRateazione.getEnteConcedente().getDescrizione() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ENTE_CONCEDENTE_CODICE_ENTE , entityItemId, pianoRateazione.getEnteConcedente().getCodiceEnte() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ENTE_CONCEDENTE_CODICE_UFFICIO , entityItemId, pianoRateazione.getEnteConcedente().getCodiceUfficio() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ENTE_CONCEDENTE_TIPO_UFFICIO , entityItemId, pianoRateazione.getEnteConcedente().getTipoUfficio() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			//FINE  Fascicolo 2.1 2015-05-07 
			
			
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	  
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		}  
		 
	}
	
//	public String buildNumeroProtocolloInsert(PianoRateazioneType pianoRateazione, int cartellaEntityItemId) throws Exception{
//		String numeroProtocollo=pianoRateazione.getProtocollo();
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_N_PROTOCOLLO, entityItemId, 0, cartellaEntityItemId, numeroProtocollo); //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildDataApprovazioneInsert(PianoRateazioneType pianoRateazione, int cartellaEntityItemId) throws Exception{
//		String dataApprovazione=UtilsClass.checkDataStandard(pianoRateazione.getDataApprovazione());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_DATA_APPROVAZIONE, entityItemId, 0, cartellaEntityItemId, dataApprovazione);  //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildConcesseDaInsert(PianoRateazioneType pianoRateazione, int cartellaEntityItemId) throws Exception{
//		String concesseDa=CodificaDocumento.getConcesseDa(pianoRateazione);
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_CONCESSE_DA, entityItemId, 0, cartellaEntityItemId, concesseDa);  //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildStatoInsert(PianoRateazioneType pianoRateazione, int cartellaEntityItemId) throws Exception{
//		String stato=CodificaDocumento.getStato(pianoRateazione);
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_STATO, entityItemId, 0, cartellaEntityItemId, stato);	  //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
	//fine 06/11/2014	

	public void inserimentoPianoRateazioneInsert( PianoRateazioneType[] pianoRateazioneTypeArray, String fascicoloId, String callerId, EntityItem cartella) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			inserimentoPianoRateazioneInsert(pianoRateazioneTypeArray, fascicoloId, callerId, cartella, conn );
		} finally {
			closeConnection();
		}
		
	}
    
	

}

