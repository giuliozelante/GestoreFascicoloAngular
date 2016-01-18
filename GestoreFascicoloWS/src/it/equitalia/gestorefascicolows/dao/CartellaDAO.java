package it.equitalia.gestorefascicolows.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
  
import it.equitalia.gestorefascicolows.dati.DocumentoType;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.InserimentoCartellaWSRequest;
import it.equitalia.gestorefascicolows.srv.FaultType;
 

public interface CartellaDAO {

	void inserimentoCartellaInsert (   //  modifica_problema_transazioni 13/10/2014  
			Fascicolo fascicolo,//2041_08_18 modifica_2
			DocumentoType[] documentoTypeArray, String fascicoloId,
			String callerId, Connection conn)   throws Exception; 


	void updateValue(String numeroDocumento, int dataTypeId, String value, String fascicoloId, String callerId, boolean isCartella) throws Exception ;


	boolean documentoEsistente(String numeroDocumento) throws SQLException;


	boolean pdfEsistente(String numeroDocumento)throws SQLException;


	void inserimentoDocumentoEsattorialeNonCartellaInsert(Fascicolo fascicolo, ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType> listaDocumentiEsattoriali, String fascicoloId, String callerId, Connection conn) throws Exception;


	void inserimentoCartellaInsert(Fascicolo fascicolo,
			DocumentoType[] documentoTypeArray, String fascicoloId,
			String callerId)  throws Exception;


	void inserimentoDocumentoEsattorialeNonCartellaInsert(
			Fascicolo fascicolo,
			ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType> listaDocumentiEsattoriali,
			String fascicoloId, String callerId) throws Exception;
	

	
	public void insertOrUpdateDataUltimoAggiornamento(EntityItem cartellaEntityItem, Fascicolo fascicolo) throws Exception; //FASCICOLO_2.1
}
