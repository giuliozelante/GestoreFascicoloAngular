package it.equitalia.gestorefascicolows.listeners;



import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class GestoreFascicoloWSListener implements ServletContextListener {
    
	ServletContext context;
	private Properties properties;
	private Properties resourceProperties;
	private static Logger logger = Log4jFactory.getLogger(GestoreFascicoloWSListener.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();

	
	public void contextDestroyed(ServletContextEvent servletcontextEvent) {
		logger.debug("GestoreFascicoloWS- Context destroyed.");
	}

	public void contextInitialized(ServletContextEvent servletcontextEvent) {
		context=servletcontextEvent.getServletContext();
		ServletContextHolder sch=new ServletContextHolder(context);
		properties = new Properties();
		resourceProperties=new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(MessagesClass.DB_PROPERTIES_PATH));
			context.setAttribute("Properties", properties);
			logger.debug("File properties caricato : "+MessagesClass.DB_PROPERTIES_PATH );
			resourceProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(MessagesClass.RESOURCES_PROPERTIES_PATH));
			context.setAttribute("resourceProperties", resourceProperties);
			logger.debug("GestoreFascicoloWS- File properties caricato : "+MessagesClass.RESOURCES_PROPERTIES_PATH);
		} catch (IOException e) {
			errorLogger.error("Errore nel caricamento dei file properties");
			e.printStackTrace();
		}
		logger.debug("Context initialized.");
	}

}
