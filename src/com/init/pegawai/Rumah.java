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
public class Rumah {
    private String IDRumah;
    private String Alamat;
    private String Telpon;
    private String HP;

    public Rumah() {
    }

    public Rumah(String Alamat, String Telpon, String HP) {
        this.Alamat = Alamat;
        this.Telpon = Telpon;
        this.HP = HP;
    }

    /**
     * @return the Alamat
     */
    public String getAlamat() {
        return Alamat;
    }

    /**
     * @param Alamat the Alamat to set
     */
    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    /**
     * @return the Telpon
     */
    public String getTelpon() {
        return Telpon;
    }

    /**
     * @param Telpon the Telpon to set
     */
    public void setTelpon(String Telpon) {
        this.Telpon = Telpon;
    }

    /**
     * @return the HP
     */
    public String getHP() {
        return HP;
    }

    /**
     * @param HP the HP to set
     */
    public void setHP(String HP) {
        this.HP = HP;
    }
    
    
}
