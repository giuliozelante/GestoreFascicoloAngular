/**
 * GestoreFascicoloWSSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.source;

public class GestoreFascicoloWSSoapBindingSkeleton implements it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface, org.apache.axis.wsdl.Skeleton {
    private it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "aperturaFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">aperturaFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("creazioneFascicolo", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "aperturaFascicoloWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">aperturaFascicoloWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "creazioneFascicolo"));
        _oper.setSoapAction("urn:aperturaFascicolo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("creazioneFascicolo") == null) {
            _myOperations.put("creazioneFascicolo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("creazioneFascicolo")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "chiusuraFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">chiusuraFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("chiusuraFascicolo", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "chiusuraFascicoloWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">chiusuraFascicoloWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "chiusuraFascicolo"));
        _oper.setSoapAction("urn:chiusuraFascicolo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("chiusuraFascicolo") == null) {
            _myOperations.put("chiusuraFascicolo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("chiusuraFascicolo")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getFascicolo", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getFascicoloWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getFascicoloWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getFascicolo"));
        _oper.setSoapAction("urn:getFascicolo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getFascicolo") == null) {
            _myOperations.put("getFascicolo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getFascicolo")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getCartellaWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getCartellaWSRequest"), it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getCartella", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getCartellaWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getCartellaWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getCartella"));
        _oper.setSoapAction("urn:getCartella");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCartella") == null) {
            _myOperations.put("getCartella", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getCartella")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertIndirizzoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertIndirizzoWSRequest"), it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertIndirizzo", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertIndirizzoWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertIndirizzoWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "insertIndirizzo"));
        _oper.setSoapAction("urn:insertIndirizzo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertIndirizzo") == null) {
            _myOperations.put("insertIndirizzo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertIndirizzo")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteIndirizzoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteIndirizzoWSRequest"), it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("deleteIndirizzo", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteIndirizzoWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteIndirizzoWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "deleteIndirizzo"));
        _oper.setSoapAction("urn:deleteIndirizzo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("deleteIndirizzo") == null) {
            _myOperations.put("deleteIndirizzo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("deleteIndirizzo")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertTelefonoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertTelefonoWSRequest"), it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertTelefono", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertTelefonoWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertTelefonoWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "insertTelefono"));
        _oper.setSoapAction("urn:insertTelefono");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertTelefono") == null) {
            _myOperations.put("insertTelefono", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertTelefono")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteTelefonoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteTelefonoWSRequest"), it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("deleteTelefono", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteTelefonoWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteTelefonoWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "deleteTelefono"));
        _oper.setSoapAction("urn:deleteTelefono");
        _myOperationsList.add(_oper);
        if (_myOperations.get("deleteTelefono") == null) {
            _myOperations.put("deleteTelefono", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("deleteTelefono")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertEmailWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertEmailWSRequest"), it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertEmail", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertEmailWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertEmailWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "insertEmail"));
        _oper.setSoapAction("urn:insertEmail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertEmail") == null) {
            _myOperations.put("insertEmail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertEmail")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteEmailWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteEmailWSRequest"), it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("deleteEmail", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteEmailWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteEmailWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "deleteEmail"));
        _oper.setSoapAction("urn:deleteEmail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("deleteEmail") == null) {
            _myOperations.put("deleteEmail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("deleteEmail")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "searchFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">searchFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchFascicolo", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "searchFascicoloWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">searchFascicoloWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "searchFascicolo"));
        _oper.setSoapAction("urn:searchFascicolo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchFascicolo") == null) {
            _myOperations.put("searchFascicolo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchFascicolo")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getDocumentiEsattorialiNonCartelleWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getDocumentiEsattorialiNonCartelleWSRequest"), it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDocumentiEsattorialiNonCartelle", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getDocumentiEsattorialiNonCartelleWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getDocumentiEsattorialiNonCartelleWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getDocumentiEsattorialiNonCartelle"));
        _oper.setSoapAction("urn:getDocumentiEsattorialiNonCartelle");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDocumentiEsattorialiNonCartelle") == null) {
            _myOperations.put("getDocumentiEsattorialiNonCartelle", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDocumentiEsattorialiNonCartelle")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getPdfDocumentoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getPdfDocumentoWSRequest"), it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getPdfDocumento", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getPdfDocumentoWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getPdfDocumentoWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getPdfDocumento"));
        _oper.setSoapAction("urn:getPdfDocumento");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getPdfDocumento") == null) {
            _myOperations.put("getPdfDocumento", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getPdfDocumento")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsPdfDocumentoResultWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsPdfDocumentoResultWSRequest"), it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("bpsPdfDocumentoResult", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsPdfDocumentoResultWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsPdfDocumentoResultWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "bpsPdfDocumentoResult"));
        _oper.setSoapAction("urn:bpsPdfDocumentoResult");
        _myOperationsList.add(_oper);
        if (_myOperations.get("bpsPdfDocumentoResult") == null) {
            _myOperations.put("bpsPdfDocumentoResult", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("bpsPdfDocumentoResult")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getRelateWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getRelateWSRequest"), it.equitalia.gestorefascicolows.dati.GetRelateWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getRelate", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getRelateWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getRelateWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getRelate"));
        _oper.setSoapAction("urn:getRelate");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRelate") == null) {
            _myOperations.put("getRelate", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getRelate")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsRelateResultWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsRelateResultWSRequest"), it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("bpsRelateResult", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsRelateResultWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsRelateResultWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "bpsRelateResult"));
        _oper.setSoapAction("urn:bpsRelateResult");
        _myOperationsList.add(_oper);
        if (_myOperations.get("bpsRelateResult") == null) {
            _myOperations.put("bpsRelateResult", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("bpsRelateResult")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "pdfEstrattoContoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">pdfEstrattoContoWSRequest"), it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("pdfEstrattoConto", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "pdfEstrattoContoWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">pdfEstrattoContoWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "pdfEstrattoConto"));
        _oper.setSoapAction("urn:pdfEstrattoConto");
        _myOperationsList.add(_oper);
        if (_myOperations.get("pdfEstrattoConto") == null) {
            _myOperations.put("pdfEstrattoConto", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("pdfEstrattoConto")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "updateAnagraficaWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">updateAnagraficaWSRequest"), it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("updateAnagrafica", _params, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "updateAnagraficaWSResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">updateAnagraficaWSResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "updateAnagrafica"));
        _oper.setSoapAction("urn:updateAnagrafica");
        _myOperationsList.add(_oper);
        if (_myOperations.get("updateAnagrafica") == null) {
            _myOperations.put("updateAnagrafica", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("updateAnagrafica")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("FaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"));
        _fault.setClassName("it.equitalia.gestorefascicolows.srv.FaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoRequestType"), it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("callBackPdfDocumento", _params, new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoResponseType"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "CallBackPdfDocumento"));
        _oper.setSoapAction("urn:CallBackPdfDocumento");
        _myOperationsList.add(_oper);
        if (_myOperations.get("callBackPdfDocumento") == null) {
            _myOperations.put("callBackPdfDocumento", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("callBackPdfDocumento")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoRequestType"), it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("callBackRelateDocumento", _params, new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoResponseType"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "callBackRelateDocumento"));
        _oper.setSoapAction("urn:callBackRelateDocumento");
        _myOperationsList.add(_oper);
        if (_myOperations.get("callBackRelateDocumento") == null) {
            _myOperations.put("callBackRelateDocumento", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("callBackRelateDocumento")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CallBackRelateDocumentoFaultType");
        _fault.setQName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoFault"));
        _fault.setClassName("it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType");
        _fault.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoFaultType"));
        _oper.addFault(_fault);
    }

    public GestoreFascicoloWSSoapBindingSkeleton() {
        this.impl = new it.equitalia.gestorefascicolows.source.GestoreFascicoloWSSoapBindingImpl();
    }

    public GestoreFascicoloWSSoapBindingSkeleton(it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface impl) {
        this.impl = impl;
    }
    public it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse creazioneFascicolo(it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest aperturaFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse ret = impl.creazioneFascicolo(aperturaFascicoloWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse chiusuraFascicolo(it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest chiusuraFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse ret = impl.chiusuraFascicolo(chiusuraFascicoloWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse getFascicolo(it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest getFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse ret = impl.getFascicolo(getFascicoloWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse getCartella(it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest getCartellaWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse ret = impl.getCartella(getCartellaWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse insertIndirizzo(it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest insertIndirizzoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse ret = impl.insertIndirizzo(insertIndirizzoWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse deleteIndirizzo(it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest deleteIndirizzoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse ret = impl.deleteIndirizzo(deleteIndirizzoWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse insertTelefono(it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest insertTelefonoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse ret = impl.insertTelefono(insertTelefonoWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse deleteTelefono(it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest deleteTelefonoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse ret = impl.deleteTelefono(deleteTelefonoWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse insertEmail(it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest insertEmailWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse ret = impl.insertEmail(insertEmailWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse deleteEmail(it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest deleteEmailWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse ret = impl.deleteEmail(deleteEmailWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.FascicoloList[] searchFascicolo(it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest searchFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.FascicoloList[] ret = impl.searchFascicolo(searchFascicoloWSRequest);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse getDocumentiEsattorialiNonCartelle(it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse ret = impl.getDocumentiEsattorialiNonCartelle(in);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse getPdfDocumento(it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse ret = impl.getPdfDocumento(in);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse bpsPdfDocumentoResult(it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse ret = impl.bpsPdfDocumentoResult(in);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.GetRelateWSResponse getRelate(it.equitalia.gestorefascicolows.dati.GetRelateWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.GetRelateWSResponse ret = impl.getRelate(in);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse bpsRelateResult(it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse ret = impl.bpsRelateResult(in);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse pdfEstrattoConto(it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse ret = impl.pdfEstrattoConto(in);
        return ret;
    }

    public it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse updateAnagrafica(it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType
    {
        it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse ret = impl.updateAnagrafica(in);
        return ret;
    }

    public it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType callBackPdfDocumento(it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType in) throws java.rmi.RemoteException
    {
        it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType ret = impl.callBackPdfDocumento(in);
        return ret;
    }

    public it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType callBackRelateDocumento(it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType in) throws java.rmi.RemoteException, it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType
    {
        it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType ret = impl.callBackRelateDocumento(in);
        return ret;
    }

}
