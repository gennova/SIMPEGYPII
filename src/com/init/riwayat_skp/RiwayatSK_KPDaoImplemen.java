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
import javax.swing.JOptionPane;

/**
 *
 * @author amnesia
 */
public class RiwayatSK_KPDaoImplemen implements RiwayatSK_KPDao {

    private final Connection connection;
    private final String sqlGetAllSk_KP = "select * from riwayat_skp where nuk=?";
    private final String sqlInsertRiwayatSKP = "insert into riwayat_skp (nuk,idgolongan,tmt_golongan,nomor_sk,tanggal_sk,tmt_kgb,nomor_kgb,tanggal_kgb,tahunkerja,bulankerja,tahunkerjabenar,bulankerjabenar,tmt_golongan_indo,tanggal_sk_indo,tmt_kgb_indo,tanggal_kgb_indo,ruang,keterangan,gaji) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // 19 parameter
    private final String sqlGetRiwayatPangkatByNukLast = "select * from riwayat_skp where nuk=? and id=(select max(id) from riwayat_skp)";

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

    @Override
    public void InsertRiwayatSKPManual(RiwayatSK_KP riwayatSK_KP) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertRiwayatSKP);
            ps.setString(1, riwayatSK_KP.getPegawai().getNUK());
            ps.setInt(2, riwayatSK_KP.getGolongan().getId());
            ps.setString(3, riwayatSK_KP.getTmt_golongan());
            ps.setString(4, riwayatSK_KP.getNomor_sk());
            ps.setString(5, riwayatSK_KP.getTanggal_sk());
            ps.setString(6, riwayatSK_KP.getTmt_kgb());
            ps.setString(7, riwayatSK_KP.getNomor_kgb());
            ps.setString(8, riwayatSK_KP.getTgl_kgb());
            ps.setInt(9, riwayatSK_KP.getTahun_kerja());
            ps.setInt(10, riwayatSK_KP.getBulan_kerja());
            ps.setInt(11, riwayatSK_KP.getTahun_kerja_benar());
            ps.setInt(12, riwayatSK_KP.getBulan_kerja_benar());
            ps.setString(13, riwayatSK_KP.getTmt_golongan_indo());
            ps.setString(14, riwayatSK_KP.getTanggal_sk_indo());
            ps.setString(15, riwayatSK_KP.getTmt_kgb_indo());
            ps.setString(16, riwayatSK_KP.getTgl_kgb_indo());
            ps.setString(17, riwayatSK_KP.getRuang());
            ps.setString(18, "KP");
            ps.setString(19, riwayatSK_KP.getGaji_str());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatSK_KPDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteRiwayatSKP_Manual(int id) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("delete from riwayat_skp where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data riwayat berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatSK_KPDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public RiwayatSK_KP getRiwayatSKKP_LamaByNukLast(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        RiwayatSK_KP pangkat = null;
        try {
            ps = connection.prepareStatement(sqlGetRiwayatPangkatByNukLast);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                pangkat = new RiwayatSK_KP();
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatSK_KPDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pangkat;
    }

}
