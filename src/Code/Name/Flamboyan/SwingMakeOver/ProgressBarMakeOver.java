/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JProgressBar;

/* Success is My Journey not a Destination :)
 * DILARANG MENGHAPUS ATAU MENGEDIT COPYRIGHT INI.
 * 
 * Copyright 2011 serendipity.10they@gmail.com. 
 * Licensed GNU/GPL
 * All rights reserved.
 * 
 * Semua isi dalam file ini adalah hak milik dari Presdir Atanasius Tendy.
 * Anda tidak diperkenankan untuk menggunakan file atau mengubah file
 * ini kecuali anda tidak menghapus atau merubah Lisensi ini.
 * 
 * File ini dibuat menggunakan :
 * IDE        : NetBeans 7.0.1
 * NoteBook   : Asus K42Jc Versatile Performance
 * OS         : Windows 7 Ultimate
 * Java       : Java 1.7
 * 
 * Program Intentity :
 * Code Name  :
 * Code Created on Jan 13, 2012, 11:37:38 PM
 * @author PresdirTendy
 */
public class ProgressBarMakeOver extends JProgressBar{

    private Shape shape;

    public ProgressBarMakeOver() {
        setForeground(Color.BLUE);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D gd = (Graphics2D) g.create();
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        gd.setColor(Color.BLUE);
        gd.fill(shape);
        
        
        gd.dispose();
    }
    
}
