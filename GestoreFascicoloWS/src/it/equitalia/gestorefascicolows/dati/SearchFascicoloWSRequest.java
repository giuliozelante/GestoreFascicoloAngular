/**
 * SearchFascicoloWSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class SearchFascicoloWSRequest  implements java.io.Serializable {
    private java.lang.String fascicoloId;

    private java.lang.String callerId;

    private java.lang.String codiceFiscale;

    private java.lang.Integer statoFascicolo;

    private java.util.Date dataAperturaDa;

    private java.util.Date dataAperturaA;

    private java.util.Date dataChiusuraDa;

    private java.util.Date dataChiusuraA;

    public SearchFascicoloWSRequest() {
    }

    public SearchFascicoloWSRequest(
           java.lang.String fascicoloId,
           java.lang.String callerId,
           java.lang.String codiceFiscale,
           java.lang.Integer statoFascicolo,
           java.util.Date dataAperturaDa,
           java.util.Date dataAperturaA,
           java.util.Date dataChiusuraDa,
           java.util.Date dataChiusuraA) {
           this.fascicoloId = fascicoloId;
           this.callerId = callerId;
           this.codiceFiscale = codiceFiscale;
           this.statoFascicolo = statoFascicolo;
           this.dataAperturaDa = dataAperturaDa;
           this.dataAperturaA = dataAperturaA;
           this.dataChiusuraDa = dataChiusuraDa;
           this.dataChiusuraA = dataChiusuraA;
    }


    /**
     * Gets the fascicoloId value for this SearchFascicoloWSRequest.
     * 
     * @return fascicoloId
     */
    public java.lang.String getFascicoloId() {
        return fascicoloId;
    }


    /**
     * Sets the fascicoloId value for this SearchFascicoloWSRequest.
     * 
     * @param fascicoloId
     */
    public void setFascicoloId(java.lang.String fascicoloId) {
        this.fascicoloId = fascicoloId;
    }


    /**
     * Gets the callerId value for this SearchFascicoloWSRequest.
     * 
     * @return callerId
     */
    public java.lang.String getCallerId() {
        return callerId;
    }


    /**
     * Sets the callerId value for this SearchFascicoloWSRequest.
     * 
     * @param callerId
     */
    public void setCallerId(java.lang.String callerId) {
        this.callerId = callerId;
    }


    /**
     * Gets the codiceFiscale value for this SearchFascicoloWSRequest.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this SearchFascicoloWSRequest.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the statoFascicolo value for this SearchFascicoloWSRequest.
     * 
     * @return statoFascicolo
     */
    public java.lang.Integer getStatoFascicolo() {
        return statoFascicolo;
    }


    /**
     * Sets the statoFascicolo value for this SearchFascicoloWSRequest.
     * 
     * @param statoFascicolo
     */
    public void setStatoFascicolo(java.lang.Integer statoFascicolo) {
        this.statoFascicolo = statoFascicolo;
    }


    /**
     * Gets the dataAperturaDa value for this SearchFascicoloWSRequest.
     * 
     * @return dataAperturaDa
     */
    public java.util.Date getDataAperturaDa() {
        return dataAperturaDa;
    }


    /**
     * Sets the dataAperturaDa value for this SearchFascicoloWSRequest.
     * 
     * @param dataAperturaDa
     */
    public void setDataAperturaDa(java.util.Date dataAperturaDa) {
        this.dataAperturaDa = dataAperturaDa;
    }


    /**
     * Gets the dataAperturaA value for this SearchFascicoloWSRequest.
     * 
     * @return dataAperturaA
     */
    public java.util.Date getDataAperturaA() {
        return dataAperturaA;
    }


    /**
     * Sets the dataAperturaA value for this SearchFascicoloWSRequest.
     * 
     * @param dataAperturaA
     */
    public void setDataAperturaA(java.util.Date dataAperturaA) {
        this.dataAperturaA = dataAperturaA;
    }


    /**
     * Gets the dataChiusuraDa value for this SearchFascicoloWSRequest.
     * 
     * @return dataChiusuraDa
     */
    public java.util.Date getDataChiusuraDa() {
        return dataChiusuraDa;
    }


    /**
     * Sets the dataChiusuraDa value for this SearchFascicoloWSRequest.
     * 
     * @param dataChiusuraDa
     */
    public void setDataChiusuraDa(java.util.Date dataChiusuraDa) {
        this.dataChiusuraDa = dataChiusuraDa;
    }


    /**
     * Gets the dataChiusuraA value for this SearchFascicoloWSRequest.
     * 
     * @return dataChiusuraA
     */
    public java.util.Date getDataChiusuraA() {
        return dataChiusuraA;
    }


    /**
     * Sets the dataChiusuraA value for this SearchFascicoloWSRequest.
     * 
     * @param dataChiusuraA
     */
    public void setDataChiusuraA(java.util.Date dataChiusuraA) {
        this.dataChiusuraA = dataChiusuraA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchFascicoloWSRequest)) return false;
        SearchFascicoloWSRequest other = (SearchFascicoloWSRequest) obj;
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
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.statoFascicolo==null && other.getStatoFascicolo()==null) || 
             (this.statoFascicolo!=null &&
              this.statoFascicolo.equals(other.getStatoFascicolo()))) &&
            ((this.dataAperturaDa==null && other.getDataAperturaDa()==null) || 
             (this.dataAperturaDa!=null &&
              this.dataAperturaDa.equals(other.getDataAperturaDa()))) &&
            ((this.dataAperturaA==null && other.getDataAperturaA()==null) || 
             (this.dataAperturaA!=null &&
              this.dataAperturaA.equals(other.getDataAperturaA()))) &&
            ((this.dataChiusuraDa==null && other.getDataChiusuraDa()==null) || 
             (this.dataChiusuraDa!=null &&
              this.dataChiusuraDa.equals(other.getDataChiusuraDa()))) &&
            ((this.dataChiusuraA==null && other.getDataChiusuraA()==null) || 
             (this.dataChiusuraA!=null &&
              this.dataChiusuraA.equals(other.getDataChiusuraA())));
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
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getStatoFascicolo() != null) {
            _hashCode += getStatoFascicolo().hashCode();
        }
        if (getDataAperturaDa() != null) {
            _hashCode += getDataAperturaDa().hashCode();
        }
        if (getDataAperturaA() != null) {
            _hashCode += getDataAperturaA().hashCode();
        }
        if (getDataChiusuraDa() != null) {
            _hashCode += getDataChiusuraDa().hashCode();
        }
        if (getDataChiusuraA() != null) {
            _hashCode += getDataChiusuraA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchFascicoloWSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", ">searchFascicoloWSRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fascicoloId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "fascicoloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "callerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoFascicolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "statoFascicolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAperturaDa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataAperturaDa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAperturaA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataAperturaA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataChiusuraDa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataChiusuraDa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataChiusuraA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataChiusuraA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
