/**
 * DocumentoRispostaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitaliaspa.servizibe.xsd.estrattoconto.dati;

public class DocumentoRispostaType  implements java.io.Serializable {
    private it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EsitoOperazioneType esitoOperazione;

    private java.lang.Double totaleDaPagare;

    private java.lang.Double totaleDaPagarePagina;

    private it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType[] documento;

    public DocumentoRispostaType() {
    }

    public DocumentoRispostaType(
           it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EsitoOperazioneType esitoOperazione,
           java.lang.Double totaleDaPagare,
           java.lang.Double totaleDaPagarePagina,
           it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType[] documento) {
           this.esitoOperazione = esitoOperazione;
           this.totaleDaPagare = totaleDaPagare;
           this.totaleDaPagarePagina = totaleDaPagarePagina;
           this.documento = documento;
    }


    /**
     * Gets the esitoOperazione value for this DocumentoRispostaType.
     * 
     * @return esitoOperazione
     */
    public it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EsitoOperazioneType getEsitoOperazione() {
        return esitoOperazione;
    }


    /**
     * Sets the esitoOperazione value for this DocumentoRispostaType.
     * 
     * @param esitoOperazione
     */
    public void setEsitoOperazione(it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EsitoOperazioneType esitoOperazione) {
        this.esitoOperazione = esitoOperazione;
    }


    /**
     * Gets the totaleDaPagare value for this DocumentoRispostaType.
     * 
     * @return totaleDaPagare
     */
    public java.lang.Double getTotaleDaPagare() {
        return totaleDaPagare;
    }


    /**
     * Sets the totaleDaPagare value for this DocumentoRispostaType.
     * 
     * @param totaleDaPagare
     */
    public void setTotaleDaPagare(java.lang.Double totaleDaPagare) {
        this.totaleDaPagare = totaleDaPagare;
    }


    /**
     * Gets the totaleDaPagarePagina value for this DocumentoRispostaType.
     * 
     * @return totaleDaPagarePagina
     */
    public java.lang.Double getTotaleDaPagarePagina() {
        return totaleDaPagarePagina;
    }


    /**
     * Sets the totaleDaPagarePagina value for this DocumentoRispostaType.
     * 
     * @param totaleDaPagarePagina
     */
    public void setTotaleDaPagarePagina(java.lang.Double totaleDaPagarePagina) {
        this.totaleDaPagarePagina = totaleDaPagarePagina;
    }


    /**
     * Gets the documento value for this DocumentoRispostaType.
     * 
     * @return documento
     */
    public it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType[] getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this DocumentoRispostaType.
     * 
     * @param documento
     */
    public void setDocumento(it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType[] documento) {
        this.documento = documento;
    }

    public it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType getDocumento(int i) {
        return this.documento[i];
    }

    public void setDocumento(int i, it.equitaliaspa.servizibe.xsd.estrattoconto.dati.DocumentoType _value) {
        this.documento[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoRispostaType)) return false;
        DocumentoRispostaType other = (DocumentoRispostaType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.esitoOperazione==null && other.getEsitoOperazione()==null) || 
             (this.esitoOperazione!=null &&
              this.esitoOperazione.equals(other.getEsitoOperazione()))) &&
            ((this.totaleDaPagare==null && other.getTotaleDaPagare()==null) || 
             (this.totaleDaPagare!=null &&
              this.totaleDaPagare.equals(other.getTotaleDaPagare()))) &&
            ((this.totaleDaPagarePagina==null && other.getTotaleDaPagarePagina()==null) || 
             (this.totaleDaPagarePagina!=null &&
              this.totaleDaPagarePagina.equals(other.getTotaleDaPagarePagina()))) &&
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              java.util.Arrays.equals(this.documento, other.getDocumento())));
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
        if (getEsitoOperazione() != null) {
            _hashCode += getEsitoOperazione().hashCode();
        }
        if (getTotaleDaPagare() != null) {
            _hashCode += getTotaleDaPagare().hashCode();
        }
        if (getTotaleDaPagarePagina() != null) {
            _hashCode += getTotaleDaPagarePagina().hashCode();
        }
        if (getDocumento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumento(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoRispostaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "DocumentoRispostaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esitoOperazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "EsitoOperazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "EsitoOperazioneType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totaleDaPagare");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "TotaleDaPagare"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totaleDaPagarePagina");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "TotaleDaPagarePagina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "Documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "DocumentoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
