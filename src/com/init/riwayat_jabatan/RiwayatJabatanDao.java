/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayat_jabatan;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface RiwayatJabatanDao {

    public void InsertRiwayatJabatan(RiwayatJabatan jabatan);

    public List<RiwayatJabatan> getALlRiwayatJabatan();

    public RiwayatJabatan getRiwayatJabatanByID(int id);

    public void updateRiwayaJabatan(RiwayatJabatan riwayatJabatan);

    public void deleteRiwayatJabatan(int id);

}
