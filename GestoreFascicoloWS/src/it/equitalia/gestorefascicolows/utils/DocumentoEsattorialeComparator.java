package it.equitalia.gestorefascicolows.utils;

import java.util.Comparator;
 



public class DocumentoEsattorialeComparator implements Comparator<it.equitalia.documentiesattoriali.bpel.DocumentoType> {

	public int compare(it.equitalia.documentiesattoriali.bpel.DocumentoType o1, it.equitalia.documentiesattoriali.bpel.DocumentoType o2) {
		
		if (o1.getTipoModello() == o2.getTipoModello() ) {
			return o1.getDataSpedizione().compareTo(o2.getDataSpedizione());
		} else{
			return o1.getTipoModello().compareTo(o2.getTipoModello() );		
		}
	}

}
