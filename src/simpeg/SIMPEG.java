/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpeg;

import com.init.tools.PrintReport;

/**
 *
 * @author Tendy Developer
 */
public class SIMPEG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new PrintReport("./report/surat_pengangkatan.jasper", "nuknya", "2000");
    }
}
