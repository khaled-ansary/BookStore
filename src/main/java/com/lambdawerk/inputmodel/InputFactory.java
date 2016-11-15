
package com.lambdawerk.inputmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * 
 * @author Khaled
 * 
 * Create a new ObjectFactory that can be used to create new instances of schema
 * derived classes for package: com.lambdawerk.inputmodel
 * 
 */

@XmlRegistry
public class InputFactory {

    private final static QName _Catalog_QNAME = new QName("", "catalog");

    public InputFactory() {
    }

    public Catalog createCatalogType() {
        return new Catalog();
    }
    public Book createBookType() {
        return new Book();
    }
    @XmlElementDecl(namespace = "", name = "catalog")
    public JAXBElement<Catalog> createCatalog(Catalog value) {
        return new JAXBElement<Catalog>(_Catalog_QNAME, Catalog.class, null, value);
    }

}
