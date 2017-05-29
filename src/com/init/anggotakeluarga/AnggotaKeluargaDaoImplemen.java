/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.anggotakeluarga;

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
public class AnggotaKeluargaDaoImplemen implements AnggotaKeluargaDao {

    private final Connection connection;
    private final static String sqlGetAllAnggotaKeluarga = "select * from anggotakeluarga";
    private final static String sqlGetAnggotaKeluargaByNUK = "select * from anggotakeluarga where nuk=?";

    public AnggotaKeluargaDaoImplemen(Connection connection1) {
        this.connection = connection1;
    }

    @Override
    public List<AnggotaKeluarga> getAllAnggotakeluarga() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AnggotaKeluarga> lists = null;
        try {
            ps = connection.prepareStatement(sqlGetAllAnggotaKeluarga);
            
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaKeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public AnggotaKeluarga getAnggotaKeluargaByNUK(String nuk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertAnggotaKeluarga(String nuk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
