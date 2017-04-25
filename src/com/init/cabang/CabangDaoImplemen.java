/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.cabang;

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
public class CabangDaoImplemen implements CabangDao {

    private Connection connection;
    private final String sqlInsertCabang = "insert into cabang(kodecabang,namacabang) values(?,?)";
    private final String sqlGetAllCabang = "select * from cabang";

    public CabangDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Cabang> getAllCabang() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cabang> cabangs = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sqlGetAllCabang);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cabang c = new Cabang();
                c.setIdCabang(rs.getInt("id"));
                c.setKode(rs.getString("kode"));
                c.setNamacabang(rs.getString("namacabang"));
                cabangs.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CabangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cabangs;
    }

    @Override
    public void insertCabang(Cabang cabang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCabangById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCabangByKode(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCabang(Cabang cabang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
