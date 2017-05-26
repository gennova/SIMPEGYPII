/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.jabatan;

/**
 *
 * @author amnesia
 */
public class Jabatan {

    private int id;
    private String kodejabatan;
    private String namajabatan;
    private int masajabatan;

    public void setId(int idnya) {
        this.id = idnya;
    }

    public int getId() {
        return id;
    }

    public String getKodejabatan() {
        return kodejabatan;
    }

    public void setKodejabatan(String kodejabatan) {
        this.kodejabatan = kodejabatan;
    }

    public String getNamajabatan() {
        return namajabatan;
    }

    public void setNamajabatan(String namajabatan) {
        this.namajabatan = namajabatan;
    }

    public int getMasajabatan() {
        return masajabatan;
    }

    public void setMasajabatan(int masajabatan) {
        this.masajabatan = masajabatan;
    }

}
