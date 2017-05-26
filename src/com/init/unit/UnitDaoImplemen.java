/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amnesia
 */
public class UnitDaoImplemen implements UnitDao {

    private final Connection connection;
    private final static String sqlGetAllUnit = "select * from unit";

    public UnitDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Unit> getAllUnit() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Unit> units = null;
        try {
            ps = connection.prepareStatement(sqlGetAllUnit);
            rs = ps.executeQuery();
            while (rs.next()) {                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return units;
    }

    @Override
    public Unit getUnitByID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Unit getUnitByKode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Unit getUnitByNama() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertUnit(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateUnitByID(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteUnitByID(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
