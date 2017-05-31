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
        DaoFactory.getConnectionFix();
        List<com.init.cabang.Cabang> lists = DaoFactory.getCabangDao().getAllCabang();
        System.out.println(lists.size());
    }
    
}
