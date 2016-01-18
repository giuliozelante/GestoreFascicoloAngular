/**
 * TributoRispostaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class TributoRispostaType  implements java.io.Serializable {
    private it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType esitoOperazione;

    private it.equitalia.dettagliocartellaavviso.wsdl.TributoType[] tributo;

    public TributoRispostaType() {
    }

    public TributoRispostaType(
           it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType esitoOperazione,
           it.equitalia.dettagliocartellaavviso.wsdl.TributoType[] tributo) {
           this.esitoOperazione = esitoOperazione;
           this.tributo = tributo;
    }


    /**
     * Gets the esitoOperazione value for this TributoRispostaType.
     * 
     * @return esitoOperazione
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType getEsitoOperazione() {
        return esitoOperazione;
    }


    /**
     * Sets the esitoOperazione value for this TributoRispostaType.
     * 
     * @param esitoOperazione
     */
    public void setEsitoOperazione(it.equitalia.dettagliocartellaavviso.wsdl.EsitoOperazioneType esitoOperazione) {
        this.esitoOperazione = esitoOperazione;
    }


    /**
     * Gets the tributo value for this TributoRispostaType.
     * 
     * @return tributo
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.TributoType[] getTributo() {
        return tributo;
    }


    /**
     * Sets the tributo value for this TributoRispostaType.
     * 
     * @param tributo
     */
    public void setTributo(it.equitalia.dettagliocartellaavviso.wsdl.TributoType[] tributo) {
        this.tributo = tributo;
    }

    public it.equitalia.dettagliocartellaavviso.wsdl.TributoType getTributo(int i) {
        return this.tributo[i];
    }

    public void setTributo(int i, it.equitalia.dettagliocartellaavviso.wsdl.TributoType _value) {
        this.tributo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TributoRispostaType)) return false;
        TributoRispostaType other = (TributoRispostaType) obj;
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
            ((this.tributo==null && other.getTributo()==null) || 
             (this.tributo!=null &&
              java.util.Arrays.equals(this.tributo, other.getTributo())));
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
        if (getTributo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTributo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTributo(), i);
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
        new org.apache.axis.description.TypeDesc(TributoRispostaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "TributoRispostaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esitoOperazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "EsitoOperazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "EsitoOperazioneType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tributo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Tributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "TributoType"));
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
