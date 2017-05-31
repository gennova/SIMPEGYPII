/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.gaji;

import com.init.pegawai.Pegawai;

/**
 *
 * @author amnesia
 */
public class Gaji_pegawai {

    private int id;
    private Pegawai pegawai;
    private double gaji_pokok;
    private double tunjangan_suami_istri;
    private double tunjangan_anak;
    private double tunjangan_lain;
    private double total_gaji;
    private int tanggungan_orang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public double getGaji_pokok() {
        return gaji_pokok;
    }

    public void setGaji_pokok(double gaji_pokok) {
        this.gaji_pokok = gaji_pokok;
    }

    public double getTunjangan_suami_istri() {
        return tunjangan_suami_istri;
    }

    public void setTunjangan_suami_istri(double tunjangan_suami_istri) {
        this.tunjangan_suami_istri = tunjangan_suami_istri;
    }

    public double getTunjangan_anak() {
        return tunjangan_anak;
    }

    public void setTunjangan_anak(double tunjangan_anak) {
        this.tunjangan_anak = tunjangan_anak;
    }

    public double getTunjangan_lain() {
        return tunjangan_lain;
    }

    public void setTunjangan_lain(double tunjangan_lain) {
        this.tunjangan_lain = tunjangan_lain;
    }

    public double getTotal_gaji() {
        return total_gaji;
    }

    public void setTotal_gaji(double total_gaji) {
        this.total_gaji = total_gaji;
    }

    public int getTanggungan_orang() {
        return tanggungan_orang;
    }

    public void setTanggungan_orang(int tanggungan_orang) {
        this.tanggungan_orang = tanggungan_orang;
    }

}
