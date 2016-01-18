package it.equitalia.gestorefascicolows.utils;



import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.listeners.GestoreFascicoloWSListener;
import it.equitalia.gestorefascicolows.listeners.ServletContextHolder;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

public class MessagesClass {
	
	
	
	public static String DB_PROPERTIES_PATH="GestoreFascicoloWS_db.properties";
	public static String RESOURCES_PROPERTIES_PATH="GestoreFascicoloWS_resources.properties";
	public static String LOG4J_PROPERTIES_PATH="GestoreFascicoloWS_log4j.properties";
	public static Properties properties=null;
	public static Properties resourceProperites=null;
	private static Logger logger = Log4jFactory.getLogger(MessagesClass.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();
	
	
	public static String getMessage(String key) throws FaultType, NumberFormatException{
		String value=null;
		if(resourceProperites==null){
			resourceProperites=(Properties) ServletContextHolder.getServletContext().getAttribute("resourceProperties");
			if (resourceProperites!=null){
				System.out.println("GestoreFascicoloWS_resources.properties CARICATO");
				logger.debug("GestoreFascicoloWS_resources.properties CARICATO");
			}
			else{
				System.out.println("GestoreFascicoloWS_resources.properties NON TROVATO");
				logger.debug("GestoreFascicolo_resources.properties NON TROVATO");
				throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_0")),MessagesClass.getMessage("ERROR_CODE_0_DESCRIZIONE"));
			}
		}
		value=resourceProperites.getProperty(key);
		return value.trim();
	}
	
	

	
	public static List<String> getMessagesListByPrefixKey(String prefixKey) throws  Exception{
		List<String> result = new ArrayList<String>();
		if(resourceProperites==null){
			resourceProperites=(Properties) ServletContextHolder.getServletContext().getAttribute("resourceProperties");
			if (resourceProperites!=null){
				System.out.println("GestoreFascicoloWS_resources.properties CARICATO");
				logger.debug("GestoreFascicoloWS_resources.properties CARICATO");
			} else{
				System.out.println("GestoreFascicoloWS_resources.properties NON TROVATO");
				logger.debug("GestoreFascicolo_resources.properties NON TROVATO");
				throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_0")),MessagesClass.getMessage("ERROR_CODE_0_DESCRIZIONE"));
			}
		}
 
		Iterator  keySetIterator = resourceProperites.keySet().iterator();
		
		while (keySetIterator.hasNext()) {
			String key = (String) keySetIterator.next();
			if (key.startsWith(prefixKey, 0)) {
				result.add(resourceProperites.getProperty(key).trim());				
			}
		}
		
		return result;
	}
	
	

	public static HashMap<String, String> getPropertiesMapByPrefixKey(String prefixKey) throws  Exception{
		HashMap<String, String> result = new HashMap<String, String>();
		if(resourceProperites==null){
			resourceProperites=(Properties) ServletContextHolder.getServletContext().getAttribute("resourceProperties");
			if (resourceProperites!=null){
				System.out.println("GestoreFascicoloWS_resources.properties CARICATO");
				logger.debug("GestoreFascicoloWS_resources.properties CARICATO");
			} else{
				System.out.println("GestoreFascicoloWS_resources.properties NON TROVATO");
				logger.debug("GestoreFascicolo_resources.properties NON TROVATO");
				throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_0")),MessagesClass.getMessage("ERROR_CODE_0_DESCRIZIONE"));
			}
		}
 
		Iterator  keySetIterator = resourceProperites.keySet().iterator();
		
		while (keySetIterator.hasNext()) {
			String key = (String) keySetIterator.next();
			if (key.startsWith(prefixKey, 0)) {
				result.put(key.substring(prefixKey.length()), resourceProperites.getProperty(key).trim()); 	
			}
		}
		
		return result;
	}
}
