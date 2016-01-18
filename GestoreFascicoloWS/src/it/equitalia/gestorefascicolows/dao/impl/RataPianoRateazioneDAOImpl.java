package it.equitalia.gestorefascicolows.dao.impl;

import java.sql.Connection; 
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.RataPianoRateazioneDAO;
import it.equitalia.gestorefascicolows.dati.ProceduraType;
import it.equitalia.gestorefascicolows.dati.RataType;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;

/**
 *   Fascicolo 2.1 2015-05-07
 *
 */
public class RataPianoRateazioneDAOImpl extends EntityItemClass implements RataPianoRateazioneDAO{ 
	public static final int  DATA_TYPE_ID_PROGRASSIVO_RATA = 461;
	public static final int  DATA_TYPE_ID_DATA_SCADENZA = 462;
	public static final int  DATA_TYPE_ID_IMPORTO = 463;
	public static final int  DATA_TYPE_ID_NUMERO_RAV = 464;
	public static final int  DATA_TYPE_ID_STATO_RATA = 465;
	 
	private static Logger logger = Log4jFactory.getLogger(DocumentoAssociatoDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
	private int entityItemId = 0;
	
	
	public void inserimentoRatePianoRateazioneInsert(RataType[] rate,
			String fascicoloId, String callerId, int parentEntityItemId,
			Connection connection) throws Exception {

		setFascicoloId(fascicoloId);
		setCallerId(callerId);
		  
		logger.debug("Numero delle rate associate ai piani di reateazione: "+ rate.length+"\n");
 
		for (int i = 0; i < rate.length; i++) {
			rataEntityItemInsert(connection,   parentEntityItemId );    
			rataDataValueInsert(connection, rate[i]   );	
			
		}  
	} 
	

	private void rataEntityItemInsert(Connection connection, int parentEntityItemId) throws Exception{ 
		String entityItemeInsertQuery=buildRataEntityItemInsert(parentEntityItemId);
		PreparedStatementWrapper preparedStatement = null; 
		preparedStatement = PreparedStatementWrapper.prepareStatement(connection, entityItemeInsertQuery,new String[]{"ENTITYITEMID"});
		preparedStatement.executeQuery();
		ResultSet rs =  preparedStatement.getGeneratedKeys();
		if(rs.next()){
			entityItemId=rs.getInt(1);
		} else{
			throw new Exception( MessagesClass.getMessage("ERROR_GENERATED_KEYS") );
		}
	}
	

	private String buildRataEntityItemInsert( int parentEntityItemId) throws FaultType{
		String res = EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_RATE_PIANI_DI_RATEAZIONE, 
													getFascicoloId(),  
													getCallerId(),   
													parentEntityItemId);
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + res);
		return res;
		
	}
	
	
	public void rataDataValueInsert(Connection connection,RataType rataType   ) throws Exception{

		PreparedStatementWrapper preparedStatementWrapper = null;
		try { 

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  

			executeInsertDatavalue( DATA_TYPE_ID_PROGRASSIVO_RATA,  entityItemId, String.valueOf(rataType.getProgressivoRata() ) , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue( DATA_TYPE_ID_DATA_SCADENZA, entityItemId,rataType.getDataScadenza() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue( DATA_TYPE_ID_IMPORTO, entityItemId, String.valueOf( rataType.getImportoRata() ), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue( DATA_TYPE_ID_NUMERO_RAV, entityItemId,rataType.getNumeroRav() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue( DATA_TYPE_ID_STATO_RATA, entityItemId, CodificaDocumento.getStatoRata(rataType)  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false); //bug3996
			       
			
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	  
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		}   
	}
}
  