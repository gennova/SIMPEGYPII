/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.unit;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface UnitDao {

    public List<Unit> getAllUnit();

    public Unit getUnitByID(int id);

    public Unit getUnitByKode(String kode);

    public Unit getUnitByNama(String nama);

    public void InsertUnit(Unit unit);

    public void UpdateUnitByID(Unit unit);

    public void DeleteUnitByID(Unit unit);
}
