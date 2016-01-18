/**
 * DettaglioCartellaAvvisoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class DettaglioCartellaAvvisoLocator extends org.apache.axis.client.Service implements it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvviso {

    public DettaglioCartellaAvvisoLocator() {
    }


    public DettaglioCartellaAvvisoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DettaglioCartellaAvvisoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DettaglioCartellaAvvisoPort
    private java.lang.String DettaglioCartellaAvvisoPort_address = "http://localhost:8080/DettaglioCartellaAvviso";

    public java.lang.String getDettaglioCartellaAvvisoPortAddress() {
        return DettaglioCartellaAvvisoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DettaglioCartellaAvvisoPortWSDDServiceName = "DettaglioCartellaAvvisoPort";

    public java.lang.String getDettaglioCartellaAvvisoPortWSDDServiceName() {
        return DettaglioCartellaAvvisoPortWSDDServiceName;
    }

    public void setDettaglioCartellaAvvisoPortWSDDServiceName(java.lang.String name) {
        DettaglioCartellaAvvisoPortWSDDServiceName = name;
    }

    public it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoPortType getDettaglioCartellaAvvisoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DettaglioCartellaAvvisoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDettaglioCartellaAvvisoPort(endpoint);
    }

    public it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoPortType getDettaglioCartellaAvvisoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoBindingStub _stub = new it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoBindingStub(portAddress, this);
            _stub.setPortName(getDettaglioCartellaAvvisoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDettaglioCartellaAvvisoPortEndpointAddress(java.lang.String address) {
        DettaglioCartellaAvvisoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoBindingStub _stub = new it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoBindingStub(new java.net.URL(DettaglioCartellaAvvisoPort_address), this);
                _stub.setPortName(getDettaglioCartellaAvvisoPortWSDDServiceName());
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
        if ("DettaglioCartellaAvvisoPort".equals(inputPortName)) {
            return getDettaglioCartellaAvvisoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DettaglioCartellaAvviso");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DettaglioCartellaAvvisoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DettaglioCartellaAvvisoPort".equals(portName)) {
            setDettaglioCartellaAvvisoPortEndpointAddress(address);
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
