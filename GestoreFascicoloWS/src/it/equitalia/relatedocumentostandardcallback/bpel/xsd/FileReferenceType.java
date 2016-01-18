/**
 * FileReferenceType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.relatedocumentostandardcallback.bpel.xsd;

public class FileReferenceType  implements java.io.Serializable {
    private java.lang.String nomeFile;

    private java.lang.String internalNumber;

    private java.lang.String queueManager;

    private java.lang.String queue;

    public FileReferenceType() {
    }

    public FileReferenceType(
           java.lang.String nomeFile,
           java.lang.String internalNumber,
           java.lang.String queueManager,
           java.lang.String queue) {
           this.nomeFile = nomeFile;
           this.internalNumber = internalNumber;
           this.queueManager = queueManager;
           this.queue = queue;
    }


    /**
     * Gets the nomeFile value for this FileReferenceType.
     * 
     * @return nomeFile
     */
    public java.lang.String getNomeFile() {
        return nomeFile;
    }


    /**
     * Sets the nomeFile value for this FileReferenceType.
     * 
     * @param nomeFile
     */
    public void setNomeFile(java.lang.String nomeFile) {
        this.nomeFile = nomeFile;
    }


    /**
     * Gets the internalNumber value for this FileReferenceType.
     * 
     * @return internalNumber
     */
    public java.lang.String getInternalNumber() {
        return internalNumber;
    }


    /**
     * Sets the internalNumber value for this FileReferenceType.
     * 
     * @param internalNumber
     */
    public void setInternalNumber(java.lang.String internalNumber) {
        this.internalNumber = internalNumber;
    }


    /**
     * Gets the queueManager value for this FileReferenceType.
     * 
     * @return queueManager
     */
    public java.lang.String getQueueManager() {
        return queueManager;
    }


    /**
     * Sets the queueManager value for this FileReferenceType.
     * 
     * @param queueManager
     */
    public void setQueueManager(java.lang.String queueManager) {
        this.queueManager = queueManager;
    }


    /**
     * Gets the queue value for this FileReferenceType.
     * 
     * @return queue
     */
    public java.lang.String getQueue() {
        return queue;
    }


    /**
     * Sets the queue value for this FileReferenceType.
     * 
     * @param queue
     */
    public void setQueue(java.lang.String queue) {
        this.queue = queue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FileReferenceType)) return false;
        FileReferenceType other = (FileReferenceType) obj;
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
            ((this.internalNumber==null && other.getInternalNumber()==null) || 
             (this.internalNumber!=null &&
              this.internalNumber.equals(other.getInternalNumber()))) &&
            ((this.queueManager==null && other.getQueueManager()==null) || 
             (this.queueManager!=null &&
              this.queueManager.equals(other.getQueueManager()))) &&
            ((this.queue==null && other.getQueue()==null) || 
             (this.queue!=null &&
              this.queue.equals(other.getQueue())));
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
        if (getInternalNumber() != null) {
            _hashCode += getInternalNumber().hashCode();
        }
        if (getQueueManager() != null) {
            _hashCode += getQueueManager().hashCode();
        }
        if (getQueue() != null) {
            _hashCode += getQueue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FileReferenceType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "FileReferenceType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeFile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "NomeFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internalNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "InternalNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queueManager");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "QueueManager"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xsd.bpel.relatedocumentostandardcallback.equitalia.it", "Queue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
