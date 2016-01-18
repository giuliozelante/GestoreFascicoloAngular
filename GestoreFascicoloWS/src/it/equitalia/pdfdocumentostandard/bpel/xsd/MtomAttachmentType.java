/**
 * MtomAttachmentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.pdfdocumentostandard.bpel.xsd;

public class MtomAttachmentType  implements java.io.Serializable {
    private java.lang.String nomeFile;

    private org.w3.www._2005._05.xmlmime.Base64Binary file;

    public MtomAttachmentType() {
    }

    public MtomAttachmentType(
           java.lang.String nomeFile,
           org.w3.www._2005._05.xmlmime.Base64Binary file) {
           this.nomeFile = nomeFile;
           this.file = file;
    }


    /**
     * Gets the nomeFile value for this MtomAttachmentType.
     * 
     * @return nomeFile
     */
    public java.lang.String getNomeFile() {
        return nomeFile;
    }


    /**
     * Sets the nomeFile value for this MtomAttachmentType.
     * 
     * @param nomeFile
     */
    public void setNomeFile(java.lang.String nomeFile) {
        this.nomeFile = nomeFile;
    }


    /**
     * Gets the file value for this MtomAttachmentType.
     * 
     * @return file
     */
    public org.w3.www._2005._05.xmlmime.Base64Binary getFile() {
        return file;
    }


    /**
     * Sets the file value for this MtomAttachmentType.
     * 
     * @param file
     */
    public void setFile(org.w3.www._2005._05.xmlmime.Base64Binary file) {
        this.file = file;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MtomAttachmentType)) return false;
        MtomAttachmentType other = (MtomAttachmentType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nomeFile==null && other.getNomeFile()==null) || 
             (this.nomeFile!=null &&
              this.nomeFile.equals(other.getNomeFile()))) &&
            ((this.file==null && other.getFile()==null) || 
             (this.file!=null &&
              this.file.equals(other.getFile())));
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
        if (getNomeFile() != null) {
            _hashCode += getNomeFile().hashCode();
        }
        if (getFile() != null) {
            _hashCode += getFile().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MtomAttachmentType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "MtomAttachmentType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeFile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "NomeFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("file");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.pdfdocumentostandard.equitalia.it", "File"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2005/05/xmlmime", "base64Binary"));
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
