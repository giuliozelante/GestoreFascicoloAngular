package it.equitalia.gestorefascicolows.dao.impl;
 

import it.equitalia.gestorefascicolows.dao.DaoHandler;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.SelectionDAO;
import it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.InserimentoDocumentoWSRequest;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.sql.CallableStatement;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;


public class SelectionDAOImpl extends DaoHandler implements SelectionDAO {
	
	private static Logger logger = Log4jFactory.getLogger(SelectionDAOImpl.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();
	
	private  String INSERT_FASCICOLO_QUERY;
	private  String INSERT_ANAGRAFICA_FASCICOLO_QUERY;
	private  String INSERT_ANGRAFICA_INDIRIZZO_QUERY;
	
	private  String UPDATE_CHIUSURA_FASCICOLO_QUERY;

	private int anagraficaFascicoloId=0;
	private int anagraficaIndirizzoId=0;
	

	public SelectionDAOImpl() { 	
	}
	
	public SelectionDAOImpl(boolean autoCommit,String origin) throws FaultType {
		super(autoCommit,origin);	
	}
	
	
//	public String aperturaFascicoloInsert(AperturaFascicoloWSRequest request)
//	throws FaultType {
//	String output="";	
//	boolean esito=true;	
//	Connection connection=getConnection();
//	esito=executeQueryInsertFascicolo(request,connection);
//	if(esito){
//	esito=executeQueryInsertAnagraficaFascicolo(request,connection);	
//	}
//	if(esito){
//	esito=executeQueryInsertAnagraficaIndirizzo(request,connection);	
//	}
//	if(esito){
//		logger.debug(MessagesClass.getMessage("ESITO_APERTURA_FASCICOLO_OK"));
//		closeConnection();
//		logger.debug(MessagesClass.getMessage("CONNESSIONE_CHIUSA"));
//	}
//	else{
//		rollback(connection);
//		output=MessagesClass.getMessage("ESITO_APERTURA_FASCICOLO_NOK");
//	}
//	if(esito){
//		output=MessagesClass.getMessage("ESITO_APERTURA_FASCICOLO_OK");
//	}
//	return output;
//	}
	
	
	private boolean executeQueryInsertFascicolo(AperturaFascicoloWSRequest request,Connection connection) throws FaultType{
	String insertFascicoloQuery=buildInsertFascicoloQuery(request);
	CallableStatement callableStatement=null;
	boolean esito=false;
	try {
	callableStatement = connection.prepareCall(insertFascicoloQuery);
	callableStatement.executeUpdate();
	esito=true;
	callableStatement.close();
     }catch (SQLException e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
			e.printStackTrace();
		}
		
		 return esito;
	}
	
	
	
//	private boolean executeQueryInsertAnagraficaFascicolo(AperturaFascicoloWSRequest request ,Connection connection) throws FaultType{
//		anagraficaFascicoloId=getAnagraficaFascicoloId(connection);
//		String insertAnagraficaFascicoloQuery=buildInsertAnagraficaFascicoloQuery(request);
//		CallableStatement callableStatement=null;
//		boolean esito=false;
//		
//		try {
//		callableStatement = connection.prepareCall(insertAnagraficaFascicoloQuery);
//		callableStatement.executeQuery();
//		esito=true;
//		callableStatement.close();
//	     }catch (SQLException e) {
//				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
//				e.printStackTrace();
//			}catch (Exception e) {
//				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
//				e.printStackTrace();	
//			}
//			 return esito;
//	}
	
	
//	private boolean executeQueryInsertAnagraficaIndirizzo(AperturaFascicoloWSRequest request,Connection connection) throws FaultType{
//		anagraficaIndirizzoId=getAnagraficaIndirizzoId(connection);
//		String insertAnagraficaIndirizzoQuery=buildInsertAnagraficaIndirizzoQuery(request);
//		CallableStatement callableStatement=null;
//		boolean esito=false;
//		
//		try {
//		callableStatement = connection.prepareCall(insertAnagraficaIndirizzoQuery);
//		callableStatement.executeQuery();
//		esito=true;
//		callableStatement.close();
//	     }catch (SQLException e) {
//				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
//				e.printStackTrace();
//			}catch (Exception e) {
//				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
//				e.printStackTrace();
//			}
//		return esito;	
//	}
	
	

    public String chiusuraFascicoloUpdate(ChiusuraFascicoloWSRequest request)
	throws FaultType {
    String esito="";	
	Connection connection=getConnection();
	ResultSet rs=null;
	boolean errorOccurred=false;
	String updateSoggettoFisicoSql=buildUpdateChiusuraFascicolo(request);
	PreparedStatementWrapper preparedStatement=null;
	try {
	preparedStatement = PreparedStatementWrapper.prepareStatement(connection, updateSoggettoFisicoSql);
	rs = preparedStatement.executeQuery();
	esito=MessagesClass.getMessage("ESITO_CHIUSURA_FASCICOLO_OK");
     }catch (SQLException e) {
    	    errorOccurred=true;
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_CHIUSURA_FASCICOLO ")+e.getMessage());
			e.printStackTrace();  		
		}catch (Exception e) {
			errorOccurred=true;
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_CHIUSURA_FASCICOLO ")+e.getMessage());
			e.printStackTrace();
    		
		}finally{
			closeResultSet(rs,preparedStatement);
			logger.debug(MessagesClass.getMessage("CONNESSIONE_CHIUSA"));
		}
	if(errorOccurred){
			 rollback(connection);
			 logger.debug(MessagesClass.getMessage("EXECUTE_ROLLBACK"));
			 esito=MessagesClass.getMessage("ESITO_CHIUSURA_FASCICOLO_NOK");;
    }else{
    	closeConnection();
    }
    return esito;
    }

	

	public String buildInsertFascicoloQuery(AperturaFascicoloWSRequest request) throws FaultType{
		StringBuffer insertFascicoloQuery;
		insertFascicoloQuery=new StringBuffer("");	
		insertFascicoloQuery.append(" INSERT INTO GESTORE_FASCICOLO.Fascicolo ");
		insertFascicoloQuery.append(" (fascicoloId,callerId,dataApertura,dataChiusura,statoFascicoloId) ");
		insertFascicoloQuery.append(" VALUES ");
		insertFascicoloQuery.append("( ");
		insertFascicoloQuery.append("'"+request.getFascicoloId()+"'" +" ,");
		insertFascicoloQuery.append("'"+request.getCallerId()+"'" +" ,");
		insertFascicoloQuery.append("TO_DATE('"+request.getDataApertura()+"','yyyy-MM-dd')" +" ,");
		insertFascicoloQuery.append("TO_DATE('0001-01-01','yyyy-MM-dd') ,");
		insertFascicoloQuery.append("10 )");
		INSERT_FASCICOLO_QUERY=insertFascicoloQuery.toString();
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_FASCICOLO")+"\n"+ INSERT_FASCICOLO_QUERY);
		return INSERT_FASCICOLO_QUERY;
	}
	
	
//	public String buildInsertAnagraficaFascicoloQuery(AperturaFascicoloWSRequest request) throws FaultType{
//		StringBuffer insertAnagraficaFascicoloQuery;
//		insertAnagraficaFascicoloQuery=new StringBuffer("");	
//		insertAnagraficaFascicoloQuery.append(" DECLARE TEMP NUMBER(38,0); ");
//		insertAnagraficaFascicoloQuery.append(" BEGIN INSERT INTO GESTORE_FASCICOLO.ANAGRAFICAFASCICOLO ");
//		insertAnagraficaFascicoloQuery.append(" (ANAGRAFICAFASCICOLOID,FASCICOLOID,CALLERID,CODICEFISCALE,NATURAGIURIDICA,COGNOME,NOME,RAGIONESOCIALE) ");
//		insertAnagraficaFascicoloQuery.append(" VALUES ");
//		insertAnagraficaFascicoloQuery.append("( ");
//		//insertAnagraficaFascicoloQuery.append(" GESTORE_FASCICOLO.ANAGRAFICAFASCICOLOIDSequence.NEXTVAL, ");
//		//insertAnagraficaFascicoloQuery.append(" (SELECT COUNT(*)+1 AS NEXTROW FROM GESTORE_FASCICOLO.ANAGRAFICAFASCICOLO), ");
//		insertAnagraficaFascicoloQuery.append( anagraficaFascicoloId+ " , ");
//		insertAnagraficaFascicoloQuery.append("'"+request.getFascicoloId()+"'" +" ,");
//		insertAnagraficaFascicoloQuery.append("'"+request.getCallerId()+"'" +" ,");
//		insertAnagraficaFascicoloQuery.append("'"+request.getCodiceFiscale()+"'" +" ,");
//		insertAnagraficaFascicoloQuery.append("'"+request.getNaturaGiuridica()+"'" +" ,");
//		insertAnagraficaFascicoloQuery.append("'"+request.getCognome()+"'" +" ,");
//		insertAnagraficaFascicoloQuery.append("'"+request.getNome()+"'" +" ,");
//		insertAnagraficaFascicoloQuery.append("'"+request.getRagioneSociale()+"')" +" ");
//		insertAnagraficaFascicoloQuery.append(" RETURNING ANAGRAFICAFASCICOLOID INTO TEMP; END; ");
//		INSERT_ANAGRAFICA_FASCICOLO_QUERY=insertAnagraficaFascicoloQuery.toString();
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ANAGRAFICA_FASCICOLO")+"\n"+ INSERT_ANAGRAFICA_FASCICOLO_QUERY);
//		return INSERT_ANAGRAFICA_FASCICOLO_QUERY;
//	}
	
	
	
//	public String buildInsertAnagraficaIndirizzoQuery(AperturaFascicoloWSRequest request) throws FaultType{
//		StringBuffer insertFascicoloQuery;
//		insertFascicoloQuery=new StringBuffer("");	
//		insertFascicoloQuery.append(" INSERT INTO GESTORE_FASCICOLO.ANAGRAFICAINDIRIZZO ");
//		insertFascicoloQuery.append(" (ANAGRAFICAINDIRIZZOID,ANAGRAFICAFASCICOLOID,INDIRIZZO,INDIRIZZOPRINCIPALE) ");
//		insertFascicoloQuery.append(" VALUES ");
//		insertFascicoloQuery.append("( ");
//		insertFascicoloQuery.append(anagraficaIndirizzoId+", ");
//		insertFascicoloQuery.append(anagraficaFascicoloId+",");
//		insertFascicoloQuery.append("'"+request.getIndirizzo()+"'" +" ,");
//		insertFascicoloQuery.append("'S'" +" )");
//		INSERT_ANGRAFICA_INDIRIZZO_QUERY=insertFascicoloQuery.toString();
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ANAGRAFICA_INDIRIZZO")+"\n"+ INSERT_ANGRAFICA_INDIRIZZO_QUERY);
//		return INSERT_ANGRAFICA_INDIRIZZO_QUERY;
//	}
	
	
	public String buildUpdateChiusuraFascicolo(ChiusuraFascicoloWSRequest request) throws FaultType{
		StringBuffer chiusuraFascicoloQuery;
		chiusuraFascicoloQuery=new StringBuffer("");
		chiusuraFascicoloQuery.append(" UPDATE GESTORE_FASCICOLO.Fascicolo ");
		chiusuraFascicoloQuery.append(" SET statoFascicoloId=90, ");
		chiusuraFascicoloQuery.append(" dataChiusura= "+"TO_DATE('"+request.getDataChiusura()+"','yyyy-MM-dd')");
		chiusuraFascicoloQuery.append(" WHERE fascicoloId= '"+request.getFascicoloId()+"' ");
		chiusuraFascicoloQuery.append(" AND callerId='"+request.getCallerId()+"'") ;
		UPDATE_CHIUSURA_FASCICOLO_QUERY=chiusuraFascicoloQuery.toString();
		logger.debug(MessagesClass.getMessage("UPDATE_CHIUSURA_FASCICOLO_QUERY")+"\n"+ UPDATE_CHIUSURA_FASCICOLO_QUERY);
		return UPDATE_CHIUSURA_FASCICOLO_QUERY;
	}

	
   public int getAnagraficaFascicoloId(Connection connection) throws FaultType, NumberFormatException{
	   int anagraficaFascicoloId=1;
	   String sequenceQueryId="SELECT GESTORE_FASCICOLO.ANAGRAFICAFASCICOLOIDSequence.NEXTVAL VL FROM DUAL";
	   PreparedStatementWrapper prparedStatement=null;
		try {
		prparedStatement = PreparedStatementWrapper.prepareStatement(connection, sequenceQueryId);
		ResultSet rs=prparedStatement.executeQuery();
		rs.next();
		anagraficaFascicoloId=rs.getInt(1);
		prparedStatement.close();
	     }catch (SQLException e) {
				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
				e.printStackTrace();
			}catch (Exception e) {
				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
				e.printStackTrace();
			}
	
	   return anagraficaFascicoloId;
   }
   
   public int getAnagraficaIndirizzoId(Connection connection) throws FaultType, NumberFormatException{
	   int anagraficaIndirzzoId=1;
	   String sequenceQueryId="SELECT GESTORE_FASCICOLO.ANAGRAFICAINDIRIZZOIDSequence.NEXTVAL VL FROM DUAL";
	   PreparedStatementWrapper prparedStatement=null;
		try {
		prparedStatement = PreparedStatementWrapper.prepareStatement(connection, sequenceQueryId);
		ResultSet rs=prparedStatement.executeQuery();
		rs.next();
		anagraficaIndirzzoId=rs.getInt(1);
		prparedStatement.close();
	     }catch (SQLException e) {
				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
				e.printStackTrace();
			}catch (Exception e) {
				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")+e.getMessage());
				e.printStackTrace();
			}
	
	   return anagraficaIndirzzoId;
   }


public String inserimentoDocumentoInserti(InserimentoDocumentoWSRequest request)
		throws FaultType { 
	return null;
}
 
	

}
