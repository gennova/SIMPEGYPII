/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.cabang;

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
public class CabangDaoImplemen implements CabangDao {

    private Connection connection;
    private final String sqlInsertCabang = "insert into cabang(kodecabang,namacabang) values(?,?)";
    private final String sqlUpdateCabangByID = "update cabang set kodecabang=?,namacabang=? where id =?";
    private final String sqlDeleteCabangByID = "delete from cabang where id=?";
    private final String sqlDeleteCabangByKode = "delete from cabang where kodecabang=?";
    private final String sqlGetAllCabang = "select * from cabang";
    private final String sqlGetCabangByID = "select * from cabang where id = ?";
    private final String sqlGetCabangByNamaCabang = "select * from cabang where namacabang=?";
    private final String sqlGetCabangByKode = "select * from cabang where kodecabang = ?";

    public CabangDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Cabang> getAllCabang() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cabang> cabangs = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sqlGetAllCabang);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cabang c = new Cabang();
                c.setIdCabang(rs.getInt("id"));
                c.setKode(rs.getString("kodecabang"));
                c.setNamacabang(rs.getString("namacabang"));
                cabangs.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cabangs;
    }

    @Override
    public Cabang getCabangByNamaCabang(String namacabang) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cabang cabang = null;
        try {
            ps = connection.prepareStatement(sqlGetCabangByNamaCabang);
            ps.setString(1, namacabang);
            rs = ps.executeQuery();
            while (rs.next()) {
                cabang = new Cabang();
                cabang.setIdCabang(rs.getInt("id"));
                cabang.setKode(rs.getString("kodecabang"));
                cabang.setNamacabang(rs.getString("namacabang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cabang;
    }

    @Override
    public void insertCabang(Cabang cabang) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement ps = null;
        try {
            ps = connection.prepareCall(sqlInsertCabang);
            ps.setString(1, cabang.getKode());
            ps.setString(2, cabang.getNamacabang());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Cabang Berhasil Di Tambahkan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan");
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteCabangById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteCabangByID);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteCabangByKode(String kode) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteCabangByKode);
            ps.setString(1, kode);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCabang(Cabang cabang) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateCabangByID);
            ps.setString(1, cabang.getKode());
            ps.setString(2, cabang.getNamacabang());
            ps.setInt(3, cabang.getIdCabang());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Cabang Berhasil Diubah");
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cabang getCabangByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cabang cabang = null;
        try {
            ps = connection.prepareStatement(sqlGetCabangByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cabang = new Cabang();
                cabang.setIdCabang(rs.getInt("id"));
                cabang.setKode(rs.getString("kodecabang"));
                cabang.setNamacabang(rs.getString("namacabang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cabang;
    }

    @Override
    public Cabang getCabangByKode(String kode) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cabang cabang = null;
        try {
            ps = connection.prepareStatement(sqlGetCabangByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cabang = new Cabang();
                cabang.setIdCabang(rs.getInt("id"));
                cabang.setKode(rs.getString("kodecabang"));
                cabang.setNamacabang(rs.getString("namacabang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cabang;
    }

}
