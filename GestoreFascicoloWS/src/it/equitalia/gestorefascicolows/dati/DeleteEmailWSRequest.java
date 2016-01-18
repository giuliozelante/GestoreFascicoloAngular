/**
 * DeleteEmailWSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class DeleteEmailWSRequest  implements java.io.Serializable {
    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private int eMailId;

    public DeleteEmailWSRequest() {
    }

    public DeleteEmailWSRequest(
           java.lang.String fascicoloId,
           java.lang.String callerId,
           int eMailId) {
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.eMailId = eMailId;
    }


    /**
     * Gets the fascicoloId value for this DeleteEmailWSRequest.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this DeleteEmailWSRequest.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this DeleteEmailWSRequest.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this DeleteEmailWSRequest.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the eMailId value for this DeleteEmailWSRequest.
     * 
     * @return eMailId
     */
    public int getEMailId() {
        return eMailId;
    }


    /**
     * Sets the eMailId value for this DeleteEmailWSRequest.
     * 
     * @param eMailId
     */
    public void setEMailId(int eMailId) {
        this.eMailId = eMailId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteEmailWSRequest)) return false;
        DeleteEmailWSRequest other = (DeleteEmailWSRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fascicoloId==null && other.getFascicoloId()==null) || 
             (this.fascicoloId!=null &&
              this.fascicoloId.equals(other.getFascicoloId()))) &&
            ((this.callerId==null && other.getCallerId()==null) || 
             (this.callerId!=null &&
              this.callerId.equals(other.getCallerId()))) &&
            this.eMailId == other.getEMailId();
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
        if (getFascicoloId() != null) {
            _hashCode += getFascicoloId().hashCode();
        }
        if (getCallerId() != null) {
            _hashCode += getCallerId().hashCode();
        }
        _hashCode += getEMailId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteEmailWSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">deleteEmailWSRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fascicoloId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "callerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EMailId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "eMailId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
