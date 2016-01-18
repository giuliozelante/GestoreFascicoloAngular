/**
 * FascicoloList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class FascicoloList  implements java.io.Serializable {
    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private java.lang.String dataApertura;

    private java.lang.String dataChiusura;

    private java.lang.Integer statoFascicoloId;

    private java.lang.String statoFascicoloDescr;

    private java.lang.String codiceFiscale;

    public FascicoloList() {
    }

    public FascicoloList(
           java.lang.String fascicoloId,
           java.lang.String callerId,
           java.lang.String dataApertura,
           java.lang.String dataChiusura,
           java.lang.Integer statoFascicoloId,
           java.lang.String statoFascicoloDescr,
           java.lang.String codiceFiscale) {
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.dataApertura = dataApertura;
           this.dataChiusura = dataChiusura;
           this.statoFascicoloId = statoFascicoloId;
           this.statoFascicoloDescr = statoFascicoloDescr;
           this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the fascicoloId value for this FascicoloList.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this FascicoloList.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this FascicoloList.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this FascicoloList.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the dataApertura value for this FascicoloList.
     * 
     * @return dataApertura
     */
    public java.lang.String getDataApertura() {
        return dataApertura;
    }


    /**
     * Sets the dataApertura value for this FascicoloList.
     * 
     * @param dataApertura
     */
    public void setDataApertura(java.lang.String dataApertura) {
        this.dataApertura = dataApertura;
    }


    /**
     * Gets the dataChiusura value for this FascicoloList.
     * 
     * @return dataChiusura
     */
    public java.lang.String getDataChiusura() {
        return dataChiusura;
    }


    /**
     * Sets the dataChiusura value for this FascicoloList.
     * 
     * @param dataChiusura
     */
    public void setDataChiusura(java.lang.String dataChiusura) {
        this.dataChiusura = dataChiusura;
    }


    /**
     * Gets the statoFascicoloId value for this FascicoloList.
     * 
     * @return statoFascicoloId
     */
    public java.lang.Integer getStatoFascicoloId() {
        return statoFascicoloId;
    }


    /**
     * Sets the statoFascicoloId value for this FascicoloList.
     * 
     * @param statoFascicoloId
     */
    public void setStatoFascicoloId(java.lang.Integer statoFascicoloId) {
        this.statoFascicoloId = statoFascicoloId;
    }


    /**
     * Gets the statoFascicoloDescr value for this FascicoloList.
     * 
     * @return statoFascicoloDescr
     */
    public java.lang.String getStatoFascicoloDescr() {
        return statoFascicoloDescr;
    }


    /**
     * Sets the statoFascicoloDescr value for this FascicoloList.
     * 
     * @param statoFascicoloDescr
     */
    public void setStatoFascicoloDescr(java.lang.String statoFascicoloDescr) {
        this.statoFascicoloDescr = statoFascicoloDescr;
    }


    /**
     * Gets the codiceFiscale value for this FascicoloList.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this FascicoloList.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FascicoloList)) return false;
        FascicoloList other = (FascicoloList) obj;
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
            ((this.dataApertura==null && other.getDataApertura()==null) || 
             (this.dataApertura!=null &&
              this.dataApertura.equals(other.getDataApertura()))) &&
            ((this.dataChiusura==null && other.getDataChiusura()==null) || 
             (this.dataChiusura!=null &&
              this.dataChiusura.equals(other.getDataChiusura()))) &&
            ((this.statoFascicoloId==null && other.getStatoFascicoloId()==null) || 
             (this.statoFascicoloId!=null &&
              this.statoFascicoloId.equals(other.getStatoFascicoloId()))) &&
            ((this.statoFascicoloDescr==null && other.getStatoFascicoloDescr()==null) || 
             (this.statoFascicoloDescr!=null &&
              this.statoFascicoloDescr.equals(other.getStatoFascicoloDescr()))) &&
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale())));
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
        if (getDataApertura() != null) {
            _hashCode += getDataApertura().hashCode();
        }
        if (getDataChiusura() != null) {
            _hashCode += getDataChiusura().hashCode();
        }
        if (getStatoFascicoloId() != null) {
            _hashCode += getStatoFascicoloId().hashCode();
        }
        if (getStatoFascicoloDescr() != null) {
            _hashCode += getStatoFascicoloDescr().hashCode();
        }
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FascicoloList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fascicoloId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "callerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataApertura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataApertura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataChiusura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataChiusura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoFascicoloId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "statoFascicoloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoFascicoloDescr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "statoFascicoloDescr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "codiceFiscale"));
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
