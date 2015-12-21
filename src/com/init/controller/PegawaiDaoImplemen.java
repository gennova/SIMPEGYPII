/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.controller;

import com.init.entity.Pegawai;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Tendy Developer
 */
public class PegawaiDaoImplemen implements PegawaiDao{
    private Connection connection;
    private static final String SQL_USER = "select password from petugas where username = ? ";

    public PegawaiDaoImplemen(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public List<Pegawai> getAllPegawai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertPegawai(Pegawai pegawai) {
        
    }

    @Override
    public void updatePegawai(String idPeg, Pegawai pegawai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hapusPegawai(String idPegawai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
