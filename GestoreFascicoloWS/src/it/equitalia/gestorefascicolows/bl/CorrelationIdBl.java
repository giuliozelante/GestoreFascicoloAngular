package it.equitalia.gestorefascicolows.bl;
 
import java.util.HashMap; 

import org.apache.log4j.Logger;
 

import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.FascicoloDAO; 
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo; 
import it.equitalia.gestorefascicolows.utils.MessagesClass;

/**
 * Classe creata per 
 * 20-05-2015 cambio Wsdl
 * 22-05-2015 RelateDocumentoStandard
 */
public class CorrelationIdBl {
	static Logger logger = Logger.getLogger(CorrelationIdBl.class); 
	
	//inizio 20-05-2015 cambio Wsdl
	
	/**
	 * restituisce l'entity item del documento (cartella o documento esattoriale) associato al correlation id passato come argomento 
	 */
	public static Fascicolo getFascicoloDocumentoCallBackPdfDocumento(
			String correlationId) throws  Exception {
		Fascicolo result = null;
		int nTentativi = getNumeroTentativiCallBackPdfDocumento();  
		String entityItemId = null;
		
		//cerco il correlation N volte
		for (int i = 0; i < nTentativi; i++) {
			EntityDAO entityDAO = new EntityDAO();
			entityItemId = entityDAO.getEntityItemIdByCorrelationIdPdf(correlationId);
			
			if (entityItemId!=null) {
				break;
			} else {
				Thread.currentThread().sleep(getWaitInMillsCallBackPdfDocumento());  
			}
			
		}
		
		if (entityItemId!=null) { 
			HashMap<String,Object> extraColumns =  new HashMap<String,Object>();
			EntityDAO entityDAO = new EntityDAO();

			EntityItem entityItem = entityDAO.getEntityItemByEntityItemId(entityItemId, extraColumns); 
 
	    	FascicoloDAO dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE); 
	    	result = dao.getFascicoloConAnagrafica( 
					    				(String)extraColumns.get("FASCICOLOID"), 
					    				(String)extraColumns.get("CALLERID"));
	    	
	    	result.setCartelle( new EntityItem[]{entityItem} );
			
		}
		 
		
		return result;
	}

	private static long getWaitInMillsCallBackPdfDocumento() {
		try {
			return  Integer.parseInt(MessagesClass.getMessage("CALLBACK_PDF_DOCUMENTO.WAIT_IN_MILLS").trim());
		} catch (Exception e) {
			logger.warn("Mancata valorizzazione della propietà CALLBACK_PDF_DOCUMENTO.WAIT_IN_MILLS");
			return 1000;
		}
	}

	private static int getNumeroTentativiCallBackPdfDocumento() { 
		try {
			return  Integer.parseInt(MessagesClass.getMessage("CALLBACK_PDF_DOCUMENTO.NUMERO_TENTATIVI").trim());
		} catch (Exception e) {
			logger.warn("Mancata valorizzazione della propietà CALLBACK_PDF_DOCUMENTO.NUMERO_TENTATIVI");
			return 60;
		}
	}
	//fine 20-05-2015 cambio Wsdl

	

	//inizio 22-05-2015 RelateDocumentoStandard
	/**
	 * restituisce l'entity item del documento (cartella o documento esattoriale) associato al correlation id passato come argomento 
	 * @throws Exception 
	 */
	public static Fascicolo getFascicoloDocumentoCallBackRelateDocumento(String correlationId) throws Exception {
		Fascicolo result = null;
		int nTentativi = getNumeroTentativiCallBackRelateDocumento();  
		String entityItemId = null;
		
		//cerco il correlation N volte
		for (int i = 0; i < nTentativi; i++) {
			EntityDAO entityDAO = new EntityDAO();
			entityItemId = entityDAO.getEntityItemIdByCorrelationIdRelate(correlationId);
			
			if (entityItemId!=null) {
				break;
			} else {
				Thread.currentThread().sleep(getWaitInMillsCallBackRelateDocumento());  
			}
			
		}
		
		if (entityItemId!=null) { 
			HashMap<String,Object> extraColumns =  new HashMap<String,Object>();
			EntityDAO entityDAO = new EntityDAO();

			EntityItem entityItem = entityDAO.getEntityItemByEntityItemId(entityItemId, extraColumns); 
 
	    	FascicoloDAO dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE); 
	    	result = dao.getFascicoloConAnagrafica( 
					    				(String)extraColumns.get("FASCICOLOID"), 
					    				(String)extraColumns.get("CALLERID"));
	    	
	    	result.setCartelle( new EntityItem[]{entityItem} );
			
		}
		 
		
		return result;
	}

	private static long getWaitInMillsCallBackRelateDocumento() {
		try {
			return  Integer.parseInt(MessagesClass.getMessage("CALLBACK_RELATE_DOCUMENTO.WAIT_IN_MILLS").trim());
		} catch (Exception e) {
			logger.warn("Mancata valorizzazione della propietà CALLBACK_RELATE_DOCUMENTO.WAIT_IN_MILLS");
			return 1000;
		}
	}

	private static int getNumeroTentativiCallBackRelateDocumento() {
		try {
			return  Integer.parseInt(MessagesClass.getMessage("CALLBACK_RELATE_DOCUMENTO.NUMERO_TENTATIVI").trim());
		} catch (Exception e) {
			logger.warn("Mancata valorizzazione della propietà CALLBACK_RELATE_DOCUMENTO.NUMERO_TENTATIVI");
			return 60;
		}
	}
	
	
	
	
	//fine 22-05-2015 RelateDocumentoStandard

}
