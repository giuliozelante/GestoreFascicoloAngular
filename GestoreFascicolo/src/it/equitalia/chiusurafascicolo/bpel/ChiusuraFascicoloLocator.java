/**
 * ChiusuraFascicoloLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.chiusurafascicolo.bpel;

public class ChiusuraFascicoloLocator extends org.apache.axis.client.Service implements it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicolo {

    // Use to get a proxy class for ChiusuraFascicoloHttpSoap11Endpoint
    private java.lang.String ChiusuraFascicoloHttpSoap11Endpoint_address = "http://drlxwso2mgrtest01.equitaliaservizi.org:8280/services/ChiusuraFascicolo.ChiusuraFascicoloHttpSoap11Endpoint";


    // The WSDD service name defaults to the port name.
    private java.lang.String ChiusuraFascicoloHttpSoap11EndpointWSDDServiceName = "ChiusuraFascicoloHttpSoap11Endpoint";

    // Use to get a proxy class for ChiusuraFascicoloHttpSoap12Endpoint
    private java.lang.String ChiusuraFascicoloHttpSoap12Endpoint_address = "http://drlxwso2mgrtest01.equitaliaservizi.org:8280/services/ChiusuraFascicolo.ChiusuraFascicoloHttpSoap12Endpoint";

    // The WSDD service name defaults to the port name.
    private java.lang.String ChiusuraFascicoloHttpSoap12EndpointWSDDServiceName = "ChiusuraFascicoloHttpSoap12Endpoint";

    // Use to get a proxy class for ChiusuraFascicoloHttpsSoap11Endpoint
    private java.lang.String ChiusuraFascicoloHttpsSoap11Endpoint_address = "https://drlxwso2mgrtest01.equitaliaservizi.org:8243/services/ChiusuraFascicolo.ChiusuraFascicoloHttpsSoap11Endpoint";

    // The WSDD service name defaults to the port name.
    private java.lang.String ChiusuraFascicoloHttpsSoap11EndpointWSDDServiceName = "ChiusuraFascicoloHttpsSoap11Endpoint";

    // Use to get a proxy class for ChiusuraFascicoloHttpsSoap12Endpoint
    private java.lang.String ChiusuraFascicoloHttpsSoap12Endpoint_address = "https://drlxwso2mgrtest01.equitaliaservizi.org:8243/services/ChiusuraFascicolo.ChiusuraFascicoloHttpsSoap12Endpoint";

    // The WSDD service name defaults to the port name.
    private java.lang.String ChiusuraFascicoloHttpsSoap12EndpointWSDDServiceName = "ChiusuraFascicoloHttpsSoap12Endpoint";

    private java.util.HashSet ports = null;

    public ChiusuraFascicoloLocator() {
    }

    public ChiusuraFascicoloLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }


    public ChiusuraFascicoloLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ChiusuraFascicoloHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getChiusuraFascicoloHttpSoap11Endpoint(endpoint);
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub(portAddress, this);
            _stub.setPortName(getChiusuraFascicoloHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getChiusuraFascicoloHttpSoap11EndpointAddress() {
        return ChiusuraFascicoloHttpSoap11Endpoint_address;
    }

    public java.lang.String getChiusuraFascicoloHttpSoap11EndpointWSDDServiceName() {
        return ChiusuraFascicoloHttpSoap11EndpointWSDDServiceName;
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ChiusuraFascicoloHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getChiusuraFascicoloHttpSoap12Endpoint(endpoint);
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub(portAddress, this);
            _stub.setPortName(getChiusuraFascicoloHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getChiusuraFascicoloHttpSoap12EndpointAddress() {
        return ChiusuraFascicoloHttpSoap12Endpoint_address;
    }


    public java.lang.String getChiusuraFascicoloHttpSoap12EndpointWSDDServiceName() {
        return ChiusuraFascicoloHttpSoap12EndpointWSDDServiceName;
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ChiusuraFascicoloHttpsSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getChiusuraFascicoloHttpsSoap11Endpoint(endpoint);
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub(portAddress, this);
            _stub.setPortName(getChiusuraFascicoloHttpsSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getChiusuraFascicoloHttpsSoap11EndpointAddress() {
        return ChiusuraFascicoloHttpsSoap11Endpoint_address;
    }

    public java.lang.String getChiusuraFascicoloHttpsSoap11EndpointWSDDServiceName() {
        return ChiusuraFascicoloHttpsSoap11EndpointWSDDServiceName;
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpsSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ChiusuraFascicoloHttpsSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getChiusuraFascicoloHttpsSoap12Endpoint(endpoint);
    }

    public it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType getChiusuraFascicoloHttpsSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub(portAddress, this);
            _stub.setPortName(getChiusuraFascicoloHttpsSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public java.lang.String getChiusuraFascicoloHttpsSoap12EndpointAddress() {
        return ChiusuraFascicoloHttpsSoap12Endpoint_address;
    }


    public java.lang.String getChiusuraFascicoloHttpsSoap12EndpointWSDDServiceName() {
        return ChiusuraFascicoloHttpsSoap12EndpointWSDDServiceName;
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
            if (it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub(new java.net.URL(ChiusuraFascicoloHttpSoap11Endpoint_address), this);
                _stub.setPortName(getChiusuraFascicoloHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub(new java.net.URL(ChiusuraFascicoloHttpSoap12Endpoint_address), this);
                _stub.setPortName(getChiusuraFascicoloHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap11BindingStub(new java.net.URL(ChiusuraFascicoloHttpsSoap11Endpoint_address), this);
                _stub.setPortName(getChiusuraFascicoloHttpsSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub _stub = new it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloSoap12BindingStub(new java.net.URL(ChiusuraFascicoloHttpsSoap12Endpoint_address), this);
                _stub.setPortName(getChiusuraFascicoloHttpsSoap12EndpointWSDDServiceName());
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
        if ("ChiusuraFascicoloHttpSoap11Endpoint".equals(inputPortName)) {
            return getChiusuraFascicoloHttpSoap11Endpoint();
        }
        else if ("ChiusuraFascicoloHttpSoap12Endpoint".equals(inputPortName)) {
            return getChiusuraFascicoloHttpSoap12Endpoint();
        }
        else if ("ChiusuraFascicoloHttpsSoap11Endpoint".equals(inputPortName)) {
            return getChiusuraFascicoloHttpsSoap11Endpoint();
        }
        else if ("ChiusuraFascicoloHttpsSoap12Endpoint".equals(inputPortName)) {
            return getChiusuraFascicoloHttpsSoap12Endpoint();
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
            ports.add(new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", "ChiusuraFascicoloHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", "ChiusuraFascicoloHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", "ChiusuraFascicoloHttpsSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", "ChiusuraFascicoloHttpsSoap12Endpoint"));
        }
        return ports.iterator();
    }

    @Override
	public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", "ChiusuraFascicolo");
    }

    public void setChiusuraFascicoloHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        ChiusuraFascicoloHttpSoap11Endpoint_address = address;
    }

    public void setChiusuraFascicoloHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        ChiusuraFascicoloHttpSoap11EndpointWSDDServiceName = name;
    }

    public void setChiusuraFascicoloHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        ChiusuraFascicoloHttpSoap12Endpoint_address = address;
    }

    public void setChiusuraFascicoloHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        ChiusuraFascicoloHttpSoap12EndpointWSDDServiceName = name;
    }

    public void setChiusuraFascicoloHttpsSoap11EndpointEndpointAddress(java.lang.String address) {
        ChiusuraFascicoloHttpsSoap11Endpoint_address = address;
    }

    public void setChiusuraFascicoloHttpsSoap11EndpointWSDDServiceName(java.lang.String name) {
        ChiusuraFascicoloHttpsSoap11EndpointWSDDServiceName = name;
    }

    public void setChiusuraFascicoloHttpsSoap12EndpointEndpointAddress(java.lang.String address) {
        ChiusuraFascicoloHttpsSoap12Endpoint_address = address;
    }

    public void setChiusuraFascicoloHttpsSoap12EndpointWSDDServiceName(java.lang.String name) {
        ChiusuraFascicoloHttpsSoap12EndpointWSDDServiceName = name;
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ChiusuraFascicoloHttpSoap11Endpoint".equals(portName)) {
            setChiusuraFascicoloHttpSoap11EndpointEndpointAddress(address);
        }
        else 
if ("ChiusuraFascicoloHttpSoap12Endpoint".equals(portName)) {
            setChiusuraFascicoloHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("ChiusuraFascicoloHttpsSoap11Endpoint".equals(portName)) {
            setChiusuraFascicoloHttpsSoap11EndpointEndpointAddress(address);
        }
        else 
if ("ChiusuraFascicoloHttpsSoap12Endpoint".equals(portName)) {
            setChiusuraFascicoloHttpsSoap12EndpointEndpointAddress(address);
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
