package it.equitalia.gestorefascicolows.bl;


import it.equitalia.gestorefascicolows.utils.MessagesClass;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DbcpUtil {
	private DataSource dataSource;

	public DbcpUtil(String driver, String dbUrl, String db_userid, String db_password) throws Exception {
		Class.forName(driver).newInstance();
		dataSource = setupDataSource(dbUrl, db_userid, db_password);
	}

	private DataSource setupDataSource(String connectURI, String username, String password) throws Exception {
		GenericObjectPool connectionPool = new GenericObjectPool(null);
		connectionPool.setMaxActive(getMaxConnections());
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectURI, username, password);
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, connectionPool, null, null, false, true);
		PoolingDataSource dataSource = new PoolingDataSource(connectionPool);
		return dataSource;
	}

	private int getMaxConnections() throws IOException {
		int maxConnecctions = 0;
		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(MessagesClass.DB_PROPERTIES_PATH));
		try {
			maxConnecctions = Integer.parseInt(properties.getProperty("dbcp.maxconnection"));
		}
		catch (NumberFormatException e) {}
		if (maxConnecctions < 5) {
			maxConnecctions = 5;
		}
		return maxConnecctions;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
