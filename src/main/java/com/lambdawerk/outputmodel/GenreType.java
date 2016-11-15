
package com.lambdawerk.outputmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *
 *  @author Khaled
 * 
 *  output xml model class to get genre data
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genreType", propOrder = {
    "title"
})

public class GenreType {

    protected List<String> title;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "average_price")
    protected Double averagePrice;
    public List<String> getTitle() {
        if (title == null) {
            title = new ArrayList<String>();
        }
        return this.title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double value) {
        this.averagePrice = value;
    }

}
