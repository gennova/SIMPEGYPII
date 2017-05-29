/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import com.init.pegawai.Pegawai;

/**
 *
 * @author amnesia
 */
public class Session {

    private static String NUK;
    private static Pegawai pegawai;

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

}
