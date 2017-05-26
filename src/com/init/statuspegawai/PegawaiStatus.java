/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.statuspegawai;

/**
 *
 * @author amnesia
 */
public class PegawaiStatus {

    private int id;
    private String KodeStatusPegawai;
    private String NamaStatusPegawai;

    public PegawaiStatus() {
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setKodeStatusPegawai(String kode) {
        this.KodeStatusPegawai = kode;
    }

    public String getKodeStatusPegawai() {
        return this.KodeStatusPegawai;
    }

    public void setNamaStatusPegawai(String nama) {
        this.NamaStatusPegawai = nama;
    }

    public String getNamaStatusPegawai() {
        return this.NamaStatusPegawai;
    }

}
