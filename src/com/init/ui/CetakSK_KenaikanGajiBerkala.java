/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import code.init.pekerjaanjabatan.PekerjaanJabatan;
import com.init.gaji.RiwayatGajiPegawai;
import com.init.golonganpangkat.Pangkat;
import com.init.pegawai.Pegawai;
import com.init.pendidikan_pegawai.PendidikanPegawai;
import com.init.riwayat_jabatan.RiwayatJabatan;
import com.init.riwayat_skp.RiwayatSK_KP;
import com.init.tools.DaoFactory;
import com.init.tools.PrintReport;
import com.init.tools.Rupiah;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author amnesia
 */
public class CetakSK_KenaikanGajiBerkala extends javax.swing.JFrame {

    /**
     * Creates new form CetakSK_KenaikanPangkat
     */
    public CetakSK_KenaikanGajiBerkala() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNuk = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNamaPegawai = new javax.swing.JTextField();
        txtLahir = new javax.swing.JTextField();
        txtIjazah = new javax.swing.JTextField();
        txtUnit = new javax.swing.JTextField();
        txtFoto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPangkatLama = new javax.swing.JTextField();
        txtNamaJabatan = new javax.swing.JTextField();
        txtGolonganGajiLama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPangkatBaru = new javax.swing.JTextField();
        txtNamaJabatanBaru = new javax.swing.JTextField();
        txtGolonganGajiBaru = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTMT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ButtonCetakRiwayatGaji = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cetak SK Kenaikan Gaji Berkala");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("NUK");

        txtNuk.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtNuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNukActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel3.setText("Tempat/Tanggal Lahir");

        jLabel4.setText("Ijazah");

        jLabel5.setText("Unit Kerja");

        txtNamaPegawai.setEditable(false);

        txtLahir.setEditable(false);

        txtIjazah.setEditable(false);
        txtIjazah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIjazahActionPerformed(evt);
            }
        });

        txtUnit.setEditable(false);

        txtFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFoto.setText("Photo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtIjazah)
                            .addComponent(txtUnit)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(txtNuk, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtIjazah, txtLahir, txtNamaPegawai, txtUnit});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtNuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtIjazah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Pangkat");

        jLabel8.setText("Jabatan");

        jLabel9.setText("Golongan/Gaji");

        txtPangkatLama.setEditable(false);

        txtNamaJabatan.setEditable(false);

        txtGolonganGajiLama.setEditable(false);

        jLabel10.setText("Jabatan");

        jLabel11.setText("Golongan/Gaji");

        txtPangkatBaru.setEditable(false);

        txtNamaJabatanBaru.setEditable(false);

        txtGolonganGajiBaru.setEditable(false);

        jLabel12.setText("Pangkat");

        jLabel13.setText("LAMA");

        jLabel14.setText("BARU");

        txtTMT.setEditable(false);

        jLabel15.setText("T.M.T");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPangkatLama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(txtNamaJabatan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGolonganGajiLama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTMT, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(txtGolonganGajiBaru)
                    .addComponent(txtNamaJabatanBaru, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPangkatBaru, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(136, 136, 136))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel12)
                            .addComponent(txtPangkatBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel10)
                            .addComponent(txtNamaJabatanBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel11)
                            .addComponent(txtGolonganGajiBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel15)
                            .addComponent(txtTMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPangkatLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtGolonganGajiLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonCetakRiwayatGaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/1360104617_print_32.png"))); // NOI18N
        ButtonCetakRiwayatGaji.setText("Cetak");
        ButtonCetakRiwayatGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCetakRiwayatGajiActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/1360057074_button_cancel.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(ButtonCetakRiwayatGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonCetakRiwayatGaji)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonCetakRiwayatGaji, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIjazahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIjazahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIjazahActionPerformed

    private void ButtonCetakRiwayatGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCetakRiwayatGajiActionPerformed
        // TODO add your handling code here:
        String nuknya = txtNuk.getText();
        Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuknya);
        PendidikanPegawai pendidikanPegawai = DaoFactory.getPendidikanPegawaiDao().getPendidikanPegawaiByNUK(nuknya);
        PekerjaanJabatan pj = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nuknya);
        RiwayatJabatan pj_lama = DaoFactory.getRiwayatJabatanDao().getRiwayatJabatanLastByNUK(nuknya);
        //----------------------------------------------------------------------//
        //Data Pokok Pangkat Lama//
        RiwayatSK_KP skp_lama = DaoFactory.getRiwayatSK_KPDao().getRiwayatSKKP_LamaByNukLast(nuknya);
        //Data Pokok Pangkat Baru
        Pangkat pangkat_baru = DaoFactory.getPangkatDao().getPangkatByNUK(nuknya);
        HashMap hashMap = new HashMap();
        hashMap.put("nuknya", txtNuk.getText());
        if (skp_lama != null) {
            hashMap.put("pangkatlama", skp_lama.getGolongan().getPangkat());
            hashMap.put("golonganlama", skp_lama.getGolongan().getNamagolongan() + " - " + skp_lama.getTahun_kerja() + " - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(Integer.parseInt(skp_lama.getGaji_str())));
            hashMap.put("terbilanglama", Rupiah.convert(Integer.parseInt(skp_lama.getGaji_str())) + " Rupiah");
        } else {
            hashMap.put("pangkatlama", pangkat_baru.getGolongan().getPangkat());
            RiwayatGajiPegawai riwayatGajiPegawai = DaoFactory.getRiwayat_Gaji_pegawai_dao().getGajiPegawaiByNUKRiwayat(nuknya);
            if (riwayatGajiPegawai != null) {
                hashMap.put("golonganlama", pangkat_baru.getGolongan().getNamagolongan() + " - " + pangkat_baru.getTahun_masa_kerja() + " Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(riwayatGajiPegawai.getGaji_pokok())));
                hashMap.put("terbilanglama", Rupiah.convert(DaoFactory.ConvertDoubleToInt(riwayatGajiPegawai.getGaji_pokok())) + "Rupiah");
            } else {
                hashMap.put("golonganlama", pangkat_baru.getGolongan().getNamagolongan() + " - " + pangkat_baru.getTahun_masa_kerja() + " - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(nuknya).getGaji_pokok())));
                hashMap.put("terbilanglama", Rupiah.convert(DaoFactory.ConvertDoubleToInt(DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(nuknya).getGaji_pokok())));
            }
        }
        if (pj_lama == null) {
            hashMap.put("jabatanlama", pj.getJabatan().getNamajabatan());
        } else {
            hashMap.put("jabatanlama", pj_lama.getJabatan().getNamajabatan());
        }
        hashMap.put("golonganbaru", pangkat_baru.getGolongan().getNamagolongan() + " - " + pangkat_baru.getTahun_masa_kerja() + " - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(nuknya).getGaji_pokok())));
        double data = DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(nuknya).getGaji_pokok();
        int news = (int) data;
        hashMap.put("terbilangbaru", Rupiah.convert(news) + "Rupiah");
        new PrintReport("./report/kenaikan_gaji_berkala.jasper", hashMap);
    }//GEN-LAST:event_ButtonCetakRiwayatGajiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNukActionPerformed
        // TODO add your handling code here:
        String nuknya = txtNuk.getText();
        Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuknya);
        if (pegawai == null) {
            JOptionPane.showMessageDialog(null, "Data nuk pegawai tidak ditemukan");
        } else {
            txtNamaPegawai.setText(pegawai.getNama());
            txtLahir.setText(pegawai.getTLahir());
            PendidikanPegawai pendidikanPegawai = DaoFactory.getPendidikanPegawaiDao().getPendidikanPegawaiByNUK(nuknya);
            String tahunlulus = pendidikanPegawai.getTglLulusSKPendidikanAkhir();
            txtIjazah.setText(pendidikanPegawai.getIjazahAngkat().getNamaIjazahPengangkatan() + " Tahun " + tahunlulus.substring(0, 4));
            ImageIcon imageIcon = new ImageIcon("image/" + pegawai.getTeksFilename());
            System.out.println(pegawai.getTeksFilename());
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
            //displayPhotoTxt.setIcon(imageIcon);
            txtFoto.setIcon(new ImageIcon(newimg));
        }
        PekerjaanJabatan pj = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nuknya);
        RiwayatJabatan pj_lama = DaoFactory.getRiwayatJabatanDao().getRiwayatJabatanLastByNUK(nuknya);
        Pangkat pangkat_baru = DaoFactory.getPangkatDao().getPangkatByNUK(nuknya);
        //----------------------------------------------------------------------//
        //Data Pokok Pangkat Lama//
        RiwayatSK_KP skp_lama = DaoFactory.getRiwayatSK_KPDao().getRiwayatSKKP_LamaByNukLast(nuknya);
        if (skp_lama != null) {
            txtPangkatLama.setText(skp_lama.getGolongan().getPangkat());
            System.out.println("Data riwayat skp ada");
            if (pj_lama == null) {
                txtNamaJabatan.setText(pj.getJabatan().getNamajabatan());
                System.out.println("Data riwayat jabatan tidak ada");
                txtUnit.setText(pj.getUnit().getNamaUnit() + " di " + pj.getCabang().getNamacabang());
            } else {
                System.out.println("Data riwayat jabatan ada");
                txtNamaJabatan.setText(pj_lama.getJabatan().getNamajabatan());
                txtUnit.setText(pj_lama.getUnit().getNamaUnit() + " di " + pj_lama.getCabang().getNamacabang());
            }
            RiwayatGajiPegawai riwayatGajiPegawai = DaoFactory.getRiwayat_Gaji_pegawai_dao().getGajiPegawaiByNUKRiwayat(nuknya);
            if (riwayatGajiPegawai == null) {
                System.out.println("Data riwayat gaji tidak ada");
                txtGolonganGajiLama.setText(skp_lama.getGolongan().getNamagolongan() + " - " + skp_lama.getTahun_kerja() + " Th - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(Integer.parseInt(skp_lama.getGaji_str())));
            } else {
                System.out.println("Data riwayat gaji ada");
                txtGolonganGajiLama.setText(skp_lama.getGolongan().getNamagolongan() + " - " + skp_lama.getTahun_kerja() + " Th - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(riwayatGajiPegawai.getGaji_pokok())));
            }
        } else {
            txtPangkatLama.setText(pangkat_baru.getGolongan().getPangkat());
            System.out.println("Data riwayat skp tidak ada");
            if (pj_lama == null) {
                System.out.println("Data riwayat jabatan tidak ada");
                txtNamaJabatan.setText(pj.getJabatan().getNamajabatan());
                txtUnit.setText(pj.getUnit().getNamaUnit() + " di " + pj.getCabang().getNamacabang());
            } else {
                System.out.println("Data riwayat jabatan ada");
                txtNamaJabatan.setText(pj_lama.getJabatan().getNamajabatan());
                txtUnit.setText(pj_lama.getUnit().getNamaUnit() + " di " + pj_lama.getCabang().getNamacabang());
            }
            RiwayatGajiPegawai riwayatGajiPegawai = DaoFactory.getRiwayat_Gaji_pegawai_dao().getGajiPegawaiByNUKRiwayat(nuknya);
            if (riwayatGajiPegawai == null) {
                System.out.println("Data riwayat gaji tidak ada");
                txtGolonganGajiLama.setText(pangkat_baru.getGolongan().getNamagolongan() + " - " + pangkat_baru.getTahun_masa_kerja() + " Th - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(nuknya).getGaji_pokok())));
            } else {
                System.out.println("Data riwayat gaji ada");
                txtGolonganGajiLama.setText(pangkat_baru.getGolongan().getNamagolongan() + " - " + riwayatGajiPegawai.getRuang() + " Th - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(riwayatGajiPegawai.getGaji_pokok())));
            }
        }

        //Data Pokok Pangkat Baru
        //Pangkat pangkat_baru = DaoFactory.getPangkatDao().getPangkatByNUK(nuknya);
        txtPangkatBaru.setText(pangkat_baru.getGolongan().getPangkat());
        txtNamaJabatanBaru.setText(pj.getJabatan().getNamajabatan());
        txtGolonganGajiBaru.setText(pangkat_baru.getGolongan().getNamagolongan() + " - " + pangkat_baru.getTahun_masa_kerja() + " Th - Rp. " + DaoFactory.getFormatRupiahIndonesiaInt(DaoFactory.ConvertDoubleToInt(DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(nuknya).getGaji_pokok())));
        txtTMT.setText(pangkat_baru.getTanggal_kgb());
    }//GEN-LAST:event_txtNukActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CetakSK_KenaikanGajiBerkala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CetakSK_KenaikanGajiBerkala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CetakSK_KenaikanGajiBerkala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CetakSK_KenaikanGajiBerkala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CetakSK_KenaikanGajiBerkala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCetakRiwayatGaji;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JTextField txtGolonganGajiBaru;
    private javax.swing.JTextField txtGolonganGajiLama;
    private javax.swing.JTextField txtIjazah;
    private javax.swing.JTextField txtLahir;
    private javax.swing.JTextField txtNamaJabatan;
    private javax.swing.JTextField txtNamaJabatanBaru;
    private javax.swing.JTextField txtNamaPegawai;
    private javax.swing.JTextField txtNuk;
    private javax.swing.JTextField txtPangkatBaru;
    private javax.swing.JTextField txtPangkatLama;
    private javax.swing.JTextField txtTMT;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
