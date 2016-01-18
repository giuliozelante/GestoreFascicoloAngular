package it.equitalia.gestorefascicolows.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.FascicoloList;
import it.equitalia.gestorefascicolows.srv.FaultType;
 



public interface FascicoloDAO {
	
	public String aperturaFascicoloInsert(AperturaFascicoloWSRequest request) throws FaultType, SQLException;
	public String chiusuraFascicoloUpdate(ChiusuraFascicoloWSRequest request) throws FaultType;
	public FascicoloList[] searchFascicolo(String fascicoloId, String callerId,
			Date dataAperturaDa, Date dataAperturaA, Date dataChiusuraDa,
			Date dataChiusuraA, Integer statoFascicolo,   String codiceFiscale)  throws Exception;
	public Fascicolo getFascicoloConEntityPrimoLivello(String fascicoloId, String callerId, int entityId) throws Exception;
	public Fascicolo getFascicoloConEntityPrimoLivello(String fascicoloId, String callerId, int entityId, Connection connection) throws Exception;   //modifica_problema_transazioni 13/10/2014
	public int getStatoFascicolo(String fascicoloId, String callerId) throws Exception;
	
	public Fascicolo getCartella(String fascicoloId, String callerId, String numeroCartella, String codiceAmbito, Connection connection) throws Exception ;//inizio modifica_problema_transazioni 13/10/2014  
	public Fascicolo getCartella(String fascicoloId, String callerId,
			String numeroCartella, String codiceAmbito) throws Exception;
	public String insertIndirizzo(String fascicoloId, String callerId,
			String indirizzo, boolean isIndirizzoPrincipale)throws Exception;
	public String insertTelefono(String fascicoloId, String callerId,
			String telefono)throws Exception;
	public String insertEmail(String fascicoloId, String callerId, String mail)throws Exception;
	public String deleteIndirizzo(int indirizzoId)throws Exception;
	public String deleteTelefono(int telefonoId)throws Exception;
	public String deleteEmail(int mailId)throws Exception; 
	public void svuotaDettagliCartelle(String fascicoloId, String callerId, Connection conn)throws Exception;
	public void svuotaFascicolo(Fascicolo fascicolo, Connection conn)throws Exception;
//	public Fascicolo getFascicoloConEntityPrimoLivello(String cf, int entityIdDocumentoEsattoriale) throws Exception;
	public void svuotaDettagliCartella(String fascicoloId, String callerId, Integer entityItemId, Connection conn) throws   Exception;  	//modifica mail 08/10/2014 10:38
	public void svuotaFascicolo(Fascicolo fascicolo) throws Exception;				//modifica mail 08/10/2014 10:38
	public void svuotaDettagliCartella(String fascicoloId, String callerId, Integer entityItemId) throws Exception;	 //modifica mail 08/10/2014 10:38
	public void dataUltimoAggiornamentoUpdate(Fascicolo fascicolo, Connection conn) throws Exception; 	//FASCICOLO_2.1   
	public void dataUltimoAggiornamentoDocumentiEsattorialiUpdate(Fascicolo fascicolo, Connection conn) throws Exception; 	//FASCICOLO_2.1   
	public void deleteTelefono(int telefonoId, Connection conn) throws SQLException;
	public void deleteEmail(int mailId,Connection conn) throws SQLException;
	public void deleteIndirizzo(int indirizzoId, Connection conn) throws SQLException;
	public void insertEmail(String fascicoloId, String callerId, int anagraficaId, String email, Connection conn)  throws SQLException;
	public void insertTelefono(String fascicoloId, String callerId, int anagraficaId, String telefono, Connection conn) throws SQLException;
	public void insertIndirizzo(String fascicoloId, String callerId,
			int anagraficaId, String indirizzo, boolean isIndirizzoPrincipale, Connection conn) throws SQLException;

	public Fascicolo getFascicoloConAnagrafica(String fascicoloId, String callerId) throws Exception; //20-05-2015 cambio Wsdl
}
