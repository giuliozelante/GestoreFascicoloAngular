/**
 * BpsRelateResultWSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class BpsRelateResultWSRequest  implements java.io.Serializable {
    private java.lang.String esitoElaborazione;

    private java.lang.String spazioInternalNumber;

    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private java.lang.String numeroDocumento;

    private java.lang.String cf;

    public BpsRelateResultWSRequest() {
    }

    public BpsRelateResultWSRequest(
           java.lang.String esitoElaborazione,
           java.lang.String spazioInternalNumber,
           java.lang.String fascicoloId,
           java.lang.String callerId,
           java.lang.String numeroDocumento,
           java.lang.String cf) {
           this.esitoElaborazione = esitoElaborazione;
           this.spazioInternalNumber = spazioInternalNumber;
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.numeroDocumento = numeroDocumento;
           this.cf = cf;
    }


    /**
     * Gets the esitoElaborazione value for this BpsRelateResultWSRequest.
     * 
     * @return esitoElaborazione
     */
    public java.lang.String getEsitoElaborazione() {
        return esitoElaborazione;
    }


    /**
     * Sets the esitoElaborazione value for this BpsRelateResultWSRequest.
     * 
     * @param esitoElaborazione
     */
    public void setEsitoElaborazione(java.lang.String esitoElaborazione) {
        this.esitoElaborazione = esitoElaborazione;
    }


    /**
     * Gets the spazioInternalNumber value for this BpsRelateResultWSRequest.
     * 
     * @return spazioInternalNumber
     */
    public java.lang.String getSpazioInternalNumber() {
        return spazioInternalNumber;
    }


    /**
     * Sets the spazioInternalNumber value for this BpsRelateResultWSRequest.
     * 
     * @param spazioInternalNumber
     */
    public void setSpazioInternalNumber(java.lang.String spazioInternalNumber) {
        this.spazioInternalNumber = spazioInternalNumber;
    }


    /**
     * Gets the fascicoloId value for this BpsRelateResultWSRequest.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this BpsRelateResultWSRequest.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this BpsRelateResultWSRequest.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this BpsRelateResultWSRequest.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the numeroDocumento value for this BpsRelateResultWSRequest.
     * 
     * @return numeroDocumento
     */
    public java.lang.String getNumeroDocumento() {
        return numeroDocumento;
    }


    /**
     * Sets the numeroDocumento value for this BpsRelateResultWSRequest.
     * 
     * @param numeroDocumento
     */
    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    /**
     * Gets the cf value for this BpsRelateResultWSRequest.
     * 
     * @return cf
     */
    public java.lang.String getCf() {
        return cf;
    }


    /**
     * Sets the cf value for this BpsRelateResultWSRequest.
     * 
     * @param cf
     */
    public void setCf(java.lang.String cf) {
        this.cf = cf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BpsRelateResultWSRequest)) return false;
        BpsRelateResultWSRequest other = (BpsRelateResultWSRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.esitoElaborazione==null && other.getEsitoElaborazione()==null) || 
             (this.esitoElaborazione!=null &&
              this.esitoElaborazione.equals(other.getEsitoElaborazione()))) &&
            ((this.spazioInternalNumber==null && other.getSpazioInternalNumber()==null) || 
             (this.spazioInternalNumber!=null &&
              this.spazioInternalNumber.equals(other.getSpazioInternalNumber()))) &&
            ((this.fascicoloId==null && other.getFascicoloId()==null) || 
             (this.fascicoloId!=null &&
              this.fascicoloId.equals(other.getFascicoloId()))) &&
            ((this.callerId==null && other.getCallerId()==null) || 
             (this.callerId!=null &&
              this.callerId.equals(other.getCallerId()))) &&
            ((this.numeroDocumento==null && other.getNumeroDocumento()==null) || 
             (this.numeroDocumento!=null &&
              this.numeroDocumento.equals(other.getNumeroDocumento()))) &&
            ((this.cf==null && other.getCf()==null) || 
             (this.cf!=null &&
              this.cf.equals(other.getCf())));
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
        if (getEsitoElaborazione() != null) {
            _hashCode += getEsitoElaborazione().hashCode();
        }
        if (getSpazioInternalNumber() != null) {
            _hashCode += getSpazioInternalNumber().hashCode();
        }
        if (getFascicoloId() != null) {
            _hashCode += getFascicoloId().hashCode();
        }
        if (getCallerId() != null) {
            _hashCode += getCallerId().hashCode();
        }
        if (getNumeroDocumento() != null) {
            _hashCode += getNumeroDocumento().hashCode();
        }
        if (getCf() != null) {
            _hashCode += getCf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BpsRelateResultWSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">bpsRelateResultWSRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esitoElaborazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "esitoElaborazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spazioInternalNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "spazioInternalNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("numeroDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "numeroDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "cf"));
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
