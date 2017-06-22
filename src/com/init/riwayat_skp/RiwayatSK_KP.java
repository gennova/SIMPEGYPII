/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayat_skp;

import com.init.golongan.Golongan;
import com.init.pegawai.Pegawai;

/**
 *
 * @author amnesia
 */
public class RiwayatSK_KP {

    private int id;
    private String nuk;
    private int id_golongan;
    private String tmt_golongan;
    private String nomor_sk;
    private String tanggal_sk;
    private String tmt_kgb;
    private String nomor_kgb;
    private String tgl_kgb;
    private int tahun_kerja;
    private int bulan_kerja;
    private int tahun_kerja_benar;
    private int bulan_kerja_benar;
    private String tmt_golongan_indo;
    private String tanggal_sk_indo;
    private String tmt_kgb_indo;
    private String tgl_kgb_indo;
    private String ruang;
    private Pegawai pegawai;
    private Golongan golongan;
    private String keterangan;
    private String track;
    private int gaji;
    private String gaji_str;

    public RiwayatSK_KP() {
    }

    public RiwayatSK_KP(int id, String nuk, int id_golongan, String tmt_golongan, String nomor_sk, String tanggal_sk, String tmt_kgb, String nomor_kgb, String tgl_kgb, int tahun_kerja, int bulan_kerja, int tahun_kerja_benar, int bulan_kerja_benar, String tmt_golongan_indo, String tanggal_sk_indo, String tmt_kgb_indo, String tgl_kgb_indo, String ruang) {
        this.id = id;
        this.nuk = nuk;
        this.id_golongan = id_golongan;
        this.tmt_golongan = tmt_golongan;
        this.nomor_sk = nomor_sk;
        this.tanggal_sk = tanggal_sk;
        this.tmt_kgb = tmt_kgb;
        this.nomor_kgb = nomor_kgb;
        this.tgl_kgb = tgl_kgb;
        this.tahun_kerja = tahun_kerja;
        this.bulan_kerja = bulan_kerja;
        this.tahun_kerja_benar = tahun_kerja_benar;
        this.bulan_kerja_benar = bulan_kerja_benar;
        this.tmt_golongan_indo = tmt_golongan_indo;
        this.tanggal_sk_indo = tanggal_sk_indo;
        this.tmt_kgb_indo = tmt_kgb_indo;
        this.tgl_kgb_indo = tgl_kgb_indo;
        this.ruang = ruang;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNuk() {
        return nuk;
    }

    public void setNuk(String nuk) {
        this.nuk = nuk;
    }

    public int getId_golongan() {
        return id_golongan;
    }

    public void setId_golongan(int id_golongan) {
        this.id_golongan = id_golongan;
    }

    public String getTmt_golongan() {
        return tmt_golongan;
    }

    public void setTmt_golongan(String tmt_golongan) {
        this.tmt_golongan = tmt_golongan;
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

    public String getTgl_kgb() {
        return tgl_kgb;
    }

    public void setTgl_kgb(String tgl_kgb) {
        this.tgl_kgb = tgl_kgb;
    }

    public int getTahun_kerja() {
        return tahun_kerja;
    }

    public void setTahun_kerja(int tahun_kerja) {
        this.tahun_kerja = tahun_kerja;
    }

    public int getBulan_kerja() {
        return bulan_kerja;
    }

    public void setBulan_kerja(int bulan_kerja) {
        this.bulan_kerja = bulan_kerja;
    }

    public int getTahun_kerja_benar() {
        return tahun_kerja_benar;
    }

    public void setTahun_kerja_benar(int tahun_kerja_benar) {
        this.tahun_kerja_benar = tahun_kerja_benar;
    }

    public int getBulan_kerja_benar() {
        return bulan_kerja_benar;
    }

    public void setBulan_kerja_benar(int bulan_kerja_benar) {
        this.bulan_kerja_benar = bulan_kerja_benar;
    }

    public String getTmt_golongan_indo() {
        return tmt_golongan_indo;
    }

    public void setTmt_golongan_indo(String tmt_golongan_indo) {
        this.tmt_golongan_indo = tmt_golongan_indo;
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

    public String getTgl_kgb_indo() {
        return tgl_kgb_indo;
    }

    public void setTgl_kgb_indo(String tgl_kgb_indo) {
        this.tgl_kgb_indo = tgl_kgb_indo;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public String getGaji_str() {
        return gaji_str;
    }

    public void setGaji_str(String gaji_str) {
        this.gaji_str = gaji_str;
    }

}
