/**
 * GestoreFascicoloWSInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.source;

public interface GestoreFascicoloWSInterface extends java.rmi.Remote {
    public it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse creazioneFascicolo(it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest aperturaFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse chiusuraFascicolo(it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest chiusuraFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse getFascicolo(it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest getFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse getCartella(it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest getCartellaWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse insertIndirizzo(it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest insertIndirizzoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse deleteIndirizzo(it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest deleteIndirizzoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse insertTelefono(it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest insertTelefonoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse deleteTelefono(it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest deleteTelefonoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse insertEmail(it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest insertEmailWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse deleteEmail(it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest deleteEmailWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.FascicoloList[] searchFascicolo(it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest searchFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse getDocumentiEsattorialiNonCartelle(it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse getPdfDocumento(it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse bpsPdfDocumentoResult(it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.GetRelateWSResponse getRelate(it.equitalia.gestorefascicolows.dati.GetRelateWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse bpsRelateResult(it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse pdfEstrattoConto(it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse updateAnagrafica(it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType;
    public it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType callBackPdfDocumento(it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType in) throws java.rmi.RemoteException;
    public it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType callBackRelateDocumento(it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType in) throws java.rmi.RemoteException, it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType;
}
