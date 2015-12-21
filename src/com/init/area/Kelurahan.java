/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.init.area;

/*
 * Semua isi dalam file ini adalah hak milik dari Presdir Atanasius Tendy. Anda
 * tidak diperkenankan untuk menggunakan file atau mengubah file ini kecuali
 * anda tidak menghapus atau merubah Lisensi ini.
 *
 * File ini dibuat menggunakan : IDE : NetBeans 7.1 NoteBook : Asus K42Jc
 * Versatile Performance OS : Windows 7 Ultimate
 * Java Version : Java 1.6 update 26
 *
 * Program Intentity : Code Name : Code Created on Feb 10, 2013, 9:14:24 AM
 *
 * @author PresdirTendy
 */

public class Kelurahan {
    private int NoUrut;
    private int idprov;
    private int idkota;
    private int idKec;
    private int idkel;
    private String NamaKelurahan;
    
    public int getIdkel() {
        return idkel;
    }

    public void setIdkel(int idkel) {
        this.idkel = idkel;
    }
    

    public String getNamaKelurahan() {
        return NamaKelurahan;
    }

    public void setNamaKelurahan(String NamaKelurahan) {
        this.NamaKelurahan = NamaKelurahan;
    }

    public int getNoUrut() {
        return NoUrut;
    }

    public void setNoUrut(int NoUrut) {
        this.NoUrut = NoUrut;
    }

    public int getIdKec() {
        return idKec;
    }

    public void setIdKec(int idKec) {
        this.idKec = idKec;
    }

    public int getIdkota() {
        return idkota;
    }

    public void setIdkota(int idkota) {
        this.idkota = idkota;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }
    
    

}
