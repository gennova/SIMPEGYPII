/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.controller;

import com.init.entity.Golongan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Tendy Developer
 */
public class GolonganTableModel extends AbstractTableModel {

    private List<Golongan> list = new ArrayList<Golongan>();

    public GolonganTableModel(List<Golongan> list) {
        this.list = list;
    }

    public Golongan get(int row) {
        return list.get(row);
    }

    public void insert(Golongan Golongan) {
        list.add(Golongan);
        fireTableDataChanged();
    }

    public void update(int row, Golongan Golongan) {
        list.set(row, Golongan);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Golongan> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Golongan";
            case 2:
                return "Pangkat";
            default:
                return null;
        }
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKodeGolongan();
            case 1:
                return list.get(rowIndex).getGolongan();
            case 2:
                return list.get(rowIndex).getPangkat();
            default:
                return null;
        }
    }

}
