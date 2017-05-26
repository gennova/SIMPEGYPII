/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.golongan;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface GolonganDao {

    public List<Golongan> getAllGolongans();

    public Golongan getGolonganByID(int id);

    public Golongan getGolonganByKode(String kode);

    public Golongan getGolonganByNamaGolongan(String nama);

    public void InsertGolongan(Golongan golongan);

    public void UpdateGolongan(Golongan golongan);

    public void DeleteGolonganByID(Golongan golongan);
}
