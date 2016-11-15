
package com.lambdawerk.xmlparser;

import com.lambdawerk.inputmodel.Book;
import com.lambdawerk.inputmodel.Catalog;
import com.lambdawerk.inputmodel.Genre;
import com.lambdawerk.inputmodel.InputFactory;
import com.lambdawerk.interfaces.Parser;
import com.lambdawerk.outputmodel.GenreType;
import com.lambdawerk.outputmodel.GenresType;
import com.lambdawerk.outputmodel.ObjectFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * process input xml and generate output xml
 * @author Khaled
 */
public class XMLParser implements Parser{
    
    private Map<String, List<Genre>> genres;
    private List<Genre> genre_list;

    /* parse input xml and generated sorted map by
       genres which contains genre name, average price
       and book title
    */
    
    @Override
    public Map<String, List<Genre>> parseInputXML(InputStream in) {
        
        Map<String, List<Genre>> sortedGenres = new HashMap<>();
        
        try{
            JAXBContext jaxbCtx = JAXBContext.newInstance(InputFactory.class);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            JAXBElement<Catalog> catalog = (JAXBElement)unmarshaller.unmarshal(in);
            List<Book> books = catalog.getValue().getBook();
            genres = new HashMap<>();
            books.stream().forEach((Book book) -> {
                if(genres.containsKey(book.getGenre())){
                    
                    genre_list = genres.get(book.getGenre());
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
                    genres.put(book.getGenre(), genre_list);                    
                }
            });            
            genres.entrySet().stream()
                .sorted(Map.Entry.<String, List<Genre>>comparingByKey())
                .forEachOrdered(x -> sortedGenres.put(x.getKey(), x.getValue()));
        }catch(Exception err){
            System.out.println(err);
        }
        return sortedGenres;
    }
    /*
        generated output xml
    */
    @Override
    public void processOutputXML(Map<String, List<Genre>> genres, String outputFile) {
        try {
            ObjectFactory output_factory = new ObjectFactory();
            GenresType genresType = output_factory.createGenresType();
            
            List<GenreType> genreList = new ArrayList<>();
            genres.forEach((genre,titles)->{
                GenreType genreType = output_factory.createGenreType();
                genreType.setName(genre);
                
                double avgPrice = 0.0;
                List<String> bookTitles = new ArrayList<>();
                for(Genre title : titles){
                    bookTitles.add(title.getTitle());
                    avgPrice += title.getPrice();
                }
                genreType.setTitle(bookTitles);
                genreType.setAveragePrice(avgPrice);
                genreList.add(genreType);
            });
            
            genresType.setGenre(genreList);
            JAXBContext context = JAXBContext.newInstance("com.lambdawerk.outputmodel");
            JAXBElement<GenresType> element = output_factory.createGenres(genresType);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
            marshaller.marshal(element,System.out);
            OutputStream output = new FileOutputStream( outputFile );
            marshaller.marshal( element, output );
            Logger.getLogger(XMLParser.class.getName()).log(Level.INFO, "output write into "+ outputFile);
            
        } catch (JAXBException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static String getFileExtension(String filename)
    {
       String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
       return extension;
    }


}
