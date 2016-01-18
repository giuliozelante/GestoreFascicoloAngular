package it.equitalia.gestorefascicolows.utils;
 

import it.equitalia.gestorefascicolows.dati.EntityItem;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

public class UtilsClass {
	
	private static String FORMATO="yyyy-MM-dd";
	private static Logger logger = Log4jFactory.getLogger(UtilsClass.class);
	
	
	public static String getDataStandard(Date data){
		if (data!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat(FORMATO);
			String dataString=sdf.format(data);
			return dataString;
		} else {
			return "";
		}
	} 
	
	public static String getDataStandard(String formatoInput,String formatoOutput,String data) throws ParseException{
		Date date = new SimpleDateFormat(formatoInput).parse(data);
		SimpleDateFormat sdf=new SimpleDateFormat(formatoOutput);
		String dataString=sdf.format(date);
		return dataString;
	} 
	
	public static String checkDataStandard(String data) {
		SimpleDateFormat sdf=new SimpleDateFormat(FORMATO);
		Date date=null;
		String dataOut="";
		try{
		date = sdf.parse(data);
		dataOut=sdf.format(date);
		}catch(ParseException e){
			logger.debug("La data inserita non rispetta il formato "+FORMATO);
		}
		return dataOut;
	} 
	
	public static boolean isNotEmpty(Object [] array){
		boolean flagPresenza=true;
		if(array==null){
			flagPresenza=false;
		}else if(array.length==0){
			flagPresenza=false;
		}
		return flagPresenza;
	}

	
    public static boolean mkdir(File file)  {
    	boolean res = true; 
		if (!file.exists()) {
			if (!file.mkdir()) { 
				res = false;
			}  
		} 
		return res;
    }
    

    public static void writeBytes(File file, byte[] bytes) throws IOException  { 
		  
		BufferedOutputStream bos = null;
		try {
			
			FileOutputStream fos = new FileOutputStream( file );
 
			bos = new BufferedOutputStream(fos);

			bos.write(bytes);
			
			bos.flush();
			
		} finally{
			if (bos!=null) {
				bos.close();
			}
		} 
    	
    }
    
    
    public static boolean isNumericoIntero(String str)  {
      return str.matches("\\d+");  
    }

	public static boolean isCodiceFiscaleValido(String codiceFiscale) { 
		return ( codiceFiscale .length() == 16 
				|| ( codiceFiscale.length()==11 && UtilsClass.isNumericoIntero( codiceFiscale )  ));
	}
    

    //inizio Bug3640
    public static String getEntityItemDataValue(EntityItem item, int dataTypeId)     {
		for (int i = 0; i < item.getDataValues().length;i++)
			if (item.getDataValues()[i].getDataTypeId()== dataTypeId){
				return item.getDataValues()[i].getValue();
		}
    	return null;
    }
    //fine Bug3640

}
