package it.equitalia.gestorefascicolows.dao;

import java.sql.Connection;

import it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType;
import it.equitalia.gestorefascicolows.dati.EntityItem;


/**
 *  FASCICOLO_2.1
 */
public interface QuietanzaDAO {

	void inserimentoQuietanze(QuietanzaType[] quietanzaTypeArray, String fascicoloId, String callerId, EntityItem cartella) throws Exception;

}
