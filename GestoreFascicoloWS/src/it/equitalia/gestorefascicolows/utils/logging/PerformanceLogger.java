package it.equitalia.gestorefascicolows.utils.logging;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.apache.log4j.Logger;
 

import it.equitalia.gestorefascicolows.utils.Log4jFactory;

public class PerformanceLogger {
	static HashMap<Object, PerformanceLogger> mappa = new HashMap<Object, PerformanceLogger>();
	
	Logger logger = Log4jFactory.getLogger(PerformanceLogger.class);
	String prefixLog;
	long initialTime;
	long previousTime;
	

	public PerformanceLogger(String prefixLog){
		this(prefixLog, Thread.currentThread());
	}
	
	public PerformanceLogger(String prefixLog, Object objKey){
		this.prefixLog = prefixLog;
		initialTime = System.currentTimeMillis();
		previousTime = initialTime;
		mappa.put(objKey, this);
	}

	public static PerformanceLogger getLogger(){
		return mappa.get(Thread.currentThread());
	}
	
	public static PerformanceLogger getLogger(Object objKey){
		return mappa.get(objKey);
	}
	
	public void reset(){
		initialTime = System.currentTimeMillis();	
	}

	public void logTime(){
		logTime("");
	}
	public void logTime(String text){
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
		long now = System.currentTimeMillis();
		long totale = now - initialTime;
		long ultimoStep = now - previousTime;
		previousTime = now;

		Date previousDate = new Date(ultimoStep);
		Calendar previousCal = new GregorianCalendar();
		previousCal.setTime(previousDate);
		previousCal.add(Calendar.HOUR_OF_DAY, -1);
		String previousFormatted = formatter.format(previousCal.getTime());
		
		Date totaleDate = new Date(totale);
		Calendar totaleCal = new GregorianCalendar();
		totaleCal.setTime(totaleDate);
		totaleCal.add(Calendar.HOUR_OF_DAY, -1);
		String totaleFormatted = formatter.format(totaleCal.getTime());
		
		logger.debug(prefixLog + " " +  text + " tempo ultimo step [" +
				previousFormatted + "] tempo totale[" +
				totaleFormatted + "]" );
	}

	public static void main(String asd[]) throws InterruptedException{
		PerformanceLogger logger =  new PerformanceLogger("", PerformanceLogger.class);

		logger.logTime("1");
		
		Thread.currentThread().sleep(1111);
		
		logger.logTime("2");
		
		
	}
}
