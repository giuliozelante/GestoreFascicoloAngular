package it.equitalia.gestorefascicolo.web.listener;


import it.equitalia.gestorefascicolo.web.util.Log4jFactory;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

public class ServletContextHolder {

	private static ServletContext servletContext;
	private static Logger logger = Log4jFactory.getLogger(ServletContextHolder.class);

	public static ServletContext getServletContext(){
		if(servletContext!=null){
			return servletContext;
		}
		return null;
	}

	protected ServletContextHolder(ServletContext context){
		ServletContextHolder.servletContext=context;
		logger.info("GestoreFascicolo - ServletContextHolder initialized");
	}


}
