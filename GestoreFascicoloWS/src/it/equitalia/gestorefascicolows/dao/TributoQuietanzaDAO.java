package it.equitalia.gestorefascicolows.dao;
 

import it.equitalia.dettagliocartellaavviso.wsdl.TributoQuietanzaType;

import java.sql.Connection;

/**
 *  FASCICOLO_2.1
 */
public interface TributoQuietanzaDAO {

	void inserimentoTributoQuietanza(TributoQuietanzaType tributoQuietanzaType,
			String fascicoloId, String callerId, int entityItemId ) throws Exception;

}
