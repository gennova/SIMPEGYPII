/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.gaji;

import com.init.tools.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amnesia
 */
public class Riwayat_Gaji_pegawai_dao_implemen implements Riwayat_Gaji_pegawai_dao {

    private final Connection connection;
    private final String sqlInsertGajiPegawai = "INSERT INTO riwayat_gajipegawai(nuk,gaji_pokok,tunjangan_suami_istri,tunjangan_anak,tunjangan_lain,total_gaji,tanggungan_orang,kgb_berikutnya,kgb_yad,kgb_yad_indo,idpangkat,idjabatan,tmt_lama,no_kgb_lama,tanggal) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdateGajiPegawai = "update riwayat_gajipegawai set gaji_pokok=?,tunjangan_suami_istri=?,tunjangan_anak=?,tunjangan_lain=?,total_gaji=?,tanggungan_orang=?,kgb_berikutnya=?,kgb_yad=?,kgb_yad_indo=? where nuk=?";
    private final String sqlGetRiwayatGajiPegawaiByNUKLast = "select * from riwayat_gajipegawai where nuk=? and id=(select max(id) from riwayat_gajipegawai)";
    private final String sqlGetAllRiwayatGaji = "select * from riwayat_gajipegawai";

    public Riwayat_Gaji_pegawai_dao_implemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertGajiPegawaiRiwayat(RiwayatGajiPegawai gaji_pegawai) {
        PreparedStatement ps = null;
        boolean statusgaji = false; // set aja ke false, asumsi riwayat masukin aja terus tanpa batas
        if (statusgaji == false) {
            try {
                ps = connection.prepareStatement(sqlInsertGajiPegawai);
                ps.setString(1, gaji_pegawai.getPegawai().getNUK());
                ps.setDouble(2, gaji_pegawai.getGaji_pokok());
                ps.setDouble(3, gaji_pegawai.getTunjangan_suami_istri());
                ps.setDouble(4, gaji_pegawai.getTunjangan_anak());
                ps.setDouble(5, gaji_pegawai.getTunjangan_lain());
                ps.setDouble(6, gaji_pegawai.getTotal_gaji());
                ps.setInt(7, gaji_pegawai.getTanggungan_orang());
                ps.setInt(8, gaji_pegawai.getKgb_berikutnya());
                ps.setString(9, gaji_pegawai.getKbg_yad_date());
                ps.setString(10, gaji_pegawai.getKgb_yad_indo());
                ps.setInt(11, gaji_pegawai.getPangkat().getId());
                ps.setInt(12, gaji_pegawai.getPekerjaanJabatan().getId());
                ps.setString(13, gaji_pegawai.getPangkat().getTmt_kgb_indo());
                ps.setString(14, gaji_pegawai.getPangkat().getNomor_kgb());
                ps.setString(15, gaji_pegawai.getPangkat().getTanggal_kgb());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Berhasil menyimpan data riwayat gaji pegawai");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Riwayat_Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (statusgaji == true) {
            try {
                ps = connection.prepareStatement(sqlUpdateGajiPegawai);
                ps.setDouble(1, gaji_pegawai.getGaji_pokok());
                ps.setDouble(2, gaji_pegawai.getTunjangan_suami_istri());
                ps.setDouble(3, gaji_pegawai.getTunjangan_anak());
                ps.setDouble(4, gaji_pegawai.getTunjangan_lain());
                ps.setDouble(5, gaji_pegawai.getTotal_gaji());
                ps.setInt(6, gaji_pegawai.getTanggungan_orang());
                ps.setInt(7, gaji_pegawai.getKgb_berikutnya());
                ps.setString(8, gaji_pegawai.getKbg_yad_date());
                ps.setString(9, gaji_pegawai.getKgb_yad_indo());
                ps.setString(10, gaji_pegawai.getPegawai().getNUK());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Berhasil update data riwayat gaji pegawai karna ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Riwayat_Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean CekGajiPegawaiByNUKRiwayat(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            ps = connection.prepareStatement(sqlGetRiwayatGajiPegawaiByNUKLast);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Riwayat_Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public RiwayatGajiPegawai getGajiPegawaiByNUKRiwayat(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        RiwayatGajiPegawai g = null;
        try {
            ps = connection.prepareStatement(sqlGetRiwayatGajiPegawaiByNUKLast);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                g = new RiwayatGajiPegawai();
                g.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk));
                g.setGaji_pokok(rs.getDouble("gaji_pokok"));
                g.setTunjangan_suami_istri(rs.getDouble("tunjangan_suami_istri"));
                g.setTunjangan_anak(rs.getDouble("tunjangan_anak"));
                g.setTunjangan_lain(rs.getDouble("tunjangan_lain"));
                g.setTotal_gaji(rs.getDouble("total_gaji"));
                g.setTanggungan_orang(rs.getInt("tanggungan_orang"));
                g.setKgb_berikutnya(rs.getInt("kgb_berikutnya"));
                g.setKbg_yad_date(rs.getString("kgb_yad"));
                g.setKgb_yad_indo(rs.getString("kgb_yad_indo"));
                g.setPangkat(DaoFactory.getPangkatDao().getPangkatByID(rs.getInt("idpangkat")));
                g.setPekerjaanJabatan(DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByID(rs.getInt("idjabatan")));
                g.setTmt_lama(rs.getString("tmt_lama"));
                g.setNo_kgb(rs.getString("no_kgb_lama"));
                g.setTanggal(rs.getString("tanggal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Riwayat_Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    @Override
    public List<RiwayatGajiPegawai> getAllRiwayatGajiPegawai() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RiwayatGajiPegawai> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllRiwayatGaji);
            rs = ps.executeQuery();
            list = new ArrayList<RiwayatGajiPegawai>();
            while (rs.next()) {
                RiwayatGajiPegawai g = new RiwayatGajiPegawai();
                g = new RiwayatGajiPegawai();
                g.setId(rs.getInt("id"));
                g.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                g.setGaji_pokok(rs.getDouble("gaji_pokok"));
                g.setTunjangan_suami_istri(rs.getDouble("tunjangan_suami_istri"));
                g.setTunjangan_anak(rs.getDouble("tunjangan_anak"));
                g.setTunjangan_lain(rs.getDouble("tunjangan_lain"));
                g.setTotal_gaji(rs.getDouble("total_gaji"));
                g.setTanggungan_orang(rs.getInt("tanggungan_orang"));
                g.setKgb_berikutnya(rs.getInt("kgb_berikutnya"));
                g.setKbg_yad_date(rs.getString("kgb_yad"));
                g.setKgb_yad_indo(rs.getString("kgb_yad_indo"));
                g.setPangkat(DaoFactory.getPangkatDao().getPangkatByID(rs.getInt("idpangkat")));
                g.setPekerjaanJabatan(DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByID(rs.getInt("idjabatan")));
                g.setTmt_lama(rs.getString("tmt_lama"));
                g.setNo_kgb(rs.getString("no_kgb_lama"));
                g.setTanggal(rs.getString("tanggal"));
                list.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Riwayat_Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
