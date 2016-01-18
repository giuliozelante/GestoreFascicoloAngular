package it.equitalia.gestorefascicolows.dati;

import java.util.ArrayList;

public class DataValueWrapper implements java.io.Serializable {
    private java.lang.Integer dataValueId;

    private java.lang.Integer dataTypeId;

    private java.lang.String dataTypeDescr;

    private java.lang.String renderingType;

    private java.lang.String titleCssClass;

    private java.lang.String valueCssClass;

    private java.lang.String value;

    private java.lang.Integer parentDataTypeId;	//aggiunta
    
    private it.equitalia.gestorefascicolows.dati.DataValueWrapper[] detailDataValues;
    
    private ArrayList<it.equitalia.gestorefascicolows.dati.DataValueWrapper> detailDataValuesList = new ArrayList<DataValueWrapper>();

    //inizio 2041_08_18 modifica_1
    private java.lang.String fascicoloId; 
    
    private java.lang.String callerId;
    
    private int persistence;
    //fine 2041_08_18 modifica_1

    public DataValueWrapper() {
    }

    public DataValueWrapper(
           java.lang.Integer dataValueId,
           java.lang.Integer dataTypeId,
           java.lang.String dataTypeDescr,
           java.lang.String renderingType,
           java.lang.String titleCssClass,
           java.lang.String valueCssClass,
           java.lang.String value ) {
           this.dataValueId = dataValueId;
           this.dataTypeId = dataTypeId;
           this.dataTypeDescr = dataTypeDescr;
           this.renderingType = renderingType;
           this.titleCssClass = titleCssClass;
           this.valueCssClass = valueCssClass;
           this.value = value; 
    }


    /**
     * Gets the dataValueId value for this DataValue.
     * 
     * @return dataValueId
     */
    public java.lang.Integer getDataValueId() {
        return dataValueId;
    }


    /**
     * Sets the dataValueId value for this DataValue.
     * 
     * @param dataValueId
     */
    public void setDataValueId(java.lang.Integer dataValueId) {
        this.dataValueId = dataValueId;
    }


    /**
     * Gets the dataTypeId value for this DataValue.
     * 
     * @return dataTypeId
     */
    public java.lang.Integer getDataTypeId() {
        return dataTypeId;
    }


    /**
     * Sets the dataTypeId value for this DataValue.
     * 
     * @param dataTypeId
     */
    public void setDataTypeId(java.lang.Integer dataTypeId) {
        this.dataTypeId = dataTypeId;
    }


    /**
     * Gets the dataTypeDescr value for this DataValue.
     * 
     * @return dataTypeDescr
     */
    public java.lang.String getDataTypeDescr() {
        return dataTypeDescr;
    }


    /**
     * Sets the dataTypeDescr value for this DataValue.
     * 
     * @param dataTypeDescr
     */
    public void setDataTypeDescr(java.lang.String dataTypeDescr) {
        this.dataTypeDescr = dataTypeDescr;
    }


    /**
     * Gets the renderingType value for this DataValue.
     * 
     * @return renderingType
     */
    public java.lang.String getRenderingType() {
        return renderingType;
    }


    /**
     * Sets the renderingType value for this DataValue.
     * 
     * @param renderingType
     */
    public void setRenderingType(java.lang.String renderingType) {
        this.renderingType = renderingType;
    }


    /**
     * Gets the titleCssClass value for this DataValue.
     * 
     * @return titleCssClass
     */
    public java.lang.String getTitleCssClass() {
        return titleCssClass;
    }


    /**
     * Sets the titleCssClass value for this DataValue.
     * 
     * @param titleCssClass
     */
    public void setTitleCssClass(java.lang.String titleCssClass) {
        this.titleCssClass = titleCssClass;
    }


    /**
     * Gets the valueCssClass value for this DataValue.
     * 
     * @return valueCssClass
     */
    public java.lang.String getValueCssClass() {
        return valueCssClass;
    }


    /**
     * Sets the valueCssClass value for this DataValue.
     * 
     * @param valueCssClass
     */
    public void setValueCssClass(java.lang.String valueCssClass) {
        this.valueCssClass = valueCssClass;
    }


    /**
     * Gets the value value for this DataValue.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }

    
    
    
   
    public java.lang.Integer getParentDataTypeId() {
		return parentDataTypeId;
	}

	public void setParentDataTypeId(java.lang.Integer parentDataTypeId) {
		this.parentDataTypeId = parentDataTypeId;
	}

	/**
     * Sets the value value for this DataValue.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the detailDataValues value for this DataValue.
     * 
     * @return detailDataValues
     */
    public it.equitalia.gestorefascicolows.dati.DataValueWrapper[] getDetailDataValues() {
        return detailDataValues;
    }


    /**
     * Sets the detailDataValues value for this DataValue.
     * 
     * @param detailDataValues
     */
    public void setDetailDataValues(it.equitalia.gestorefascicolows.dati.DataValueWrapper[] detailDataValues) {
        this.detailDataValues = detailDataValues;
    }

    public it.equitalia.gestorefascicolows.dati.DataValueWrapper getDetailDataValues(int i) {
        return this.detailDataValues[i];
    }

    public void setDetailDataValues(int i, it.equitalia.gestorefascicolows.dati.DataValueWrapper _value) {
        this.detailDataValues[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataValue)) return false;
        DataValue other = (DataValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataValueId==null && other.getDataValueId()==null) || 
             (this.dataValueId!=null &&
              this.dataValueId.equals(other.getDataValueId()))) &&
            ((this.dataTypeId==null && other.getDataTypeId()==null) || 
             (this.dataTypeId!=null &&
              this.dataTypeId.equals(other.getDataTypeId()))) &&
            ((this.dataTypeDescr==null && other.getDataTypeDescr()==null) || 
             (this.dataTypeDescr!=null &&
              this.dataTypeDescr.equals(other.getDataTypeDescr()))) &&
            ((this.renderingType==null && other.getRenderingType()==null) || 
             (this.renderingType!=null &&
              this.renderingType.equals(other.getRenderingType()))) &&
            ((this.titleCssClass==null && other.getTitleCssClass()==null) || 
             (this.titleCssClass!=null &&
              this.titleCssClass.equals(other.getTitleCssClass()))) &&
            ((this.valueCssClass==null && other.getValueCssClass()==null) || 
             (this.valueCssClass!=null &&
              this.valueCssClass.equals(other.getValueCssClass()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.detailDataValues==null && other.getDetailDataValues()==null) || 
             (this.detailDataValues!=null &&
              java.util.Arrays.equals(this.detailDataValues, other.getDetailDataValues())));
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
        if (getDataValueId() != null) {
            _hashCode += getDataValueId().hashCode();
        }
        if (getDataTypeId() != null) {
            _hashCode += getDataTypeId().hashCode();
        }
        if (getDataTypeDescr() != null) {
            _hashCode += getDataTypeDescr().hashCode();
        }
        if (getRenderingType() != null) {
            _hashCode += getRenderingType().hashCode();
        }
        if (getTitleCssClass() != null) {
            _hashCode += getTitleCssClass().hashCode();
        }
        if (getValueCssClass() != null) {
            _hashCode += getValueCssClass().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getDetailDataValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDetailDataValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDetailDataValues(), i);
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
        new org.apache.axis.description.TypeDesc(DataValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataValueId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataValueId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataTypeDescr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataTypeDescr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renderingType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "renderingType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titleCssClass");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "titleCssClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueCssClass");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "valueCssClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detailDataValues");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "detailDataValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dati.gestorefascicolows.equitalia.it", "dataValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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

	public void addDetailDataValues(DataValueWrapper dataValue) {
		detailDataValuesList.add(dataValue); 
	}

//	public ArrayList<it.equitalia.gestorefascicolows.dati.DataValue> getDetailDataValuesList() {
//		return detailDataValuesList;
//	}
//
//	public void setDetailDataValuesList(
//			ArrayList<it.equitalia.gestorefascicolows.dati.DataValue> detailDataValuesList) {
//		this.detailDataValuesList = detailDataValuesList;
//	}

	public void refreshDetailDataValues() {
		 setDetailDataValues( detailDataValuesList.toArray( new DataValueWrapper[0]  )  );
		
	}

    //inizio 2041_08_18 modifica_1
	public java.lang.String getFascicoloId() {
		return fascicoloId;
	}

	public void setFascicoloId(java.lang.String fascicoloId) {
		this.fascicoloId = fascicoloId;
	}

	public java.lang.String getCallerId() {
		return callerId;
	}

	public void setCallerId(java.lang.String callerId) {
		this.callerId = callerId;
	}

	public int isPersistence() {
		return persistence;
	}

	public void setPersistence(int persistence) {
		this.persistence = persistence;
	}
    //fine 2041_08_18 modifica_1

	
	
}
