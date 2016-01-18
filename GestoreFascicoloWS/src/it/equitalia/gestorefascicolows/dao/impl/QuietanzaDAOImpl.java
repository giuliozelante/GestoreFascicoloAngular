package it.equitalia.gestorefascicolows.dao.impl;
 
import it.equitalia.gestorefascicolows.bl.DBFactory;
import it.equitalia.gestorefascicolows.dao.DAOFactory; 
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper; 
import it.equitalia.gestorefascicolows.dao.QuietanzaDAO;
import it.equitalia.gestorefascicolows.dao.TributoQuietanzaDAO;
import it.equitalia.gestorefascicolows.dati.EntityItem; 
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;
 
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType;
import it.equitalia.dettagliocartellaavviso.wsdl.TributoQuietanzaType;

import org.apache.log4j.Logger;


/**
 *  FASCICOLO_2.1
 */
public class QuietanzaDAOImpl extends EntityItemClass implements QuietanzaDAO {
	public static final int  DATA_TYPE_ID_NUMERO_QUIETANZA = 501;
	public static final int  DATA_TYPE_ID_TIPO_PAGAMENTO = 502;
	public static final int  DATA_TYPE_ID_CANALE_PAGAMENTO = 503;
	public static final int  DATA_TYPE_ID_DATA_PAGAMENTO = 504;
	public static final int  DATA_TYPE_ID_IMPORTO_QUIETANZA = 505;
	public static final int  DATA_TYPE_ID_QUIETANZA_ANNULLATA = 506;
	public static final int  DATA_TYPE_ID_DATA_ANNULLAMENTO = 507;
	public static final int  DATA_TYPE_ID_CODICE_FISCALE_VERSANTE = 508;
	public static final int  DATA_TYPE_ID_IMPORTO_TRIBUTI = 509;
	public static final int  DATA_TYPE_ID_IMPORTO_INTERESSI_MORA = 510;
	public static final int  DATA_TYPE_ID_IMPORTO_COMPENSI = 511;
	public static final int  DATA_TYPE_ID_IMPORTO_DIRITTI_DI_NOTIFICA = 512;
	public static final int  DATA_TYPE_ID_IMPORTO_SPESE = 513; 


	private static Logger logger = Log4jFactory.getLogger(QuietanzaDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();


	private int entityItemId = 0; 
    

	public QuietanzaDAOImpl() {
	}

    
	public QuietanzaDAOImpl(boolean autocommit, String origin) throws FaultType {
		super(autocommit, origin);
	}


	public void inserimentoQuietanze(QuietanzaType[] quietanzaTypeArray, String fascicoloId, String callerId, EntityItem cartella, Connection connection) throws Exception { 
		setFascicoloId(fascicoloId);
		setCallerId(callerId);  
		 
		if(UtilsClass.isNotEmpty(quietanzaTypeArray)){
			logger.debug("FascicoloId: "+getFascicoloId()+"\n");
			logger.debug("CallerId: "+getCallerId()+"\n");  
			logger.debug("Numero delle quietanze da elaborare: "+ quietanzaTypeArray.length+"\n");

			
			for (int i = 0; i < quietanzaTypeArray.length; i++) {
				entityItemInsert(connection, cartella.getEntityItemId() );
				dataValueInsert(connection, quietanzaTypeArray[i] );	 
				 
				if (quietanzaTypeArray[i].getTributiQuietanza()!=null 
						&& quietanzaTypeArray[i].getTributiQuietanza().length> 0 ) {
					
					TributoQuietanzaType[] tributi = quietanzaTypeArray[i].getTributiQuietanza();
					
					for (int iTributi = 0; iTributi < tributi.length; iTributi++) {
						TributoQuietanzaDAO tributoQuietanzaDAO = DAOFactory.getTributoQuietanzaDAO(true, DBFactory.ORIGINE_ORACLE); 
						TributoQuietanzaType tributoQuietanzaType = tributi[iTributi];
						tributoQuietanzaDAO.inserimentoTributoQuietanza(tributoQuietanzaType, fascicoloId, callerId, entityItemId);		
					}
							
				}  
				
			}  
			 
		} else{ 
			logger.debug("Nessuna quietanza da elaborare");
		} 
		
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
		INSERT_ENTITY_ITEM_QUERY=EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_QUIETANZE, 
				getFascicoloId(),  
				getCallerId(), 		 
				parentEntityItemId);
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + INSERT_ENTITY_ITEM_QUERY);
		return INSERT_ENTITY_ITEM_QUERY;
		
	}

	
	public void dataValueInsert(Connection connection,QuietanzaType quietanzaType) throws Exception{

		PreparedStatementWrapper preparedStatementWrapper = null;
		try { 

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
 
			
			executeInsertDatavalue(DATA_TYPE_ID_NUMERO_QUIETANZA, entityItemId, String.valueOf(quietanzaType.getNumeroQuietanza().intValue()) , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_TIPO_PAGAMENTO, entityItemId, quietanzaType.getTipoPagamento() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_CANALE_PAGAMENTO, entityItemId, quietanzaType.getCanalePagamento() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_DATA_PAGAMENTO, entityItemId, quietanzaType.getDataPagamento() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_QUIETANZA, entityItemId, quietanzaType.getImportoQuietanza().doubleValue() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_QUIETANZA_ANNULLATA, entityItemId, CodificaDocumento.getQuietanzaAnnullata(quietanzaType) , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);

			//Inizio modifica 25/3/2015 - AB
			String dataAnnullamento=UtilsClass.getDataStandard(quietanzaType.getDataAnnulloQuietanza());
			if (dataAnnullamento.equals("0001-01-01")){
				dataAnnullamento="";
			}			
			executeInsertDatavalue(DATA_TYPE_ID_DATA_ANNULLAMENTO, entityItemId, dataAnnullamento , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			//Fine modifica 25/3/2015 - AB
			executeInsertDatavalue(DATA_TYPE_ID_CODICE_FISCALE_VERSANTE, entityItemId, quietanzaType.getCodiceFiscaleVersante() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_TRIBUTI, entityItemId, quietanzaType.getImportoTributi().doubleValue() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_INTERESSI_MORA, entityItemId, quietanzaType.getImportoInteressiMora().doubleValue() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_COMPENSI, entityItemId, quietanzaType.getImportoCompensi().doubleValue() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_DIRITTI_DI_NOTIFICA, entityItemId, quietanzaType.getImportoDirittiNotifica().doubleValue() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_SPESE, entityItemId, quietanzaType.getImportoSpese().doubleValue() , getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			    
			
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	  
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		}   
	}
	 

	private void executeInsertDatavalue(int dataTypeId,
			int entityItemId2, Date value, String fascicoloId,
			String callerId, PreparedStatementWrapper preparedStatementWrapper,
			boolean refresh) throws Exception {
		executeInsertDatavalue(dataTypeId, entityItemId2, CodificaDocumento.getDate( value), fascicoloId, callerId, preparedStatementWrapper, refresh);
		
	}


	private void executeInsertDatavalue(int dataTypeIdNumeroQuietanza, int entityItemId2, double d, String fascicoloId, String callerId, PreparedStatementWrapper preparedStatementWrapper, boolean refresh) throws Exception {
		executeInsertDatavalue(dataTypeIdNumeroQuietanza, entityItemId2, CodificaDocumento.getImporto( d), fascicoloId, callerId, preparedStatementWrapper, refresh);
	}


	public void inserimentoQuietanze(QuietanzaType[] quietanzaTypeArray, String fascicoloId, String callerId, EntityItem cartella) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			inserimentoQuietanze(quietanzaTypeArray, fascicoloId, callerId, cartella, conn );
		} finally {
			closeConnection();
		}
		
	}

}

