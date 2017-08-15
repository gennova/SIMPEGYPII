/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pegawai;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class PegawaiTabelModelUltahSimple extends AbstractTableModel {

    private final List<Pegawai> listpegawai;

    public PegawaiTabelModelUltahSimple(List<Pegawai> list) {
        this.listpegawai = list;
    }

    @Override
    public int getRowCount() {
        return listpegawai.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case (0):
                return "Nama Pegawai";
            case (1):
                return "tanggal Lahir";
            case (2):
                return "Unit";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return listpegawai.get(rowIndex).getNama();
            case (1):
                return listpegawai.get(rowIndex).getTglLahir();
            case (2):
                return listpegawai.get(rowIndex).getPekerjaanJabatan().getUnit().getNamaUnit();
            default:
                return null;
        }
    }

}
