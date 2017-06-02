/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.gaji;

/**
 *
 * @author amnesia
 */
public interface Gaji_pegawai_dao {

    public void InsertGajiPegawai(Gaji_pegawai gaji_pegawai);

    public boolean CekGajiPegawaiByNUK(String nuk);

    public Gaji_pegawai getGajiPegawaiByNUK(String nuk);
}
