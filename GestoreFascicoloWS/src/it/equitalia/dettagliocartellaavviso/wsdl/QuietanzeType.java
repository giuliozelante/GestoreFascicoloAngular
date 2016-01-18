/**
 * QuietanzeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class QuietanzeType  implements java.io.Serializable {
    private int numeroQuietanze;

    private it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType[] listaQuietanze;

    public QuietanzeType() {
    }

    public QuietanzeType(
           int numeroQuietanze,
           it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType[] listaQuietanze) {
           this.numeroQuietanze = numeroQuietanze;
           this.listaQuietanze = listaQuietanze;
    }


    /**
     * Gets the numeroQuietanze value for this QuietanzeType.
     * 
     * @return numeroQuietanze
     */
    public int getNumeroQuietanze() {
        return numeroQuietanze;
    }


    /**
     * Sets the numeroQuietanze value for this QuietanzeType.
     * 
     * @param numeroQuietanze
     */
    public void setNumeroQuietanze(int numeroQuietanze) {
        this.numeroQuietanze = numeroQuietanze;
    }


    /**
     * Gets the listaQuietanze value for this QuietanzeType.
     * 
     * @return listaQuietanze
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType[] getListaQuietanze() {
        return listaQuietanze;
    }


    /**
     * Sets the listaQuietanze value for this QuietanzeType.
     * 
     * @param listaQuietanze
     */
    public void setListaQuietanze(it.equitalia.dettagliocartellaavviso.wsdl.QuietanzaType[] listaQuietanze) {
        this.listaQuietanze = listaQuietanze;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QuietanzeType)) return false;
        QuietanzeType other = (QuietanzeType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.numeroQuietanze == other.getNumeroQuietanze() &&
            ((this.listaQuietanze==null && other.getListaQuietanze()==null) || 
             (this.listaQuietanze!=null &&
              java.util.Arrays.equals(this.listaQuietanze, other.getListaQuietanze())));
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
        _hashCode += getNumeroQuietanze();
        if (getListaQuietanze() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaQuietanze());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaQuietanze(), i);
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
        new org.apache.axis.description.TypeDesc(QuietanzeType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "QuietanzeType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroQuietanze");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "numeroQuietanze"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaQuietanze");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ListaQuietanze"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "QuietanzaType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "quietanza"));
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
