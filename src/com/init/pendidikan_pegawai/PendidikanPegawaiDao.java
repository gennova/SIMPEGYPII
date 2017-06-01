/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pendidikan_pegawai;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface PendidikanPegawaiDao {

    public List<PendidikanPegawai> getAllPendidikanPegawai();

    public PendidikanPegawai getPendidikanPegawaiByNUK(String nuk);

    public void InsertPendidikanPegawai(PendidikanPegawai ppeg);

    public boolean cekPendidikanPegawaiByNUK(String nuk);
}
