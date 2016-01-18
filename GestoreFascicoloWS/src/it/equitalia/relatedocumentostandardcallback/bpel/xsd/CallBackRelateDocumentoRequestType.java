/**
 * CallBackRelateDocumentoRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.relatedocumentostandardcallback.bpel.xsd;

public class CallBackRelateDocumentoRequestType  implements java.io.Serializable {
    private java.lang.String correlationId;

    private it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType codiceEsito;

    private it.equitalia.relatedocumentostandardcallback.bpel.xsd.FileReferenceType fileReference;

    public CallBackRelateDocumentoRequestType() {
    }

    public CallBackRelateDocumentoRequestType(
           java.lang.String correlationId,
           it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType codiceEsito,
           it.equitalia.relatedocumentostandardcallback.bpel.xsd.FileReferenceType fileReference) {
           this.correlationId = correlationId;
           this.codiceEsito = codiceEsito;
           this.fileReference = fileReference;
    }


    /**
     * Gets the correlationId value for this CallBackRelateDocumentoRequestType.
     * 
     * @return correlationId
     */
    public java.lang.String getCorrelationId() {
        return correlationId;
    }


    /**
     * Sets the correlationId value for this CallBackRelateDocumentoRequestType.
     * 
     * @param correlationId
     */
    public void setCorrelationId(java.lang.String correlationId) {
        this.correlationId = correlationId;
    }


    /**
     * Gets the codiceEsito value for this CallBackRelateDocumentoRequestType.
     * 
     * @return codiceEsito
     */
    public it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType getCodiceEsito() {
        return codiceEsito;
    }


    /**
     * Sets the codiceEsito value for this CallBackRelateDocumentoRequestType.
     * 
     * @param codiceEsito
     */
    public void setCodiceEsito(it.equitalia.relatedocumentostandardcallback.bpel.xsd.EsitoType codiceEsito) {
        this.codiceEsito = codiceEsito;
    }


    /**
     * Gets the fileReference value for this CallBackRelateDocumentoRequestType.
     * 
     * @return fileReference
     */
    public it.equitalia.relatedocumentostandardcallback.bpel.xsd.FileReferenceType getFileReference() {
        return fileReference;
    }


    /**
     * Sets the fileReference value for this CallBackRelateDocumentoRequestType.
     * 
     * @param fileReference
     */
    public void setFileReference(it.equitalia.relatedocumentostandardcallback.bpel.xsd.FileReferenceType fileReference) {
        this.fileReference = fileReference;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CallBackRelateDocumentoRequestType)) return false;
        CallBackRelateDocumentoRequestType other = (CallBackRelateDocumentoRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.correlationId==null && other.getCorrelationId()==null) || 
             (this.correlationId!=null &&
              this.correlationId.equals(other.getCorrelationId()))) &&
            ((this.codiceEsito==null && other.getCodiceEsito()==null) || 
             (this.codiceEsito!=null &&
              this.codiceEsito.equals(other.getCodiceEsito()))) &&
            ((this.fileReference==null && other.getFileReference()==null) || 
             (this.fileReference!=null &&
              this.fileReference.equals(other.getFileReference())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCorrelationId() != null) {
            _hashCode += getCorrelationId().hashCode();
        }
        if (getCodiceEsito() != null) {
            _hashCode += getCodiceEsito().hashCode();
        }
        if (getFileReference() != null) {
            _hashCode += getFileReference().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CallBackRelateDocumentoRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correlationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CorrelationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CodiceEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "EsitoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileReference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "FileReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "FileReferenceType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
