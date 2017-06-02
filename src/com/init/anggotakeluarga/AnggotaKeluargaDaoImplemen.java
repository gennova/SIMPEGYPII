/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.anggotakeluarga;

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
public class AnggotaKeluargaDaoImplemen implements AnggotaKeluargaDao {

    private final Connection connection;
    private final String sqlGetAllAnggotaKeluarga = "select * from anggotakeluarga";
    private final String sqlGetAllAnggotaKeluargaByNUK = "select * from anggotakeluarga where nuk=?";
    private final String sqlInsertAnggotaKeluarga = "insert into anggotakeluarga (nuk,nama,tanggallahir,count) values (?,?,?,?)";
    private final String sqlUpdateAnggotaKeluarga = "update anggotakeluarga set nama=?,tanggallahir=? where count=? and nuk=?";

    public AnggotaKeluargaDaoImplemen(Connection connection1) {
        this.connection = connection1;
    }

    @Override
    public List<AnggotaKeluarga> getAllAnggotakeluarga() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AnggotaKeluarga> lists = null;
        try {
            ps = connection.prepareStatement(sqlGetAllAnggotaKeluarga);

        } catch (SQLException ex) {
            Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public AnggotaKeluarga getAnggotaKeluargaByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        AnggotaKeluarga anggotaKeluarga = null;
        try {
            ps = connection.prepareStatement(sqlGetAllAnggotaKeluargaByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                anggotaKeluarga = new AnggotaKeluarga();
                anggotaKeluarga.setID(rs.getInt("id"));
                anggotaKeluarga.setNuk(rs.getString("nuk"));
                anggotaKeluarga.setNama(rs.getString("nama"));
                anggotaKeluarga.setTanggalLahir(rs.getString("tanggallahir"));
                anggotaKeluarga.setCount(rs.getString("count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anggotaKeluarga;
    }

    @Override
    public void InsertAnggotaKeluarga(AnggotaKeluarga anggotaKeluarga) {
        PreparedStatement ps = null;
        boolean status = cekNuks(anggotaKeluarga.getNuk(), anggotaKeluarga.getNama(), anggotaKeluarga.getCount(), anggotaKeluarga.getTanggalLahir());
        if (status == false) {
            try {
                ps = connection.prepareStatement("delete from anggotakeluarga where nuk=? and count=?");
                ps.setString(1, anggotaKeluarga.getNuk());
                ps.setString(2, anggotaKeluarga.getCount());
                ps.executeUpdate();
                ps = connection.prepareStatement(sqlInsertAnggotaKeluarga);
                ps.setString(1, anggotaKeluarga.getNuk());
                ps.setString(2, anggotaKeluarga.getNama());
                ps.setString(3, anggotaKeluarga.getTanggalLahir());
                ps.setString(4, anggotaKeluarga.getCount());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (status == true) {
            //JOptionPane.showMessageDialog(null, "Data berhasil diperbaharui");
            System.out.println("");
            try {
                ps = connection.prepareStatement(sqlUpdateAnggotaKeluarga);
                ps.setString(1, anggotaKeluarga.getNama());
                ps.setString(2, anggotaKeluarga.getTanggalLahir());
                ps.setString(3, anggotaKeluarga.getCount());
                ps.setString(4, anggotaKeluarga.getNuk());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean cekNuks(String nuks, String nama, String count, String tanggal) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            ps = connection.prepareStatement("select nuk,nama,count from anggotakeluarga where nuk=? and nama=? and count=? and tanggallahir =?");
            ps.setString(1, nuks);
            ps.setString(2, nama);
            ps.setString(3, count);
            ps.setString(4, tanggal);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("nuk").equals(nuks) && rs.getString("nama").equals(nama) && rs.getString("count").equals(count)) {
                    //JOptionPane.showMessageDialog(null, "DATA ADA UPDATE");
                    System.out.println("update data anggota keluargaf");
                    status = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public List<AnggotaKeluarga> getAllAnggotaKeluargaByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AnggotaKeluarga> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllAnggotaKeluargaByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            list = new ArrayList<AnggotaKeluarga>();
            while (rs.next()) {
                AnggotaKeluarga ak = new AnggotaKeluarga();
                ak.setID(rs.getInt("id"));
                ak.setNuk(rs.getString("nuk"));
                ak.setNama(rs.getString("nama"));
                ak.setTanggalLahir(rs.getString("tanggallahir"));
                ak.setCount(rs.getString("count"));
                list.add(ak);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean cekNuks_ada_atau_gak(String nuks) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            ps = connection.prepareStatement("select nuk from anggotakeluarga where nuk=?");
            ps.setString(1, nuks);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
