/**
 * PianoRateazioneRispostaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class PianoRateazioneRispostaType  implements java.io.Serializable {
    private it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType esitoOperazione;

    private it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType[] pianoRateazione;

    public PianoRateazioneRispostaType() {
    }

    public PianoRateazioneRispostaType(
           it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType esitoOperazione,
           it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType[] pianoRateazione) {
           this.esitoOperazione = esitoOperazione;
           this.pianoRateazione = pianoRateazione;
    }


    /**
     * Gets the esitoOperazione value for this PianoRateazioneRispostaType.
     * 
     * @return esitoOperazione
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType getEsitoOperazione() {
        return esitoOperazione;
    }


    /**
     * Sets the esitoOperazione value for this PianoRateazioneRispostaType.
     * 
     * @param esitoOperazione
     */
    public void setEsitoOperazione(it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType esitoOperazione) {
        this.esitoOperazione = esitoOperazione;
    }


    /**
     * Gets the pianoRateazione value for this PianoRateazioneRispostaType.
     * 
     * @return pianoRateazione
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType[] getPianoRateazione() {
        return pianoRateazione;
    }


    /**
     * Sets the pianoRateazione value for this PianoRateazioneRispostaType.
     * 
     * @param pianoRateazione
     */
    public void setPianoRateazione(it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType[] pianoRateazione) {
        this.pianoRateazione = pianoRateazione;
    }

    public it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType getPianoRateazione(int i) {
        return this.pianoRateazione[i];
    }

    public void setPianoRateazione(int i, it.equitalia.dettagliocartellaavviso.wsdl.PianoRateazioneType _value) {
        this.pianoRateazione[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PianoRateazioneRispostaType)) return false;
        PianoRateazioneRispostaType other = (PianoRateazioneRispostaType) obj;
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
            ((this.pianoRateazione==null && other.getPianoRateazione()==null) || 
             (this.pianoRateazione!=null &&
              java.util.Arrays.equals(this.pianoRateazione, other.getPianoRateazione())));
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
        if (getPianoRateazione() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPianoRateazione());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPianoRateazione(), i);
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
        new org.apache.axis.description.TypeDesc(PianoRateazioneRispostaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "PianoRateazioneRispostaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esitoOperazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "EsitoOperazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "EsitoOperazioneType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pianoRateazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "PianoRateazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "PianoRateazioneType"));
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
