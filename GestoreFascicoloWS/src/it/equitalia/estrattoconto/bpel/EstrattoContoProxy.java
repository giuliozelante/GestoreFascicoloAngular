package it.equitalia.estrattoconto.bpel;

public class EstrattoContoProxy implements it.equitalia.estrattoconto.bpel.EstrattoConto_PortType {
  private String _endpoint = null;
  private it.equitalia.estrattoconto.bpel.EstrattoConto_PortType estrattoConto_PortType = null;
  
  public EstrattoContoProxy() {
    _initEstrattoContoProxy();
  }
  
  public EstrattoContoProxy(String endpoint) {
    _endpoint = endpoint;
    _initEstrattoContoProxy();
  }
  
  private void _initEstrattoContoProxy() {
    try {
      estrattoConto_PortType = (new it.equitalia.estrattoconto.bpel.EstrattoConto_ServiceLocator()).getEstrattoContoPort();
      if (estrattoConto_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)estrattoConto_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)estrattoConto_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (estrattoConto_PortType != null)
      ((javax.xml.rpc.Stub)estrattoConto_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.equitalia.estrattoconto.bpel.EstrattoConto_PortType getEstrattoConto_PortType() {
    if (estrattoConto_PortType == null)
      _initEstrattoContoProxy();
    return estrattoConto_PortType;
  }
  
  public it.equitalia.estrattoconto.bpel.EstrattoContoResponse process(it.equitalia.estrattoconto.bpel.EstrattoContoRequest payload) throws java.rmi.RemoteException{
    if (estrattoConto_PortType == null)
      _initEstrattoContoProxy();
    return estrattoConto_PortType.process(payload);
  }
  
  
}