/**
 * GetPdfDocumentoRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.pdfdocumentostandard.bpel.xsd;

public class GetPdfDocumentoRequestType  implements java.io.Serializable {
    private java.lang.String codiceFiscale;

    private java.lang.String numeroDocumento;

    private boolean flagSincrono;

    private java.lang.String modalitaEstrazione;

    public GetPdfDocumentoRequestType() {
    }

    public GetPdfDocumentoRequestType(
           java.lang.String codiceFiscale,
           java.lang.String numeroDocumento,
           boolean flagSincrono,
           java.lang.String modalitaEstrazione) {
           this.codiceFiscale = codiceFiscale;
           this.numeroDocumento = numeroDocumento;
           this.flagSincrono = flagSincrono;
           this.modalitaEstrazione = modalitaEstrazione;
    }


    /**
     * Gets the codiceFiscale value for this GetPdfDocumentoRequestType.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this GetPdfDocumentoRequestType.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the numeroDocumento value for this GetPdfDocumentoRequestType.
     * 
     * @return numeroDocumento
     */
    public java.lang.String getNumeroDocumento() {
        return numeroDocumento;
    }


    /**
     * Sets the numeroDocumento value for this GetPdfDocumentoRequestType.
     * 
     * @param numeroDocumento
     */
    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    /**
     * Gets the flagSincrono value for this GetPdfDocumentoRequestType.
     * 
     * @return flagSincrono
     */
    public boolean isFlagSincrono() {
        return flagSincrono;
    }


    /**
     * Sets the flagSincrono value for this GetPdfDocumentoRequestType.
     * 
     * @param flagSincrono
     */
    public void setFlagSincrono(boolean flagSincrono) {
        this.flagSincrono = flagSincrono;
    }


    /**
     * Gets the modalitaEstrazione value for this GetPdfDocumentoRequestType.
     * 
     * @return modalitaEstrazione
     */
    public java.lang.String getModalitaEstrazione() {
        return modalitaEstrazione;
    }


    /**
     * Sets the modalitaEstrazione value for this GetPdfDocumentoRequestType.
     * 
     * @param modalitaEstrazione
     */
    public void setModalitaEstrazione(java.lang.String modalitaEstrazione) {
        this.modalitaEstrazione = modalitaEstrazione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPdfDocumentoRequestType)) return false;
        GetPdfDocumentoRequestType other = (GetPdfDocumentoRequestType) obj;
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
            ((this.numeroDocumento==null && other.getNumeroDocumento()==null) || 
             (this.numeroDocumento!=null &&
              this.numeroDocumento.equals(other.getNumeroDocumento()))) &&
            this.flagSincrono == other.isFlagSincrono() &&
            ((this.modalitaEstrazione==null && other.getModalitaEstrazione()==null) || 
             (this.modalitaEstrazione!=null &&
              this.modalitaEstrazione.equals(other.getModalitaEstrazione())));
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
        if (getNumeroDocumento() != null) {
            _hashCode += getNumeroDocumento().hashCode();
        }
        _hashCode += (isFlagSincrono() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getModalitaEstrazione() != null) {
            _hashCode += getModalitaEstrazione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPdfDocumentoRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "GetPdfDocumentoRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "CodiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "NumeroDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagSincrono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "FlagSincrono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modalitaEstrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "ModalitaEstrazione"));
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
