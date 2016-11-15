
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
 * Main class
 * @author Khaled
 */
public class BookStore {
    
    public static void main(String args[]){
        
        XMLParser xml_parser = new XMLParser();
       
        try {
            if(args.length<2){
                Logger.getLogger(BookStore.class.getName()).log(Level.INFO,"Please give input and output filename as args");
                return;
            }
            // get input file
            Path path = Paths.get(args[0]);  
            byte[] data = Files.readAllBytes(path);
            ByteArrayInputStream in = new ByteArrayInputStream(data); 
            // parse input xml file and generated sorted map
            Map<String, List<Genre>> genres = xml_parser.parseInputXML(in); 
            String fileExtension=XMLParser.getFileExtension(args[0]); 
            if(genres == null){
                Logger.getLogger(BookStore.class.getName()).log(Level.INFO,"Input XML format is not correct");               
            }else{
                if(!fileExtension.equals("xml") ){
                    Logger.getLogger(BookStore.class.getName()).log(Level.INFO,"please choose a xml file");
                }else{ 
                    //process sorted map to expected xml output
                    xml_parser.processOutputXML(genres, args[1]);
                }
            }            
        } catch (IOException ex) {
            Logger.getLogger(BookStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
