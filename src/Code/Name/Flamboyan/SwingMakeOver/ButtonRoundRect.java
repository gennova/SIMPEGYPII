/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

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
 * Program Intentity : Code Name : Code Created on Jan 7, 2012, 7:47:32 AM
 * @author PresdirTendy
 */
public class ButtonRoundRect extends JButton {

    private Paint paint;
    private Shape shape;
    private Paint glass;
    private boolean over;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public ButtonRoundRect() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);


        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();

        paint = new GradientPaint(0, 0, Color.MAGENTA, 0, getHeight(), Color.GREEN);
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        if (isOver()) {
            glass = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0F), 0, getHeight(), new Color(1F, 1F, 1F, 0.5F));
        } else {
            glass = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F, 1F, 1F, 0F));
        }

        gd.setPaint(paint);
        gd.fill(shape);
        gd.setPaint(glass);
        gd.fill(shape);
        gd.dispose();
        super.paintComponent(g);


    }
}
