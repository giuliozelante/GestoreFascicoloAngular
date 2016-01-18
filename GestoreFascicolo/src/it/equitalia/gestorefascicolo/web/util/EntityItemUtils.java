package it.equitalia.gestorefascicolo.web.util;

import it.equitalia.gestorefascicolows.dati.DataValue;
import it.equitalia.gestorefascicolows.dati.EntityItem;

import java.util.ArrayList;

public class EntityItemUtils {
	//FIXME  i dataTypeId dovrebbero essere  censiti in un unico punto, invece si trovano anche nelle jsp

	public static final int DATA_TYPE_ID_CARTELLA_NUMERO_CARTELLA = 1; 
	
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_TIPO_MODELLO = 210; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_NUMERO_DOCUMENTO = 215; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_IMPORTO = 220; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_DATA_SPEDIZIONE = 225; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_GESTORE = 290; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_STATO_DISPONIBILITA = 291; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_STATO_PDF = 292;  
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_STATO_RELATE = 293; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_DATA_AGGIORNAMENTO_RELATE = 294; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_CORRELATIONID_PDF = 295; 
	public static final int DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_CORRELATIONID_RELATE = 296; 
	
	 

	
	

	public static String getNumeroCartella( it.equitalia.gestorefascicolows.dati.EntityItem entityItemCartella){
		return getValue(entityItemCartella, DATA_TYPE_ID_CARTELLA_NUMERO_CARTELLA);
	}

	public static java.lang.Boolean hasDataTypeDescrVisibleDocumentoEsattoriale( it.equitalia.gestorefascicolows.dati.DataValue dataValue ){
		boolean res;
		switch (dataValue.getDataTypeId()) {
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_STATO_PDF:
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_STATO_RELATE:  
			res = false;
			break;
		default:
			res = true;
			break;
		} 
		
		return res;
	}

	public static java.lang.Boolean hasRenderingTypeVisibleDocumentoEsattoriale( it.equitalia.gestorefascicolows.dati.DataValue dataValue ){
		boolean res;
		switch (dataValue.getDataTypeId()) {
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_TIPO_MODELLO:
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_GESTORE: //FIXME verificare che non debba essere visualizzato
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_STATO_DISPONIBILITA:
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_DATA_AGGIORNAMENTO_RELATE: 
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_CORRELATIONID_PDF: 
		case DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_CORRELATIONID_RELATE: 
			res = false;
			break;
		default:
			res = true;
			break;
		} 
		
		return res;
	}
	
	
	public static java.util.List<EntityItem> getDocumentiEsattorialiPerTipoModello(it.equitalia.gestorefascicolows.dati.EntityItem[] allDocs, String tipoModello ){
		ArrayList<EntityItem> result =  new ArrayList<EntityItem>(); 
		  
		for (EntityItem doc : allDocs) {
			String tm = getValue(doc, DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_TIPO_MODELLO) ;
			if (tm.equals(tipoModello)) {
				result.add(doc);
			} 
		}
		
		return result;
		
	}
	
	
	/**
	 * restituisce la lista dei distinti Tipo Modello (dataTypeId 210) per un array di entity item di tipo Documenti esattoriali (entityID 200)
	 */
	public static java.util.List<String> getDistinctTipoModello(it.equitalia.gestorefascicolows.dati.EntityItem[] docs ){
		ArrayList<String> result =  new ArrayList<String>(); 
		  
		for (EntityItem doc : docs) {
			String tipoModello = getValue(doc, DATA_TYPE_ID_DOCUMENTI_ESATTORIALI_TIPO_MODELLO) ;
			if (!result.contains( tipoModello )) {
				result.add( tipoModello );
			}
		}
		
		return result;
		
	}


	private static String getValue(it.equitalia.gestorefascicolows.dati.EntityItem entityItem, Integer dataTypeId){
		String res = null;
		for (DataValue dataValue: entityItem.getDataValues()) {
			if (dataTypeId.equals( dataValue.getDataTypeId() ) ) {
				res = dataValue.getValue();
				break;
			}
		}
		return res;
	}
	
	
/**
 * restituisce la lista dei figli di entità data per l'entità padre data all'interno dell'entità root
 * @param root
 * @param parentEntityItemId
 * @param entityId
 * @return
 */
	public static ArrayList<EntityItem> getChilds(
									EntityItem root, 
									Integer parentEntityItemId, 
									Integer entityId){
		ArrayList<EntityItem>   res = new ArrayList<EntityItem>();
		
		exploreGetChilds(root, res, parentEntityItemId, entityId, null);
		
		return res;
	}
	
	
	

	private static void exploreGetChilds(EntityItem entityItem, ArrayList<EntityItem> listaEntityItem, Integer parentEntityItemIdMatch, Integer entityIdMatch, Integer parentEntityItemId){
		if (parentEntityItemId!= null && parentEntityItemId.equals( parentEntityItemIdMatch )
				&& entityItem.getEntityId().equals(entityIdMatch)  ) {
			listaEntityItem.add(entityItem);
		}
		
		if (entityItem.getDetailEntityItems()!=null) { 
			for (int i = 0; i < entityItem.getDetailEntityItems().length; i++) {
				EntityItem child = entityItem.getDetailEntityItems()[i];
				exploreGetChilds(child, listaEntityItem, parentEntityItemIdMatch, entityIdMatch, entityItem.getEntityItemId()  );
			}
		}
	}
	
	
	
	/**
	 * restituisce la lista dei distinti tipi di entità figlie per un dato entity item
	 */
	public static java.util.List<Integer> getDistinctEntityIdsEntityItemChils(it.equitalia.gestorefascicolows.dati.EntityItem cartella, java.lang.Integer entityItemId  ){
		ArrayList<Integer> result =  new ArrayList<Integer>();
		EntityItem item = getChild(cartella, entityItemId);
		  
		for (EntityItem child : item.getDetailEntityItems()) {
			if (!result.contains( child.getEntityId() )) {
				result.add(child.getEntityId() );
			}
		}
		
		return result;
		
	}
	
	
	
	
	public static java.lang.Boolean hasEntityItemChils(it.equitalia.gestorefascicolows.dati.EntityItem cartella, java.lang.Integer entityItemId  ){
		EntityItem item = getChild(cartella, entityItemId);
		
		return item.getDetailEntityItems()!=null 
				&& item.getDetailEntityItems().length>0;
	}
	
	
	private static EntityItem getChild(EntityItem entityItem, java.lang.Integer entityItemId){
		EntityItem res = null;

		for (int i = 0; i < entityItem.getDetailEntityItems().length; i++) {
			EntityItem child = entityItem.getDetailEntityItems()[i];
			if (child.getEntityItemId().equals(entityItemId)) {
				res = child;
			}
		}
		
		if (res==null) { 
			for (int i = 0; i < entityItem.getDetailEntityItems().length; i++) {
				EntityItem child = entityItem.getDetailEntityItems()[i];
				res = getChild(child, entityItemId);
				if (res!=null) {
					break;
				}
			}
		}
		
		return res;
	}
	

	public static boolean hasDetailDataValues(DataValue dataValue){
		return dataValue.getDetailDataValues()!=null && dataValue.getDetailDataValues().length>0;
	}
	
	
}
