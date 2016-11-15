
package com.lambdawerk.interfaces;

import com.lambdawerk.inputmodel.Genre;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khaled
 */
public interface Parser {
    public Map<String, List<Genre>> parseInputXML(InputStream in);
    public void processOutputXML(Map<String, List<Genre>> genres, String outputFile); 
}
