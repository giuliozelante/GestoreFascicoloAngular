/**
 * RataType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class RataType  implements java.io.Serializable {
    private java.lang.String dataScadenza;

    private java.math.BigDecimal importoRata;

    private java.lang.String numeroRav;

    private java.lang.String statoRata;

    private int progressivoRata;

    public RataType() {
    }

    public RataType(
           java.lang.String dataScadenza,
           java.math.BigDecimal importoRata,
           java.lang.String numeroRav,
           java.lang.String statoRata,
           int progressivoRata) {
           this.dataScadenza = dataScadenza;
           this.importoRata = importoRata;
           this.numeroRav = numeroRav;
           this.statoRata = statoRata;
           this.progressivoRata = progressivoRata;
    }


    /**
     * Gets the dataScadenza value for this RataType.
     * 
     * @return dataScadenza
     */
    public java.lang.String getDataScadenza() {
        return dataScadenza;
    }


    /**
     * Sets the dataScadenza value for this RataType.
     * 
     * @param dataScadenza
     */
    public void setDataScadenza(java.lang.String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }


    /**
     * Gets the importoRata value for this RataType.
     * 
     * @return importoRata
     */
    public java.math.BigDecimal getImportoRata() {
        return importoRata;
    }


    /**
     * Sets the importoRata value for this RataType.
     * 
     * @param importoRata
     */
    public void setImportoRata(java.math.BigDecimal importoRata) {
        this.importoRata = importoRata;
    }


    /**
     * Gets the numeroRav value for this RataType.
     * 
     * @return numeroRav
     */
    public java.lang.String getNumeroRav() {
        return numeroRav;
    }


    /**
     * Sets the numeroRav value for this RataType.
     * 
     * @param numeroRav
     */
    public void setNumeroRav(java.lang.String numeroRav) {
        this.numeroRav = numeroRav;
    }


    /**
     * Gets the statoRata value for this RataType.
     * 
     * @return statoRata
     */
    public java.lang.String getStatoRata() {
        return statoRata;
    }


    /**
     * Sets the statoRata value for this RataType.
     * 
     * @param statoRata
     */
    public void setStatoRata(java.lang.String statoRata) {
        this.statoRata = statoRata;
    }


    /**
     * Gets the progressivoRata value for this RataType.
     * 
     * @return progressivoRata
     */
    public int getProgressivoRata() {
        return progressivoRata;
    }


    /**
     * Sets the progressivoRata value for this RataType.
     * 
     * @param progressivoRata
     */
    public void setProgressivoRata(int progressivoRata) {
        this.progressivoRata = progressivoRata;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RataType)) return false;
        RataType other = (RataType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataScadenza==null && other.getDataScadenza()==null) || 
             (this.dataScadenza!=null &&
              this.dataScadenza.equals(other.getDataScadenza()))) &&
            ((this.importoRata==null && other.getImportoRata()==null) || 
             (this.importoRata!=null &&
              this.importoRata.equals(other.getImportoRata()))) &&
            ((this.numeroRav==null && other.getNumeroRav()==null) || 
             (this.numeroRav!=null &&
              this.numeroRav.equals(other.getNumeroRav()))) &&
            ((this.statoRata==null && other.getStatoRata()==null) || 
             (this.statoRata!=null &&
              this.statoRata.equals(other.getStatoRata()))) &&
            this.progressivoRata == other.getProgressivoRata();
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
        if (getDataScadenza() != null) {
            _hashCode += getDataScadenza().hashCode();
        }
        if (getImportoRata() != null) {
            _hashCode += getImportoRata().hashCode();
        }
        if (getNumeroRav() != null) {
            _hashCode += getNumeroRav().hashCode();
        }
        if (getStatoRata() != null) {
            _hashCode += getStatoRata().hashCode();
        }
        _hashCode += getProgressivoRata();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RataType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "RataType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataScadenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DataScadenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importoRata");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ImportoRata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("statoRata");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "StatoRata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("progressivoRata");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ProgressivoRata"));
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
