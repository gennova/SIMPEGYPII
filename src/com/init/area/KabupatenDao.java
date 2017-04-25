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
public interface KabupatenDao {

    public List<Kabupaten> GetAllKabupaten();
    
    public List<Kabupaten> GetAllKabupatenByIDProv(int idprov);
    
    public int getIdKabByNamaKabupaten(String ID);
}
