/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.jabatan;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface JabatanDao {

    public List<Jabatan> getAllJabatan();

    public List<Jabatan> getAllJabatanByMasaJabatan(int masa);

    public Jabatan getJabatanByID(int id);

    public Jabatan getJabatanByKode(String kode);

    public Jabatan getJabatanByNama(String name);

    public void InsertJabatan(Jabatan jabatan);

    public void UpdateJabatan(Jabatan jabatan);

    public void DeleteJabatanByID(Jabatan jabatan);

}
