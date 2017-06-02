/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pegawai;

import com.init.tools.DaoFactory;
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
public class PegawaiDaoImplemen implements PegawaiDao {

    private final Connection connection;
    private final String sqlInsertPegawai = "call spInsertPegawaiUmum(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdatePegawai = "call spUpdatePegawaiUmum(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlGetPegawaiByNUK = "select * from pegawai where nuk=?";
    private final String sqlInsertRumahPegawai = "insert into alamatrumahpegawai (nuk,alamat,telpon,hp) values (?,?,?,?)";
    private final String sqlUpdateRumahPegawai = "update alamatrumahpegawai set alamat=?,telpon=?,hp=? where nuk=?";
    private final String sqlGetRumahPegawaiByNUK = "select * from alamatrumahpegawai where nuk=?";
    private final String sqlGetPegawaiWithBidangKerja = "SELECT * FROM pegawai JOIN pekerjaanjabatan ON pegawai.nuk=pekerjaanjabatan.nuk JOIN bidangkerja ON pekerjaanjabatan.idbidangkerja=bidangkerja.id order by pegawai.nuk asc";
    private final String sqlGetPegawaiWithBidangKerjaNama = "SELECT * FROM pegawai JOIN pekerjaanjabatan ON pegawai.nuk=pekerjaanjabatan.nuk JOIN bidangkerja ON pekerjaanjabatan.idbidangkerja=bidangkerja.id order by pegawai.namapegawai asc";
    private final String sqlGetPegawaiWithBidangKerjaWilayah = "SELECT * FROM pegawai JOIN pekerjaanjabatan ON pegawai.nuk=pekerjaanjabatan.nuk JOIN bidangkerja ON pekerjaanjabatan.idbidangkerja=bidangkerja.id JOIN cabang ON pekerjaanjabatan.idcabang=cabang. id ORDER BY cabang.namacabang ASC";
    private final String sqlGetPegawaiWithBidangKerjaUrut = "SELECT * FROM pegawai JOIN pekerjaanjabatan ON pegawai.nuk=pekerjaanjabatan.nuk JOIN bidangkerja ON pekerjaanjabatan.idbidangkerja=bidangkerja.id JOIN cabang ON pekerjaanjabatan.idcabang=cabang. id ORDER BY bidangkerja.namabidangkerja ASC";
    private final String sqlGetPegawaiWithBidangKerjaGolongan = "SELECT * FROM pegawai JOIN pekerjaanjabatan ON pegawai.nuk=pekerjaanjabatan.nuk JOIN bidangkerja ON pekerjaanjabatan.idbidangkerja=bidangkerja.id JOIN pangkatpegawai ON pegawai.nuk=pangkatpegawai.nuk JOIN golongan ON pangkatpegawai.idgolongan = golongan.id ORDER BY golongan.namagolongan ASC";
    private final String sqlGetPegawaiWithBidangKerjaUnit = "SELECT * FROM pegawai JOIN pekerjaanjabatan ON pegawai.nuk=pekerjaanjabatan.nuk JOIN bidangkerja ON pekerjaanjabatan.idbidangkerja=bidangkerja.id  JOIN unit ON pekerjaanjabatan.idunit=unit.id ORDER BY unit.namaunit ASC";

    public PegawaiDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pegawai> getAllPegawai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertPegawai(Pegawai pegawai) {
        PreparedStatement ps = null;
        boolean cek_status_pegawai = CekPegawaiByNUK(pegawai.getNUK());
        if (cek_status_pegawai == true) {
            try {
                ps = connection.prepareStatement(sqlUpdatePegawai);
                ps.setString(1, pegawai.getNUK());
                ps.setString(2, pegawai.getGelarDepan());
                ps.setString(3, pegawai.getNama());
                ps.setString(4, pegawai.getGelarBelakang());
                ps.setString(5, pegawai.getAlias());
                ps.setString(6, pegawai.getJK());
                ps.setString(7, pegawai.getAgama());
                ps.setString(8, pegawai.getTLahir());
                ps.setString(9, pegawai.getTglLahir());
                ps.setString(10, pegawai.getStatusPerkawinan());
                ps.setInt(11, pegawai.getJumlahAnakSeluruh());
                ps.setInt(12, pegawai.getJumlahAnakGaji());
                ps.setString(13, pegawai.getStatusPegawai());
                ps.setString(14, pegawai.getTeksFilename());
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Data Pegawai Berhasil Diupdate Karna Sudah ada");
                System.out.println("Data berhasil diupdate karena sudah ada");
            } catch (SQLException ex) {
                Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (cek_status_pegawai == false) {
            try {
                ps = connection.prepareStatement(sqlInsertPegawai);
                ps.setString(1, pegawai.getNUK());
                ps.setString(2, pegawai.getGelarDepan());
                ps.setString(3, pegawai.getNama());
                ps.setString(4, pegawai.getGelarBelakang());
                ps.setString(5, pegawai.getAlias());
                ps.setString(6, pegawai.getJK());
                ps.setString(7, pegawai.getAgama());
                ps.setString(8, pegawai.getTLahir());
                ps.setString(9, pegawai.getTglLahir());
                ps.setString(10, pegawai.getStatusPerkawinan());
                ps.setInt(11, pegawai.getJumlahAnakSeluruh());
                ps.setInt(12, pegawai.getJumlahAnakGaji());
                ps.setString(13, pegawai.getStatusPegawai());
                ps.setString(14, pegawai.getTeksFilename());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Pegawai Berhasil Ditambahkan");
            } catch (SQLException ex) {
                Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Pegawai getPegawaiByNUK(String nuk) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Pegawai p = null;
        try {
            statement = connection.prepareStatement(sqlGetPegawaiByNUK);
            statement.setString(1, nuk);
            rs = statement.executeQuery();
            if (rs.next()) {
                p = new Pegawai();
                p.setID(rs.getInt("id"));
                p.setNUK(rs.getString("nuk"));
                p.setGelarDepan(rs.getString("gelardepan"));
                p.setNama(rs.getString("namapegawai"));
                p.setGelarBelakang(rs.getString("gelarbelakang"));
                p.setAlias(rs.getString("alias"));
                p.setJK(rs.getString("jeniskelamin"));
                p.setAgama(rs.getString("agama"));
                p.setTLahir(rs.getString("tempatlahir"));
                p.setTglLahir(rs.getString("tanggallahir"));
                p.setStatusPerkawinan(rs.getString("statuspernikahan"));
                p.setJumlahAnakSeluruh(rs.getInt("jumlahanakseluruh"));
                p.setJumlahAnakGaji(rs.getInt("jumlahanakgaji"));
                p.setStatusPegawai(rs.getString("statuspegawai"));
                p.setTeksFilename(rs.getString("filephoto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public List getComboTempatLahir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRumahPegawai(String nuk, String alamat, String telepon, String hp) {
        PreparedStatement ps = null;
        try {
            boolean status = cekRumahByNUK(nuk);
            if (status == false) {
                ps = connection.prepareStatement(sqlInsertRumahPegawai);
                ps.setString(1, nuk);
                ps.setString(2, alamat);
                ps.setString(3, telepon);
                ps.setString(4, hp);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Rumah Berhasil Disimpan");
            } else if (status == true) {
                ps = connection.prepareStatement(sqlUpdateRumahPegawai);
                ps.setString(1, alamat);
                ps.setString(2, telepon);
                ps.setString(3, hp);
                ps.setString(4, nuk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Rumah Berhasil Diupdate");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String[] getAlamatRumahPegawai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rumah getRumahPegawaiByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rumah rumah = new Rumah();
        try {
            ps = connection.prepareStatement(sqlGetRumahPegawaiByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                rumah.setAlamat(rs.getString("alamat"));
                rumah.setTelpon(rs.getString("telpon"));
                rumah.setHP(rs.getString("hp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rumah;
    }

    @Override
    public boolean cekRumahByNUK(String nuk) {
        boolean status = false;
        try {
            PreparedStatement ps = connection.prepareStatement("select nuk from alamatrumahpegawai where nuk=?");
            ps.setString(1, nuk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public List<Pegawai> getAllPegawaiAndBidangKerja() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pegawai> list = null;
        try {
            ps = connection.prepareStatement(sqlGetPegawaiWithBidangKerja);
            rs = ps.executeQuery();
            list = new ArrayList<Pegawai>();
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setNUK(rs.getString("nuk"));
                pegawai.setNama(rs.getString("namapegawai"));
                pegawai.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                list.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pegawai> getAllPegawaiAndBidangKerjaNama() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pegawai> list = null;
        try {
            ps = connection.prepareStatement(sqlGetPegawaiWithBidangKerjaNama);
            rs = ps.executeQuery();
            list = new ArrayList<Pegawai>();
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setNUK(rs.getString("nuk"));
                pegawai.setNama(rs.getString("namapegawai"));
                pegawai.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                list.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pegawai> getAllPegawaiAndBidangKerjaWilayah() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pegawai> list = null;
        try {
            ps = connection.prepareStatement(sqlGetPegawaiWithBidangKerjaWilayah);
            rs = ps.executeQuery();
            list = new ArrayList<Pegawai>();
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setNUK(rs.getString("nuk"));
                pegawai.setNama(rs.getString("namapegawai"));
                pegawai.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                list.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pegawai> getAllPegawaiAndBidangKerjaBidangKerja() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pegawai> list = null;
        try {
            ps = connection.prepareStatement(sqlGetPegawaiWithBidangKerjaUrut);
            rs = ps.executeQuery();
            list = new ArrayList<Pegawai>();
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setNUK(rs.getString("nuk"));
                pegawai.setNama(rs.getString("namapegawai"));
                pegawai.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                list.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pegawai> getAllPegawaiAndBidangKerjaGolongan() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pegawai> list = null;
        try {
            ps = connection.prepareStatement(sqlGetPegawaiWithBidangKerjaGolongan);
            rs = ps.executeQuery();
            list = new ArrayList<Pegawai>();
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setNUK(rs.getString("nuk"));
                pegawai.setNama(rs.getString("namapegawai"));
                pegawai.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                list.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Pegawai> getAllPegawaiAndBidangKerjaUnitKerja() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pegawai> list = null;
        try {
            ps = connection.prepareStatement(sqlGetPegawaiWithBidangKerjaUnit);
            rs = ps.executeQuery();
            list = new ArrayList<Pegawai>();
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setNUK(rs.getString("nuk"));
                pegawai.setNama(rs.getString("namapegawai"));
                pegawai.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                list.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean CekPegawaiByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            ps = connection.prepareStatement("select nuk from pegawai where nuk=?");
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
