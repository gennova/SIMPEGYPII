/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.statuspegawai;

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
public class PegawaiStatusDaoImplemen implements PegawaiStatusDao {

    private Connection connection;
    private final String sqlGetAllPegawaiStatus = "select * from statuspegawai";
    private final String sqlGetPegawaiStatusByID = "select * from statuspegawai where id=?";
    private final String sqlGetPegawaiStatusByKode = "select * from statuspegawai where kodestatuspegawai=?";
    private final String sqlGetPegawaiStatusByNama = "select * from statuspegawai where namastatuspegawai=?";
    private final String sqlInsertPegawaiStatus = "insert into statuspegawai(kodestatuspegawai,namastatuspegawai) values (?,?)";
    private final String sqlUpdatePegawaiStatus = "update statuspegawai set kodestatuspegawai=?,namastatuspegawai=? where id=?";
    private final String sqlDeletePegawaiStatus = " delete from statuspegawai where id=?";

    public PegawaiStatusDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PegawaiStatus> getAllPegawaiStatus() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PegawaiStatus> lists = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPegawaiStatus);
            rs = ps.executeQuery();
            lists = new ArrayList<>();
            while (rs.next()) {
                PegawaiStatus ps1 = new PegawaiStatus();
                ps1.setID(rs.getInt("id"));
                ps1.setKodeStatusPegawai(rs.getString("kodestatuspegawai"));
                ps1.setNamaStatusPegawai(rs.getString("namastatuspegawai"));
                lists.add(ps1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiStatusDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public PegawaiStatus getPegawaiStatusByID(int id) {
        PegawaiStatus pegawaiStatus = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try {
            ps1 = connection.prepareStatement(sqlGetPegawaiStatusByID);
            ps1.setInt(1, id);
            rs = ps1.executeQuery();
            while (rs.next()) {
                pegawaiStatus = new PegawaiStatus();
                pegawaiStatus.setID(rs.getInt("id"));
                pegawaiStatus.setKodeStatusPegawai(rs.getString("kodestatuspegawai"));
                pegawaiStatus.setNamaStatusPegawai(rs.getString("namastatuspegawai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiStatusDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pegawaiStatus;
    }

    @Override
    public PegawaiStatus getPegawaiStatusByKode(String kode) {
        PegawaiStatus pegawaiStatus = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try {
            ps1 = connection.prepareStatement(sqlGetPegawaiStatusByKode);
            ps1.setString(1, kode);
            rs = ps1.executeQuery();
            while (rs.next()) {
                pegawaiStatus = new PegawaiStatus();
                pegawaiStatus.setID(rs.getInt("id"));
                pegawaiStatus.setKodeStatusPegawai(rs.getString("kodestatuspegawai"));
                pegawaiStatus.setNamaStatusPegawai(rs.getString("namastatuspegawai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiStatusDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pegawaiStatus;
    }

    @Override
    public PegawaiStatus getPegawaiStatusByNama(String name) {
        PegawaiStatus pegawaiStatus = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try {
            ps1 = connection.prepareStatement(sqlGetPegawaiStatusByNama);
            ps1.setString(1, name);
            rs = ps1.executeQuery();
            while (rs.next()) {
                pegawaiStatus = new PegawaiStatus();
                pegawaiStatus.setID(rs.getInt("id"));
                pegawaiStatus.setKodeStatusPegawai(rs.getString("kodestatuspegawai"));
                pegawaiStatus.setNamaStatusPegawai(rs.getString("namastatuspegawai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiStatusDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pegawaiStatus;
    }

    @Override
    public void InsertPegawaiStatus(PegawaiStatus ps) {
        PreparedStatement p = null;
        try {
            p = connection.prepareStatement(sqlInsertPegawaiStatus);
            p.setString(1, ps.getKodeStatusPegawai());
            p.setString(2, ps.getNamaStatusPegawai());
            int status = p.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiStatusDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdatePegawaiStatus(PegawaiStatus ps) {
        PreparedStatement ps1 = null;
        try {
            ps1 = connection.prepareStatement(sqlUpdatePegawaiStatus);
            ps1.setString(1, ps.getKodeStatusPegawai());
            ps1.setString(2, ps.getNamaStatusPegawai());
            ps1.setInt(3, ps.getID());
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiStatusDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeletePegawaiStatusByID(PegawaiStatus ps) {
        PreparedStatement ps1 = null;
        try {
            ps1 = connection.prepareStatement(sqlDeletePegawaiStatus);
            ps1.setInt(1, ps.getID());
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiStatusDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
