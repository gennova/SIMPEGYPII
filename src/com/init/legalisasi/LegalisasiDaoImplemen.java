/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.legalisasi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amnesia
 */
public class LegalisasiDaoImplemen implements LegalisasiDao {

    private final Connection connection;
    private final String sqlGetLegalisasi = "select * from legalisasi";
    private final String sqlUpdateLegalisasi = "update legalisasi set ketua=?,sekretaris=?,jabatan_legalisasi=?";

    public LegalisasiDaoImplemen(Connection c) {
        this.connection = c;
    }

    @Override
    public Legalisasi getLegalisasi() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Legalisasi legalisasi = null;
        try {
            ps = connection.prepareStatement(sqlGetLegalisasi);
            rs = ps.executeQuery();
            while (rs.next()) {
                legalisasi = new Legalisasi();
                legalisasi.setId(rs.getInt("id"));
                legalisasi.setKetua(rs.getString("ketua"));
                legalisasi.setSekretaris(rs.getString("sekretaris"));
                legalisasi.setJabatan(rs.getString("jabatan_legalisasi"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LegalisasiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return legalisasi;
    }

    @Override
    public void updateLegalisasi(Legalisasi legalisasi) {
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(sqlUpdateLegalisasi);
            ps.setString(1, legalisasi.getKetua());
            ps.setString(2, legalisasi.getSekretaris());
            ps.setString(3, legalisasi.getJabatan());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update legalisasi berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(LegalisasiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
