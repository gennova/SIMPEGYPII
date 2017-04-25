/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

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
 * Program Intentity : Code Name : Code Created on Jan 8, 2012, 3:36:38 AM
 * @author PresdirTendy
 */
public class RenderBackgroundWarnaTree extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        JLabel label = new JLabel();
        label.setText(value.toString());
        label.setOpaque(true);

        label.setFont(label.getFont().deriveFont(20F));
        if (selected) {
            label.setBackground(Color.BLUE);
        } else {
            if (row % 2 == 1) {
                label.setBackground(Color.RED);
            } else {
                label.setBackground(Color.GREEN);
            }
        }

        return label;
    }
}
