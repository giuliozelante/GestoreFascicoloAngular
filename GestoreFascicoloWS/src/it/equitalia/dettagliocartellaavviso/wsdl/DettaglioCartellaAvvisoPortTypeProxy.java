package it.equitalia.dettagliocartellaavviso.wsdl;

public class DettaglioCartellaAvvisoPortTypeProxy implements it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoPortType {
  private String _endpoint = null;
  private it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoPortType dettaglioCartellaAvvisoPortType = null;
  
  public DettaglioCartellaAvvisoPortTypeProxy() {
    _initDettaglioCartellaAvvisoPortTypeProxy();
  }
  
  public DettaglioCartellaAvvisoPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initDettaglioCartellaAvvisoPortTypeProxy();
  }
  
  private void _initDettaglioCartellaAvvisoPortTypeProxy() {
    try {
      dettaglioCartellaAvvisoPortType = (new it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoLocator()).getDettaglioCartellaAvvisoPort();
      if (dettaglioCartellaAvvisoPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dettaglioCartellaAvvisoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dettaglioCartellaAvvisoPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dettaglioCartellaAvvisoPortType != null)
      ((javax.xml.rpc.Stub)dettaglioCartellaAvvisoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoPortType getDettaglioCartellaAvvisoPortType() {
    if (dettaglioCartellaAvvisoPortType == null)
      _initDettaglioCartellaAvvisoPortTypeProxy();
    return dettaglioCartellaAvvisoPortType;
  }
  
  public it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoResponse process(it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoRequest payload) throws java.rmi.RemoteException{
    if (dettaglioCartellaAvvisoPortType == null)
      _initDettaglioCartellaAvvisoPortTypeProxy();
    return dettaglioCartellaAvvisoPortType.process(payload);
  }
  
  
}