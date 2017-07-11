/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import code.ini.skjabatan.SK_jabatan_dao;
import code.ini.skjabatan.SK_jabatan_dao_implemen;
import code.init.pekerjaanjabatan.PekerjaanJabatan;
import code.init.pekerjaanjabatan.PekerjaanJabatanDao;
import code.init.pekerjaanjabatan.PekerjaanJabatanDaoImplemen;
import com.init.anggotakeluarga.AnggotaKeluargaDao;
import com.init.anggotakeluarga.AnggotaKeluargaDaoImplemen;
import com.init.badan.BadanDao;
import com.init.badan.BadanDaoImplemen;
import com.init.bidangkerja.BidangKerjaDao;
import com.init.bidangkerja.BidangKerjaDaoImplemen;
import com.init.cabang.CabangDao;
import com.init.cabang.CabangDaoImplemen;
import com.init.gaji.Gaji_pegawai_dao;
import com.init.gaji.Gaji_pegawai_dao_implemen;
import com.init.golongan.GolonganDao;
import com.init.golongan.GolonganDaoImplemen;
import com.init.golonganpangkat.PangkatDao;
import com.init.golonganpangkat.PangkatDaoImplemen;
import com.init.ijazah.IjazahAngkatDao;
import com.init.ijazah.IjazahAngkatDaoImplemen;
import com.init.jabatan.JabatanDao;
import com.init.jabatan.JabatanDaoImplemen;
import com.init.jenistugas.JenisTugasDao;
import com.init.jenistugas.JenisTugasDaoImplemen;
import com.init.kartu.KartuDao;
import com.init.kartu.KartuDaoImplemen;
import com.init.pegawai.PegawaiDao;
import com.init.pegawai.PegawaiDaoImplemen;
import com.init.pendidikan_pegawai.PendidikanPegawaiDao;
import com.init.pendidikan_pegawai.PendidikanPegawaiDaoImplemen;
import com.init.pendidikanterakhir.PendidikanTerakhirDao;
import com.init.pendidikanterakhir.PendidikanTerakhirDaoImplemen;
import com.init.provinsi.ProvinsiDao;
import com.init.provinsi.ProvinsiDaoImplemen;
import com.init.riwayat_jabatan.RiwayatJabatanDao;
import com.init.riwayat_jabatan.RiwayatJabatanDaoImplemen;
import com.init.riwayat_skp.RiwayatSK_KP;
import com.init.riwayat_skp.RiwayatSK_KPDao;
import com.init.riwayat_skp.RiwayatSK_KPDaoImplemen;
import com.init.rumah.RumahDao;
import com.init.rumah.RumahDaoImplemen;
import com.init.sk_pegawai.SK_Pegawai_Dao;
import com.init.sk_pegawai.SK_Pegawai_DaoImplemen;
import com.init.statuspegawai.PegawaiStatusDao;
import com.init.statuspegawai.PegawaiStatusDaoImplemen;
import com.init.unit.UnitDao;
import com.init.unit.UnitDaoImplemen;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tendy Developer
 */
public class DaoFactory {

    private static Connection connection = null;
    private static final String url = "jdbc:mysql://";
    static String user = "";
    static String password = "";
    private static Statement st = null;
    private static CabangDao cabangDao;
    private static GolonganDao golonganDao;
    private static PegawaiDao pegawaiDao;
    private static UnitDao unitDao;
    private static PegawaiStatusDao pegawaiStatusDao;
    private static JabatanDao jabatanDao;
    private static PendidikanTerakhirDao pendidikanTerakhirDao;
    private static IjazahAngkatDao ijazahAngkatDao;
    private static BidangKerjaDao bidangKerjaDao;
    private static JenisTugasDao jenisTugasDao;
    private static ProvinsiDao provinsiDao;
    private static RumahDao rumahDao;
    private static KartuDao kartuDao;
    private static BadanDao badanDao;
    private static AnggotaKeluargaDao anggotaKeluargaDao;
    private static PangkatDao pangkatDao;
    private static PekerjaanJabatanDao pekerjaanJabatanDao;
    private static PendidikanPegawaiDao pendidikanPegawaiDao;
    private static Gaji_pegawai_dao gaji_pegawai_dao;
    private static SK_jabatan_dao sK_jabatan_dao;
    private static SK_Pegawai_Dao k_Pegawai_Dao;
    private static RiwayatSK_KPDao riwayatSK_KPDao;
    private static RiwayatJabatanDao riwayatJabatanDao;

    public static RiwayatJabatanDao getRiwayatJabatanDao() {
        if (riwayatJabatanDao == null) {
            riwayatJabatanDao = new RiwayatJabatanDaoImplemen(getConnectionFix());
        }
        return riwayatJabatanDao;
    }

    public static RiwayatSK_KPDao getRiwayatSK_KPDao() {
        if (riwayatSK_KPDao == null) {
            riwayatSK_KPDao = new RiwayatSK_KPDaoImplemen(getConnectionFix());
        }
        return riwayatSK_KPDao;
    }

    public static SK_Pegawai_Dao getK_Pegawai_Dao() {
        if (k_Pegawai_Dao == null) {
            k_Pegawai_Dao = new SK_Pegawai_DaoImplemen(getConnectionFix());
        }
        return k_Pegawai_Dao;
    }

    public static SK_jabatan_dao getsK_jabatan_dao() {
        if (sK_jabatan_dao == null) {
            sK_jabatan_dao = new SK_jabatan_dao_implemen(getConnectionFix());
        }
        return sK_jabatan_dao;
    }

    public static Gaji_pegawai_dao getGaji_pegawai_dao() {
        if (gaji_pegawai_dao == null) {
            gaji_pegawai_dao = new Gaji_pegawai_dao_implemen(getConnectionFix());
        }
        return gaji_pegawai_dao;
    }

    public static PendidikanPegawaiDao getPendidikanPegawaiDao() {
        if (pendidikanPegawaiDao == null) {
            pendidikanPegawaiDao = new PendidikanPegawaiDaoImplemen(getConnectionFix());
        }
        return pendidikanPegawaiDao;
    }

    public static PekerjaanJabatanDao getPekerjaanJabatanDao() {
        if (pekerjaanJabatanDao == null) {
            pekerjaanJabatanDao = new PekerjaanJabatanDaoImplemen(getConnectionFix());
        }
        return pekerjaanJabatanDao;
    }

    public static PangkatDao getPangkatDao() {
        if (pangkatDao == null) {
            pangkatDao = new PangkatDaoImplemen(getConnectionFix());
        }
        return pangkatDao;
    }

    public static AnggotaKeluargaDao getAnggotaKeluargaDao() {
        if (anggotaKeluargaDao == null) {
            anggotaKeluargaDao = new AnggotaKeluargaDaoImplemen(getConnectionFix());
        }
        return anggotaKeluargaDao;
    }

    public static BadanDao getBadanDao() {
        if (badanDao == null) {
            badanDao = new BadanDaoImplemen(getConnectionFix());
        }
        return badanDao;
    }

    public static KartuDao getKartuDao() {
        if (kartuDao == null) {
            kartuDao = new KartuDaoImplemen(getConnectionFix());
        }
        return kartuDao;
    }

    public static RumahDao getRumahDao() {
        if (rumahDao == null) {
            rumahDao = new RumahDaoImplemen(getConnectionFix());
        }
        return rumahDao;
    }

    public static ProvinsiDao getProvinsiDao() {
        if (provinsiDao == null) {
            provinsiDao = new ProvinsiDaoImplemen(getConnectionFix());
        }
        return provinsiDao;
    }

    public static JenisTugasDao getJenisTugasDao() {
        if (jenisTugasDao == null) {
            jenisTugasDao = new JenisTugasDaoImplemen(getConnectionFix());
        }
        return jenisTugasDao;
    }

    public static BidangKerjaDao getBidangKerjaDao() {
        if (bidangKerjaDao == null) {
            bidangKerjaDao = new BidangKerjaDaoImplemen(getConnectionFix());
        }
        return bidangKerjaDao;
    }

    public static IjazahAngkatDao getIjazahAngkatDao() {
        if (ijazahAngkatDao == null) {
            ijazahAngkatDao = new IjazahAngkatDaoImplemen(getConnectionFix());
        }
        return ijazahAngkatDao;
    }

    public static PendidikanTerakhirDao getPendidikanTerakhirDao() {
        if (pendidikanTerakhirDao == null) {
            pendidikanTerakhirDao = new PendidikanTerakhirDaoImplemen(getConnectionFix());
        }
        return pendidikanTerakhirDao;
    }

    public static JabatanDao getJabatanDao() {
        if (jabatanDao == null) {
            jabatanDao = new JabatanDaoImplemen(getConnectionFix());
        }
        return jabatanDao;
    }

    public static PegawaiStatusDao getPegawaiStatusDao() {
        if (pegawaiStatusDao == null) {
            pegawaiStatusDao = new PegawaiStatusDaoImplemen(getConnectionFix());
        }
        return pegawaiStatusDao;
    }

    public static UnitDao getUnitDao() {
        if (unitDao == null) {
            unitDao = new UnitDaoImplemen(getConnectionFix());
        }
        return unitDao;
    }

    public static CabangDao getCabangDao() {
        if (cabangDao == null) {
            cabangDao = new CabangDaoImplemen(getConnectionFix());
        }
        return cabangDao;
    }

    public static GolonganDao getGolonganDao() {
        if (golonganDao == null) {
            golonganDao = new GolonganDaoImplemen(getConnectionFix());
        }
        return golonganDao;
    }

    public static PegawaiDao getPegawaiDao() {
        if (pegawaiDao == null) {
            pegawaiDao = new PegawaiDaoImplemen(getConnectionFix());
        }
        return pegawaiDao;
    }

    public static Connection getConnectionFix() {
        if (connection == null) {
            Koneksi k = new Koneksi();
            connection = k.getKoneksi();
        }
        return connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage());
            }
            FileInputStream in = null;
            try {
                String urlFile = "";
                String urlCOmplete = "";
                in = new FileInputStream("resource.xml");
                Properties p = new Properties();
                p.loadFromXML(in);
                urlFile = p.getProperty("host") + ":" + p.getProperty("PORT") + "/" + p.getProperty("DBNAME");
                urlCOmplete = url + urlFile;
                System.out.println(urlCOmplete);
                user = p.getProperty("USERNAME");
                password = p.getProperty("PASSWORD");
                connection = DriverManager.getConnection(urlCOmplete, user, password);
//                System.out.println("Koneksi OK");
                st = connection.createStatement();
//                System.out.println(urlCOmplete);
            } catch (IOException ex) {
                Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage());
                }
            }
        }
        return connection;
    }

    public static String FormatTanggalIndonesia(String formatsql) {
        String tanggal = formatsql;
        String removestrip = tanggal.replace("-", "");
        String tahun = removestrip.substring(0, 4);
        String bulan = removestrip.substring(4, 6);
        String bulanindo = "";
        String hari = removestrip.substring(6, 8);
        if (bulan.equalsIgnoreCase("01")) {
            bulanindo = "Januari";
        } else if (bulan.equalsIgnoreCase("02")) {
            bulanindo = "Februari";
        } else if (bulan.equalsIgnoreCase("03")) {
            bulanindo = "Maret";
        } else if (bulan.equalsIgnoreCase("04")) {
            bulanindo = "April";
        } else if (bulan.equalsIgnoreCase("05")) {
            bulanindo = "Mei";
        } else if (bulan.equalsIgnoreCase("06")) {
            bulanindo = "Juni";
        } else if (bulan.equalsIgnoreCase("07")) {
            bulanindo = "Juli";
        } else if (bulan.equalsIgnoreCase("08")) {
            bulanindo = "Agustus";
        } else if (bulan.equalsIgnoreCase("09")) {
            bulanindo = "September";
        } else if (bulan.equalsIgnoreCase("10")) {
            bulanindo = "Oktober";
        } else if (bulan.equalsIgnoreCase("11")) {
            bulanindo = "November";
        } else if (bulan.equalsIgnoreCase("12")) {
            bulanindo = "Desember";
        }
        String formatindofix = hari + " " + bulanindo + " " + tahun;
        return formatindofix;
    }
}
