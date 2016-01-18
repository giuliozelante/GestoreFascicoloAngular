package it.equitalia.gestorefascicolows.bl;

/**
 * Interfaccia per la gestione delle connessioni con il DB
 */
public interface HolderInterface {
	/**
	 * Rende una Connection
	 * 
	 * @return java.sql.Connection
	 * @throws java.sql.SQLException
	 */
	public java.sql.Connection getConnection() throws java.sql.SQLException;
}
