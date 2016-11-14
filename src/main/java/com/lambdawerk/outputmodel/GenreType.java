
package com.lambdawerk.outputmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genreType", propOrder = {
    "title"
})

/**
 *
 *  @author Khaled
 * 
 *  output xml model class to get genre data
 */

public class GenreType {

    protected List<String> title;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "average_price")
    protected Float averagePrice;
    public List<String> getTitle() {
        if (title == null) {
            title = new ArrayList<String>();
        }
        return this.title;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Float value) {
        this.averagePrice = value;
    }

}
