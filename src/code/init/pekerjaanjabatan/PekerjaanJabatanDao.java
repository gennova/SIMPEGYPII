/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.init.pekerjaanjabatan;

import com.init.pegawai.Pegawai;
import java.util.List;

/**
 *
 * @author amnesia
 */
public interface PekerjaanJabatanDao {

    public List<PekerjaanJabatan> getAllPekerjaanJabatan();

    public List<PekerjaanJabatan> getAllPekerjaanJabatanByID(int id);
    
    public PekerjaanJabatan getPekerjaanJabatanByID(int id);
    
    public PekerjaanJabatan getPekerjaanJabatanByNUK(String nuk);

    public List<PekerjaanJabatan> getAllPekerjaanJabatanByNUK(Pegawai pegawai);

    public void InsertPekerjaanJabatan(PekerjaanJabatan pekerjaan);

    public void UpdatePekerjaanJabatan(PekerjaanJabatan pekerjaan);

    public void DeletePekerjaanJabatanByID(PekerjaanJabatan pekerjaan);
    
    public boolean cekPekerjaanJabatanByNUK(String nuk);
}
