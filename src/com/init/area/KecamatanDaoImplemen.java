/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.area;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Semua isi dalam file ini adalah hak milik dari Presdir Atanasius Tendy. Anda
 * tidak diperkenankan untuk menggunakan file atau mengubah file ini kecuali
 * anda tidak menghapus atau merubah Lisensi ini.
 *
 * File ini dibuat menggunakan : IDE : NetBeans 7.1 NoteBook : Asus K42Jc
 * Versatile Performance OS : Windows 7 Ultimate Java Version : Java 1.6 update
 * 26
 *
 * Program Intentity : Code Name : Code Created on Feb 10, 2013, 9:06:07 AM
 *
 * @author PresdirTendy
 */
public class KecamatanDaoImplemen implements KecamatanDao {

    private Connection connection;
    private static final String SQL_GET_ALL_KECAMATAN = "select * from t_kec order by kecamatan asc";
    private static final String SQL_GET_ALL_KABUPATEN_BYIDKAB = "select * from t_kec where id_kot=?";
    private static final String SQL_GET_IDKEC_BYNAME = "select id_kec from t_kec where kecamatan=?";

    public KecamatanDaoImplemen(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public List<Kecamatan> GetAllKecamatan() {
        List<Kecamatan> Kecamatans = new ArrayList<Kecamatan>();
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL_KECAMATAN);
            while (resultSet.next()) {
                Kecamatan k = new Kecamatan();
                k.setIdKec(resultSet.getInt("id_kec"));
                k.setIdkota(resultSet.getInt("id_kot"));
                k.setNamaKecamatan(resultSet.getString("kecamatan"));
                Kecamatans.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KecamatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return Kecamatans;
    }

    @Override
    public List<Kecamatan> GetAllKecamatanByIDKabupaten(int idKab) {
        List<Kecamatan> Kecamatans = new ArrayList<Kecamatan>();
        try {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            statement = connection.prepareStatement(SQL_GET_ALL_KABUPATEN_BYIDKAB);
            statement.setInt(1, idKab);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Kecamatan k = new Kecamatan();
                k.setIdKec(resultSet.getInt("id_kec"));
                k.setIdkota(resultSet.getInt("id_kot"));
                k.setNamaKecamatan(resultSet.getString("kecamatan"));
                Kecamatans.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KecamatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return Kecamatans;
    }

    @Override
    public int getIdKecByNamaKecamatan(String NamaKecamatan) {
        int idProv = 0;
        try {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            statement = connection.prepareStatement(SQL_GET_IDKEC_BYNAME);
            statement.setString(1, NamaKecamatan);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                idProv = resultSet.getInt("id_kec");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KecamatanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return idProv;
    }
}
