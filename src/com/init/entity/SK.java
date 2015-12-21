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
public class SK {
    private String IDSK;
    private String JenisSK;
    private String TMT;
    private String NoSK;
    private String TanggalSK;

    public SK() {
    }

    public SK(String JenisSK, String TMT, String NoSK, String TanggalSK) {
        this.JenisSK = JenisSK;
        this.TMT = TMT;
        this.NoSK = NoSK;
        this.TanggalSK = TanggalSK;
    }

    /**
     * @return the JenisSK
     */
    public String getJenisSK() {
        return JenisSK;
    }

    /**
     * @param JenisSK the JenisSK to set
     */
    public void setJenisSK(String JenisSK) {
        this.JenisSK = JenisSK;
    }

    /**
     * @return the TMT
     */
    public String getTMT() {
        return TMT;
    }

    /**
     * @param TMT the TMT to set
     */
    public void setTMT(String TMT) {
        this.TMT = TMT;
    }

    /**
     * @return the NoSK
     */
    public String getNoSK() {
        return NoSK;
    }

    /**
     * @param NoSK the NoSK to set
     */
    public void setNoSK(String NoSK) {
        this.NoSK = NoSK;
    }

    /**
     * @return the TanggalSK
     */
    public String getTanggalSK() {
        return TanggalSK;
    }

    /**
     * @param TanggalSK the TanggalSK to set
     */
    public void setTanggalSK(String TanggalSK) {
        this.TanggalSK = TanggalSK;
    }
    
    
}
