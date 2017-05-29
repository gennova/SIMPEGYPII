/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.badan;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface BadanDao {

    public List<Badan> getAllBadanPegawai();

    public Badan getDataBadanByNUK(String nuk);

    public void InsertDataBadanPegawai(Badan badan);
    
    public boolean cekBadanNUK(String nuk);
}
