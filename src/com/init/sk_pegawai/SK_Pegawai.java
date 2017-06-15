/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.sk_pegawai;

import com.init.pegawai.Pegawai;
import com.init.statuspegawai.PegawaiStatus;

/**
 *
 * @author amnesia
 */
public class SK_Pegawai {

    private int id;
    private int kolom_kategori;
    private Pegawai pegawai;
    private String nuk;
    private PegawaiStatus status_pegawai;
    private String status_pegawai_str;
    private String tmt;
    private String tmt_indo;
    private String no_sk;
    private String tanggal;
    private String tanggal_indo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKolom_kategori() {
        return kolom_kategori;
    }

    public void setKolom_kategori(int kolom_kategori) {
        this.kolom_kategori = kolom_kategori;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public String getNuk() {
        return nuk;
    }

    public void setNuk(String nuk) {
        this.nuk = nuk;
    }

    public PegawaiStatus getStatus_pegawai() {
        return status_pegawai;
    }

    public void setStatus_pegawai(PegawaiStatus status_pegawai) {
        this.status_pegawai = status_pegawai;
    }

    public String getTmt() {
        return tmt;
    }

    public void setTmt(String tmt) {
        this.tmt = tmt;
    }

    public String getTmt_indo() {
        return tmt_indo;
    }

    public void setTmt_indo(String tmt_indo) {
        this.tmt_indo = tmt_indo;
    }

    public String getNo_sk() {
        return no_sk;
    }

    public void setNo_sk(String no_sk) {
        this.no_sk = no_sk;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal_indo() {
        return tanggal_indo;
    }

    public void setTanggal_indo(String tanggal_indo) {
        this.tanggal_indo = tanggal_indo;
    }

    public String getStatus_pegawai_str() {
        return status_pegawai_str;
    }

    public void setStatus_pegawai_str(String status_pegawai_str) {
        this.status_pegawai_str = status_pegawai_str;
    }

}
