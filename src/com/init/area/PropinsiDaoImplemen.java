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
 * Program Intentity : Code Name : Code Created on Feb 10, 2013, 8:44:53 AM
 *
 * @author PresdirTendy
 */
public class PropinsiDaoImplemen implements PropinsiDao {

    private Connection connection;
    private static final String SQL_GET_ALL_PROPINSI = "select * from t_prov order by propinsi asc ";
    private static final String SQL_GET_IDPROV_BYNAME = "select id_prov from t_prov where propinsi = ?";

    public PropinsiDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Propinsi> GetAllPropinsi() {
        List<Propinsi> propinsis = new ArrayList<Propinsi>();
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL_PROPINSI);
            while (resultSet.next()) {
                Propinsi propinsi = new Propinsi();
                propinsi.setIDPropinsi(resultSet.getInt("id_prov"));
                propinsi.setNamaPropinsi(resultSet.getString("propinsi"));
                propinsis.add(propinsi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return propinsis;
    }

    @Override
    public int getIdProvByNamaPropinsi(String ID) {
        int idProv = 0;
        try {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            statement = connection.prepareStatement(SQL_GET_IDPROV_BYNAME);
            statement.setString(1, ID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                idProv = resultSet.getInt("id_prov");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropinsiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
        }
        return idProv;
    }
}
