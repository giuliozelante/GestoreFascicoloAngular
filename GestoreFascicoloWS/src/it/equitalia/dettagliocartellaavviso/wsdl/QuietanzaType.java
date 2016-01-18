/**
 * QuietanzaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class QuietanzaType  implements java.io.Serializable {
    private java.math.BigInteger numeroQuietanza;

    private java.lang.String tipoPagamento;

    private java.lang.String canalePagamento;

    private java.util.Date dataPagamento;

    private java.math.BigDecimal importoQuietanza;

    private it.equitalia.dettagliocartellaavviso.wsdl.IndicatoreQuietanzeAnnullateType quietanzaAnnullata;

    private java.util.Date dataAnnulloQuietanza;

    private java.lang.String codiceFiscaleVersante;

    private java.math.BigDecimal importoTributi;

    private java.math.BigDecimal importoInteressiMora;

    private java.math.BigDecimal importoCompensi;

    private java.math.BigDecimal importoDirittiNotifica;

    private java.math.BigDecimal importoSpese;

    private it.equitalia.dettagliocartellaavviso.wsdl.TributoQuietanzaType[] tributiQuietanza;

    public QuietanzaType() {
    }

    public QuietanzaType(
           java.math.BigInteger numeroQuietanza,
           java.lang.String tipoPagamento,
           java.lang.String canalePagamento,
           java.util.Date dataPagamento,
           java.math.BigDecimal importoQuietanza,
           it.equitalia.dettagliocartellaavviso.wsdl.IndicatoreQuietanzeAnnullateType quietanzaAnnullata,
           java.util.Date dataAnnulloQuietanza,
           java.lang.String codiceFiscaleVersante,
           java.math.BigDecimal importoTributi,
           java.math.BigDecimal importoInteressiMora,
           java.math.BigDecimal importoCompensi,
           java.math.BigDecimal importoDirittiNotifica,
           java.math.BigDecimal importoSpese,
           it.equitalia.dettagliocartellaavviso.wsdl.TributoQuietanzaType[] tributiQuietanza) {
           this.numeroQuietanza = numeroQuietanza;
           this.tipoPagamento = tipoPagamento;
           this.canalePagamento = canalePagamento;
           this.dataPagamento = dataPagamento;
           this.importoQuietanza = importoQuietanza;
           this.quietanzaAnnullata = quietanzaAnnullata;
           this.dataAnnulloQuietanza = dataAnnulloQuietanza;
           this.codiceFiscaleVersante = codiceFiscaleVersante;
           this.importoTributi = importoTributi;
           this.importoInteressiMora = importoInteressiMora;
           this.importoCompensi = importoCompensi;
           this.importoDirittiNotifica = importoDirittiNotifica;
           this.importoSpese = importoSpese;
           this.tributiQuietanza = tributiQuietanza;
    }


    /**
     * Gets the numeroQuietanza value for this QuietanzaType.
     * 
     * @return numeroQuietanza
     */
    public java.math.BigInteger getNumeroQuietanza() {
        return numeroQuietanza;
    }


    /**
     * Sets the numeroQuietanza value for this QuietanzaType.
     * 
     * @param numeroQuietanza
     */
    public void setNumeroQuietanza(java.math.BigInteger numeroQuietanza) {
        this.numeroQuietanza = numeroQuietanza;
    }


    /**
     * Gets the tipoPagamento value for this QuietanzaType.
     * 
     * @return tipoPagamento
     */
    public java.lang.String getTipoPagamento() {
        return tipoPagamento;
    }


    /**
     * Sets the tipoPagamento value for this QuietanzaType.
     * 
     * @param tipoPagamento
     */
    public void setTipoPagamento(java.lang.String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    /**
     * Gets the canalePagamento value for this QuietanzaType.
     * 
     * @return canalePagamento
     */
    public java.lang.String getCanalePagamento() {
        return canalePagamento;
    }


    /**
     * Sets the canalePagamento value for this QuietanzaType.
     * 
     * @param canalePagamento
     */
    public void setCanalePagamento(java.lang.String canalePagamento) {
        this.canalePagamento = canalePagamento;
    }


    /**
     * Gets the dataPagamento value for this QuietanzaType.
     * 
     * @return dataPagamento
     */
    public java.util.Date getDataPagamento() {
        return dataPagamento;
    }


    /**
     * Sets the dataPagamento value for this QuietanzaType.
     * 
     * @param dataPagamento
     */
    public void setDataPagamento(java.util.Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


    /**
     * Gets the importoQuietanza value for this QuietanzaType.
     * 
     * @return importoQuietanza
     */
    public java.math.BigDecimal getImportoQuietanza() {
        return importoQuietanza;
    }


    /**
     * Sets the importoQuietanza value for this QuietanzaType.
     * 
     * @param importoQuietanza
     */
    public void setImportoQuietanza(java.math.BigDecimal importoQuietanza) {
        this.importoQuietanza = importoQuietanza;
    }


    /**
     * Gets the quietanzaAnnullata value for this QuietanzaType.
     * 
     * @return quietanzaAnnullata
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.IndicatoreQuietanzeAnnullateType getQuietanzaAnnullata() {
        return quietanzaAnnullata;
    }


    /**
     * Sets the quietanzaAnnullata value for this QuietanzaType.
     * 
     * @param quietanzaAnnullata
     */
    public void setQuietanzaAnnullata(it.equitalia.dettagliocartellaavviso.wsdl.IndicatoreQuietanzeAnnullateType quietanzaAnnullata) {
        this.quietanzaAnnullata = quietanzaAnnullata;
    }


    /**
     * Gets the dataAnnulloQuietanza value for this QuietanzaType.
     * 
     * @return dataAnnulloQuietanza
     */
    public java.util.Date getDataAnnulloQuietanza() {
        return dataAnnulloQuietanza;
    }


    /**
     * Sets the dataAnnulloQuietanza value for this QuietanzaType.
     * 
     * @param dataAnnulloQuietanza
     */
    public void setDataAnnulloQuietanza(java.util.Date dataAnnulloQuietanza) {
        this.dataAnnulloQuietanza = dataAnnulloQuietanza;
    }


    /**
     * Gets the codiceFiscaleVersante value for this QuietanzaType.
     * 
     * @return codiceFiscaleVersante
     */
    public java.lang.String getCodiceFiscaleVersante() {
        return codiceFiscaleVersante;
    }


    /**
     * Sets the codiceFiscaleVersante value for this QuietanzaType.
     * 
     * @param codiceFiscaleVersante
     */
    public void setCodiceFiscaleVersante(java.lang.String codiceFiscaleVersante) {
        this.codiceFiscaleVersante = codiceFiscaleVersante;
    }


    /**
     * Gets the importoTributi value for this QuietanzaType.
     * 
     * @return importoTributi
     */
    public java.math.BigDecimal getImportoTributi() {
        return importoTributi;
    }


    /**
     * Sets the importoTributi value for this QuietanzaType.
     * 
     * @param importoTributi
     */
    public void setImportoTributi(java.math.BigDecimal importoTributi) {
        this.importoTributi = importoTributi;
    }


    /**
     * Gets the importoInteressiMora value for this QuietanzaType.
     * 
     * @return importoInteressiMora
     */
    public java.math.BigDecimal getImportoInteressiMora() {
        return importoInteressiMora;
    }


    /**
     * Sets the importoInteressiMora value for this QuietanzaType.
     * 
     * @param importoInteressiMora
     */
    public void setImportoInteressiMora(java.math.BigDecimal importoInteressiMora) {
        this.importoInteressiMora = importoInteressiMora;
    }


    /**
     * Gets the importoCompensi value for this QuietanzaType.
     * 
     * @return importoCompensi
     */
    public java.math.BigDecimal getImportoCompensi() {
        return importoCompensi;
    }


    /**
     * Sets the importoCompensi value for this QuietanzaType.
     * 
     * @param importoCompensi
     */
    public void setImportoCompensi(java.math.BigDecimal importoCompensi) {
        this.importoCompensi = importoCompensi;
    }


    /**
     * Gets the importoDirittiNotifica value for this QuietanzaType.
     * 
     * @return importoDirittiNotifica
     */
    public java.math.BigDecimal getImportoDirittiNotifica() {
        return importoDirittiNotifica;
    }


    /**
     * Sets the importoDirittiNotifica value for this QuietanzaType.
     * 
     * @param importoDirittiNotifica
     */
    public void setImportoDirittiNotifica(java.math.BigDecimal importoDirittiNotifica) {
        this.importoDirittiNotifica = importoDirittiNotifica;
    }


    /**
     * Gets the importoSpese value for this QuietanzaType.
     * 
     * @return importoSpese
     */
    public java.math.BigDecimal getImportoSpese() {
        return importoSpese;
    }


    /**
     * Sets the importoSpese value for this QuietanzaType.
     * 
     * @param importoSpese
     */
    public void setImportoSpese(java.math.BigDecimal importoSpese) {
        this.importoSpese = importoSpese;
    }


    /**
     * Gets the tributiQuietanza value for this QuietanzaType.
     * 
     * @return tributiQuietanza
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.TributoQuietanzaType[] getTributiQuietanza() {
        return tributiQuietanza;
    }


    /**
     * Sets the tributiQuietanza value for this QuietanzaType.
     * 
     * @param tributiQuietanza
     */
    public void setTributiQuietanza(it.equitalia.dettagliocartellaavviso.wsdl.TributoQuietanzaType[] tributiQuietanza) {
        this.tributiQuietanza = tributiQuietanza;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QuietanzaType)) return false;
        QuietanzaType other = (QuietanzaType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroQuietanza==null && other.getNumeroQuietanza()==null) || 
             (this.numeroQuietanza!=null &&
              this.numeroQuietanza.equals(other.getNumeroQuietanza()))) &&
            ((this.tipoPagamento==null && other.getTipoPagamento()==null) || 
             (this.tipoPagamento!=null &&
              this.tipoPagamento.equals(other.getTipoPagamento()))) &&
            ((this.canalePagamento==null && other.getCanalePagamento()==null) || 
             (this.canalePagamento!=null &&
              this.canalePagamento.equals(other.getCanalePagamento()))) &&
            ((this.dataPagamento==null && other.getDataPagamento()==null) || 
             (this.dataPagamento!=null &&
              this.dataPagamento.equals(other.getDataPagamento()))) &&
            ((this.importoQuietanza==null && other.getImportoQuietanza()==null) || 
             (this.importoQuietanza!=null &&
              this.importoQuietanza.equals(other.getImportoQuietanza()))) &&
            ((this.quietanzaAnnullata==null && other.getQuietanzaAnnullata()==null) || 
             (this.quietanzaAnnullata!=null &&
              this.quietanzaAnnullata.equals(other.getQuietanzaAnnullata()))) &&
            ((this.dataAnnulloQuietanza==null && other.getDataAnnulloQuietanza()==null) || 
             (this.dataAnnulloQuietanza!=null &&
              this.dataAnnulloQuietanza.equals(other.getDataAnnulloQuietanza()))) &&
            ((this.codiceFiscaleVersante==null && other.getCodiceFiscaleVersante()==null) || 
             (this.codiceFiscaleVersante!=null &&
              this.codiceFiscaleVersante.equals(other.getCodiceFiscaleVersante()))) &&
            ((this.importoTributi==null && other.getImportoTributi()==null) || 
             (this.importoTributi!=null &&
              this.importoTributi.equals(other.getImportoTributi()))) &&
            ((this.importoInteressiMora==null && other.getImportoInteressiMora()==null) || 
             (this.importoInteressiMora!=null &&
              this.importoInteressiMora.equals(other.getImportoInteressiMora()))) &&
            ((this.importoCompensi==null && other.getImportoCompensi()==null) || 
             (this.importoCompensi!=null &&
              this.importoCompensi.equals(other.getImportoCompensi()))) &&
            ((this.importoDirittiNotifica==null && other.getImportoDirittiNotifica()==null) || 
             (this.importoDirittiNotifica!=null &&
              this.importoDirittiNotifica.equals(other.getImportoDirittiNotifica()))) &&
            ((this.importoSpese==null && other.getImportoSpese()==null) || 
             (this.importoSpese!=null &&
              this.importoSpese.equals(other.getImportoSpese()))) &&
            ((this.tributiQuietanza==null && other.getTributiQuietanza()==null) || 
             (this.tributiQuietanza!=null &&
              java.util.Arrays.equals(this.tributiQuietanza, other.getTributiQuietanza())));
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
        if (getNumeroQuietanza() != null) {
            _hashCode += getNumeroQuietanza().hashCode();
        }
        if (getTipoPagamento() != null) {
            _hashCode += getTipoPagamento().hashCode();
        }
        if (getCanalePagamento() != null) {
            _hashCode += getCanalePagamento().hashCode();
        }
        if (getDataPagamento() != null) {
            _hashCode += getDataPagamento().hashCode();
        }
        if (getImportoQuietanza() != null) {
            _hashCode += getImportoQuietanza().hashCode();
        }
        if (getQuietanzaAnnullata() != null) {
            _hashCode += getQuietanzaAnnullata().hashCode();
        }
        if (getDataAnnulloQuietanza() != null) {
            _hashCode += getDataAnnulloQuietanza().hashCode();
        }
        if (getCodiceFiscaleVersante() != null) {
            _hashCode += getCodiceFiscaleVersante().hashCode();
        }
        if (getImportoTributi() != null) {
            _hashCode += getImportoTributi().hashCode();
        }
        if (getImportoInteressiMora() != null) {
            _hashCode += getImportoInteressiMora().hashCode();
        }
        if (getImportoCompensi() != null) {
            _hashCode += getImportoCompensi().hashCode();
        }
        if (getImportoDirittiNotifica() != null) {
            _hashCode += getImportoDirittiNotifica().hashCode();
        }
        if (getImportoSpese() != null) {
            _hashCode += getImportoSpese().hashCode();
        }
        if (getTributiQuietanza() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTributiQuietanza());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTributiQuietanza(), i);
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
        new org.apache.axis.description.TypeDesc(QuietanzaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "QuietanzaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroQuietanza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "numeroQuietanza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPagamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "tipoPagamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canalePagamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "canalePagamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataPagamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "dataPagamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoQuietanza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "importoQuietanza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quietanzaAnnullata");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "quietanzaAnnullata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "IndicatoreQuietanzeAnnullateType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAnnulloQuietanza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "dataAnnulloQuietanza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscaleVersante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "codiceFiscaleVersante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "importoTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoInteressiMora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "importoInteressiMora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoCompensi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "importoCompensi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoDirittiNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "importoDirittiNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoSpese");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "importoSpese"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tributiQuietanza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "tributiQuietanza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "TributoQuietanzaType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "tributoQuietanza"));
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
