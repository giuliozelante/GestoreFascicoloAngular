
package it.equitalia.gestorefascicolows.dao;



import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.RataType;   

import java.sql.Connection;

/**
 *    creata per la modifica_08/10/2014 
 *
 */
public interface RataDAO {

	void inserimentoRata(
			RataType[] rate, String fascicoloId,
			String callerId, EntityItem cartella, Connection conn) throws  Exception ;

	void inserimentoRata(RataType[] rateOrigine, String fascicoloId,
			String callerId, EntityItem cartella) throws  Exception ;
}
