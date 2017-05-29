/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pegawai;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface PegawaiDao {

    public List<Pegawai> getAllPegawai();

    public void InsertPegawai(Pegawai pegawai);

    public Pegawai getPegawaiByNUK(String nuk);

    public List getComboTempatLahir();

    public void insertRumahPegawai(String nuk, String alamat, String telepon, String hp);

    public String[] getAlamatRumahPegawai();

    public Rumah getRumahPegawaiByNUK(String nuk);
    
    public boolean cekRumahByNUK(String nuk);
}