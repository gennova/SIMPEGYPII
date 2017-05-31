/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.cabang;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface CabangDao {

    public List<Cabang> getAllCabang();
    
    public Cabang getCabangByID(int id);
    
    public Cabang getCabangByKode(String kode);
    
    public Cabang getCabangByNamaCabang(String namacabang);

    public void insertCabang(Cabang cabang);

    public void deleteCabangById(int id);

    public void deleteCabangByKode(String kode);

    public void updateCabang(Cabang cabang);
}
