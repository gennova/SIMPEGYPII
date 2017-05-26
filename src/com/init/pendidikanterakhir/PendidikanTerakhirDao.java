/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pendidikanterakhir;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface PendidikanTerakhirDao {

    public List<PendidikanTerakhir> getAllPendidikan();

    public PendidikanTerakhir getPendidikanByID(int id);

    public PendidikanTerakhir getPendidikanByKode(String kode);

    public PendidikanTerakhir getPendidikanByNama(String nama);

    public void InsertPendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir);

    public void UpdatePendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir);

    public void DeletePendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir);
}
