/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pendidikanterakhir;

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
public class PendidikanTerakhirDaoImplemen implements PendidikanTerakhirDao {

    private Connection connection;
    private final static String sqlGetAllPendidikan = "select * from pendidikanterakhir";
    private final static String sqlGetPendidikanByID = "select * from pendidikanterakhir where id=?";
    private final static String sqlGetPendidikanByKode = "select * from pendidikanterakhir where kodependidikan=?";
    private final static String sqlGetPendidikanByNama = "select * from pendidikanterakhir where namapendidikan=?";
    private final static String sqlInsertPendidikan = "insert into pendidikanterakhir (kodependidikan,namapendidikan) values (?,?)";
    private final static String sqlUpdatePendidikan = "update pendidikanterakhir set kodependidikan=?,namapendidikan=? where id=?";
    private final static String sqlDeletePendidikan = "delete from pendidikanterakhir where id=?";

    public PendidikanTerakhirDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PendidikanTerakhir> getAllPendidikan() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PendidikanTerakhir> lists = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPendidikan);
            rs = ps.executeQuery();
            lists = new ArrayList<PendidikanTerakhir>();
            while (rs.next()) {
                PendidikanTerakhir pt = new PendidikanTerakhir();
                pt.setId(rs.getInt("id"));
                pt.setKode(rs.getString("kodependidikan"));
                pt.setNamapendidikanterakhir(rs.getString("namapendidikan"));
                lists.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanTerakhirDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public PendidikanTerakhir getPendidikanByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        PendidikanTerakhir pt = new PendidikanTerakhir();
        try {
            ps = connection.prepareStatement(sqlGetPendidikanByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pt.setId(rs.getInt("id"));
                pt.setKode(rs.getString("kodependidikan"));
                pt.setNamapendidikanterakhir(rs.getString("namapendidikan"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanTerakhirDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pt;
    }

    @Override
    public PendidikanTerakhir getPendidikanByKode(String kode) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        PendidikanTerakhir pt = new PendidikanTerakhir();
        try {
            ps = connection.prepareStatement(sqlGetPendidikanByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                pt.setId(rs.getInt("id"));
                pt.setKode(rs.getString("kodependidikan"));
                pt.setNamapendidikanterakhir(rs.getString("namapendidikan"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanTerakhirDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pt;
    }

    @Override
    public PendidikanTerakhir getPendidikanByNama(String nama) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        PendidikanTerakhir pt = new PendidikanTerakhir();
        try {
            ps = connection.prepareStatement(sqlGetPendidikanByNama);
            ps.setString(1, nama);
            rs = ps.executeQuery();
            while (rs.next()) {
                pt.setId(rs.getInt("id"));
                pt.setKode(rs.getString("kodependidikan"));
                pt.setNamapendidikanterakhir(rs.getString("namapendidikan"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanTerakhirDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pt;
    }

    @Override
    public void InsertPendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir) {
        PreparedStatement ps =null;
        try {
            ps = connection.prepareStatement(sqlInsertPendidikan);
            ps.setString(1, pendidikanTerakhir.getKode());
            ps.setString(2, pendidikanTerakhir.getNamapendidikanterakhir());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pendidikan Berhasil Disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanTerakhirDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdatePendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir) {        
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdatePendidikan);
            ps.setString(1, pendidikanTerakhir.getKode());
            ps.setString(2, pendidikanTerakhir.getNamapendidikanterakhir());
            ps.setInt(3, pendidikanTerakhir.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaharui");
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanTerakhirDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeletePendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeletePendidikan);
            ps.setInt(1, pendidikanTerakhir.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanTerakhirDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
