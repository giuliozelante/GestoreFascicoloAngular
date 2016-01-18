package it.equitalia.gestorefascicolows.utils;

import it.equitalia.gestorefascicolows.dao.impl.CartellaDAOImpl;
import it.equitalia.gestorefascicolows.dati.EntityItem;

import java.util.Comparator;

/**
 *  Bug3640
 */
public class DocumentoEsattorialeEntityComparator implements Comparator<EntityItem> {

	public int compare(EntityItem o1, EntityItem o2) {
		
		if ( UtilsClass.getEntityItemDataValue(o1, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_TIPO_MODELLO).
					equals( 
							UtilsClass.getEntityItemDataValue(o2, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_TIPO_MODELLO)) ) {
			
			return UtilsClass.getEntityItemDataValue(o1, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_DATA_SPEDIZIONE).
						compareTo(
								UtilsClass.getEntityItemDataValue(o2, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_DATA_SPEDIZIONE));
		} else{
			return UtilsClass.getEntityItemDataValue(o1, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_TIPO_MODELLO).
						compareTo( 
								UtilsClass.getEntityItemDataValue(o2, CartellaDAOImpl.DOCUMENTO_ESATTORIALE_TIPO_MODELLO));		
		}
		
		
	}

}