/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.golongan;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class GolonganTabelModel extends AbstractTableModel {

    private final List<Golongan> listes;

    public GolonganTabelModel(List<Golongan> datas) {
        this.listes = datas;
    }

    @Override
    public int getRowCount() {
        return listes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return rowIndex + 1;
            case (1):
                return listes.get(rowIndex).getKode();
            case (2):
                return listes.get(rowIndex).getNamagolongan();
            case (3):
                return listes.get(rowIndex).getPangkat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case (0):
                return "No.";
            case (1):
                return "Kode";
            case (2):
                return "Golongan";
            case (3):
                return "Pangkat";
            default:
                return null;
        }
    }

}
