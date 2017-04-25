/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

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
 * Code Created on Jan 9, 2012, 10:08:46 AM
 * @author PresdirTendy
 */
public class PanelGlass extends JPanel{
    
    private Paint paint;
    private Shape shape;
    private Color warna;

    public PanelGlass() {
        setOpaque(false);
        warna = new Color(1F, 1F, 1F, 0.5F);
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D gd =(Graphics2D) g.create();
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30);
        gd.setColor(warna);
        gd.fill(shape);       
        
        gd.dispose();
    }
    
}
