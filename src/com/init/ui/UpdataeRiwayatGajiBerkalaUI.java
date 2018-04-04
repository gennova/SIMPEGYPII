/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import com.init.gaji.RiwayatGajiPegawai;
import com.init.golongan.Golongan;
import com.init.jabatan.Jabatan;
import com.init.pegawai.Pegawai;
import com.init.tools.DaoFactory;
import com.init.tools.Session;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amnesia
 */
public class UpdataeRiwayatGajiBerkalaUI extends javax.swing.JFrame {

    /**
     * Creates new form InsertRiwayatGajiBerkalaUI
     */
    public UpdataeRiwayatGajiBerkalaUI() {
        initComponents();
        setLocationRelativeTo(null);
        initApp();
    }

    private void initApp() {
        combojabatan.removeAllItems();
        combopangkat.removeAllItems();
        List<Golongan> gols = DaoFactory.getGolonganDao().getAllGolongans();
        List<Jabatan> jabatans = DaoFactory.getJabatanDao().getAllJabatan();
        for (Jabatan jabatan : jabatans) {
            combojabatan.addItem(jabatan.getNamajabatan());
        }
        for (Golongan golongan : gols) {
            combopangkat.addItem(golongan.getNamagolongan());
        }
        tglSKKgb.setDate(GregorianCalendar.getInstance().getTime());
        tmtKGBDate.setDate(GregorianCalendar.getInstance().getTime());
        RiwayatGajiPegawai rgp = DaoFactory.getRiwayat_Gaji_pegawai_dao().getGajiPegawaiByID(Session.getRiwayatGajiID());
        txtNuk.setText(rgp.getPegawai().getNUK());
        combopangkat.setSelectedItem(rgp.getGolongan().getNamagolongan());
        txtRuang.setText(String.valueOf(rgp.getRuang()));
        txtGaji.setText(rgp.getGaji_pokok_str());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            tmtKGBDate.setDate(sdf.parse(rgp.getKbg_yad_date()));
            tglSKKgb.setDate(sdf.parse(rgp.getTanggal()));
        } catch (ParseException ex) {
            Logger.getLogger(UpdataeRiwayatGajiBerkalaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNoSKKgb.setText(rgp.getNo_kgb());
        combojabatan.setSelectedItem(rgp.getJabatan().getNamajabatan());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradientUpDownShape1 = new Code.Name.Flamboyan.SwingMakeOver.PanelGradientUpDownShape();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNuk = new javax.swing.JTextField();
        txtNamaPegawai = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combopangkat = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtRuang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGaji = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tmtKGBDate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtNoSKKgb = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tglSKKgb = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        combojabatan = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNamaPangkat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Riwayat Pegawai");
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MEMPERBAHARUI DAFTAR RIWAYAT GAJI BERKALA MANUAL");

        javax.swing.GroupLayout panelGradientUpDownShape1Layout = new javax.swing.GroupLayout(panelGradientUpDownShape1);
        panelGradientUpDownShape1.setLayout(panelGradientUpDownShape1Layout);
        panelGradientUpDownShape1Layout.setHorizontalGroup(
            panelGradientUpDownShape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradientUpDownShape1Layout.setVerticalGroup(
            panelGradientUpDownShape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradientUpDownShape1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel2.setText("NUK");

        txtNuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNukActionPerformed(evt);
            }
        });

        txtNamaPegawai.setText("Nama Pegawai");

        jLabel4.setText("Pangkat / Golongan ");

        combopangkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combopangkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopangkatActionPerformed(evt);
            }
        });

        jLabel5.setText("Ruang");

        jLabel6.setText("Tahun");

        jLabel7.setText("Gaji");

        jLabel8.setText("TMT KGB");

        jLabel9.setText("Nomor SK KGB");

        jLabel10.setText("Tgl.");

        jLabel11.setText("Jabatan");

        combojabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNuk, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(combojabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNoSKKgb, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tmtKGBDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtGaji, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglSKKgb, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combopangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addComponent(panelGradientUpDownShape1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combopangkat, txtNuk, txtRuang});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradientUpDownShape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPegawai)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(combopangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNamaPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(tmtKGBDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNoSKKgb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(tglSKKgb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(combojabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combopangkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopangkatActionPerformed
        // TODO add your handling code here:
        if (combopangkat.getItemCount() > 0) {
            txtNamaPangkat.setText(DaoFactory.getGolonganDao().getGolonganByNamaGolongan(combopangkat.getSelectedItem().toString()).getPangkat());
        }
    }//GEN-LAST:event_combopangkatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNukActionPerformed
        // TODO add your handling code here:
        Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(txtNuk.getText());
        if (pegawai != null) {
            txtNamaPegawai.setText(pegawai.getNama());
            txtNamaPegawai.setFont(new Font("Arial Bold", Font.BOLD, 14));
        } else {
            JOptionPane.showMessageDialog(null, "Data Pegawai Tidak Ditemukan");
        }
    }//GEN-LAST:event_txtNukActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(txtNuk.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (pegawai != null) {
            txtNamaPegawai.setText(pegawai.getNama());
            Golongan golongan = DaoFactory.getGolonganDao().getGolonganByNamaGolongan(combopangkat.getSelectedItem().toString());
            String ruang = txtRuang.getText();
            Double gaji = Double.parseDouble(txtGaji.getText());
            String tglTMTKgb = sdf.format(tmtKGBDate.getDate());
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(tmtKGBDate.getDate());
            calendar.add(Calendar.YEAR, Integer.parseInt(ruang));
            String kgb_yad = sdf.format(calendar.getTime());
            String kgb_yad_indo = DaoFactory.FormatTanggalIndonesia(kgb_yad);
            String noSK = txtNoSKKgb.getText();
            String tglNoSK = sdf.format(tglSKKgb.getDate());
            Jabatan jabatan = DaoFactory.getJabatanDao().getJabatanByNama(combojabatan.getSelectedItem().toString());
            RiwayatGajiPegawai rgp = new RiwayatGajiPegawai();
            rgp.setPegawai(pegawai);
            rgp.setGolongan(golongan);
            rgp.setRuang(Integer.parseInt(ruang));
            rgp.setGaji_pokok(gaji);
            rgp.setTmt_lama(tglTMTKgb);
            rgp.setNo_kgb(noSK);
            rgp.setJabatan(jabatan);
            rgp.setTanggal(tglNoSK);
            rgp.setKbg_yad_date(kgb_yad);
            rgp.setKgb_yad_indo(kgb_yad_indo);
            rgp.setId(Session.getRiwayatGajiID());
            DaoFactory.getRiwayat_Gaji_pegawai_dao().UpdateRiwayatGajiPegawaiManual(rgp);
            initApp();
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdataeRiwayatGajiBerkalaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdataeRiwayatGajiBerkalaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdataeRiwayatGajiBerkalaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdataeRiwayatGajiBerkalaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdataeRiwayatGajiBerkalaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combojabatan;
    private javax.swing.JComboBox<String> combopangkat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private Code.Name.Flamboyan.SwingMakeOver.PanelGradientUpDownShape panelGradientUpDownShape1;
    private com.toedter.calendar.JDateChooser tglSKKgb;
    private com.toedter.calendar.JDateChooser tmtKGBDate;
    private javax.swing.JTextField txtGaji;
    private javax.swing.JLabel txtNamaPangkat;
    private javax.swing.JLabel txtNamaPegawai;
    private javax.swing.JTextField txtNoSKKgb;
    private javax.swing.JTextField txtNuk;
    private javax.swing.JTextField txtRuang;
    // End of variables declaration//GEN-END:variables
}
