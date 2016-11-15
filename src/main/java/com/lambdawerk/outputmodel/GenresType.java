


package com.lambdawerk.outputmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 *  @author Khaled
 * 
 *  output xml model class to get list of genres
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genresType", propOrder = {
    "genre"
})

public class GenresType {

    protected List<GenreType> genre;

    public List<GenreType> getGenre() {
        if (genre == null) {
            genre = new ArrayList<GenreType>();
        }
        return this.genre;
    }

    public void setGenre(List<GenreType> genre) {
        this.genre = genre;
    }

}
