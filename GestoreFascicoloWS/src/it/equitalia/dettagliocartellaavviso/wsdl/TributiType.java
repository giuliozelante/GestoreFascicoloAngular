/**
 * TributiType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class TributiType  implements java.io.Serializable {
    private java.lang.Integer numeroTributi;

    private it.equitalia.dettagliocartellaavviso.wsdl.TributoRispostaType listaTributi;

    public TributiType() {
    }

    public TributiType(
           java.lang.Integer numeroTributi,
           it.equitalia.dettagliocartellaavviso.wsdl.TributoRispostaType listaTributi) {
           this.numeroTributi = numeroTributi;
           this.listaTributi = listaTributi;
    }


    /**
     * Gets the numeroTributi value for this TributiType.
     * 
     * @return numeroTributi
     */
    public java.lang.Integer getNumeroTributi() {
        return numeroTributi;
    }


    /**
     * Sets the numeroTributi value for this TributiType.
     * 
     * @param numeroTributi
     */
    public void setNumeroTributi(java.lang.Integer numeroTributi) {
        this.numeroTributi = numeroTributi;
    }


    /**
     * Gets the listaTributi value for this TributiType.
     * 
     * @return listaTributi
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.TributoRispostaType getListaTributi() {
        return listaTributi;
    }


    /**
     * Sets the listaTributi value for this TributiType.
     * 
     * @param listaTributi
     */
    public void setListaTributi(it.equitalia.dettagliocartellaavviso.wsdl.TributoRispostaType listaTributi) {
        this.listaTributi = listaTributi;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TributiType)) return false;
        TributiType other = (TributiType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroTributi==null && other.getNumeroTributi()==null) || 
             (this.numeroTributi!=null &&
              this.numeroTributi.equals(other.getNumeroTributi()))) &&
            ((this.listaTributi==null && other.getListaTributi()==null) || 
             (this.listaTributi!=null &&
              this.listaTributi.equals(other.getListaTributi())));
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
        if (getNumeroTributi() != null) {
            _hashCode += getNumeroTributi().hashCode();
        }
        if (getListaTributi() != null) {
            _hashCode += getListaTributi().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TributiType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "TributiType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "NumeroTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ListaTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "TributoRispostaType"));
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
