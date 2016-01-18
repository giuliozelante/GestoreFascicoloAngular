package it.equitalia.gestorefascicolo.web.util;

/**
 * mod 2015-03-12
 *
 */
public class DataValueRenderingType {
	final static int hidden = 0	;
	final static int stringaIntero = 1	; 
	final static int data = 2	;
	final static int decimale = 4	;
	final static int valuta = 8	;
	final static int percentuale = 16	 ; 
	final static int link = 32	;
	final static int popup = 64	;

	public static final boolean isValueData(String renderingType){
		return isBitPresente(renderingType, data);
	}

	public static final boolean isValueValuta(String renderingType){
		return isBitPresente(renderingType, valuta);
	}
	
	public static final boolean isValueLink(String renderingType){ 
		return isBitPresente(renderingType, link);
	}

	public static final boolean isValueHidden(String renderingType){ 
		if (Integer.parseInt(renderingType) == hidden) {

			System.out.println("asds");
		}
		System.out.println(renderingType);
		return Integer.parseInt(renderingType) == hidden;
	}
	
	public static final boolean isBitPresente(String renderingType, int bit){
		return (Integer.parseInt(renderingType) & bit) == bit;
	}
	
}
