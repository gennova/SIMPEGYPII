/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import com.init.pegawai.Pegawai;
import com.init.sk_pegawai.SK_Pegawai;
import com.init.tools.DaoFactory;
import com.init.tools.Session;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tendy Developer
 */
public class InsertSK extends javax.swing.JFrame {

    private int aktif_kolom = 0;

    /**
     * Creates new form InsertSK
     *
     * @param data
     */
    public InsertSK(String data) {
        initComponents();
        setLocationRelativeTo(null);
        try {
            initApp();
            setEnable(data);
        } catch (Exception ex) {
            Logger.getLogger(InsertSK.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initApp() {
        Date date = GregorianCalendar.getInstance().getTime();
        dt1.setDate(date);
        dt2.setDate(date);
        dt3.setDate(date);
        dt4.setDate(date);
        dt5.setDate(date);
        dt6.setDate(date);
        dt7.setDate(date);
        dt8.setDate(date);
        dt9.setDate(date);
        tmt1.setDate(date);
        tmt2.setDate(date);
        tmt3.setDate(date);
        tmt4.setDate(date);
        tmt5.setDate(date);
        tmt6.setDate(date);
        tmt7.setDate(date);
        tmt8.setDate(date);
        tmt9.setDate(date);
    }

    private void setEnable(String data) throws Exception {
        if (data.equalsIgnoreCase("DPK")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 1);
            System.out.println("status dpk : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 1);
                tmt1.setDate(sdf.parse(skp.getTmt()));
                sk1.setText(skp.getNo_sk());
                dt1.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 1;
        } else if (data.equalsIgnoreCase("TETAP")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 2);
            System.out.println("status tetap : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 2);
                tmt2.setDate(sdf.parse(skp.getTmt()));
                sk2.setText(skp.getNo_sk());
                dt2.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 2;
        } else if (data.equalsIgnoreCase("KONTRAK")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 3);
            System.out.println("status kontrak : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 3);
                tmt3.setDate(sdf.parse(skp.getTmt()));
                sk3.setText(skp.getNo_sk());
                dt3.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 3;
        } else if (data.equalsIgnoreCase("TUGAS BELAJAR")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 4);
            System.out.println("status tgs belajar : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 4);
                tmt4.setDate(sdf.parse(skp.getTmt()));
                sk4.setText(skp.getNo_sk());
                dt4.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 4;
        } else if (data.equalsIgnoreCase("CUTI LT YAYASAN")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 5);
            System.out.println("status cuti lty : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 5);
                tmt5.setDate(sdf.parse(skp.getTmt()));
                sk5.setText(skp.getNo_sk());
                dt5.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 5;
        } else if (data.equalsIgnoreCase("PINDAH")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 6);
            System.out.println("status pindah : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 6);
                tmt6.setDate(sdf.parse(skp.getTmt()));
                sk6.setText(skp.getNo_sk());
                dt6.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 6;
        } else if (data.equalsIgnoreCase("PENSIUN")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 7);
            System.out.println("status pensiun : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 7);
                tmt7.setDate(sdf.parse(skp.getTmt()));
                sk7.setText(skp.getNo_sk());
                dt7.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 7;
        } else if (data.equalsIgnoreCase("BERHENTI")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 8);
            System.out.println("status berhenti : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 8);
                tmt8.setDate(sdf.parse(skp.getTmt()));
                sk8.setText(skp.getNo_sk());
                dt8.setDate(sdf.parse(skp.getTanggal()));
            }

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
            aktif_kolom = 8;
        } else if (data.equalsIgnoreCase("MENINGGAL")) {
            boolean status = DaoFactory.getK_Pegawai_Dao().cekStatusNUK(Session.getNUK(), 9);
            System.out.println("status meninggal : " + status);
            if (status == true) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SK_Pegawai skp = DaoFactory.getK_Pegawai_Dao().getSKPegawaiByNUK(Session.getNUK(), 9);
                tmt9.setDate(sdf.parse(skp.getTmt()));
                sk9.setText(skp.getNo_sk());
                dt9.setDate(sdf.parse(skp.getTanggal()));
            }
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
            aktif_kolom = 9;
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
        jLabel12 = new javax.swing.JLabel();
        sk1 = new javax.swing.JTextField();
        js1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        js2 = new javax.swing.JLabel();
        sk2 = new javax.swing.JTextField();
        js3 = new javax.swing.JLabel();
        sk3 = new javax.swing.JTextField();
        js4 = new javax.swing.JLabel();
        sk4 = new javax.swing.JTextField();
        js8 = new javax.swing.JLabel();
        sk8 = new javax.swing.JTextField();
        js9 = new javax.swing.JLabel();
        sk9 = new javax.swing.JTextField();
        dt1 = new com.toedter.calendar.JDateChooser();
        dt2 = new com.toedter.calendar.JDateChooser();
        dt3 = new com.toedter.calendar.JDateChooser();
        dt4 = new com.toedter.calendar.JDateChooser();
        dt8 = new com.toedter.calendar.JDateChooser();
        dt9 = new com.toedter.calendar.JDateChooser();
        sk5 = new javax.swing.JTextField();
        js5 = new javax.swing.JLabel();
        dt5 = new com.toedter.calendar.JDateChooser();
        sk6 = new javax.swing.JTextField();
        js6 = new javax.swing.JLabel();
        dt6 = new com.toedter.calendar.JDateChooser();
        sk7 = new javax.swing.JTextField();
        js7 = new javax.swing.JLabel();
        dt7 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        tmt1 = new com.toedter.calendar.JDateChooser();
        tmt2 = new com.toedter.calendar.JDateChooser();
        tmt3 = new com.toedter.calendar.JDateChooser();
        tmt4 = new com.toedter.calendar.JDateChooser();
        tmt5 = new com.toedter.calendar.JDateChooser();
        tmt6 = new com.toedter.calendar.JDateChooser();
        tmt7 = new com.toedter.calendar.JDateChooser();
        tmt8 = new com.toedter.calendar.JDateChooser();
        tmt9 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SAVE SK");
        setBackground(new java.awt.Color(0, 255, 255));
        setResizable(false);

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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(js1)
                    .addComponent(js2)
                    .addComponent(js5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(js3)
                    .addComponent(js6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(js4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(js7)
                    .addComponent(js8)
                    .addComponent(js9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tmt1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tmt2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tmt3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tmt4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tmt5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tmt6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tmt7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tmt8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tmt9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(sk1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel11)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel12)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dt1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel14)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js1)
                    .addComponent(tmt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js2)
                    .addComponent(tmt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js3)
                    .addComponent(tmt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js6)
                    .addComponent(tmt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js7)
                    .addComponent(tmt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js8)
                    .addComponent(tmt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sk8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(js9)
                            .addComponent(tmt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sk9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (aktif_kolom == 1) {
            String tmt = sdf.format(tmt1.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk1.getText();
            String tanggal = sdf.format(dt1.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js1.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 2) {
            String tmt = sdf.format(tmt2.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk2.getText();
            String tanggal = sdf.format(dt2.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js2.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 3) {
            String tmt = sdf.format(tmt3.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk3.getText();
            String tanggal = sdf.format(dt3.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js3.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 4) {
            String tmt = sdf.format(tmt4.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk4.getText();
            String tanggal = sdf.format(dt4.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js4.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 5) {
            String tmt = sdf.format(tmt5.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk5.getText();
            String tanggal = sdf.format(dt5.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js5.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 6) {
            String tmt = sdf.format(tmt6.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk6.getText();
            String tanggal = sdf.format(dt6.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js6.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 7) {
            String tmt = sdf.format(tmt7.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk7.getText();
            String tanggal = sdf.format(dt7.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js7.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 8) {
            String tmt = sdf.format(tmt8.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk8.getText();
            String tanggal = sdf.format(dt8.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js8.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        } else if (aktif_kolom == 9) {
            String tmt = sdf.format(tmt9.getDate());
            String tmt_indo = DaoFactory.FormatTanggalIndonesia(tmt);
            String no_sk = sk9.getText();
            String tanggal = sdf.format(dt9.getDate());
            String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            String statuspegawai = js9.getText();
            SK_Pegawai skp = new SK_Pegawai();
            skp.setKolom_kategori(aktif_kolom);
            skp.setNuk(Session.getNUK());
            skp.setPegawai(pegawai);
            skp.setTmt(tmt);
            skp.setTmt_indo(tmt_indo);
            skp.setNo_sk(no_sk);
            skp.setTanggal(tanggal);
            skp.setTanggal_indo(tanggal_indo);
            skp.setStatus_pegawai_str(statuspegawai);
            DaoFactory.getK_Pegawai_Dao().InsertSKPegawai(skp);
        }
        JOptionPane.showMessageDialog(null, "Ok Tersimpan");

    }//GEN-LAST:event_jButton1ActionPerformed

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
    private com.toedter.calendar.JDateChooser tmt1;
    private com.toedter.calendar.JDateChooser tmt2;
    private com.toedter.calendar.JDateChooser tmt3;
    private com.toedter.calendar.JDateChooser tmt4;
    private com.toedter.calendar.JDateChooser tmt5;
    private com.toedter.calendar.JDateChooser tmt6;
    private com.toedter.calendar.JDateChooser tmt7;
    private com.toedter.calendar.JDateChooser tmt8;
    private com.toedter.calendar.JDateChooser tmt9;
    // End of variables declaration//GEN-END:variables
}
