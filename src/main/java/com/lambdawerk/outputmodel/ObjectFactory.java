
package com.lambdawerk.outputmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * 
 * @author Khaled
 * 
 * Create a new ObjectFactory that can be used to create new instances of schema
 * derived classes for package: com.lambdawerk.outputmodel
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Genres_QNAME = new QName("", "genres");
    public ObjectFactory() {
    }

    public GenresType createGenresType() {
        return new GenresType();
    }

    public GenreType createGenreType() {
        return new GenreType();
    }

    @XmlElementDecl(namespace = "", name = "genres")
    public JAXBElement<GenresType> createGenres(GenresType value) {
        return new JAXBElement<GenresType>(_Genres_QNAME, GenresType.class, null, value);
    }

}
