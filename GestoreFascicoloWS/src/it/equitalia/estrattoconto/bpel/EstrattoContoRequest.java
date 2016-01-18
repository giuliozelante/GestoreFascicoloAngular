/**
 * EstrattoContoRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.estrattoconto.bpel;

public class EstrattoContoRequest  implements java.io.Serializable {
    private java.lang.String codiceFiscale;

    private java.util.Date dataRichiesta;

    private java.lang.String tipologia;

    public EstrattoContoRequest() {
    }

    public EstrattoContoRequest(
           java.lang.String codiceFiscale,
           java.util.Date dataRichiesta,
           java.lang.String tipologia) {
           this.codiceFiscale = codiceFiscale;
           this.dataRichiesta = dataRichiesta;
           this.tipologia = tipologia;
    }


    /**
     * Gets the codiceFiscale value for this EstrattoContoRequest.
     *
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this EstrattoContoRequest.
     *
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the dataRichiesta value for this EstrattoContoRequest.
     *
     * @return dataRichiesta
     */
    public java.util.Date getDataRichiesta() {
        return dataRichiesta;
    }


    /**
     * Sets the dataRichiesta value for this EstrattoContoRequest.
     *
     * @param dataRichiesta
     */
    public void setDataRichiesta(java.util.Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }


    /**
     * Gets the tipologia value for this EstrattoContoRequest.
     *
     * @return tipologia
     */
    public java.lang.String getTipologia() {
        return tipologia;
    }


    /**
     * Sets the tipologia value for this EstrattoContoRequest.
     *
     * @param tipologia
     */
    public void setTipologia(java.lang.String tipologia) {
        this.tipologia = tipologia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstrattoContoRequest)) return false;
        EstrattoContoRequest other = (EstrattoContoRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) ||
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.dataRichiesta==null && other.getDataRichiesta()==null) ||
             (this.dataRichiesta!=null &&
              this.dataRichiesta.equals(other.getDataRichiesta()))) &&
            ((this.tipologia==null && other.getTipologia()==null) ||
             (this.tipologia!=null &&
              this.tipologia.equals(other.getTipologia())));
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
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getDataRichiesta() != null) {
            _hashCode += getDataRichiesta().hashCode();
        }
        if (getTipologia() != null) {
            _hashCode += getTipologia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstrattoContoRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", ">EstrattoContoRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataRichiesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "dataRichiesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipologia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.estrattoconto.equitalia.it", "tipologia"));
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
