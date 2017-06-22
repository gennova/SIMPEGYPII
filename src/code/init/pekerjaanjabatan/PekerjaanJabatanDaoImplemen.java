/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.init.pekerjaanjabatan;

import com.init.pegawai.Pegawai;
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
public class PekerjaanJabatanDaoImplemen implements PekerjaanJabatanDao {

    private final Connection connection;
    private final String sqlGetPekerjaanJabatanByID = "select * from pekerjaanjabatan where id=?";
    private final String sqlGetPekerjaanJabatanByNUK = "select * from pekerjaanjabatan where nuk=?";
    private final String sqlInsertPekerjaanJabatan = "insert into pekerjaanjabatan(nuk,idbidangkerja,tmt_tanggal_pekerjaan,no_sk_pekerjaan,tgl_sk_pekerjaan,idcabang,idunit,idjabatan,nama_jabatan,masa_jabatan,tmt_tanggal_pekerjaan_indo,tgl_sk_pekerjaan_indo) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdatePekerjaanJabatan = "update pekerjaanjabatan set idbidangkerja=?,tmt_tanggal_pekerjaan=?,no_sk_pekerjaan=?,tgl_sk_pekerjaan=?,idcabang=?,idunit=?,idjabatan=?,nama_jabatan=?,masa_jabatan=? ,tmt_tanggal_pekerjaan_indo=?,tgl_sk_pekerjaan_indo=? where nuk=?";
    private final String sqlPergantianJabatanBaru = " call spGantiJabatan(?)";
    private final String sqlGetAllRiwayatJabatanByNUK = "select * from riwayat_jabatan where nuk=?";

    public PekerjaanJabatanDaoImplemen(Connection connect) {
        this.connection = connect;
    }

    @Override
    public List<PekerjaanJabatan> getAllPekerjaanJabatan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PekerjaanJabatan> getAllPekerjaanJabatanByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PekerjaanJabatan> getAllPekerjaanJabatanByNUK(Pegawai pegawai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertPekerjaanJabatan(PekerjaanJabatan pekerjaan) {
        PreparedStatement ps = null;
        boolean statuspekerjaanjabatan = cekPekerjaanJabatanByNUK(pekerjaan.getPegawai().getNUK());
        if (statuspekerjaanjabatan == false) {
            try {
                ps = connection.prepareStatement(sqlInsertPekerjaanJabatan);
                ps.setString(1, pekerjaan.getPegawai().getNUK());
                ps.setInt(2, pekerjaan.getBk().getId());
                ps.setString(3, pekerjaan.getTglTMTPekerjaan());
                ps.setString(4, pekerjaan.getNomorSKPekerjaan());
                ps.setString(5, pekerjaan.getTglSKPekerjaan());
                ps.setInt(6, pekerjaan.getCabang().getIdCabang());
                ps.setInt(7, pekerjaan.getUnit().getID());
                ps.setInt(8, pekerjaan.getJabatan().getId());
                ps.setString(9, pekerjaan.getNamaJabatan());
                ps.setInt(10, pekerjaan.getMasaJabatan());
                ps.setString(11, pekerjaan.getTglTMTPekerjaan_indo());
                ps.setString(12, pekerjaan.getTglSKPekerjaan_indo());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Berhasil menyimpan data Pekerjaan Jabatan pegawai");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PekerjaanJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (statuspekerjaanjabatan == true) {
            try {
                ps = connection.prepareStatement(sqlUpdatePekerjaanJabatan);
                ps.setInt(1, pekerjaan.getBk().getId());
                ps.setString(2, pekerjaan.getTglTMTPekerjaan());
                ps.setString(3, pekerjaan.getNomorSKPekerjaan());
                ps.setString(4, pekerjaan.getTglSKPekerjaan());
                ps.setInt(5, pekerjaan.getCabang().getIdCabang());
                ps.setInt(6, pekerjaan.getUnit().getID());
                ps.setInt(7, pekerjaan.getJabatan().getId());
                ps.setString(8, pekerjaan.getNamaJabatan());
                ps.setInt(9, pekerjaan.getMasaJabatan());
                ps.setString(10, pekerjaan.getTglTMTPekerjaan_indo());
                ps.setString(11, pekerjaan.getTglSKPekerjaan_indo());
                ps.setString(12, pekerjaan.getPegawai().getNUK());
                int status = ps.executeUpdate();
                if (status == 1) {
                    System.out.println("Berhasil memperbaharui data Pekerjaan Jabatan pegawai karena data sudah ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PekerjaanJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void UpdatePekerjaanJabatan(PekerjaanJabatan pekerjaan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeletePekerjaanJabatanByID(PekerjaanJabatan pekerjaan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PekerjaanJabatan getPekerjaanJabatanByID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        PekerjaanJabatan jabatan = null;
        try {
            ps = connection.prepareStatement(sqlGetPekerjaanJabatanByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                jabatan = new PekerjaanJabatan();
                jabatan.setId(rs.getInt("id"));
                jabatan.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                jabatan.setCabang(DaoFactory.getCabangDao().getCabangByID(rs.getInt("idcabang")));
                jabatan.setJabatan(DaoFactory.getJabatanDao().getJabatanByID(rs.getInt("idjabatan")));
                jabatan.setMasaJabatan(rs.getInt("masa_jabatan"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                jabatan.setNomorSKPekerjaan(rs.getString("no_sk_pekerjaan"));
                jabatan.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                jabatan.setTglSKPekerjaan(rs.getString("tgl_sk_pekerjaan"));
                jabatan.setTglTMTPekerjaan(rs.getString("tmt_tanggal_pekerjaan"));
                jabatan.setUnit(DaoFactory.getUnitDao().getUnitByID(rs.getInt("idunit")));
                jabatan.setTglTMTPekerjaan_indo(rs.getString("tmt_tanggal_pekerjaan_indo"));
                jabatan.setTglSKPekerjaan_indo(rs.getString("tgl_sk_pekerjaan_indo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabatan;
    }

    @Override
    public PekerjaanJabatan getPekerjaanJabatanByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        PekerjaanJabatan jabatan = null;
        try {
            ps = connection.prepareStatement(sqlGetPekerjaanJabatanByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                jabatan = new PekerjaanJabatan();
                jabatan.setId(rs.getInt("id"));
                jabatan.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                jabatan.setCabang(DaoFactory.getCabangDao().getCabangByID(rs.getInt("idcabang")));
                jabatan.setJabatan(DaoFactory.getJabatanDao().getJabatanByID(rs.getInt("idjabatan")));
                jabatan.setMasaJabatan(rs.getInt("masa_jabatan"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                jabatan.setNomorSKPekerjaan(rs.getString("no_sk_pekerjaan"));
                jabatan.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                jabatan.setTglSKPekerjaan(rs.getString("tgl_sk_pekerjaan"));
                jabatan.setTglTMTPekerjaan(rs.getString("tmt_tanggal_pekerjaan"));
                jabatan.setUnit(DaoFactory.getUnitDao().getUnitByID(rs.getInt("idunit")));
                jabatan.setTglTMTPekerjaan_indo(rs.getString("tmt_tanggal_pekerjaan_indo"));
                jabatan.setTglSKPekerjaan_indo(rs.getString("tgl_sk_pekerjaan_indo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabatan;
    }

    @Override
    public boolean cekPekerjaanJabatanByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            ps = connection.prepareStatement("select nuk from pekerjaanjabatan where nuk=?");
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public void PergantianJabatanBaru(int id_pkj) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlPergantianJabatanBaru);
            statement.setInt(1, id_pkj);
            int status = statement.executeUpdate();
            if (status == 0) {
                System.out.println("Berhasil melakukan ganti jabatan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PekerjaanJabatan> getAllRiwayatJabatanByNUK(String nuk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PekerjaanJabatan> lists = null;
        try {
            ps = connection.prepareStatement(sqlGetAllRiwayatJabatanByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            lists = new ArrayList<PekerjaanJabatan>();
            while (rs.next()) {
                PekerjaanJabatan jabatan = new PekerjaanJabatan();
                jabatan = new PekerjaanJabatan();
                jabatan.setId(rs.getInt("id"));
                jabatan.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                jabatan.setCabang(DaoFactory.getCabangDao().getCabangByID(rs.getInt("idcabang")));
                jabatan.setJabatan(DaoFactory.getJabatanDao().getJabatanByID(rs.getInt("idjabatan")));
                jabatan.setMasaJabatan(rs.getInt("masa_jabatan"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                jabatan.setNomorSKPekerjaan(rs.getString("no_sk_pekerjaan"));
                jabatan.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(rs.getString("nuk")));
                jabatan.setTglSKPekerjaan(rs.getString("tgl_sk_pekerjaan"));
                jabatan.setTglTMTPekerjaan(rs.getString("tmt_tanggal_pekerjaan"));
                jabatan.setUnit(DaoFactory.getUnitDao().getUnitByID(rs.getInt("idunit")));
                jabatan.setTglTMTPekerjaan_indo(rs.getString("tmt_tanggal_pekerjaan_indo"));
                jabatan.setTglSKPekerjaan_indo(rs.getString("tgl_sk_pekerjaan_indo"));
                lists.add(jabatan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanJabatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

}
