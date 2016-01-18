/**
 * GetRelateWSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class GetRelateWSRequest  implements java.io.Serializable {
    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private java.lang.String numeroDocumento;

    private java.lang.String cf;

    private java.lang.String download;

    public GetRelateWSRequest() {
    }

    public GetRelateWSRequest(
           java.lang.String fascicoloId,
           java.lang.String callerId,
           java.lang.String numeroDocumento,
           java.lang.String cf,
           java.lang.String download) {
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.numeroDocumento = numeroDocumento;
           this.cf = cf;
           this.download = download;
    }


    /**
     * Gets the fascicoloId value for this GetRelateWSRequest.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this GetRelateWSRequest.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this GetRelateWSRequest.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this GetRelateWSRequest.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the numeroDocumento value for this GetRelateWSRequest.
     * 
     * @return numeroDocumento
     */
    public java.lang.String getNumeroDocumento() {
        return numeroDocumento;
    }


    /**
     * Sets the numeroDocumento value for this GetRelateWSRequest.
     * 
     * @param numeroDocumento
     */
    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    /**
     * Gets the cf value for this GetRelateWSRequest.
     * 
     * @return cf
     */
    public java.lang.String getCf() {
        return cf;
    }


    /**
     * Sets the cf value for this GetRelateWSRequest.
     * 
     * @param cf
     */
    public void setCf(java.lang.String cf) {
        this.cf = cf;
    }


    /**
     * Gets the download value for this GetRelateWSRequest.
     * 
     * @return download
     */
    public java.lang.String getDownload() {
        return download;
    }


    /**
     * Sets the download value for this GetRelateWSRequest.
     * 
     * @param download
     */
    public void setDownload(java.lang.String download) {
        this.download = download;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRelateWSRequest)) return false;
        GetRelateWSRequest other = (GetRelateWSRequest) obj;
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
            ((this.numeroDocumento==null && other.getNumeroDocumento()==null) || 
             (this.numeroDocumento!=null &&
              this.numeroDocumento.equals(other.getNumeroDocumento()))) &&
            ((this.cf==null && other.getCf()==null) || 
             (this.cf!=null &&
              this.cf.equals(other.getCf()))) &&
            ((this.download==null && other.getDownload()==null) || 
             (this.download!=null &&
              this.download.equals(other.getDownload())));
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
        if (getNumeroDocumento() != null) {
            _hashCode += getNumeroDocumento().hashCode();
        }
        if (getCf() != null) {
            _hashCode += getCf().hashCode();
        }
        if (getDownload() != null) {
            _hashCode += getDownload().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRelateWSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">getRelateWSRequest"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("download");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "download"));
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
