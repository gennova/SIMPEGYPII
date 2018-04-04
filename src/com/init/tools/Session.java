/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import code.init.pekerjaanjabatan.PekerjaanJabatan;
import com.init.golonganpangkat.Pangkat;
import com.init.pegawai.Pegawai;
import com.init.riwayat_jabatan.RiwayatJabatan;

/**
 *
 * @author amnesia
 */
public class Session {

    private static String NUK;
    private static Pegawai pegawai;
    private static PekerjaanJabatan pekerjaanJabatan;
    private static Pangkat pangkat;
    private static RiwayatJabatan riwayatJabatan;
    private static int RiwayatGajiID;

    public static int getRiwayatGajiID() {
        return RiwayatGajiID;
    }

    public static void setRiwayatGajiID(int RiwayatGajiID) {
        Session.RiwayatGajiID = RiwayatGajiID;
    }

    public static String getNUK() {
        return NUK;
    }

    public static void setNUK(String NUK) {
        Session.NUK = NUK;
    }

    public static Pegawai getPegawai() {
        return pegawai;
    }

    public static void setPegawai(Pegawai pegawai) {
        Session.pegawai = pegawai;
    }

    public static PekerjaanJabatan getPekerjaanJabatan() {
        return pekerjaanJabatan;
    }

    public static void setPekerjaanJabatan(PekerjaanJabatan pekerjaanJabatan) {
        Session.pekerjaanJabatan = pekerjaanJabatan;
    }

    public static Pangkat getPangkat() {
        return pangkat;
    }

    public static void setPangkat(Pangkat pangkat) {
        Session.pangkat = pangkat;
    }

    public static RiwayatJabatan getRiwayatJabatan() {
        return riwayatJabatan;
    }

    public static void setRiwayatJabatan(RiwayatJabatan riwayatJabatan) {
        Session.riwayatJabatan = riwayatJabatan;
    }

}
