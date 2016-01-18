/**
 * GetRelateDocumentoResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.relatedocumentostandard.bpel.xsd;

public class GetRelateDocumentoResponseType  implements java.io.Serializable {
    private it.equitalia.relatedocumentostandard.bpel.xsd.EsitoType esito;

    private java.lang.String correlationId;

    public GetRelateDocumentoResponseType() {
    }

    public GetRelateDocumentoResponseType(
           it.equitalia.relatedocumentostandard.bpel.xsd.EsitoType esito,
           java.lang.String correlationId) {
           this.esito = esito;
           this.correlationId = correlationId;
    }


    /**
     * Gets the esito value for this GetRelateDocumentoResponseType.
     * 
     * @return esito
     */
    public it.equitalia.relatedocumentostandard.bpel.xsd.EsitoType getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this GetRelateDocumentoResponseType.
     * 
     * @param esito
     */
    public void setEsito(it.equitalia.relatedocumentostandard.bpel.xsd.EsitoType esito) {
        this.esito = esito;
    }


    /**
     * Gets the correlationId value for this GetRelateDocumentoResponseType.
     * 
     * @return correlationId
     */
    public java.lang.String getCorrelationId() {
        return correlationId;
    }


    /**
     * Sets the correlationId value for this GetRelateDocumentoResponseType.
     * 
     * @param correlationId
     */
    public void setCorrelationId(java.lang.String correlationId) {
        this.correlationId = correlationId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRelateDocumentoResponseType)) return false;
        GetRelateDocumentoResponseType other = (GetRelateDocumentoResponseType) obj;
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
              this.correlationId.equals(other.getCorrelationId())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRelateDocumentoResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandard.equitalia.it", "GetRelateDocumentoResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandard.equitalia.it", "Esito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandard.equitalia.it", "EsitoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correlationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandard.equitalia.it", "CorrelationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
