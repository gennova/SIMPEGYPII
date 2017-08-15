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
public class PegawaiTabelModelUltah extends AbstractTableModel {

    private final List<Pegawai> listpegawai;

    public PegawaiTabelModelUltah(List<Pegawai> list) {
        this.listpegawai = list;
    }

    @Override
    public int getRowCount() {
        return listpegawai.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case (0):
                return "NUK";
            case (1):
                return "Nama Pegawai";
            case (2):
                return "tanggal Lahir";
            case (3):
                return "Bidang Kerja";
            case (4):
                return "Unit";
            case (5):
                return "Cabang";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return listpegawai.get(rowIndex).getNUK();
            case (1):
                return listpegawai.get(rowIndex).getNama();
            case (2):
                return listpegawai.get(rowIndex).getTglLahir();
            case (3):
                return listpegawai.get(rowIndex).getPekerjaanJabatan().getBk().getNamabidangkerja();
            case (4):
                return listpegawai.get(rowIndex).getPekerjaanJabatan().getUnit().getNamaUnit();
            case (5):
                return listpegawai.get(rowIndex).getPekerjaanJabatan().getCabang().getNamacabang();
            default:
                return null;
        }
    }

}
