/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayat_skp;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface RiwayatSK_KPDao {

    public List<RiwayatSK_KP> getALlSK_KPByNUK(String nuk);
    
    public void InsertRiwayatSKPManual(RiwayatSK_KP riwayatSK_KP);
    
    public void DeleteRiwayatSKP_Manual(int id);
    
    public RiwayatSK_KP getRiwayatSKKP_LamaByNukLast(String nuk);
}
