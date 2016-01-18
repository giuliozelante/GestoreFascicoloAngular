package it.equitalia.gestorefascicolows.dao.impl;

import java.sql.Connection; 
import java.sql.ResultSet; 

import org.apache.log4j.Logger;
 
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.RataDAO;
import it.equitalia.gestorefascicolows.dati.EntityItem; 
import it.equitalia.gestorefascicolows.dati.RataType;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;



/**
 *    creata per la modifica_08/10/2014 
 *
 */
public class RataDAOImpl extends EntityItemClass implements RataDAO{
	private static Logger logger = Log4jFactory.getLogger(RataDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
    
    
	public static final int  DATA_TYPE_ID_PROGRESSIVO_RATA  =  51	 ; 
	public static final int  DATA_TYPE_ID_DATA_SCADENZA =  52 ;
	public static final int  DATA_TYPE_ID_IMPORTO =  53; 
	public static final int  DATA_TYPE_ID_NUMERO_RAV =  54; 
	public static final int  DATA_TYPE_ID_STATO_RATA =  55; 



	public RataDAOImpl(){
	}
	
	public RataDAOImpl(boolean autocommit, String origin) throws FaultType {
		super(autocommit, origin); 
	}
	
	
	
	
	
	public void inserimentoRata(RataType[] rate, String fascicoloId, String callerId, EntityItem cartella, Connection connection) throws Exception { 
		
		try {

			int rataEntityItemId;
			
			setFascicoloId(fascicoloId);
			setCallerId(callerId); 
			  
			checkData(rate);
			
			logger.debug("FascicoloId: "+getFascicoloId()+"\n");
			logger.debug("CallerId: "+getCallerId()+"\n"); 
			logger.debug("Numero delle rate da elaborare: "+ rate.length+"\n");


			for (int i = 0; i < rate.length; i++) {
				rataEntityItemId = entityItemInsert(connection, cartella.getEntityItemId()); 
				dataValueInsert(connection, rate[i], rataEntityItemId, cartella.getEntityItemId() );  
			}

			logger.debug(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_RATE_OK")); 
			
		} catch (Exception e) {
			errorLogger.error("",e);
			throw e;
		}
		  
	}

	
//inizio 06/11/2014	 sostituisco gli statement creati da stringa con i preparedstatement usati propriamente per il problema delle stringhe che includono apici
	public void dataValueInsert(Connection connection, RataType rata, int rataEntityItemId, int cartellaEntityItemId ) throws Exception{
		 
		PreparedStatementWrapper preparedStatementWrapper = null;
		try { 

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
			
			
			executeInsertDatavalue(DATA_TYPE_ID_PROGRESSIVO_RATA, rataEntityItemId,  String.valueOf( rata.getProgressivoRata() ), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			executeInsertDatavalue(DATA_TYPE_ID_DATA_SCADENZA, rataEntityItemId,  rata.getDataScadenza(), getFascicoloId(), getCallerId(), preparedStatementWrapper, false); 
			 
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO, rataEntityItemId,  String.valueOf(  rata.getImportoRata() ), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			  
			executeInsertDatavalue(DATA_TYPE_ID_NUMERO_RAV, rataEntityItemId,  rata.getNumeroRav() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
		  
			executeInsertDatavalue(DATA_TYPE_ID_STATO_RATA, rataEntityItemId,  CodificaDocumento.getStatoRata(rata), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
		  
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	  
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		}  
		   
		 
	}
	//fine 06/11/2014		
	

	private int entityItemInsert(Connection connection, int parentEntityItemId) throws Exception{
		int entityItemId = -1;
		String entityItemeInsertQuery= EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_RATE, 
				getFascicoloId(),  
				getCallerId(),   
				parentEntityItemId );
			
			 
		PreparedStatementWrapper preparedStatement = null;
		try {
			preparedStatement = PreparedStatementWrapper.prepareStatement(connection, entityItemeInsertQuery, new String[]{"ENTITYITEMID"} );
			   
			preparedStatement.executeQuery();
			
			ResultSet rs =  preparedStatement.getGeneratedKeys();
			
			if(rs !=null && rs.next()){
				entityItemId = rs.getInt(1);
			} else{
				throw new Exception( MessagesClass.getMessage("ERROR_GENERATED_KEYS") );
			}
			
		} finally { 
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
		} 
		
		
		return entityItemId;
	}
	
	
	private void checkData(RataType[] rate) throws FaultType, NumberFormatException, Exception { 
		if(!UtilsClass.isNotEmpty(rate)){  
			throw new Exception(  MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_RATE_VOID") );
				 
		}
		
	}

	public void inserimentoRata(RataType[] rateOrigine, String fascicoloId, String callerId, EntityItem cartella) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			inserimentoRata(rateOrigine, fascicoloId, callerId, cartella, conn );
		} finally {
			closeConnection();
		}
		
		
	}

}
