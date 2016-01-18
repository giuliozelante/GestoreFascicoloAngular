package it.equitalia.gestorefascicolows.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;

public class Convertions {
	static SimpleDateFormat defaultDf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date fromSqlDateToUtilDate(java.sql.Date sqlDate){
		return new java.util.Date(sqlDate.getTime());
	}
	
	public static String fromSqlDateToDefaultStringDate(java.sql.Date sqlDate){
		return   defaultDf.format(  fromSqlDateToUtilDate(sqlDate)   );
	}
	public static String fromDateToSqlString(java.util.Date date){
		return   defaultDf.format(date);
	}
	public static java.sql.Date fromUtitlDateToSqlDate(java.util.Date date){
		return  new java.sql.Date(date.getTime());
	}


	public static byte[] convertIntoBytes(File outputFile) throws IOException { 
    	FileInputStream fileInputStream=null; 
 
        byte[] bFile = new byte[(int) outputFile.length()];
 
        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(outputFile);
	    fileInputStream.read(bFile);
  
        } finally {
        	if (fileInputStream!=null) {
			    fileInputStream.close();
			}
        } 

		return bFile;
	}

}
