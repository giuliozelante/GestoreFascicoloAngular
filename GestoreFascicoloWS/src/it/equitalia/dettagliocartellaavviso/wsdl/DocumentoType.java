/**
 * DocumentoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class DocumentoType  implements java.io.Serializable {
    private it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType idDocumento;

    private it.equitalia.dettagliocartellaavviso.wsdl.EnteType[] ente;

    private java.lang.String annoEmissione;

    private java.lang.String statoDocumento;

    private java.util.Date dataNotifica;

    private java.lang.String numeroRav;

    /* Fornisce un riepilogo sul numero di tributi
     * 								associati alla cartella. */
    private java.lang.Integer sommarioTributi;

    private java.math.BigDecimal importoTotaleDocumento;

    private java.math.BigDecimal importoPagatoDocumento;

    private java.math.BigDecimal importoResiduoDocumento;

    private java.math.BigDecimal importoInizialeTributi;

    private java.math.BigDecimal importoPagatoTributi;

    private java.math.BigDecimal importoResiduoTributi;

    private java.math.BigDecimal importoTotaleNotifica;

    private java.math.BigDecimal importoPagatoNotifica;

    private java.math.BigDecimal importoResiduoNotifica;

    private java.math.BigDecimal importoTotaleCompensi;

    private java.math.BigDecimal importoPagatoCompensi;

    private java.math.BigDecimal importoResiduoCompensi;

    private java.math.BigDecimal importoInteressiMora;

    private java.math.BigDecimal importoAltreSpese;

    private java.math.BigDecimal importoSpeseProcedure;

    private java.lang.Integer flagRateazione;

    private java.lang.Integer flagSgravio;

    private java.lang.Integer flagSospensione;

    private java.lang.Integer flagProcedura;

    private java.lang.String codiceEsitoDettaglio;

    private java.math.BigDecimal importoTotaleSgravato;

    private java.math.BigDecimal importoTotaleSospeso;

    public DocumentoType() {
    }

    public DocumentoType(
           it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType idDocumento,
           it.equitalia.dettagliocartellaavviso.wsdl.EnteType[] ente,
           java.lang.String annoEmissione,
           java.lang.String statoDocumento,
           java.util.Date dataNotifica,
           java.lang.String numeroRav,
           java.lang.Integer sommarioTributi,
           java.math.BigDecimal importoTotaleDocumento,
           java.math.BigDecimal importoPagatoDocumento,
           java.math.BigDecimal importoResiduoDocumento,
           java.math.BigDecimal importoInizialeTributi,
           java.math.BigDecimal importoPagatoTributi,
           java.math.BigDecimal importoResiduoTributi,
           java.math.BigDecimal importoTotaleNotifica,
           java.math.BigDecimal importoPagatoNotifica,
           java.math.BigDecimal importoResiduoNotifica,
           java.math.BigDecimal importoTotaleCompensi,
           java.math.BigDecimal importoPagatoCompensi,
           java.math.BigDecimal importoResiduoCompensi,
           java.math.BigDecimal importoInteressiMora,
           java.math.BigDecimal importoAltreSpese,
           java.math.BigDecimal importoSpeseProcedure,
           java.lang.Integer flagRateazione,
           java.lang.Integer flagSgravio,
           java.lang.Integer flagSospensione,
           java.lang.Integer flagProcedura,
           java.lang.String codiceEsitoDettaglio,
           java.math.BigDecimal importoTotaleSgravato,
           java.math.BigDecimal importoTotaleSospeso) {
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
    public it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType getIdDocumento() {
        return idDocumento;
    }


    /**
     * Sets the idDocumento value for this DocumentoType.
     * 
     * @param idDocumento
     */
    public void setIdDocumento(it.equitalia.dettagliocartellaavviso.wsdl.IdentificativoDocumentoType idDocumento) {
        this.idDocumento = idDocumento;
    }


    /**
     * Gets the ente value for this DocumentoType.
     * 
     * @return ente
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.EnteType[] getEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this DocumentoType.
     * 
     * @param ente
     */
    public void setEnte(it.equitalia.dettagliocartellaavviso.wsdl.EnteType[] ente) {
        this.ente = ente;
    }

    public it.equitalia.dettagliocartellaavviso.wsdl.EnteType getEnte(int i) {
        return this.ente[i];
    }

    public void setEnte(int i, it.equitalia.dettagliocartellaavviso.wsdl.EnteType _value) {
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
     * 								associati alla cartella.
     */
    public java.lang.Integer getSommarioTributi() {
        return sommarioTributi;
    }


    /**
     * Sets the sommarioTributi value for this DocumentoType.
     * 
     * @param sommarioTributi   * Fornisce un riepilogo sul numero di tributi
     * 								associati alla cartella.
     */
    public void setSommarioTributi(java.lang.Integer sommarioTributi) {
        this.sommarioTributi = sommarioTributi;
    }


    /**
     * Gets the importoTotaleDocumento value for this DocumentoType.
     * 
     * @return importoTotaleDocumento
     */
    public java.math.BigDecimal getImportoTotaleDocumento() {
        return importoTotaleDocumento;
    }


    /**
     * Sets the importoTotaleDocumento value for this DocumentoType.
     * 
     * @param importoTotaleDocumento
     */
    public void setImportoTotaleDocumento(java.math.BigDecimal importoTotaleDocumento) {
        this.importoTotaleDocumento = importoTotaleDocumento;
    }


    /**
     * Gets the importoPagatoDocumento value for this DocumentoType.
     * 
     * @return importoPagatoDocumento
     */
    public java.math.BigDecimal getImportoPagatoDocumento() {
        return importoPagatoDocumento;
    }


    /**
     * Sets the importoPagatoDocumento value for this DocumentoType.
     * 
     * @param importoPagatoDocumento
     */
    public void setImportoPagatoDocumento(java.math.BigDecimal importoPagatoDocumento) {
        this.importoPagatoDocumento = importoPagatoDocumento;
    }


    /**
     * Gets the importoResiduoDocumento value for this DocumentoType.
     * 
     * @return importoResiduoDocumento
     */
    public java.math.BigDecimal getImportoResiduoDocumento() {
        return importoResiduoDocumento;
    }


    /**
     * Sets the importoResiduoDocumento value for this DocumentoType.
     * 
     * @param importoResiduoDocumento
     */
    public void setImportoResiduoDocumento(java.math.BigDecimal importoResiduoDocumento) {
        this.importoResiduoDocumento = importoResiduoDocumento;
    }


    /**
     * Gets the importoInizialeTributi value for this DocumentoType.
     * 
     * @return importoInizialeTributi
     */
    public java.math.BigDecimal getImportoInizialeTributi() {
        return importoInizialeTributi;
    }


    /**
     * Sets the importoInizialeTributi value for this DocumentoType.
     * 
     * @param importoInizialeTributi
     */
    public void setImportoInizialeTributi(java.math.BigDecimal importoInizialeTributi) {
        this.importoInizialeTributi = importoInizialeTributi;
    }


    /**
     * Gets the importoPagatoTributi value for this DocumentoType.
     * 
     * @return importoPagatoTributi
     */
    public java.math.BigDecimal getImportoPagatoTributi() {
        return importoPagatoTributi;
    }


    /**
     * Sets the importoPagatoTributi value for this DocumentoType.
     * 
     * @param importoPagatoTributi
     */
    public void setImportoPagatoTributi(java.math.BigDecimal importoPagatoTributi) {
        this.importoPagatoTributi = importoPagatoTributi;
    }


    /**
     * Gets the importoResiduoTributi value for this DocumentoType.
     * 
     * @return importoResiduoTributi
     */
    public java.math.BigDecimal getImportoResiduoTributi() {
        return importoResiduoTributi;
    }


    /**
     * Sets the importoResiduoTributi value for this DocumentoType.
     * 
     * @param importoResiduoTributi
     */
    public void setImportoResiduoTributi(java.math.BigDecimal importoResiduoTributi) {
        this.importoResiduoTributi = importoResiduoTributi;
    }


    /**
     * Gets the importoTotaleNotifica value for this DocumentoType.
     * 
     * @return importoTotaleNotifica
     */
    public java.math.BigDecimal getImportoTotaleNotifica() {
        return importoTotaleNotifica;
    }


    /**
     * Sets the importoTotaleNotifica value for this DocumentoType.
     * 
     * @param importoTotaleNotifica
     */
    public void setImportoTotaleNotifica(java.math.BigDecimal importoTotaleNotifica) {
        this.importoTotaleNotifica = importoTotaleNotifica;
    }


    /**
     * Gets the importoPagatoNotifica value for this DocumentoType.
     * 
     * @return importoPagatoNotifica
     */
    public java.math.BigDecimal getImportoPagatoNotifica() {
        return importoPagatoNotifica;
    }


    /**
     * Sets the importoPagatoNotifica value for this DocumentoType.
     * 
     * @param importoPagatoNotifica
     */
    public void setImportoPagatoNotifica(java.math.BigDecimal importoPagatoNotifica) {
        this.importoPagatoNotifica = importoPagatoNotifica;
    }


    /**
     * Gets the importoResiduoNotifica value for this DocumentoType.
     * 
     * @return importoResiduoNotifica
     */
    public java.math.BigDecimal getImportoResiduoNotifica() {
        return importoResiduoNotifica;
    }


    /**
     * Sets the importoResiduoNotifica value for this DocumentoType.
     * 
     * @param importoResiduoNotifica
     */
    public void setImportoResiduoNotifica(java.math.BigDecimal importoResiduoNotifica) {
        this.importoResiduoNotifica = importoResiduoNotifica;
    }


    /**
     * Gets the importoTotaleCompensi value for this DocumentoType.
     * 
     * @return importoTotaleCompensi
     */
    public java.math.BigDecimal getImportoTotaleCompensi() {
        return importoTotaleCompensi;
    }


    /**
     * Sets the importoTotaleCompensi value for this DocumentoType.
     * 
     * @param importoTotaleCompensi
     */
    public void setImportoTotaleCompensi(java.math.BigDecimal importoTotaleCompensi) {
        this.importoTotaleCompensi = importoTotaleCompensi;
    }


    /**
     * Gets the importoPagatoCompensi value for this DocumentoType.
     * 
     * @return importoPagatoCompensi
     */
    public java.math.BigDecimal getImportoPagatoCompensi() {
        return importoPagatoCompensi;
    }


    /**
     * Sets the importoPagatoCompensi value for this DocumentoType.
     * 
     * @param importoPagatoCompensi
     */
    public void setImportoPagatoCompensi(java.math.BigDecimal importoPagatoCompensi) {
        this.importoPagatoCompensi = importoPagatoCompensi;
    }


    /**
     * Gets the importoResiduoCompensi value for this DocumentoType.
     * 
     * @return importoResiduoCompensi
     */
    public java.math.BigDecimal getImportoResiduoCompensi() {
        return importoResiduoCompensi;
    }


    /**
     * Sets the importoResiduoCompensi value for this DocumentoType.
     * 
     * @param importoResiduoCompensi
     */
    public void setImportoResiduoCompensi(java.math.BigDecimal importoResiduoCompensi) {
        this.importoResiduoCompensi = importoResiduoCompensi;
    }


    /**
     * Gets the importoInteressiMora value for this DocumentoType.
     * 
     * @return importoInteressiMora
     */
    public java.math.BigDecimal getImportoInteressiMora() {
        return importoInteressiMora;
    }


    /**
     * Sets the importoInteressiMora value for this DocumentoType.
     * 
     * @param importoInteressiMora
     */
    public void setImportoInteressiMora(java.math.BigDecimal importoInteressiMora) {
        this.importoInteressiMora = importoInteressiMora;
    }


    /**
     * Gets the importoAltreSpese value for this DocumentoType.
     * 
     * @return importoAltreSpese
     */
    public java.math.BigDecimal getImportoAltreSpese() {
        return importoAltreSpese;
    }


    /**
     * Sets the importoAltreSpese value for this DocumentoType.
     * 
     * @param importoAltreSpese
     */
    public void setImportoAltreSpese(java.math.BigDecimal importoAltreSpese) {
        this.importoAltreSpese = importoAltreSpese;
    }


    /**
     * Gets the importoSpeseProcedure value for this DocumentoType.
     * 
     * @return importoSpeseProcedure
     */
    public java.math.BigDecimal getImportoSpeseProcedure() {
        return importoSpeseProcedure;
    }


    /**
     * Sets the importoSpeseProcedure value for this DocumentoType.
     * 
     * @param importoSpeseProcedure
     */
    public void setImportoSpeseProcedure(java.math.BigDecimal importoSpeseProcedure) {
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
    public java.math.BigDecimal getImportoTotaleSgravato() {
        return importoTotaleSgravato;
    }


    /**
     * Sets the importoTotaleSgravato value for this DocumentoType.
     * 
     * @param importoTotaleSgravato
     */
    public void setImportoTotaleSgravato(java.math.BigDecimal importoTotaleSgravato) {
        this.importoTotaleSgravato = importoTotaleSgravato;
    }


    /**
     * Gets the importoTotaleSospeso value for this DocumentoType.
     * 
     * @return importoTotaleSospeso
     */
    public java.math.BigDecimal getImportoTotaleSospeso() {
        return importoTotaleSospeso;
    }


    /**
     * Sets the importoTotaleSospeso value for this DocumentoType.
     * 
     * @param importoTotaleSospeso
     */
    public void setImportoTotaleSospeso(java.math.BigDecimal importoTotaleSospeso) {
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DocumentoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "IdDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "IdentificativoDocumentoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Ente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "EnteType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annoEmissione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "AnnoEmissione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "StatoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DataNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroRav");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "NumeroRav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sommarioTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "SommarioTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoTotaleDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoPagatoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoResiduoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoInizialeTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoInizialeTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoPagatoTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoTributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoResiduoTributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoTotaleNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoPagatoNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoNotifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoResiduoNotifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleCompensi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoTotaleCompensi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoPagatoCompensi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoPagatoCompensi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoResiduoCompensi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoResiduoCompensi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoInteressiMora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoInteressiMora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoAltreSpese");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoAltreSpese"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoSpeseProcedure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoSpeseProcedure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagRateazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "FlagRateazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagSgravio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "FlagSgravio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagSospensione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "FlagSospensione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "FlagProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceEsitoDettaglio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "CodiceEsitoDettaglio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleSgravato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoTotaleSgravato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoTotaleSospeso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoTotaleSospeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
