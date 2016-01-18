/**
 * InserimentoTributoWSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class InserimentoTributoWSRequest  implements java.io.Serializable {
    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private EsitoOperazioneType esitoOperazione;

    private TributoType[] tributo;

    public InserimentoTributoWSRequest() {
    }

    public InserimentoTributoWSRequest(
           java.lang.String fascicoloId,
           java.lang.String callerId,
           EsitoOperazioneType esitoOperazione,
           TributoType[] tributo) {
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.esitoOperazione = esitoOperazione;
           this.tributo = tributo;
    }


    /**
     * Gets the fascicoloId value for this InserimentoTributoWSRequest.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this InserimentoTributoWSRequest.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this InserimentoTributoWSRequest.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this InserimentoTributoWSRequest.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the esitoOperazione value for this InserimentoTributoWSRequest.
     * 
     * @return esitoOperazione
     */
    public EsitoOperazioneType getEsitoOperazione() {
        return esitoOperazione;
    }


    /**
     * Sets the esitoOperazione value for this InserimentoTributoWSRequest.
     * 
     * @param esitoOperazione
     */
    public void setEsitoOperazione(EsitoOperazioneType esitoOperazione) {
        this.esitoOperazione = esitoOperazione;
    }


    /**
     * Gets the tributo value for this InserimentoTributoWSRequest.
     * 
     * @return tributo
     */
    public TributoType[] getTributo() {
        return tributo;
    }


    /**
     * Sets the tributo value for this InserimentoTributoWSRequest.
     * 
     * @param tributo
     */
    public void setTributo(TributoType[] tributo) {
        this.tributo = tributo;
    }

    public TributoType getTributo(int i) {
        return this.tributo[i];
    }

    public void setTributo(int i, TributoType _value) {
        this.tributo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InserimentoTributoWSRequest)) return false;
        InserimentoTributoWSRequest other = (InserimentoTributoWSRequest) obj;
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
        if (getFascicoloId() != null) {
            _hashCode += getFascicoloId().hashCode();
        }
        if (getCallerId() != null) {
            _hashCode += getCallerId().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(InserimentoTributoWSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", ">inserimentoTributoWSRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fascicoloId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "fascicoloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "callerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esitoOperazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "EsitoOperazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "EsitoOperazioneType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tributo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "Tributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "TributoType"));
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
