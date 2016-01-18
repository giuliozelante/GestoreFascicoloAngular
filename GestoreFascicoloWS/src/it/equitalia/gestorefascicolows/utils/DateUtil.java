package it.equitalia.gestorefascicolows.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
 

public class DateUtil {
	static SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat dateTimeFormat  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getEmptyDateValue(){
		Calendar c= new GregorianCalendar(0,0,1);
		return simpleDateFormat.format(c.getTime());
	}

	public static String getActualDateValue() {
		return simpleDateFormat.format(new Date());
	}
	
	//inizio FASCICOLO_2.1
	public static Calendar fromDateToCalendar(Date date) {
		Calendar c =null;
		if (date!=null) {
			c = Calendar.getInstance();
			c.setTime(date);
		}
		return c;
	}

	public static java.util.Calendar parseDate (String data) throws ParseException {
		if (data!=null) { 
			Calendar c = new GregorianCalendar();
			c.setTime(simpleDateFormat.parse(data));
			return c;
		} else {
			return null;
		}
	}
	//fine FASCICOLO_2.1
}
