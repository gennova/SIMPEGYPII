/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pegawai;

import com.init.tools.DaoFactory;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class PegawaiTabelModelDetil extends AbstractTableModel {

    private final List<Pegawai> listpegawai;

    public PegawaiTabelModelDetil(List<Pegawai> list) {
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
                return "Jenis Kelamin";
            case (3):
                return "Tanggal Lahir";
            case (4):
                return "Pangkat/Gol.";
            case (5):
                return "GAJI";
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
                return listpegawai.get(rowIndex).getJK();
            case (3):
                return listpegawai.get(rowIndex).getTanggalLahirIndo();
            case (4):
                return listpegawai.get(rowIndex).getPangkat().getGolongan().getNamagolongan()+ " " + listpegawai.get(rowIndex).getPangkat().getGolongan().getPangkat() + " " + listpegawai.get(rowIndex).getPangkat().getTMTGolongan_indo();
            case (5):
                return DaoFactory.getFormatRupiahIndonesiaDouble(DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(listpegawai.get(rowIndex).getNUK()).getGaji_pokok());
            default:
                return null;
        }
    }

}
