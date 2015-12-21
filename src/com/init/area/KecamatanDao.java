/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.area;

import java.util.List;

/**
 *
 * @author PresdirTendy
 */
public interface KecamatanDao {

    public List<Kecamatan> GetAllKecamatan();
    
    public List<Kecamatan> GetAllKecamatanByIDKabupaten(int idKab);
    
    public int getIdKecByNamaKecamatan(String NamaKecamatan);
}
