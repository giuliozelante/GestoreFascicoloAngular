package it.equitalia.relatedocumentostandard.bpel;

public class RelateDocumentoStandardPortTypeProxy implements it.equitalia.relatedocumentostandard.bpel.RelateDocumentoStandardPortType {
  private String _endpoint = null;
  private it.equitalia.relatedocumentostandard.bpel.RelateDocumentoStandardPortType relateDocumentoStandardPortType = null;
  
  public RelateDocumentoStandardPortTypeProxy() {
    _initRelateDocumentoStandardPortTypeProxy();
  }
  
  public RelateDocumentoStandardPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initRelateDocumentoStandardPortTypeProxy();
  }
  
  private void _initRelateDocumentoStandardPortTypeProxy() {
    try {
      relateDocumentoStandardPortType = (new it.equitalia.relatedocumentostandard.bpel.RelateDocumentoStandardLocator()).getRelateDocumentoStandardSOAP11port_http();
      if (relateDocumentoStandardPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)relateDocumentoStandardPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)relateDocumentoStandardPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (relateDocumentoStandardPortType != null)
      ((javax.xml.rpc.Stub)relateDocumentoStandardPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.equitalia.relatedocumentostandard.bpel.RelateDocumentoStandardPortType getRelateDocumentoStandardPortType() {
    if (relateDocumentoStandardPortType == null)
      _initRelateDocumentoStandardPortTypeProxy();
    return relateDocumentoStandardPortType;
  }
  
  public it.equitalia.relatedocumentostandard.bpel.xsd.GetRelateDocumentoResponseType getRelateDocumentoStandard(it.equitalia.relatedocumentostandard.bpel.xsd.GetRelateDocumentoRequestType part1) throws java.rmi.RemoteException, it.equitalia.relatedocumentostandard.bpel.xsd.GetRelateDocumentoFaultType{
    if (relateDocumentoStandardPortType == null)
      _initRelateDocumentoStandardPortTypeProxy();
    return relateDocumentoStandardPortType.getRelateDocumentoStandard(part1);
  }
  
  
}