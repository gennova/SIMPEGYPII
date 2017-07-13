/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import com.init.golongan.Golongan;
import com.init.golonganpangkat.Pangkat;
import com.init.pegawai.Pegawai;
import com.init.tools.DaoFactory;
import com.init.tools.Session;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amnesia
 */
public class UpdateSKPUI extends javax.swing.JFrame {

    /**
     * Creates new form UpdateSKPUI
     */
    public UpdateSKPUI() {
        initComponents();
        setLocationRelativeTo(null);
        initData();
        initAPP();
    }

    private void initData() {
        Date date = GregorianCalendar.getInstance().getTime();
        List<Golongan> golongans = DaoFactory.getGolonganDao().getAllGolongans();
        tmt_golongan_combo.removeAllItems();
        for (int i = 0; i < golongans.size(); i++) {
            tmt_golongan_combo.addItem(golongans.get(i).getNamagolongan());
        }
        tmt_golongan_date.setDate(date);
        tgl_sk.setDate(date);
    }

    private void initAPP() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Pegawai pegawai = Session.getPegawai();
        if (pegawai != null) {
            txtNama.setText(pegawai.getNama());
        }

        Pangkat pangkat = Session.getPangkat();
        try {
            tmt_golongan_date.setDate(sdf.parse(pangkat.getTMTGolongan()));
        } catch (ParseException ex) {
            Logger.getLogger(UpdateSKPUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        no_sk.setText(pangkat.getNomor_sk());
        try {
            System.out.println("tanggal sk" + pangkat.getTanggal_sk());
            tgl_sk.setDate(sdf.parse(pangkat.getTanggal_sk()));
        } catch (ParseException ex) {
            Logger.getLogger(UpdateSKPUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtRuang.setText(pangkat.getRuang());
        txtGaji.setText(pangkat.getGaji_str());
        txtID.setText(String.valueOf(pangkat.getId()));
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
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tmt_golongan_combo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tmt_golongan_date = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        no_sk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tgl_sk = new com.toedter.calendar.JDateChooser();
        txtRuang = new javax.swing.JTextField();
        txtGaji = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        UpdateRiwayat = new javax.swing.JButton();
        txtNamaPangkat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Riwayat SKP");

        jLabel1.setText("Kode");

        txtID.setEditable(false);

        jLabel2.setText("Nama");

        txtNama.setEditable(false);

        jLabel3.setText("Golongan");

        tmt_golongan_combo.setEditable(true);
        tmt_golongan_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tmt_golongan_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmt_golongan_comboActionPerformed(evt);
            }
        });

        jLabel4.setText("TMT Golongan");

        jLabel5.setText("Nomor SK");

        jLabel6.setText("Tanggal SK");

        jLabel7.setText("Ruang");

        jLabel8.setText("Gaji");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        UpdateRiwayat.setText("Update");
        UpdateRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateRiwayatActionPerformed(evt);
            }
        });

        txtNamaPangkat.setText(".................................................");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tmt_golongan_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(no_sk)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tmt_golongan_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tgl_sk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtNamaPangkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(UpdateRiwayat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(txtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(tmt_golongan_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaPangkat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(tmt_golongan_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(no_sk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(tgl_sk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(UpdateRiwayat))
                .addGap(20, 20, 20))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {no_sk, tgl_sk, tmt_golongan_combo, tmt_golongan_date, txtGaji, txtID, txtNama, txtRuang});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UpdateRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateRiwayatActionPerformed
        // TODO add your handling code here:
        Pangkat pangkat_update = new Pangkat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        pangkat_update.setId(Integer.parseInt(txtID.getText()));
        pangkat_update.setPegawai(DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK()));
        pangkat_update.setGolongan(DaoFactory.getGolonganDao().getGolonganByNamaGolongan(tmt_golongan_combo.getSelectedItem().toString()));
        pangkat_update.setTMTGolongan(sdf.format(tmt_golongan_date.getDate()));
        pangkat_update.setTMTGolongan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tmt_golongan_date.getDate())));
        pangkat_update.setNomor_sk(no_sk.getText());
        pangkat_update.setTanggal_sk(sdf.format(tgl_sk.getDate()));
        pangkat_update.setTanggal_sk_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tgl_sk.getDate())));
        pangkat_update.setRuang(txtRuang.getText());
        pangkat_update.setGaji_str(txtGaji.getText());
        DaoFactory.getPangkatDao().UpdateDataRiwayatPangkatByID(pangkat_update);
        this.dispose();
    }//GEN-LAST:event_UpdateRiwayatActionPerformed

    private void tmt_golongan_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmt_golongan_comboActionPerformed
        // TODO add your handling code here:
        if (tmt_golongan_combo.getSelectedIndex() >= 0) {
            txtNamaPangkat.setText(DaoFactory.getGolonganDao().getGolonganByNamaGolongan(tmt_golongan_combo.getSelectedItem().toString()).getPangkat());
        }

    }//GEN-LAST:event_tmt_golongan_comboActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateSKPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSKPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSKPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSKPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSKPUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateRiwayat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField no_sk;
    private com.toedter.calendar.JDateChooser tgl_sk;
    private javax.swing.JComboBox<String> tmt_golongan_combo;
    private com.toedter.calendar.JDateChooser tmt_golongan_date;
    private javax.swing.JTextField txtGaji;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JLabel txtNamaPangkat;
    private javax.swing.JTextField txtRuang;
    // End of variables declaration//GEN-END:variables
}
