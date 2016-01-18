/**
 * CallBackRelateDocumentoFaultType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.relatedocumentostandardcallback.bpel.xsd;

public class CallBackRelateDocumentoFaultType  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private java.lang.String faultcode;

    private java.lang.String faultdescription;

    public CallBackRelateDocumentoFaultType() {
    }

    public CallBackRelateDocumentoFaultType(
           java.lang.String faultcode,
           java.lang.String faultdescription) {
        this.faultcode = faultcode;
        this.faultdescription = faultdescription;
    }


    /**
     * Gets the faultcode value for this CallBackRelateDocumentoFaultType.
     * 
     * @return faultcode
     */
    public java.lang.String getFaultcode() {
        return faultcode;
    }


    /**
     * Sets the faultcode value for this CallBackRelateDocumentoFaultType.
     * 
     * @param faultcode
     */
    public void setFaultcode(java.lang.String faultcode) {
        this.faultcode = faultcode;
    }


    /**
     * Gets the faultdescription value for this CallBackRelateDocumentoFaultType.
     * 
     * @return faultdescription
     */
    public java.lang.String getFaultdescription() {
        return faultdescription;
    }


    /**
     * Sets the faultdescription value for this CallBackRelateDocumentoFaultType.
     * 
     * @param faultdescription
     */
    public void setFaultdescription(java.lang.String faultdescription) {
        this.faultdescription = faultdescription;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CallBackRelateDocumentoFaultType)) return false;
        CallBackRelateDocumentoFaultType other = (CallBackRelateDocumentoFaultType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.faultcode==null && other.getFaultcode()==null) || 
             (this.faultcode!=null &&
              this.faultcode.equals(other.getFaultcode()))) &&
            ((this.faultdescription==null && other.getFaultdescription()==null) || 
             (this.faultdescription!=null &&
              this.faultdescription.equals(other.getFaultdescription())));
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
        if (getFaultcode() != null) {
            _hashCode += getFaultcode().hashCode();
        }
        if (getFaultdescription() != null) {
            _hashCode += getFaultdescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CallBackRelateDocumentoFaultType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "CallBackRelateDocumentoFaultType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faultcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "faultcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faultdescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "faultdescription"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
