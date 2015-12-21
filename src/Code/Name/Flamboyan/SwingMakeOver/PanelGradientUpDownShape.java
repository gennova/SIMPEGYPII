/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
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
 * Code Created on Feb 4, 2012, 8:16:19 PM
 * @author PresdirTendy
 */
public class PanelGradientUpDownShape extends JPanel{

    public PanelGradientUpDownShape() {
        this.setOpaque(false);
    }

   

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x1 = getWidth() / 2;
        int y1 = 0;
        int x2 = getWidth() / 2;
        int y2 = getHeight();
        Graphics2D gd = (Graphics2D) g.create();
        Shape s = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        Paint paint = new GradientPaint(x1, y1, Color.WHITE, x2, y2, Color.BLUE);
        gd.setPaint(paint);
        gd.fill(s);
        gd.draw(s);
        
        
        gd.dispose();
    }

    
}
