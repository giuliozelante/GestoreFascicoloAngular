/**
 * CartellaAvvisiRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.cartelleavvisi.wsdl;

public class CartellaAvvisiRequestType  implements java.io.Serializable {
    private java.lang.String codiceFiscale;

    private java.util.Date dataRichiesta;

    private java.lang.String tipologiaRichiesta;

    private java.lang.String tipoDocumento;

    public CartellaAvvisiRequestType() {
    }

    public CartellaAvvisiRequestType(
           java.lang.String codiceFiscale,
           java.util.Date dataRichiesta,
           java.lang.String tipologiaRichiesta,
           java.lang.String tipoDocumento) {
           this.codiceFiscale = codiceFiscale;
           this.dataRichiesta = dataRichiesta;
           this.tipologiaRichiesta = tipologiaRichiesta;
           this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the codiceFiscale value for this CartellaAvvisiRequestType.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this CartellaAvvisiRequestType.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the dataRichiesta value for this CartellaAvvisiRequestType.
     * 
     * @return dataRichiesta
     */
    public java.util.Date getDataRichiesta() {
        return dataRichiesta;
    }


    /**
     * Sets the dataRichiesta value for this CartellaAvvisiRequestType.
     * 
     * @param dataRichiesta
     */
    public void setDataRichiesta(java.util.Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }


    /**
     * Gets the tipologiaRichiesta value for this CartellaAvvisiRequestType.
     * 
     * @return tipologiaRichiesta
     */
    public java.lang.String getTipologiaRichiesta() {
        return tipologiaRichiesta;
    }


    /**
     * Sets the tipologiaRichiesta value for this CartellaAvvisiRequestType.
     * 
     * @param tipologiaRichiesta
     */
    public void setTipologiaRichiesta(java.lang.String tipologiaRichiesta) {
        this.tipologiaRichiesta = tipologiaRichiesta;
    }


    /**
     * Gets the tipoDocumento value for this CartellaAvvisiRequestType.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this CartellaAvvisiRequestType.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartellaAvvisiRequestType)) return false;
        CartellaAvvisiRequestType other = (CartellaAvvisiRequestType) obj;
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
            ((this.tipologiaRichiesta==null && other.getTipologiaRichiesta()==null) || 
             (this.tipologiaRichiesta!=null &&
              this.tipologiaRichiesta.equals(other.getTipologiaRichiesta()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento())));
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
        if (getTipologiaRichiesta() != null) {
            _hashCode += getTipologiaRichiesta().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartellaAvvisiRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "cartellaAvvisiRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataRichiesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "dataRichiesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipologiaRichiesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "tipologiaRichiesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "tipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
