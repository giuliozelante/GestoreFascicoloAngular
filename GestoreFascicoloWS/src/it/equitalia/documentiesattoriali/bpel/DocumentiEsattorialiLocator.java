/**
 * DocumentiEsattorialiLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.documentiesattoriali.bpel;

public class DocumentiEsattorialiLocator extends org.apache.axis.client.Service implements it.equitalia.documentiesattoriali.bpel.DocumentiEsattoriali {

    public DocumentiEsattorialiLocator() {
    }


    public DocumentiEsattorialiLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DocumentiEsattorialiLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DocumentiEsattorialiHttpSoap11Endpoint
    private java.lang.String DocumentiEsattorialiHttpSoap11Endpoint_address = "http://server2003:8280/services/DocumentiEsattoriali.DocumentiEsattorialiHttpSoap11Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpSoap11EndpointAddress() {
        return DocumentiEsattorialiHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DocumentiEsattorialiHttpSoap11EndpointWSDDServiceName = "DocumentiEsattorialiHttpSoap11Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpSoap11EndpointWSDDServiceName() {
        return DocumentiEsattorialiHttpSoap11EndpointWSDDServiceName;
    }

    public void setDocumentiEsattorialiHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        DocumentiEsattorialiHttpSoap11EndpointWSDDServiceName = name;
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DocumentiEsattorialiHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDocumentiEsattorialiHttpSoap11Endpoint(endpoint);
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub(portAddress, this);
            _stub.setPortName(getDocumentiEsattorialiHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDocumentiEsattorialiHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        DocumentiEsattorialiHttpSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for DocumentiEsattorialiHttpSoap12Endpoint
    private java.lang.String DocumentiEsattorialiHttpSoap12Endpoint_address = "http://server2003:8280/services/DocumentiEsattoriali.DocumentiEsattorialiHttpSoap12Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpSoap12EndpointAddress() {
        return DocumentiEsattorialiHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DocumentiEsattorialiHttpSoap12EndpointWSDDServiceName = "DocumentiEsattorialiHttpSoap12Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpSoap12EndpointWSDDServiceName() {
        return DocumentiEsattorialiHttpSoap12EndpointWSDDServiceName;
    }

    public void setDocumentiEsattorialiHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        DocumentiEsattorialiHttpSoap12EndpointWSDDServiceName = name;
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DocumentiEsattorialiHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDocumentiEsattorialiHttpSoap12Endpoint(endpoint);
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub(portAddress, this);
            _stub.setPortName(getDocumentiEsattorialiHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDocumentiEsattorialiHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        DocumentiEsattorialiHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for DocumentiEsattorialiHttpsSoap11Endpoint
    private java.lang.String DocumentiEsattorialiHttpsSoap11Endpoint_address = "https://server2003:8243/services/DocumentiEsattoriali.DocumentiEsattorialiHttpsSoap11Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpsSoap11EndpointAddress() {
        return DocumentiEsattorialiHttpsSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DocumentiEsattorialiHttpsSoap11EndpointWSDDServiceName = "DocumentiEsattorialiHttpsSoap11Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpsSoap11EndpointWSDDServiceName() {
        return DocumentiEsattorialiHttpsSoap11EndpointWSDDServiceName;
    }

    public void setDocumentiEsattorialiHttpsSoap11EndpointWSDDServiceName(java.lang.String name) {
        DocumentiEsattorialiHttpsSoap11EndpointWSDDServiceName = name;
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DocumentiEsattorialiHttpsSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDocumentiEsattorialiHttpsSoap11Endpoint(endpoint);
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub(portAddress, this);
            _stub.setPortName(getDocumentiEsattorialiHttpsSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDocumentiEsattorialiHttpsSoap11EndpointEndpointAddress(java.lang.String address) {
        DocumentiEsattorialiHttpsSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for DocumentiEsattorialiHttpsSoap12Endpoint
    private java.lang.String DocumentiEsattorialiHttpsSoap12Endpoint_address = "https://server2003:8243/services/DocumentiEsattoriali.DocumentiEsattorialiHttpsSoap12Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpsSoap12EndpointAddress() {
        return DocumentiEsattorialiHttpsSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DocumentiEsattorialiHttpsSoap12EndpointWSDDServiceName = "DocumentiEsattorialiHttpsSoap12Endpoint";

    public java.lang.String getDocumentiEsattorialiHttpsSoap12EndpointWSDDServiceName() {
        return DocumentiEsattorialiHttpsSoap12EndpointWSDDServiceName;
    }

    public void setDocumentiEsattorialiHttpsSoap12EndpointWSDDServiceName(java.lang.String name) {
        DocumentiEsattorialiHttpsSoap12EndpointWSDDServiceName = name;
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpsSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DocumentiEsattorialiHttpsSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDocumentiEsattorialiHttpsSoap12Endpoint(endpoint);
    }

    public it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType getDocumentiEsattorialiHttpsSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub(portAddress, this);
            _stub.setPortName(getDocumentiEsattorialiHttpsSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDocumentiEsattorialiHttpsSoap12EndpointEndpointAddress(java.lang.String address) {
        DocumentiEsattorialiHttpsSoap12Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub(new java.net.URL(DocumentiEsattorialiHttpSoap11Endpoint_address), this);
                _stub.setPortName(getDocumentiEsattorialiHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub(new java.net.URL(DocumentiEsattorialiHttpSoap12Endpoint_address), this);
                _stub.setPortName(getDocumentiEsattorialiHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap11BindingStub(new java.net.URL(DocumentiEsattorialiHttpsSoap11Endpoint_address), this);
                _stub.setPortName(getDocumentiEsattorialiHttpsSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub _stub = new it.equitalia.documentiesattoriali.bpel.DocumentiEsattorialiSoap12BindingStub(new java.net.URL(DocumentiEsattorialiHttpsSoap12Endpoint_address), this);
                _stub.setPortName(getDocumentiEsattorialiHttpsSoap12EndpointWSDDServiceName());
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
        if ("DocumentiEsattorialiHttpSoap11Endpoint".equals(inputPortName)) {
            return getDocumentiEsattorialiHttpSoap11Endpoint();
        }
        else if ("DocumentiEsattorialiHttpSoap12Endpoint".equals(inputPortName)) {
            return getDocumentiEsattorialiHttpSoap12Endpoint();
        }
        else if ("DocumentiEsattorialiHttpsSoap11Endpoint".equals(inputPortName)) {
            return getDocumentiEsattorialiHttpsSoap11Endpoint();
        }
        else if ("DocumentiEsattorialiHttpsSoap12Endpoint".equals(inputPortName)) {
            return getDocumentiEsattorialiHttpsSoap12Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "DocumentiEsattoriali");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "DocumentiEsattorialiHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "DocumentiEsattorialiHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "DocumentiEsattorialiHttpsSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "DocumentiEsattorialiHttpsSoap12Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DocumentiEsattorialiHttpSoap11Endpoint".equals(portName)) {
            setDocumentiEsattorialiHttpSoap11EndpointEndpointAddress(address);
        }
        else 
if ("DocumentiEsattorialiHttpSoap12Endpoint".equals(portName)) {
            setDocumentiEsattorialiHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("DocumentiEsattorialiHttpsSoap11Endpoint".equals(portName)) {
            setDocumentiEsattorialiHttpsSoap11EndpointEndpointAddress(address);
        }
        else 
if ("DocumentiEsattorialiHttpsSoap12Endpoint".equals(portName)) {
            setDocumentiEsattorialiHttpsSoap12EndpointEndpointAddress(address);
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
