package it.equitalia.gestorefascicolows.dao.impl;

import java.sql.Connection; 
import java.sql.ResultSet; 
import org.apache.log4j.Logger;

import it.equitalia.gestorefascicolows.dao.DAOFactory; 
import it.equitalia.gestorefascicolows.dao.DocumentoAssociatoDAO;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.ProceduraDAO;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.InserimentoProceduraWSRequest;
import it.equitalia.gestorefascicolows.dati.ProceduraType;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;

public class ProceduraDAOImpl extends EntityItemClass implements ProceduraDAO {
	public static final int  DATA_TYPE_ID_TIPO_PROCEDURA = 310;
	public static final int  DATA_TYPE_ID_DATA_ATTIVAZIONE = 315;
	//INIZIO Fascicolo 2.1 2015-05-07
	public static final int  DATA_TYPE_ID_CODICE_FISCALE  = 320;
	public static final int  DATA_TYPE_ID_PROCEDURA_ID = 322;
	public static final int  DATA_TYPE_ID_ANNO_PROCEDURA = 324;
	public static final int  DATA_TYPE_ID_CODICE_TIPO_PROCEDURA = 326;
	public static final int  DATA_TYPE_ID_DATA_CHIUSURA_PROCEDURA = 330;
	public static final int  DATA_TYPE_ID_STATO_PROCEDURA = 332; 
	//FINE Fascicolo 2.1 2015-05-07
	
	
	   

	private static Logger logger = Log4jFactory.getLogger(ProceduraDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
  //2041_08_18 modifica_1    private String fascicoloID;
  //2041_08_18 modifica_1    private String callerID;
    private String INSERT_ENTITY_ITEM_QUERY;
    private String INSERT_DATA_VALUE_QUERY;
    

	public ProceduraDAOImpl() {
	}

    
	public ProceduraDAOImpl(boolean autocommit, String origin) throws FaultType {
		super(autocommit, origin);
	}


//	public String inserimentoProceduraInsert( InserimentoProceduraWSRequest request) throws FaultType {
//		return inserimentoProceduraInsert(request.getProcedura(),request.getFascicoloId(),request.getCallerId());
//	}
//	
	
	public void inserimentoProceduraInsert(ProceduraType[] proceduraTypeArray, String fascicoloId, String callerId, EntityItem cartella, Connection connection) throws  Exception  { 
		//inizio 2041_08_18 modifica_1 
//		this.fascicoloID = fascicoloId; 
//	    this.callerID = callerId; 
		setFascicoloId(fascicoloId);
		setCallerId(callerId);
		//fine 2041_08_18 modifica_1  
		
		boolean flagPresenzaProcedure=UtilsClass.isNotEmpty(proceduraTypeArray);
		if(!flagPresenzaProcedure){
			logger.info(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_PROCEDURA_VOID")); 
		}
		
		logger.debug("FascicoloId: "+getFascicoloId()+"\n");
		logger.debug("CallerId: "+getCallerId()+"\n"); 
		logger.debug("Numero delle procedure da elaborare: "+proceduraTypeArray.length+"\n");
 
		for (int i = 0; i < proceduraTypeArray.length; i++) {
			entityItemInsert(connection, cartella.getEntityItemId() );
			dataValueInsert(connection,proceduraTypeArray[i], cartella.getEntityItemId());	
			 
			//INIZIO ModDocumentiAssociati
			if (proceduraTypeArray[i].getDocumentoAssociato()!=null 
					&& proceduraTypeArray[i].getDocumentoAssociato().length> 0 ) {
		    	DocumentoAssociatoDAO documentoAssociatoDAO = DAOFactory.getDocumentoAssociatoDAO(); 
		    	documentoAssociatoDAO.inserimentoDocumentoAssociatoProceduraInsert(proceduraTypeArray[i].getDocumentoAssociato(), fascicoloId, callerId, entityItemId, connection);				
			} 
			//fine ModDocumentiAssociati
			
		}  
		logger.debug(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_PROCEDURA_OK"));  
		 
		
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
	
	private String buildEntityItemInsert(int parentEntityItemId) throws FaultType{
		INSERT_ENTITY_ITEM_QUERY=EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_PROCEDURE, 
				getFascicoloId(), //2041_08_18 modifica_1 
				getCallerId(), 		//2041_08_18 modifica_1 
				//modifica 2041_08_18  0, 0, 
				parentEntityItemId);
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + INSERT_ENTITY_ITEM_QUERY);
		return INSERT_ENTITY_ITEM_QUERY;
		
	}
	
	//inizio 06/11/2014	 sostituisco gli statement creati da stringa con i preparedstatement usati propriamente per il problema delle stringhe che includono apici
	public void dataValueInsert(Connection connection,ProceduraType procedura, int cartellaEntityItemId) throws Exception{

		PreparedStatementWrapper preparedStatementWrapper = null;
		try { 

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
			
			//Tipo procedura
			executeInsertDatavalue(DATA_TYPE_ID_TIPO_PROCEDURA, entityItemId,procedura.getTipoProcedura().getDescrizioneTipoProcedura(), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			   
			//Data attivazione
			executeInsertDatavalue(DATA_TYPE_ID_DATA_ATTIVAZIONE, entityItemId, UtilsClass.getDataStandard(procedura.getDataApertura()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
 
			//INIZIO Fascicolo 2.1 2015-05-07
			executeInsertDatavalue(DATA_TYPE_ID_CODICE_FISCALE , entityItemId, procedura.getCodiceFiscale() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_PROCEDURA_ID , entityItemId, procedura.getIdProcedura() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_ANNO_PROCEDURA , entityItemId, procedura.getAnnoProcedura() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_CODICE_TIPO_PROCEDURA , entityItemId, procedura.getTipoProcedura().getCodiceTipoProcedura() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_DATA_CHIUSURA_PROCEDURA , entityItemId,UtilsClass.getDataStandard( procedura.getDataChiusura() ), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_STATO_PROCEDURA , entityItemId, procedura.getStatoProcedura()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
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
	
//	public String buildTipoProceduraInsert(ProceduraType procedura, int cartellaEntityItemId) throws Exception{
//		String tipoProcedura=procedura.getTipoProcedura().getDescrizioneTipoProcedura();	
//		INSERT_DATA_VALUE_QUERY= buildDataValueInsert(DATA_TYPE_ID_TIPO_PROCEDURA, entityItemId, 0, cartellaEntityItemId, tipoProcedura); //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildDataAttivazioneInsert(ProceduraType procedura, int cartellaEntityItemId) throws Exception {
//		String dataAttivazione=UtilsClass.getDataStandard(procedura.getDataApertura());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_DATA_ATTIVAZIONE, entityItemId, 0, cartellaEntityItemId, dataAttivazione);	 //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
	//fine 06/11/2014


	public void inserimentoProceduraInsert(ProceduraType[] proceduraTypeArray, String fascicoloId, String callerId, EntityItem cartella) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			inserimentoProceduraInsert(proceduraTypeArray, fascicoloId, callerId, cartella, conn );
		} finally {
			closeConnection();
		}
		
	}

}
