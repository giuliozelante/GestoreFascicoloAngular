package it.equitalia.gestorefascicolo.web.listener;

import it.equitalia.gestorefascicolo.web.util.Log4jFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

public class GestoreFascicoloListener implements ServletContextListener {

	ServletContext context;
	private static Logger logger = Log4jFactory.getLogger(GestoreFascicoloListener.class);

	public void contextDestroyed(ServletContextEvent servletcontextEvent) {
		logger.info("GestoreFascicolo - Context destroyed.");
	} 
	
	public void contextInitialized(ServletContextEvent servletcontextEvent) {
		context=servletcontextEvent.getServletContext();
		ServletContextHolder sch=new ServletContextHolder(context);
		Log4jFactory.configure();
		logger.info("Caricamento GestoreFascicolo_resources.properties...");
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(Thread.currentThread().getContextClassLoader().getResource("GestoreFascicolo_resources.properties"));
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
			context.setAttribute("resourceProperties", config);
			config.load();
			logger.info("GestoreFascicolo_resources.properties CARICATO");
		} catch (Exception e) {
			logger.error("GestoreFascicolo_resources.properties NON TROVATO");
		}

		logger.info("Context initialized.");
	}

}
