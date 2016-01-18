/**
 * EstrattoContoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.estrattoconto.bpel;

public class EstrattoContoResponse  implements java.io.Serializable {
    private java.lang.String esito;

    private java.lang.String descrizioneEsito;

    private byte[] estrattoContoPdf;

    public EstrattoContoResponse() {
    }

    public EstrattoContoResponse(
           java.lang.String esito,
           java.lang.String descrizioneEsito,
           byte[] estrattoContoPdf) {
           this.esito = esito;
           this.descrizioneEsito = descrizioneEsito;
           this.estrattoContoPdf = estrattoContoPdf;
    }


    /**
     * Gets the esito value for this EstrattoContoResponse.
     * 
     * @return esito
     */
    public java.lang.String getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this EstrattoContoResponse.
     * 
     * @param esito
     */
    public void setEsito(java.lang.String esito) {
        this.esito = esito;
    }


    /**
     * Gets the descrizioneEsito value for this EstrattoContoResponse.
     * 
     * @return descrizioneEsito
     */
    public java.lang.String getDescrizioneEsito() {
        return descrizioneEsito;
    }


    /**
     * Sets the descrizioneEsito value for this EstrattoContoResponse.
     * 
     * @param descrizioneEsito
     */
    public void setDescrizioneEsito(java.lang.String descrizioneEsito) {
        this.descrizioneEsito = descrizioneEsito;
    }


    /**
     * Gets the estrattoContoPdf value for this EstrattoContoResponse.
     * 
     * @return estrattoContoPdf
     */
    public byte[] getEstrattoContoPdf() {
        return estrattoContoPdf;
    }


    /**
     * Sets the estrattoContoPdf value for this EstrattoContoResponse.
     * 
     * @param estrattoContoPdf
     */
    public void setEstrattoContoPdf(byte[] estrattoContoPdf) {
        this.estrattoContoPdf = estrattoContoPdf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstrattoContoResponse)) return false;
        EstrattoContoResponse other = (EstrattoContoResponse) obj;
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
            ((this.estrattoContoPdf==null && other.getEstrattoContoPdf()==null) || 
             (this.estrattoContoPdf!=null &&
              java.util.Arrays.equals(this.estrattoContoPdf, other.getEstrattoContoPdf())));
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
        if (getEstrattoContoPdf() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstrattoContoPdf());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstrattoContoPdf(), i);
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
        new org.apache.axis.description.TypeDesc(EstrattoContoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", ">EstrattoContoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "esito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "descrizioneEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estrattoContoPdf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "estrattoContoPdf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
