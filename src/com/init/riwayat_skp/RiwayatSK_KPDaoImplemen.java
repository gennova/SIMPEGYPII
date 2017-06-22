/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayat_skp;

import com.init.tools.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amnesia
 */
public class RiwayatSK_KPDaoImplemen implements RiwayatSK_KPDao {

    private final Connection connection;
    private final String sqlGetAllSk_KP = "select * from riwayat_skp where nuk=?";

    public RiwayatSK_KPDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<RiwayatSK_KP> getALlSK_KPByNUK(String nuk) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<RiwayatSK_KP> lists = null;
        try {
            statement = connection.prepareStatement(sqlGetAllSk_KP);
            statement.setString(1, nuk);
            rs = statement.executeQuery();
            lists = new ArrayList<RiwayatSK_KP>();
            while (rs.next()) {
                RiwayatSK_KP pangkat = new RiwayatSK_KP();
                pangkat.setId(rs.getInt("id"));
                pangkat.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                pangkat.setGolongan(DaoFactory.getGolonganDao().getGolonganByID(rs.getInt("idgolongan")));
                pangkat.setTmt_golongan(rs.getString("tmt_golongan"));
                pangkat.setNomor_sk(rs.getString("nomor_sk"));
                pangkat.setTanggal_sk(rs.getString("tanggal_sk"));
                pangkat.setTmt_kgb(rs.getString("tmt_kgb"));
                pangkat.setNomor_kgb(rs.getString("nomor_kgb"));
                pangkat.setTgl_kgb(rs.getString("tanggal_kgb"));
                pangkat.setTahun_kerja(rs.getInt("tahunkerja"));
                pangkat.setBulan_kerja(rs.getInt("bulankerja"));
                pangkat.setTahun_kerja_benar(rs.getInt("tahunkerjabenar"));
                pangkat.setBulan_kerja_benar(rs.getInt("bulankerjabenar"));
                pangkat.setTmt_golongan_indo(rs.getString("tmt_golongan_indo"));
                pangkat.setTanggal_sk_indo(rs.getString("tanggal_sk_indo"));
                pangkat.setTmt_kgb_indo(rs.getString("tmt_kgb_indo"));
                pangkat.setTmt_kgb_indo(rs.getString("tanggal_kgb_indo"));
                pangkat.setRuang(rs.getString("ruang"));
                pangkat.setGaji_str(rs.getString("gaji"));
                pangkat.setKeterangan(rs.getString("keterangan"));
                pangkat.setTrack(rs.getString("tracking"));
                lists.add(pangkat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatSK_KPDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

}
