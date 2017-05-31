/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pendidikan_pegawai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amnesia
 */
public class PendidikanPegawaiDaoImplemen implements PendidikanPegawaiDao {

    private final Connection connection;
    private final String sqlInsertPendidikanPegawai = "INSERT INTO pendidikanpegawai(id_pegawai,nuk,id_ijazah_angkat,tgl_ijazah_sk_angkat,id_pendidikan_akhir,tgl_lulus_sk_pendidikan_akhir) VALUES (?,?,?,?,?,?)";

    public PendidikanPegawaiDaoImplemen(Connection conn) {
        this.connection = conn;
    }

    @Override
    public List<PendidikanPegawai> getAllPendidikanPegawai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PendidikanPegawai getPendidikanPegawaiByNUK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertPendidikanPegawai(PendidikanPegawai ppeg) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertPendidikanPegawai);
            ps.setInt(1, ppeg.getPegawai().getID());
            ps.setString(2, ppeg.getPegawai().getNUK());
            ps.setInt(3, ppeg.getIjazahAngkat().getId());
            ps.setString(4, ppeg.getTglLulusSKPengangkatan());
            ps.setInt(5, ppeg.getPendidikanTerakhir().getId());
            ps.setString(6, ppeg.getTglLulusSKPendidikanAkhir());
            int status = ps.executeUpdate();
            if (status==1) {
                System.out.println("Input data pendidikan pegawai sukses");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanPegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
