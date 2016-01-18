package it.equitalia.gestorefascicolows.listeners;


import it.equitalia.gestorefascicolows.utils.Log4jFactory;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;


public class ServletContextHolder {
	
	private static ServletContext servletContext;
	private static Logger logger = Log4jFactory.getLogger(ServletContextHolder.class);
	
	protected ServletContextHolder(ServletContext context){
		this.servletContext=context;
		logger.debug("GestoreFascicoloWS - ServletContextHolder initialized");
	}
	
	public static ServletContext getServletContext(){
		    if(servletContext!=null){
			return servletContext;
		    }
    return null;
	}
	

}
