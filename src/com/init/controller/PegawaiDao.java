/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.controller;

import com.init.entity.Pegawai;
import java.util.List;

/**
 *
 * @author Tendy Developer
 */
public interface PegawaiDao {
    public List<Pegawai> getAllPegawai();
    
    public void insertPegawai(Pegawai pegawai);
    
    public void updatePegawai(String idPeg,Pegawai pegawai);
    
    public void hapusPegawai(String idPegawai);
}
