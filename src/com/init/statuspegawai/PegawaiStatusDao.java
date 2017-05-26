/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.statuspegawai;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface PegawaiStatusDao {

    public List<PegawaiStatus> getAllPegawaiStatus();

    public PegawaiStatus getPegawaiStatusByID(int id);

    public PegawaiStatus getPegawaiStatusByKode(String kode);

    public PegawaiStatus getPegawaiStatusByNama(String nama);

    public void InsertPegawaiStatus(PegawaiStatus ps);

    public void UpdatePegawaiStatus(PegawaiStatus ps);

    public void DeletePegawaiStatusByID(PegawaiStatus ps);
}
