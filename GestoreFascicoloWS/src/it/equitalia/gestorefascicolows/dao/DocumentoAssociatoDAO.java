package it.equitalia.gestorefascicolows.dao;

import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.IdentificativoDocumentoType;

import java.sql.Connection;

/**
 *  ModDocumentiAssociati
 */
public interface DocumentoAssociatoDAO {

	public void inserimentoDocumentoAssociatoPianoRateazioneInsert(
			IdentificativoDocumentoType[] documentiAssociati, String fascicoloId,
			String callerId,   int parentEntityItemId, Connection connection) throws  Exception;
	

	public void inserimentoDocumentoAssociatoProceduraInsert(
			IdentificativoDocumentoType[] documentiAssociati, String fascicoloId,
			String callerId,   int parentEntityItemId, Connection connection) throws  Exception;
	
}
