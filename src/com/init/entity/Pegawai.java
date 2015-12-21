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
public class Pegawai {
    private String NUK;
    private String Nama;
    private String GelarDepan;
    private String GelarBelakang;
    private String Alias;
    private String JK;
    private String Agama;
    private String TLahir;
    private String TglLahir;
    private String StatusPerkawinan;
    private String StatusPegawai;
    private String TeksFilename;
    
    public Pegawai(){
        
    } 
    
    public Pegawai(String NUK, String Nama, String Alias, String JK, String Agama, String TLahir, String TglLahir, String StatusPerkawinan, String StatusPegawai) {
        this.NUK = NUK;
        this.Nama = Nama;
        this.Alias = Alias;
        this.JK = JK;
        this.Agama = Agama;
        this.TLahir = TLahir;
        this.TglLahir = TglLahir;
        this.StatusPerkawinan = StatusPerkawinan;
        this.StatusPegawai = StatusPegawai;
    }

    /**
     * @return the NUK
     */
    public String getNUK() {
        return NUK;
    }

    /**
     * @param NUK the NUK to set
     */
    public void setNUK(String NUK) {
        this.NUK = NUK;
    }

    /**
     * @return the Nama
     */
    public String getNama() {
        return Nama;
    }

    /**
     * @param Nama the Nama to set
     */
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    /**
     * @return the Alias
     */
    public String getAlias() {
        return Alias;
    }

    /**
     * @param Alias the Alias to set
     */
    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    /**
     * @return the JK
     */
    public String getJK() {
        return JK;
    }

    /**
     * @param JK the JK to set
     */
    public void setJK(String JK) {
        this.JK = JK;
    }

    /**
     * @return the Agama
     */
    public String getAgama() {
        return Agama;
    }

    /**
     * @param Agama the Agama to set
     */
    public void setAgama(String Agama) {
        this.Agama = Agama;
    }

    /**
     * @return the TLahir
     */
    public String getTLahir() {
        return TLahir;
    }

    /**
     * @param TLahir the TLahir to set
     */
    public void setTLahir(String TLahir) {
        this.TLahir = TLahir;
    }

    /**
     * @return the TglLahir
     */
    public String getTglLahir() {
        return TglLahir;
    }

    /**
     * @param TglLahir the TglLahir to set
     */
    public void setTglLahir(String TglLahir) {
        this.TglLahir = TglLahir;
    }

    /**
     * @return the StatusPerkawinan
     */
    public String getStatusPerkawinan() {
        return StatusPerkawinan;
    }

    /**
     * @param StatusPerkawinan the StatusPerkawinan to set
     */
    public void setStatusPerkawinan(String StatusPerkawinan) {
        this.StatusPerkawinan = StatusPerkawinan;
    }

    /**
     * @return the StatusPegawai
     */
    public String getStatusPegawai() {
        return StatusPegawai;
    }

    /**
     * @param StatusPegawai the StatusPegawai to set
     */
    public void setStatusPegawai(String StatusPegawai) {
        this.StatusPegawai = StatusPegawai;
    }

    /**
     * @return the TeksFilename
     */
    public String getTeksFilename() {
        return TeksFilename;
    }

    /**
     * @param TeksFilename the TeksFilename to set
     */
    public void setTeksFilename(String TeksFilename) {
        this.TeksFilename = TeksFilename;
    }

    /**
     * @return the GelarDepan
     */
    public String getGelarDepan() {
        return GelarDepan;
    }

    /**
     * @param GelarDepan the GelarDepan to set
     */
    public void setGelarDepan(String GelarDepan) {
        this.GelarDepan = GelarDepan;
    }

    /**
     * @return the GelarBelakang
     */
    public String getGelarBelakang() {
        return GelarBelakang;
    }

    /**
     * @param GelarBelakang the GelarBelakang to set
     */
    public void setGelarBelakang(String GelarBelakang) {
        this.GelarBelakang = GelarBelakang;
    }
    
    
}
