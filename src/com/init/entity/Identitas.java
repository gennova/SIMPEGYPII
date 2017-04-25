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
public class Identitas {
    private String IDIdentitas;
    private String JenisKartu;
    private String NoKartu;
    private String MasaBerlaku;
    private String NUK;

    public Identitas() {
    }

    public Identitas(String JenisKartu, String NoKartu, String MasaBerlaku) {
        this.JenisKartu = JenisKartu;
        this.NoKartu = NoKartu;
        this.MasaBerlaku = MasaBerlaku;
    }

    /**
     * @return the JenisKartu
     */
    public String getJenisKartu() {
        return JenisKartu;
    }

    /**
     * @param JenisKartu the JenisKartu to set
     */
    public void setJenisKartu(String JenisKartu) {
        this.JenisKartu = JenisKartu;
    }

    /**
     * @return the NoKartu
     */
    public String getNoKartu() {
        return NoKartu;
    }

    /**
     * @param NoKartu the NoKartu to set
     */
    public void setNoKartu(String NoKartu) {
        this.NoKartu = NoKartu;
    }

    /**
     * @return the MasaBerlaku
     */
    public String getMasaBerlaku() {
        return MasaBerlaku;
    }

    /**
     * @param MasaBerlaku the MasaBerlaku to set
     */
    public void setMasaBerlaku(String MasaBerlaku) {
        this.MasaBerlaku = MasaBerlaku;
    }
    
    
}
