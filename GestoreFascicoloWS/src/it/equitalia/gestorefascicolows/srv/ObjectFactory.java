//
// Generated By:JAX-WS RI IBM 2.0_03-07/07/2008 01:00 PM(foreman)-fcs (JAXB RI IBM 2.0.5-02/25/2009 05:47 AM(foreman)-fcs)
//


package it.equitalia.gestorefascicolows.srv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.equitalia.gestorefascicolows.srv package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault_QNAME = new QName("http://srv.gestorefascicolows.equitalia.it", "Fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.equitalia.gestorefascicolows.srv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FaultType }
     * 
     */
    public FaultType createFaultType() {
        return new FaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://srv.gestorefascicolows.equitalia.it", name = "Fault")
    public JAXBElement<FaultType> createFault(FaultType value) {
        return new JAXBElement<FaultType>(_Fault_QNAME, FaultType.class, null, value);
    }

}
