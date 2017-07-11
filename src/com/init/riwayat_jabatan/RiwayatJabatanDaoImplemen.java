/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayat_jabatan;

import com.init.tools.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amnesia
 */
public class RiwayatJabatanDaoImplemen implements RiwayatJabatanDao {

    private final Connection connection;
    private final static String sqlGetRiwayatJabatanBy = "select * from riwayat_jabatan where nuk=? and idjabatan=?";
    private final static String sqlInsertRiwayatPekerjaanManual = "insert into riwayat_jabatan (nuk,idbidangkerja,tmt_tanggal_pekerjaan,no_sk_pekerjaan,tgl_sk_pekerjaan,idcabang,idunit,idjabatan,nama_jabatan,masa_jabatan,tmt_tanggal_pekerjaan_indo,tgl_sk_pekerjaan_indo,tmt_awal,tmt_akhir) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static String sqlDeleteRiwayatJabatabByID = "delete from riwayat_jabatan where id=?";
    private static String sqlGetRiwayatByID = "select * from riwayat_jabatan where id=?";
    private final static String sqlUpdateRiwayatPekerjaanManual = "update riwayat_jabatan set nuk=?,idbidangkerja=?,tmt_tanggal_pekerjaan=?,no_sk_pekerjaan=?,tgl_sk_pekerjaan=?,idcabang=?,idunit=?,idjabatan=?,nama_jabatan=?,masa_jabatan=?,tmt_tanggal_pekerjaan_indo=?,tgl_sk_pekerjaan_indo=?,tmt_awal=?,tmt_akhir=? where id=?";

    public RiwayatJabatanDaoImplemen(Connection conn) {
        this.connection = conn;
    }

    @Override
    public void InsertRiwayatJabatan(RiwayatJabatan jabatan) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertRiwayatPekerjaanManual);
            ps.setString(1, jabatan.getPegawai().getNUK());
            ps.setInt(2, jabatan.getBk().getId());
            ps.setString(3, jabatan.getTglTMTPekerjaan());
            ps.setString(4, jabatan.getNomorSKPekerjaan());
            ps.setString(5, jabatan.getTglSKPekerjaan());
            ps.setInt(6, jabatan.getCabang().getIdCabang());
            ps.setInt(7, jabatan.getUnit().getID());
            ps.setInt(8, jabatan.getJabatan().getId());
            ps.setString(9, jabatan.getNamaJabatan());
            ps.setInt(10, jabatan.getMasaJabatan());
            ps.setString(11, jabatan.getTglTMTPekerjaan_indo());
            ps.setString(12, jabatan.getTglSKPekerjaan_indo());
            ps.setString(13, jabatan.getTmt_awal());
            ps.setString(14, jabatan.getTmt_akhir());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data riwayat berhasil dimasukkkan");
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<RiwayatJabatan> getALlRiwayatJabatan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRiwayaJabatan(RiwayatJabatan riwayatJabatan) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateRiwayatPekerjaanManual);
            ps.setString(1, riwayatJabatan.getPegawai().getNUK());
            ps.setInt(2, riwayatJabatan.getBk().getId());
            ps.setString(3, riwayatJabatan.getTglTMTPekerjaan());
            ps.setString(4, riwayatJabatan.getNomorSKPekerjaan());
            ps.setString(5, riwayatJabatan.getTglSKPekerjaan());
            ps.setInt(6, riwayatJabatan.getCabang().getIdCabang());
            ps.setInt(7, riwayatJabatan.getUnit().getID());
            ps.setInt(8, riwayatJabatan.getJabatan().getId());
            ps.setString(9, riwayatJabatan.getNamaJabatan());
            ps.setInt(10, riwayatJabatan.getMasaJabatan());
            ps.setString(11, riwayatJabatan.getTglTMTPekerjaan_indo());
            ps.setString(12, riwayatJabatan.getTglSKPekerjaan_indo());
            ps.setString(13, riwayatJabatan.getTmt_awal());
            ps.setString(14, riwayatJabatan.getTmt_akhir());
            ps.setInt(15, riwayatJabatan.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data riwayat berhasil diperbaharui");
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteRiwayatJabatan(int id) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteRiwayatJabatabByID);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data riwayat berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public RiwayatJabatan getRiwayatJabatanByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        RiwayatJabatan jabatan = null;
        try {
            ps = connection.prepareStatement(sqlGetRiwayatByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                jabatan = new RiwayatJabatan();
                jabatan.setId(rs.getInt("id"));
                jabatan.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                jabatan.setCabang(DaoFactory.getCabangDao().getCabangByID(rs.getInt("idcabang")));
                jabatan.setJabatan(DaoFactory.getJabatanDao().getJabatanByID(rs.getInt("idjabatan")));
                jabatan.setMasaJabatan(rs.getInt("masa_jabatan"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                jabatan.setNomorSKPekerjaan(rs.getString("no_sk_pekerjaan"));
                jabatan.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                jabatan.setTglSKPekerjaan(rs.getString("tgl_sk_pekerjaan"));
                jabatan.setTglTMTPekerjaan(rs.getString("tmt_tanggal_pekerjaan"));
                jabatan.setUnit(DaoFactory.getUnitDao().getUnitByID(rs.getInt("idunit")));
                jabatan.setTglTMTPekerjaan_indo(rs.getString("tmt_tanggal_pekerjaan_indo"));
                jabatan.setTglSKPekerjaan_indo(rs.getString("tgl_sk_pekerjaan_indo"));
                jabatan.setTmt_awal(rs.getString("tmt_awal"));
                jabatan.setTmt_akhir(rs.getString("tmt_akhir"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabatan;
    }

}
