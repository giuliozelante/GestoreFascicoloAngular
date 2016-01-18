/**
 * TributoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class TributoType  implements java.io.Serializable {
    private IdentificativoDocumentoType idDocumento;

    private java.lang.String codiceTributo;

    private java.lang.String descrizioneTributo;

    private java.lang.String descrizioneTributoRuolo;

    private int progressivoTributo;

    private java.lang.String annoPartita;

    private java.lang.String numeroPartita;

    private java.lang.String numeroRuolo;

    private java.lang.String annoTributo;

    private EnteType ente;

    private java.lang.Double importoIniziale;

    private java.lang.Double importoPagato;

    private java.lang.Double importoInteressiMR;

    private java.lang.Double importoSgravato;

    private java.lang.Double importoResiduoTotale;

    private java.lang.Double importoSospeso;

    private java.lang.Double importoResiduoCorrente;

    private int rateizzabile;

    public TributoType() {
    }

    public TributoType(
           IdentificativoDocumentoType idDocumento,
           java.lang.String codiceTributo,
           java.lang.String descrizioneTributo,
           java.lang.String descrizioneTributoRuolo,
           int progressivoTributo,
           java.lang.String annoPartita,
           java.lang.String numeroPartita,
           java.lang.String numeroRuolo,
           java.lang.String annoTributo,
           EnteType ente,
           java.lang.Double importoIniziale,
           java.lang.Double importoPagato,
           java.lang.Double importoInteressiMR,
           java.lang.Double importoSgravato,
           java.lang.Double importoResiduoTotale,
           java.lang.Double importoSospeso,
           java.lang.Double importoResiduoCorrente,
           int rateizzabile) {
           this.idDocumento = idDocumento;
           this.codiceTributo = codiceTributo;
           this.descrizioneTributo = descrizioneTributo;
           this.descrizioneTributoRuolo = descrizioneTributoRuolo;
           this.progressivoTributo = progressivoTributo;
           this.annoPartita = annoPartita;
           this.numeroPartita = numeroPartita;
           this.numeroRuolo = numeroRuolo;
           this.annoTributo = annoTributo;
           this.ente = ente;
           this.importoIniziale = importoIniziale;
           this.importoPagato = importoPagato;
           this.importoInteressiMR = importoInteressiMR;
           this.importoSgravato = importoSgravato;
           this.importoResiduoTotale = importoResiduoTotale;
           this.importoSospeso = importoSospeso;
           this.importoResiduoCorrente = importoResiduoCorrente;
           this.rateizzabile = rateizzabile;
    }


    /**
     * Gets the idDocumento value for this TributoType.
     * 
     * @return idDocumento
     */
    public IdentificativoDocumentoType getIdDocumento() {
        return idDocumento;
    }


    /**
     * Sets the idDocumento value for this TributoType.
     * 
     * @param idDocumento
     */
    public void setIdDocumento(IdentificativoDocumentoType idDocumento) {
        this.idDocumento = idDocumento;
    }


    /**
     * Gets the codiceTributo value for this TributoType.
     * 
     * @return codiceTributo
     */
    public java.lang.String getCodiceTributo() {
        return codiceTributo;
    }


    /**
     * Sets the codiceTributo value for this TributoType.
     * 
     * @param codiceTributo
     */
    public void setCodiceTributo(java.lang.String codiceTributo) {
        this.codiceTributo = codiceTributo;
    }


    /**
     * Gets the descrizioneTributo value for this TributoType.
     * 
     * @return descrizioneTributo
     */
    public java.lang.String getDescrizioneTributo() {
        return descrizioneTributo;
    }


    /**
     * Sets the descrizioneTributo value for this TributoType.
     * 
     * @param descrizioneTributo
     */
    public void setDescrizioneTributo(java.lang.String descrizioneTributo) {
        this.descrizioneTributo = descrizioneTributo;
    }


    /**
     * Gets the descrizioneTributoRuolo value for this TributoType.
     * 
     * @return descrizioneTributoRuolo
     */
    public java.lang.String getDescrizioneTributoRuolo() {
        return descrizioneTributoRuolo;
    }


    /**
     * Sets the descrizioneTributoRuolo value for this TributoType.
     * 
     * @param descrizioneTributoRuolo
     */
    public void setDescrizioneTributoRuolo(java.lang.String descrizioneTributoRuolo) {
        this.descrizioneTributoRuolo = descrizioneTributoRuolo;
    }


    /**
     * Gets the progressivoTributo value for this TributoType.
     * 
     * @return progressivoTributo
     */
    public int getProgressivoTributo() {
        return progressivoTributo;
    }


    /**
     * Sets the progressivoTributo value for this TributoType.
     * 
     * @param progressivoTributo
     */
    public void setProgressivoTributo(int progressivoTributo) {
        this.progressivoTributo = progressivoTributo;
    }


    /**
     * Gets the annoPartita value for this TributoType.
     * 
     * @return annoPartita
     */
    public java.lang.String getAnnoPartita() {
        return annoPartita;
    }


    /**
     * Sets the annoPartita value for this TributoType.
     * 
     * @param annoPartita
     */
    public void setAnnoPartita(java.lang.String annoPartita) {
        this.annoPartita = annoPartita;
    }


    /**
     * Gets the numeroPartita value for this TributoType.
     * 
     * @return numeroPartita
     */
    public java.lang.String getNumeroPartita() {
        return numeroPartita;
    }


    /**
     * Sets the numeroPartita value for this TributoType.
     * 
     * @param numeroPartita
     */
    public void setNumeroPartita(java.lang.String numeroPartita) {
        this.numeroPartita = numeroPartita;
    }


    /**
     * Gets the numeroRuolo value for this TributoType.
     * 
     * @return numeroRuolo
     */
    public java.lang.String getNumeroRuolo() {
        return numeroRuolo;
    }


    /**
     * Sets the numeroRuolo value for this TributoType.
     * 
     * @param numeroRuolo
     */
    public void setNumeroRuolo(java.lang.String numeroRuolo) {
        this.numeroRuolo = numeroRuolo;
    }


    /**
     * Gets the annoTributo value for this TributoType.
     * 
     * @return annoTributo
     */
    public java.lang.String getAnnoTributo() {
        return annoTributo;
    }


    /**
     * Sets the annoTributo value for this TributoType.
     * 
     * @param annoTributo
     */
    public void setAnnoTributo(java.lang.String annoTributo) {
        this.annoTributo = annoTributo;
    }


    /**
     * Gets the ente value for this TributoType.
     * 
     * @return ente
     */
    public EnteType getEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this TributoType.
     * 
     * @param ente
     */
    public void setEnte(EnteType ente) {
        this.ente = ente;
    }


    /**
     * Gets the importoIniziale value for this TributoType.
     * 
     * @return importoIniziale
     */
    public java.lang.Double getImportoIniziale() {
        return importoIniziale;
    }


    /**
     * Sets the importoIniziale value for this TributoType.
     * 
     * @param importoIniziale
     */
    public void setImportoIniziale(java.lang.Double importoIniziale) {
        this.importoIniziale = importoIniziale;
    }


    /**
     * Gets the importoPagato value for this TributoType.
     * 
     * @return importoPagato
     */
    public java.lang.Double getImportoPagato() {
        return importoPagato;
    }


    /**
     * Sets the importoPagato value for this TributoType.
     * 
     * @param importoPagato
     */
    public void setImportoPagato(java.lang.Double importoPagato) {
        this.importoPagato = importoPagato;
    }


    /**
     * Gets the importoInteressiMR value for this TributoType.
     * 
     * @return importoInteressiMR
     */
    public java.lang.Double getImportoInteressiMR() {
        return importoInteressiMR;
    }


    /**
     * Sets the importoInteressiMR value for this TributoType.
     * 
     * @param importoInteressiMR
     */
    public void setImportoInteressiMR(java.lang.Double importoInteressiMR) {
        this.importoInteressiMR = importoInteressiMR;
    }


    /**
     * Gets the importoSgravato value for this TributoType.
     * 
     * @return importoSgravato
     */
    public java.lang.Double getImportoSgravato() {
        return importoSgravato;
    }


    /**
     * Sets the importoSgravato value for this TributoType.
     * 
     * @param importoSgravato
     */
    public void setImportoSgravato(java.lang.Double importoSgravato) {
        this.importoSgravato = importoSgravato;
    }


    /**
     * Gets the importoResiduoTotale value for this TributoType.
     * 
     * @return importoResiduoTotale
     */
    public java.lang.Double getImportoResiduoTotale() {
        return importoResiduoTotale;
    }


    /**
     * Sets the importoResiduoTotale value for this TributoType.
     * 
     * @param importoResiduoTotale
     */
    public void setImportoResiduoTotale(java.lang.Double importoResiduoTotale) {
        this.importoResiduoTotale = importoResiduoTotale;
    }


    /**
     * Gets the importoSospeso value for this TributoType.
     * 
     * @return importoSospeso
     */
    public java.lang.Double getImportoSospeso() {
        return importoSospeso;
    }


    /**
     * Sets the importoSospeso value for this TributoType.
     * 
     * @param importoSospeso
     */
    public void setImportoSospeso(java.lang.Double importoSospeso) {
        this.importoSospeso = importoSospeso;
    }


    /**
     * Gets the importoResiduoCorrente value for this TributoType.
     * 
     * @return importoResiduoCorrente
     */
    public java.lang.Double getImportoResiduoCorrente() {
        return importoResiduoCorrente;
    }


    /**
     * Sets the importoResiduoCorrente value for this TributoType.
     * 
     * @param importoResiduoCorrente
     */
    public void setImportoResiduoCorrente(java.lang.Double importoResiduoCorrente) {
        this.importoResiduoCorrente = importoResiduoCorrente;
    }


    /**
     * Gets the rateizzabile value for this TributoType.
     * 
     * @return rateizzabile
     */
    public int getRateizzabile() {
        return rateizzabile;
    }


    /**
     * Sets the rateizzabile value for this TributoType.
     * 
     * @param rateizzabile
     */
    public void setRateizzabile(int rateizzabile) {
        this.rateizzabile = rateizzabile;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TributoType)) return false;
        TributoType other = (TributoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idDocumento==null && other.getIdDocumento()==null) || 
             (this.idDocumento!=null &&
              this.idDocumento.equals(other.getIdDocumento()))) &&
            ((this.codiceTributo==null && other.getCodiceTributo()==null) || 
             (this.codiceTributo!=null &&
              this.codiceTributo.equals(other.getCodiceTributo()))) &&
            ((this.descrizioneTributo==null && other.getDescrizioneTributo()==null) || 
             (this.descrizioneTributo!=null &&
              this.descrizioneTributo.equals(other.getDescrizioneTributo()))) &&
            ((this.descrizioneTributoRuolo==null && other.getDescrizioneTributoRuolo()==null) || 
             (this.descrizioneTributoRuolo!=null &&
              this.descrizioneTributoRuolo.equals(other.getDescrizioneTributoRuolo()))) &&
            this.progressivoTributo == other.getProgressivoTributo() &&
            ((this.annoPartita==null && other.getAnnoPartita()==null) || 
             (this.annoPartita!=null &&
              this.annoPartita.equals(other.getAnnoPartita()))) &&
            ((this.numeroPartita==null && other.getNumeroPartita()==null) || 
             (this.numeroPartita!=null &&
              this.numeroPartita.equals(other.getNumeroPartita()))) &&
            ((this.numeroRuolo==null && other.getNumeroRuolo()==null) || 
             (this.numeroRuolo!=null &&
              this.numeroRuolo.equals(other.getNumeroRuolo()))) &&
            ((this.annoTributo==null && other.getAnnoTributo()==null) || 
             (this.annoTributo!=null &&
              this.annoTributo.equals(other.getAnnoTributo()))) &&
            ((this.ente==null && other.getEnte()==null) || 
             (this.ente!=null &&
              this.ente.equals(other.getEnte()))) &&
            ((this.importoIniziale==null && other.getImportoIniziale()==null) || 
             (this.importoIniziale!=null &&
              this.importoIniziale.equals(other.getImportoIniziale()))) &&
            ((this.importoPagato==null && other.getImportoPagato()==null) || 
             (this.importoPagato!=null &&
              this.importoPagato.equals(other.getImportoPagato()))) &&
            ((this.importoInteressiMR==null && other.getImportoInteressiMR()==null) || 
             (this.importoInteressiMR!=null &&
              this.importoInteressiMR.equals(other.getImportoInteressiMR()))) &&
            ((this.importoSgravato==null && other.getImportoSgravato()==null) || 
             (this.importoSgravato!=null &&
              this.importoSgravato.equals(other.getImportoSgravato()))) &&
            ((this.importoResiduoTotale==null && other.getImportoResiduoTotale()==null) || 
             (this.importoResiduoTotale!=null &&
              this.importoResiduoTotale.equals(other.getImportoResiduoTotale()))) &&
            ((this.importoSospeso==null && other.getImportoSospeso()==null) || 
             (this.importoSospeso!=null &&
              this.importoSospeso.equals(other.getImportoSospeso()))) &&
            ((this.importoResiduoCorrente==null && other.getImportoResiduoCorrente()==null) || 
             (this.importoResiduoCorrente!=null &&
              this.importoResiduoCorrente.equals(other.getImportoResiduoCorrente()))) &&
            this.rateizzabile == other.getRateizzabile();
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
        if (getIdDocumento() != null) {
            _hashCode += getIdDocumento().hashCode();
        }
        if (getCodiceTributo() != null) {
            _hashCode += getCodiceTributo().hashCode();
        }
        if (getDescrizioneTributo() != null) {
            _hashCode += getDescrizioneTributo().hashCode();
        }
        if (getDescrizioneTributoRuolo() != null) {
            _hashCode += getDescrizioneTributoRuolo().hashCode();
        }
        _hashCode += getProgressivoTributo();
        if (getAnnoPartita() != null) {
            _hashCode += getAnnoPartita().hashCode();
        }
        if (getNumeroPartita() != null) {
            _hashCode += getNumeroPartita().hashCode();
        }
        if (getNumeroRuolo() != null) {
            _hashCode += getNumeroRuolo().hashCode();
        }
        if (getAnnoTributo() != null) {
            _hashCode += getAnnoTributo().hashCode();
        }
        if (getEnte() != null) {
            _hashCode += getEnte().hashCode();
        }
        if (getImportoIniziale() != null) {
            _hashCode += getImportoIniziale().hashCode();
        }
        if (getImportoPagato() != null) {
            _hashCode += getImportoPagato().hashCode();
        }
        if (getImportoInteressiMR() != null) {
            _hashCode += getImportoInteressiMR().hashCode();
        }
        if (getImportoSgravato() != null) {
            _hashCode += getImportoSgravato().hashCode();
        }
        if (getImportoResiduoTotale() != null) {
            _hashCode += getImportoResiduoTotale().hashCode();
        }
        if (getImportoSospeso() != null) {
            _hashCode += getImportoSospeso().hashCode();
        }
        if (getImportoResiduoCorrente() != null) {
            _hashCode += getImportoResiduoCorrente().hashCode();
        }
        _hashCode += getRateizzabile();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TributoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "TributoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "IdDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "IdentificativoDocumentoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceTributo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "CodiceTributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneTributo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DescrizioneTributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneTributoRuolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DescrizioneTributoRuolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("progressivoTributo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ProgressivoTributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annoPartita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "AnnoPartita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPartita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "NumeroPartita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroRuolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "NumeroRuolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annoTributo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "AnnoTributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "Ente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "EnteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoIniziale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ImportoIniziale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ImportoPagato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoInteressiMR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ImportoInteressiMR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoSgravato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ImportoSgravato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoTotale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ImportoResiduoTotale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoSospeso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ImportoSospeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoCorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ImportoResiduoCorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rateizzabile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "Rateizzabile"));
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
