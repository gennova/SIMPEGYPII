/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.kartu;

import com.init.pegawai.Pegawai;
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
public class KartuDaoImplemen implements KartuDao {

    private final Connection connection;
    private final String sqlGetAllKartu = "select * from kartu";
    private final String sqlGetAllKartuByNUK = "select * from kartu where nuk=?";
    private final String sqlInsertKartuWithNUK = "INSERT INTO kartu(nuk,kartupegawai,nokartupegawai,masaberlakukartupegawai,kartusuamiistri,nokartusuamiistri,masaberlakukartusuamiistri,kartuaskes,nokartuaskes,masaberlakuaskes,kartubpjs,nokartubpjs,masaberlakubpjs,kartuyadapen,nokartuyadapen,masaberlakuyadapen,kartuktp,nokartuktp,masaberlakuktp,kartusim,nokartusim,masaberlakusim,kartupaspor,nokartupaspor,masaberlakupaspor,kartunpwp,nokartunpwp,masaberlakunpwp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private final String sqlUpdateKartuWithNUK = "update kartu set kartupegawai=?,nokartupegawai=?,masaberlakukartupegawai=?,kartusuamiistri=?,nokartusuamiistri=?,masaberlakukartusuamiistri=?,kartuaskes=?,nokartuaskes=?,masaberlakuaskes=?,kartubpjs=?,nokartubpjs=?,masaberlakubpjs=?,kartuyadapen=?,nokartuyadapen=?,masaberlakuyadapen=?,kartuktp=?,nokartuktp=?,masaberlakuktp=?,kartusim=?,nokartusim=?,masaberlakusim=?,kartupaspor=?,nokartupaspor=?,masaberlakupaspor=?,kartunpwp=?,nokartunpwp=?,masaberlakunpwp=? where nuk =?";

    public KartuDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Kartu> getAllKartu() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Kartu> kartus = null;
        try {
            ps = connection.prepareStatement(sqlGetAllKartu);
            rs = ps.executeQuery();
            kartus = new ArrayList<Kartu>();
            while (rs.next()) {
                Kartu k = new Kartu();
                k.setId(rs.getInt("id"));
                k.setKartuPegawai(rs.getString("kartupegawai"));
                k.setNoKartuPegawai(rs.getString("nokartupegawai"));
                k.setMasaBerlakuKartuPegawai(rs.getString("masaberlakukartupegawai"));
                k.setKartuSuamiIstri(rs.getString("kartusuamiistri"));
                k.setNoKartuSuamiIstri(rs.getString("nokartusuamiistri"));
                k.setMasaBerlakuKartuSuamiIstri(rs.getString("masaberlakukartusuamiistri"));
                k.setKartuAskes(rs.getString("kartuaskes"));
                k.setNoKartuAskes(rs.getString("nokartuaskes"));
                k.setMasaBerlakuKartuAskes(rs.getString("masaberlakuaskes"));
                k.setKartuBPJS(rs.getString("kartubpjs"));
                k.setNoKartuBPJS(rs.getString("nokartubpjs"));
                k.setMasaBerlakuKartuBPJS(rs.getString("masaberlakubpjs"));
                k.setKartuYadapen(rs.getString("kartuyadapen"));
                k.setNoKartuYadapen(rs.getString("nokartuyadapen"));
                k.setMasaBerlakuKartuYadapen(rs.getString("masaberlakuyadapen"));
                k.setKartuKTP(rs.getString("kartuktp"));
                k.setNoKartuKTP(rs.getString("nokartuktp"));
                k.setMasaBerlakuKartuKTP(rs.getString("masaberlakuktp"));
                k.setKartuSIM(rs.getString("kartusim"));
                k.setNoKartuSIM(rs.getString("nokartusim"));
                k.setMasaBerlakuKartuSIM(rs.getString("masaberlakusim"));
                k.setKartuPaspor(rs.getString("kartupaspor"));
                k.setNoKartuPaspor(rs.getString("nokartupaspor"));
                k.setMasaBerlakuKartuPaspor(rs.getString("masaberlakupaspor"));
                k.setKartuNPWP(rs.getString("kartunpwp"));
                k.setNoKartuNPWP(rs.getString("nokartunpwp"));
                k.setMasaBerlakuKartuNPWP(rs.getString("masaberlakunpwp"));
                kartus.add(k);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KartuDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kartus;

    }

    @Override
    public Kartu getAllKartuByNUK(Pegawai pegawai) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Kartu k = new Kartu();
        try {
            ps = connection.prepareStatement(sqlGetAllKartuByNUK);
            ps.setString(1, pegawai.getNUK());
            rs = ps.executeQuery();
            while (rs.next()) {
                k.setId(rs.getInt("id"));
                k.setPegawai(pegawai);
                k.setKartuPegawai(rs.getString("kartupegawai"));
                k.setNoKartuPegawai(rs.getString("nokartupegawai"));
                k.setMasaBerlakuKartuPegawai(rs.getString("masaberlakukartupegawai"));
                k.setKartuSuamiIstri(rs.getString("kartusuamiistri"));
                k.setNoKartuSuamiIstri(rs.getString("nokartusuamiistri"));
                k.setMasaBerlakuKartuSuamiIstri(rs.getString("masaberlakukartusuamiistri"));
                k.setKartuAskes(rs.getString("kartuaskes"));
                k.setNoKartuAskes(rs.getString("nokartuaskes"));
                k.setMasaBerlakuKartuAskes(rs.getString("masaberlakuaskes"));
                k.setKartuBPJS(rs.getString("kartubpjs"));
                k.setNoKartuBPJS(rs.getString("nokartubpjs"));
                k.setMasaBerlakuKartuBPJS(rs.getString("masaberlakubpjs"));
                k.setKartuYadapen(rs.getString("kartuyadapen"));
                k.setNoKartuYadapen(rs.getString("nokartuyadapen"));
                k.setMasaBerlakuKartuYadapen(rs.getString("masaberlakuyadapen"));
                k.setKartuKTP(rs.getString("kartuktp"));
                k.setNoKartuKTP(rs.getString("nokartuktp"));
                k.setMasaBerlakuKartuKTP(rs.getString("masaberlakuktp"));
                k.setKartuSIM(rs.getString("kartusim"));
                k.setNoKartuSIM(rs.getString("nokartusim"));
                k.setMasaBerlakuKartuSIM(rs.getString("masaberlakusim"));
                k.setKartuPaspor(rs.getString("kartupaspor"));
                k.setNoKartuPaspor(rs.getString("nokartupaspor"));
                k.setMasaBerlakuKartuPaspor(rs.getString("masaberlakupaspor"));
                k.setKartuNPWP(rs.getString("kartunpwp"));
                k.setNoKartuNPWP(rs.getString("nokartunpwp"));
                k.setMasaBerlakuKartuNPWP(rs.getString("masaberlakunpwp"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(KartuDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }

    @Override
    public void InsertKartuWithNUK(Kartu kartu) {
        PreparedStatement ps = null;
        try {
            boolean status = CekNUK(kartu.getPegawai().getNUK());
            if (status == false) {
                ps = connection.prepareStatement(sqlInsertKartuWithNUK);
                ps.setString(1, kartu.getPegawai().getNUK());
                ps.setString(2, kartu.getKartuPegawai());
                ps.setString(3, kartu.getNoKartuPegawai());
                ps.setString(4, kartu.getMasaBerlakuKartuPegawai());
                ps.setString(5, kartu.getKartuSuamiIstri());
                ps.setString(6, kartu.getNoKartuSuamiIstri());
                ps.setString(7, kartu.getMasaBerlakuKartuSuamiIstri());
                ps.setString(8, kartu.getKartuAskes());
                ps.setString(9, kartu.getNoKartuAskes());
                ps.setString(10, kartu.getMasaBerlakuKartuAskes());
                ps.setString(11, kartu.getKartuBPJS());
                ps.setString(12, kartu.getNoKartuBPJS());
                ps.setString(13, kartu.getMasaBerlakuKartuBPJS());
                ps.setString(14, kartu.getKartuYadapen());
                ps.setString(15, kartu.getNoKartuYadapen());
                ps.setString(16, kartu.getMasaBerlakuKartuYadapen());
                ps.setString(17, kartu.getKartuKTP());
                ps.setString(18, kartu.getNoKartuKTP());
                ps.setString(19, kartu.getMasaBerlakuKartuKTP());
                ps.setString(20, kartu.getKartuSIM());
                ps.setString(21, kartu.getNoKartuSIM());
                ps.setString(22, kartu.getMasaBerlakuKartuSIM());
                ps.setString(23, kartu.getKartuPaspor());
                ps.setString(24, kartu.getNoKartuPaspor());
                ps.setString(25, kartu.getMasaBerlakuKartuPaspor());
                ps.setString(26, kartu.getKartuNPWP());
                ps.setString(27, kartu.getNoKartuNPWP());
                ps.setString(28, kartu.getMasaBerlakuKartuNPWP());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Kartu Berhasil di tambahkan");
            } else if (status == true) {
                ps = connection.prepareStatement(sqlUpdateKartuWithNUK);
                ps.setString(1, kartu.getKartuPegawai());
                ps.setString(2, kartu.getNoKartuPegawai());
                ps.setString(3, kartu.getMasaBerlakuKartuPegawai());
                ps.setString(4, kartu.getKartuSuamiIstri());
                ps.setString(5, kartu.getNoKartuSuamiIstri());
                ps.setString(6, kartu.getMasaBerlakuKartuSuamiIstri());
                ps.setString(7, kartu.getKartuAskes());
                ps.setString(8, kartu.getNoKartuAskes());
                ps.setString(9, kartu.getMasaBerlakuKartuAskes());
                ps.setString(10, kartu.getKartuBPJS());
                ps.setString(11, kartu.getNoKartuBPJS());
                ps.setString(12, kartu.getMasaBerlakuKartuBPJS());
                ps.setString(13, kartu.getKartuYadapen());
                ps.setString(14, kartu.getNoKartuYadapen());
                ps.setString(15, kartu.getMasaBerlakuKartuYadapen());
                ps.setString(16, kartu.getKartuKTP());
                ps.setString(17, kartu.getNoKartuKTP());
                ps.setString(18, kartu.getMasaBerlakuKartuKTP());
                ps.setString(19, kartu.getKartuSIM());
                ps.setString(20, kartu.getNoKartuSIM());
                ps.setString(21, kartu.getMasaBerlakuKartuSIM());
                ps.setString(22, kartu.getKartuPaspor());
                ps.setString(23, kartu.getNoKartuPaspor());
                ps.setString(24, kartu.getMasaBerlakuKartuPaspor());
                ps.setString(25, kartu.getKartuNPWP());
                ps.setString(26, kartu.getNoKartuNPWP());
                ps.setString(27, kartu.getMasaBerlakuKartuNPWP());
                ps.setString(28, kartu.getPegawai().getNUK());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Kartu Berhasil Diperbaharui");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KartuDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean CekNUK(String nuk) {
        boolean status = false;
        try {
            PreparedStatement ps = connection.prepareStatement("select nuk from kartu where nuk=?");
            ps.setString(1, nuk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KartuDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
