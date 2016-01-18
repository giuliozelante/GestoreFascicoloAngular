/**
 * CallBackPdfDocumentoRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class CallBackPdfDocumentoRequestType  implements java.io.Serializable {
    private java.lang.String correlationId;

    private it.equitalia.gestorefascicolows.dati.EsitoType esito;

    private it.equitalia.gestorefascicolows.dati.MtomAttachmentType mtomAttachment;

    public CallBackPdfDocumentoRequestType() {
    }

    public CallBackPdfDocumentoRequestType(
           java.lang.String correlationId,
           it.equitalia.gestorefascicolows.dati.EsitoType esito,
           it.equitalia.gestorefascicolows.dati.MtomAttachmentType mtomAttachment) {
           this.correlationId = correlationId;
           this.esito = esito;
           this.mtomAttachment = mtomAttachment;
    }


    /**
     * Gets the correlationId value for this CallBackPdfDocumentoRequestType.
     * 
     * @return correlationId
     */
    public java.lang.String getCorrelationId() {
        return correlationId;
    }


    /**
     * Sets the correlationId value for this CallBackPdfDocumentoRequestType.
     * 
     * @param correlationId
     */
    public void setCorrelationId(java.lang.String correlationId) {
        this.correlationId = correlationId;
    }


    /**
     * Gets the esito value for this CallBackPdfDocumentoRequestType.
     * 
     * @return esito
     */
    public it.equitalia.gestorefascicolows.dati.EsitoType getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this CallBackPdfDocumentoRequestType.
     * 
     * @param esito
     */
    public void setEsito(it.equitalia.gestorefascicolows.dati.EsitoType esito) {
        this.esito = esito;
    }


    /**
     * Gets the mtomAttachment value for this CallBackPdfDocumentoRequestType.
     * 
     * @return mtomAttachment
     */
    public it.equitalia.gestorefascicolows.dati.MtomAttachmentType getMtomAttachment() {
        return mtomAttachment;
    }


    /**
     * Sets the mtomAttachment value for this CallBackPdfDocumentoRequestType.
     * 
     * @param mtomAttachment
     */
    public void setMtomAttachment(it.equitalia.gestorefascicolows.dati.MtomAttachmentType mtomAttachment) {
        this.mtomAttachment = mtomAttachment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CallBackPdfDocumentoRequestType)) return false;
        CallBackPdfDocumentoRequestType other = (CallBackPdfDocumentoRequestType) obj;
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
            ((this.esito==null && other.getEsito()==null) || 
             (this.esito!=null &&
              this.esito.equals(other.getEsito()))) &&
            ((this.mtomAttachment==null && other.getMtomAttachment()==null) || 
             (this.mtomAttachment!=null &&
              this.mtomAttachment.equals(other.getMtomAttachment())));
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
        if (getEsito() != null) {
            _hashCode += getEsito().hashCode();
        }
        if (getMtomAttachment() != null) {
            _hashCode += getMtomAttachment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CallBackPdfDocumentoRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "CallBackPdfDocumentoRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correlationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "CorrelationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "Esito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "EsitoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mtomAttachment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "MtomAttachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "MtomAttachmentType"));
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
