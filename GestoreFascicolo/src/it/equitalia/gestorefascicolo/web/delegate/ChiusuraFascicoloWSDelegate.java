package it.equitalia.gestorefascicolo.web.delegate;

import it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloLocator;
import it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType;
import it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloRequest;
import it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloResponse;
import it.equitalia.gestorefascicolo.web.listener.ServletContextHolder;
import it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse;
import it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface;
import it.equitalia.gestorefascicolows.source.GestoreFascicoloWSLocator;
import it.equitalia.gestorefascicolows.srv.FaultType;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import org.apache.commons.configuration.PropertiesConfiguration;

public class ChiusuraFascicoloWSDelegate {

	private static String endpointUrl;

	private GestoreFascicoloWSInterface proxy;
	private static ChiusuraFascicoloWSDelegate instance;

	public static ChiusuraFascicoloWSDelegate getInstance(HttpServletRequest request) throws ServiceException, UnsupportedEncodingException{
		PropertiesConfiguration properties = (PropertiesConfiguration) ServletContextHolder.getServletContext().getAttribute("resourceProperties");
		endpointUrl = properties.getString("chiusuraFascicoloWS.endpointUrl");
		instance = new ChiusuraFascicoloWSDelegate(request);

		return instance; 
	}

	private ChiusuraFascicoloWSDelegate(HttpServletRequest request) throws ServiceException, UnsupportedEncodingException {

		GestoreFascicoloWSLocator locator = new GestoreFascicoloWSLocator();
		locator.setGestoreFascicoloWSEndpointAddress(endpointUrl);
		this.proxy = locator.getGestoreFascicoloWS(UtilWSDelegate.getUser(request),  UtilWSDelegate.getPassword(request));
	}


	public ChiusuraFascicoloResponse chiudiFascicolo(String fascicoloId,String callerId) throws MalformedURLException, ServiceException, RemoteException{
		ChiusuraFascicoloLocator locator = new ChiusuraFascicoloLocator();
		ChiusuraFascicoloPortType proxy = locator.getChiusuraFascicoloHttpSoap11Endpoint(new URL(endpointUrl));
		ChiusuraFascicoloRequest request = new ChiusuraFascicoloRequest(fascicoloId,callerId);
		return proxy.process(request);
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

	@Override
	public int hashCode() {
		return proxy.hashCode();
	}
	@Override
	public String toString() {
		return proxy.toString();
	}
}
