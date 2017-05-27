/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ijazah;

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
public class IjazahAngkatDaoImplemen implements IjazahAngkatDao {

    private final Connection connection;
    private final String sqlGetAllIjazahAngkat = "select * from ijazahangkat";
    private final String sqlGetIjazahByID = "select * from ijazahangkat where id=?";
    private final String sqlGetIjazahByKode = "select * from ijazahangkat where kodeijazah=?";
    private final String sqlInsertIjazah = "insert into ijazahangkat (kodeijazah,namaijazah) values (?,?)";
    private final String sqlUpdateIjazah = "update ijazahangkat set kodeijazah=?,namaijazah=? where id=?";
    private final String sqlDeleteIjazahByID = "delete from ijazahangkat where id=?";

    public IjazahAngkatDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<IjazahAngkat> getAllIjazahPengangkatan() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<IjazahAngkat> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllIjazahAngkat);
            list = new ArrayList<IjazahAngkat>();
            rs = ps.executeQuery();
            while (rs.next()) {
                IjazahAngkat ij = new IjazahAngkat();
                ij.setId(rs.getInt("id"));
                ij.setKodeIjazahPengangkatan(rs.getString("kodeijazah"));
                ij.setNamaIjazahPengangkatan(rs.getString("namaijazah"));
                list.add(ij);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IjazahAngkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public IjazahAngkat getIjazahAngkatByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        IjazahAngkat ij = new IjazahAngkat();
        try {
            ps = connection.prepareStatement(sqlGetIjazahByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ij.setId(rs.getInt("id"));
                ij.setKodeIjazahPengangkatan(rs.getString("kodeijazah"));
                ij.setNamaIjazahPengangkatan(rs.getString("namaijazah"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IjazahAngkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ij;
    }

    @Override
    public IjazahAngkat getIjazahAngkatByKode(String kode) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        IjazahAngkat ij = new IjazahAngkat();
        try {
            ps = connection.prepareStatement(sqlGetIjazahByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                ij.setId(rs.getInt("id"));
                ij.setKodeIjazahPengangkatan(rs.getString("kodeijazah"));
                ij.setNamaIjazahPengangkatan(rs.getString("namaijazah"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IjazahAngkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ij;
    }

    @Override
    public void InsertIjazah(IjazahAngkat ijazahAngkat) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertIjazah);
            ps.setString(1, ijazahAngkat.getKodeIjazahPengangkatan());
            ps.setString(2, ijazahAngkat.getNamaIjazahPengangkatan());
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IjazahAngkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateIjazah(IjazahAngkat ijazahAngkat) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateIjazah);
            ps.setString(1, ijazahAngkat.getKodeIjazahPengangkatan());
            ps.setString(2, ijazahAngkat.getNamaIjazahPengangkatan());
            ps.setInt(3, ijazahAngkat.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
        } catch (SQLException ex) {
            Logger.getLogger(IjazahAngkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteIjazahByID(IjazahAngkat ijazahAngkat) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteIjazahByID);
            ps.setInt(1, ijazahAngkat.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
        } catch (SQLException ex) {
            Logger.getLogger(IjazahAngkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
