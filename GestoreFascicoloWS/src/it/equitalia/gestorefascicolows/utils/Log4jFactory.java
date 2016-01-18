package it.equitalia.gestorefascicolows.utils;

import java.io.File;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jFactory {

	private static boolean log4jConfigured = false;
	
	public static void configure(){
		log4jConfigured = true;
		System.out.println("Caricamento log4j.properties...");
		URL url=Thread.currentThread().getContextClassLoader().getResource(MessagesClass.LOG4J_PROPERTIES_PATH);
		if (url!=null){
			System.out.println(MessagesClass.LOG4J_PROPERTIES_PATH+" CARICATO");
		}
		else{
			System.out.println(MessagesClass.LOG4J_PROPERTIES_PATH+" NON TROVATO");
		}
		PropertyConfigurator.configure(url.getFile());
		
	}

	public static Logger getLogger(Class clazz){
		if (!log4jConfigured){
			configure();
		}
		return  org.apache.log4j.Logger.getLogger(clazz);
	}
	
	public static Logger getErrorLogger(){
		if (!log4jConfigured){
			configure();
		}
		return  org.apache.log4j.Logger.getLogger("ErrorLogger");
	}
}
