/**
 * DocumentoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.documentiesattoriali.bpel;

public class DocumentoType  implements java.io.Serializable {
    private java.lang.String numeroDocumento;

    private java.lang.String tipoModello;

    private java.lang.String statoDocumento;

    private java.lang.String importo;

    private java.lang.String dataSpedizione;

    public DocumentoType() {
    }

    public DocumentoType(
           java.lang.String numeroDocumento,
           java.lang.String tipoModello,
           java.lang.String statoDocumento,
           java.lang.String importo,
           java.lang.String dataSpedizione) {
           this.numeroDocumento = numeroDocumento;
           this.tipoModello = tipoModello;
           this.statoDocumento = statoDocumento;
           this.importo = importo;
           this.dataSpedizione = dataSpedizione;
    }


    /**
     * Gets the numeroDocumento value for this DocumentoType.
     * 
     * @return numeroDocumento
     */
    public java.lang.String getNumeroDocumento() {
        return numeroDocumento;
    }


    /**
     * Sets the numeroDocumento value for this DocumentoType.
     * 
     * @param numeroDocumento
     */
    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    /**
     * Gets the tipoModello value for this DocumentoType.
     * 
     * @return tipoModello
     */
    public java.lang.String getTipoModello() {
        return tipoModello;
    }


    /**
     * Sets the tipoModello value for this DocumentoType.
     * 
     * @param tipoModello
     */
    public void setTipoModello(java.lang.String tipoModello) {
        this.tipoModello = tipoModello;
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
     * Gets the importo value for this DocumentoType.
     * 
     * @return importo
     */
    public java.lang.String getImporto() {
        return importo;
    }


    /**
     * Sets the importo value for this DocumentoType.
     * 
     * @param importo
     */
    public void setImporto(java.lang.String importo) {
        this.importo = importo;
    }


    /**
     * Gets the dataSpedizione value for this DocumentoType.
     * 
     * @return dataSpedizione
     */
    public java.lang.String getDataSpedizione() {
        return dataSpedizione;
    }


    /**
     * Sets the dataSpedizione value for this DocumentoType.
     * 
     * @param dataSpedizione
     */
    public void setDataSpedizione(java.lang.String dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
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
            ((this.numeroDocumento==null && other.getNumeroDocumento()==null) || 
             (this.numeroDocumento!=null &&
              this.numeroDocumento.equals(other.getNumeroDocumento()))) &&
            ((this.tipoModello==null && other.getTipoModello()==null) || 
             (this.tipoModello!=null &&
              this.tipoModello.equals(other.getTipoModello()))) &&
            ((this.statoDocumento==null && other.getStatoDocumento()==null) || 
             (this.statoDocumento!=null &&
              this.statoDocumento.equals(other.getStatoDocumento()))) &&
            ((this.importo==null && other.getImporto()==null) || 
             (this.importo!=null &&
              this.importo.equals(other.getImporto()))) &&
            ((this.dataSpedizione==null && other.getDataSpedizione()==null) || 
             (this.dataSpedizione!=null &&
              this.dataSpedizione.equals(other.getDataSpedizione())));
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
        if (getNumeroDocumento() != null) {
            _hashCode += getNumeroDocumento().hashCode();
        }
        if (getTipoModello() != null) {
            _hashCode += getTipoModello().hashCode();
        }
        if (getStatoDocumento() != null) {
            _hashCode += getStatoDocumento().hashCode();
        }
        if (getImporto() != null) {
            _hashCode += getImporto().hashCode();
        }
        if (getDataSpedizione() != null) {
            _hashCode += getDataSpedizione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "documentoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "numeroDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoModello");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "tipoModello"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "statoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "importo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataSpedizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.documentiesattoriali.equitalia.it", "dataSpedizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
