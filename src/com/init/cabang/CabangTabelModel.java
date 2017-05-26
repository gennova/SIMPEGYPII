/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.cabang;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class CabangTabelModel extends AbstractTableModel {

    private List<Cabang> list = new ArrayList<Cabang>();

    public CabangTabelModel(List<Cabang> cabangs) {
        this.list = cabangs;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Kode";
            case 2:
                return "Nama Cabang";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return list.get(rowIndex).getKode();
            case 2:
                return list.get(rowIndex).getNamacabang();
            default:
                return 0;
        }
    }
}
