
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

    public CatalogType createCatalogType() {
        return new CatalogType();
    }
    public BookType createBookType() {
        return new BookType();
    }
    @XmlElementDecl(namespace = "", name = "catalog")
    public JAXBElement<CatalogType> createCatalog(CatalogType value) {
        return new JAXBElement<CatalogType>(_Catalog_QNAME, CatalogType.class, null, value);
    }

}
