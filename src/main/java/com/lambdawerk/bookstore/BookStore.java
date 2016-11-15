
package com.lambdawerk.bookstore;

import com.lambdawerk.inputmodel.Genre;
import com.lambdawerk.xmlparser.XMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khaled
 */
public class BookStore {
    
    public static void main(String args[]){
        XMLParser xml_parser = new XMLParser();
       
        try {
            
            Path path = Paths.get(args[0]);
            byte[] data = Files.readAllBytes(path);
            ByteArrayInputStream in = new ByteArrayInputStream(data); 
            Map<String, List<Genre>> genres = xml_parser.parseInputXML(in);
            String fileExtension=xml_parser.getFileExtension(args[0]);
            if(fileExtension.equals("xml")){
                xml_parser.processOutputXML(genres, args[1]);
            }else{
                System.out.println("please choose a xml file");
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(BookStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
