/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.provinsi;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface ProvinsiDao {

    public List<Provinsi> getAllProvinsi();

    public Provinsi getProvinsiByID(int id);

    public Provinsi getProvinsiByKode(String kode);

    public void InsertProvinsi(Provinsi provinsi);

    public void UpdateProvinsi(Provinsi provinsi);

    public void DeleteProvinsiByID(Provinsi provinsi);
}
