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
public interface KelurahanDao {

    public List<Kelurahan> GetAllKelurahan();
    
    public List<Kelurahan> GetAllKelurahanByIDKecamatan(int idKec);
    
    
}
