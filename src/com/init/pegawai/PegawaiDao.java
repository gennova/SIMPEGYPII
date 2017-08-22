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
    
    public List<Pegawai> getAllPegawaiByNamaCabangAndUnit(String idcabang,String idunit);
    
    public List<Pegawai> getAllPegawaiByNamaCabang(String namagolongan);
    
    public List<Pegawai> getAllPegawaiByNamaUnit(String namaunit);
    
    public List<Pegawai> getAllPegawaiByNamaGolongan(String namagolongan);
    
    public List<Pegawai> getAllPegawaiByStatusPegawai(String statuspegawai);
    
    public List<Pegawai> getAllPegawaiByStatusPendidikan(String namapendidikan);
    
    public List<Pegawai> getAllPegawaiUlangTahun(String tglAwal,String tglAkhir);
    
    public List<Pegawai> getAllPegawaiUltahToday();    

    public void InsertPegawai(Pegawai pegawai);

    public Pegawai getPegawaiByNUK(String nuk);

    public List getComboTempatLahir();

    public void insertRumahPegawai(String nuk, String alamat, String telepon, String hp);

    public String[] getAlamatRumahPegawai();

    public Rumah getRumahPegawaiByNUK(String nuk);

    public boolean cekRumahByNUK(String nuk);

    public List<Pegawai> getAllPegawaiAndBidangKerja();

    public List<Pegawai> getAllPegawaiAndBidangKerjaNama();

    public List<Pegawai> getAllPegawaiAndBidangKerjaWilayah();

    public List<Pegawai> getAllPegawaiAndBidangKerjaBidangKerja();

    public List<Pegawai> getAllPegawaiAndBidangKerjaGolongan();

    public List<Pegawai> getAllPegawaiAndBidangKerjaUnitKerja();

    public boolean CekPegawaiByNUK(String nuk);
}
