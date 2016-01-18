package it.equitalia.gestorefascicolows.dao;

import java.sql.Connection;

import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.InserimentoProceduraWSRequest;
import it.equitalia.gestorefascicolows.dati.ProceduraType;
import it.equitalia.gestorefascicolows.srv.FaultType;
 

public interface ProceduraDAO {
	
	//String inserimentoProceduraInsert(InserimentoProceduraWSRequest request) throws FaultType;
	void inserimentoProceduraInsert(ProceduraType[] proceduraTypeArray, String fascicoloId, String callerId, EntityItem cartella, Connection conn) throws FaultType, Exception;

	void inserimentoProceduraInsert(ProceduraType[] proceduraTypeArray,
			String fascicoloId, String callerId, EntityItem cartelle) throws   Exception; 

}
