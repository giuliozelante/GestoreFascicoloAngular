package it.equitalia.gestorefascicolows.dao.impl;

import java.math.BigInteger;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
 
import it.equitalia.dettagliocartellaavviso.wsdl.TributoQuietanzaType;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.TributoQuietanzaDAO;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass; 

public class TributoQuietanzaDAOImpl extends EntityItemClass implements TributoQuietanzaDAO {

	private static Logger logger = Log4jFactory.getLogger(TributoQuietanzaDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
	
	public static final int  DATA_TYPE_ID_CODICE_TRIBUTO  =551;
	public static final int  DATA_TYPE_ID_DESCRIZIONE_TRIBUTO =552;
	public static final int  DATA_TYPE_ID_PROGRESSIVO_TRIBUTO =553;
	public static final int  DATA_TYPE_ID_ANNO_TRIBUTO =554;
	public static final int  DATA_TYPE_ID_ANNO_RUOLO =555;
	public static final int  DATA_TYPE_ID_NUMERO_RUOLO =556;
	public static final int  DATA_TYPE_ID_CODICE_ENTE=557;
	public static final int  DATA_TYPE_ID_TIPO_UFFICIO   =558;
	public static final int  DATA_TYPE_ID_CODICE_UFFICIO =559;
	public static final int  DATA_TYPE_ID_IMPORTO_TOTALE=560;
	public static final int  DATA_TYPE_ID_IMPORTO_TRIBUTO=561;
	public static final int  DATA_TYPE_ID_IMPORTO_INTERESSI_DI_MORA =562;
	public static final int  DATA_TYPE_ID_IMPORTO_COMPENSI =563;
	public static final int  DATA_TYPE_ID_IMPORTO_DIRITTI_DI_NOTIFICA=564;
	public static final int  DATA_TYPE_ID_IMPORTO_SPESE  =565;
	

	private int entityItemId = 0; 
 
	
	public TributoQuietanzaDAOImpl(boolean autocommit, String origin) throws FaultType{
		super(autocommit, origin);
	}
	
	public void inserimentoTributoQuietanza( TributoQuietanzaType tributoQuietanzaType, String fascicoloId, String callerId, int parentEntityItemId  ) throws Exception {
		Connection conn = getConnection();
		try { 
			setFascicoloId(fascicoloId);
			setCallerId(callerId);  
			entityItemInsert(conn, parentEntityItemId );
			dataValueInsert(conn, tributoQuietanzaType );	  
		} finally {
			closeConnection();
		}
			  
	}  
	
	private void dataValueInsert(Connection connection, TributoQuietanzaType tributoQuietanzaType) throws Exception {

		PreparedStatementWrapper preparedStatementWrapper = null;
		try { 

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
  

			executeInsertDatavalue(DATA_TYPE_ID_CODICE_TRIBUTO, entityItemId, tributoQuietanzaType.getCodiceTributo()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_DESCRIZIONE_TRIBUTO, entityItemId, tributoQuietanzaType.getDescrizioneTributo()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_PROGRESSIVO_TRIBUTO, entityItemId, tributoQuietanzaType.getProgressivoTributo()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_ANNO_TRIBUTO, entityItemId, tributoQuietanzaType.getAnnoTributo()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_ANNO_RUOLO, entityItemId, tributoQuietanzaType.getAnnoRuolo()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_NUMERO_RUOLO, entityItemId, tributoQuietanzaType.getNumeroRuolo()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_CODICE_ENTE, entityItemId, tributoQuietanzaType.getCodiceEnte()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_TIPO_UFFICIO, entityItemId, tributoQuietanzaType.getTipoUfficio()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_CODICE_UFFICIO, entityItemId, tributoQuietanzaType.getCodiceUfficio()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_TOTALE, entityItemId, calcolaImportoTotale(tributoQuietanzaType)  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_TRIBUTO, entityItemId, tributoQuietanzaType.getImportoTributi().doubleValue()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_INTERESSI_DI_MORA, entityItemId, tributoQuietanzaType.getImportoInteressiMora().doubleValue()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_COMPENSI, entityItemId, tributoQuietanzaType.getImportoCompensi().doubleValue()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_DIRITTI_DI_NOTIFICA, entityItemId, tributoQuietanzaType.getImportoDirittiNotifica().doubleValue()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_SPESE, entityItemId, tributoQuietanzaType.getImportoSpese().doubleValue()  , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			 
		
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	  
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		}   
	}
 
	private double calcolaImportoTotale(TributoQuietanzaType tributoQuietanzaType) {
			  return 	  tributoQuietanzaType.getImportoTributi() .add(
					  tributoQuietanzaType.getImportoInteressiMora()
			  ).add(
					  tributoQuietanzaType.getImportoCompensi()  
			  ).add(
					  tributoQuietanzaType.getImportoDirittiNotifica()	  
			  ).add(
					  tributoQuietanzaType.getImportoSpese() 
			  )  .doubleValue() ; 
	}

	private void executeInsertDatavalue(int dataTypeId,
			int entityItemId2, double d, String fascicoloId,
			String callerId, PreparedStatementWrapper preparedStatementWrapper,
			boolean refresh) throws Exception {
		executeInsertDatavalue(dataTypeId, entityItemId2, CodificaDocumento.getImporto(d), fascicoloId, callerId, preparedStatementWrapper, refresh);
		
	}

	private void executeInsertDatavalue(int dataTypeId,
			int entityItemId2, BigInteger bigInteger,
			String fascicoloId, String callerId,
			PreparedStatementWrapper preparedStatementWrapper, boolean refresh) throws Exception {
		executeInsertDatavalue(dataTypeId, entityItemId2, String.valueOf( bigInteger.intValue()) , fascicoloId, callerId, preparedStatementWrapper, refresh);
		
	}

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
		} catch (SQLException e) {
			errorLogger.error(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT" )+ e.getMessage());
			e.printStackTrace();
			throw e;
		}  
	}
	
	private String buildEntityItemInsert(int parentEntityItemId) throws FaultType{
	    String INSERT_ENTITY_ITEM_QUERY; 
		INSERT_ENTITY_ITEM_QUERY=EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_TRIBUTI_QUIETANZE, 
				getFascicoloId(), 
				getCallerId(), 		 
				parentEntityItemId);
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + INSERT_ENTITY_ITEM_QUERY);
		return INSERT_ENTITY_ITEM_QUERY;
		
	}
	
}
