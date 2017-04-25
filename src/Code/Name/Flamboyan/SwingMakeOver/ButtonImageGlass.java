/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * Program Intentity : Code Name : Code Created on Jan 7, 2012, 7:27:16 AM
 * @author PresdirTendy
 */
public class ButtonImageGlass extends JButton {

    private Paint paint;
    private Paint glass;
    private boolean over;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public ButtonImageGlass() {
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.BLUE);
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
        paint = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), getWidth(), getHeight(), new Color(1F, 1F, 1F, 0));
        gd.setPaint(paint);
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        if (isOver()) {
            glass = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0F), 0, getHeight(), new Color(1F, 1F, 1F, 0.5F));
        } else {
            glass = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F, 1F, 1F, 0F));
        }
        gd.setPaint(glass);
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        gd.dispose();
        super.paintComponent(g);

    }
}
