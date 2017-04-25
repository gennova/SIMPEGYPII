/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * Program Intentity : Code Name : Code Created on Jan 10, 2012, 12:20:49 PM
 * @author PresdirTendy
 */
public class ButtonGradientColor extends JButton {

    private Paint paint;
    private Shape shape;
    private boolean Over;

    public boolean isOver() {
        return Over;
    }

    public void setOver(boolean Over) {
        this.Over = Over;

        repaint();
    }

    public ButtonGradientColor() {
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);

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
    protected void paintComponent(Graphics g) {

        Graphics2D gd = (Graphics2D) g.create();
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25);
        if (isOver()) {
            paint = new GradientPaint(0, 0, Color.YELLOW, getWidth(), getHeight(), Color.GREEN);
        } else {
            paint = new GradientPaint(0, 0, Color.GREEN, getWidth(), getHeight(), Color.YELLOW);
        }
        gd.setPaint(paint);
        gd.fill(shape);
        gd.dispose();
        super.paintComponent(g);

    }
}
