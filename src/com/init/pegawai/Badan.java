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
public class Badan {
    private String IDBadan;
    private String Tinggi;
    private String Berat;
    private String Rambut;
    private String BentukMuka;
    private String WarnaKulit;
    private String CiriKhas;
    private String CacatTubuh;
    private String GolonganDarah;
    private String Hobby;
    private String PekerjaanLain;
    private String NUK;

    public Badan() {
    }

    public Badan(String Tinggi, String Berat, String Rambut, String BentukMuka, String WarnaKulit, String CiriKhas, String CacatTubuh, String GolonganDarah, String Hobby, String PekerjaanLain) {
        this.Tinggi = Tinggi;
        this.Berat = Berat;
        this.Rambut = Rambut;
        this.BentukMuka = BentukMuka;
        this.WarnaKulit = WarnaKulit;
        this.CiriKhas = CiriKhas;
        this.CacatTubuh = CacatTubuh;
        this.GolonganDarah = GolonganDarah;
        this.Hobby = Hobby;
        this.PekerjaanLain = PekerjaanLain;
    }

    /**
     * @return the Tinggi
     */
    public String getTinggi() {
        return Tinggi;
    }

    /**
     * @param Tinggi the Tinggi to set
     */
    public void setTinggi(String Tinggi) {
        this.Tinggi = Tinggi;
    }

    /**
     * @return the Berat
     */
    public String getBerat() {
        return Berat;
    }

    /**
     * @param Berat the Berat to set
     */
    public void setBerat(String Berat) {
        this.Berat = Berat;
    }

    /**
     * @return the Rambut
     */
    public String getRambut() {
        return Rambut;
    }

    /**
     * @param Rambut the Rambut to set
     */
    public void setRambut(String Rambut) {
        this.Rambut = Rambut;
    }

    /**
     * @return the BentukMuka
     */
    public String getBentukMuka() {
        return BentukMuka;
    }

    /**
     * @param BentukMuka the BentukMuka to set
     */
    public void setBentukMuka(String BentukMuka) {
        this.BentukMuka = BentukMuka;
    }

    /**
     * @return the WarnaKulit
     */
    public String getWarnaKulit() {
        return WarnaKulit;
    }

    /**
     * @param WarnaKulit the WarnaKulit to set
     */
    public void setWarnaKulit(String WarnaKulit) {
        this.WarnaKulit = WarnaKulit;
    }

    /**
     * @return the CiriKhas
     */
    public String getCiriKhas() {
        return CiriKhas;
    }

    /**
     * @param CiriKhas the CiriKhas to set
     */
    public void setCiriKhas(String CiriKhas) {
        this.CiriKhas = CiriKhas;
    }

    /**
     * @return the CacatTubuh
     */
    public String getCacatTubuh() {
        return CacatTubuh;
    }

    /**
     * @param CacatTubuh the CacatTubuh to set
     */
    public void setCacatTubuh(String CacatTubuh) {
        this.CacatTubuh = CacatTubuh;
    }

    /**
     * @return the GolonganDarah
     */
    public String getGolonganDarah() {
        return GolonganDarah;
    }

    /**
     * @param GolonganDarah the GolonganDarah to set
     */
    public void setGolonganDarah(String GolonganDarah) {
        this.GolonganDarah = GolonganDarah;
    }

    /**
     * @return the Hobby
     */
    public String getHobby() {
        return Hobby;
    }

    /**
     * @param Hobby the Hobby to set
     */
    public void setHobby(String Hobby) {
        this.Hobby = Hobby;
    }

    /**
     * @return the PekerjaanLain
     */
    public String getPekerjaanLain() {
        return PekerjaanLain;
    }

    /**
     * @param PekerjaanLain the PekerjaanLain to set
     */
    public void setPekerjaanLain(String PekerjaanLain) {
        this.PekerjaanLain = PekerjaanLain;
    }
    
    
    
}
