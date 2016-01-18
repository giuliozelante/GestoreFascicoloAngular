/**
 * GetPdfDocumentoResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.pdfdocumentostandard.bpel.xsd;

public class GetPdfDocumentoResponseType  implements java.io.Serializable {
    private it.equitalia.pdfdocumentostandard.bpel.xsd.EsitoType esito;

    private java.lang.String correlationId;

    private it.equitalia.pdfdocumentostandard.bpel.xsd.MtomAttachmentType mtomAttachment;

    public GetPdfDocumentoResponseType() {
    }

    public GetPdfDocumentoResponseType(
           it.equitalia.pdfdocumentostandard.bpel.xsd.EsitoType esito,
           java.lang.String correlationId,
           it.equitalia.pdfdocumentostandard.bpel.xsd.MtomAttachmentType mtomAttachment) {
           this.esito = esito;
           this.correlationId = correlationId;
           this.mtomAttachment = mtomAttachment;
    }


    /**
     * Gets the esito value for this GetPdfDocumentoResponseType.
     * 
     * @return esito
     */
    public it.equitalia.pdfdocumentostandard.bpel.xsd.EsitoType getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this GetPdfDocumentoResponseType.
     * 
     * @param esito
     */
    public void setEsito(it.equitalia.pdfdocumentostandard.bpel.xsd.EsitoType esito) {
        this.esito = esito;
    }


    /**
     * Gets the correlationId value for this GetPdfDocumentoResponseType.
     * 
     * @return correlationId
     */
    public java.lang.String getCorrelationId() {
        return correlationId;
    }


    /**
     * Sets the correlationId value for this GetPdfDocumentoResponseType.
     * 
     * @param correlationId
     */
    public void setCorrelationId(java.lang.String correlationId) {
        this.correlationId = correlationId;
    }


    /**
     * Gets the mtomAttachment value for this GetPdfDocumentoResponseType.
     * 
     * @return mtomAttachment
     */
    public it.equitalia.pdfdocumentostandard.bpel.xsd.MtomAttachmentType getMtomAttachment() {
        return mtomAttachment;
    }


    /**
     * Sets the mtomAttachment value for this GetPdfDocumentoResponseType.
     * 
     * @param mtomAttachment
     */
    public void setMtomAttachment(it.equitalia.pdfdocumentostandard.bpel.xsd.MtomAttachmentType mtomAttachment) {
        this.mtomAttachment = mtomAttachment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPdfDocumentoResponseType)) return false;
        GetPdfDocumentoResponseType other = (GetPdfDocumentoResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.esito==null && other.getEsito()==null) || 
             (this.esito!=null &&
              this.esito.equals(other.getEsito()))) &&
            ((this.correlationId==null && other.getCorrelationId()==null) || 
             (this.correlationId!=null &&
              this.correlationId.equals(other.getCorrelationId()))) &&
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
        if (getEsito() != null) {
            _hashCode += getEsito().hashCode();
        }
        if (getCorrelationId() != null) {
            _hashCode += getCorrelationId().hashCode();
        }
        if (getMtomAttachment() != null) {
            _hashCode += getMtomAttachment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPdfDocumentoResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "GetPdfDocumentoResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "Esito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "EsitoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correlationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "CorrelationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mtomAttachment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "MtomAttachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "MtomAttachmentType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
