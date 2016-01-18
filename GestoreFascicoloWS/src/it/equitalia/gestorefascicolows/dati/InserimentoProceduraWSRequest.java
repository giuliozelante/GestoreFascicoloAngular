/**
 * InserimentoProceduraWSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class InserimentoProceduraWSRequest  implements java.io.Serializable {
    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private EsitoOperazioneType esitoOperazione;

    private ProceduraType[] procedura;

    public InserimentoProceduraWSRequest() {
    }

    public InserimentoProceduraWSRequest(
           java.lang.String fascicoloId,
           java.lang.String callerId,
           EsitoOperazioneType esitoOperazione,
           ProceduraType[] procedura) {
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.esitoOperazione = esitoOperazione;
           this.procedura = procedura;
    }


    /**
     * Gets the fascicoloId value for this InserimentoProceduraWSRequest.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this InserimentoProceduraWSRequest.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this InserimentoProceduraWSRequest.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this InserimentoProceduraWSRequest.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the esitoOperazione value for this InserimentoProceduraWSRequest.
     * 
     * @return esitoOperazione
     */
    public EsitoOperazioneType getEsitoOperazione() {
        return esitoOperazione;
    }


    /**
     * Sets the esitoOperazione value for this InserimentoProceduraWSRequest.
     * 
     * @param esitoOperazione
     */
    public void setEsitoOperazione(EsitoOperazioneType esitoOperazione) {
        this.esitoOperazione = esitoOperazione;
    }


    /**
     * Gets the procedura value for this InserimentoProceduraWSRequest.
     * 
     * @return procedura
     */
    public ProceduraType[] getProcedura() {
        return procedura;
    }


    /**
     * Sets the procedura value for this InserimentoProceduraWSRequest.
     * 
     * @param procedura
     */
    public void setProcedura(ProceduraType[] procedura) {
        this.procedura = procedura;
    }

    public ProceduraType getProcedura(int i) {
        return this.procedura[i];
    }

    public void setProcedura(int i, ProceduraType _value) {
        this.procedura[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InserimentoProceduraWSRequest)) return false;
        InserimentoProceduraWSRequest other = (InserimentoProceduraWSRequest) obj;
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
            ((this.procedura==null && other.getProcedura()==null) || 
             (this.procedura!=null &&
              java.util.Arrays.equals(this.procedura, other.getProcedura())));
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
        if (getProcedura() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProcedura());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProcedura(), i);
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
        new org.apache.axis.description.TypeDesc(InserimentoProceduraWSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", ">inserimentoProceduraWSRequest"));
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
        elemField.setFieldName("procedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "Procedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ProceduraType"));
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
