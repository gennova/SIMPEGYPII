/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.ini.skjabatan;

import com.init.pegawai.Pegawai;
import java.util.List;

/**
 *
 * @author amnesia
 */
public interface SK_jabatan_dao {

    public List<SK_jabatan> getAllSK_Jabatan();

    public SK_jabatan getSKJabatanByID(int id);

    public SK_jabatan getSKJabatanByID_Jabatan(int id);

    public SK_jabatan getSKJabatanByID_Pekerjaan_Jabatan(int id);

    public SK_jabatan getSKJabatanByNUK(String nuk);

    public void InsertSK_Jabatan(Pegawai pegawai, SK_jabatan sk);

    public void UpdateSK_Jabatan(Pegawai pegawai, SK_jabatan sk);

}
