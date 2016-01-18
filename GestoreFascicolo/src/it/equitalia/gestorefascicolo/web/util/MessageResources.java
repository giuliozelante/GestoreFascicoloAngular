package it.equitalia.gestorefascicolo.web.util;

import it.equitalia.gestorefascicolo.web.listener.ServletContextHolder;

import org.apache.commons.configuration.PropertiesConfiguration;

public class MessageResources {
	private static MessageResources instance = null;
	private static PropertiesConfiguration properties;
	protected MessageResources() {
		properties = (PropertiesConfiguration) ServletContextHolder.getServletContext().getAttribute("resourceProperties");
	}
	public static MessageResources getInstance() {
		if(instance == null) {
			instance = new MessageResources();
		}
		return instance;
	}

	

	public static String getProperty(String key){
		getInstance();
		return properties.getString(key);
	}
}
