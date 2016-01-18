/**
 * PianoRateazioneType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class PianoRateazioneType  implements java.io.Serializable {
    private java.lang.String codiceFiscale;

    private java.lang.String dataApprovazione;

    private it.equitalia.dettagliocartellaavviso.wsdl.EnteType enteConcedente;

    private java.lang.String statoPiano;

    private it.equitalia.dettagliocartellaavviso.wsdl.RataType[] rata;

    private it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType[] documentoAssociato;

    private java.lang.String protocollo;

    public PianoRateazioneType() {
    }

    public PianoRateazioneType(
           java.lang.String codiceFiscale,
           java.lang.String dataApprovazione,
           it.equitalia.dettagliocartellaavviso.wsdl.EnteType enteConcedente,
           java.lang.String statoPiano,
           it.equitalia.dettagliocartellaavviso.wsdl.RataType[] rata,
           it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType[] documentoAssociato,
           java.lang.String protocollo) {
           this.codiceFiscale = codiceFiscale;
           this.dataApprovazione = dataApprovazione;
           this.enteConcedente = enteConcedente;
           this.statoPiano = statoPiano;
           this.rata = rata;
           this.documentoAssociato = documentoAssociato;
           this.protocollo = protocollo;
    }


    /**
     * Gets the codiceFiscale value for this PianoRateazioneType.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this PianoRateazioneType.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the dataApprovazione value for this PianoRateazioneType.
     * 
     * @return dataApprovazione
     */
    public java.lang.String getDataApprovazione() {
        return dataApprovazione;
    }


    /**
     * Sets the dataApprovazione value for this PianoRateazioneType.
     * 
     * @param dataApprovazione
     */
    public void setDataApprovazione(java.lang.String dataApprovazione) {
        this.dataApprovazione = dataApprovazione;
    }


    /**
     * Gets the enteConcedente value for this PianoRateazioneType.
     * 
     * @return enteConcedente
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.EnteType getEnteConcedente() {
        return enteConcedente;
    }


    /**
     * Sets the enteConcedente value for this PianoRateazioneType.
     * 
     * @param enteConcedente
     */
    public void setEnteConcedente(it.equitalia.dettagliocartellaavviso.wsdl.EnteType enteConcedente) {
        this.enteConcedente = enteConcedente;
    }


    /**
     * Gets the statoPiano value for this PianoRateazioneType.
     * 
     * @return statoPiano
     */
    public java.lang.String getStatoPiano() {
        return statoPiano;
    }


    /**
     * Sets the statoPiano value for this PianoRateazioneType.
     * 
     * @param statoPiano
     */
    public void setStatoPiano(java.lang.String statoPiano) {
        this.statoPiano = statoPiano;
    }


    /**
     * Gets the rata value for this PianoRateazioneType.
     * 
     * @return rata
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.RataType[] getRata() {
        return rata;
    }


    /**
     * Sets the rata value for this PianoRateazioneType.
     * 
     * @param rata
     */
    public void setRata(it.equitalia.dettagliocartellaavviso.wsdl.RataType[] rata) {
        this.rata = rata;
    }

    public it.equitalia.dettagliocartellaavviso.wsdl.RataType getRata(int i) {
        return this.rata[i];
    }

    public void setRata(int i, it.equitalia.dettagliocartellaavviso.wsdl.RataType _value) {
        this.rata[i] = _value;
    }


    /**
     * Gets the documentoAssociato value for this PianoRateazioneType.
     * 
     * @return documentoAssociato
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType[] getDocumentoAssociato() {
        return documentoAssociato;
    }


    /**
     * Sets the documentoAssociato value for this PianoRateazioneType.
     * 
     * @param documentoAssociato
     */
    public void setDocumentoAssociato(it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType[] documentoAssociato) {
        this.documentoAssociato = documentoAssociato;
    }

    public it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType getDocumentoAssociato(int i) {
        return this.documentoAssociato[i];
    }

    public void setDocumentoAssociato(int i, it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType _value) {
        this.documentoAssociato[i] = _value;
    }


    /**
     * Gets the protocollo value for this PianoRateazioneType.
     * 
     * @return protocollo
     */
    public java.lang.String getProtocollo() {
        return protocollo;
    }


    /**
     * Sets the protocollo value for this PianoRateazioneType.
     * 
     * @param protocollo
     */
    public void setProtocollo(java.lang.String protocollo) {
        this.protocollo = protocollo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PianoRateazioneType)) return false;
        PianoRateazioneType other = (PianoRateazioneType) obj;
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
            ((this.dataApprovazione==null && other.getDataApprovazione()==null) || 
             (this.dataApprovazione!=null &&
              this.dataApprovazione.equals(other.getDataApprovazione()))) &&
            ((this.enteConcedente==null && other.getEnteConcedente()==null) || 
             (this.enteConcedente!=null &&
              this.enteConcedente.equals(other.getEnteConcedente()))) &&
            ((this.statoPiano==null && other.getStatoPiano()==null) || 
             (this.statoPiano!=null &&
              this.statoPiano.equals(other.getStatoPiano()))) &&
            ((this.rata==null && other.getRata()==null) || 
             (this.rata!=null &&
              java.util.Arrays.equals(this.rata, other.getRata()))) &&
            ((this.documentoAssociato==null && other.getDocumentoAssociato()==null) || 
             (this.documentoAssociato!=null &&
              java.util.Arrays.equals(this.documentoAssociato, other.getDocumentoAssociato()))) &&
            ((this.protocollo==null && other.getProtocollo()==null) || 
             (this.protocollo!=null &&
              this.protocollo.equals(other.getProtocollo())));
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
        if (getDataApprovazione() != null) {
            _hashCode += getDataApprovazione().hashCode();
        }
        if (getEnteConcedente() != null) {
            _hashCode += getEnteConcedente().hashCode();
        }
        if (getStatoPiano() != null) {
            _hashCode += getStatoPiano().hashCode();
        }
        if (getRata() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRata());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRata(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocumentoAssociato() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentoAssociato());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentoAssociato(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProtocollo() != null) {
            _hashCode += getProtocollo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PianoRateazioneType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "PianoRateazioneType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "CodiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataApprovazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DataApprovazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enteConcedente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "EnteConcedente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "EnteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoPiano");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "StatoPiano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rata");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Rata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "RataType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoAssociato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DocumentoAssociato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "IdentificativoDocumentoType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocollo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Protocollo"));
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
