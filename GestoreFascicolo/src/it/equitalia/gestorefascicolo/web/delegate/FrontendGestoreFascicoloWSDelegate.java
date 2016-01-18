package it.equitalia.gestorefascicolo.web.delegate;

import it.equitalia.gestorefascicolo.web.listener.ServletContextHolder;
import it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.FascicoloList;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse;
import it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest;
import it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse;
import it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse;
import it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest;
import it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse;
import it.equitalia.gestorefascicolows.dati.GetRelateWSRequest;
import it.equitalia.gestorefascicolows.dati.GetRelateWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest;
import it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest;
import it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest;
import it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse;
import it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest;
import it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse;
import it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest;
import it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface;
import it.equitalia.gestorefascicolows.source.GestoreFascicoloWSLocator;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse;
import it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import org.apache.commons.configuration.PropertiesConfiguration;

public class FrontendGestoreFascicoloWSDelegate {

	private static String endpointUrl;

	private GestoreFascicoloWSInterface proxy;
	private static FrontendGestoreFascicoloWSDelegate instance;

	public static FrontendGestoreFascicoloWSDelegate getInstance(HttpServletRequest request) throws ServiceException, UnsupportedEncodingException{
		PropertiesConfiguration properties = (PropertiesConfiguration) ServletContextHolder
				.getServletContext().getAttribute("resourceProperties");

		endpointUrl = properties.getString("gestoreFascicoloWS.endpointUrl");
		instance = new FrontendGestoreFascicoloWSDelegate(request);

		return instance; 
	}

	private FrontendGestoreFascicoloWSDelegate(HttpServletRequest request) throws ServiceException, UnsupportedEncodingException {
		GestoreFascicoloWSLocator locator = new GestoreFascicoloWSLocator();
		locator.setGestoreFascicoloWSEndpointAddress(endpointUrl);
		this.proxy = locator.getGestoreFascicoloWS(UtilWSDelegate.getUser(request),  UtilWSDelegate.getPassword(request));
	}

	public DeleteEmailWSResponse deleteEmail(DeleteEmailWSRequest in)
			throws RemoteException, FaultType { 
		return proxy.deleteEmail(in);
	}

	public DeleteIndirizzoWSResponse deleteIndirizzo(DeleteIndirizzoWSRequest in)
			throws RemoteException, FaultType {
		return proxy.deleteIndirizzo(in);
	}

	public DeleteTelefonoWSResponse deleteTelefono(DeleteTelefonoWSRequest in)
			throws RemoteException, FaultType {
		return proxy.deleteTelefono(in);
	}

	@Override
	public boolean equals(Object o) {
		return proxy.equals(o);
	}

	public Fascicolo getCartella(GetCartellaWSRequest in)
			throws RemoteException, FaultType {


		GetCartellaWSResponse cartellaResponse = proxy.getCartella(in);


		return cartellaResponse.getFascicolo();

	}
	public GetDocumentiEsattorialiNonCartelleWSResponse getDocumentiEsattorialiNonCartelle(GetDocumentiEsattorialiNonCartelleWSRequest request) throws FaultType, RemoteException{

		return proxy.getDocumentiEsattorialiNonCartelle(request);

	}

	public Fascicolo getFascicolo(GetFascicoloWSRequest in) throws RemoteException, FaultType {
		GetFascicoloWSResponse fascicoloResponse = proxy.getFascicolo(in);
		Fascicolo fascicolo = fascicoloResponse.getFascicolo();

		return fascicolo;
	}

	public GetPdfDocumentoWSResponse getPdfDocumento(GetPdfDocumentoWSRequest request) throws FaultType, RemoteException{
		return proxy.getPdfDocumento(request);
	}

	public PdfEstrattoContoWSResponse getPdfEstrattoConto(PdfEstrattoContoWSRequest request) throws FaultType, RemoteException{
		return proxy.pdfEstrattoConto(request);
	}

	public GetRelateWSResponse getRelate(GetRelateWSRequest request) throws FaultType, RemoteException{
		return proxy.getRelate(request);
	}

	@Override
	public int hashCode() {
		return proxy.hashCode();
	}

	public InsertEmailWSResponse insertEmail(InsertEmailWSRequest in)
			throws RemoteException, FaultType {
		return proxy.insertEmail(in);
	}

	/*public Fascicolo getFascicolo(String fascicoloId, String callerId) throws Exception{

		GetFascicoloWSRequest fascicoloRequest = new GetFascicoloWSRequest(
				fascicoloId, callerId);

		GetFascicoloWSResponse fascicoloResponse = this.proxy.getFascicolo(fascicoloRequest);

		Fascicolo fascicolo = fascicoloResponse.getFascicolo();

		return fascicolo;

	}*/

	public InsertIndirizzoWSResponse insertIndirizzo(InsertIndirizzoWSRequest in)
			throws RemoteException, FaultType {
		return proxy.insertIndirizzo(in);
	}
	public String insertTelefono(InsertTelefonoWSRequest in)
			throws RemoteException, FaultType {
		InsertTelefonoWSResponse telefonoResponse = proxy.insertTelefono(in);
		return telefonoResponse.getEsito();
	}
	
	public FascicoloList[] searchFascicolo(SearchFascicoloWSRequest in)
			throws RemoteException, FaultType {
		return proxy.searchFascicolo(in);
	}
	

	public  UpdateAnagraficaWSResponse updateAnagrafica(UpdateAnagraficaWSRequest in)
			throws RemoteException, FaultType {
		return proxy.updateAnagrafica(in);
	}
	
	@Override
	public String toString() {
		return proxy.toString();
	}
	
}
