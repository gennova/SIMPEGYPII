/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ijazah;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface IjazahAngkatDao {

    public List<IjazahAngkat> getAllIjazahPengangkatan();

    public IjazahAngkat getIjazahAngkatByID(int id);

    public IjazahAngkat getIjazahAngkatByKode(String kode);

    public void InsertIjazah(IjazahAngkat ijazahAngkat);

    public void UpdateIjazah(IjazahAngkat ijazahAngkat);

    public void DeleteIjazahByID(IjazahAngkat ijazahAngkat);
}
