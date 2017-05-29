/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.address;

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
public class AddressDaoImplemen implements AddressDao {

    private final Connection connection;
    private final String getAllProvinsi = "select * from provinsi";

    public AddressDaoImplemen(Connection conn) {
        this.connection = conn;
    }

    @Override
    public List<Address> getAllProvinsi() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Address> addresses = null;
        try {
            ps = connection.prepareStatement(getAllProvinsi);
            rs = ps.executeQuery();
            addresses = new ArrayList<Address>();
            while (rs.next()) {
                Address a = new Address();
                a.setID(rs.getInt("id"));
                a.setIDProvinsi(rs.getInt("IDProvinsi"));
                a.setNamaProvinsi(rs.getString("Nama"));
                addresses.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addresses;
    }

    @Override
    public List<Address> getAllKabupaten(int IDProvinsi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAllKecamatan(int IDKabupaten) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAllKeluarahan(int IDKecamatan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getNamaProvinsi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getNamaKabupaten(int IDProvinsi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getNamaKecamatan(int IDKabupaten) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getNamaKelurahan(int IDKecamatan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
