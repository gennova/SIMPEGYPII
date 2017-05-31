/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pendidikan_pegawai;

import com.init.ijazah.IjazahAngkat;
import com.init.pegawai.Pegawai;
import com.init.pendidikanterakhir.PendidikanTerakhir;

/**
 *
 * @author amnesia
 */
public class PendidikanPegawai {

    private int id;
    private Pegawai pegawai;
    private IjazahAngkat ijazahAngkat;
    private String tglLulusSKPengangkatan;
    private PendidikanTerakhir pendidikanTerakhir;
    private String tglLulusSKPendidikanAkhir;

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

    public IjazahAngkat getIjazahAngkat() {
        return ijazahAngkat;
    }

    public void setIjazahAngkat(IjazahAngkat ijazahAngkat) {
        this.ijazahAngkat = ijazahAngkat;
    }

    public String getTglLulusSKPengangkatan() {
        return tglLulusSKPengangkatan;
    }

    public void setTglLulusSKPengangkatan(String tglLulusSKPengangkatan) {
        this.tglLulusSKPengangkatan = tglLulusSKPengangkatan;
    }

    public PendidikanTerakhir getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getTglLulusSKPendidikanAkhir() {
        return tglLulusSKPendidikanAkhir;
    }

    public void setTglLulusSKPendidikanAkhir(String tglLulusSKPendidikanAkhir) {
        this.tglLulusSKPendidikanAkhir = tglLulusSKPendidikanAkhir;
    }

}
