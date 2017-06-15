/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.sk_pegawai;

import com.init.statuspegawai.PegawaiStatus;
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
public class SK_Pegawai_DaoImplemen implements SK_Pegawai_Dao {

    private final Connection connection;
    private final String SqlInsertSKPegawai = "insert into sk_status_pegawai(kolom,nuk,jenis_sk,tmt,tmt_indo,nomor_sk,tanggal,tanggalindo) values (?,?,?,?,?,?,?,?)";
    private final String SqlUpdateSKPegawai = "update sk_status_pegawai set jenis_sk=?,tmt=?,tmt_indo=?,nomor_sk=?,tanggal=?,tanggalindo=? where kolom=? and nuk=?";
    private final String SqlCekSKPegawai = "select nuk from sk_status_pegawai where nuk=? and kolom=?";
    private final String SQLGetSKPegawaiByNUK_KOLOM = "select * from sk_status_pegawai where kolom=? and nuk=?";

    public SK_Pegawai_DaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SK_Pegawai> getAllSKPegawai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SK_Pegawai getSKPegawaiByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SK_Pegawai getSKPegawaiByNUK(String nuk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SK_Pegawai getSKPegawaiByStatusPegawai(PegawaiStatus pegawaiStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertSKPegawai(SK_Pegawai sk_pegawai) {
        boolean status_skp = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(sk_pegawai.getNuk(), sk_pegawai.getKolom_kategori());
        if (status_skp == true) {
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(SqlUpdateSKPegawai);
                statement.setString(1, sk_pegawai.getStatus_pegawai_str());
                statement.setString(2, sk_pegawai.getTmt());
                statement.setString(3, sk_pegawai.getTmt_indo());
                statement.setString(4, sk_pegawai.getNo_sk());
                statement.setString(5, sk_pegawai.getTanggal());
                statement.setString(6, sk_pegawai.getTanggal_indo());
                statement.setInt(7, sk_pegawai.getKolom_kategori());
                statement.setString(8, sk_pegawai.getNuk());
                int status = statement.executeUpdate();
                if (status == 1) {
                    System.out.println("Sukses update sk pegawai");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SK_Pegawai_DaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (status_skp == false) {
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(SqlInsertSKPegawai);
                statement.setInt(1, sk_pegawai.getKolom_kategori());
                statement.setString(2, sk_pegawai.getNuk());
                statement.setString(3, sk_pegawai.getStatus_pegawai_str());
                statement.setString(4, sk_pegawai.getTmt());
                statement.setString(5, sk_pegawai.getTmt_indo());
                statement.setString(6, sk_pegawai.getNo_sk());
                statement.setString(7, sk_pegawai.getTanggal());
                statement.setString(8, sk_pegawai.getTanggal_indo());
                int status = statement.executeUpdate();
                if (status == 1) {
                    System.out.println("Sukses simpan sk pegawai");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SK_Pegawai_DaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean cekStatusNUK(String nuk, int kolom) {
        boolean status = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(SqlCekSKPegawai);
            statement.setString(1, nuk);
            statement.setInt(2, kolom);
            rs = statement.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SK_Pegawai_DaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    @Override
    public SK_Pegawai getSKPegawaiByNUK(String nuk, int kolom) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        SK_Pegawai skp = null;
        try {
            statement = connection.prepareStatement(SQLGetSKPegawaiByNUK_KOLOM);
            statement.setInt(1, kolom);
            statement.setString(2, nuk);
            rs = statement.executeQuery();
            while (rs.next()) {
                skp = new SK_Pegawai();
                skp.setId(rs.getInt("id"));
                skp.setKolom_kategori(rs.getInt("kolom"));
                skp.setNuk(rs.getString("nuk"));
                skp.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk));
                skp.setStatus_pegawai_str(rs.getString("jenis_sk"));
                skp.setTmt(rs.getString("tmt"));
                skp.setTmt_indo(rs.getString("tmt_indo"));
                skp.setNo_sk(rs.getString("nomor_sk"));
                skp.setTanggal(rs.getString("tanggal"));
                skp.setTanggal_indo(rs.getString("tanggalindo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SK_Pegawai_DaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return skp;
    }

}
