/**
 * TipoProceduraType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class TipoProceduraType  implements java.io.Serializable {
    private java.lang.String codiceTipoProcedura;

    private java.lang.String descrizioneTipoProcedura;

    public TipoProceduraType() {
    }

    public TipoProceduraType(
           java.lang.String codiceTipoProcedura,
           java.lang.String descrizioneTipoProcedura) {
           this.codiceTipoProcedura = codiceTipoProcedura;
           this.descrizioneTipoProcedura = descrizioneTipoProcedura;
    }


    /**
     * Gets the codiceTipoProcedura value for this TipoProceduraType.
     * 
     * @return codiceTipoProcedura
     */
    public java.lang.String getCodiceTipoProcedura() {
        return codiceTipoProcedura;
    }


    /**
     * Sets the codiceTipoProcedura value for this TipoProceduraType.
     * 
     * @param codiceTipoProcedura
     */
    public void setCodiceTipoProcedura(java.lang.String codiceTipoProcedura) {
        this.codiceTipoProcedura = codiceTipoProcedura;
    }


    /**
     * Gets the descrizioneTipoProcedura value for this TipoProceduraType.
     * 
     * @return descrizioneTipoProcedura
     */
    public java.lang.String getDescrizioneTipoProcedura() {
        return descrizioneTipoProcedura;
    }


    /**
     * Sets the descrizioneTipoProcedura value for this TipoProceduraType.
     * 
     * @param descrizioneTipoProcedura
     */
    public void setDescrizioneTipoProcedura(java.lang.String descrizioneTipoProcedura) {
        this.descrizioneTipoProcedura = descrizioneTipoProcedura;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TipoProceduraType)) return false;
        TipoProceduraType other = (TipoProceduraType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceTipoProcedura==null && other.getCodiceTipoProcedura()==null) || 
             (this.codiceTipoProcedura!=null &&
              this.codiceTipoProcedura.equals(other.getCodiceTipoProcedura()))) &&
            ((this.descrizioneTipoProcedura==null && other.getDescrizioneTipoProcedura()==null) || 
             (this.descrizioneTipoProcedura!=null &&
              this.descrizioneTipoProcedura.equals(other.getDescrizioneTipoProcedura())));
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
        if (getCodiceTipoProcedura() != null) {
            _hashCode += getCodiceTipoProcedura().hashCode();
        }
        if (getDescrizioneTipoProcedura() != null) {
            _hashCode += getDescrizioneTipoProcedura().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TipoProceduraType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "TipoProceduraType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceTipoProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "CodiceTipoProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneTipoProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DescrizioneTipoProcedura"));
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
