package it.equitalia.gestorefascicolo.web.util;


import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jFactory {
	static Logger logger = Logger.getLogger(Log4jFactory.class.getName());

	public static void configure(){
		System.out.println("Caricamento log4j.properties...");
		URL url=Thread.currentThread().getContextClassLoader().getResource("GestoreFascicolo_log4j.properties");
		try {
			PropertyConfigurator.configure(url);
			logger.info("GestoreFascicolo_log4j.properties CARICATO");
			System.out.println("GestoreFascicolo_log4j.properties CARICATO");
		} catch (Exception e) {
			System.out.println("GestoreFascicolo_log4j.properties NON TROVATO");
		}

	}

	public static Logger getErrorLogger(){
		Logger logger = Logger.getLogger("ErrorLogger");
		return logger;
	}

	public static Logger getLogger(Class loggingClass){
		Logger logger = Logger.getLogger(loggingClass);
		return logger;
	}


}
