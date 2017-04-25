/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tendy Developer
 */
public class InsertSK extends javax.swing.JFrame {

    /**
     * Creates new form InsertSK
     * @param data
     */
    
    

    public InsertSK(String data) {
        initComponents();
        try {
            setEnable(data);
        } catch (Exception ex) {
            Logger.getLogger(InsertSK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setEnable(String data) throws Exception{
        if (data.equalsIgnoreCase("DPK")) {
            js1.setEnabled(true);
            tmt1.setEnabled(true);
            sk1.setEnabled(true);
            dt1.setEnabled(true);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("TETAP")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(true);
            tmt2.setEnabled(true);
            sk2.setEnabled(true);
            dt2.setEnabled(true);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("KONTRAK")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(true);
            tmt3.setEnabled(true);
            sk3.setEnabled(true);
            dt3.setEnabled(true);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("TUGAS BELAJAR")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(true);
            tmt4.setEnabled(true);
            sk4.setEnabled(true);
            dt4.setEnabled(true);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("CUTI LT YAYASAN")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(true);
            tmt5.setEnabled(true);
            sk5.setEnabled(true);
            dt5.setEnabled(true);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("PINDAH")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(true);
            tmt6.setEnabled(true);
            sk6.setEnabled(true);
            dt6.setEnabled(true);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("PENSIUN")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(true);
            tmt7.setEnabled(true);
            sk7.setEnabled(true);
            dt7.setEnabled(true);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("BERHENTI")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(true);
            tmt8.setEnabled(true);
            sk8.setEnabled(true);
            dt8.setEnabled(true);
            js9.setEnabled(false);
            tmt9.setEnabled(false);
            sk9.setEnabled(false);
            dt9.setEnabled(false);
        }else if (data.equalsIgnoreCase("MENINGGAL")) {
            js1.setEnabled(false);
            tmt1.setEnabled(false);
            sk1.setEnabled(false);
            dt1.setEnabled(false);
            js2.setEnabled(false);
            tmt2.setEnabled(false);
            sk2.setEnabled(false);
            dt2.setEnabled(false);
            js3.setEnabled(false);
            tmt3.setEnabled(false);
            sk3.setEnabled(false);
            dt3.setEnabled(false);
            js4.setEnabled(false);
            tmt4.setEnabled(false);
            sk4.setEnabled(false);
            dt4.setEnabled(false);
            js5.setEnabled(false);
            tmt5.setEnabled(false);
            sk5.setEnabled(false);
            dt5.setEnabled(false);
            js6.setEnabled(false);
            tmt6.setEnabled(false);
            sk6.setEnabled(false);
            dt6.setEnabled(false);
            js7.setEnabled(false);
            tmt7.setEnabled(false);
            sk7.setEnabled(false);
            dt7.setEnabled(false);
            js8.setEnabled(false);
            tmt8.setEnabled(false);
            sk8.setEnabled(false);
            dt8.setEnabled(false);
            js9.setEnabled(true);
            tmt9.setEnabled(true);
            sk9.setEnabled(true);
            dt9.setEnabled(true);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tmt1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sk1 = new javax.swing.JTextField();
        js1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        js2 = new javax.swing.JLabel();
        tmt2 = new javax.swing.JTextField();
        sk2 = new javax.swing.JTextField();
        js3 = new javax.swing.JLabel();
        tmt3 = new javax.swing.JTextField();
        sk3 = new javax.swing.JTextField();
        js4 = new javax.swing.JLabel();
        tmt4 = new javax.swing.JTextField();
        sk4 = new javax.swing.JTextField();
        js8 = new javax.swing.JLabel();
        tmt8 = new javax.swing.JTextField();
        sk8 = new javax.swing.JTextField();
        js9 = new javax.swing.JLabel();
        tmt9 = new javax.swing.JTextField();
        sk9 = new javax.swing.JTextField();
        dt1 = new com.toedter.calendar.JDateChooser();
        dt2 = new com.toedter.calendar.JDateChooser();
        dt3 = new com.toedter.calendar.JDateChooser();
        dt4 = new com.toedter.calendar.JDateChooser();
        dt8 = new com.toedter.calendar.JDateChooser();
        dt9 = new com.toedter.calendar.JDateChooser();
        sk5 = new javax.swing.JTextField();
        js5 = new javax.swing.JLabel();
        tmt5 = new javax.swing.JTextField();
        dt5 = new com.toedter.calendar.JDateChooser();
        sk6 = new javax.swing.JTextField();
        js6 = new javax.swing.JLabel();
        tmt6 = new javax.swing.JTextField();
        dt6 = new com.toedter.calendar.JDateChooser();
        sk7 = new javax.swing.JTextField();
        js7 = new javax.swing.JLabel();
        tmt7 = new javax.swing.JTextField();
        dt7 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SAVE SK");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Jenis SK");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("TMT");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("No. SK");

        js1.setText("DPK");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tanggal");

        js2.setText("TETAP");

        js3.setText("KONTRAK");

        js4.setText("Tugas Blj");

        js8.setText("Berhenti");

        js9.setText("Meninggal");

        js5.setText("Cuti LTY");

        js6.setText("Pindah");

        js7.setText("Pensiun ");

        jButton1.setText("SAVE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel12)
                        .addGap(256, 256, 256)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(js1)
                        .addGap(41, 41, 41)
                        .addComponent(tmt1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sk1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dt1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(js2)
                        .addGap(29, 29, 29)
                        .addComponent(tmt2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sk2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dt2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(js3)
                        .addGap(13, 13, 13)
                        .addComponent(tmt3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sk3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dt3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(js8)
                        .addGap(18, 18, 18)
                        .addComponent(tmt8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sk8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dt8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(js7)
                        .addGap(18, 18, 18)
                        .addComponent(tmt7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sk7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dt7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(js6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tmt6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sk6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(dt6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(js5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(js4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(tmt4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(sk4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(dt4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(tmt5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(sk5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(dt5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(js9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tmt9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sk9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(dt9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js1)
                    .addComponent(tmt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js2)
                    .addComponent(tmt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js3)
                    .addComponent(tmt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js4)
                    .addComponent(tmt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js5)
                    .addComponent(tmt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js6)
                    .addComponent(tmt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js7)
                    .addComponent(tmt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js8)
                    .addComponent(tmt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js9)
                    .addComponent(tmt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InsertSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertSK("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dt1;
    private com.toedter.calendar.JDateChooser dt2;
    private com.toedter.calendar.JDateChooser dt3;
    private com.toedter.calendar.JDateChooser dt4;
    private com.toedter.calendar.JDateChooser dt5;
    private com.toedter.calendar.JDateChooser dt6;
    private com.toedter.calendar.JDateChooser dt7;
    private com.toedter.calendar.JDateChooser dt8;
    private com.toedter.calendar.JDateChooser dt9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel js1;
    private javax.swing.JLabel js2;
    private javax.swing.JLabel js3;
    private javax.swing.JLabel js4;
    private javax.swing.JLabel js5;
    private javax.swing.JLabel js6;
    private javax.swing.JLabel js7;
    private javax.swing.JLabel js8;
    private javax.swing.JLabel js9;
    private javax.swing.JTextField sk1;
    private javax.swing.JTextField sk2;
    private javax.swing.JTextField sk3;
    private javax.swing.JTextField sk4;
    private javax.swing.JTextField sk5;
    private javax.swing.JTextField sk6;
    private javax.swing.JTextField sk7;
    private javax.swing.JTextField sk8;
    private javax.swing.JTextField sk9;
    private javax.swing.JTextField tmt1;
    private javax.swing.JTextField tmt2;
    private javax.swing.JTextField tmt3;
    private javax.swing.JTextField tmt4;
    private javax.swing.JTextField tmt5;
    private javax.swing.JTextField tmt6;
    private javax.swing.JTextField tmt7;
    private javax.swing.JTextField tmt8;
    private javax.swing.JTextField tmt9;
    // End of variables declaration//GEN-END:variables
}
