package it.equitalia.gestorefascicolows.bl;



import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;



/**
 * Classe di utility per la gestione del DB via JDBC
 */
public class HolderConnection implements HolderInterface {
	private String dbUrl;
	private String userid;
	private String password;
	private DbcpUtil dbcpUtil;
	
	private static Logger logger = Log4jFactory.getLogger(HolderConnection.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();

	public HolderConnection(String driver, String dbUrl) throws Exception {
		this(driver, dbUrl, null, null);
	}

	public HolderConnection(String driver, String dbUrl, String db_userid, String db_password) throws Exception {
		Class.forName(driver).newInstance();
		this.dbUrl = dbUrl;
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
		try {
			dbcpUtil = new DbcpUtil(driver, dbUrl, userid, password);
		}
		catch (Throwable e) {
			errorLogger.error("Errore nell'instanziare la classe"+dbcpUtil.getClass().getName());
			throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if (dbcpUtil != null) {
			conn = dbcpUtil.getConnection();
		} else {
			if ((userid.equals("")) && (password.equals(""))) {
				conn = DriverManager.getConnection(dbUrl);
			} else {
				conn = DriverManager.getConnection(dbUrl, userid, password);
			}
		}
		return conn;
	}
}
