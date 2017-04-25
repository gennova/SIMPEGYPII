/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * Program Intentity : Code Name : Code Created on Jan 6, 2012, 8:48:25 AM
 * @author PresdirTendy
 */
public class PanelAlphaRect extends JPanel {

    private Color warna;
    private Paint paint;
    private boolean over;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        
        repaint();
    }

    public PanelAlphaRect() {
        setOpaque(false);
//        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 100);
       

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setOver(false);
            }
        });
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);

        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 100);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();
        if (isOver()) {
             paint = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), getWidth(), getHeight(), new Color(1F, 1F, 1F, 0));
        }else{
             paint = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0F), getWidth(), getHeight(), new Color(1F, 1F, 1F, 0.5F));
        }
        gd.setPaint(paint);
//        gd.setColor(warna);
        gd.fillRect(0, 0, getWidth(), getHeight());

        gd.dispose();
    }
}
