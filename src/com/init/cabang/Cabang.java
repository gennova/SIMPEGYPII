/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.cabang;

/**
 *
 * @author amnesia
 */
public class Cabang {

    private int idcabang;
    private String kode;
    private String namacabang;

    public Cabang() {
    }

    public Cabang(int idcabang, String kode, String namacabang) {
        this.idcabang = idcabang;
        this.kode = kode;
        this.namacabang = namacabang;
    }

    public void setIdCabang(int idcabang) {
        this.idcabang = idcabang;
    }

    public int getIdCabang() {
        return idcabang;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return this.kode;
    }

    public void setNamacabang(String namacabang) {
        this.namacabang = namacabang;
    }

    public String getNamacabang() {
        return namacabang;
    }

}
