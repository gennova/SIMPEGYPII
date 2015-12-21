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
public class Golongan {
    private int KodeGolongan;
    private String Golongan;
    private String Pangkat;

    public Golongan() {
    }

    public Golongan(int KodeGolongan, String Golongan, String Pangkat) {
        this.KodeGolongan = KodeGolongan;
        this.Golongan = Golongan;
        this.Pangkat = Pangkat;
    }

    /**
     * @return the KodeGolongan
     */
    public int getKodeGolongan() {
        return KodeGolongan;
    }

    /**
     * @param KodeGolongan the KodeGolongan to set
     */
    public void setKodeGolongan(int KodeGolongan) {
        this.KodeGolongan = KodeGolongan;
    }

    /**
     * @return the Golongan
     */
    public String getGolongan() {
        return Golongan;
    }

    /**
     * @param Golongan the Golongan to set
     */
    public void setGolongan(String Golongan) {
        this.Golongan = Golongan;
    }

    /**
     * @return the Pangkat
     */
    public String getPangkat() {
        return Pangkat;
    }

    /**
     * @param Pangkat the Pangkat to set
     */
    public void setPangkat(String Pangkat) {
        this.Pangkat = Pangkat;
    }
    
    
}
