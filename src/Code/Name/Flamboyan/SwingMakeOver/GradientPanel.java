/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.*;
import javax.swing.JPanel;

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
 * Program Intentity : Code Name : Code Created on Jan 7, 2012, 8:33:25 AM
 * @author PresdirTendy
 */
public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        Paint paint = new LinearGradientPaint(0, 0, getWidth(), getHeight(), new float[]{
                    0F,
                    0.3F,
                    0.6F,
                    0.9F,
                    1F}, new Color[]{
                    Color.RED,
                    Color.BLUE,
                    Color.CYAN,
                    Color.YELLOW,
                    Color.MAGENTA
                });

        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
