/**
 * InserimentoDocumentoWSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class InserimentoDocumentoWSRequest  implements java.io.Serializable {
    private DocumentoRispostaType documentoRisposta;

    public InserimentoDocumentoWSRequest() {
    }

    public InserimentoDocumentoWSRequest(
           DocumentoRispostaType documentoRisposta) {
           this.documentoRisposta = documentoRisposta;
    }


    /**
     * Gets the documentoRisposta value for this InserimentoDocumentoWSRequest.
     * 
     * @return documentoRisposta
     */
    public DocumentoRispostaType getDocumentoRisposta() {
        return documentoRisposta;
    }


    /**
     * Sets the documentoRisposta value for this InserimentoDocumentoWSRequest.
     * 
     * @param documentoRisposta
     */
    public void setDocumentoRisposta(DocumentoRispostaType documentoRisposta) {
        this.documentoRisposta = documentoRisposta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InserimentoDocumentoWSRequest)) return false;
        InserimentoDocumentoWSRequest other = (InserimentoDocumentoWSRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documentoRisposta==null && other.getDocumentoRisposta()==null) || 
             (this.documentoRisposta!=null &&
              this.documentoRisposta.equals(other.getDocumentoRisposta())));
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
        if (getDocumentoRisposta() != null) {
            _hashCode += getDocumentoRisposta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InserimentoDocumentoWSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", ">inserimentoDocumentoWSRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoRisposta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DocumentoRisposta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DocumentoRispostaType"));
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
