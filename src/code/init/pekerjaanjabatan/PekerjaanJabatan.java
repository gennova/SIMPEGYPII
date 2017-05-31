/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.init.pekerjaanjabatan;

import com.init.bidangkerja.BidangKerja;
import com.init.cabang.Cabang;
import com.init.jabatan.Jabatan;
import com.init.pegawai.Pegawai;
import com.init.unit.Unit;

/**
 *
 * @author amnesia
 */
public class PekerjaanJabatan {

    private int id;
    private Pegawai pegawai;
    private BidangKerja bk;
    private String tglTMTPekerjaan;
    private String nomorSKPekerjaan;
    private String tglSKPekerjaan;
    private Cabang cabang;
    private Unit unit;
    private Jabatan jabatan;
    private String namaJabatan;
    private int masaJabatan;

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

    public BidangKerja getBk() {
        return bk;
    }

    public void setBk(BidangKerja bk) {
        this.bk = bk;
    }

    public String getTglTMTPekerjaan() {
        return tglTMTPekerjaan;
    }

    public void setTglTMTPekerjaan(String tglTMTPekerjaan) {
        this.tglTMTPekerjaan = tglTMTPekerjaan;
    }

    public String getNomorSKPekerjaan() {
        return nomorSKPekerjaan;
    }

    public void setNomorSKPekerjaan(String nomorSKPekerjaan) {
        this.nomorSKPekerjaan = nomorSKPekerjaan;
    }

    public String getTglSKPekerjaan() {
        return tglSKPekerjaan;
    }

    public void setTglSKPekerjaan(String tglSKPekerjaan) {
        this.tglSKPekerjaan = tglSKPekerjaan;
    }

    public Cabang getCabang() {
        return cabang;
    }

    public void setCabang(Cabang cabang) {
        this.cabang = cabang;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public int getMasaJabatan() {
        return masaJabatan;
    }

    public void setMasaJabatan(int masaJabatan) {
        this.masaJabatan = masaJabatan;
    }

}
