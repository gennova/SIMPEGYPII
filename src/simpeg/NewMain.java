/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpeg;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author amnesia
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // class that opens the printer as a file
// and writes "Hello World" to it 

        try {
            FileOutputStream os = new FileOutputStream("LPT1");
            //wrap stream in "friendly" PrintStream
            PrintStream ps = new PrintStream(os);

            //print text here
            ps.println("Hello world!");

            //form feed -- this is important
            //Without the form feed, the text will simply sit
            // in print buffer until something else gets printed.
            ps.print("\f");
            //flush buffer and close
            ps.close();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
    }
}
