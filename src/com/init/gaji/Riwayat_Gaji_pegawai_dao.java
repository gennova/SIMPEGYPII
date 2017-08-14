/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.gaji;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface Riwayat_Gaji_pegawai_dao {

    public void InsertGajiPegawaiRiwayat(RiwayatGajiPegawai gaji_pegawai);

    public boolean CekGajiPegawaiByNUKRiwayat(String nuk);

    public RiwayatGajiPegawai getGajiPegawaiByNUKRiwayat(String nuk);

    public List<RiwayatGajiPegawai> getAllRiwayatGajiPegawai();
    
    public List<RiwayatGajiPegawai> getAllRiwayatGajiPegawaiNuk(String nuk);
    
    public void InsertRiwayatGajiPegawaiManual(RiwayatGajiPegawai gajiPegawai);
    
    public void deleteRiwayatGajiPegawai(int id);
}
