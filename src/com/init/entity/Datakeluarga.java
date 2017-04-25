/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.entity;

/**
 *
 * @author Tendy Developer
 */
public class Datakeluarga {
    private String IDDataKeluarga;
    private String IDPegawai;
    private String NamaAnggotaKeluarga;
    private String TanggalLahir;
    private String NUK;

    public Datakeluarga() {
    }

    public Datakeluarga(String IDPegawai, String NamaAnggotaKeluarga, String TanggalLahir) {
        this.IDPegawai = IDPegawai;
        this.NamaAnggotaKeluarga = NamaAnggotaKeluarga;
        this.TanggalLahir = TanggalLahir;
    }

    /**
     * @return the IDPegawai
     */
    public String getIDPegawai() {
        return IDPegawai;
    }

    /**
     * @param IDPegawai the IDPegawai to set
     */
    public void setIDPegawai(String IDPegawai) {
        this.IDPegawai = IDPegawai;
    }

    /**
     * @return the NamaAnggotaKeluarga
     */
    public String getNamaAnggotaKeluarga() {
        return NamaAnggotaKeluarga;
    }

    /**
     * @param NamaAnggotaKeluarga the NamaAnggotaKeluarga to set
     */
    public void setNamaAnggotaKeluarga(String NamaAnggotaKeluarga) {
        this.NamaAnggotaKeluarga = NamaAnggotaKeluarga;
    }

    /**
     * @return the TanggalLahir
     */
    public String getTanggalLahir() {
        return TanggalLahir;
    }

    /**
     * @param TanggalLahir the TanggalLahir to set
     */
    public void setTanggalLahir(String TanggalLahir) {
        this.TanggalLahir = TanggalLahir;
    }
    
    
}
