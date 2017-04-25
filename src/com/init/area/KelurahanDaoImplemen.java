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
 * Program Intentity : Code Name : Code Created on Feb 10, 2013, 9:14:45 AM
 *
 * @author PresdirTendy
 */
public class KelurahanDaoImplemen implements KelurahanDao {

    private Connection connection;
    private static final String SQL_GET_ALL_KELURAHAN = "select * from t_kel";
    private static final String SQL_GET_ALL_KELURAHAN_BYID_Kec = "select * from t_kel where id_kec=?";

    public KelurahanDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Kelurahan> GetAllKelurahan() {
        List<Kelurahan> kelurahans = new ArrayList<Kelurahan>();
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL_KELURAHAN);
            while (resultSet.next()) {
                Kelurahan k = new Kelurahan();
                k.setIdkel(resultSet.getInt("id_kel"));
                k.setIdKec(resultSet.getInt("id_kec"));                
                k.setNamaKelurahan(resultSet.getString("kelurahan"));
                kelurahans.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelurahanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return kelurahans;
    }

    @Override
    public List<Kelurahan> GetAllKelurahanByIDKecamatan(int idKec) {
        List<Kelurahan> kelurahans = new ArrayList<Kelurahan>();
        try {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            statement = connection.prepareStatement(SQL_GET_ALL_KELURAHAN_BYID_Kec);
            statement.setInt(1, idKec);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Kelurahan k = new Kelurahan();
//                k.setIdkel(resultSet.getBigDecimal("id_kel"));
                k.setIdKec(resultSet.getInt("id_kec"));                
                k.setNamaKelurahan(resultSet.getString("kelurahan"));
                kelurahans.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelurahanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return kelurahans;
    }

}
