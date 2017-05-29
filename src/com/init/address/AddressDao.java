/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.address;

import java.util.List;

/**
 *
 * @author amnesia
 */
public interface AddressDao {

    public List<Address> getAllProvinsi();
    
    public List<Address> getAllKabupaten(int IDProvinsi);

    public List<Address> getAllKecamatan(int IDKabupaten);

    public List<Address> getAllKeluarahan(int IDKecamatan);

    public List getNamaProvinsi();

    public List getNamaKabupaten(int IDProvinsi);

    public List getNamaKecamatan(int IDKabupaten);

    public List getNamaKelurahan(int IDKecamatan);
}
