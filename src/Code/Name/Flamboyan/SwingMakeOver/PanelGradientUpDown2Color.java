/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
 * Success is My Journey not a Destination :) DILARANG MENGHAPUS ATAU MENGEDIT
 * COPYRIGHT INI.
 *
 * Copyright 2011 serendipity.10they@gmail.com. Licensed GNU/GPL All rights
 * reserved.
 *
 * Semua isi dalam file ini adalah hak milik dari Presdir Atanasius Tendy. Anda
 * tidak diperkenankan untuk menggunakan file atau mengubah file ini kecuali
 * anda tidak menghapus atau merubah Lisensi ini.
 *
 * File ini dibuat menggunakan : IDE : NetBeans 7.0.1 NoteBook : Asus K42Jc
 * Versatile Performance OS : Windows 7 Ultimate Java : Java 1.7
 *
 * Program Intentity : Code Name : Code Created on Jan 9, 2012, 10:55:26 AM
 * @author PresdirTendy
 */
public class PanelGradientUpDown2Color extends JPanel {

    public PanelGradientUpDown2Color() {
        setOpaque(false);
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        Graphics2D g2 = (Graphics2D) g.create();
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50);
        int x1 = getWidth() / 2;
        int y1 = 0;
        int x2 = getWidth() / 2;
        int y2 = getHeight();

        Paint paint = new GradientPaint(x1, y1, new Color(205, 105, 30), x2, y2, Color.DARK_GRAY);
        g2.setPaint(paint);
        g2.fill(shape);
        g2.draw(shape);

        g2.dispose();
    }
}
