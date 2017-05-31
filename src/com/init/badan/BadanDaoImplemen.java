/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.badan;

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
public class BadanDaoImplemen implements BadanDao {

    private final Connection connection;
    private final String sqlGetAllBadan = "select * from badan";
    private final String sqlGetBadanByNUK = "select * from badan where nuk=?";
    private final String sqlInsertDataBadan = "insert into badan (nuk,tinggi,berat,warna,cirikhas,cacat,golongandarah,hobby,pekerjaanlain,jenisrambut,bentukmuka) values (?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdateDataBadan = "update badan set tinggi=?,berat=?,warna=?,cirikhas=?,cacat=?,golongandarah=?,hobby=?,pekerjaanlain=?,jenisrambut=?,bentukmuka=? where nuk=?";

    public BadanDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Badan> getAllBadanPegawai() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Badan> badans = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBadan);
            rs = ps.executeQuery();
            badans = new ArrayList<Badan>();
            while (rs.next()) {
                Badan badan = new Badan();
                badan.setId(rs.getInt(rs.getInt("id")));
                badan.setNuk(rs.getString("nuk"));
                badan.setTinggibadan(rs.getDouble("tinggi"));
                badan.setBeratbadan(rs.getDouble("berat"));
                badan.setWarnakulit(rs.getString("warna"));
                badan.setCirikhas(rs.getString("cirikhas"));
                badan.setCacattubuh(rs.getString("cacat"));
                badan.setGolongandarah(rs.getString("golongandarah"));
                badan.setHobby(rs.getString("hobby"));
                badan.setPekerjaanlain(rs.getString("pekerjaanlain"));
                badan.setJenisrambut(rs.getString("jenisrambut"));
                badan.setBentukmuka(rs.getString("bentukmuka"));
                badans.add(badan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BadanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return badans;
    }

    @Override
    public Badan getDataBadanByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Badan badan = new Badan();
        try {
            ps = connection.prepareStatement(sqlGetBadanByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                badan.setId(rs.getInt(rs.getInt("id")));
                badan.setNuk(rs.getString("nuk"));
                badan.setTinggibadan(rs.getDouble("tinggi"));
                badan.setBeratbadan(rs.getDouble("berat"));
                badan.setWarnakulit(rs.getString("warna"));
                badan.setCirikhas(rs.getString("cirikhas"));
                badan.setCacattubuh(rs.getString("cacat"));
                badan.setGolongandarah(rs.getString("golongandarah"));
                badan.setHobby(rs.getString("hobby"));
                badan.setPekerjaanlain(rs.getString("pekerjaanlain"));
                badan.setJenisrambut(rs.getString("jenisrambut"));
                badan.setBentukmuka(rs.getString("bentukmuka"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BadanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return badan;
    }

    @Override
    public void InsertDataBadanPegawai(Badan badan) {
        PreparedStatement ps = null;
        try {
            boolean status = cekBadanNUK(badan.getNuk());
            if (status == false) {
                ps = connection.prepareStatement(sqlInsertDataBadan);
                ps.setString(1, badan.getNuk());
                ps.setDouble(2, badan.getTinggibadan());
                ps.setDouble(3, badan.getBeratbadan());
                ps.setString(4, badan.getWarnakulit());
                ps.setString(5, badan.getCirikhas());
                ps.setString(6, badan.getCacattubuh());
                ps.setString(7, badan.getGolongandarah());
                ps.setString(8, badan.getHobby());
                ps.setString(9, badan.getPekerjaanlain());
                ps.setString(10, badan.getJenisrambut());
                ps.setString(11, badan.getBentukmuka());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Badan berhasil ditambahkan");
            } else if (status == true) {
                ps = connection.prepareStatement(sqlUpdateDataBadan);
                ps.setDouble(1, badan.getTinggibadan());
                ps.setDouble(2, badan.getBeratbadan());
                ps.setString(3, badan.getWarnakulit());
                ps.setString(4, badan.getCirikhas());
                ps.setString(5, badan.getCacattubuh());
                ps.setString(6, badan.getGolongandarah());
                ps.setString(7, badan.getHobby());
                ps.setString(8, badan.getPekerjaanlain());
                ps.setString(9, badan.getJenisrambut());
                ps.setString(10, badan.getBentukmuka());
                ps.setString(11, badan.getNuk());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Badan berhasil diperbaharui");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BadanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean cekBadanNUK(String nuk) {
        boolean status = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select nuk from badan where nuk=?");
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BadanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
