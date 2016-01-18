package it.equitalia.gestorefascicolo.web.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	
	public static Date getEmptyDate(){
		Calendar c = new GregorianCalendar(1, 0, 1); 
		return c.getTime();
	}

	
	public static String formatDate(String inputFormat, String outputFormat, String dateValue)    {
		try {

			Date parsedDate = new java.text.SimpleDateFormat(inputFormat).parse(dateValue);
			
			if (parsedDate.equals( getEmptyDate() )) {
				
				return "-";
				
			} else{

				String formattedDate = new java.text.SimpleDateFormat(outputFormat).format(parsedDate);
				
				return formattedDate;
			}
			
		} catch (Exception e) {
			return "-";
		}
		
	}
}
