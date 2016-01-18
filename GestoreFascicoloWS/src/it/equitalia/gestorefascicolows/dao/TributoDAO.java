package it.equitalia.gestorefascicolows.dao;

import java.sql.Connection;

import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.InserimentoTributoWSRequest;
import it.equitalia.gestorefascicolows.dati.TributoType;
import it.equitalia.gestorefascicolows.srv.FaultType;
 

public interface TributoDAO {

	//String inserimentoTributoInsert(InserimentoTributoWSRequest request) throws FaultType;
	void inserimentoTributoInsert(TributoType [] tributoTypeArray, String fascicoloID, String callerID, EntityItem cartella, Connection conn) throws FaultType, Exception;

	void inserimentoTributoInsert(TributoType[] tributoTypeArray,
			String fascicoloId, String callerId, EntityItem cartelle)throws   Exception;
}
