/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.anggotakeluarga;

/**
 *
 * @author amnesia
 */
public class AnggotaKeluarga {

    private int id;
    private String count;
    private String nuk;
    private String nama;
    private String tanggallahir;

    public void setID(int ID) {
        this.id = ID;
    }

    public int getID() {
        return id;
    }

    public String getNuk() {
        return nuk;
    }

    public void setNuk(String nuk) {
        this.nuk = nuk;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setTanggalLahir(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getTanggalLahir() {
        return tanggallahir;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
