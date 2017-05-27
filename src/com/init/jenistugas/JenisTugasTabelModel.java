/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.jenistugas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class JenisTugasTabelModel extends AbstractTableModel {

    private List<JenisTugas> list;

    public JenisTugasTabelModel(List<JenisTugas> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
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
                return "Jenis Tugas";
            case (3):
                return "Skor";
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
                return list.get(rowIndex).getKode();
            case (2):
                return list.get(rowIndex).getJenistugas();
            case (3):
                return list.get(rowIndex).getSkor();
            default:
                return null;
        }
    }

}
