/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.ini.skjabatan;

import code.init.pekerjaanjabatan.PekerjaanJabatan;
import com.init.jabatan.Jabatan;
import com.init.pegawai.Pegawai;

/**
 *
 * @author amnesia
 */
public class SK_jabatan {

    private int id;
    private String nuk;
    private int id_jabatan;
    private int id_pekerjaan_jabatan;
    private String tmt;
    private String tmt_indo;
    private String no_sk;
    private String tanggal;
    private String tanggal_indo;
    private Pegawai pegawai;
    private Jabatan jabatan;
    private PekerjaanJabatan pekerjaanJabatan;

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

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public int getId_pekerjaan_jabatan() {
        return id_pekerjaan_jabatan;
    }

    public void setId_pekerjaan_jabatan(int id_pekerjaan_jabatan) {
        this.id_pekerjaan_jabatan = id_pekerjaan_jabatan;
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

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    public PekerjaanJabatan getPekerjaanJabatan() {
        return pekerjaanJabatan;
    }

    public void setPekerjaanJabatan(PekerjaanJabatan pekerjaanJabatan) {
        this.pekerjaanJabatan = pekerjaanJabatan;
    }

}
