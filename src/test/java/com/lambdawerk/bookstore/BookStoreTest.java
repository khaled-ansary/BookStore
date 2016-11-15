
package com.lambdawerk.bookstore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khaled
 */
public class BookStoreTest {
   
    private String inputFile, outputFile;
    
    public BookStoreTest() {
        this.inputFile = "books.xml";
        this.outputFile = "output.xml";
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }
   
    /**
     * Test of main method, of class BookStore.
     */
    @org.junit.Test
    public void testMain() {
        String []args = {System.getProperty("user.dir") +"\\" + getInputFile(), 
                         System.getProperty("user.dir") +"\\" + getOutputFile()};
        
        BookStore.main(args);
    
    }
    
}
