/**
 * DocumentiAmbitoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.cartelleavvisi.wsdl;

public class DocumentiAmbitoType  implements java.io.Serializable {
    private java.lang.String codiceAmbito;

    private java.lang.Integer totaleDocumenti;

    private java.lang.Double totaleDaPagare;

    private it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoRispostaType documenti;

    public DocumentiAmbitoType() {
    }

    public DocumentiAmbitoType(
           java.lang.String codiceAmbito,
           java.lang.Integer totaleDocumenti,
           java.lang.Double totaleDaPagare,
           it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoRispostaType documenti) {
           this.codiceAmbito = codiceAmbito;
           this.totaleDocumenti = totaleDocumenti;
           this.totaleDaPagare = totaleDaPagare;
           this.documenti = documenti;
    }


    /**
     * Gets the codiceAmbito value for this DocumentiAmbitoType.
     * 
     * @return codiceAmbito
     */
    public java.lang.String getCodiceAmbito() {
        return codiceAmbito;
    }


    /**
     * Sets the codiceAmbito value for this DocumentiAmbitoType.
     * 
     * @param codiceAmbito
     */
    public void setCodiceAmbito(java.lang.String codiceAmbito) {
        this.codiceAmbito = codiceAmbito;
    }


    /**
     * Gets the totaleDocumenti value for this DocumentiAmbitoType.
     * 
     * @return totaleDocumenti
     */
    public java.lang.Integer getTotaleDocumenti() {
        return totaleDocumenti;
    }


    /**
     * Sets the totaleDocumenti value for this DocumentiAmbitoType.
     * 
     * @param totaleDocumenti
     */
    public void setTotaleDocumenti(java.lang.Integer totaleDocumenti) {
        this.totaleDocumenti = totaleDocumenti;
    }


    /**
     * Gets the totaleDaPagare value for this DocumentiAmbitoType.
     * 
     * @return totaleDaPagare
     */
    public java.lang.Double getTotaleDaPagare() {
        return totaleDaPagare;
    }


    /**
     * Sets the totaleDaPagare value for this DocumentiAmbitoType.
     * 
     * @param totaleDaPagare
     */
    public void setTotaleDaPagare(java.lang.Double totaleDaPagare) {
        this.totaleDaPagare = totaleDaPagare;
    }


    /**
     * Gets the documenti value for this DocumentiAmbitoType.
     * 
     * @return documenti
     */
    public it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoRispostaType getDocumenti() {
        return documenti;
    }


    /**
     * Sets the documenti value for this DocumentiAmbitoType.
     * 
     * @param documenti
     */
    public void setDocumenti(it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoRispostaType documenti) {
        this.documenti = documenti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentiAmbitoType)) return false;
        DocumentiAmbitoType other = (DocumentiAmbitoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceAmbito==null && other.getCodiceAmbito()==null) || 
             (this.codiceAmbito!=null &&
              this.codiceAmbito.equals(other.getCodiceAmbito()))) &&
            ((this.totaleDocumenti==null && other.getTotaleDocumenti()==null) || 
             (this.totaleDocumenti!=null &&
              this.totaleDocumenti.equals(other.getTotaleDocumenti()))) &&
            ((this.totaleDaPagare==null && other.getTotaleDaPagare()==null) || 
             (this.totaleDaPagare!=null &&
              this.totaleDaPagare.equals(other.getTotaleDaPagare()))) &&
            ((this.documenti==null && other.getDocumenti()==null) || 
             (this.documenti!=null &&
              this.documenti.equals(other.getDocumenti())));
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
        if (getCodiceAmbito() != null) {
            _hashCode += getCodiceAmbito().hashCode();
        }
        if (getTotaleDocumenti() != null) {
            _hashCode += getTotaleDocumenti().hashCode();
        }
        if (getTotaleDaPagare() != null) {
            _hashCode += getTotaleDaPagare().hashCode();
        }
        if (getDocumenti() != null) {
            _hashCode += getDocumenti().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentiAmbitoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "documentiAmbitoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAmbito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "codiceAmbito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totaleDocumenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "totaleDocumenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totaleDaPagare");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "totaleDaPagare"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.cartelleavvisi.equitalia.it", "documenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "DocumentoRispostaType"));
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
