package it.equitalia.gestorefascicolows.dao;
 
import it.equitalia.gestorefascicolows.bl.DBFactory;
import it.equitalia.gestorefascicolows.dao.impl.CartellaDAOImpl;
import it.equitalia.gestorefascicolows.dati.DataValue;
import it.equitalia.gestorefascicolows.dati.DataValueWrapper;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.srv.FaultType;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap; 
import java.util.Map;

import org.apache.log4j.Logger;  

public class EntityDAO extends DaoHandler{
	public static final int ENTITY_ID_CARTELLA = 1;	// valore ufficiale 1; per test usare i valore 6 
	public static final int ENTITY_ID_TRIBUTO = 100 ;	 
	public static final int ENTITY_ID_DOCUMENTO_ESATTORIALE =  200;	 
	public static final int ENTITY_ID_PROCEDURA = 300 ;	 
	public static final int ENTITY_ID_PIANO_DI_RATEAZIONE = 400 ;	 
	public static final int LIVELLO_MAX = -1;	
	 
 
	static HashMap<Integer, Integer> persistenceLevelPerDataTypeId = new HashMap<Integer, Integer>();

	
	static Logger logger = Logger.getLogger(EntityDAO.class);
	static final String ORACLE_ORIGIN ="ora";
	
	public EntityDAO(boolean autoCommit, String origin) throws FaultType {
		super(autoCommit, origin); 
	}

	public EntityDAO() throws FaultType {
		super(true, ORACLE_ORIGIN); 
	}
 

	static public  EntityItem[] getEntityItems(
			String fascicoloId,
			String callerId,
			Integer entityId, int level, Connection conn ) throws Exception { 
		
		EntityItem[] result = new EntityItem[0]; 
			
		try { 
			result = getEntityItems(fascicoloId, callerId, entityId, null, conn,   level, true);
 
		} catch (Exception e) {
			logger.error("",e);
			throw e;
		} 
		
		
		return result;
	}

	static private EntityItem[] getEntityItems(String fascicoloId, String callerId,
			Integer entityId, Integer parentEntityItemId, Connection conn, int level, boolean firstLevel) throws SQLException {
		
		EntityItem[] result;
		ArrayList<EntityItem> lista;
		 
		
		if (firstLevel) { 
			lista = selectEntityItemLista(fascicoloId, callerId, entityId, null, conn);
		} else{ 
			lista = selectEntityItemLista(fascicoloId, callerId, null, parentEntityItemId, conn);
		}
		
		//correzione di bug evidenziato durante ModDocumentiAssociati: senza l'if seguente con LIVELLO_MAX non sarebbe sceso al secondo livello (utile invece per i documenti associati a piani rateaz. e procedure)
		if (level != LIVELLO_MAX) {	
			level--;	
		}
		
		for (EntityItem entityItem : lista) {
			addValues(entityItem, conn);
			if (level >0 || level == LIVELLO_MAX) {
				entityItem.setDetailEntityItems(
							getEntityItems(fascicoloId, callerId, null, entityItem.getEntityItemId(), conn, level, false)
							);
			}
		}
		
		result = lista.toArray(new EntityItem[0]);
		
		return result;
	}
	
	
	//inizio bug3780
	/**
	 * restituisce solo la gerarchia degli entity item discententi senza i data values valorizzati
	 *  
	 */
	static public EntityItem[] getEntityItemsDiscendenti(String fascicoloId, String callerId,
			 Integer parentEntityItemId, Connection conn, int level   ) throws SQLException {
		
		EntityItem[] result;
		ArrayList<EntityItem> lista;
		  
		lista = selectEntityItemLista(fascicoloId, callerId, null, parentEntityItemId, conn);
		 
		
		//correzione di bug evidenziato durante ModDocumentiAssociati: senza l'if seguente con LIVELLO_MAX non sarebbe sceso al secondo livello (utile invece per i documenti associati a piani rateaz. e procedure)
		if (level != LIVELLO_MAX) {	
			level--;	
		}
		
		for (EntityItem entityItem : lista) { 
			if (level >0 || level == LIVELLO_MAX) {
				entityItem.setDetailEntityItems(
							getEntityItems(fascicoloId, callerId, null, entityItem.getEntityItemId(), conn, level, false)
							);
			}
		}
		
		result = lista.toArray(new EntityItem[0]);
		
		return result;
	}
	//fine bug3780
	

//	private void addEntityItemChildren(String fascicoloId, String callerId, EntityItem entityItem, Connection conn) throws SQLException {
//
//		ArrayList<EntityItem> items = selectEntityItemLista(fascicoloId, callerId, null, entityItem.getEntityItemId(), conn);
//		for (EntityItem item : items) {
//			addValues(item, conn);
//		}
//		
//		entityItem.setDetailEntityItems(items.toArray(new EntityItem[0]) );
//	}

	static private void addValues(EntityItem entityItem, Connection conn) throws SQLException {

		ResultSet rs = null;
		PreparedStatementWrapper ps = null;
		ArrayList<DataValueWrapper> app = new ArrayList<DataValueWrapper>();
		
		try {
			String query =  "	SELECT  *											  "  +
							"	FROM GESTORE_FASCICOLO.DATATYPE DT                  "	  +
							"	  INNER JOIN GESTORE_FASCICOLO.DATAVALUE DV         "	  +
							"	    on DT.DATATYPEID = DV.DATATYPEID                "	  +
							"	      AND DV.ENTITYITEMID = ?                       "	 +
							"	      ORDER BY DV.DATATYPEID 						"	 ;
			
			 
			
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setInt(1, entityItem.getEntityItemId() );   
			
			rs = ps.executeQuery();
			
			HashMap<Integer, DataValueWrapper>  mappaDataValue = 
						new LinkedHashMap<Integer, DataValueWrapper>();//modifiche andate perse in Agosto
			
			if (rs!=null) {
				while ( rs.next() ) {
					DataValueWrapper dataValue = new DataValueWrapper();
					
					dataValue.setDataTypeDescr(rs.getString("DATATYPEDESCR") );
					dataValue.setDataTypeId(rs.getInt("DATATYPEID"))  ;
//				dataValue.setDataValueId(rs.getInt(""))  ;
					dataValue.setRenderingType(rs.getString("RENDERINGTYPE"))  ;
					dataValue.setTitleCssClass(rs.getString("TITLECSSCLASS"))  ;
					dataValue.setValue(rs.getString("VALUE"))  ;
					dataValue.setValueCssClass(rs.getString("VALUECSSCLASS"))  ; 
					dataValue.setParentDataTypeId(rs.getInt("PARENTDATATYPEID"));
					
					
					mappaDataValue.put(dataValue.getDataTypeId(), dataValue);
					
					if (dataValue.getParentDataTypeId() > 0) {
						DataValueWrapper parent = mappaDataValue.get(dataValue.getParentDataTypeId());
						parent.addDetailDataValues( dataValue);
					}
					
				}
				 
				for (DataValueWrapper value : mappaDataValue.values()) {
				    if ( value.getParentDataTypeId() <= 0) {
						app.add(value);
					} 
				    value.refreshDetailDataValues(); 
				}
				
				
				entityItem.setDataValues( convert( app.toArray( new DataValueWrapper[0] ) ) );
				
			}
			
			
		} finally{
			if (rs != null) {
				rs.close();
			} 
			if (ps != null) {
				ps.close();
			}
		} 
		
	}

	private static DataValue[] convert(DataValueWrapper[] inputArray) {
		DataValue[] result = new DataValue[inputArray.length];
		
		
		for (int i = 0; i < inputArray.length; i++) {
			DataValueWrapper wrap = inputArray[i];
			DataValue dataValue = new DataValue();

			dataValue.setDataTypeDescr(wrap.getDataTypeDescr()) ;
			dataValue.setDataTypeId(wrap.getDataTypeId()) ;
			dataValue.setDataValueId(wrap.getDataValueId()) ;
			dataValue.setDetailDataValues( convert( wrap.getDetailDataValues() ) ) ;
			dataValue.setRenderingType(wrap.getRenderingType()) ;
			dataValue.setTitleCssClass(wrap.getTitleCssClass()) ;
			dataValue.setValue(wrap.getValue()) ;
			dataValue.setValueCssClass(wrap.getValueCssClass()) ;
 			
			result[i] = dataValue;
		}
		
		return result;
	}

	static private ArrayList<EntityItem> selectEntityItemLista(String fascicoloId, String callerId, Integer entityId, Integer parentEntityItemId, Connection conn) throws SQLException { 
		ResultSet rs = null;
		PreparedStatementWrapper ps = null;
		ArrayList<EntityItem> result = new ArrayList<EntityItem>();
		
		try {
			String query =  " SELECT  *										" +	
							" FROM GESTORE_FASCICOLO.ENTITY e               " +	
							" INNER JOIN GESTORE_FASCICOLO.ENTITYITEM ei    " +	
							"  on ei.ENTITYID=e.ENTITYID                    " +	
							"                                               " +	
							" WHERE ei.FASCICOLOID= ?                 " +	
							"   AND  ei.CALLERID= ?                   ";	
			
			if (entityId != null) {
				query += 
					"   AND  e.ENTITYID = ?   ";	
			} else{
				query += 
					"   AND  ei.PARENTENTITYITEMID = ?   ";	 
			}
			query += " ORDER BY ei.ENTITYID ";
			
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setString(1, fascicoloId);
			ps.setString(2, callerId);
			if (entityId != null) {
				ps.setInt(3, entityId);
			} else{
				ps.setInt(3, parentEntityItemId); 
			}
			
			rs = ps.executeQuery();
			
			if (rs!=null) {
				while ( rs.next() ) {
					EntityItem entityItem = new EntityItem();
					entityItem.setEntityItemId(rs.getInt("ENTITYITEMID")); 
					entityItem.setEntityDescr(rs.getString("ENTITYDESCR")) ;
					entityItem.setEntityId(rs.getInt("ENTITYID")) ;
					//modifica 2041_08_18            					entityItem.setEntityItemRef(rs.getString("ENTITYITEMREF")); 
					entityItem.setRenderingType(rs.getString("RENDERINGTYPE"));  
					
					result.add(entityItem);
				}
			}
			
			
		} finally{
			if (rs != null) {
				rs.close();
			} 
			if (ps != null) {
				ps.close();
			}
		}
		
		return result;
	} 
	
	//bug 2015-03-15 aggiunto modificatore static
	public static EntityItem getEntityCartella(String fascicoloId, String callerId, String numeroCartella,  Connection conn) throws SQLException {
		
		int level = LIVELLO_MAX;
		EntityItem cartellaItem  = selectEntityDocumento( fascicoloId, callerId ,numeroCartella, conn, CartellaDAOImpl.N_CARTELLA   );
		if (cartellaItem!=null) { 
			addValues(cartellaItem, conn); 
			cartellaItem.setDetailEntityItems(
								getEntityItems(fascicoloId, callerId, null, cartellaItem.getEntityItemId(), conn, level, false)
								);  
		}
		return cartellaItem;
	}

	/**
	 * restituisce un'entity di tipo cartella o documento esattoriale
	 * @param fascicoloId
	 * @param callerId
	 * @param numeroCartella
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	
	public EntityItem getEntityDocumento(String fascicoloId, String callerId, String numeroDoc,  Connection conn, int level) throws SQLException {
		EntityItem docItem  = selectEntityDocumento( fascicoloId, callerId ,numeroDoc, conn, CartellaDAOImpl.N_CARTELLA,  CartellaDAOImpl.DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO  );
		if (docItem!=null) { 
			addValues(docItem, conn); 
			docItem.setDetailEntityItems(
								getEntityItems(fascicoloId, callerId, null, docItem.getEntityItemId(), conn, level, false)
								);  
		}
		return docItem;
	}
	

	public EntityItem getEntityDocumento(String fascicoloId, String callerId, String numeroDoc, int level) throws SQLException, FaultType {
		Connection conn = getConnection();
		//inizio bug 2015-03-15 mancava la chiusura della connessione
		EntityItem entityItem;
		try {
			entityItem = getEntityDocumento(fascicoloId, callerId, numeroDoc, conn, level);
		} finally { 
			closeConnection();
		}
		return entityItem;
		//fine bug 2015-03-15
		 
	}
	

	public int deleteDataValue(int entityItemId,   boolean soloCampiNonPersistenti  ) throws  Exception{

		Connection conn = null;
		try {
			conn = getConnection();
			return deleteDataValue(entityItemId, conn, soloCampiNonPersistenti);
		} finally {
			closeConnection();
		}
	}
	
	
	public static int deleteDataValue(int entityItemId, Connection conn, 
			boolean soloCampiNonPersistenti  //2041_08_18 modifica_2	
			) throws SQLException{
		PreparedStatementWrapper ps =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.datavalue " +
						" WHERE entityItemId = ?   " ;
		//inizio 2041_08_18 modifica_2	
		if (soloCampiNonPersistenti) {
			query += " AND persistence=0 ";	 
		}//2041_08_18 modifica_2	

		try {

			ps =  new PreparedStatementWrapper(conn, query);
			ps.setInt(1, entityItemId); 
			
			int deleted = ps.executeUpdate();
			   
			return deleted;
			
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		} 
		
	}

	//inizio modifica 2041_08_18 modifica_2
	public static synchronized int getPersistence(int dataTypeID) throws  Exception {

		int result = -1 ;
		 
		if (persistenceLevelPerDataTypeId.get(dataTypeID)==null) {
			
			ResultSet rs = null;
			PreparedStatementWrapper ps = null;
			Connection  conn = null;
			try { 
				conn =  DBFactory.connectionGet(DBFactory.ORIGINE_ORACLE, true);
				
				String query =  "  SELECT  persistenceLevel " +    
								" FROM GESTORE_FASCICOLO.DATATYPE DT1   " + 
								"  WHERE   DT1.DATATYPEID =  ? "  ;
				
				
				ps = new PreparedStatementWrapper(conn, query); 
				ps.setInt(1, dataTypeID); 
				
				rs = ps.executeQuery();
				 
				if ( rs.next() ) { 
					result = rs.getInt("persistenceLevel");   
					persistenceLevelPerDataTypeId.put(dataTypeID, result);
				} else{
					throw new Exception("Non è stato trovato alcun DATATYPE per DATATYPEID = "+ dataTypeID);
				}
				
				
			} finally{
				if (rs != null) {
					rs.close();
				} 
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			 
			
		} else{
			result = persistenceLevelPerDataTypeId.get(dataTypeID);
		}  
		
		return result;}
	//fine modifica 2041_08_18 modifica_2


	//bug 2015-03-15 aggiunto modificatore static
	private static EntityItem selectEntityDocumento(String fascicoloId, String callerId, String numeroCartella, Connection   conn, Integer... dataTypeIds) throws SQLException { 
		ResultSet rs = null;
		PreparedStatementWrapper ps = null;
		EntityItem result = null ;
		
		try {
			String query =  "  SELECT  *													" +
							"  FROM GESTORE_FASCICOLO.ENTITY e                              " +
							"  INNER JOIN GESTORE_FASCICOLO.ENTITYITEM ei                   " +
							"    on ei.ENTITYID=e.ENTITYID                                  " +
							"  INNER JOIN GESTORE_FASCICOLO.DATAVALUE DV1                   " +
							"    on DV1.ENTITYITEMID = ei.ENTITYITEMID                      " +
							"  INNER JOIN GESTORE_FASCICOLO.DATATYPE DT1                    " +
							"      on DT1.DATATYPEID = DV1.DATATYPEID                       " + 
							"                                                               " +
							"  WHERE ei.FASCICOLOID= ?                                " +
							"     	AND  ei.CALLERID= ?                               " +
							" 		AND DV1.VALUE = ?   " +
							" 		AND ( " ;
							
			
			
			for (int iDataTypeIds = 0; iDataTypeIds < dataTypeIds.length; iDataTypeIds++) {
				if (iDataTypeIds != 0) {
					query += " OR ";
				}
				query += "     DV1.DATATYPEID = " +  dataTypeIds[iDataTypeIds] ;
			}		 
			query += " ) ";			
							
			
			
			ps = new PreparedStatementWrapper(conn, query); 
			ps.setString(1, fascicoloId);
			ps.setString(2, callerId);
			ps.setString(3, numeroCartella);  
			
			rs = ps.executeQuery();
			
			if (rs!=null) {
				while ( rs.next() ) { 
					result = new EntityItem();
					result.setEntityItemId(rs.getInt("ENTITYITEMID")); 
					result.setEntityDescr(rs.getString("ENTITYDESCR")) ;
					result.setEntityId(rs.getInt("ENTITYID")) ;
					//modifica 2041_08_18            result.setEntityItemRef(rs.getString("ENTITYITEMREF")); 
					result.setRenderingType(rs.getString("RENDERINGTYPE"));  
					 
				}
			}
			
			
		} finally{
			if (rs != null) {
				rs.close();
			} 
			if (ps != null) {
				ps.close();
			}
		}
		
		return result;
	}

	public static int deleteEntityItem(Integer entityItemId, Connection conn) throws SQLException {
		PreparedStatementWrapper ps =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.entityitem " +
						" WHERE entityItemId = ?   " ;

		try {

			ps =  new PreparedStatementWrapper(conn, query);
			ps.setInt(1, entityItemId); 
			
			int deleted = ps.executeUpdate(); 
			
			return deleted;
			
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		}  
	}

	//inizio bug3780
	public static int deleteDataValues(Integer entityItemId, Connection conn) throws SQLException {
		PreparedStatementWrapper ps =null; 
		String query = " delete " +
						" FROM   GESTORE_FASCICOLO.DATAVALUE " +
						" WHERE entityItemId = ?   " ;

		try {

			ps =  new PreparedStatementWrapper(conn, query);
			ps.setInt(1, entityItemId); 
			
			int deleted = ps.executeUpdate(); 
			
			return deleted;
			
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		}  
	}
	
	/**
	 * elimina l'entity item ed i data values di un dato entity item e di tutta la sua discendenza 
	 */
	public static void  deleteEntityItemDescendants(EntityItem entityItem, Connection conn) throws SQLException {

		//cancello i dati dei figli
		EntityItem[] detailEntityItems = entityItem.getDetailEntityItems();
		for (EntityItem detailEntityItem : detailEntityItems) {
			deleteEntityItemDescendants(detailEntityItem, conn);
		}
		
		//cancello i dati dell'entity item in questione
		deleteDataValues(entityItem.getEntityItemId(), conn);
		deleteEntityItem(entityItem.getEntityItemId(), conn);
	}
	//fine bug3780
	

	public void updateDataValue(int entityItemId, int dataTypeId, String value) throws SQLException {
		PreparedStatementWrapper ps =null; 
		String query = " update " +
				" gestore_fascicolo.datavalue " +
				" set VALUE = ? " +
				" WHERE entityItemId = ? AND dataTypeId = ?  " ;
		Connection conn =null;
		try {
			conn = getConnection();

			ps =  new PreparedStatementWrapper(conn, query);
			ps.setString(1, value); 
			ps.setInt(2, entityItemId); 
			ps.setInt(3, dataTypeId); 
			
			ps.executeUpdate(); 
			
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
			if (conn!= null) {
				conn.close();
			}
		} 
	}


	//inizio modifica 20-05-2015 cambio Wsdl
	public String getEntityItemIdByCorrelationIdPdf(String correlationId) throws SQLException {
		String result = null;
		ResultSet rs = null;
		PreparedStatementWrapper ps = null; 
		Connection conn = getConnection();
		try {
			String query =  "  select ENTITYITEMID " +
					" from gestore_fascicolo.datavalue    " +
					" where ( datatypeid = " + CartellaDAOImpl.CORRELATION_ID_PDF + 
 					"			or  datatypeid = " + CartellaDAOImpl.DOCUMENTO_ESATTORIALE_CORRELATION_ID_PDF + " ) " + 
					" and value = ? ";	
			  
			
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setString(1, correlationId); 
			
			rs = ps.executeQuery();
			
			if (rs!=null && rs.next() ) {
				result = rs.getString("ENTITYITEMID");
			}
			
		} finally{
			if (rs != null) {
				rs.close();
			} 
			if (ps != null) {
				ps.close();
			}
			if (conn!=null) {
				conn.close();
			}
		}
		
		return result;
	}
	

	public EntityItem getEntityItemByEntityItemId(String entityItemId, Map<String,Object> extraColumns) throws Exception{
		Connection conn;
		EntityItem docItem =null;
		try {
			conn = getConnection();
			docItem = selectEntityItemByEntityId(entityItemId, conn, extraColumns);
			if (docItem!=null) { 
				addValues(docItem, conn);  
			}			
		} finally {
			closeConnection();
		}

		return docItem;
	}
	

	static private EntityItem selectEntityItemByEntityId(String entityItemId, Connection conn, Map<String,Object> extraColumns) throws SQLException { 
		ResultSet rs = null;
		PreparedStatementWrapper ps = null;
		EntityItem result = null;
		try {
			String query =  " select *  " +
					" from gestore_fascicolo.entityitem  ei    " +
					" where ei.entityitemid = ? ";	 
			
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setString(1, entityItemId); 
			 
			rs = ps.executeQuery();
			

			if (rs!=null && rs.next()  ) {  
				       
					result = new EntityItem();
					result.setEntityItemId(rs.getInt("ENTITYITEMID"));  
					result.setEntityId(rs.getInt("ENTITYID")) ; 
					extraColumns.put("FASCICOLOID", rs.getString("FASCICOLOID"));
					extraColumns.put("CALLERID", rs.getString("CALLERID"));
				
			}
			
			
		} finally{
			if (rs != null) {
				rs.close();
			} 
			if (ps != null) {
				ps.close();
			}
		}
		
		return result;
	} 
	//fine modifica 20-05-2015 cambio Wsdl
	

	//inizio 22-05-2015 RelateDocumentoStandard
	public String getEntityItemIdByCorrelationIdRelate(String correlationId) throws SQLException {
		String result = null;
		ResultSet rs = null;
		PreparedStatementWrapper ps = null; 
		Connection conn = getConnection();
		try {
			String query =  "  select ENTITYITEMID " +
					" from gestore_fascicolo.datavalue    " +
					" where ( datatypeid = " + CartellaDAOImpl.CORRELATION_ID_RELATE + 
 					"			or  datatypeid = " + CartellaDAOImpl.DOCUMENTO_ESATTORIALE_CORRELATION_ID_RELATE + " ) " + 
					" and value = ? ";	
			  
			
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setString(1, correlationId); 
			
			rs = ps.executeQuery();
			
			if (rs!=null && rs.next() ) {
				result = rs.getString("ENTITYITEMID");
			}
			
		} finally{
			if (rs != null) {
				rs.close();
			} 
			if (ps != null) {
				ps.close();
			}
			if (conn!=null) {
				conn.close();
			}
		}
		
		return result;
	} 
	//fine 22-05-2015 RelateDocumentoStandard
	

}
