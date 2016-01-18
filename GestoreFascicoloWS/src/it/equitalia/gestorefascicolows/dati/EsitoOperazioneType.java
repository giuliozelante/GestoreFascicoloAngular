/**
 * EsitoOperazioneType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class EsitoOperazioneType  implements java.io.Serializable {
    private java.lang.String codiceEsito;

    private java.lang.String descrizioneEsito;

    private int totaleDocumenti;

    private int totalePagine;

    private int documentiPaginaCorrente;

    private int numeroPaginaCorrente;

    public EsitoOperazioneType() {
    }

    public EsitoOperazioneType(
           java.lang.String codiceEsito,
           java.lang.String descrizioneEsito,
           int totaleDocumenti,
           int totalePagine,
           int documentiPaginaCorrente,
           int numeroPaginaCorrente) {
           this.codiceEsito = codiceEsito;
           this.descrizioneEsito = descrizioneEsito;
           this.totaleDocumenti = totaleDocumenti;
           this.totalePagine = totalePagine;
           this.documentiPaginaCorrente = documentiPaginaCorrente;
           this.numeroPaginaCorrente = numeroPaginaCorrente;
    }


    /**
     * Gets the codiceEsito value for this EsitoOperazioneType.
     * 
     * @return codiceEsito
     */
    public java.lang.String getCodiceEsito() {
        return codiceEsito;
    }


    /**
     * Sets the codiceEsito value for this EsitoOperazioneType.
     * 
     * @param codiceEsito
     */
    public void setCodiceEsito(java.lang.String codiceEsito) {
        this.codiceEsito = codiceEsito;
    }


    /**
     * Gets the descrizioneEsito value for this EsitoOperazioneType.
     * 
     * @return descrizioneEsito
     */
    public java.lang.String getDescrizioneEsito() {
        return descrizioneEsito;
    }


    /**
     * Sets the descrizioneEsito value for this EsitoOperazioneType.
     * 
     * @param descrizioneEsito
     */
    public void setDescrizioneEsito(java.lang.String descrizioneEsito) {
        this.descrizioneEsito = descrizioneEsito;
    }


    /**
     * Gets the totaleDocumenti value for this EsitoOperazioneType.
     * 
     * @return totaleDocumenti
     */
    public int getTotaleDocumenti() {
        return totaleDocumenti;
    }


    /**
     * Sets the totaleDocumenti value for this EsitoOperazioneType.
     * 
     * @param totaleDocumenti
     */
    public void setTotaleDocumenti(int totaleDocumenti) {
        this.totaleDocumenti = totaleDocumenti;
    }


    /**
     * Gets the totalePagine value for this EsitoOperazioneType.
     * 
     * @return totalePagine
     */
    public int getTotalePagine() {
        return totalePagine;
    }


    /**
     * Sets the totalePagine value for this EsitoOperazioneType.
     * 
     * @param totalePagine
     */
    public void setTotalePagine(int totalePagine) {
        this.totalePagine = totalePagine;
    }


    /**
     * Gets the documentiPaginaCorrente value for this EsitoOperazioneType.
     * 
     * @return documentiPaginaCorrente
     */
    public int getDocumentiPaginaCorrente() {
        return documentiPaginaCorrente;
    }


    /**
     * Sets the documentiPaginaCorrente value for this EsitoOperazioneType.
     * 
     * @param documentiPaginaCorrente
     */
    public void setDocumentiPaginaCorrente(int documentiPaginaCorrente) {
        this.documentiPaginaCorrente = documentiPaginaCorrente;
    }


    /**
     * Gets the numeroPaginaCorrente value for this EsitoOperazioneType.
     * 
     * @return numeroPaginaCorrente
     */
    public int getNumeroPaginaCorrente() {
        return numeroPaginaCorrente;
    }


    /**
     * Sets the numeroPaginaCorrente value for this EsitoOperazioneType.
     * 
     * @param numeroPaginaCorrente
     */
    public void setNumeroPaginaCorrente(int numeroPaginaCorrente) {
        this.numeroPaginaCorrente = numeroPaginaCorrente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EsitoOperazioneType)) return false;
        EsitoOperazioneType other = (EsitoOperazioneType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceEsito==null && other.getCodiceEsito()==null) || 
             (this.codiceEsito!=null &&
              this.codiceEsito.equals(other.getCodiceEsito()))) &&
            ((this.descrizioneEsito==null && other.getDescrizioneEsito()==null) || 
             (this.descrizioneEsito!=null &&
              this.descrizioneEsito.equals(other.getDescrizioneEsito()))) &&
            this.totaleDocumenti == other.getTotaleDocumenti() &&
            this.totalePagine == other.getTotalePagine() &&
            this.documentiPaginaCorrente == other.getDocumentiPaginaCorrente() &&
            this.numeroPaginaCorrente == other.getNumeroPaginaCorrente();
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
        if (getCodiceEsito() != null) {
            _hashCode += getCodiceEsito().hashCode();
        }
        if (getDescrizioneEsito() != null) {
            _hashCode += getDescrizioneEsito().hashCode();
        }
        _hashCode += getTotaleDocumenti();
        _hashCode += getTotalePagine();
        _hashCode += getDocumentiPaginaCorrente();
        _hashCode += getNumeroPaginaCorrente();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EsitoOperazioneType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "EsitoOperazioneType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "CodiceEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DescrizioneEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totaleDocumenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "TotaleDocumenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalePagine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "TotalePagine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentiPaginaCorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DocumentiPaginaCorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPaginaCorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "NumeroPaginaCorrente"));
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
