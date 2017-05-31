/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.bidangkerja;

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
public class BidangKerjaDaoImplemen implements BidangKerjaDao {

    private final Connection connection;
    private final static String sqlGetAllBidangKerja = "select * from bidangkerja";
    private final static String sqlGetBidangKerjaByID = "select * from bidangkerja where id=?";
    private final static String sqlGetBidangKerjaByNamaBidang = "select * from bidangkerja where namabidangkerja=?";
    private final static String sqlGetBidangKerjaByKode = "select * from bidangkerja where kodebidangkerja=?";
    private final static String sqlInsertBidangKerja = "insert into bidangkerja(kodebidangkerja,namabidangkerja) values (?,?)";
    private final static String sqlUpdateBidangKerja = "update bidangkerja set kodebidangkerja=?,namabidangkerja=? where id=?";
    private final static String sqlDeleteBidangKerja = "delete from bidangkerja where id=?";

    public BidangKerjaDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<BidangKerja> getAllBidangKerja() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BidangKerja> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBidangKerja);
            rs = ps.executeQuery();
            list = new ArrayList<BidangKerja>();
            while (rs.next()) {
                BidangKerja bk = new BidangKerja();
                bk.setId(rs.getInt("id"));
                bk.setKode(rs.getString("kodebidangkerja"));
                bk.setNamabidangkerja(rs.getString("namabidangkerja"));
                list.add(bk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BidangKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public BidangKerja getBidangKerjaByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BidangKerja bk = new BidangKerja();
        try {
            ps = connection.prepareStatement(sqlGetBidangKerjaByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                bk.setId(rs.getInt("id"));
                bk.setKode(rs.getString("kodebidangkerja"));
                bk.setNamabidangkerja(rs.getString("namabidangkerja"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BidangKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bk;
    }

    @Override
    public BidangKerja getBidangKerjaByNamaBidangKerja(String namabidangkerja) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BidangKerja bk = new BidangKerja();
        try {
            ps = connection.prepareStatement(sqlGetBidangKerjaByNamaBidang);
            ps.setString(1, namabidangkerja);
            rs = ps.executeQuery();
            while (rs.next()) {
                bk.setId(rs.getInt("id"));
                bk.setKode(rs.getString("kodebidangkerja"));
                bk.setNamabidangkerja(rs.getString("namabidangkerja"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BidangKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bk;
    }

    @Override
    public BidangKerja getBidangkerjaByKode(String kode) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BidangKerja bk = new BidangKerja();
        try {
            ps = connection.prepareStatement(sqlGetBidangKerjaByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                bk.setId(rs.getInt("id"));
                bk.setKode(rs.getString("kodebidangkerja"));
                bk.setNamabidangkerja(rs.getString("namabidangkerja"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BidangKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bk;
    }

    @Override
    public void InsertBidangKerja(BidangKerja bidangKerja) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertBidangKerja);
            ps.setString(1, bidangKerja.getKode());
            ps.setString(2, bidangKerja.getNamabidangkerja());
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BidangKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateBidangKerja(BidangKerja bidangKerja) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateBidangKerja);
            ps.setString(1, bidangKerja.getKode());
            ps.setString(2, bidangKerja.getNamabidangkerja());
            ps.setInt(3, bidangKerja.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(BidangKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteBidangKerja(BidangKerja bidangKerja) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteBidangKerja);
            ps.setInt(1, bidangKerja.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(BidangKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
