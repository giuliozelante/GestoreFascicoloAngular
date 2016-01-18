package it.equitalia.gestorefascicolows.utils;

import java.sql.Connection;

import it.equitalia.gestorefascicolows.dao.DaoHandler;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.srv.FaultType; 

public class EntityItemClass 
					extends DaoHandler {//  2041_08_18 modifica_1
	public static final int ENTITY_ITEM_ID_CARTELLE = 1;
	public static final int ENTITY_ITEM_ID_RATE  =   50;		//modifica_08/10/2014
	public static final int ENTITY_ITEM_ID_TRIBUTI =  100;
	public static final int ENTITY_ITEM_ID_DOCUMENTI_ESATTORIALI  =  200 ;
	public static final int ENTITY_ITEM_ID_PROCEDURE  =  300 ;
	public static final int ENTITY_ITEM_ID_PIANI_DI_REATEAZIONE  =   400;
	public static final int ENTITY_ITEM_ID_DOCUMENTI_ASSOCIATI_PROCEDURE  =   350;	//ModDocumentiAssociati
	public static final int ENTITY_ITEM_ID_DOCUMENTI_ASSOCIATI_PIANI_DI_REATEAZIONE  =   450;	//ModDocumentiAssociati
	public static final int ENTITY_ITEM_ID_RATE_PIANI_DI_RATEAZIONE  =   460;	 //Fascicolo 2.1 2015-05-07
	//inizio FASCICOLO_2.1  
	public static final int ENTITY_ITEM_ID_QUIETANZE  =   500;
	public static final int ENTITY_ITEM_ID_TRIBUTI_QUIETANZE  =   550;
	//fine FASCICOLO_2.1  
	
	
	

    public EntityItemClass() {
	}
	
    public EntityItemClass(boolean autocommit, String origin) throws FaultType {
		super(autocommit, origin); 
	}

	//inizio 2041_08_18 modifica_1
    private java.lang.String fascicoloId; 
    private java.lang.String callerId;
    //fine 2041_08_18 modifica_1
	
     
	//inizio modifica 2041_08_18 modifica_2
	public static int getPersistence(int dataTypeID) throws FaultType, Exception {  
		return   EntityDAO.getPersistence(dataTypeID); 
	}//fine modifica 2041_08_18 modifica_2

	public static String buildEntityItemInsert(int entityId,String fascicoloID,String callerID, 
			//modifica 2041_08_18 int rObjectId,int entityItemRef,
			int parentEntityItemId){
		StringBuffer entityItemInsertQuery;
		entityItemInsertQuery = new StringBuffer("");
		entityItemInsertQuery.append(" INSERT INTO GESTORE_FASCICOLO.ENTITYITEM ");
		entityItemInsertQuery.append(" (ENTITYITEMID,ENTITYID,FASCICOLOID,CALLERID," +
				//modifica 2041_08_18 		"R_OBJECT_ID,ENTITYITEMREF," +
				"PARENTENTITYITEMID) ");
		entityItemInsertQuery.append(" VALUES ");
		
		
		entityItemInsertQuery.append("((GESTORE_FASCICOLO.ENTITYITEMIDSequence.NEXTVAL),");
		//entityItemInsertQuery.append("((select Coalesce(Max(entityitemid),0) + 1 from gestore_fascicolo.entityitem),");
		 
		entityItemInsertQuery.append(entityId+",");
		entityItemInsertQuery.append("'"+fascicoloID+"', ");
		entityItemInsertQuery.append("'"+callerID+"', ");
		//modifica 2041_08_18 		entityItemInsertQuery.append(rObjectId+", ");
		//modifica 2041_08_18 		entityItemInsertQuery.append(entityItemRef+", ");
		entityItemInsertQuery.append(parentEntityItemId+")");
		return entityItemInsertQuery.toString();
	}

	

    //inizio 2041_08_18 modifica_1 
	
	public java.lang.String getFascicoloId() {
		return fascicoloId;
	}

	public void setFascicoloId(java.lang.String fascicoloId) {
		this.fascicoloId = fascicoloId;
	}

	public java.lang.String getCallerId() {
		return callerId;
	}

	public void setCallerId(java.lang.String callerId) {
		this.callerId = callerId;
	}
    //fine 2041_08_18 modifica_1

//06/11/2014	public  String buildDataValueInsert(int dataTypeID,int entityItemID,int parentDataTypeId,  int parententityItemId,  String value  ) throws FaultType, Exception{
//06/11/2014		
//06/11/2014		if (value==null || value.trim().equals("")) {
//06/11/2014			value = " ";
//06/11/2014		}
//06/11/2014		StringBuffer dataValueInsertQuery;
//06/11/2014		dataValueInsertQuery = new StringBuffer("");
//06/11/2014		dataValueInsertQuery.append(" INSERT INTO GESTORE_FASCICOLO.DATAVALUE ");
//06/11/2014		dataValueInsertQuery.append(" (DATATYPEID,ENTITYITEMID,PARENTDATATYPEID,PARENTENTITYITEMID,VALUE" +
//06/11/2014				", fascicoloId, callerId,  	persistence ) ");  //06/11/2014 2041_08_18 modifica_1
//06/11/2014		dataValueInsertQuery.append(" VALUES ");
//06/11/2014		dataValueInsertQuery.append("("+dataTypeID+",");
//06/11/2014		dataValueInsertQuery.append(entityItemID+",");
//06/11/2014		dataValueInsertQuery.append(parentDataTypeId+",");
//06/11/2014		dataValueInsertQuery.append(parententityItemId+",");
//06/11/2014		//06/11/2014inizio 2041_08_18 modifica_1
//06/11/2014		dataValueInsertQuery.append("'"+value+"',");
//06/11/2014		dataValueInsertQuery.append("'"+fascicoloId+"',");
//06/11/2014		dataValueInsertQuery.append("'"+callerId+"',");
//06/11/2014		dataValueInsertQuery.append(getPersistence(dataTypeID)+")");
//06/11/2014		//06/11/2014modifica 2041_08_18 modifica_1
//06/11/2014		return dataValueInsertQuery.toString();
//06/11/2014	}
	
	
	//inizio 06/11/2014
	public  PreparedStatementWrapper buildPreparedStatementDataValueInsert(int dataTypeID,int entityItemID,int parentDataTypeId,  int parententityItemId,  String value, Connection conn  ) throws FaultType, Exception{
		
		if (value==null || value.trim().equals("")) {
			value = " ";
		}
		StringBuffer dataValueInsertQuery = new StringBuffer();  
		dataValueInsertQuery.append(" INSERT INTO GESTORE_FASCICOLO.DATAVALUE ");
		dataValueInsertQuery.append(" ( DATATYPEID, ENTITYITEMID, PARENTDATATYPEID, PARENTENTITYITEMID, VALUE, fascicoloId, callerId,  	persistence ) ");   
		dataValueInsertQuery.append(" VALUES (?, ?,  ?, ?, ?, ?, ?, ?,)");

		PreparedStatementWrapper ps = new PreparedStatementWrapper(conn, dataValueInsertQuery.toString() );
		ps.setInt(1, dataTypeID);
		ps.setInt(2, entityItemID); 
		ps.setInt(3, parentDataTypeId); 
		ps.setInt(4, parententityItemId); 
		ps.setString(5, value); 
		ps.setString(6, fascicoloId); 
		ps.setString(7, callerId); 
		ps.setInt(8, getPersistence(dataTypeID));   
		
		return ps;
	}
	//fine 06/11/2014
	
	
	

	protected void executeInsertDatavalue(int dataTypeId,
			int entityItemId,   String value,
			String fascicoloId, String callerId,  
			PreparedStatementWrapper preparedStatementWrapper, boolean refresh) throws  Exception { 
		
		int persistence = getPersistence(dataTypeId);
		
		if (!refresh || persistence == 0) {
			
			if (value==null || value.trim().equals("")) {
				value = "-";
			}
			
			preparedStatementWrapper.clearParameters();
			preparedStatementWrapper.setInt(1, dataTypeId);
			preparedStatementWrapper.setInt(2, entityItemId);
			preparedStatementWrapper.setString(3, value);
			preparedStatementWrapper.setString(4, fascicoloId);
			preparedStatementWrapper.setString(5, callerId);
			preparedStatementWrapper.setInt(6,  persistence);
			preparedStatementWrapper.executeUpdate();
			
		}
	}

	
}
