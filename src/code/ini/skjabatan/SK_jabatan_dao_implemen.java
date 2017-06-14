/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.ini.skjabatan;

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
public class SK_jabatan_dao_implemen implements SK_jabatan_dao {

    private final Connection connection;
    private final String sqlInsertSK_Jabatan = "insert into sk_jabatan(nuk,id_jabatan,id_pekerjaan_jabatan,tmt,tmt_indo,sk_jabatan,tanggal,tanggalindo) values (?,?,?,?,?,?,?,?)";
    private final String sqlUpdateSK_JabatanByNUK = "update sk_jabatan set id_jabatan=?,id_pekerjaan_jabatan=?,tmt=?,tmt_indo=?,sk_jabatan=?,tanggal=?,tanggalindo=? where nuk=?";
    private final String sqlGetAllSKJabatan = "select * from sk_jabatan";
    private final String sqlGetSKJabatanByNUK = "select * from sk_jabatan where nuk =?";

    public SK_jabatan_dao_implemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SK_jabatan> getAllSK_Jabatan() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<SK_jabatan> sK_jabatans = null;
        try {
            sK_jabatans = new ArrayList<SK_jabatan>();
            statement = connection.prepareStatement(sqlGetAllSKJabatan);
            rs = statement.executeQuery();
            while (rs.next()) {
                SK_jabatan sk = new SK_jabatan();
                sk.setId(rs.getInt("id"));
                sk.setNuk(rs.getString("nuk"));
                sk.setJabatan(DaoFactory.getJabatanDao().getJabatanByID(rs.getInt("id_jabatan")));
                sk.setPekerjaanJabatan(DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByID(rs.getInt("id_pekerjaan_jabatan")));
                sk.setId_jabatan(rs.getInt("id_jabatan"));
                sk.setId_pekerjaan_jabatan(rs.getInt("id_pekerjaan_jabatan"));
                sk.setTmt(rs.getString("tmt"));
                sk.setTmt_indo("tmt_indo");
                sk.setNo_sk(rs.getString("sk_jabatan"));
                sk.setTanggal(rs.getString("tanggal"));
                sk.setTanggal_indo(rs.getString("tanggalindo"));
                sk.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK("nuk"));
                sK_jabatans.add(sk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SK_jabatan_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sK_jabatans;

    }

    @Override
    public SK_jabatan getSKJabatanByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SK_jabatan getSKJabatanByID_Jabatan(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SK_jabatan getSKJabatanByID_Pekerjaan_Jabatan(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SK_jabatan getSKJabatanByNUK(String nuk) {
        SK_jabatan sk = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            sk = new SK_jabatan();
            ps = connection.prepareStatement(sqlGetSKJabatanByNUK);
            ps.setString(1, nuk);
            rs = ps.executeQuery();
            while (rs.next()) {
                sk.setId(rs.getInt("id"));
                sk.setNuk(rs.getString("nuk"));
                sk.setJabatan(DaoFactory.getJabatanDao().getJabatanByID(rs.getInt("id_jabatan")));
                sk.setPekerjaanJabatan(DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByID(rs.getInt("id_pekerjaan_jabatan")));
                sk.setId_jabatan(rs.getInt("id_jabatan"));
                sk.setId_pekerjaan_jabatan(rs.getInt("id_pekerjaan_jabatan"));
                sk.setTmt(rs.getString("tmt"));
                sk.setTmt_indo("tmt_indo");
                sk.setNo_sk(rs.getString("sk_jabatan"));
                sk.setTanggal(rs.getString("tanggal"));
                sk.setTanggal_indo(rs.getString("tanggalindo"));
                sk.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK("nuk"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SK_jabatan_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sk;

    }

    @Override
    public void InsertSK_Jabatan(Pegawai pegawai, SK_jabatan sk) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertSK_Jabatan);
            statement.setString(1, pegawai.getNUK());
            statement.setInt(2, sk.getId_jabatan());
            statement.setInt(3, sk.getId_pekerjaan_jabatan());
            statement.setString(4, sk.getTmt());
            statement.setString(5, sk.getTmt_indo());
            statement.setString(6, sk.getNo_sk());
            statement.setString(7, sk.getTanggal());
            statement.setString(8, sk.getTanggal_indo());
            int status = statement.executeUpdate();
            if (status == 1) {
                System.out.println("Data SK Jabatan Kolom 2 Saved Insert");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SK_jabatan_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateSK_Jabatan(Pegawai pegawai, SK_jabatan sk) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlUpdateSK_JabatanByNUK);
            statement.setInt(1, sk.getId_jabatan());
            statement.setInt(2, sk.getId_pekerjaan_jabatan());
            statement.setString(3, sk.getTmt());
            statement.setString(4, sk.getTmt_indo());
            statement.setString(5, sk.getNo_sk());
            statement.setString(6, sk.getTanggal());
            statement.setString(7, sk.getTanggal_indo());
            statement.setString(8, pegawai.getNUK());
            int status = statement.executeUpdate();
            if (status == 1) {
                System.out.println("Data SK Jabatan Kolom 2 Saved Update");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SK_jabatan_dao_implemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
