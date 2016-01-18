/**
 * Fascicolo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class Fascicolo  implements java.io.Serializable {
    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private java.lang.String dataApertura;

    private java.lang.String dataChiusura;

    private java.lang.Integer statoFascicoloId;

    private java.lang.String statoFascicoloDescr;

    private it.equitalia.gestorefascicolows.dati.Anagrafica anagrafica;

    private it.equitalia.gestorefascicolows.dati.EntityItem[] cartelle;

    private it.equitalia.gestorefascicolows.dati.EntityItem[] documenti;

    private boolean chiuso;

    private java.util.Date dataUltimoAggiornamento;

    private java.util.Date dataUltimoAggiornamentoDocumentiEsattoriali;

    public Fascicolo() {
    }

    public Fascicolo(
           java.lang.String fascicoloId,
           java.lang.String callerId,
           java.lang.String dataApertura,
           java.lang.String dataChiusura,
           java.lang.Integer statoFascicoloId,
           java.lang.String statoFascicoloDescr,
           it.equitalia.gestorefascicolows.dati.Anagrafica anagrafica,
           it.equitalia.gestorefascicolows.dati.EntityItem[] cartelle,
           it.equitalia.gestorefascicolows.dati.EntityItem[] documenti,
           boolean chiuso,
           java.util.Date dataUltimoAggiornamento,
           java.util.Date dataUltimoAggiornamentoDocumentiEsattoriali) {
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.dataApertura = dataApertura;
           this.dataChiusura = dataChiusura;
           this.statoFascicoloId = statoFascicoloId;
           this.statoFascicoloDescr = statoFascicoloDescr;
           this.anagrafica = anagrafica;
           this.cartelle = cartelle;
           this.documenti = documenti;
           this.chiuso = chiuso;
           this.dataUltimoAggiornamento = dataUltimoAggiornamento;
           this.dataUltimoAggiornamentoDocumentiEsattoriali = dataUltimoAggiornamentoDocumentiEsattoriali;
    }


    /**
     * Gets the fascicoloId value for this Fascicolo.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this Fascicolo.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this Fascicolo.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this Fascicolo.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the dataApertura value for this Fascicolo.
     * 
     * @return dataApertura
     */
    public java.lang.String getDataApertura() {
        return dataApertura;
    }


    /**
     * Sets the dataApertura value for this Fascicolo.
     * 
     * @param dataApertura
     */
    public void setDataApertura(java.lang.String dataApertura) {
        this.dataApertura = dataApertura;
    }


    /**
     * Gets the dataChiusura value for this Fascicolo.
     * 
     * @return dataChiusura
     */
    public java.lang.String getDataChiusura() {
        return dataChiusura;
    }


    /**
     * Sets the dataChiusura value for this Fascicolo.
     * 
     * @param dataChiusura
     */
    public void setDataChiusura(java.lang.String dataChiusura) {
        this.dataChiusura = dataChiusura;
    }


    /**
     * Gets the statoFascicoloId value for this Fascicolo.
     * 
     * @return statoFascicoloId
     */
    public java.lang.Integer getStatoFascicoloId() {
        return statoFascicoloId;
    }


    /**
     * Sets the statoFascicoloId value for this Fascicolo.
     * 
     * @param statoFascicoloId
     */
    public void setStatoFascicoloId(java.lang.Integer statoFascicoloId) {
        this.statoFascicoloId = statoFascicoloId;
    }


    /**
     * Gets the statoFascicoloDescr value for this Fascicolo.
     * 
     * @return statoFascicoloDescr
     */
    public java.lang.String getStatoFascicoloDescr() {
        return statoFascicoloDescr;
    }


    /**
     * Sets the statoFascicoloDescr value for this Fascicolo.
     * 
     * @param statoFascicoloDescr
     */
    public void setStatoFascicoloDescr(java.lang.String statoFascicoloDescr) {
        this.statoFascicoloDescr = statoFascicoloDescr;
    }


    /**
     * Gets the anagrafica value for this Fascicolo.
     * 
     * @return anagrafica
     */
    public it.equitalia.gestorefascicolows.dati.Anagrafica getAnagrafica() {
        return anagrafica;
    }


    /**
     * Sets the anagrafica value for this Fascicolo.
     * 
     * @param anagrafica
     */
    public void setAnagrafica(it.equitalia.gestorefascicolows.dati.Anagrafica anagrafica) {
        this.anagrafica = anagrafica;
    }


    /**
     * Gets the cartelle value for this Fascicolo.
     * 
     * @return cartelle
     */
    public it.equitalia.gestorefascicolows.dati.EntityItem[] getCartelle() {
        return cartelle;
    }


    /**
     * Sets the cartelle value for this Fascicolo.
     * 
     * @param cartelle
     */
    public void setCartelle(it.equitalia.gestorefascicolows.dati.EntityItem[] cartelle) {
        this.cartelle = cartelle;
    }

    public it.equitalia.gestorefascicolows.dati.EntityItem getCartelle(int i) {
        return this.cartelle[i];
    }

    public void setCartelle(int i, it.equitalia.gestorefascicolows.dati.EntityItem _value) {
        this.cartelle[i] = _value;
    }


    /**
     * Gets the documenti value for this Fascicolo.
     * 
     * @return documenti
     */
    public it.equitalia.gestorefascicolows.dati.EntityItem[] getDocumenti() {
        return documenti;
    }


    /**
     * Sets the documenti value for this Fascicolo.
     * 
     * @param documenti
     */
    public void setDocumenti(it.equitalia.gestorefascicolows.dati.EntityItem[] documenti) {
        this.documenti = documenti;
    }

    public it.equitalia.gestorefascicolows.dati.EntityItem getDocumenti(int i) {
        return this.documenti[i];
    }

    public void setDocumenti(int i, it.equitalia.gestorefascicolows.dati.EntityItem _value) {
        this.documenti[i] = _value;
    }


    /**
     * Gets the chiuso value for this Fascicolo.
     * 
     * @return chiuso
     */
    public boolean isChiuso() {
        return chiuso;
    }


    /**
     * Sets the chiuso value for this Fascicolo.
     * 
     * @param chiuso
     */
    public void setChiuso(boolean chiuso) {
        this.chiuso = chiuso;
    }


    /**
     * Gets the dataUltimoAggiornamento value for this Fascicolo.
     * 
     * @return dataUltimoAggiornamento
     */
    public java.util.Date getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }


    /**
     * Sets the dataUltimoAggiornamento value for this Fascicolo.
     * 
     * @param dataUltimoAggiornamento
     */
    public void setDataUltimoAggiornamento(java.util.Date dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }


    /**
     * Gets the dataUltimoAggiornamentoDocumentiEsattoriali value for this Fascicolo.
     * 
     * @return dataUltimoAggiornamentoDocumentiEsattoriali
     */
    public java.util.Date getDataUltimoAggiornamentoDocumentiEsattoriali() {
        return dataUltimoAggiornamentoDocumentiEsattoriali;
    }


    /**
     * Sets the dataUltimoAggiornamentoDocumentiEsattoriali value for this Fascicolo.
     * 
     * @param dataUltimoAggiornamentoDocumentiEsattoriali
     */
    public void setDataUltimoAggiornamentoDocumentiEsattoriali(java.util.Date dataUltimoAggiornamentoDocumentiEsattoriali) {
        this.dataUltimoAggiornamentoDocumentiEsattoriali = dataUltimoAggiornamentoDocumentiEsattoriali;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fascicolo)) return false;
        Fascicolo other = (Fascicolo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fascicoloId==null && other.getFascicoloId()==null) || 
             (this.fascicoloId!=null &&
              this.fascicoloId.equals(other.getFascicoloId()))) &&
            ((this.callerId==null && other.getCallerId()==null) || 
             (this.callerId!=null &&
              this.callerId.equals(other.getCallerId()))) &&
            ((this.dataApertura==null && other.getDataApertura()==null) || 
             (this.dataApertura!=null &&
              this.dataApertura.equals(other.getDataApertura()))) &&
            ((this.dataChiusura==null && other.getDataChiusura()==null) || 
             (this.dataChiusura!=null &&
              this.dataChiusura.equals(other.getDataChiusura()))) &&
            ((this.statoFascicoloId==null && other.getStatoFascicoloId()==null) || 
             (this.statoFascicoloId!=null &&
              this.statoFascicoloId.equals(other.getStatoFascicoloId()))) &&
            ((this.statoFascicoloDescr==null && other.getStatoFascicoloDescr()==null) || 
             (this.statoFascicoloDescr!=null &&
              this.statoFascicoloDescr.equals(other.getStatoFascicoloDescr()))) &&
            ((this.anagrafica==null && other.getAnagrafica()==null) || 
             (this.anagrafica!=null &&
              this.anagrafica.equals(other.getAnagrafica()))) &&
            ((this.cartelle==null && other.getCartelle()==null) || 
             (this.cartelle!=null &&
              java.util.Arrays.equals(this.cartelle, other.getCartelle()))) &&
            ((this.documenti==null && other.getDocumenti()==null) || 
             (this.documenti!=null &&
              java.util.Arrays.equals(this.documenti, other.getDocumenti()))) &&
            this.chiuso == other.isChiuso() &&
            ((this.dataUltimoAggiornamento==null && other.getDataUltimoAggiornamento()==null) || 
             (this.dataUltimoAggiornamento!=null &&
              this.dataUltimoAggiornamento.equals(other.getDataUltimoAggiornamento()))) &&
            ((this.dataUltimoAggiornamentoDocumentiEsattoriali==null && other.getDataUltimoAggiornamentoDocumentiEsattoriali()==null) || 
             (this.dataUltimoAggiornamentoDocumentiEsattoriali!=null &&
              this.dataUltimoAggiornamentoDocumentiEsattoriali.equals(other.getDataUltimoAggiornamentoDocumentiEsattoriali())));
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
        if (getFascicoloId() != null) {
            _hashCode += getFascicoloId().hashCode();
        }
        if (getCallerId() != null) {
            _hashCode += getCallerId().hashCode();
        }
        if (getDataApertura() != null) {
            _hashCode += getDataApertura().hashCode();
        }
        if (getDataChiusura() != null) {
            _hashCode += getDataChiusura().hashCode();
        }
        if (getStatoFascicoloId() != null) {
            _hashCode += getStatoFascicoloId().hashCode();
        }
        if (getStatoFascicoloDescr() != null) {
            _hashCode += getStatoFascicoloDescr().hashCode();
        }
        if (getAnagrafica() != null) {
            _hashCode += getAnagrafica().hashCode();
        }
        if (getCartelle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCartelle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCartelle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocumenti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumenti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumenti(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isChiuso() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDataUltimoAggiornamento() != null) {
            _hashCode += getDataUltimoAggiornamento().hashCode();
        }
        if (getDataUltimoAggiornamentoDocumentiEsattoriali() != null) {
            _hashCode += getDataUltimoAggiornamentoDocumentiEsattoriali().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fascicolo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicolo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fascicoloId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "callerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataApertura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataApertura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataChiusura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataChiusura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoFascicoloId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "statoFascicoloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoFascicoloDescr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "statoFascicoloDescr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anagrafica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "anagrafica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "anagrafica"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cartelle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "cartelle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "entityItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "documenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "entityItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chiuso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "chiuso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimoAggiornamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataUltimoAggiornamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimoAggiornamentoDocumentiEsattoriali");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataUltimoAggiornamentoDocumentiEsattoriali"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(true);
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
