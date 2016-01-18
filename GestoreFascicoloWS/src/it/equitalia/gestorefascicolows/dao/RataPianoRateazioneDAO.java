package it.equitalia.gestorefascicolows.dao;

import it.equitalia.gestorefascicolows.dati.RataType;

import java.sql.Connection;

/**
 *   Fascicolo 2.1 2015-05-07
 *
 */
public interface RataPianoRateazioneDAO {

	void inserimentoRatePianoRateazioneInsert(RataType[] rata,
			String fascicoloId, String callerId, int parentEntityItemId,
			Connection connection) throws Exception;

}
