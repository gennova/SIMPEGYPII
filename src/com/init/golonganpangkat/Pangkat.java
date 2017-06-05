/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.golonganpangkat;

import com.init.golongan.Golongan;
import com.init.pegawai.Pegawai;

/**
 *
 * @author amnesia
 */
public class Pangkat {

    private int id;
    private Pegawai pegawai;
    private Golongan golongan;
    private String TMTGolongan; // tanggal
    private String TMTGolongan_indo; // tanggal
    private String nomor_sk;
    private String tanggal_sk; //tanggal
    private String tanggal_sk_indo; //tanggal
    private String tmt_kgb; // tanggal
    private String tmt_kgb_indo; //tanggal
    private String nomor_kgb;
    private String tanggal_kgb; // tanggal
    private String tanggal_kgb_indo; //tanggal
    private int tahun_masa_kerja;
    private int bulan_masa_kerja;
    private int tahun_masa_kerja_sebenarnya;
    private int bulan_masa_kerja_sebenarnya;

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

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }

    public String getTMTGolongan() {
        return TMTGolongan;
    }

    public void setTMTGolongan(String TMTGolongan) {
        this.TMTGolongan = TMTGolongan;
    }

    public String getNomor_sk() {
        return nomor_sk;
    }

    public void setNomor_sk(String nomor_sk) {
        this.nomor_sk = nomor_sk;
    }

    public String getTanggal_sk() {
        return tanggal_sk;
    }

    public void setTanggal_sk(String tanggal_sk) {
        this.tanggal_sk = tanggal_sk;
    }

    public String getTmt_kgb() {
        return tmt_kgb;
    }

    public void setTmt_kgb(String tmt_kgb) {
        this.tmt_kgb = tmt_kgb;
    }

    public String getNomor_kgb() {
        return nomor_kgb;
    }

    public void setNomor_kgb(String nomor_kgb) {
        this.nomor_kgb = nomor_kgb;
    }

    public String getTanggal_kgb() {
        return tanggal_kgb;
    }

    public void setTanggal_kgb(String tanggal_kgb) {
        this.tanggal_kgb = tanggal_kgb;
    }

    public int getTahun_masa_kerja() {
        return tahun_masa_kerja;
    }

    public void setTahun_masa_kerja(int tahun_masa_kerja) {
        this.tahun_masa_kerja = tahun_masa_kerja;
    }

    public int getBulan_masa_kerja() {
        return bulan_masa_kerja;
    }

    public void setBulan_masa_kerja(int bulan_masa_kerja) {
        this.bulan_masa_kerja = bulan_masa_kerja;
    }

    public int getTahun_masa_kerja_sebenarnya() {
        return tahun_masa_kerja_sebenarnya;
    }

    public void setTahun_masa_kerja_sebenarnya(int tahun_masa_kerja_sebenarnya) {
        this.tahun_masa_kerja_sebenarnya = tahun_masa_kerja_sebenarnya;
    }

    public int getBulan_masa_kerja_sebenarnya() {
        return bulan_masa_kerja_sebenarnya;
    }

    public void setBulan_masa_kerja_sebenarnya(int bulan_masa_kerja_sebenarnya) {
        this.bulan_masa_kerja_sebenarnya = bulan_masa_kerja_sebenarnya;
    }

    public String getTMTGolongan_indo() {
        return TMTGolongan_indo;
    }

    public void setTMTGolongan_indo(String TMTGolongan_indo) {
        this.TMTGolongan_indo = TMTGolongan_indo;
    }

    public String getTanggal_sk_indo() {
        return tanggal_sk_indo;
    }

    public void setTanggal_sk_indo(String tanggal_sk_indo) {
        this.tanggal_sk_indo = tanggal_sk_indo;
    }

    public String getTmt_kgb_indo() {
        return tmt_kgb_indo;
    }

    public void setTmt_kgb_indo(String tmt_kgb_indo) {
        this.tmt_kgb_indo = tmt_kgb_indo;
    }

    public String getTanggal_kgb_indo() {
        return tanggal_kgb_indo;
    }

    public void setTanggal_kgb_indo(String tanggal_kgb_indo) {
        this.tanggal_kgb_indo = tanggal_kgb_indo;
    }

}
