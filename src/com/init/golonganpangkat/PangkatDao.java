/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.golonganpangkat;

import com.init.golongan.Golongan;
import java.util.List;

/**
 *
 * @author amnesia
 */
public interface PangkatDao {

    public List<Pangkat> getAllPangkat();

    public List<Pangkat> getAllPangkatByID(int id);

    public List<Pangkat> getAllPangkatByNUK(String nuk);

    public Pangkat getPangkatByNUK(String nuk);

    public List<Pangkat> getAllPangkatByIDGolongan(Golongan golongan);

    public List<Pangkat> getAllPangkatByNamaGolongan(Golongan golongan);

    public void InsertPangkatPegawai(Pangkat pangkat);

    public void UpdatePangkatPegawai(Pangkat pangkat);

    public void DeletePangkatPegawai(Pangkat pangkat);
    
    public boolean cekPangkatPegawai(String nuk);
    
    public void InsertNaikPangkat(int id);
    
    public void UpdateDataRiwayatPangkatByID(Pangkat pangkat); // limited variable not all
    
    public Pangkat getRiwayatPangkatByNUK(String nuk,int id);
}
