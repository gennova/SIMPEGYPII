/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import com.init.tools.DaoFactory;
import java.util.List;

/**
 *
 * @author amnesia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(DaoFactory.FormatTanggalIndonesia("2020-02-27"));
    }

}
