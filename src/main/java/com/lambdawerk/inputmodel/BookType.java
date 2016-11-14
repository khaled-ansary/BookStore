
package com.lambdawerk.inputmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookType", propOrder = {
    "author",
    "title",
    "genre",
    "price",
    "publishDate",
    "description"
})

/**
 *
 *  @author Khaled
 * 
 *  input xml model class to get book informations
 */
public class BookType {

    @XmlElement(required = true)
    protected String author;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String genre;
    protected float price;
    @XmlElement(name = "publish_date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar publishDate;
    @XmlElement(required = true)
    protected String description;
    @XmlAttribute(name = "id")
    protected String id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String value) {
        this.author = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String value) {
        this.genre = value;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float value) {
        this.price = value;
    }
    public XMLGregorianCalendar getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(XMLGregorianCalendar value) {
        this.publishDate = value;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        this.description = value;
    }
    public String getId() {
        return id;
    }
    public void setId(String value) {
        this.id = value;
    }

}
