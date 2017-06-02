/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.golonganpangkat;

import com.init.golongan.Golongan;
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
public class PangkatDaoImplemen implements PangkatDao {

    private final Connection connection;
    private final String sqlGetAllPangkatPegawai = "select * from pangkatpegawai";
    private final String sqlGetAllPangkatPegawaiByNUK = "SELECT * FROM pangkatpegawai JOIN golongan ON pangkatpegawai.idgolongan=golongan.id WHERE pangkatpegawai.nuk=?";
    private final String sqlGetAllPangkatPegawaiByID = "select * from pangkatpegawai where id=?";
    private final String sqlGetAllPangkatPegawaiByIDGolongan = "select * from pangkatpegawai where idgolongan=?";
    private final String sqlGetAllPangkatPegawaiByNamaGolongan = "select * from pangkatpegawai join golongan on pangkatpegawai.idgolongan=golongan.id where where pangkatpegawai.idgolongan=?";
    private final String sqlInsertPangkatPegawai = "insert into pangkatpegawai (nuk,idgolongan,tmt_golongan,nomor_sk,tanggal_sk,tmt_kgb,nomor_kgb,tanggal_kgb,tahunkerja,bulankerja,tahunkerjabenar,bulankerjabenar) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdatePangkatPegawai = "update pangkatpegawai set idgolongan=?,tmt_golongan=?,nomor_sk=?,tanggal_sk=?,tmt_kgb=?,nomor_kgb=?,tanggal_kgb=?,tahunkerja=?,bulankerja=?,tahunkerjabenar=?,bulankerjabenar=? where nuk=?";

    public PangkatDaoImplemen(Connection conn) {
        this.connection = conn;
    }

    @Override
    public List<Pangkat> getAllPangkat() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pangkat> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPangkatPegawai);
            rs = ps.executeQuery();
            list = new ArrayList<Pangkat>();
            while (rs.next()) {
                Pangkat pangkat = new Pangkat();
                pangkat.setId(rs.getInt("id"));
                pangkat.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                pangkat.setGolongan(DaoFactory.getGolonganDao().getGolonganByID(rs.getInt("idgolongan")));
                pangkat.setTMTGolongan(sqlGetAllPangkatPegawai);
                pangkat.setNomor_sk(rs.getString("nomor_sk"));
                pangkat.setTanggal_sk(rs.getString("tanggal_sk"));
                pangkat.setTmt_kgb(rs.getString("tmt_kgb"));
                pangkat.setNomor_kgb(rs.getString("nomor_kgb"));
                pangkat.setTanggal_kgb(rs.getString("tanggal_kgb"));
                pangkat.setTahun_masa_kerja(rs.getInt("tahunkerja"));
                pangkat.setBulan_masa_kerja(rs.getInt("bulankerja"));
                pangkat.setTahun_masa_kerja_sebenarnya(rs.getInt("tahunkerjabenar"));
                pangkat.setBulan_masa_kerja_sebenarnya(rs.getInt("bulankerjabenar"));
                list.add(pangkat);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Pangkat getPangkatByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pangkat pangkat = new Pangkat();
        try {
            ps = connection.prepareStatement(sqlGetAllPangkatPegawaiByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                pangkat.setId(rs.getInt("id"));
                pangkat.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                pangkat.setGolongan(DaoFactory.getGolonganDao().getGolonganByID(rs.getInt("idgolongan")));
                pangkat.setTMTGolongan(sqlGetAllPangkatPegawai);
                pangkat.setNomor_sk(rs.getString("nomor_sk"));
                pangkat.setTanggal_sk(rs.getString("tanggal_sk"));
                pangkat.setTmt_kgb(rs.getString("tmt_kgb"));
                pangkat.setNomor_kgb(rs.getString("nomor_kgb"));
                pangkat.setTanggal_kgb(rs.getString("tanggal_kgb"));
                pangkat.setTahun_masa_kerja(rs.getInt("tahunkerja"));
                pangkat.setBulan_masa_kerja(rs.getInt("bulankerja"));
                pangkat.setTahun_masa_kerja_sebenarnya(rs.getInt("tahunkerjabenar"));
                pangkat.setBulan_masa_kerja_sebenarnya(rs.getInt("bulankerjabenar"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pangkat;
    }

    @Override
    public List<Pangkat> getAllPangkatByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pangkat> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPangkatPegawaiByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            list = new ArrayList<Pangkat>();
            while (rs.next()) {
                Pangkat pangkat = new Pangkat();
                pangkat.setId(rs.getInt("id"));
                pangkat.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                pangkat.setGolongan(DaoFactory.getGolonganDao().getGolonganByID(rs.getInt("idgolongan")));
                pangkat.setTMTGolongan(sqlGetAllPangkatPegawai);
                pangkat.setNomor_sk(rs.getString("nomor_sk"));
                pangkat.setTanggal_sk(rs.getString("tanggal_sk"));
                pangkat.setTmt_kgb(rs.getString("tmt_kgb"));
                pangkat.setNomor_kgb(rs.getString("nomor_kgb"));
                pangkat.setTanggal_kgb(rs.getString("tanggal_kgb"));
                pangkat.setTahun_masa_kerja(rs.getInt("tahunkerja"));
                pangkat.setBulan_masa_kerja(rs.getInt("bulankerja"));
                pangkat.setTahun_masa_kerja_sebenarnya(rs.getInt("tahunkerjabenar"));
                pangkat.setBulan_masa_kerja_sebenarnya(rs.getInt("bulankerjabenar"));
                list.add(pangkat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pangkat> getAllPangkatByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pangkat> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPangkatPegawaiByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            list = new ArrayList<Pangkat>();
            while (rs.next()) {
                Pangkat pangkat = new Pangkat();
                pangkat.setId(rs.getInt("id"));
                pangkat.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                pangkat.setGolongan(DaoFactory.getGolonganDao().getGolonganByID(rs.getInt("idgolongan")));
                pangkat.setTMTGolongan(sqlGetAllPangkatPegawai);
                pangkat.setNomor_sk(rs.getString("nomor_sk"));
                pangkat.setTanggal_sk(rs.getString("tanggal_sk"));
                pangkat.setTmt_kgb(rs.getString("tmt_kgb"));
                pangkat.setNomor_kgb(rs.getString("nomor_kgb"));
                pangkat.setTanggal_kgb(rs.getString("tanggal_kgb"));
                pangkat.setTahun_masa_kerja(rs.getInt("tahunkerja"));
                pangkat.setBulan_masa_kerja(rs.getInt("bulankerja"));
                pangkat.setTahun_masa_kerja_sebenarnya(rs.getInt("tahunkerjabenar"));
                pangkat.setBulan_masa_kerja_sebenarnya(rs.getInt("bulankerjabenar"));
                list.add(pangkat);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pangkat> getAllPangkatByIDGolongan(Golongan golongan) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pangkat> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPangkatPegawaiByIDGolongan);
            ps.setInt(1, golongan.getId());
            rs = ps.executeQuery();
            list = new ArrayList<Pangkat>();
            while (rs.next()) {
                Pangkat pangkat = new Pangkat();
                pangkat.setId(rs.getInt("id"));
                pangkat.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                pangkat.setGolongan(DaoFactory.getGolonganDao().getGolonganByID(rs.getInt("idgolongan")));
                pangkat.setTMTGolongan(sqlGetAllPangkatPegawai);
                pangkat.setNomor_sk(rs.getString("nomor_sk"));
                pangkat.setTanggal_sk(rs.getString("tanggal_sk"));
                pangkat.setTmt_kgb(rs.getString("tmt_kgb"));
                pangkat.setNomor_kgb(rs.getString("nomor_kgb"));
                pangkat.setTanggal_kgb(rs.getString("tanggal_kgb"));
                pangkat.setTahun_masa_kerja(rs.getInt("tahunkerja"));
                pangkat.setBulan_masa_kerja(rs.getInt("bulankerja"));
                pangkat.setTahun_masa_kerja_sebenarnya(rs.getInt("tahunkerjabenar"));
                pangkat.setBulan_masa_kerja_sebenarnya(rs.getInt("bulankerjabenar"));
                list.add(pangkat);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pangkat> getAllPangkatByNamaGolongan(Golongan golongan) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pangkat> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPangkatPegawaiByNamaGolongan);
            ps.setString(1, golongan.getNamagolongan());
            rs = ps.executeQuery();
            list = new ArrayList<Pangkat>();
            while (rs.next()) {
                Pangkat pangkat = new Pangkat();
                pangkat.setId(rs.getInt("id"));
                pangkat.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                pangkat.setGolongan(DaoFactory.getGolonganDao().getGolonganByID(rs.getInt("idgolongan")));
                pangkat.setTMTGolongan(sqlGetAllPangkatPegawai);
                pangkat.setNomor_sk(rs.getString("nomor_sk"));
                pangkat.setTanggal_sk(rs.getString("tanggal_sk"));
                pangkat.setTmt_kgb(rs.getString("tmt_kgb"));
                pangkat.setNomor_kgb(rs.getString("nomor_kgb"));
                pangkat.setTanggal_kgb(rs.getString("tanggal_kgb"));
                pangkat.setTahun_masa_kerja(rs.getInt("tahunkerja"));
                pangkat.setBulan_masa_kerja(rs.getInt("bulankerja"));
                pangkat.setTahun_masa_kerja_sebenarnya(rs.getInt("tahunkerjabenar"));
                pangkat.setBulan_masa_kerja_sebenarnya(rs.getInt("bulankerjabenar"));
                list.add(pangkat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void InsertPangkatPegawai(Pangkat pangkat) {
        boolean statuspangkat = cekPangkatPegawai(pangkat.getPegawai().getNUK());
        PreparedStatement ps = null;
        if (statuspangkat == false) {
            try {
                ps = connection.prepareStatement(sqlInsertPangkatPegawai);
                ps.setString(1, pangkat.getPegawai().getNUK());
                ps.setInt(2, pangkat.getGolongan().getId());
                ps.setString(3, pangkat.getTMTGolongan());
                ps.setString(4, pangkat.getNomor_sk());
                ps.setString(5, pangkat.getTanggal_sk());
                ps.setString(6, pangkat.getTmt_kgb());
                ps.setString(7, pangkat.getNomor_kgb());
                ps.setString(8, pangkat.getTanggal_kgb());
                ps.setInt(9, pangkat.getTahun_masa_kerja());
                ps.setInt(10, pangkat.getBulan_masa_kerja());
                ps.setInt(11, pangkat.getTahun_masa_kerja_sebenarnya());
                ps.setInt(12, pangkat.getBulan_masa_kerja_sebenarnya());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Data Pangkat pegawai berhasil Disimpan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (statuspangkat == true) {
            try {
                ps = connection.prepareStatement(sqlUpdatePangkatPegawai);
                ps.setInt(1, pangkat.getGolongan().getId());
                ps.setString(2, pangkat.getTMTGolongan());
                ps.setString(3, pangkat.getNomor_sk());
                ps.setString(4, pangkat.getTanggal_sk());
                ps.setString(5, pangkat.getTmt_kgb());
                ps.setString(6, pangkat.getNomor_kgb());
                ps.setString(7, pangkat.getTanggal_kgb());
                ps.setInt(8, pangkat.getTahun_masa_kerja());
                ps.setInt(9, pangkat.getBulan_masa_kerja());
                ps.setInt(10, pangkat.getTahun_masa_kerja_sebenarnya());
                ps.setInt(11, pangkat.getBulan_masa_kerja_sebenarnya());
                ps.setString(12, pangkat.getPegawai().getNUK());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Data Pangkat pegawai berhasil diupdate karena ada nuk");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void UpdatePangkatPegawai(Pangkat pangkat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeletePangkatPegawai(Pangkat pangkat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cekPangkatPegawai(String nuk) {
        boolean status = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select nuk from pangkatpegawai where nuk=?");
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PangkatDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
