/**
 * BPSDocumentiEsattorialiResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.documentiesattoriali.bpel;

public class BPSDocumentiEsattorialiResponse  implements java.io.Serializable {
    private java.lang.String esito;

    private java.lang.String descrizioneEsito;

    private it.equitalia.documentiesattoriali.bpel.DocumentoType[] documenti;

    public BPSDocumentiEsattorialiResponse() {
    }

    public BPSDocumentiEsattorialiResponse(
           java.lang.String esito,
           java.lang.String descrizioneEsito,
           it.equitalia.documentiesattoriali.bpel.DocumentoType[] documenti) {
           this.esito = esito;
           this.descrizioneEsito = descrizioneEsito;
           this.documenti = documenti;
    }


    /**
     * Gets the esito value for this BPSDocumentiEsattorialiResponse.
     * 
     * @return esito
     */
    public java.lang.String getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this BPSDocumentiEsattorialiResponse.
     * 
     * @param esito
     */
    public void setEsito(java.lang.String esito) {
        this.esito = esito;
    }


    /**
     * Gets the descrizioneEsito value for this BPSDocumentiEsattorialiResponse.
     * 
     * @return descrizioneEsito
     */
    public java.lang.String getDescrizioneEsito() {
        return descrizioneEsito;
    }


    /**
     * Sets the descrizioneEsito value for this BPSDocumentiEsattorialiResponse.
     * 
     * @param descrizioneEsito
     */
    public void setDescrizioneEsito(java.lang.String descrizioneEsito) {
        this.descrizioneEsito = descrizioneEsito;
    }


    /**
     * Gets the documenti value for this BPSDocumentiEsattorialiResponse.
     * 
     * @return documenti
     */
    public it.equitalia.documentiesattoriali.bpel.DocumentoType[] getDocumenti() {
        return documenti;
    }


    /**
     * Sets the documenti value for this BPSDocumentiEsattorialiResponse.
     * 
     * @param documenti
     */
    public void setDocumenti(it.equitalia.documentiesattoriali.bpel.DocumentoType[] documenti) {
        this.documenti = documenti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BPSDocumentiEsattorialiResponse)) return false;
        BPSDocumentiEsattorialiResponse other = (BPSDocumentiEsattorialiResponse) obj;
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
            ((this.descrizioneEsito==null && other.getDescrizioneEsito()==null) || 
             (this.descrizioneEsito!=null &&
              this.descrizioneEsito.equals(other.getDescrizioneEsito()))) &&
            ((this.documenti==null && other.getDocumenti()==null) || 
             (this.documenti!=null &&
              java.util.Arrays.equals(this.documenti, other.getDocumenti())));
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
        if (getDescrizioneEsito() != null) {
            _hashCode += getDescrizioneEsito().hashCode();
        }
        if (getDocumenti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumenti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumenti(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BPSDocumentiEsattorialiResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", ">BPSDocumentiEsattorialiResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "esito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "descrizioneEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "documenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "documentoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "documento"));
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
