
package com.lambdawerk.interfaces;

import java.io.InputStream;

/**
 *
 * @author Khaled
 */
public interface Parser {
    public void parseInputXML(InputStream in);
    public void getOutputXML(String outputFile); 
}
