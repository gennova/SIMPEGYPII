/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
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
 * Code Created on Jan 7, 2012, 5:31:13 AM
 * @author PresdirTendy
 */
public class PanelHeader extends JPanel{

    private Image image;
    
    public PanelHeader() {
        image = new ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/Header.jpg")).getImage();
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D gd = (Graphics2D) g.create();
//        gd.setComposite(AlphaComposite.SrcOver.derive(0.5F));
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }

    
}
