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
public interface PropinsiDao {

    public List<Propinsi> GetAllPropinsi();
    
    public int getIdProvByNamaPropinsi(String ID);
}
