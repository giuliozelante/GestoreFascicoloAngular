package it.equitalia.gestorefascicolows.dao;

import java.sql.Connection;

import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.InserimentoPianoRateazioneWSRequest;
import it.equitalia.gestorefascicolows.dati.PianoRateazioneType;
import it.equitalia.gestorefascicolows.srv.FaultType;
 
public interface PianoRateazioneDAO {
	//String inserimentoPianoRateazioneInsert(InserimentoPianoRateazioneWSRequest request) throws FaultType;
	

	void inserimentoPianoRateazioneInsert(
			PianoRateazioneType[] pianoRateazioneTypeArray, String fascicoloId,
			String callerId, EntityItem cartella, Connection conn) throws FaultType, NumberFormatException, Exception ;

	void inserimentoPianoRateazioneInsert(
			PianoRateazioneType[] pianoRateazioneTypeArray, String fascicoloId,
			String callerId, EntityItem cartelle) throws   Exception ;

 
}
