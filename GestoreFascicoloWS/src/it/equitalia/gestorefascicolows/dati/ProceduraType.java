/**
 * ProceduraType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.gestorefascicolows.dati;

public class ProceduraType  implements java.io.Serializable {
    private java.lang.String codiceFiscale;

    private java.lang.String idProcedura;

    private java.lang.String annoProcedura;

    private TipoProceduraType tipoProcedura;

    private java.lang.String descrizioneProcedura;

    private java.util.Date dataApertura;

    private java.util.Date dataChiusura;

    private java.lang.String statoProcedura;

    private IdentificativoDocumentoType[] documentoAssociato;

    public ProceduraType() {
    }

    public ProceduraType(
           java.lang.String codiceFiscale,
           java.lang.String idProcedura,
           java.lang.String annoProcedura,
           TipoProceduraType tipoProcedura,
           java.lang.String descrizioneProcedura,
           java.util.Date dataApertura,
           java.util.Date dataChiusura,
           java.lang.String statoProcedura,
           IdentificativoDocumentoType[] documentoAssociato) {
           this.codiceFiscale = codiceFiscale;
           this.idProcedura = idProcedura;
           this.annoProcedura = annoProcedura;
           this.tipoProcedura = tipoProcedura;
           this.descrizioneProcedura = descrizioneProcedura;
           this.dataApertura = dataApertura;
           this.dataChiusura = dataChiusura;
           this.statoProcedura = statoProcedura;
           this.documentoAssociato = documentoAssociato;
    }


    /**
     * Gets the codiceFiscale value for this ProceduraType.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this ProceduraType.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the idProcedura value for this ProceduraType.
     * 
     * @return idProcedura
     */
    public java.lang.String getIdProcedura() {
        return idProcedura;
    }


    /**
     * Sets the idProcedura value for this ProceduraType.
     * 
     * @param idProcedura
     */
    public void setIdProcedura(java.lang.String idProcedura) {
        this.idProcedura = idProcedura;
    }


    /**
     * Gets the annoProcedura value for this ProceduraType.
     * 
     * @return annoProcedura
     */
    public java.lang.String getAnnoProcedura() {
        return annoProcedura;
    }


    /**
     * Sets the annoProcedura value for this ProceduraType.
     * 
     * @param annoProcedura
     */
    public void setAnnoProcedura(java.lang.String annoProcedura) {
        this.annoProcedura = annoProcedura;
    }


    /**
     * Gets the tipoProcedura value for this ProceduraType.
     * 
     * @return tipoProcedura
     */
    public TipoProceduraType getTipoProcedura() {
        return tipoProcedura;
    }


    /**
     * Sets the tipoProcedura value for this ProceduraType.
     * 
     * @param tipoProcedura
     */
    public void setTipoProcedura(TipoProceduraType tipoProcedura) {
        this.tipoProcedura = tipoProcedura;
    }


    /**
     * Gets the descrizioneProcedura value for this ProceduraType.
     * 
     * @return descrizioneProcedura
     */
    public java.lang.String getDescrizioneProcedura() {
        return descrizioneProcedura;
    }


    /**
     * Sets the descrizioneProcedura value for this ProceduraType.
     * 
     * @param descrizioneProcedura
     */
    public void setDescrizioneProcedura(java.lang.String descrizioneProcedura) {
        this.descrizioneProcedura = descrizioneProcedura;
    }


    /**
     * Gets the dataApertura value for this ProceduraType.
     * 
     * @return dataApertura
     */
    public java.util.Date getDataApertura() {
        return dataApertura;
    }


    /**
     * Sets the dataApertura value for this ProceduraType.
     * 
     * @param dataApertura
     */
    public void setDataApertura(java.util.Date dataApertura) {
        this.dataApertura = dataApertura;
    }


    /**
     * Gets the dataChiusura value for this ProceduraType.
     * 
     * @return dataChiusura
     */
    public java.util.Date getDataChiusura() {
        return dataChiusura;
    }


    /**
     * Sets the dataChiusura value for this ProceduraType.
     * 
     * @param dataChiusura
     */
    public void setDataChiusura(java.util.Date dataChiusura) {
        this.dataChiusura = dataChiusura;
    }


    /**
     * Gets the statoProcedura value for this ProceduraType.
     * 
     * @return statoProcedura
     */
    public java.lang.String getStatoProcedura() {
        return statoProcedura;
    }


    /**
     * Sets the statoProcedura value for this ProceduraType.
     * 
     * @param statoProcedura
     */
    public void setStatoProcedura(java.lang.String statoProcedura) {
        this.statoProcedura = statoProcedura;
    }


    /**
     * Gets the documentoAssociato value for this ProceduraType.
     * 
     * @return documentoAssociato
     */
    public IdentificativoDocumentoType[] getDocumentoAssociato() {
        return documentoAssociato;
    }


    /**
     * Sets the documentoAssociato value for this ProceduraType.
     * 
     * @param documentoAssociato
     */
    public void setDocumentoAssociato(IdentificativoDocumentoType[] documentoAssociato) {
        this.documentoAssociato = documentoAssociato;
    }

    public IdentificativoDocumentoType getDocumentoAssociato(int i) {
        return this.documentoAssociato[i];
    }

    public void setDocumentoAssociato(int i, IdentificativoDocumentoType _value) {
        this.documentoAssociato[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProceduraType)) return false;
        ProceduraType other = (ProceduraType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.idProcedura==null && other.getIdProcedura()==null) || 
             (this.idProcedura!=null &&
              this.idProcedura.equals(other.getIdProcedura()))) &&
            ((this.annoProcedura==null && other.getAnnoProcedura()==null) || 
             (this.annoProcedura!=null &&
              this.annoProcedura.equals(other.getAnnoProcedura()))) &&
            ((this.tipoProcedura==null && other.getTipoProcedura()==null) || 
             (this.tipoProcedura!=null &&
              this.tipoProcedura.equals(other.getTipoProcedura()))) &&
            ((this.descrizioneProcedura==null && other.getDescrizioneProcedura()==null) || 
             (this.descrizioneProcedura!=null &&
              this.descrizioneProcedura.equals(other.getDescrizioneProcedura()))) &&
            ((this.dataApertura==null && other.getDataApertura()==null) || 
             (this.dataApertura!=null &&
              this.dataApertura.equals(other.getDataApertura()))) &&
            ((this.dataChiusura==null && other.getDataChiusura()==null) || 
             (this.dataChiusura!=null &&
              this.dataChiusura.equals(other.getDataChiusura()))) &&
            ((this.statoProcedura==null && other.getStatoProcedura()==null) || 
             (this.statoProcedura!=null &&
              this.statoProcedura.equals(other.getStatoProcedura()))) &&
            ((this.documentoAssociato==null && other.getDocumentoAssociato()==null) || 
             (this.documentoAssociato!=null &&
              java.util.Arrays.equals(this.documentoAssociato, other.getDocumentoAssociato())));
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
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getIdProcedura() != null) {
            _hashCode += getIdProcedura().hashCode();
        }
        if (getAnnoProcedura() != null) {
            _hashCode += getAnnoProcedura().hashCode();
        }
        if (getTipoProcedura() != null) {
            _hashCode += getTipoProcedura().hashCode();
        }
        if (getDescrizioneProcedura() != null) {
            _hashCode += getDescrizioneProcedura().hashCode();
        }
        if (getDataApertura() != null) {
            _hashCode += getDataApertura().hashCode();
        }
        if (getDataChiusura() != null) {
            _hashCode += getDataChiusura().hashCode();
        }
        if (getStatoProcedura() != null) {
            _hashCode += getStatoProcedura().hashCode();
        }
        if (getDocumentoAssociato() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentoAssociato());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentoAssociato(), i);
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
        new org.apache.axis.description.TypeDesc(ProceduraType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "ProceduraType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "CodiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "IdProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annoProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "AnnoProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "TipoProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "TipoProceduraType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DescrizioneProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataApertura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DataApertura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataChiusura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DataChiusura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoProcedura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "StatoProcedura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoAssociato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "DocumentoAssociato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.backend.gestorefascicolows.equitalia.it", "IdentificativoDocumentoType"));
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
