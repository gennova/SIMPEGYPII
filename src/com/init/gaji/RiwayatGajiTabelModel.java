/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.gaji;

import com.init.tools.DaoFactory;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class RiwayatGajiTabelModel extends AbstractTableModel {

    private final List<RiwayatGajiPegawai> lists;

    public RiwayatGajiTabelModel(List<RiwayatGajiPegawai> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case (0):
                return "Kode";
            case (1):
                return "Golongan";
            case (2):
                return "Ruang";
            case (3):
                return "Gaji";
            case (4):
                return "TMT";
            case (5):
                return "Nomor";
            case (6):
                return "Tanggal";
            case (7):
                return "Keterangan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return lists.get(rowIndex).getId();
            case (1):
                return lists.get(rowIndex).getPangkat().getGolongan().getNamagolongan();
            case (2):
                return lists.get(rowIndex).getPangkat().getTahun_masa_kerja();
            case (3):
                return "Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(lists.get(rowIndex).getGaji_pokok()));
            case (4):
                return lists.get(rowIndex).getTmt_lama();
            case (5):
                return lists.get(rowIndex).getNo_kgb();
            case (6):
                return lists.get(rowIndex).getTanggal();
            case (7):
                return lists.get(rowIndex).getKeterangan();
            default:
                return null;
        }
    }

}
