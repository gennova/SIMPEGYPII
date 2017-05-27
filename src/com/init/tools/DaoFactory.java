/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import com.init.bidangkerja.BidangKerjaDao;
import com.init.bidangkerja.BidangKerjaDaoImplemen;
import com.init.cabang.CabangDao;
import com.init.cabang.CabangDaoImplemen;
import com.init.controller.PegawaiDao;
import com.init.controller.PegawaiDaoImplemen;
import com.init.golongan.GolonganDao;
import com.init.golongan.GolonganDaoImplemen;
import com.init.ijazah.IjazahAngkatDao;
import com.init.ijazah.IjazahAngkatDaoImplemen;
import com.init.jabatan.JabatanDao;
import com.init.jabatan.JabatanDaoImplemen;
import com.init.jenistugas.JenisTugas;
import com.init.jenistugas.JenisTugasDao;
import com.init.jenistugas.JenisTugasDaoImplemen;
import com.init.pendidikanterakhir.PendidikanTerakhirDao;
import com.init.pendidikanterakhir.PendidikanTerakhirDaoImplemen;
import com.init.provinsi.ProvinsiDao;
import com.init.provinsi.ProvinsiDaoImplemen;
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
            try {
                connection = k.bukaKoneksi();
            } catch (SQLException ex) {
                Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                in = new FileInputStream("DBConfiguration.xml");
                Properties p = new Properties();
                p.loadFromXML(in);
                urlFile = p.getProperty("HOST") + ":" + p.getProperty("PORT") + "/" + p.getProperty("DBNAME");
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
}
