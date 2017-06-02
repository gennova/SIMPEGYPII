/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.anggotakeluarga;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface AnggotaKeluargaDao {

    public List<AnggotaKeluarga> getAllAnggotakeluarga();

    public List<AnggotaKeluarga> getAllAnggotaKeluargaByNUK(String nuk);

    public AnggotaKeluarga getAnggotaKeluargaByNUK(String nuk);

    public void InsertAnggotaKeluarga(AnggotaKeluarga anggotaKeluarga);

    public boolean cekNuks(String nuks, String nama, String count, String tanggal);

    public boolean cekNuks_ada_atau_gak(String nuks);
}
