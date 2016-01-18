package it.equitalia.cartelleavvisi.wsdl;

public class CartelleAvvisiProxy implements it.equitalia.cartelleavvisi.wsdl.CartelleAvvisi_PortType {
  private String _endpoint = null;
  private it.equitalia.cartelleavvisi.wsdl.CartelleAvvisi_PortType cartelleAvvisi_PortType = null;
  
  public CartelleAvvisiProxy() {
    _initCartelleAvvisiProxy();
  }
  
  public CartelleAvvisiProxy(String endpoint) {
    _endpoint = endpoint;
    _initCartelleAvvisiProxy();
  }
  
  private void _initCartelleAvvisiProxy() {
    try {
      cartelleAvvisi_PortType = (new it.equitalia.cartelleavvisi.wsdl.CartelleAvvisi_ServiceLocator()).getCartelleAvvisiPort();
      if (cartelleAvvisi_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cartelleAvvisi_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cartelleAvvisi_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cartelleAvvisi_PortType != null)
      ((javax.xml.rpc.Stub)cartelleAvvisi_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.equitalia.cartelleavvisi.wsdl.CartelleAvvisi_PortType getCartelleAvvisi_PortType() {
    if (cartelleAvvisi_PortType == null)
      _initCartelleAvvisiProxy();
    return cartelleAvvisi_PortType;
  }
  
  public it.equitalia.cartelleavvisi.wsdl.CartelleAvvisiResponseType process(it.equitalia.cartelleavvisi.wsdl.CartellaAvvisiRequestType payload) throws java.rmi.RemoteException{
    if (cartelleAvvisi_PortType == null)
      _initCartelleAvvisiProxy();
    return cartelleAvvisi_PortType.process(payload);
  }
  
  
}