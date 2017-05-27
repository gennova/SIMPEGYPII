/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ijazah;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class IjazahTabelModel extends AbstractTableModel {

    private final List<IjazahAngkat> lists;

    public IjazahTabelModel(List<IjazahAngkat> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case (1):
                return "No.";
            case (2):
                return "Kode";
            case (3):
                return "Ijazah Pengangkatan";
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
                return lists.get(rowIndex).getKodeIjazahPengangkatan();
            case (2):
                return lists.get(rowIndex).getNamaIjazahPengangkatan();
            default:
                return null;
        }
    }

}
