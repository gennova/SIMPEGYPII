/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.bidangkerja;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface BidangKerjaDao {

    public List<BidangKerja> getAllBidangKerja();

    public BidangKerja getBidangKerjaByID(int id);

    public BidangKerja getBidangkerjaByKode(String kode);
    
    public BidangKerja getBidangKerjaByNamaBidangKerja(String namabidangkerja);

    public void InsertBidangKerja(BidangKerja bidangKerja);

    public void UpdateBidangKerja(BidangKerja bidangKerja);

    public void DeleteBidangKerja(BidangKerja bidangKerja);
}
