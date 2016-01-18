/**
 * GestoreFascicoloWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.source;

public class GestoreFascicoloWSLocator extends org.apache.axis.client.Service implements it.equitalia.gestorefascicolows.source.GestoreFascicoloWS {

    public GestoreFascicoloWSLocator() {
    }


    public GestoreFascicoloWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GestoreFascicoloWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GestoreFascicoloWS
    private java.lang.String GestoreFascicoloWS_address = "http://tempuri.org/GestoreFascicoloWS/services/GestoreFascicoloWS";

    public java.lang.String getGestoreFascicoloWSAddress() {
        return GestoreFascicoloWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GestoreFascicoloWSWSDDServiceName = "GestoreFascicoloWS";

    public java.lang.String getGestoreFascicoloWSWSDDServiceName() {
        return GestoreFascicoloWSWSDDServiceName;
    }

    public void setGestoreFascicoloWSWSDDServiceName(java.lang.String name) {
        GestoreFascicoloWSWSDDServiceName = name;
    }

    public it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface getGestoreFascicoloWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GestoreFascicoloWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGestoreFascicoloWS(endpoint);
    }

    public it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface getGestoreFascicoloWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.gestorefascicolows.source.GestoreFascicoloWSSoapBindingStub _stub = new it.equitalia.gestorefascicolows.source.GestoreFascicoloWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getGestoreFascicoloWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGestoreFascicoloWSEndpointAddress(java.lang.String address) {
        GestoreFascicoloWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.gestorefascicolows.source.GestoreFascicoloWSSoapBindingStub _stub = new it.equitalia.gestorefascicolows.source.GestoreFascicoloWSSoapBindingStub(new java.net.URL(GestoreFascicoloWS_address), this);
                _stub.setPortName(getGestoreFascicoloWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GestoreFascicoloWS".equals(inputPortName)) {
            return getGestoreFascicoloWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://source.gestorefascicolows.equitalia.it", "GestoreFascicoloWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://source.gestorefascicolows.equitalia.it", "GestoreFascicoloWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GestoreFascicoloWS".equals(portName)) {
            setGestoreFascicoloWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
