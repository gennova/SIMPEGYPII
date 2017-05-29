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

    public AnggotaKeluarga getAnggotaKeluargaByNUK(String nuk);

    public void InsertAnggotaKeluarga(String nuk);
}
