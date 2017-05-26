/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.golongan;

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
public class GolonganDaoImplemen implements GolonganDao {

    private Connection connection;
    private static final String sqlGetAllGolongan= "select * from golongan";
    private static final String sqlGetGolonganByID = "select * from golongan where id=?";
    private static final String sqlGetGolonganByKode = "select * from golongan where kodegolongan=?";
    private static final String sqlGetGolonganByNama = "select * from golongan where namagolongan=?";
    private static final String sqlUpdateGolongan = "update golongan set kodegolongan=?,namagolongan=?,pangkat=? where id=?";
    private static final String sqlDeleteGolongan = "delete from golongan where id=?";
    private static final String sqlInsertGolongan = "insert into golongan(kodegolongan,namagolongan,pangkat) values (?,?,?)";

    public GolonganDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Golongan> getAllGolongans() {
        PreparedStatement ps=null;
        ResultSet rs= null;
        List<Golongan> lists=null;
        try {
            ps = connection.prepareStatement(sqlGetAllGolongan);
            rs= ps.executeQuery();
            lists = new ArrayList<Golongan>();
            while (rs.next()) {                
                Golongan g = new Golongan();
                g.setId(rs.getInt("id"));
                g.setKode(rs.getString("kodegolongan"));
                g.setNamagolongan(rs.getString("namagolongan"));
                g.setPangkat(rs.getString("pangkat"));
                lists.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public Golongan getGolonganByID(int id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Golongan golongan=null;
        try {
            ps = connection.prepareStatement(sqlGetGolonganByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                golongan = new Golongan();
                golongan.setId(rs.getInt("id"));
                golongan.setKode(rs.getString("kodegolongan"));
                golongan.setNamagolongan(rs.getString("namagolongan"));
                golongan.setPangkat(rs.getString("pangkat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return golongan;
    }

    @Override
    public Golongan getGolonganByKode(String kode) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Golongan golongan=null;
        try {
            ps = connection.prepareStatement(sqlGetGolonganByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {                
                golongan = new Golongan();
                golongan.setId(rs.getInt("id"));
                golongan.setKode(rs.getString("kodegolongan"));
                golongan.setNamagolongan(rs.getString("namagolongan"));
                golongan.setPangkat(rs.getString("pangkat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return golongan;
    }

    @Override
    public Golongan getGolonganByNamaGolongan(String nama) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Golongan golongan=null;
        try {
            ps = connection.prepareStatement(sqlGetGolonganByNama);
            ps.setString(1, nama);
            rs = ps.executeQuery();
            while (rs.next()) {                
                golongan = new Golongan();
                golongan.setId(rs.getInt("id"));
                golongan.setKode(rs.getString("kodegolongan"));
                golongan.setNamagolongan(rs.getString("namagolongan"));
                golongan.setPangkat(rs.getString("pangkat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return golongan;
    }

    @Override
    public void InsertGolongan(Golongan golongan) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlInsertGolongan);
            ps.setString(1, golongan.getKode());
            ps.setString(2, golongan.getNamagolongan());
            ps.setString(3, golongan.getPangkat());
            int status = ps.executeUpdate();
            if (status==1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateGolongan(Golongan golongan) {
        PreparedStatement ps =null;
        try {
            ps = connection.prepareStatement(sqlUpdateGolongan);
            ps.setString(1, golongan.getKode());
            ps.setString(2, golongan.getNamagolongan());
            ps.setString(3, golongan.getPangkat());
            ps.setInt(4, golongan.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaharui");                    
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteGolonganByID(Golongan golongan) {
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(sqlDeleteGolongan);
            ps.setInt(1, golongan.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
