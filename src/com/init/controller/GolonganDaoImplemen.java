/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.controller;

import com.init.entity.Golongan;
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
 * @author Tendy Developer
 */
public class GolonganDaoImplemen implements GolonganDao {

    private Connection connection = null;
    private static final String sqlGelALlGolongan="select * from pangkatgolongan";

    public GolonganDaoImplemen(Connection c) {
        this.connection = c;
    }
    
       
    @Override
    public List<Golongan> getAllGolongan() {
        List<com.init.entity.Golongan> gs = new ArrayList<>();
        PreparedStatement statement=null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGelALlGolongan);
            rs = statement.executeQuery();
            while (rs.next()) {                
                com.init.entity.Golongan g = new com.init.entity.Golongan();
                g.setKodeGolongan(rs.getInt("kode"));
                g.setGolongan(rs.getString("golongan"));
                g.setPangkat(rs.getString("pangkat"));
                gs.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GolonganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  gs;
    }

    @Override
    public void insertGolongan(Golongan golongan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateGolongan(Golongan golongan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGolongan(Golongan golongan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
