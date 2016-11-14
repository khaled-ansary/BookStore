
package com.lambdawerk.xmlparser;

import com.lambdawerk.inputmodel.BookType;
import com.lambdawerk.inputmodel.CatalogType;
import com.lambdawerk.inputmodel.Genre;
import com.lambdawerk.inputmodel.InputFactory;
import com.lambdawerk.interfaces.Parser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Khaled
 */
public class XMLParser implements Parser{
    
    private static Map<String, List<Genre>> genres;
    private List<Genre> genre_list;

    @Override
    public void parseInputXML(InputStream in) {
        try{
            JAXBContext jaxbCtx = JAXBContext.newInstance(InputFactory.class);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            JAXBElement<CatalogType> catalog = (JAXBElement)unmarshaller.unmarshal(in);
            List<BookType> books = catalog.getValue().getBook();
            genres = new HashMap<>();
            books.stream().forEach((BookType book) -> {
                if(genres.containsKey(book.getTitle())){
                    
                    genre_list = genres.get(book.getTitle());
                    Genre genre = new Genre();
                    genre.setTitle(book.getTitle());
                    genre.setPrice(book.getPrice());
                    genre_list.add(genre);
                }else{         
                    
                    genre_list = new ArrayList<>();
                    Genre genre = new Genre();
                    genre.setTitle(book.getTitle());
                    genre.setPrice(book.getPrice());
                    genre_list.add(genre);
                    genres.put(book.getTitle(), genre_list);                    
                }
            });            
        }catch(Exception err){
            System.out.println(err);
        }
    }

    @Override
    public void getOutputXML(String outputFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
