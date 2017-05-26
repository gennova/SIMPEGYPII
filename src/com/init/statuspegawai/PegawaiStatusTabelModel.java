/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.statuspegawai;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class PegawaiStatusTabelModel extends AbstractTableModel {

    private List<PegawaiStatus> lists;

    public PegawaiStatusTabelModel(List<PegawaiStatus> datas) {
        this.lists = datas;
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
            case (0):
                return "No.";
            case (1):
                return "Kode";
            case (2):
                return "Status";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return lists.get(rowIndex).getID();
            case (1):
                return lists.get(rowIndex).getKodeStatusPegawai();
            case (2):
                return lists.get(rowIndex).getNamaStatusPegawai();
            default:
                return null;
        }
    }
}
