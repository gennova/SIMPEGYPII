/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pendidikan_pegawai;

import com.init.tools.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private final String sqlGetPendidikanByNUK = "select * from pendidikanpegawai where nuk=?";
    private final String sqlInsertPendidikanPegawai = "INSERT INTO pendidikanpegawai(id_pegawai,nuk,id_ijazah_angkat,tgl_ijazah_sk_angkat,id_pendidikan_akhir,tgl_lulus_sk_pendidikan_akhir) VALUES (?,?,?,?,?,?)";
    private final String sqlUpdatePendidikanPegawai = "update pendidikanpegawai set id_ijazah_angkat=?,tgl_ijazah_sk_angkat=?,id_pendidikan_akhir=?,tgl_lulus_sk_pendidikan_akhir=? where nuk=?";

    public PendidikanPegawaiDaoImplemen(Connection conn) {
        this.connection = conn;
    }

    @Override
    public List<PendidikanPegawai> getAllPendidikanPegawai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PendidikanPegawai getPendidikanPegawaiByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        PendidikanPegawai pegawai = null;
        try {
            ps = connection.prepareStatement(sqlGetPendidikanByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                pegawai = new PendidikanPegawai();
                pegawai.setId(rs.getInt("id"));
                pegawai.setIjazahAngkat(DaoFactory.getIjazahAngkatDao().getIjazahAngkatByID(rs.getInt("id_ijazah_angkat")));
                pegawai.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk));
                pegawai.setPendidikanTerakhir(DaoFactory.getPendidikanTerakhirDao().getPendidikanByID(rs.getInt("id_pendidikan_akhir")));
                pegawai.setTglLulusSKPengangkatan(rs.getString("tgl_ijazah_sk_angkat"));
                pegawai.setTglLulusSKPendidikanAkhir(rs.getString("tgl_lulus_sk_pendidikan_akhir"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanPegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pegawai;
    }

    @Override
    public void InsertPendidikanPegawai(PendidikanPegawai ppeg) {
        PreparedStatement ps = null;
        boolean statuspendidikan = cekPendidikanPegawaiByNUK(ppeg.getPegawai().getNUK());
        if (statuspendidikan == false) {
            try {
                ps = connection.prepareStatement(sqlInsertPendidikanPegawai);
                ps.setInt(1, ppeg.getPegawai().getID());
                ps.setString(2, ppeg.getPegawai().getNUK());
                ps.setInt(3, ppeg.getIjazahAngkat().getId());
                ps.setString(4, ppeg.getTglLulusSKPengangkatan());
                ps.setInt(5, ppeg.getPendidikanTerakhir().getId());
                ps.setString(6, ppeg.getTglLulusSKPendidikanAkhir());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Input data pendidikan pegawai sukses");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PendidikanPegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                ps = connection.prepareStatement(sqlUpdatePendidikanPegawai);
                ps.setInt(1, ppeg.getIjazahAngkat().getId());
                ps.setString(2, ppeg.getTglLulusSKPengangkatan());
                ps.setInt(3, ppeg.getPendidikanTerakhir().getId());
                ps.setString(4, ppeg.getTglLulusSKPendidikanAkhir());
                ps.setString(5, ppeg.getPegawai().getNUK());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Update data pendidikan pegawai sukses karena data sudah ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PendidikanPegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean cekPendidikanPegawaiByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            ps = connection.prepareStatement("select nuk from pendidikanpegawai where nuk=?");
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanPegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
