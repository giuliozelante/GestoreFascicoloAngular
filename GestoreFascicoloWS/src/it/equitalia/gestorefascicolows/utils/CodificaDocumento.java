package it.equitalia.gestorefascicolows.utils;
 
import it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType;
import it.equitalia.gestorefascicolows.bl.CartellaBl;
import it.equitalia.gestorefascicolows.dati.DocumentoType;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest;
import it.equitalia.gestorefascicolows.dati.PianoRateazioneType;
import it.equitalia.gestorefascicolows.dati.RataType;
import it.equitalia.gestorefascicolows.dati.TributoType;
import it.equitalia.gestorefascicolows.srv.FaultType;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger; 

public  class CodificaDocumento {
	private static Logger logger = Log4jFactory.getLogger(CodificaDocumento.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();


	private static HashMap<String, String> tipiDocumentoGetCartellaMap = null;
	private static HashMap<String, String> descrizioniDocumentiPerTipoDocMap = null;
	
	static{
		try {
			tipiDocumentoGetCartellaMap = MessagesClass.getPropertiesMapByPrefixKey("GET_CARTELLA.TIPO_DOCUMENTO.");
		} catch (Exception e) { 
			errorLogger.error("Errore in fase di inizializzazione della mappa di proprietà con prefisso \"GET_CARTELLA.TIPO_DOCUMENTO.\"", e);
		}
		
		try {
			descrizioniDocumentiPerTipoDocMap = MessagesClass.getPropertiesMapByPrefixKey("DOCUMENTO_DESCRIZIONE_");
		} catch (Exception e) { 
			errorLogger.error("Errore in fase di inizializzazione della mappa di proprietà con prefisso \"DOCUMENTO_DESCRIZIONE_\"", e);
		}
		
	}  

	public static String getTipoDocumento(GetCartellaWSRequest in) throws Exception{
		String input = in.getTipoDocumento().trim();
		String out = null;
		out = tipiDocumentoGetCartellaMap.get(input);
		
		if (out==null) { 
			throw new Exception("Proprietà \"GET_CARTELLA.TIPO_DOCUMENTO\" non mappata per tipo documento [" + input +"]");
		}
		return out;
	}
	
	public static String getDescrizione(DocumentoType documento) throws FaultType{
		String tipoDoc=documento.getIdDocumento().getTipoDocumento();
		String output="";
		if(tipoDoc==null){
			logger.debug("Il valore TipoDocumento  è null");
			return null;
		}
//		if(descrizione.equalsIgnoreCase("1")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_1");
//		}else if(descrizione.equalsIgnoreCase("2")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_2");
//		}else if(descrizione.equalsIgnoreCase("3")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_3");
//		}else if(descrizione.equalsIgnoreCase("4")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_4");
//		}else if(descrizione.equalsIgnoreCase("5")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_5");
//		}else if(descrizione.equalsIgnoreCase("6")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_6");
//		}else if(descrizione.equalsIgnoreCase("7")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_7");
//		}else if(descrizione.equalsIgnoreCase("8")){
//			output=MessagesClass.getMessage("DOCUMENTO_DESCRIZIONE_8");
//		}
		output = descrizioniDocumentiPerTipoDocMap.get(tipoDoc);
		
		return output;
	}

	public static String getSospensioni(DocumentoType documento) throws FaultType{
		String output="";
		Integer flagSospensione=documento.getFlagSospensione();
		if(flagSospensione==null){
			logger.debug("Il valore FlagSospensione  è null");
			return null;
		}
		if(flagSospensione>0||flagSospensione==-1){
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_SOSPENSIONE_SI");
		}else{
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_SOSPENSIONE_NO");
		}
		return output;
	}
	
	
	public static String getSgravi(DocumentoType documento) throws FaultType{
		String output="";
		Integer flagSgravio=documento.getFlagSgravio();
		if(flagSgravio==null){
			logger.debug("Il valore FlagSgravio  è null");
			return null;
		}
		if(flagSgravio>0||flagSgravio==-1){
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_SGRAVIO_SI");
		}else{
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_SGRAVIO_NO");
		}
		return output;
	}
	
	public static String getRateazioni(DocumentoType documento) throws FaultType{
		String output="";
		Integer flagRateazioni=documento.getFlagRateazione();
		if(flagRateazioni==null){
			logger.debug("Il valore FlagRateazione  è null");
			return null;
		}
		if(flagRateazioni>0||flagRateazioni==-1){
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_RATEAZIONE_SI");
		}else{
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_RATEAZIONE_NO");
		}
		return output;
	}
	
	public static String getProcedure(DocumentoType documento) throws FaultType{
		String output="";
		Integer flagProcedure=documento.getFlagProcedura();
		if(flagProcedure==null){
			logger.debug("Il valore FlagProcedura  è null");
			return null;
		}
		if(flagProcedure>0||flagProcedure==-1){
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_PROCEDURA_SI");
		}else{
			output=MessagesClass.getMessage("DOCUMENTO_FLAG_PROCEDURA_NO");
		}
		return output;
	}
	
	
	public static String getRateizzabile(TributoType tributo) throws FaultType{
		String output="";
		Integer rateizzabile=tributo.getRateizzabile();
		if(rateizzabile==null){
			logger.debug("Il valore FlagRateizzabile  è null");
			return null;
		}
		if(rateizzabile>0||rateizzabile==-1){
			output=MessagesClass.getMessage("TRIBUTO_FLAG_RATEIZZABILE_SI");
		}else{
			output=MessagesClass.getMessage("TRIBUTO_FLAG_RATEIZZABILE_NO");
		}
		return output;
	}
	
	
	public static String getConcesseDa(PianoRateazioneType pianoRateazione){
		String output="";
		List<String> equitaliaList=Arrays.asList("70","71");
		List<String> pianoRateazioneList=Arrays.asList("60","61");
		String cancesseDa=pianoRateazione.getStatoPiano();
		
		if(equitaliaList.contains(cancesseDa)){
			output="Equitalia";
		}
		if(pianoRateazioneList.contains(cancesseDa)){
			output=pianoRateazione.getEnteConcedente().getDescrizione();
		}
		return output;
	}
	
    public static String getStato(PianoRateazioneType pianoRateazione){
    	String output="";
		List<String> attivoList=Arrays.asList("60","70");
		List<String> nonAttivoList=Arrays.asList("61","71");
		String cancesseDa=pianoRateazione.getStatoPiano();
		
		if(attivoList.contains(cancesseDa)){
			output="Attivo";
		}
		if(nonAttivoList.contains(cancesseDa)){
			output="Non Attivo";
		}
		return output;
	}
 
    public static String getImporto(Double importo){
//    	DecimalFormat df = new DecimalFormat("0.00");
//    	String importoString=df.format(importo);
    	return importo.toString();
    }
     
	public static String getStatoRata(RataType rata) {  
    	String output="";
		 
    	if (rata.getStatoRata().equals("0")) {
    		output = "Non Pagata";
		} else if (rata.getStatoRata().equals("1")) {
    		output = "Pagata";
		} else{
    		output = "Non definito";
		}
    	
		return output;
	}

	public static String getDate(Date d) {
		SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}
	
	public static String getQuietanzaAnnullata(QuietanzaType quietanza) throws FaultType{
		String output="";
		String flagAnnullata=quietanza.getQuietanzaAnnullata().getValue();
		if(flagAnnullata==null){
			logger.debug("Il valore FlagQuietanzaAnnullata  è null");
			return null;
		}
		if(flagAnnullata.equals("0")){
			output=MessagesClass.getMessage("QUIETANZA_FLAG_ANNULLATA_NO");
		}else{
			output=MessagesClass.getMessage("QUIETANZA_FLAG_ANNULLATA_SI");
		}
		return output;
	}	
}
