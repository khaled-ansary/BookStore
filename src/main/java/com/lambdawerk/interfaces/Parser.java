
package com.lambdawerk.interfaces;

import java.io.InputStream;

/**
 *
 * @author Khaled
 */
public interface Parser {
    public void parseInputXML(InputStream in);
    public void getOutputXML(String outputFile);
    public void avgPrice();
    public void sortTitle();
    public double getAvgPrice();
    public double getSortedTitle();
}
