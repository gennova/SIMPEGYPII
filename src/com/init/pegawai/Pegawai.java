/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pegawai;

/**
 *
 * @author Tendy Developer
 */
public class Pegawai {

    private int ID;
    //data umum
    private String NUK; //1
    private String Nama; //2
    private String GelarDepan; //3
    private String GelarBelakang; //4
    private String Alias; //5 
    private String JK; //6
    private String Agama; //7
    private String TLahir; //8
    private String TglLahir; //9
    private String StatusPerkawinan; //10
    private int JumlahAnakSeluruh; //11
    private int JumlahAnakGaji; //12
    private String StatusPegawai; //13
    private String TeksFilename; //14
    // akhir data umum

    public Pegawai() {

    }

    public Pegawai(String NUK, String Nama, String GelarDepan, String GelarBelakang, String Alias, String JK, String Agama, String TLahir, String TglLahir, String StatusPerkawinan, int JumlahAnakSeluruh, int JumlahAnakGaji, String StatusPegawai, String TeksFilename) {
        this.NUK = NUK;
        this.Nama = Nama;
        this.GelarDepan = GelarDepan;
        this.GelarBelakang = GelarBelakang;
        this.Alias = Alias;
        this.JK = JK;
        this.Agama = Agama;
        this.TLahir = TLahir;
        this.TglLahir = TglLahir;
        this.StatusPerkawinan = StatusPerkawinan;
        this.JumlahAnakSeluruh = JumlahAnakSeluruh;
        this.JumlahAnakGaji = JumlahAnakGaji;
        this.StatusPegawai = StatusPegawai;
        this.TeksFilename = TeksFilename;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNUK() {
        return NUK;
    }

    public void setNUK(String NUK) {
        this.NUK = NUK;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getGelarDepan() {
        return GelarDepan;
    }

    public void setGelarDepan(String GelarDepan) {
        this.GelarDepan = GelarDepan;
    }

    public String getGelarBelakang() {
        return GelarBelakang;
    }

    public void setGelarBelakang(String GelarBelakang) {
        this.GelarBelakang = GelarBelakang;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public String getJK() {
        return JK;
    }

    public void setJK(String JK) {
        this.JK = JK;
    }

    public String getAgama() {
        return Agama;
    }

    public void setAgama(String Agama) {
        this.Agama = Agama;
    }

    public String getTLahir() {
        return TLahir;
    }

    public void setTLahir(String TLahir) {
        this.TLahir = TLahir;
    }

    public String getTglLahir() {
        return TglLahir;
    }

    public void setTglLahir(String TglLahir) {
        this.TglLahir = TglLahir;
    }

    public String getStatusPerkawinan() {
        return StatusPerkawinan;
    }

    public void setStatusPerkawinan(String StatusPerkawinan) {
        this.StatusPerkawinan = StatusPerkawinan;
    }

    public int getJumlahAnakSeluruh() {
        return JumlahAnakSeluruh;
    }

    public void setJumlahAnakSeluruh(int JumlahAnakSeluruh) {
        this.JumlahAnakSeluruh = JumlahAnakSeluruh;
    }

    public int getJumlahAnakGaji() {
        return JumlahAnakGaji;
    }

    public void setJumlahAnakGaji(int JumlahAnakGaji) {
        this.JumlahAnakGaji = JumlahAnakGaji;
    }

    public String getStatusPegawai() {
        return StatusPegawai;
    }

    public void setStatusPegawai(String StatusPegawai) {
        this.StatusPegawai = StatusPegawai;
    }

    public String getTeksFilename() {
        return TeksFilename;
    }

    public void setTeksFilename(String TeksFilename) {
        this.TeksFilename = TeksFilename;
    }

}
