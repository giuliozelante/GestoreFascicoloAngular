package it.equitalia.gestorefascicolows.bl;





import it.equitalia.gestorefascicolows.listeners.ServletContextHolder;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBFactory {	

	private static Logger logger = Log4jFactory.getLogger(DBFactory.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();

	public DBFactory() {
		super();
	}

	public static final String ORIGINE_ORACLE = "ora";
	
	
	private static Properties properties = null; 
	
	public static Connection connectionGet(String origine, boolean autoCommit) throws SQLException, Exception {
		if (properties==null){
			properties=(Properties) ServletContextHolder.getServletContext().getAttribute("Properties");
			if (properties!=null){
				System.out.println(MessagesClass.DB_PROPERTIES_PATH+" CARICATO");
			}
			else{
				System.out.println(MessagesClass.DB_PROPERTIES_PATH+" NON TROVATO");
			}
			readDbParams(properties);
		}
		Connection conn = MultipleDataSource.getConnection(origine);
		if (!autoCommit) { 
			conn.setAutoCommit(autoCommit);
		}
		try {
			conn.setHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
		}
		catch (SQLException e) {
			errorLogger.error("Origine "+origine+". conn.setHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT) ignorato");
			throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
		}
		return conn;
	}

	private static void readDbParams(Properties rbMain) throws Exception {
		if (logger.isDebugEnabled())logger.debug("Caricamento parametri ORACLE...");
		readDbParams(rbMain, ORIGINE_ORACLE);
		if (logger.isDebugEnabled())logger.debug("... fine caricamento parametri connessione DB");
	}

	private static void readDbParams(Properties rbMain, String prefisso) throws Exception {
		String kind = null;
		String conn_driver = null;
		String conn_url = null;
		String ds_container = null;
		String ds_name = null;
		String userid = null;
		String password = null;
		//
		kind = rbMain.getProperty(prefisso + ".kind");
		conn_driver = rbMain.getProperty(prefisso + ".driver");
		conn_url = rbMain.getProperty(prefisso + ".url");
		ds_container = rbMain.getProperty(prefisso + ".container");
		ds_name = rbMain.getProperty(prefisso + ".datasourceName");
		userid = rbMain.getProperty(prefisso + ".userid");
		password = rbMain.getProperty(prefisso + ".password");

		if ("direct".equals(kind)) {
			if (logger.isDebugEnabled()) {
				logger.debug("conn_driver " + conn_driver);
				logger.debug("conn_url " + conn_url);
				logger.debug("userid " + userid);
				logger.debug("password " + password);
			}
			MultipleDataSource.addNewConnectionItem(prefisso, conn_driver, conn_url, userid, password);
		} else if ("datapool".equals(kind)) {
			if (logger.isDebugEnabled()) {
				logger.debug("ds_container " + ds_container);
				logger.debug("ds_name " + ds_name);
				logger.debug("userid " + userid);
				logger.debug("password " + password);
			}
			MultipleDataSource.addNewDataSource(prefisso, ds_container, ds_name, userid, password);
		} else {
			errorLogger.error("errore nella configurazione del database. Tipo: " + prefisso.toUpperCase());
			throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
		}
	}
	
}
