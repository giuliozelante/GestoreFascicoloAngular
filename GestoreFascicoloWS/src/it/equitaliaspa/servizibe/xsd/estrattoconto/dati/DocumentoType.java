/**
 * DocumentoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitaliaspa.servizibe.xsd.estrattoconto.dati;

public class DocumentoType  implements java.io.Serializable {
    private it.equitaliaspa.servizibe.xsd.estrattoconto.dati.IdentificativoDocumentoType idDocumento;

    private it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EnteType[] ente;

    private java.lang.String annoEmissione;

    private java.lang.String statoDocumento;

    private java.util.Date dataNotifica;

    private java.lang.String numeroRav;

    /* Fornisce un riepilogo sul numero di tributi
     * 						associati alla cartella. */
    private java.lang.Integer sommarioTributi;

    private java.lang.Double importoTotaleDocumento;

    private java.lang.Double importoPagatoDocumento;

    private java.lang.Double importoResiduoDocumento;

    private java.lang.Double importoInizialeTributi;

    private java.lang.Double importoPagatoTributi;

    private java.lang.Double importoResiduoTributi;

    private java.lang.Double importoTotaleNotifica;

    private java.lang.Double importoPagatoNotifica;

    private java.lang.Double importoResiduoNotifica;

    private java.lang.Double importoTotaleCompensi;

    private java.lang.Double importoPagatoCompensi;

    private java.lang.Double importoResiduoCompensi;

    private java.lang.Double importoInteressiMora;

    private java.lang.Double importoAltreSpese;

    private java.lang.Double importoSpeseProcedure;

    private java.lang.Integer flagRateazione;

    private java.lang.Integer flagSgravio;

    private java.lang.Integer flagSospensione;

    private java.lang.Integer flagProcedura;

    private java.lang.String codiceEsitoDettaglio;

    private java.lang.Double importoTotaleSgravato;

    private java.lang.Double importoTotaleSospeso;

    public DocumentoType() {
    }

    public DocumentoType(
           it.equitaliaspa.servizibe.xsd.estrattoconto.dati.IdentificativoDocumentoType idDocumento,
           it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EnteType[] ente,
           java.lang.String annoEmissione,
           java.lang.String statoDocumento,
           java.util.Date dataNotifica,
           java.lang.String numeroRav,
           java.lang.Integer sommarioTributi,
           java.lang.Double importoTotaleDocumento,
           java.lang.Double importoPagatoDocumento,
           java.lang.Double importoResiduoDocumento,
           java.lang.Double importoInizialeTributi,
           java.lang.Double importoPagatoTributi,
           java.lang.Double importoResiduoTributi,
           java.lang.Double importoTotaleNotifica,
           java.lang.Double importoPagatoNotifica,
           java.lang.Double importoResiduoNotifica,
           java.lang.Double importoTotaleCompensi,
           java.lang.Double importoPagatoCompensi,
           java.lang.Double importoResiduoCompensi,
           java.lang.Double importoInteressiMora,
           java.lang.Double importoAltreSpese,
           java.lang.Double importoSpeseProcedure,
           java.lang.Integer flagRateazione,
           java.lang.Integer flagSgravio,
           java.lang.Integer flagSospensione,
           java.lang.Integer flagProcedura,
           java.lang.String codiceEsitoDettaglio,
           java.lang.Double importoTotaleSgravato,
           java.lang.Double importoTotaleSospeso) {
           this.idDocumento = idDocumento;
           this.ente = ente;
           this.annoEmissione = annoEmissione;
           this.statoDocumento = statoDocumento;
           this.dataNotifica = dataNotifica;
           this.numeroRav = numeroRav;
           this.sommarioTributi = sommarioTributi;
           this.importoTotaleDocumento = importoTotaleDocumento;
           this.importoPagatoDocumento = importoPagatoDocumento;
           this.importoResiduoDocumento = importoResiduoDocumento;
           this.importoInizialeTributi = importoInizialeTributi;
           this.importoPagatoTributi = importoPagatoTributi;
           this.importoResiduoTributi = importoResiduoTributi;
           this.importoTotaleNotifica = importoTotaleNotifica;
           this.importoPagatoNotifica = importoPagatoNotifica;
           this.importoResiduoNotifica = importoResiduoNotifica;
           this.importoTotaleCompensi = importoTotaleCompensi;
           this.importoPagatoCompensi = importoPagatoCompensi;
           this.importoResiduoCompensi = importoResiduoCompensi;
           this.importoInteressiMora = importoInteressiMora;
           this.importoAltreSpese = importoAltreSpese;
           this.importoSpeseProcedure = importoSpeseProcedure;
           this.flagRateazione = flagRateazione;
           this.flagSgravio = flagSgravio;
           this.flagSospensione = flagSospensione;
           this.flagProcedura = flagProcedura;
           this.codiceEsitoDettaglio = codiceEsitoDettaglio;
           this.importoTotaleSgravato = importoTotaleSgravato;
           this.importoTotaleSospeso = importoTotaleSospeso;
    }


    /**
     * Gets the idDocumento value for this DocumentoType.
     * 
     * @return idDocumento
     */
    public it.equitaliaspa.servizibe.xsd.estrattoconto.dati.IdentificativoDocumentoType getIdDocumento() {
        return idDocumento;
    }


    /**
     * Sets the idDocumento value for this DocumentoType.
     * 
     * @param idDocumento
     */
    public void setIdDocumento(it.equitaliaspa.servizibe.xsd.estrattoconto.dati.IdentificativoDocumentoType idDocumento) {
        this.idDocumento = idDocumento;
    }


    /**
     * Gets the ente value for this DocumentoType.
     * 
     * @return ente
     */
    public it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EnteType[] getEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this DocumentoType.
     * 
     * @param ente
     */
    public void setEnte(it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EnteType[] ente) {
        this.ente = ente;
    }

    public it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EnteType getEnte(int i) {
        return this.ente[i];
    }

    public void setEnte(int i, it.equitaliaspa.servizibe.xsd.estrattoconto.dati.EnteType _value) {
        this.ente[i] = _value;
    }


    /**
     * Gets the annoEmissione value for this DocumentoType.
     * 
     * @return annoEmissione
     */
    public java.lang.String getAnnoEmissione() {
        return annoEmissione;
    }


    /**
     * Sets the annoEmissione value for this DocumentoType.
     * 
     * @param annoEmissione
     */
    public void setAnnoEmissione(java.lang.String annoEmissione) {
        this.annoEmissione = annoEmissione;
    }


    /**
     * Gets the statoDocumento value for this DocumentoType.
     * 
     * @return statoDocumento
     */
    public java.lang.String getStatoDocumento() {
        return statoDocumento;
    }


    /**
     * Sets the statoDocumento value for this DocumentoType.
     * 
     * @param statoDocumento
     */
    public void setStatoDocumento(java.lang.String statoDocumento) {
        this.statoDocumento = statoDocumento;
    }


    /**
     * Gets the dataNotifica value for this DocumentoType.
     * 
     * @return dataNotifica
     */
    public java.util.Date getDataNotifica() {
        return dataNotifica;
    }


    /**
     * Sets the dataNotifica value for this DocumentoType.
     * 
     * @param dataNotifica
     */
    public void setDataNotifica(java.util.Date dataNotifica) {
        this.dataNotifica = dataNotifica;
    }


    /**
     * Gets the numeroRav value for this DocumentoType.
     * 
     * @return numeroRav
     */
    public java.lang.String getNumeroRav() {
        return numeroRav;
    }


    /**
     * Sets the numeroRav value for this DocumentoType.
     * 
     * @param numeroRav
     */
    public void setNumeroRav(java.lang.String numeroRav) {
        this.numeroRav = numeroRav;
    }


    /**
     * Gets the sommarioTributi value for this DocumentoType.
     * 
     * @return sommarioTributi   * Fornisce un riepilogo sul numero di tributi
     * 						associati alla cartella.
     */
    public java.lang.Integer getSommarioTributi() {
        return sommarioTributi;
    }


    /**
     * Sets the sommarioTributi value for this DocumentoType.
     * 
     * @param sommarioTributi   * Fornisce un riepilogo sul numero di tributi
     * 						associati alla cartella.
     */
    public void setSommarioTributi(java.lang.Integer sommarioTributi) {
        this.sommarioTributi = sommarioTributi;
    }


    /**
     * Gets the importoTotaleDocumento value for this DocumentoType.
     * 
     * @return importoTotaleDocumento
     */
    public java.lang.Double getImportoTotaleDocumento() {
        return importoTotaleDocumento;
    }


    /**
     * Sets the importoTotaleDocumento value for this DocumentoType.
     * 
     * @param importoTotaleDocumento
     */
    public void setImportoTotaleDocumento(java.lang.Double importoTotaleDocumento) {
        this.importoTotaleDocumento = importoTotaleDocumento;
    }


    /**
     * Gets the importoPagatoDocumento value for this DocumentoType.
     * 
     * @return importoPagatoDocumento
     */
    public java.lang.Double getImportoPagatoDocumento() {
        return importoPagatoDocumento;
    }


    /**
     * Sets the importoPagatoDocumento value for this DocumentoType.
     * 
     * @param importoPagatoDocumento
     */
    public void setImportoPagatoDocumento(java.lang.Double importoPagatoDocumento) {
        this.importoPagatoDocumento = importoPagatoDocumento;
    }


    /**
     * Gets the importoResiduoDocumento value for this DocumentoType.
     * 
     * @return importoResiduoDocumento
     */
    public java.lang.Double getImportoResiduoDocumento() {
        return importoResiduoDocumento;
    }


    /**
     * Sets the importoResiduoDocumento value for this DocumentoType.
     * 
     * @param importoResiduoDocumento
     */
    public void setImportoResiduoDocumento(java.lang.Double importoResiduoDocumento) {
        this.importoResiduoDocumento = importoResiduoDocumento;
    }


    /**
     * Gets the importoInizialeTributi value for this DocumentoType.
     * 
     * @return importoInizialeTributi
     */
    public java.lang.Double getImportoInizialeTributi() {
        return importoInizialeTributi;
    }


    /**
     * Sets the importoInizialeTributi value for this DocumentoType.
     * 
     * @param importoInizialeTributi
     */
    public void setImportoInizialeTributi(java.lang.Double importoInizialeTributi) {
        this.importoInizialeTributi = importoInizialeTributi;
    }


    /**
     * Gets the importoPagatoTributi value for this DocumentoType.
     * 
     * @return importoPagatoTributi
     */
    public java.lang.Double getImportoPagatoTributi() {
        return importoPagatoTributi;
    }


    /**
     * Sets the importoPagatoTributi value for this DocumentoType.
     * 
     * @param importoPagatoTributi
     */
    public void setImportoPagatoTributi(java.lang.Double importoPagatoTributi) {
        this.importoPagatoTributi = importoPagatoTributi;
    }


    /**
     * Gets the importoResiduoTributi value for this DocumentoType.
     * 
     * @return importoResiduoTributi
     */
    public java.lang.Double getImportoResiduoTributi() {
        return importoResiduoTributi;
    }


    /**
     * Sets the importoResiduoTributi value for this DocumentoType.
     * 
     * @param importoResiduoTributi
     */
    public void setImportoResiduoTributi(java.lang.Double importoResiduoTributi) {
        this.importoResiduoTributi = importoResiduoTributi;
    }


    /**
     * Gets the importoTotaleNotifica value for this DocumentoType.
     * 
     * @return importoTotaleNotifica
     */
    public java.lang.Double getImportoTotaleNotifica() {
        return importoTotaleNotifica;
    }


    /**
     * Sets the importoTotaleNotifica value for this DocumentoType.
     * 
     * @param importoTotaleNotifica
     */
    public void setImportoTotaleNotifica(java.lang.Double importoTotaleNotifica) {
        this.importoTotaleNotifica = importoTotaleNotifica;
    }


    /**
     * Gets the importoPagatoNotifica value for this DocumentoType.
     * 
     * @return importoPagatoNotifica
     */
    public java.lang.Double getImportoPagatoNotifica() {
        return importoPagatoNotifica;
    }


    /**
     * Sets the importoPagatoNotifica value for this DocumentoType.
     * 
     * @param importoPagatoNotifica
     */
    public void setImportoPagatoNotifica(java.lang.Double importoPagatoNotifica) {
        this.importoPagatoNotifica = importoPagatoNotifica;
    }


    /**
     * Gets the importoResiduoNotifica value for this DocumentoType.
     * 
     * @return importoResiduoNotifica
     */
    public java.lang.Double getImportoResiduoNotifica() {
        return importoResiduoNotifica;
    }


    /**
     * Sets the importoResiduoNotifica value for this DocumentoType.
     * 
     * @param importoResiduoNotifica
     */
    public void setImportoResiduoNotifica(java.lang.Double importoResiduoNotifica) {
        this.importoResiduoNotifica = importoResiduoNotifica;
    }


    /**
     * Gets the importoTotaleCompensi value for this DocumentoType.
     * 
     * @return importoTotaleCompensi
     */
    public java.lang.Double getImportoTotaleCompensi() {
        return importoTotaleCompensi;
    }


    /**
     * Sets the importoTotaleCompensi value for this DocumentoType.
     * 
     * @param importoTotaleCompensi
     */
    public void setImportoTotaleCompensi(java.lang.Double importoTotaleCompensi) {
        this.importoTotaleCompensi = importoTotaleCompensi;
    }


    /**
     * Gets the importoPagatoCompensi value for this DocumentoType.
     * 
     * @return importoPagatoCompensi
     */
    public java.lang.Double getImportoPagatoCompensi() {
        return importoPagatoCompensi;
    }


    /**
     * Sets the importoPagatoCompensi value for this DocumentoType.
     * 
     * @param importoPagatoCompensi
     */
    public void setImportoPagatoCompensi(java.lang.Double importoPagatoCompensi) {
        this.importoPagatoCompensi = importoPagatoCompensi;
    }


    /**
     * Gets the importoResiduoCompensi value for this DocumentoType.
     * 
     * @return importoResiduoCompensi
     */
    public java.lang.Double getImportoResiduoCompensi() {
        return importoResiduoCompensi;
    }


    /**
     * Sets the importoResiduoCompensi value for this DocumentoType.
     * 
     * @param importoResiduoCompensi
     */
    public void setImportoResiduoCompensi(java.lang.Double importoResiduoCompensi) {
        this.importoResiduoCompensi = importoResiduoCompensi;
    }


    /**
     * Gets the importoInteressiMora value for this DocumentoType.
     * 
     * @return importoInteressiMora
     */
    public java.lang.Double getImportoInteressiMora() {
        return importoInteressiMora;
    }


    /**
     * Sets the importoInteressiMora value for this DocumentoType.
     * 
     * @param importoInteressiMora
     */
    public void setImportoInteressiMora(java.lang.Double importoInteressiMora) {
        this.importoInteressiMora = importoInteressiMora;
    }


    /**
     * Gets the importoAltreSpese value for this DocumentoType.
     * 
     * @return importoAltreSpese
     */
    public java.lang.Double getImportoAltreSpese() {
        return importoAltreSpese;
    }


    /**
     * Sets the importoAltreSpese value for this DocumentoType.
     * 
     * @param importoAltreSpese
     */
    public void setImportoAltreSpese(java.lang.Double importoAltreSpese) {
        this.importoAltreSpese = importoAltreSpese;
    }


    /**
     * Gets the importoSpeseProcedure value for this DocumentoType.
     * 
     * @return importoSpeseProcedure
     */
    public java.lang.Double getImportoSpeseProcedure() {
        return importoSpeseProcedure;
    }


    /**
     * Sets the importoSpeseProcedure value for this DocumentoType.
     * 
     * @param importoSpeseProcedure
     */
    public void setImportoSpeseProcedure(java.lang.Double importoSpeseProcedure) {
        this.importoSpeseProcedure = importoSpeseProcedure;
    }


    /**
     * Gets the flagRateazione value for this DocumentoType.
     * 
     * @return flagRateazione
     */
    public java.lang.Integer getFlagRateazione() {
        return flagRateazione;
    }


    /**
     * Sets the flagRateazione value for this DocumentoType.
     * 
     * @param flagRateazione
     */
    public void setFlagRateazione(java.lang.Integer flagRateazione) {
        this.flagRateazione = flagRateazione;
    }


    /**
     * Gets the flagSgravio value for this DocumentoType.
     * 
     * @return flagSgravio
     */
    public java.lang.Integer getFlagSgravio() {
        return flagSgravio;
    }


    /**
     * Sets the flagSgravio value for this DocumentoType.
     * 
     * @param flagSgravio
     */
    public void setFlagSgravio(java.lang.Integer flagSgravio) {
        this.flagSgravio = flagSgravio;
    }


    /**
     * Gets the flagSospensione value for this DocumentoType.
     * 
     * @return flagSospensione
     */
    public java.lang.Integer getFlagSospensione() {
        return flagSospensione;
    }


    /**
     * Sets the flagSospensione value for this DocumentoType.
     * 
     * @param flagSospensione
     */
    public void setFlagSospensione(java.lang.Integer flagSospensione) {
        this.flagSospensione = flagSospensione;
    }


    /**
     * Gets the flagProcedura value for this DocumentoType.
     * 
     * @return flagProcedura
     */
    public java.lang.Integer getFlagProcedura() {
        return flagProcedura;
    }


    /**
     * Sets the flagProcedura value for this DocumentoType.
     * 
     * @param flagProcedura
     */
    public void setFlagProcedura(java.lang.Integer flagProcedura) {
        this.flagProcedura = flagProcedura;
    }


    /**
     * Gets the codiceEsitoDettaglio value for this DocumentoType.
     * 
     * @return codiceEsitoDettaglio
     */
    public java.lang.String getCodiceEsitoDettaglio() {
        return codiceEsitoDettaglio;
    }


    /**
     * Sets the codiceEsitoDettaglio value for this DocumentoType.
     * 
     * @param codiceEsitoDettaglio
     */
    public void setCodiceEsitoDettaglio(java.lang.String codiceEsitoDettaglio) {
        this.codiceEsitoDettaglio = codiceEsitoDettaglio;
    }


    /**
     * Gets the importoTotaleSgravato value for this DocumentoType.
     * 
     * @return importoTotaleSgravato
     */
    public java.lang.Double getImportoTotaleSgravato() {
        return importoTotaleSgravato;
    }


    /**
     * Sets the importoTotaleSgravato value for this DocumentoType.
     * 
     * @param importoTotaleSgravato
     */
    public void setImportoTotaleSgravato(java.lang.Double importoTotaleSgravato) {
        this.importoTotaleSgravato = importoTotaleSgravato;
    }


    /**
     * Gets the importoTotaleSospeso value for this DocumentoType.
     * 
     * @return importoTotaleSospeso
     */
    public java.lang.Double getImportoTotaleSospeso() {
        return importoTotaleSospeso;
    }


    /**
     * Sets the importoTotaleSospeso value for this DocumentoType.
     * 
     * @param importoTotaleSospeso
     */
    public void setImportoTotaleSospeso(java.lang.Double importoTotaleSospeso) {
        this.importoTotaleSospeso = importoTotaleSospeso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoType)) return false;
        DocumentoType other = (DocumentoType) obj;
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
            ((this.ente==null && other.getEnte()==null) || 
             (this.ente!=null &&
              java.util.Arrays.equals(this.ente, other.getEnte()))) &&
            ((this.annoEmissione==null && other.getAnnoEmissione()==null) || 
             (this.annoEmissione!=null &&
              this.annoEmissione.equals(other.getAnnoEmissione()))) &&
            ((this.statoDocumento==null && other.getStatoDocumento()==null) || 
             (this.statoDocumento!=null &&
              this.statoDocumento.equals(other.getStatoDocumento()))) &&
            ((this.dataNotifica==null && other.getDataNotifica()==null) || 
             (this.dataNotifica!=null &&
              this.dataNotifica.equals(other.getDataNotifica()))) &&
            ((this.numeroRav==null && other.getNumeroRav()==null) || 
             (this.numeroRav!=null &&
              this.numeroRav.equals(other.getNumeroRav()))) &&
            ((this.sommarioTributi==null && other.getSommarioTributi()==null) || 
             (this.sommarioTributi!=null &&
              this.sommarioTributi.equals(other.getSommarioTributi()))) &&
            ((this.importoTotaleDocumento==null && other.getImportoTotaleDocumento()==null) || 
             (this.importoTotaleDocumento!=null &&
              this.importoTotaleDocumento.equals(other.getImportoTotaleDocumento()))) &&
            ((this.importoPagatoDocumento==null && other.getImportoPagatoDocumento()==null) || 
             (this.importoPagatoDocumento!=null &&
              this.importoPagatoDocumento.equals(other.getImportoPagatoDocumento()))) &&
            ((this.importoResiduoDocumento==null && other.getImportoResiduoDocumento()==null) || 
             (this.importoResiduoDocumento!=null &&
              this.importoResiduoDocumento.equals(other.getImportoResiduoDocumento()))) &&
            ((this.importoInizialeTributi==null && other.getImportoInizialeTributi()==null) || 
             (this.importoInizialeTributi!=null &&
              this.importoInizialeTributi.equals(other.getImportoInizialeTributi()))) &&
            ((this.importoPagatoTributi==null && other.getImportoPagatoTributi()==null) || 
             (this.importoPagatoTributi!=null &&
              this.importoPagatoTributi.equals(other.getImportoPagatoTributi()))) &&
            ((this.importoResiduoTributi==null && other.getImportoResiduoTributi()==null) || 
             (this.importoResiduoTributi!=null &&
              this.importoResiduoTributi.equals(other.getImportoResiduoTributi()))) &&
            ((this.importoTotaleNotifica==null && other.getImportoTotaleNotifica()==null) || 
             (this.importoTotaleNotifica!=null &&
              this.importoTotaleNotifica.equals(other.getImportoTotaleNotifica()))) &&
            ((this.importoPagatoNotifica==null && other.getImportoPagatoNotifica()==null) || 
             (this.importoPagatoNotifica!=null &&
              this.importoPagatoNotifica.equals(other.getImportoPagatoNotifica()))) &&
            ((this.importoResiduoNotifica==null && other.getImportoResiduoNotifica()==null) || 
             (this.importoResiduoNotifica!=null &&
              this.importoResiduoNotifica.equals(other.getImportoResiduoNotifica()))) &&
            ((this.importoTotaleCompensi==null && other.getImportoTotaleCompensi()==null) || 
             (this.importoTotaleCompensi!=null &&
              this.importoTotaleCompensi.equals(other.getImportoTotaleCompensi()))) &&
            ((this.importoPagatoCompensi==null && other.getImportoPagatoCompensi()==null) || 
             (this.importoPagatoCompensi!=null &&
              this.importoPagatoCompensi.equals(other.getImportoPagatoCompensi()))) &&
            ((this.importoResiduoCompensi==null && other.getImportoResiduoCompensi()==null) || 
             (this.importoResiduoCompensi!=null &&
              this.importoResiduoCompensi.equals(other.getImportoResiduoCompensi()))) &&
            ((this.importoInteressiMora==null && other.getImportoInteressiMora()==null) || 
             (this.importoInteressiMora!=null &&
              this.importoInteressiMora.equals(other.getImportoInteressiMora()))) &&
            ((this.importoAltreSpese==null && other.getImportoAltreSpese()==null) || 
             (this.importoAltreSpese!=null &&
              this.importoAltreSpese.equals(other.getImportoAltreSpese()))) &&
            ((this.importoSpeseProcedure==null && other.getImportoSpeseProcedure()==null) || 
             (this.importoSpeseProcedure!=null &&
              this.importoSpeseProcedure.equals(other.getImportoSpeseProcedure()))) &&
            ((this.flagRateazione==null && other.getFlagRateazione()==null) || 
             (this.flagRateazione!=null &&
              this.flagRateazione.equals(other.getFlagRateazione()))) &&
            ((this.flagSgravio==null && other.getFlagSgravio()==null) || 
             (this.flagSgravio!=null &&
              this.flagSgravio.equals(other.getFlagSgravio()))) &&
            ((this.flagSospensione==null && other.getFlagSospensione()==null) || 
             (this.flagSospensione!=null &&
              this.flagSospensione.equals(other.getFlagSospensione()))) &&
            ((this.flagProcedura==null && other.getFlagProcedura()==null) || 
             (this.flagProcedura!=null &&
              this.flagProcedura.equals(other.getFlagProcedura()))) &&
            ((this.codiceEsitoDettaglio==null && other.getCodiceEsitoDettaglio()==null) || 
             (this.codiceEsitoDettaglio!=null &&
              this.codiceEsitoDettaglio.equals(other.getCodiceEsitoDettaglio()))) &&
            ((this.importoTotaleSgravato==null && other.getImportoTotaleSgravato()==null) || 
             (this.importoTotaleSgravato!=null &&
              this.importoTotaleSgravato.equals(other.getImportoTotaleSgravato()))) &&
            ((this.importoTotaleSospeso==null && other.getImportoTotaleSospeso()==null) || 
             (this.importoTotaleSospeso!=null &&
              this.importoTotaleSospeso.equals(other.getImportoTotaleSospeso())));
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
        if (getEnte() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEnte());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEnte(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAnnoEmissione() != null) {
            _hashCode += getAnnoEmissione().hashCode();
        }
        if (getStatoDocumento() != null) {
            _hashCode += getStatoDocumento().hashCode();
        }
        if (getDataNotifica() != null) {
            _hashCode += getDataNotifica().hashCode();
        }
        if (getNumeroRav() != null) {
            _hashCode += getNumeroRav().hashCode();
        }
        if (getSommarioTributi() != null) {
            _hashCode += getSommarioTributi().hashCode();
        }
        if (getImportoTotaleDocumento() != null) {
            _hashCode += getImportoTotaleDocumento().hashCode();
        }
        if (getImportoPagatoDocumento() != null) {
            _hashCode += getImportoPagatoDocumento().hashCode();
        }
        if (getImportoResiduoDocumento() != null) {
            _hashCode += getImportoResiduoDocumento().hashCode();
        }
        if (getImportoInizialeTributi() != null) {
            _hashCode += getImportoInizialeTributi().hashCode();
        }
        if (getImportoPagatoTributi() != null) {
            _hashCode += getImportoPagatoTributi().hashCode();
        }
        if (getImportoResiduoTributi() != null) {
            _hashCode += getImportoResiduoTributi().hashCode();
        }
        if (getImportoTotaleNotifica() != null) {
            _hashCode += getImportoTotaleNotifica().hashCode();
        }
        if (getImportoPagatoNotifica() != null) {
            _hashCode += getImportoPagatoNotifica().hashCode();
        }
        if (getImportoResiduoNotifica() != null) {
            _hashCode += getImportoResiduoNotifica().hashCode();
        }
        if (getImportoTotaleCompensi() != null) {
            _hashCode += getImportoTotaleCompensi().hashCode();
        }
        if (getImportoPagatoCompensi() != null) {
            _hashCode += getImportoPagatoCompensi().hashCode();
        }
        if (getImportoResiduoCompensi() != null) {
            _hashCode += getImportoResiduoCompensi().hashCode();
        }
        if (getImportoInteressiMora() != null) {
            _hashCode += getImportoInteressiMora().hashCode();
        }
        if (getImportoAltreSpese() != null) {
            _hashCode += getImportoAltreSpese().hashCode();
        }
        if (getImportoSpeseProcedure() != null) {
            _hashCode += getImportoSpeseProcedure().hashCode();
        }
        if (getFlagRateazione() != null) {
            _hashCode += getFlagRateazione().hashCode();
        }
        if (getFlagSgravio() != null) {
            _hashCode += getFlagSgravio().hashCode();
        }
        if (getFlagSospensione() != null) {
            _hashCode += getFlagSospensione().hashCode();
        }
        if (getFlagProcedura() != null) {
            _hashCode += getFlagProcedura().hashCode();
        }
        if (getCodiceEsitoDettaglio() != null) {
            _hashCode += getCodiceEsitoDettaglio().hashCode();
        }
        if (getImportoTotaleSgravato() != null) {
            _hashCode += getImportoTotaleSgravato().hashCode();
        }
        if (getImportoTotaleSospeso() != null) {
            _hashCode += getImportoTotaleSospeso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "DocumentoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "IdDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "IdentificativoDocumentoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "Ente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "EnteType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annoEmissione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "AnnoEmissione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "StatoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "DataNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroRav");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "NumeroRav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sommarioTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "SommarioTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoTotaleDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoPagatoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoResiduoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoInizialeTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoInizialeTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoPagatoTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoResiduoTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoTotaleNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoPagatoNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoResiduoNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleCompensi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoTotaleCompensi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoCompensi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoPagatoCompensi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoCompensi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoResiduoCompensi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoInteressiMora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoInteressiMora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoAltreSpese");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoAltreSpese"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoSpeseProcedure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoSpeseProcedure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagRateazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "FlagRateazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagSgravio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "FlagSgravio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagSospensione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "FlagSospensione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "FlagProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceEsitoDettaglio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "CodiceEsitoDettaglio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleSgravato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoTotaleSgravato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleSospeso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.estrattoconto.xsd.servizibe.equitaliaspa.it", "ImportoTotaleSospeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
