package it.equitalia.gestorefascicolows.dao;

 

import it.equitalia.gestorefascicolows.bl.DBFactory;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public abstract class DaoHandler {
	
	private Connection connection;
    
	private boolean autoCommit=true;
	
	private static Logger logger = Log4jFactory.getLogger(DaoHandler.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();
	

	public DaoHandler(){}
	
	
	public DaoHandler(boolean autocommit,String origin) throws FaultType {
		super();
		Connection connection=null;
		try {
			connection =   DBFactory.connectionGet(origin, autocommit);
			logger.debug(MessagesClass.getMessage("COMPLETED_CONNESSIONE_ORA"));
		}catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_CONNESSIONE_ORA"), e);
			e.printStackTrace();
			throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));	
		}
		this.connection=connection;
		this.autoCommit=autocommit;
	}
	
	public void closeConnection() throws FaultType{
		if (connection!=null) {

			if(!autoCommit){
				try {
					connection.commit();
				} catch (SQLException e) {
					errorLogger.error(MessagesClass.getMessage("ERROR_ORA_COMMIT ")+e.getMessage());
					e.printStackTrace();
					throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_0")),MessagesClass.getMessage("ERROR_CODE_0_DESCRIZIONE"));
				}
			}
			
			try {
				connection.close();
			} catch (SQLException e) {
				errorLogger.error(MessagesClass.getMessage("ERRORE_ORA_CLOSE_CONNECTION ")+e.getMessage());
				e.printStackTrace();
				throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_0")),MessagesClass.getMessage("ERROR_CODE_0_DESCRIZIONE"));
			}
		}
	}
	

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void rollback(Connection connection) throws FaultType, NumberFormatException{
		try {
			connection.rollback();
			connection.close();
		} catch (SQLException e) {
			errorLogger.error(MessagesClass.getMessage("ERROR_ROLLBACK"));
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs,PreparedStatement preparedStatement) throws FaultType, NumberFormatException{
		try {
			if(rs!=null){
			rs.close();
			}
			if(preparedStatement!=null){
			preparedStatement.close();
			}
			} catch (SQLException e) {
				logger.debug(MessagesClass.getMessage("ERRORE_CHIUSURE_RESSTAT ")+e.getMessage());
				e.printStackTrace();
			}
	}

	protected void closeResultSet(ResultSet rs,
			PreparedStatementWrapper preparedStatement) throws FaultType, NumberFormatException {
		try {
			if(rs!=null){
			rs.close();
			}
			if(preparedStatement!=null){
			preparedStatement.close();
			}
			} catch (SQLException e) {
				logger.debug(MessagesClass.getMessage("ERRORE_CHIUSURE_RESSTAT ")+e.getMessage());
				e.printStackTrace();
			}
		
	}
}
