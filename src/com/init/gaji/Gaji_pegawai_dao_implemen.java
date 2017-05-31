/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.gaji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amnesia
 */
public class Gaji_pegawai_dao_implemen implements Gaji_pegawai_dao {

    private final Connection connection;
    private final String sqlInsertGajiPegawai = "INSERT INTO gajipegawai(nuk,gaji_pokok,tunjangan_suami_istri,tunjangan_anak,tunjangan_lain,total_gaji,tanggungan_orang) VALUES (?,?,?,?,?,?,?)";

    public Gaji_pegawai_dao_implemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertGajiPegawai(Gaji_pegawai gaji_pegawai) {
        PreparedStatement ps =null;
        try {
            ps = connection.prepareStatement(sqlInsertGajiPegawai);
            ps.setString(1, gaji_pegawai.getPegawai().getNUK());
            ps.setDouble(2, gaji_pegawai.getGaji_pokok());
            ps.setDouble(3, gaji_pegawai.getTunjangan_suami_istri());
            ps.setDouble(4, gaji_pegawai.getTunjangan_anak());
            ps.setDouble(5, gaji_pegawai.getTunjangan_lain());
            ps.setDouble(6, gaji_pegawai.getTotal_gaji());
            ps.setInt(7, gaji_pegawai.getTanggungan_orang());
            int status = ps.executeUpdate();
            if (status==1) {
                System.out.println("Berhasil menyimpan data gaji pegawai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gaji_pegawai_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
