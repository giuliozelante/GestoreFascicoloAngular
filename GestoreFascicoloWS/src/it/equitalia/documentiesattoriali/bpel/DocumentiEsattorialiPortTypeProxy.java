package it.equitalia.documentiesattoriali.bpel;

public class DocumentiEsattorialiPortTypeProxy implements it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType {
  private String _endpoint = null;
  private it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType documentiEsattorialiPortType = null;
  
  public DocumentiEsattorialiPortTypeProxy() {
    _initDocumentiEsattorialiPortTypeProxy();
  }
  
  public DocumentiEsattorialiPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initDocumentiEsattorialiPortTypeProxy();
  }
  
  private void _initDocumentiEsattorialiPortTypeProxy() {
    try {
      documentiEsattorialiPortType = (new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiLocator()).getDocumentiEsattorialiHttpSoap11Endpoint();
      if (documentiEsattorialiPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)documentiEsattorialiPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)documentiEsattorialiPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (documentiEsattorialiPortType != null)
      ((javax.xml.rpc.Stub)documentiEsattorialiPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiPortType() {
    if (documentiEsattorialiPortType == null)
      _initDocumentiEsattorialiPortTypeProxy();
    return documentiEsattorialiPortType;
  }
  
  public it.equitalia.documentiesattoriali.bpel.BPSDocumentiEsattorialiResponse process(it.equitalia.documentiesattoriali.bpel.BPSDocumentiEsattorialiRequest payload) throws java.rmi.RemoteException{
    if (documentiEsattorialiPortType == null)
      _initDocumentiEsattorialiPortTypeProxy();
    return documentiEsattorialiPortType.process(payload);
  }
  
  
}