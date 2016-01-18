/**
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.source;



import java.rmi.RemoteException;

import it.equitalia.gestorefascicolows.bl.AnagraficaBl;
import it.equitalia.gestorefascicolows.bl.CartellaBl;
import it.equitalia.gestorefascicolows.bl.DBFactory;
import it.equitalia.gestorefascicolows.bl.EstrattoContoBl;
import it.equitalia.gestorefascicolows.bl.FascicoloBl;
import it.equitalia.gestorefascicolows.bl.PdfDocumentoBl;
import it.equitalia.gestorefascicolows.bl.RelateBl;
import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.FascicoloDAO;
import it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse;
import it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse;
import it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse;
import it.equitalia.gestorefascicolows.dati.RefreshFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.RefreshFascicoloWSResponse;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import org.apache.log4j.Logger;

public class GestoreFascicoloWSSoapBindingImpl implements it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface{
	static Logger logger = Logger.getLogger(GestoreFascicoloWSSoapBindingImpl.class);
	
	
	
	public it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse creazioneFascicolo(it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return FascicoloBl.creazioneFascicolo(in);

		
    }

    public it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse chiusuraFascicolo(it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return FascicoloBl.chiusuraFascicolo(in);
    }

    
	
	public it.equitalia.gestorefascicolows.dati.FascicoloList[] searchFascicolo(it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return FascicoloBl.searchFascicolo(in); 
    }

    
    public it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse getDocumentiEsattorialiNonCartelle(it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return FascicoloBl.getDocumentiEsattorialiNonCartelle(in);  
    }

	public it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse getFascicolo(it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
		return FascicoloBl.getFascicolo(in);   
    } 
 

	public it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse getCartella(it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
		return CartellaBl.getCartella(in);  
	}
 

	public it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse insertIndirizzo(it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
		return AnagraficaBl.insertIndirizzo(in);
		

    }


    public it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse insertTelefono(it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return AnagraficaBl.insertTelefono(in);
    }
    public it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse insertEmail(it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return AnagraficaBl.insertEmail(in);
    	
    }

    public it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse deleteIndirizzo(it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return AnagraficaBl.deleteIndirizzo(in);
    	
    }

    public it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse deleteTelefono(it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return AnagraficaBl.deleteTelefono(in);
    	
    }

    public it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse deleteEmail(it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
    	return AnagraficaBl.deleteEmail(in); 
    }

	public RefreshFascicoloWSResponse refreshFascicolo( RefreshFascicoloWSRequest in) throws RemoteException, FaultType { 
		return null;
	}


	public it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse getPdfDocumento(it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {

		return PdfDocumentoBl.getPdfDocumento(in);
    }

	public it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse bpsPdfDocumentoResult(it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {

		return PdfDocumentoBl.bpsPdfDocumentoResult(in);
    }

	public it.equitalia.gestorefascicolows.dati.GetRelateWSResponse getRelate(it.equitalia.gestorefascicolows.dati.GetRelateWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {

		return RelateBl.getRelate(in);
    }

	public it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse bpsRelateResult(it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {

		return RelateBl.bpsRelateResult(in);
    }
	



	public it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse pdfEstrattoConto(it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        return EstrattoContoBl.pdfEstrattoConto(in);
    }

	public it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse updateAnagrafica(it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        return AnagraficaBl.updateAnagrafica(in);
    }
 
	//inizio modifica 20-05-2015 cambio Wsdl
	public it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType callBackPdfDocumento(it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType in) throws java.rmi.RemoteException {
		return PdfDocumentoBl.callBackPdfDocumento(in);
    }

	//fine modifica 20-05-2015 cambio Wsdl

	//inizio 22-05-2015 RelateDocumentoStandard
	public it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType callBackRelateDocumento(it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType in) throws java.rmi.RemoteException, it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType {
        return RelateBl.callBackRelateDocumento(in); 
    } 
	//fine 22-05-2015 RelateDocumentoStandard
 
}
