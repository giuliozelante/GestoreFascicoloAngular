package it.equitalia.gestorefascicolo.web.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Beautifier {
	public static String beautifyHtmlTable(String sTable,boolean removeStyle, boolean removeHeadings) throws IOException{	
		StringBuffer sTableMod = new StringBuffer();
		// convert String into InputStreamsTable
		InputStream is = new ByteArrayInputStream(sTable.getBytes());
	 
		// read it with BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
	 
		String line;
		while ((line = br.readLine()) != null) {
			line = line.replaceAll("  ", "");
			line = line.replaceAll("><", ">\n<");
			sTableMod.append(line); 
		}
	 
		br.close();
		return sTableMod.toString();
	}
}
