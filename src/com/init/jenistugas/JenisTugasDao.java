/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.jenistugas;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface JenisTugasDao {

    public List<JenisTugas> getAllJenisTugas();

    public JenisTugas getJenisTugasByID(int id);

    public JenisTugas getJenisTUgasByKode(String kode);

    public void InsertJenisTugas(JenisTugas jenisTugas);

    public void UpdateJenisTugas(JenisTugas jenisTugas);

    public void DeletJenisTugasByID(JenisTugas jenisTugas);
}
