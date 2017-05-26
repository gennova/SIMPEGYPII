/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.unit;

/**
 *
 * @author amnesia
 */
public class Unit {

    private int id;
    private String kodeunit;
    private String namaunit;

    public Unit() {
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setKodeUnit(String kode) {
        this.kodeunit = kode;
    }

    public String getKodeUnit() {
        return this.kodeunit;
    }

    public void setNamaUnit(String nama) {
        this.namaunit = nama;
    }

    public String getNamaUnit() {
        return this.namaunit;
    }

}
