/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.jabatan;

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
public class JabatanDaoImplemen implements JabatanDao {

    private final Connection connection;
    private final static String sqlGetAllJabatan = "select * from jabatan";
    private final static String sqlGetAlljabatanByMasa = "Select * from jabatan where masajabatan=?";
    private final static String sqlGetJabatanByID = "select * from jabatan where id=?";
    private final static String sqlgetJabatanByKode = "select * from jabatan where kodejabatan=?";
    private final static String sqlgetJabatanByNama = "select * from jabatan where namajabatan=?";
    private final static String sqlInsertJabatan = "insert into jabatan(kodejabatan,namajabatan,masajabatan) values (?,?,?)";
    private final static String sqlUpdateJabatan = "update jabatan set kodejabatan=?,namajabatan=?,masajabatan=? where id=?";
    private final static String sqlDeleteJabatanByID = "delete from jabatan where id=?";

    public JabatanDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Jabatan> getAllJabatan() {
        List<Jabatan> lists = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllJabatan);
            rs = statement.executeQuery();
            lists = new ArrayList<Jabatan>();
            while (rs.next()) {
                Jabatan jabatan = new Jabatan();
                jabatan.setId(rs.getInt("id"));
                jabatan.setKodejabatan(rs.getString("kodejabatan"));
                jabatan.setNamajabatan(rs.getString("namajabatan"));
                jabatan.setMasajabatan(rs.getInt("masajabatan"));
                lists.add(jabatan);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public List<Jabatan> getAllJabatanByMasaJabatan(int masa) {
        List<Jabatan> lists = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAlljabatanByMasa);
            statement.setInt(1, masa);
            rs = statement.executeQuery();
            while (rs.next()) {
                Jabatan jabatan = new Jabatan();
                jabatan.setId(rs.getInt("id"));
                jabatan.setKodejabatan(rs.getString("kodejabatan"));
                jabatan.setNamajabatan(rs.getString("namajabatan"));
                jabatan.setMasajabatan(rs.getInt("masajabatan"));
                lists.add(jabatan);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public Jabatan getJabatanByID(int id) {
        PreparedStatement ps = null;
        Jabatan jabatan = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlGetJabatanByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            jabatan = new Jabatan();
            while (rs.next()) {
                jabatan.setId(rs.getInt("id"));
                jabatan.setKodejabatan(rs.getString("kodejabatan"));
                jabatan.setNamajabatan(rs.getString("namajabatan"));
                jabatan.setMasajabatan(rs.getInt("masajabaatn"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabatan;
    }

    @Override
    public Jabatan getJabatanByKode(String kode) {
        PreparedStatement ps = null;
        Jabatan jabatan = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlgetJabatanByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            jabatan = new Jabatan();
            while (rs.next()) {
                jabatan.setId(rs.getInt("id"));
                jabatan.setKodejabatan(rs.getString("kodejabatan"));
                jabatan.setNamajabatan(rs.getString("namajabatan"));
                jabatan.setMasajabatan(rs.getInt("masajabatan"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabatan;
    }

    @Override
    public Jabatan getJabatanByNama(String name) {
        PreparedStatement ps = null;
        Jabatan jabatan = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlgetJabatanByNama);
            ps.setString(1, name);
            rs = ps.executeQuery();
            jabatan = new Jabatan();
            while (rs.next()) {
                jabatan.setId(rs.getInt("id"));
                jabatan.setKodejabatan(rs.getString("kodejabatan"));
                jabatan.setNamajabatan(rs.getString("namajabatan"));
                jabatan.setMasajabatan(rs.getInt("masajabaatn"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabatan;
    }

    @Override
    public void InsertJabatan(Jabatan jabatan) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertJabatan);
            ps.setString(1, jabatan.getKodejabatan());
            ps.setString(2, jabatan.getNamajabatan());
            ps.setInt(3, jabatan.getMasajabatan());
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data Jabatan Berhasil Ditambahkan");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateJabatan(Jabatan jabatan) {
        PreparedStatement ps =null;
        try {
            ps = connection.prepareStatement(sqlUpdateJabatan);
            ps.setString(1, jabatan.getKodejabatan());
            ps.setString(2, jabatan.getNamajabatan());
            ps.setInt(3, jabatan.getMasajabatan());
            ps.setInt(4, jabatan.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Jabatan Berhasil Diubah");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteJabatanByID(Jabatan jabatan) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteJabatanByID);
            ps.setInt(1, jabatan.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Jabatan Berhasil DIhapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan, Ulangi Lagi / Restart \n"+ex.getMessage());
            Logger.getLogger(JabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
