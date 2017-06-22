/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayat_jabatan;

import code.init.pekerjaanjabatan.PekerjaanJabatan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class RiwayatJabatanTabelModel extends AbstractTableModel {

    private final List<PekerjaanJabatan> lists;

    public RiwayatJabatanTabelModel(List<PekerjaanJabatan> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Jabatan";
            case 2:
                return "Masa Jabatan";
            case 3:
                return "Wilayah Tugas";
            case 4:
                return "Awal";
            case 5:
                return "Akhir";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lists.get(rowIndex).getId();
            case 1:
                return lists.get(rowIndex).getJabatan().getNamajabatan();
            case 2:
                return lists.get(rowIndex).getJabatan().getMasajabatan();
            case 3:
                return lists.get(rowIndex).getCabang().getNamacabang();
            case 4:
                return lists.get(rowIndex).getTmt_awal();
            case 5:
                return lists.get(rowIndex).getTmt_akhir();
            default:
                return null;
        }
    }

}
