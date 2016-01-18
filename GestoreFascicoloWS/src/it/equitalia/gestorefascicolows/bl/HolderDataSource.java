package it.equitalia.gestorefascicolows.bl;



import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * Classe di utility per la gestione del DB via DataSource
 */
public class HolderDataSource implements HolderInterface {
	private String userid = null;
	private String password = null;
	private DataSource ds = null;
	private static Logger logger=Log4jFactory.getLogger(HolderDataSource.class);
	private static Logger errorLogger=Log4jFactory.getErrorLogger();
	
	public HolderDataSource(String db_DataSourceContainerUrl, String db_dataSourceName) throws Exception {
		this(db_DataSourceContainerUrl, db_dataSourceName, null, null, false);
	}

	public HolderDataSource(String db_DataSourceContainerUrl, String db_dataSourceName, String db_userid, String db_password, boolean wasEnabled) throws Exception {
		if (db_userid == null) {
			userid = "";
		} else {
			userid = db_userid;
		}
		if (db_password == null) {
			password = "";
		} else {
			password = db_password;
		}
		//
		ds = getDataSource(db_DataSourceContainerUrl, db_dataSourceName, wasEnabled);
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if ((userid.equals("")) && (password.equals(""))) {
			conn = ds.getConnection();
		} else {
			conn = ds.getConnection(userid, password);
			// conn.setHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
		}
		return conn;
	}

	private DataSource getDataSource(String datasourceContainerUrl, String datasourceName, boolean wasEnabled) throws NamingException, FaultType {
		if (ds == null) {
			InitialContext ic = null;
			try {
				if (wasEnabled) {
					Properties properties = new Properties();
					properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, datasourceContainerUrl);
					ic = new InitialContext(properties);
				} else {
					ic = new InitialContext();
				}
				ds = (DataSource) ic.lookup(datasourceName);
			}
			catch (NamingException e) {
				errorLogger.error("Errore nel lookup del database. "+datasourceName+" Error: \n"+e.getMessage());
				throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
			}
		}
		return ds;
	}
}