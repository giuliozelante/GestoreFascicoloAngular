package it.equitalia.gestorefascicolows.dao;


 
   
import it.equitalia.gestorefascicolows.dao.impl.CartellaDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.DocumentoAssociatoDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.FascicoloDAOImpl; 
import it.equitalia.gestorefascicolows.dao.impl.PianoRateazioneDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.ProceduraDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.QuietanzaDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.RataDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.RataPianoRateazioneDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.TributoDAOImpl;
import it.equitalia.gestorefascicolows.dao.impl.TributoQuietanzaDAOImpl;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;


public abstract class DAOFactory {
	

	public static String  GESTOREFASCICOLOWS_CLASS ;
	public static String GESTOREFASCICOLOWSTRIBUTI_CLASS;
	public static String GESTOREFASCICOLOWSPROCEDURA_CLASS;
	public static String GESTOREFASCICOLOWSPIANORATEAZIONE_CLASS;
	public static String GESTOREFASCICOLOWSCARTELLA_CLASS;
	public static String GESTOREFASCICOLOWSRATA_CLASS;
	public static String GESTOREFASCICOLOWSDOCUMENTOASSOCIATO_CLASS;  //ModDocumentiAssociati
	public static String GESTOREFASCICOLOWSQUIETANZA_CLASS;  //FASCICOLO_2.1  
	public static String GESTOREFASCICOLOWSTRIBUTOQUIETANZA_CLASS;  //FASCICOLO_2.1  
	public static String GESTOREFASCICOLOWSRATAPIANORATEAZIONE_CLASS;  //Fascicolo 2.1 2015-05-07  
	
	
	private static Logger logger = Log4jFactory.getLogger(DAOFactory.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();
	
	static{
		GESTOREFASCICOLOWS_CLASS=FascicoloDAOImpl.class.getName();
	}
		
    @SuppressWarnings("unchecked")
	public static FascicoloDAO getFascicoloDAO(boolean autoCommit,String origin) throws Exception {
    	FascicoloDAO selectionDAO = null;
		try {
    		Class<FascicoloDAO> clazz = (Class<FascicoloDAO>)Class.forName(GESTOREFASCICOLOWS_CLASS);
    		Constructor<FascicoloDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
    		selectionDAO = constructor.newInstance(autoCommit,origin);
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return selectionDAO;
	}
    

	public static FascicoloDAO getFascicoloDAO() throws FaultType, NumberFormatException {
    	FascicoloDAO selectionDAO = null;
		try {
    		Class<FascicoloDAO> clazz = (Class<FascicoloDAO>)Class.forName(GESTOREFASCICOLOWS_CLASS); 
    		selectionDAO = clazz.newInstance();
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return selectionDAO;
	}
    
    
    
    
	
    static{
		GESTOREFASCICOLOWSTRIBUTI_CLASS=TributoDAOImpl.class.getName();
	}
    
    @SuppressWarnings("unchecked")
	public static TributoDAO getTributoDAO(boolean autoCommit,String origin) throws Exception {
    	TributoDAO tributiDAO = null;
		try {
    		Class<TributoDAO> clazz = (Class<TributoDAO>)Class.forName(GESTOREFASCICOLOWSTRIBUTI_CLASS);
    		Constructor<TributoDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
    		tributiDAO = constructor.newInstance(autoCommit,origin);
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return tributiDAO;
	}
    

	public static TributoDAO getTributoDAO() throws FaultType, NumberFormatException {
    	TributoDAO tributiDAO = null;
		try {
    		Class<TributoDAO> clazz = (Class<TributoDAO>)Class.forName(GESTOREFASCICOLOWSTRIBUTI_CLASS); 
    		tributiDAO = clazz.newInstance( );
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return tributiDAO;
	}
    
    static{
    	GESTOREFASCICOLOWSPROCEDURA_CLASS=ProceduraDAOImpl.class.getName();
	}
    
    @SuppressWarnings("unchecked")
	public static ProceduraDAO getProceduraDAO(boolean autoCommit,String origin) throws Exception {
    	ProceduraDAO proceduraDAO = null;
		try {
    		Class<ProceduraDAO> clazz = (Class<ProceduraDAO>)Class.forName(GESTOREFASCICOLOWSPROCEDURA_CLASS);
    		Constructor<ProceduraDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
    		proceduraDAO = constructor.newInstance(autoCommit,origin);
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return proceduraDAO;
	}
    

	public static ProceduraDAO getProceduraDAO() throws FaultType, NumberFormatException {
    	ProceduraDAO proceduraDAO = null;
		try {
    		Class<ProceduraDAO> clazz = (Class<ProceduraDAO>)Class.forName(GESTOREFASCICOLOWSPROCEDURA_CLASS);
    		proceduraDAO = clazz.newInstance();
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return proceduraDAO;
	}
    
    
    static{
    	GESTOREFASCICOLOWSPIANORATEAZIONE_CLASS=PianoRateazioneDAOImpl.class.getName();
	}
    
    @SuppressWarnings("unchecked")
	public static PianoRateazioneDAO getPianoRateazioneDAO(boolean autoCommit,String origin) throws Exception {
    	PianoRateazioneDAO pianoRateazioneDAO = null;
		try {
    		Class<PianoRateazioneDAO> clazz = (Class<PianoRateazioneDAO>)Class.forName(GESTOREFASCICOLOWSPIANORATEAZIONE_CLASS);
    		Constructor<PianoRateazioneDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
    		pianoRateazioneDAO = constructor.newInstance(autoCommit,origin);
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return pianoRateazioneDAO;
	}
    
	public static PianoRateazioneDAO getPianoRateazioneDAO() throws FaultType, NumberFormatException {
    	PianoRateazioneDAO pianoRateazioneDAO = null;
		try {
    		Class<PianoRateazioneDAO> clazz = (Class<PianoRateazioneDAO>)Class.forName(GESTOREFASCICOLOWSPIANORATEAZIONE_CLASS);
    		pianoRateazioneDAO = clazz.newInstance();
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return pianoRateazioneDAO;
	}


    
    
    static{
    	GESTOREFASCICOLOWSCARTELLA_CLASS=CartellaDAOImpl.class.getName();
	}
    
    @SuppressWarnings("unchecked")
	public static CartellaDAO getCartellaDAO(boolean autoCommit,String origin) throws Exception {
    	CartellaDAO cartellaDAO = null;
		try {
    		Class<CartellaDAO> clazz = (Class<CartellaDAO>)Class.forName(GESTOREFASCICOLOWSCARTELLA_CLASS);
    		Constructor<CartellaDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
    		cartellaDAO = constructor.newInstance(autoCommit,origin);
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return cartellaDAO;
	}


	public static CartellaDAO getCartellaDAO() throws FaultType, NumberFormatException {
    	CartellaDAO cartellaDAO = null;
		try {
    		Class<CartellaDAO> clazz = (Class<CartellaDAO>)Class.forName(GESTOREFASCICOLOWSCARTELLA_CLASS); 
    		cartellaDAO = clazz.newInstance();
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return cartellaDAO;
	}

	//inizio modifica_08/10/2014

	static{
		GESTOREFASCICOLOWSRATA_CLASS=RataDAOImpl.class.getName();
	}
	
	public static RataDAO getRataDAO() throws FaultType, NumberFormatException {
		RataDAO dao = null;
		try {
    		Class<RataDAO> clazz = (Class<RataDAO>)Class.forName(GESTOREFASCICOLOWSRATA_CLASS); 
    		dao = clazz.newInstance();
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return dao;
	}
	//fine modifica_08/10/2014


	public static RataDAO getRataDAO(boolean autoCommit, String origin) throws FaultType, NumberFormatException {

		RataDAO rataDAO = null;
		try {
    		Class<RataDAO> clazz = (Class<RataDAO>)Class.forName(GESTOREFASCICOLOWSRATA_CLASS);
    		Constructor<RataDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
    		rataDAO = constructor.newInstance(autoCommit,origin);
    	} catch (Exception x) {
    		errorLogger.error(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1"))+" - "+MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"), x);
    		throw new FaultType(Integer.valueOf(MessagesClass.getMessage("ERROR_CODE_1")),MessagesClass.getMessage("ERROR_CODE_1_DESCRIZIONE"));
    	} 
    	return rataDAO;
	}




	//INIZIO ModDocumentiAssociati
	
    static{
    	GESTOREFASCICOLOWSDOCUMENTOASSOCIATO_CLASS=DocumentoAssociatoDAOImpl.class.getName();
	}
    
	public static DocumentoAssociatoDAO getDocumentoAssociatoDAO(boolean autoCommit,String origin) throws Exception {
		DocumentoAssociatoDAO dao = null; 
		Class<DocumentoAssociatoDAO> clazz = (Class<DocumentoAssociatoDAO>)Class.forName(GESTOREFASCICOLOWSDOCUMENTOASSOCIATO_CLASS);
		Constructor<DocumentoAssociatoDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
		dao = constructor.newInstance(autoCommit,origin);
    	return dao;
	}
	
	public static DocumentoAssociatoDAO getDocumentoAssociatoDAO() throws Exception {
		DocumentoAssociatoDAO dao = null; 
		Class<DocumentoAssociatoDAO> clazz = (Class<DocumentoAssociatoDAO>)Class.forName(GESTOREFASCICOLOWSDOCUMENTOASSOCIATO_CLASS); 
		dao = clazz.newInstance();
    	return dao;
	} 
	//FINE ModDocumentiAssociati
	
	
//INIZIO Fascicolo 2.1 2015-05-07	
	static{
		GESTOREFASCICOLOWSRATAPIANORATEAZIONE_CLASS = RataPianoRateazioneDAOImpl.class.getName();
	}
	
	public static RataPianoRateazioneDAO getRataPianoRateazioneDAO() throws Exception {
		RataPianoRateazioneDAO dao = null; 
		Class<RataPianoRateazioneDAO> clazz = (Class<RataPianoRateazioneDAO>)Class.forName(GESTOREFASCICOLOWSRATAPIANORATEAZIONE_CLASS); 
		dao = clazz.newInstance();
    	return dao;
	} 
//FINE  Fascicolo 2.1 2015-05-07
	
	//inizio FASCICOLO_2.1   
    static{
    	GESTOREFASCICOLOWSQUIETANZA_CLASS= QuietanzaDAOImpl.class.getName();
    	GESTOREFASCICOLOWSTRIBUTOQUIETANZA_CLASS = TributoQuietanzaDAOImpl.class.getName();
	} 
	
	public static QuietanzaDAO getQuietanzaDAO(boolean autoCommit, String origin) throws Exception {
		QuietanzaDAO dao = null; 
		Class<QuietanzaDAO> clazz = (Class<QuietanzaDAO>)Class.forName(GESTOREFASCICOLOWSQUIETANZA_CLASS);
		Constructor<QuietanzaDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
		dao = constructor.newInstance(autoCommit,origin);
    	return dao;
	}
	

	public static TributoQuietanzaDAO getTributoQuietanzaDAO(boolean autoCommit, String origin) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
		TributoQuietanzaDAO dao = null; 
		Class<TributoQuietanzaDAO> clazz = (Class<TributoQuietanzaDAO>)Class.forName(GESTOREFASCICOLOWSTRIBUTOQUIETANZA_CLASS);
		Constructor<TributoQuietanzaDAO> constructor = clazz.getConstructor(new Class[] {boolean.class,java.lang.String.class});
		dao = constructor.newInstance(autoCommit,origin);
    	return dao;
	}
	
	//fine FASCICOLO_2.1  



}
