/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author laravel
 */
public class StripedRowTableCellRenderer extends DefaultTableCellRenderer {

    private static final Color STRIPE = Color.WHITE;
    private static final Color WHITE = Color.getHSBColor(134, 50, 150);

    private final JCheckBox ckb = new JCheckBox();

    public StripedRowTableCellRenderer() {
        setOpaque(true); //MUST do this for background to show up.
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent c = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            if (row % 2 == 0) {
                c.setBackground(WHITE);
            } else {
                c.setBackground(STRIPE);
            }
        }

        if (value instanceof Boolean) { // Boolean
            ckb.setSelected(((Boolean) value));
            ckb.setHorizontalAlignment(JLabel.CENTER);
            ckb.setBackground(super.getBackground());
            if (isSelected || hasFocus) {
                ckb.setBackground(table.getSelectionBackground());
            }
            return ckb;
        }

        return c;
    }
}
