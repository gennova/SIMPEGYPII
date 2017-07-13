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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amnesia
 */
public class Gaji_pegawai_dao_implemen implements Gaji_pegawai_dao {

    private final Connection connection;
    private final String sqlInsertGajiPegawai = "INSERT INTO gajipegawai(nuk,gaji_pokok,tunjangan_suami_istri,tunjangan_anak,tunjangan_lain,total_gaji,tanggungan_orang,kgb_berikutnya,kgb_yad,kgb_yad_indo) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdateGajiPegawai = "update gajipegawai set gaji_pokok=?,tunjangan_suami_istri=?,tunjangan_anak=?,tunjangan_lain=?,total_gaji=?,tanggungan_orang=?,kgb_berikutnya=?,kgb_yad=?,kgb_yad_indo=? where nuk=?";
    private final String sqlGetGajiPegawaiByNUK = "select * from gajipegawai where nuk=?";

    public Gaji_pegawai_dao_implemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertGajiPegawai(Gaji_pegawai gaji_pegawai) {
        PreparedStatement ps = null;
        boolean statusgaji = CekGajiPegawaiByNUK(gaji_pegawai.getPegawai().getNUK());
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
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Berhasil menyimpan data gaji pegawai");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
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
                    System.out.println("Berhasil update data gaji pegawai karna ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean CekGajiPegawaiByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            ps = connection.prepareStatement("select nuk from gajipegawai where nuk=?");
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public Gaji_pegawai getGajiPegawaiByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Gaji_pegawai g = null;
        try {
            ps = connection.prepareStatement(sqlGetGajiPegawaiByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                g = new Gaji_pegawai();
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

}
