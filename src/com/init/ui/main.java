/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import com.init.gaji.RiwayatGajiPegawai;
import com.init.tools.DaoFactory;
import com.init.tools.Rupiah;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author amnesia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date d = new GregorianCalendar().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.YEAR, 5);
        System.out.println(c.getTime());
        System.out.println(Rupiah.convert(194854789));

        System.out.println(DaoFactory.getFormatRupiahIndonesiaInt(9823910));
        
        System.out.println(DaoFactory.ConvertDoubleToInt(9.90));
        
        RiwayatGajiPegawai riwayatGajiPegawai = DaoFactory.getRiwayat_Gaji_pegawai_dao().getGajiPegawaiByNUKRiwayat("0501");
        System.out.println(riwayatGajiPegawai.getGolongan().getNamagolongan());
    }

}
