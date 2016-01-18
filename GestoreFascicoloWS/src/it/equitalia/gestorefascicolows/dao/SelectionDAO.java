package it.equitalia.gestorefascicolows.dao;

import it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.InserimentoDocumentoWSRequest;
import it.equitalia.gestorefascicolows.srv.FaultType;
 



public interface SelectionDAO {
	
//	public String aperturaFascicoloInsert(AperturaFascicoloWSRequest request) throws FaultType;
	public String chiusuraFascicoloUpdate(ChiusuraFascicoloWSRequest request) throws FaultType;
	public String inserimentoDocumentoInserti(InserimentoDocumentoWSRequest request) throws FaultType;

}
