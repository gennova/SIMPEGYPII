/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayat_skp;

import com.init.tools.DaoFactory;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amnesia
 */
public class RiwayatSK_KP_TabelModel extends AbstractTableModel {

    private final List<RiwayatSK_KP> lists;

    public RiwayatSK_KP_TabelModel(List<RiwayatSK_KP> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Gol";
            case 2:
                return "Pangkat";
            case 3:
                return "TMT";
            case 4:
                return "Nomor";
            case 5:
                return "Tanggal";
            case 6:
                return "Ruang";
            case 7:
                return "Gaji";
            case 8:
                return "Ket";
            case 9:
                return "Tanggal";
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
                return lists.get(rowIndex).getGolongan().getNamagolongan();
            case 2:
                return lists.get(rowIndex).getGolongan().getPangkat();
            case 3:
                return lists.get(rowIndex).getTmt_golongan();
            case 4:
                return lists.get(rowIndex).getNomor_sk();
            case 5:
                return lists.get(rowIndex).getTanggal_sk();
            case 6:
                return lists.get(rowIndex).getRuang();
            case 7:
                return lists.get(rowIndex).getGaji_str();
            case 8:
                return lists.get(rowIndex).getKeterangan();
            case 9:
                return lists.get(rowIndex).getTrack();
            default:
                return null;
        }
    }

}
