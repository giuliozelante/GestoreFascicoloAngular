/**
 * EstrattoConto_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.estrattoconto.bpel;

public class EstrattoConto_ServiceLocator extends org.apache.axis.client.Service implements it.equitalia.estrattoconto.bpel.EstrattoConto_Service {

    public EstrattoConto_ServiceLocator() {
    }


    public EstrattoConto_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EstrattoConto_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EstrattoContoPort
    private java.lang.String EstrattoContoPort_address = "http://192.168.64.1:9765/services/EstrattoConto/";

    public java.lang.String getEstrattoContoPortAddress() {
        return EstrattoContoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EstrattoContoPortWSDDServiceName = "EstrattoContoPort";

    public java.lang.String getEstrattoContoPortWSDDServiceName() {
        return EstrattoContoPortWSDDServiceName;
    }

    public void setEstrattoContoPortWSDDServiceName(java.lang.String name) {
        EstrattoContoPortWSDDServiceName = name;
    }

    public it.equitalia.estrattoconto.bpel.EstrattoConto_PortType getEstrattoContoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EstrattoContoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEstrattoContoPort(endpoint);
    }

    public it.equitalia.estrattoconto.bpel.EstrattoConto_PortType getEstrattoContoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.estrattoconto.bpel.EstrattoContoBindingStub _stub = new it.equitalia.estrattoconto.bpel.EstrattoContoBindingStub(portAddress, this);
            _stub.setPortName(getEstrattoContoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEstrattoContoPortEndpointAddress(java.lang.String address) {
        EstrattoContoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.equitalia.estrattoconto.bpel.EstrattoConto_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.estrattoconto.bpel.EstrattoContoBindingStub _stub = new it.equitalia.estrattoconto.bpel.EstrattoContoBindingStub(new java.net.URL(EstrattoContoPort_address), this);
                _stub.setPortName(getEstrattoContoPortWSDDServiceName());
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
        if ("EstrattoContoPort".equals(inputPortName)) {
            return getEstrattoContoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "EstrattoConto");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "EstrattoContoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EstrattoContoPort".equals(portName)) {
            setEstrattoContoPortEndpointAddress(address);
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
