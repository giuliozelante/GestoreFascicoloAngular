package it.equitalia.pdfdocumentostandard.bpel;

public class PdfDocumentoStandardPortTypeProxy implements it.equitalia.pdfdocumentostandard.bpel.PdfDocumentoStandardPortType {
  private String _endpoint = null;
  private it.equitalia.pdfdocumentostandard.bpel.PdfDocumentoStandardPortType pdfDocumentoStandardPortType = null;
  
  public PdfDocumentoStandardPortTypeProxy() {
    _initPdfDocumentoStandardPortTypeProxy();
  }
  
  public PdfDocumentoStandardPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPdfDocumentoStandardPortTypeProxy();
  }
  
  private void _initPdfDocumentoStandardPortTypeProxy() {
    try {
      pdfDocumentoStandardPortType = (new it.equitalia.pdfdocumentostandard.bpel.PdfDocumentoStandardLocator()).getPdfDocumentoStandardSOAP11port_http();
      if (pdfDocumentoStandardPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pdfDocumentoStandardPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pdfDocumentoStandardPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pdfDocumentoStandardPortType != null)
      ((javax.xml.rpc.Stub)pdfDocumentoStandardPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.equitalia.pdfdocumentostandard.bpel.PdfDocumentoStandardPortType getPdfDocumentoStandardPortType() {
    if (pdfDocumentoStandardPortType == null)
      _initPdfDocumentoStandardPortTypeProxy();
    return pdfDocumentoStandardPortType;
  }
  
  public it.equitalia.pdfdocumentostandard.bpel.xsd.GetPdfDocumentoResponseType getPdfDocumento(it.equitalia.pdfdocumentostandard.bpel.xsd.GetPdfDocumentoRequestType part1) throws java.rmi.RemoteException{
    if (pdfDocumentoStandardPortType == null)
      _initPdfDocumentoStandardPortTypeProxy();
    return pdfDocumentoStandardPortType.getPdfDocumento(part1);
  }
  
  
}