/**
 * ChiusuraFascicoloResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.equitalia.chiusurafascicolo.bpel;

public class ChiusuraFascicoloResponse  implements java.io.Serializable {
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
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    private java.lang.String codiceEsito;

    private java.lang.String descrizioneEsito;


    private java.lang.Object __equalsCalc = null;


    private boolean __hashCodeCalc = false;


    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChiusuraFascicoloResponse.class, true);


    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", ">ChiusuraFascicoloResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", "codiceEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneEsito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bpel.chiusurafascicolo.equitalia.it", "descrizioneEsito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    public ChiusuraFascicoloResponse() {
    }
    public ChiusuraFascicoloResponse(
           java.lang.String codiceEsito,
           java.lang.String descrizioneEsito) {
           this.codiceEsito = codiceEsito;
           this.descrizioneEsito = descrizioneEsito;
    }

    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChiusuraFascicoloResponse)) return false;
        ChiusuraFascicoloResponse other = (ChiusuraFascicoloResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceEsito==null && other.getCodiceEsito()==null) || 
             (this.codiceEsito!=null &&
              this.codiceEsito.equals(other.getCodiceEsito()))) &&
            ((this.descrizioneEsito==null && other.getDescrizioneEsito()==null) || 
             (this.descrizioneEsito!=null &&
              this.descrizioneEsito.equals(other.getDescrizioneEsito())));
        __equalsCalc = null;
        return _equals;
    }
    /**
     * Gets the codiceEsito value for this ChiusuraFascicoloResponse.
     * 
     * @return codiceEsito
     */
    public java.lang.String getCodiceEsito() {
        return codiceEsito;
    }

    /**
     * Gets the descrizioneEsito value for this ChiusuraFascicoloResponse.
     * 
     * @return descrizioneEsito
     */
    public java.lang.String getDescrizioneEsito() {
        return descrizioneEsito;
    }

    @Override
	public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCodiceEsito() != null) {
            _hashCode += getCodiceEsito().hashCode();
        }
        if (getDescrizioneEsito() != null) {
            _hashCode += getDescrizioneEsito().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    /**
     * Sets the codiceEsito value for this ChiusuraFascicoloResponse.
     * 
     * @param codiceEsito
     */
    public void setCodiceEsito(java.lang.String codiceEsito) {
        this.codiceEsito = codiceEsito;
    }

    /**
     * Sets the descrizioneEsito value for this ChiusuraFascicoloResponse.
     * 
     * @param descrizioneEsito
     */
    public void setDescrizioneEsito(java.lang.String descrizioneEsito) {
        this.descrizioneEsito = descrizioneEsito;
    }

    @Override
	public String toString() {
		return "{\"ChiusuraFascicoloResponse\": {\"codiceEsito\" :\""+codiceEsito+"\""
				+ ", \"descrizioneEsito\":\""+descrizioneEsito +"\"}}";
	}

}
