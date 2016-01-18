/**
 * ProcedureType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class ProcedureType  implements java.io.Serializable {
    private java.lang.Integer numeroProcedure;

    private it.equitalia.dettagliocartellaavviso.wsdl.ProceduraRispostaType listaProcedure;

    public ProcedureType() {
    }

    public ProcedureType(
           java.lang.Integer numeroProcedure,
           it.equitalia.dettagliocartellaavviso.wsdl.ProceduraRispostaType listaProcedure) {
           this.numeroProcedure = numeroProcedure;
           this.listaProcedure = listaProcedure;
    }


    /**
     * Gets the numeroProcedure value for this ProcedureType.
     * 
     * @return numeroProcedure
     */
    public java.lang.Integer getNumeroProcedure() {
        return numeroProcedure;
    }


    /**
     * Sets the numeroProcedure value for this ProcedureType.
     * 
     * @param numeroProcedure
     */
    public void setNumeroProcedure(java.lang.Integer numeroProcedure) {
        this.numeroProcedure = numeroProcedure;
    }


    /**
     * Gets the listaProcedure value for this ProcedureType.
     * 
     * @return listaProcedure
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.ProceduraRispostaType getListaProcedure() {
        return listaProcedure;
    }


    /**
     * Sets the listaProcedure value for this ProcedureType.
     * 
     * @param listaProcedure
     */
    public void setListaProcedure(it.equitalia.dettagliocartellaavviso.wsdl.ProceduraRispostaType listaProcedure) {
        this.listaProcedure = listaProcedure;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProcedureType)) return false;
        ProcedureType other = (ProcedureType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroProcedure==null && other.getNumeroProcedure()==null) || 
             (this.numeroProcedure!=null &&
              this.numeroProcedure.equals(other.getNumeroProcedure()))) &&
            ((this.listaProcedure==null && other.getListaProcedure()==null) || 
             (this.listaProcedure!=null &&
              this.listaProcedure.equals(other.getListaProcedure())));
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
        if (getNumeroProcedure() != null) {
            _hashCode += getNumeroProcedure().hashCode();
        }
        if (getListaProcedure() != null) {
            _hashCode += getListaProcedure().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProcedureType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ProcedureType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroProcedure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "NumeroProcedure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaProcedure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ListaProcedure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ProceduraRispostaType"));
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
