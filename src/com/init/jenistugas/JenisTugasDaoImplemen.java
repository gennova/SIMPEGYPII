/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.jenistugas;

import com.init.bidangkerja.BidangKerja;
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
public class JenisTugasDaoImplemen implements JenisTugasDao {

    private Connection connection;
    private final static String sqlGetAllBidangKerja = "select * from jenistugas";
    private final static String sqlGetBidangKerjaByID = "select * from jenistugas where id=?";
    private final static String sqlGetBidangKerjaByKode = "select * from jenistugas where kodejenistugas=?";
    private final static String sqlInsertBidangKerja = "insert into jenistugas(kodejenistugas,namajenistugas,skor) values (?,?,?)";
    private final static String sqlUpdateBidangKerja = "update jenistugas set kodejenistugas=?,namajenistugas=?, skor=? where id=?";
    private final static String sqlDeleteBidangKerja = "delete from jenistugas where id=?";

    public JenisTugasDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<JenisTugas> getAllJenisTugas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<JenisTugas> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBidangKerja);
            rs = ps.executeQuery();
            list = new ArrayList<JenisTugas>();
            while (rs.next()) {
                JenisTugas jt = new JenisTugas();
                jt.setId(rs.getInt("id"));
                jt.setKode(rs.getString("kodejenistugas"));
                jt.setJenistugas(rs.getString("namajenistugas"));
                jt.setSkor(rs.getInt("skor"));
                list.add(jt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JenisTugasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public JenisTugas getJenisTugasByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        JenisTugas jt = new JenisTugas();
        try {
            ps = connection.prepareStatement(sqlGetBidangKerjaByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                jt.setId(rs.getInt("id"));
                jt.setKode(rs.getString("kodejenistugas"));
                jt.setJenistugas(rs.getString("namajenistugas"));
                jt.setSkor(rs.getInt("skor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JenisTugasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jt;
    }

    @Override
    public JenisTugas getJenisTUgasByKode(String kode) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        JenisTugas jt = new JenisTugas();
        try {
            ps = connection.prepareStatement(sqlGetBidangKerjaByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                jt.setId(rs.getInt("id"));
                jt.setKode(rs.getString("kodejenistugas"));
                jt.setJenistugas(rs.getString("namajenistugas"));
                jt.setSkor(rs.getInt("skor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JenisTugasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jt;
    }

    @Override
    public void InsertJenisTugas(JenisTugas jenisTugas) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertBidangKerja);
            ps.setString(1, jenisTugas.getKode());
            ps.setString(2, jenisTugas.getJenistugas());
            ps.setInt(3, jenisTugas.getSkor());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Jenis Tugas Berhasil Disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(JenisTugasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateJenisTugas(JenisTugas jenisTugas) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateBidangKerja);
            ps.setString(1, jenisTugas.getKode());
            ps.setString(2, jenisTugas.getJenistugas());
            ps.setInt(3, jenisTugas.getSkor());
            ps.setInt(4, jenisTugas.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Jenis Tugas Berhasil Diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(JenisTugasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeletJenisTugasByID(JenisTugas jenisTugas) {
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(sqlDeleteBidangKerja);
            ps.setInt(1, jenisTugas.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(JenisTugasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
