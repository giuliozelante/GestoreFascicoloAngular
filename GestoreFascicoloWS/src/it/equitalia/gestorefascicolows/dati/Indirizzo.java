/**
 * Indirizzo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class Indirizzo  implements java.io.Serializable {
    private java.lang.Integer indirizzoId;

    private java.lang.String indirizzo;

    private java.lang.String indirizzoPrincipale;

    public Indirizzo() {
    }

    public Indirizzo(
           java.lang.Integer indirizzoId,
           java.lang.String indirizzo,
           java.lang.String indirizzoPrincipale) {
           this.indirizzoId = indirizzoId;
           this.indirizzo = indirizzo;
           this.indirizzoPrincipale = indirizzoPrincipale;
    }


    /**
     * Gets the indirizzoId value for this Indirizzo.
     * 
     * @return indirizzoId
     */
    public java.lang.Integer getIndirizzoId() {
        return indirizzoId;
    }


    /**
     * Sets the indirizzoId value for this Indirizzo.
     * 
     * @param indirizzoId
     */
    public void setIndirizzoId(java.lang.Integer indirizzoId) {
        this.indirizzoId = indirizzoId;
    }


    /**
     * Gets the indirizzo value for this Indirizzo.
     * 
     * @return indirizzo
     */
    public java.lang.String getIndirizzo() {
        return indirizzo;
    }


    /**
     * Sets the indirizzo value for this Indirizzo.
     * 
     * @param indirizzo
     */
    public void setIndirizzo(java.lang.String indirizzo) {
        this.indirizzo = indirizzo;
    }


    /**
     * Gets the indirizzoPrincipale value for this Indirizzo.
     * 
     * @return indirizzoPrincipale
     */
    public java.lang.String getIndirizzoPrincipale() {
        return indirizzoPrincipale;
    }


    /**
     * Sets the indirizzoPrincipale value for this Indirizzo.
     * 
     * @param indirizzoPrincipale
     */
    public void setIndirizzoPrincipale(java.lang.String indirizzoPrincipale) {
        this.indirizzoPrincipale = indirizzoPrincipale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Indirizzo)) return false;
        Indirizzo other = (Indirizzo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indirizzoId==null && other.getIndirizzoId()==null) || 
             (this.indirizzoId!=null &&
              this.indirizzoId.equals(other.getIndirizzoId()))) &&
            ((this.indirizzo==null && other.getIndirizzo()==null) || 
             (this.indirizzo!=null &&
              this.indirizzo.equals(other.getIndirizzo()))) &&
            ((this.indirizzoPrincipale==null && other.getIndirizzoPrincipale()==null) || 
             (this.indirizzoPrincipale!=null &&
              this.indirizzoPrincipale.equals(other.getIndirizzoPrincipale())));
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
        if (getIndirizzoId() != null) {
            _hashCode += getIndirizzoId().hashCode();
        }
        if (getIndirizzo() != null) {
            _hashCode += getIndirizzo().hashCode();
        }
        if (getIndirizzoPrincipale() != null) {
            _hashCode += getIndirizzoPrincipale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Indirizzo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "indirizzo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "indirizzoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "indirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoPrincipale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "indirizzoPrincipale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
