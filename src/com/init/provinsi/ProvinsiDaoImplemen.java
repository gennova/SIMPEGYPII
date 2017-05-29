/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.provinsi;

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
public class ProvinsiDaoImplemen implements ProvinsiDao {

    private final Connection connection;
    private final String sqlGetAllProvinsi = "select * from provinsi";
    private final String sqlGetProvinsiByID = "select * from provinsi where id=?";
    private final String sqlGetProvinsiByKode = "select * from provinsi where IDProvinsi=?";
    private final String sqlInsertProvinsi = "insert into provinsi(IDProvinsi,Nama) values (?,?)";
    private final String sqlUpdateProvinsi = "update provinsi set IDProvinsi=?,Nama=? where id=?";
    private final String sqlDeleteProvinsi = "delete from provinsi where id=?";

    public ProvinsiDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Provinsi> getAllProvinsi() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Provinsi> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllProvinsi);
            list = new ArrayList<Provinsi>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Provinsi p = new Provinsi();
                p.setID(rs.getInt("id"));
                p.setKode(rs.getInt("IDProvinsi"));
                p.setNamaProvinsi(rs.getString("Nama"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Provinsi getProvinsiByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Provinsi p = new Provinsi();
        try {
            ps = connection.prepareStatement(sqlGetProvinsiByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setID(rs.getInt("id"));
                p.setKode(rs.getInt("IDProvinsi"));
                p.setNamaProvinsi(rs.getString("Nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Provinsi getProvinsiByKode(String kode) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Provinsi p = new Provinsi();
        try {
            ps = connection.prepareStatement(sqlGetProvinsiByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setID(rs.getInt("id"));
                p.setKode(rs.getInt("IDProvinsi"));
                p.setNamaProvinsi(rs.getString("Nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void InsertProvinsi(Provinsi provinsi) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertProvinsi);
            ps.setInt(1, provinsi.getKode());
            ps.setString(2, provinsi.getNamaProvinsi());
            int status = ps.executeUpdate();
            if (status==1) {
                JOptionPane.showMessageDialog(null, "Data Provinsi berhasil ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateProvinsi(Provinsi provinsi) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateProvinsi);
            ps.setInt(1, provinsi.getKode());
            ps.setString(2, provinsi.getNamaProvinsi());
            ps.setInt(3, provinsi.getID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Provinsi berhasil diperbaharui");
        } catch (SQLException ex) {
            Logger.getLogger(ProvinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteProvinsiByID(Provinsi provinsi) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteProvinsi);
            ps.setInt(1, provinsi.getID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(ProvinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
