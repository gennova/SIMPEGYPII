/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.jabatan;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class JabatanTabelModel extends AbstractTableModel {

    private List<Jabatan> listes;

    public JabatanTabelModel(List<Jabatan> jabatans) {
        this.listes = jabatans;
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
    public String getColumnName(int column) {
        switch (column) {
            case (0):
                return "No.";
            case (1):
                return "Kode";
            case (2):
                return "Jabatan";
            case (3):
                return "Masa Jabatan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return rowIndex + 1;
            case (1):
                return listes.get(rowIndex).getKodejabatan();
            case (2):
                return listes.get(rowIndex).getNamajabatan();
            case (3):
                return listes.get(rowIndex).getMasajabatan();
            default:
                return null;
        }
    }

}
