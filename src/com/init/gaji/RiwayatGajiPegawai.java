/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.gaji;

import code.init.pekerjaanjabatan.PekerjaanJabatan;
import com.init.golongan.Golongan;
import com.init.golonganpangkat.Pangkat;
import com.init.jabatan.Jabatan;
import com.init.pegawai.Pegawai;

/**
 *
 * @author amnesia
 */
public class RiwayatGajiPegawai {

    private int id;
    private Pegawai pegawai;
    private double gaji_pokok;
    private double tunjangan_suami_istri;
    private double tunjangan_anak;
    private double tunjangan_lain;
    private double total_gaji;
    private int tanggungan_orang;
    private int kgb_berikutnya;
    private String kbg_yad_date;
    private String kgb_yad_indo;
    private Pangkat pangkat;
    private PekerjaanJabatan pekerjaanJabatan;
    private String tmt_lama;
    private String no_kgb;
    private String tanggal;
    private Golongan golongan;
    private Jabatan jabatan;
    private int ruang;
    private String keterangan;
    private String gaji_pokok_str;

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

    public int getKgb_berikutnya() {
        return kgb_berikutnya;
    }

    public void setKgb_berikutnya(int kgb_berikutnya) {
        this.kgb_berikutnya = kgb_berikutnya;
    }

    public String getKbg_yad_date() {
        return kbg_yad_date;
    }

    public void setKbg_yad_date(String kbg_yad_date) {
        this.kbg_yad_date = kbg_yad_date;
    }

    public String getKgb_yad_indo() {
        return kgb_yad_indo;
    }

    public void setKgb_yad_indo(String kgb_yad_indo) {
        this.kgb_yad_indo = kgb_yad_indo;
    }

    public Pangkat getPangkat() {
        return pangkat;
    }

    public void setPangkat(Pangkat pangkat) {
        this.pangkat = pangkat;
    }

    public PekerjaanJabatan getPekerjaanJabatan() {
        return pekerjaanJabatan;
    }

    public void setPekerjaanJabatan(PekerjaanJabatan pekerjaanJabatan) {
        this.pekerjaanJabatan = pekerjaanJabatan;
    }

    public String getTmt_lama() {
        return tmt_lama;
    }

    public void setTmt_lama(String tmt_lama) {
        this.tmt_lama = tmt_lama;
    }

    public String getNo_kgb() {
        return no_kgb;
    }

    public void setNo_kgb(String no_kgb) {
        this.no_kgb = no_kgb;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    public int getRuang() {
        return ruang;
    }

    public void setRuang(int ruang) {
        this.ruang = ruang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getGaji_pokok_str() {
        return gaji_pokok_str;
    }

    public void setGaji_pokok_str(String gaji_pokok_str) {
        this.gaji_pokok_str = gaji_pokok_str;
    }

}
