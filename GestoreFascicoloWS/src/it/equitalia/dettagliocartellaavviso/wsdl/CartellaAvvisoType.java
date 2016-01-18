/**
 * CartellaAvvisoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.dettagliocartellaavviso.wsdl;

public class CartellaAvvisoType  implements java.io.Serializable {
    private it.equitalia.dettagliocartellaavviso.wsdl.DocumentoType documento;

    private it.equitalia.dettagliocartellaavviso.wsdl.TributiType tributi;

    private it.equitalia.dettagliocartellaavviso.wsdl.RataType[] pianoRateOrigine;

    private it.equitalia.dettagliocartellaavviso.wsdl.PianiRateazioneType pianiRateazione;

    private it.equitalia.dettagliocartellaavviso.wsdl.ProcedureType procedure;

    private it.equitalia.dettagliocartellaavviso.wsdl.QuietanzeType quietanze;

    public CartellaAvvisoType() {
    }

    public CartellaAvvisoType(
           it.equitalia.dettagliocartellaavviso.wsdl.DocumentoType documento,
           it.equitalia.dettagliocartellaavviso.wsdl.TributiType tributi,
           it.equitalia.dettagliocartellaavviso.wsdl.RataType[] pianoRateOrigine,
           it.equitalia.dettagliocartellaavviso.wsdl.PianiRateazioneType pianiRateazione,
           it.equitalia.dettagliocartellaavviso.wsdl.ProcedureType procedure,
           it.equitalia.dettagliocartellaavviso.wsdl.QuietanzeType quietanze) {
           this.documento = documento;
           this.tributi = tributi;
           this.pianoRateOrigine = pianoRateOrigine;
           this.pianiRateazione = pianiRateazione;
           this.procedure = procedure;
           this.quietanze = quietanze;
    }


    /**
     * Gets the documento value for this CartellaAvvisoType.
     * 
     * @return documento
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.DocumentoType getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this CartellaAvvisoType.
     * 
     * @param documento
     */
    public void setDocumento(it.equitalia.dettagliocartellaavviso.wsdl.DocumentoType documento) {
        this.documento = documento;
    }


    /**
     * Gets the tributi value for this CartellaAvvisoType.
     * 
     * @return tributi
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.TributiType getTributi() {
        return tributi;
    }


    /**
     * Sets the tributi value for this CartellaAvvisoType.
     * 
     * @param tributi
     */
    public void setTributi(it.equitalia.dettagliocartellaavviso.wsdl.TributiType tributi) {
        this.tributi = tributi;
    }


    /**
     * Gets the pianoRateOrigine value for this CartellaAvvisoType.
     * 
     * @return pianoRateOrigine
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.RataType[] getPianoRateOrigine() {
        return pianoRateOrigine;
    }


    /**
     * Sets the pianoRateOrigine value for this CartellaAvvisoType.
     * 
     * @param pianoRateOrigine
     */
    public void setPianoRateOrigine(it.equitalia.dettagliocartellaavviso.wsdl.RataType[] pianoRateOrigine) {
        this.pianoRateOrigine = pianoRateOrigine;
    }


    /**
     * Gets the pianiRateazione value for this CartellaAvvisoType.
     * 
     * @return pianiRateazione
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.PianiRateazioneType getPianiRateazione() {
        return pianiRateazione;
    }


    /**
     * Sets the pianiRateazione value for this CartellaAvvisoType.
     * 
     * @param pianiRateazione
     */
    public void setPianiRateazione(it.equitalia.dettagliocartellaavviso.wsdl.PianiRateazioneType pianiRateazione) {
        this.pianiRateazione = pianiRateazione;
    }


    /**
     * Gets the procedure value for this CartellaAvvisoType.
     * 
     * @return procedure
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.ProcedureType getProcedure() {
        return procedure;
    }


    /**
     * Sets the procedure value for this CartellaAvvisoType.
     * 
     * @param procedure
     */
    public void setProcedure(it.equitalia.dettagliocartellaavviso.wsdl.ProcedureType procedure) {
        this.procedure = procedure;
    }


    /**
     * Gets the quietanze value for this CartellaAvvisoType.
     * 
     * @return quietanze
     */
    public it.equitalia.dettagliocartellaavviso.wsdl.QuietanzeType getQuietanze() {
        return quietanze;
    }


    /**
     * Sets the quietanze value for this CartellaAvvisoType.
     * 
     * @param quietanze
     */
    public void setQuietanze(it.equitalia.dettagliocartellaavviso.wsdl.QuietanzeType quietanze) {
        this.quietanze = quietanze;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartellaAvvisoType)) return false;
        CartellaAvvisoType other = (CartellaAvvisoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              this.documento.equals(other.getDocumento()))) &&
            ((this.tributi==null && other.getTributi()==null) || 
             (this.tributi!=null &&
              this.tributi.equals(other.getTributi()))) &&
            ((this.pianoRateOrigine==null && other.getPianoRateOrigine()==null) || 
             (this.pianoRateOrigine!=null &&
              java.util.Arrays.equals(this.pianoRateOrigine, other.getPianoRateOrigine()))) &&
            ((this.pianiRateazione==null && other.getPianiRateazione()==null) || 
             (this.pianiRateazione!=null &&
              this.pianiRateazione.equals(other.getPianiRateazione()))) &&
            ((this.procedure==null && other.getProcedure()==null) || 
             (this.procedure!=null &&
              this.procedure.equals(other.getProcedure()))) &&
            ((this.quietanze==null && other.getQuietanze()==null) || 
             (this.quietanze!=null &&
              this.quietanze.equals(other.getQuietanze())));
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
        if (getDocumento() != null) {
            _hashCode += getDocumento().hashCode();
        }
        if (getTributi() != null) {
            _hashCode += getTributi().hashCode();
        }
        if (getPianoRateOrigine() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPianoRateOrigine());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPianoRateOrigine(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPianiRateazione() != null) {
            _hashCode += getPianiRateazione().hashCode();
        }
        if (getProcedure() != null) {
            _hashCode += getProcedure().hashCode();
        }
        if (getQuietanze() != null) {
            _hashCode += getQuietanze().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartellaAvvisoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "cartellaAvvisoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "DocumentoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tributi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Tributi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "TributiType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pianoRateOrigine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "PianoRateOrigine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "RataType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Rata"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pianiRateazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "PianiRateazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "PianiRateazioneType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procedure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Procedure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "ProcedureType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quietanze");
        elemField.setXmlName(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "Quietanze"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://wsdl.dettagliocartellaavviso.equitalia.it", "QuietanzeType"));
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
