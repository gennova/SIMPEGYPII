/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.sk_pegawai;

import com.init.statuspegawai.PegawaiStatus;
import java.util.List;

/**
 *
 * @author amnesia
 */
public interface SK_Pegawai_Dao {

    public List<SK_Pegawai> getAllSKPegawai();

    public SK_Pegawai getSKPegawaiByID(int id);

    public SK_Pegawai getSKPegawaiByNUK(String nuk);
    
    public SK_Pegawai getSKPegawaiByNUK(String nuk,int kolom);

    public SK_Pegawai getSKPegawaiByStatusPegawai(PegawaiStatus pegawaiStatus);

    public void InsertSKPegawai(SK_Pegawai sk_pegawai);

    public boolean cekStatusNUK(String nuk, int kolom);
}
