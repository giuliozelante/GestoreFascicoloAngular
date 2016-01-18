/**
 * GestoreFascicoloWSSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.source;

public class GestoreFascicoloWSSoapBindingStub extends org.apache.axis.client.Stub implements it.equitalia.gestorefascicolows.source.GestoreFascicoloWSInterface {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[20];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("creazioneFascicolo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "aperturaFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">aperturaFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">aperturaFascicoloWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "aperturaFascicoloWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("chiusuraFascicolo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "chiusuraFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">chiusuraFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">chiusuraFascicoloWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "chiusuraFascicoloWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFascicolo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getFascicoloWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getFascicoloWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCartella");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getCartellaWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getCartellaWSRequest"), it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getCartellaWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getCartellaWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertIndirizzo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertIndirizzoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertIndirizzoWSRequest"), it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertIndirizzoWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertIndirizzoWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteIndirizzo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteIndirizzoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteIndirizzoWSRequest"), it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteIndirizzoWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteIndirizzoWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertTelefono");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertTelefonoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertTelefonoWSRequest"), it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertTelefonoWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertTelefonoWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteTelefono");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteTelefonoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteTelefonoWSRequest"), it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteTelefonoWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteTelefonoWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertEmailWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertEmailWSRequest"), it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertEmailWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "insertEmailWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteEmailWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteEmailWSRequest"), it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteEmailWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "deleteEmailWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchFascicolo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "searchFascicoloWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">searchFascicoloWSRequest"), it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">searchFascicoloWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.FascicoloList[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "searchFascicoloWSResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloList"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentiEsattorialiNonCartelle");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getDocumentiEsattorialiNonCartelleWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getDocumentiEsattorialiNonCartelleWSRequest"), it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getDocumentiEsattorialiNonCartelleWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getDocumentiEsattorialiNonCartelleWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPdfDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getPdfDocumentoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getPdfDocumentoWSRequest"), it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getPdfDocumentoWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getPdfDocumentoWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bpsPdfDocumentoResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsPdfDocumentoResultWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsPdfDocumentoResultWSRequest"), it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsPdfDocumentoResultWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsPdfDocumentoResultWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRelate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getRelateWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getRelateWSRequest"), it.equitalia.gestorefascicolows.dati.GetRelateWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getRelateWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.GetRelateWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "getRelateWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bpsRelateResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsRelateResultWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsRelateResultWSRequest"), it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsRelateResultWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "bpsRelateResultWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("pdfEstrattoConto");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "pdfEstrattoContoWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">pdfEstrattoContoWSRequest"), it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">pdfEstrattoContoWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "pdfEstrattoContoWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateAnagrafica");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "updateAnagraficaWSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">updateAnagraficaWSRequest"), it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">updateAnagraficaWSResponse"));
        oper.setReturnClass(it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "updateAnagraficaWSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "Fault"),
                      "it.equitalia.gestorefascicolows.srv.FaultType",
                      new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CallBackPdfDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoRequestType"), it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoResponseType"));
        oper.setReturnClass(it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("callBackRelateDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoRequestType"), it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoResponseType"));
        oper.setReturnClass(it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoFault"),
                      "it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType",
                      new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoFaultType"), 
                      true
                     ));
        _operations[19] = oper;

    }

    public GestoreFascicoloWSSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public GestoreFascicoloWSSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public GestoreFascicoloWSSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">aperturaFascicoloWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">aperturaFascicoloWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsPdfDocumentoResultWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsPdfDocumentoResultWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsRelateResultWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsRelateResultWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">chiusuraFascicoloWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">chiusuraFascicoloWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteEmailWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteEmailWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteIndirizzoWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteIndirizzoWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteTelefonoWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteTelefonoWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getCartellaWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getCartellaWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getDocumentiEsattorialiNonCartelleWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getDocumentiEsattorialiNonCartelleWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getFascicoloWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getFascicoloWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getPdfDocumentoWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getPdfDocumentoWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getRelateWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetRelateWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getRelateWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.GetRelateWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertEmailWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertEmailWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertIndirizzoWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertIndirizzoWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertTelefonoWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">insertTelefonoWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">pdfEstrattoContoWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">pdfEstrattoContoWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">searchFascicoloWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">searchFascicoloWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.FascicoloList[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloList");
            qName2 = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloList");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">updateAnagraficaWSRequest");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">updateAnagraficaWSResponse");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "anagrafica");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.Anagrafica.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataValue");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.DataValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "eMail");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.EMail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "entityItem");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.EntityItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicolo");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.Fascicolo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloList");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.FascicoloList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "indirizzo");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.Indirizzo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "telefono");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.dati.Telefono.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://srv.gestorefascicolows.equitalia.it", "FaultType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.gestorefascicolows.srv.FaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.w3.org/2005/05/xmlmime", ">contentType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.w3.org/2005/05/xmlmime", "base64Binary");
            cachedSerQNames.add(qName);
            cls = org.w3.www._2005._05.xmlmime.Base64Binary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoRequestType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "CallBackPdfDocumentoResponseType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "EsitoType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.pdfdocumentostandardcallback.bpel.xsd.EsitoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandardcallback.equitalia.it", "MtomAttachmentType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.pdfdocumentostandardcallback.bpel.xsd.MtomAttachmentType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoFaultType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoRequestType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoResponseType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "EsitoType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "FileReferenceType");
            cachedSerQNames.add(qName);
            cls = it.equitalia.relatedocumentostandardcallback.bpel.xsd.FileReferenceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse creazioneFascicolo(it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest aperturaFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:aperturaFascicolo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "creazioneFascicolo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {aperturaFascicoloWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse chiusuraFascicolo(it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest chiusuraFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:chiusuraFascicolo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "chiusuraFascicolo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {chiusuraFascicoloWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse getFascicolo(it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest getFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getFascicolo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getFascicolo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getFascicoloWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.GetFascicoloWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse getCartella(it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest getCartellaWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getCartella");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getCartella"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getCartellaWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse insertIndirizzo(it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest insertIndirizzoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:insertIndirizzo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "insertIndirizzo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {insertIndirizzoWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse deleteIndirizzo(it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest deleteIndirizzoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:deleteIndirizzo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "deleteIndirizzo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {deleteIndirizzoWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse insertTelefono(it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest insertTelefonoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:insertTelefono");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "insertTelefono"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {insertTelefonoWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse deleteTelefono(it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest deleteTelefonoWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:deleteTelefono");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "deleteTelefono"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {deleteTelefonoWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse insertEmail(it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest insertEmailWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:insertEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "insertEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {insertEmailWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse deleteEmail(it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest deleteEmailWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:deleteEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "deleteEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {deleteEmailWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.FascicoloList[] searchFascicolo(it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest searchFascicoloWSRequest) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:searchFascicolo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "searchFascicolo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {searchFascicoloWSRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.FascicoloList[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.FascicoloList[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.FascicoloList[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse getDocumentiEsattorialiNonCartelle(it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getDocumentiEsattorialiNonCartelle");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getDocumentiEsattorialiNonCartelle"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse getPdfDocumento(it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getPdfDocumento");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPdfDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse bpsPdfDocumentoResult(it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:bpsPdfDocumentoResult");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "bpsPdfDocumentoResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.BpsPdfDocumentoResultWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.GetRelateWSResponse getRelate(it.equitalia.gestorefascicolows.dati.GetRelateWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getRelate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getRelate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.GetRelateWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.GetRelateWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.GetRelateWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse bpsRelateResult(it.equitalia.gestorefascicolows.dati.BpsRelateResultWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:bpsRelateResult");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "bpsRelateResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.BpsRelateResultWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse pdfEstrattoConto(it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:pdfEstrattoConto");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "pdfEstrattoConto"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse updateAnagrafica(it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest in) throws java.rmi.RemoteException, it.equitalia.gestorefascicolows.srv.FaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:updateAnagrafica");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "updateAnagrafica"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.gestorefascicolows.srv.FaultType) {
              throw (it.equitalia.gestorefascicolows.srv.FaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType callBackPdfDocumento(it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoRequestType in) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:CallBackPdfDocumento");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CallBackPdfDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.pdfdocumentostandardcallback.bpel.xsd.CallBackPdfDocumentoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType callBackRelateDocumento(it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoRequestType in) throws java.rmi.RemoteException, it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:callBackRelateDocumento");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "callBackRelateDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType) {
              throw (it.equitalia.relatedocumentostandardcallback.bpel.xsd.CallBackRelateDocumentoFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
