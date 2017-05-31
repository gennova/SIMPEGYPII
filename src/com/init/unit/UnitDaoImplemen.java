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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amnesia
 */
public class UnitDaoImplemen implements UnitDao {

    private final Connection connection;
    private final static String sqlGetAllUnit = "select * from unit";
    private final static String sqlGetUnitByID = "select * from unit where id=?";
    private final static String sqlGetUnitByKode = "select * from unit where kodeunit=?";
    private final static String sqlGetUnitByNamaUnit = "select * from unit where namaunit=?";
    private final static String sqlInsertUnit = "insert into unit (kodeunit,namaunit) values(?,?)";
    private final static String sqlUpdateUnitByID = "update unit set kodeunit=?,namaunit=? where id=?";
    private final static String sqlDeleteUnitByID = "delete from unit where id=?";

    public UnitDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Unit> getAllUnit() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Unit> units = null;
        try {
            units = new ArrayList<Unit>();
            ps = connection.prepareStatement(sqlGetAllUnit);
            rs = ps.executeQuery();
            while (rs.next()) {
                Unit unit = new Unit();
                unit.setID(rs.getInt("id"));
                unit.setKodeUnit(rs.getString("kodeunit"));
                unit.setNamaUnit(rs.getString("namaunit"));
                units.add(unit);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return units;
    }

    @Override
    public Unit getUnitByID(int id) {
        Unit unit = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlGetUnitByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                unit = new Unit();
                unit.setID(rs.getInt("id"));
                unit.setKodeUnit(rs.getString("kodeunit"));
                unit.setNamaUnit(rs.getString("namaunit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unit;
    }

    @Override
    public Unit getUnitByKode(String kode) {
        Unit unit = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlGetUnitByKode);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                unit = new Unit();
                unit.setID(rs.getInt("id"));
                unit.setKodeUnit(rs.getString("kodeunit"));
                unit.setNamaUnit(rs.getString("namaunit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unit;
    }

    @Override
    public Unit getUnitByNama(String nama) {
        Unit unit = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlGetUnitByNamaUnit);
            ps.setString(1, nama);
            rs = ps.executeQuery();
            while (rs.next()) {
                unit = new Unit();
                unit.setID(rs.getInt("id"));
                unit.setKodeUnit(rs.getString("kodeunit"));
                unit.setNamaUnit(rs.getString("namaunit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unit;
    }

    @Override
    public void InsertUnit(Unit unit) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertUnit);
            ps.setString(1, unit.getKodeUnit());
            ps.setString(2, unit.getNamaUnit());
            int i = ps.executeUpdate();
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Data Unit Berhasil Disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Unit Gagal Disimpan");
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void UpdateUnitByID(Unit unit) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateUnitByID);
            ps.setString(1, unit.getKodeUnit());
            ps.setString(2, unit.getNamaUnit());
            ps.setInt(3, unit.getID());
            int i = ps.executeUpdate();
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Data Unit Berhasil Diupdate");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteUnitByID(Unit unit) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDeleteUnitByID);
            ps.setInt(1, unit.getID());
            int i = ps.executeUpdate();
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Data Unit Berhasil Dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
