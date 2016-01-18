package it.equitalia.gestorefascicolows.bl;

import it.equitalia.gestorefascicolows.dao.EntityDAO;  
import it.equitalia.gestorefascicolows.dati.EntityItem; 

/**
 * 2015-03-31 relate-doc-esattoriali 
 *
 */
public class EntityBl {

	public static boolean isCartella(EntityItem documentoItem)   {
		boolean res = false;	
		
		if (documentoItem.getEntityId() == EntityDAO.ENTITY_ID_CARTELLA) {
			res = true;
		} 
		return res;  
	}
	
}
