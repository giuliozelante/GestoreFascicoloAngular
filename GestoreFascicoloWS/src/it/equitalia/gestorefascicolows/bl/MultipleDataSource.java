package it.equitalia.gestorefascicolows.bl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Facility class di gestione di molteplici DB attraverso JDBC e/o DataSource
 */
public class MultipleDataSource  {  
	private static Hashtable<String, HolderInterface> internal = new Hashtable<String, HolderInterface>();

	/**
	 * aggiunge un nuovo gestore JDBC
	 * 
	 * @param key
	 * @param driver
	 * @param dbUrl
	 * @throws Exception
	 */
	public static void addNewConnectionItem(String key, String driver, String dbUrl) throws Exception {
		addNewConnectionItem(key, driver, dbUrl, null, null);
	}

	/**
	 * aggiunge un nuovo gestore JDBC
	 * 
	 * @param key
	 * @param driver
	 * @param dbUrl
	 * @param userid
	 * @param password
	 * @throws Exception
	 */
	public static void addNewConnectionItem(String key, String driver, String dbUrl, String userid, String password) throws Exception {
		HolderConnection ci = new HolderConnection(driver, dbUrl, userid, password);
		internal.put(normalizeKey(key), ci);
	}

	/**
	 * aggiunge un nuovo gestore DataSource
	 * 
	 * @param key
	 * @param db_DataSourceContainerUrl
	 * @param db_dataSourceName
	 * @throws Exception
	 */
	public static void addNewDataSource(String key, String db_DataSourceContainerUrl, String db_dataSourceName) throws Exception {
		addNewDataSource(key, db_DataSourceContainerUrl, db_dataSourceName, null, null);
	}

	/**
	 * aggiunge un nuovo gestore DataSource
	 * 
	 * @param key
	 * @param db_DataSourceContainerUrl
	 * @param db_dataSourceName
	 * @param userid
	 * @param password
	 * @throws Exception
	 */
	public static void addNewDataSource(String key, String db_DataSourceContainerUrl, String db_dataSourceName, String userid, String password) throws Exception {
		HolderDataSource dsi = new HolderDataSource(db_DataSourceContainerUrl, db_dataSourceName, userid, password, false);
		internal.put(normalizeKey(key), dsi);
	}

	public static void addWasDataSource(String key, String db_DataSourceContainerUrl, String db_dataSourceName, String userid, String password) throws Exception {
		HolderDataSource dsi = new HolderDataSource(db_DataSourceContainerUrl, db_dataSourceName, userid, password, true);
		internal.put(normalizeKey(key), dsi);
	}

	/**
	 * Ottiene una Connection dal gestore specificato
	 * 
	 * @param key
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection(String key) throws SQLException {
		HolderInterface wi = internal.get(normalizeKey(key));
		return wi.getConnection();
	}

	private static String normalizeKey(String key) {
		return key.toLowerCase();
	}
	 
}
