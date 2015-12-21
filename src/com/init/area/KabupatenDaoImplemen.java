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
 * Program Intentity : Code Name : Code Created on Feb 10, 2013, 9:01:52 AM
 *
 * @author PresdirTendy
 */
public class KabupatenDaoImplemen implements KabupatenDao {

    private Connection connection;
    private static final String SQL_GET_ALL_KABUPATEN = "select * from t_kot order by kota_kabupaten asc";
    private static final String SQL_GET_ALL_KABUPATENBYIDPROV = "select * from t_kot where id_prov=?";
    private static final String SQL_GET_IDKAB_BYNAME = "select id_kot from t_kot where kota_kabupaten = ? order by kota_kabupaten asc";
    
    public KabupatenDaoImplemen(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<Kabupaten> GetAllKabupaten() {
        List<Kabupaten> Kabupatens = new ArrayList<Kabupaten>();
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL_KABUPATEN);
            while (resultSet.next()) {
                Kabupaten kabupaten = new Kabupaten();
                kabupaten.setIdprov(resultSet.getInt("id_prov"));
                kabupaten.setIdkota(resultSet.getInt("id_kot"));
                kabupaten.setNameKabupaten(resultSet.getString("kota_kabupaten"));
                Kabupatens.add(kabupaten);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KabupatenDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return Kabupatens;
    }

    @Override
    public List<Kabupaten> GetAllKabupatenByIDProv(int idpro) {
        List<Kabupaten> Kabupatens = new ArrayList<Kabupaten>();
        try {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            statement = connection.prepareCall(SQL_GET_ALL_KABUPATENBYIDPROV);
            statement.setInt(1, idpro);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Kabupaten kabupaten = new Kabupaten();
                kabupaten.setIdprov(resultSet.getInt("id_prov"));
                kabupaten.setIdkota(resultSet.getInt("id_kot"));
                kabupaten.setNameKabupaten(resultSet.getString("kota_kabupaten"));
                Kabupatens.add(kabupaten);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KabupatenDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return Kabupatens;
    }

    @Override
    public int getIdKabByNamaKabupaten(String ID) {
        int idProv = 0;
        try {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            statement = connection.prepareStatement(SQL_GET_IDKAB_BYNAME);
            statement.setString(1, ID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                idProv = resultSet.getInt("id_kot");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KabupatenDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return idProv;
    }
}
