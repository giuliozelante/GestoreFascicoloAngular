/**
 * AperturaFascicoloLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.aperturafascicolo.bpel;

public class AperturaFascicoloLocator extends org.apache.axis.client.Service implements it.equitalia.aperturafascicolo.bpel.AperturaFascicolo {

    // Use to get a proxy class for AperturaFascicoloHttpsSoap12Endpoint
    private java.lang.String AperturaFascicoloHttpsSoap12Endpoint_address = "https://drlxwso2mgrtest01.equitaliaservizi.org:8243/services/AperturaFascicolo.AperturaFascicoloHttpsSoap12Endpoint";


    // The WSDD service name defaults to the port name.
    private java.lang.String AperturaFascicoloHttpsSoap12EndpointWSDDServiceName = "AperturaFascicoloHttpsSoap12Endpoint";

    // Use to get a proxy class for AperturaFascicoloHttpSoap11Endpoint
    private java.lang.String AperturaFascicoloHttpSoap11Endpoint_address = "http://drlxwso2mgrtest01.equitaliaservizi.org:8280/services/AperturaFascicolo.AperturaFascicoloHttpSoap11Endpoint";

    // The WSDD service name defaults to the port name.
    private java.lang.String AperturaFascicoloHttpSoap11EndpointWSDDServiceName = "AperturaFascicoloHttpSoap11Endpoint";

    // Use to get a proxy class for AperturaFascicoloHttpSoap12Endpoint
    private java.lang.String AperturaFascicoloHttpSoap12Endpoint_address = "http://drlxwso2mgrtest01.equitaliaservizi.org:8280/services/AperturaFascicolo.AperturaFascicoloHttpSoap12Endpoint";

    // The WSDD service name defaults to the port name.
    private java.lang.String AperturaFascicoloHttpSoap12EndpointWSDDServiceName = "AperturaFascicoloHttpSoap12Endpoint";

    // Use to get a proxy class for AperturaFascicoloHttpsSoap11Endpoint
    private java.lang.String AperturaFascicoloHttpsSoap11Endpoint_address = "https://drlxwso2mgrtest01.equitaliaservizi.org:8243/services/AperturaFascicolo.AperturaFascicoloHttpsSoap11Endpoint";

    // The WSDD service name defaults to the port name.
    private java.lang.String AperturaFascicoloHttpsSoap11EndpointWSDDServiceName = "AperturaFascicoloHttpsSoap11Endpoint";

    private java.util.HashSet ports = null;

    public AperturaFascicoloLocator() {
    }

    public AperturaFascicoloLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }


    public AperturaFascicoloLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AperturaFascicoloHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAperturaFascicoloHttpSoap11Endpoint(endpoint);
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub(portAddress, this);
            _stub.setPortName(getAperturaFascicoloHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getAperturaFascicoloHttpSoap11EndpointAddress() {
        return AperturaFascicoloHttpSoap11Endpoint_address;
    }

    public java.lang.String getAperturaFascicoloHttpSoap11EndpointWSDDServiceName() {
        return AperturaFascicoloHttpSoap11EndpointWSDDServiceName;
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AperturaFascicoloHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAperturaFascicoloHttpSoap12Endpoint(endpoint);
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub(portAddress, this);
            _stub.setPortName(getAperturaFascicoloHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getAperturaFascicoloHttpSoap12EndpointAddress() {
        return AperturaFascicoloHttpSoap12Endpoint_address;
    }


    public java.lang.String getAperturaFascicoloHttpSoap12EndpointWSDDServiceName() {
        return AperturaFascicoloHttpSoap12EndpointWSDDServiceName;
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AperturaFascicoloHttpsSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAperturaFascicoloHttpsSoap11Endpoint(endpoint);
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub(portAddress, this);
            _stub.setPortName(getAperturaFascicoloHttpsSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getAperturaFascicoloHttpsSoap11EndpointAddress() {
        return AperturaFascicoloHttpsSoap11Endpoint_address;
    }

    public java.lang.String getAperturaFascicoloHttpsSoap11EndpointWSDDServiceName() {
        return AperturaFascicoloHttpsSoap11EndpointWSDDServiceName;
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpsSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AperturaFascicoloHttpsSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAperturaFascicoloHttpsSoap12Endpoint(endpoint);
    }

    public it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType getAperturaFascicoloHttpsSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub(portAddress, this);
            _stub.setPortName(getAperturaFascicoloHttpsSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getAperturaFascicoloHttpsSoap12EndpointAddress() {
        return AperturaFascicoloHttpsSoap12Endpoint_address;
    }


    public java.lang.String getAperturaFascicoloHttpsSoap12EndpointWSDDServiceName() {
        return AperturaFascicoloHttpsSoap12EndpointWSDDServiceName;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    @Override
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub(new java.net.URL(AperturaFascicoloHttpsSoap12Endpoint_address), this);
                _stub.setPortName(getAperturaFascicoloHttpsSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub(new java.net.URL(AperturaFascicoloHttpSoap11Endpoint_address), this);
                _stub.setPortName(getAperturaFascicoloHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap12BindingStub(new java.net.URL(AperturaFascicoloHttpSoap12Endpoint_address), this);
                _stub.setPortName(getAperturaFascicoloHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.aperturafascicolo.bpel.AperturaFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub _stub = new it.equitalia.aperturafascicolo.bpel.AperturaFascicoloSoap11BindingStub(new java.net.URL(AperturaFascicoloHttpsSoap11Endpoint_address), this);
                _stub.setPortName(getAperturaFascicoloHttpsSoap11EndpointWSDDServiceName());
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
    @Override
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AperturaFascicoloHttpsSoap12Endpoint".equals(inputPortName)) {
            return getAperturaFascicoloHttpsSoap12Endpoint();
        }
        else if ("AperturaFascicoloHttpSoap11Endpoint".equals(inputPortName)) {
            return getAperturaFascicoloHttpSoap11Endpoint();
        }
        else if ("AperturaFascicoloHttpSoap12Endpoint".equals(inputPortName)) {
            return getAperturaFascicoloHttpSoap12Endpoint();
        }
        else if ("AperturaFascicoloHttpsSoap11Endpoint".equals(inputPortName)) {
            return getAperturaFascicoloHttpsSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bpel.aperturafascicolo.equitalia.it", "AperturaFascicoloHttpsSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.aperturafascicolo.equitalia.it", "AperturaFascicoloHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.aperturafascicolo.equitalia.it", "AperturaFascicoloHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.aperturafascicolo.equitalia.it", "AperturaFascicoloHttpsSoap11Endpoint"));
        }
        return ports.iterator();
    }

    @Override
	public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bpel.aperturafascicolo.equitalia.it", "AperturaFascicolo");
    }

    public void setAperturaFascicoloHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        AperturaFascicoloHttpSoap11Endpoint_address = address;
    }

    public void setAperturaFascicoloHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        AperturaFascicoloHttpSoap11EndpointWSDDServiceName = name;
    }

    public void setAperturaFascicoloHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        AperturaFascicoloHttpSoap12Endpoint_address = address;
    }

    public void setAperturaFascicoloHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        AperturaFascicoloHttpSoap12EndpointWSDDServiceName = name;
    }

    public void setAperturaFascicoloHttpsSoap11EndpointEndpointAddress(java.lang.String address) {
        AperturaFascicoloHttpsSoap11Endpoint_address = address;
    }

    public void setAperturaFascicoloHttpsSoap11EndpointWSDDServiceName(java.lang.String name) {
        AperturaFascicoloHttpsSoap11EndpointWSDDServiceName = name;
    }

    public void setAperturaFascicoloHttpsSoap12EndpointEndpointAddress(java.lang.String address) {
        AperturaFascicoloHttpsSoap12Endpoint_address = address;
    }

    public void setAperturaFascicoloHttpsSoap12EndpointWSDDServiceName(java.lang.String name) {
        AperturaFascicoloHttpsSoap12EndpointWSDDServiceName = name;
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

if ("AperturaFascicoloHttpsSoap12Endpoint".equals(portName)) {
            setAperturaFascicoloHttpsSoap12EndpointEndpointAddress(address);
        }
        else
if ("AperturaFascicoloHttpSoap11Endpoint".equals(portName)) {
            setAperturaFascicoloHttpSoap11EndpointEndpointAddress(address);
        }
        else
if ("AperturaFascicoloHttpSoap12Endpoint".equals(portName)) {
            setAperturaFascicoloHttpSoap12EndpointEndpointAddress(address);
        }
        else
if ("AperturaFascicoloHttpsSoap11Endpoint".equals(portName)) {
            setAperturaFascicoloHttpsSoap11EndpointEndpointAddress(address);
        }
        else { // Unknown Port Name
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
