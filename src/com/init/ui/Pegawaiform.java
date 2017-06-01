/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import code.init.pekerjaanjabatan.PekerjaanJabatan;
import com.init.golonganpangkat.Pangkat;
import com.init.pegawai.Pegawai;
import com.init.pegawai.PegawaiTabelModelSimple;
import com.init.pendidikan_pegawai.PendidikanPegawai;
import com.init.tools.DaoFactory;
import com.init.tools.Session;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tendy Developer
 */
public class Pegawaiform extends javax.swing.JFrame {

    private TableRowSorter<TableModel> rowSorter = null;
    private TableRowSorter<TableModel> rowSorterNUK = null;
    private TableRowSorter<TableModel> rowSorterNAMA = null;
    private TableRowSorter<TableModel> rowSorterWILAYAH = null;
    private TableRowSorter<TableModel> rowSorterBIDANG = null;
    private TableRowSorter<TableModel> rowSorterGOLONGAN = null;
    private TableRowSorter<TableModel> rowSorterUNIT = null;

    /**
     * Creates new form Pegawaiform
     */
    public Pegawaiform() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(820, 480);
        setExtendedState(MAXIMIZED_BOTH);
        showtabelpegawai();
    }

    private void showtabelpegawai() {
        PegawaiTabelModelSimple modelSimple = new PegawaiTabelModelSimple(DaoFactory.getPegawaiDao().getAllPegawaiAndBidangKerja());
        TabelPegawaiUtama.setModel(modelSimple);
        rowSorterNUK = new TableRowSorter(modelSimple);
        TabelPegawaiUtama.setRowSorter(rowSorterNUK);
        TabelPegawaiUtama.getColumnModel().getColumn(0).setPreferredWidth(100);
        TabelPegawaiUtama.getColumnModel().getColumn(1).setPreferredWidth(500);
        TabelPegawaiUtama.getColumnModel().getColumn(2).setPreferredWidth(300);
        txtTotalRow.setText(String.valueOf(modelSimple.getRowCount()) + " data");

        PegawaiTabelModelSimple modelSimpleUrutNama = new PegawaiTabelModelSimple(DaoFactory.getPegawaiDao().getAllPegawaiAndBidangKerjaNama());
        TabelPegawaiUtamaNama.setModel(modelSimpleUrutNama);
        rowSorterNAMA = new TableRowSorter(modelSimpleUrutNama);
        TabelPegawaiUtamaNama.setRowSorter(rowSorterNAMA);
        TabelPegawaiUtamaNama.getColumnModel().getColumn(0).setPreferredWidth(100);
        TabelPegawaiUtamaNama.getColumnModel().getColumn(1).setPreferredWidth(500);
        TabelPegawaiUtamaNama.getColumnModel().getColumn(2).setPreferredWidth(300);

        PegawaiTabelModelSimple modelSimpleUrutWilayah = new PegawaiTabelModelSimple(DaoFactory.getPegawaiDao().getAllPegawaiAndBidangKerjaWilayah());
        TabelPegawaiUtamaWilayah.setModel(modelSimpleUrutWilayah);
        rowSorterWILAYAH = new TableRowSorter(modelSimpleUrutNama);
        TabelPegawaiUtamaWilayah.setRowSorter(rowSorterWILAYAH);
        TabelPegawaiUtamaWilayah.getColumnModel().getColumn(0).setPreferredWidth(100);
        TabelPegawaiUtamaWilayah.getColumnModel().getColumn(1).setPreferredWidth(500);
        TabelPegawaiUtamaWilayah.getColumnModel().getColumn(2).setPreferredWidth(300);

        PegawaiTabelModelSimple modelSimpleUrutBidangKerja = new PegawaiTabelModelSimple(DaoFactory.getPegawaiDao().getAllPegawaiAndBidangKerjaBidangKerja());
        TabelPegawaiUtamaBidangKerja.setModel(modelSimpleUrutBidangKerja);
        rowSorterBIDANG = new TableRowSorter(modelSimpleUrutBidangKerja);
        TabelPegawaiUtamaBidangKerja.setRowSorter(rowSorterBIDANG);
        TabelPegawaiUtamaBidangKerja.getColumnModel().getColumn(0).setPreferredWidth(100);
        TabelPegawaiUtamaBidangKerja.getColumnModel().getColumn(1).setPreferredWidth(500);
        TabelPegawaiUtamaBidangKerja.getColumnModel().getColumn(2).setPreferredWidth(300);

        PegawaiTabelModelSimple modelSimpleUrutBidangGolongan = new PegawaiTabelModelSimple(DaoFactory.getPegawaiDao().getAllPegawaiAndBidangKerjaGolongan());
        TabelPegawaiUtamaGolongan.setModel(modelSimpleUrutBidangGolongan);
        rowSorterGOLONGAN = new TableRowSorter(modelSimpleUrutBidangGolongan);
        TabelPegawaiUtamaGolongan.setRowSorter(rowSorterGOLONGAN);
        TabelPegawaiUtamaGolongan.getColumnModel().getColumn(0).setPreferredWidth(100);
        TabelPegawaiUtamaGolongan.getColumnModel().getColumn(1).setPreferredWidth(500);
        TabelPegawaiUtamaGolongan.getColumnModel().getColumn(2).setPreferredWidth(300);

        PegawaiTabelModelSimple modelSimpleUrutBidangUnitKerja = new PegawaiTabelModelSimple(DaoFactory.getPegawaiDao().getAllPegawaiAndBidangKerjaUnitKerja());
        TabelPegawaiUtamaUnitKerja.setModel(modelSimpleUrutBidangUnitKerja);
        rowSorterUNIT = new TableRowSorter(modelSimpleUrutBidangUnitKerja);
        TabelPegawaiUtamaUnitKerja.setRowSorter(rowSorterUNIT);
        TabelPegawaiUtamaUnitKerja.getColumnModel().getColumn(0).setPreferredWidth(100);
        TabelPegawaiUtamaUnitKerja.getColumnModel().getColumn(1).setPreferredWidth(500);
        TabelPegawaiUtamaUnitKerja.getColumnModel().getColumn(2).setPreferredWidth(300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNUKUtama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPegawaiUtama = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNamaUtama = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelPegawaiUtamaNama = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtWilayahUtama = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TabelPegawaiUtamaWilayah = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBidangKerjaUtama = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        TabelPegawaiUtamaBidangKerja = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtGolonganUtama = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        TabelPegawaiUtamaGolongan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtUnitKerjaUtama = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        TabelPegawaiUtamaUnitKerja = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotalRow = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txtLabelJenisKelamin = new javax.swing.JLabel();
        txtLabelTempatLahir = new javax.swing.JLabel();
        txtLabelTglLahir = new javax.swing.JLabel();
        txtAgamaLabel = new javax.swing.JLabel();
        txtKawinLabel = new javax.swing.JLabel();
        txtStatusPegawaiLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtLabelPangkat = new javax.swing.JLabel();
        txtLabelGolongan = new javax.swing.JLabel();
        txtMKGolongan = new javax.swing.JLabel();
        txtMKSebenarnya = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtJenjangPendidikan = new javax.swing.JLabel();
        txtTglLulusPendidikanAkhir = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtLabelWilayahTugas = new javax.swing.JLabel();
        txtLabelUnitKerja = new javax.swing.JLabel();
        txtLabelJabatan = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Pokok  Pegawai");
        setResizable(false);

        jLabel1.setText("NUK");

        txtNUKUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNUKUtamaKeyReleased(evt);
            }
        });

        TabelPegawaiUtama.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama", "Bidang Pekerjaan"
            }
        ));
        TabelPegawaiUtama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPegawaiUtamaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPegawaiUtama);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(txtNUKUtama)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNUKUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Urut Nuk", jPanel1);

        jLabel4.setText("NAMA");

        txtNamaUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaUtamaKeyReleased(evt);
            }
        });

        TabelPegawaiUtamaNama.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama", "Bidang Pekerjaan"
            }
        ));
        TabelPegawaiUtamaNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPegawaiUtamaNamaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TabelPegawaiUtamaNama);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNamaUtama)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Urut Nama", jPanel2);

        jLabel5.setText("Wilayah");

        txtWilayahUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWilayahUtamaKeyReleased(evt);
            }
        });

        TabelPegawaiUtamaWilayah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama", "Bidang Pekerjaan"
            }
        ));
        TabelPegawaiUtamaWilayah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPegawaiUtamaWilayahMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TabelPegawaiUtamaWilayah);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtWilayahUtama)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtWilayahUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Wilayah", jPanel3);

        jLabel6.setText("Bidang Kerja");

        txtBidangKerjaUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBidangKerjaUtamaKeyReleased(evt);
            }
        });

        TabelPegawaiUtamaBidangKerja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama", "Bidang Pekerjaan"
            }
        ));
        TabelPegawaiUtamaBidangKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPegawaiUtamaBidangKerjaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TabelPegawaiUtamaBidangKerja);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBidangKerjaUtama)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBidangKerjaUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bidang Pekerjaan", jPanel4);

        jLabel7.setText("Golongan");

        txtGolonganUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGolonganUtamaKeyReleased(evt);
            }
        });

        TabelPegawaiUtamaGolongan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama", "Bidang Pekerjaan"
            }
        ));
        TabelPegawaiUtamaGolongan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPegawaiUtamaGolonganMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(TabelPegawaiUtamaGolongan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGolonganUtama)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGolonganUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Golongan", jPanel5);

        jLabel8.setText("Unit Kerja");

        txtUnitKerjaUtama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnitKerjaUtamaKeyReleased(evt);
            }
        });

        TabelPegawaiUtamaUnitKerja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama", "Bidang Pekerjaan"
            }
        ));
        TabelPegawaiUtamaUnitKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPegawaiUtamaUnitKerjaMouseClicked(evt);
            }
        });
        TabelPegawaiUtamaUnitKerja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelPegawaiUtamaUnitKerjaKeyReleased(evt);
            }
        });
        jScrollPane10.setViewportView(TabelPegawaiUtamaUnitKerja);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUnitKerjaUtama)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUnitKerjaUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Unit Kerja", jPanel6);

        jButton1.setText("Close");

        jButton2.setText("Delete");

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Insert");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Jumlah :");

        txtTotalRow.setText("Rows");

        jButton5.setText("Riwayat Penataran");

        jButton6.setText("Riwayat Pendidikan");

        jButton7.setText("Riwayat Jabatan");

        jButton8.setText("Riwayat SK KP");

        jButton9.setText("Riwayat SK KGB");

        jButton10.setText("Riwayat Jenis Tgs.");

        jButton11.setText("Riwayat Kontrak");

        jButton12.setText("Riwayat Kinerja");

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        txtLabelJenisKelamin.setText("-");

        txtLabelTempatLahir.setText("-");

        txtLabelTglLahir.setText("-");

        txtAgamaLabel.setText("-");

        txtKawinLabel.setText("-");

        txtStatusPegawaiLabel.setText("-");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLabelJenisKelamin)
                    .addComponent(txtLabelTempatLahir)
                    .addComponent(txtLabelTglLahir)
                    .addComponent(txtAgamaLabel)
                    .addComponent(txtKawinLabel)
                    .addComponent(txtStatusPegawaiLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(txtLabelJenisKelamin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLabelTempatLahir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLabelTglLahir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAgamaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKawinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStatusPegawaiLabel))
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Pangkat");

        jLabel11.setText("Golongan");

        jLabel12.setText("MK Golongan");

        jLabel13.setText("MK Sebenarnya");

        txtLabelPangkat.setText("-");

        txtLabelGolongan.setText("-");

        txtMKGolongan.setText("-");

        txtMKSebenarnya.setText("-");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMKGolongan)
                    .addComponent(txtLabelGolongan)
                    .addComponent(txtLabelPangkat)
                    .addComponent(txtMKSebenarnya))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtLabelPangkat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtLabelGolongan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMKGolongan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMKSebenarnya))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Jenjang Pendidikan");

        jLabel15.setText("Lulus");

        txtJenjangPendidikan.setText("-");

        txtTglLulusPendidikanAkhir.setText("- ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTglLulusPendidikanAkhir)
                    .addComponent(txtJenjangPendidikan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtJenjangPendidikan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTglLulusPendidikanAkhir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Wilayah Tugas");

        jLabel17.setText("Unit Kerja");

        jLabel18.setText("Jabatan");

        txtLabelWilayahTugas.setText("-");

        txtLabelUnitKerja.setText("-");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLabelJabatan)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLabelUnitKerja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLabelWilayahTugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtLabelWilayahTugas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtLabelUnitKerja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtLabelJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel18, txtLabelJabatan});

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton13.setText("Refresh");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(102, 25, 72));

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Developer : Atanasius Tendy || http://multisoftdeveloper.wordpress.com || atanasiustendy@hotmail.com || 085643221232 / 08112578800");

        jLabel9.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Powered By Java - MySQL - Ireport for Jasper Report");

        jLabel19.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Sistem Informasi Pendataan Kepegawaian & Kenaikan Pangkat Pegawai YPII Pusat - V-2.0");

        jLabel20.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("2017");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalRow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton10, jButton11, jButton12, jButton5, jButton6, jButton7, jButton8, jButton9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTotalRow)
                                .addComponent(jLabel2))
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton13))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Insertpegawai i = new Insertpegawai();
        i.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TabelPegawaiUtamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPegawaiUtamaMouseClicked
        // TODO add your handling code here:
        int row = TabelPegawaiUtama.getSelectedRow();
        System.out.println(row);
        if (row >= 0) {
            String nuk_utama_selected = TabelPegawaiUtama.getValueAt(row, 0).toString();
            txtNUKUtama.setText(nuk_utama_selected);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk_utama_selected);
            txtLabelJenisKelamin.setText(pegawai.getJK());
            txtLabelTempatLahir.setText(pegawai.getTLahir());
            txtLabelTglLahir.setText(pegawai.getTglLahir());
            txtAgamaLabel.setText(pegawai.getAgama());
            txtKawinLabel.setText(pegawai.getStatusPerkawinan());
            txtStatusPegawaiLabel.setText(pegawai.getStatusPegawai());
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(nuk_utama_selected);
            txtLabelPangkat.setText(pangkat.getGolongan().getPangkat());
            txtLabelGolongan.setText(pangkat.getGolongan().getNamagolongan());
            txtMKGolongan.setText(String.valueOf(pangkat.getTahun_masa_kerja()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja()) + " Bulan");
            txtMKSebenarnya.setText(String.valueOf(pangkat.getTahun_masa_kerja_sebenarnya()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja_sebenarnya()) + " Bulan");
            PekerjaanJabatan jabatan = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nuk_utama_selected);
            txtLabelWilayahTugas.setText(jabatan.getCabang().getNamacabang());
            txtLabelUnitKerja.setText(jabatan.getUnit().getNamaUnit());
            txtLabelJabatan.setText(jabatan.getJabatan().getNamajabatan());
            PendidikanPegawai pendidikanPegawai = DaoFactory.getPendidikanPegawaiDao().getPendidikanPegawaiByNUK(nuk_utama_selected);
            txtJenjangPendidikan.setText(pendidikanPegawai.getPendidikanTerakhir().getNamapendidikanterakhir());
            txtTglLulusPendidikanAkhir.setText(pendidikanPegawai.getTglLulusSKPendidikanAkhir());
        }
    }//GEN-LAST:event_TabelPegawaiUtamaMouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        showtabelpegawai();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void TabelPegawaiUtamaNamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPegawaiUtamaNamaMouseClicked
        // TODO add your handling code here:
        int row = TabelPegawaiUtamaNama.getSelectedRow();
        System.out.println(row);
        if (row >= 0) {
            String nama_utama_selected = TabelPegawaiUtamaNama.getValueAt(row, 0).toString();
            txtNamaUtama.setText(nama_utama_selected);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nama_utama_selected);
            txtLabelJenisKelamin.setText(pegawai.getJK());
            txtLabelTempatLahir.setText(pegawai.getTLahir());
            txtLabelTglLahir.setText(pegawai.getTglLahir());
            txtAgamaLabel.setText(pegawai.getAgama());
            txtKawinLabel.setText(pegawai.getStatusPerkawinan());
            txtStatusPegawaiLabel.setText(pegawai.getStatusPegawai());
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(nama_utama_selected);
            txtLabelPangkat.setText(pangkat.getGolongan().getPangkat());
            txtLabelGolongan.setText(pangkat.getGolongan().getNamagolongan());
            txtMKGolongan.setText(String.valueOf(pangkat.getTahun_masa_kerja()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja()) + " Bulan");
            txtMKSebenarnya.setText(String.valueOf(pangkat.getTahun_masa_kerja_sebenarnya()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja_sebenarnya()) + " Bulan");
            PekerjaanJabatan jabatan = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nama_utama_selected);
            txtLabelWilayahTugas.setText(jabatan.getCabang().getNamacabang());
            txtLabelUnitKerja.setText(jabatan.getUnit().getNamaUnit());
            txtLabelJabatan.setText(jabatan.getJabatan().getNamajabatan());
        }
    }//GEN-LAST:event_TabelPegawaiUtamaNamaMouseClicked

    private void TabelPegawaiUtamaWilayahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPegawaiUtamaWilayahMouseClicked
        // TODO add your handling code here:
        int row = TabelPegawaiUtamaWilayah.getSelectedRow();
        System.out.println(row);
        if (row >= 0) {
            String nuk_utama_selected = TabelPegawaiUtamaWilayah.getValueAt(row, 0).toString();
            txtNUKUtama.setText(nuk_utama_selected);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk_utama_selected);
            txtLabelJenisKelamin.setText(pegawai.getJK());
            txtLabelTempatLahir.setText(pegawai.getTLahir());
            txtLabelTglLahir.setText(pegawai.getTglLahir());
            txtAgamaLabel.setText(pegawai.getAgama());
            txtKawinLabel.setText(pegawai.getStatusPerkawinan());
            txtStatusPegawaiLabel.setText(pegawai.getStatusPegawai());
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(nuk_utama_selected);
            txtLabelPangkat.setText(pangkat.getGolongan().getPangkat());
            txtLabelGolongan.setText(pangkat.getGolongan().getNamagolongan());
            txtMKGolongan.setText(String.valueOf(pangkat.getTahun_masa_kerja()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja()) + " Bulan");
            txtMKSebenarnya.setText(String.valueOf(pangkat.getTahun_masa_kerja_sebenarnya()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja_sebenarnya()) + " Bulan");
            PekerjaanJabatan jabatan = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nuk_utama_selected);
            txtLabelWilayahTugas.setText(jabatan.getCabang().getNamacabang());
            txtLabelUnitKerja.setText(jabatan.getUnit().getNamaUnit());
            txtLabelJabatan.setText(jabatan.getJabatan().getNamajabatan());
        }
    }//GEN-LAST:event_TabelPegawaiUtamaWilayahMouseClicked

    private void TabelPegawaiUtamaBidangKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPegawaiUtamaBidangKerjaMouseClicked
        // TODO add your handling code here:
        int row = TabelPegawaiUtamaBidangKerja.getSelectedRow();
        System.out.println(row);
        if (row >= 0) {
            String nuk_utama_selected = TabelPegawaiUtamaBidangKerja.getValueAt(row, 0).toString();
            txtNUKUtama.setText(nuk_utama_selected);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk_utama_selected);
            txtLabelJenisKelamin.setText(pegawai.getJK());
            txtLabelTempatLahir.setText(pegawai.getTLahir());
            txtLabelTglLahir.setText(pegawai.getTglLahir());
            txtAgamaLabel.setText(pegawai.getAgama());
            txtKawinLabel.setText(pegawai.getStatusPerkawinan());
            txtStatusPegawaiLabel.setText(pegawai.getStatusPegawai());
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(nuk_utama_selected);
            txtLabelPangkat.setText(pangkat.getGolongan().getPangkat());
            txtLabelGolongan.setText(pangkat.getGolongan().getNamagolongan());
            txtMKGolongan.setText(String.valueOf(pangkat.getTahun_masa_kerja()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja()) + " Bulan");
            txtMKSebenarnya.setText(String.valueOf(pangkat.getTahun_masa_kerja_sebenarnya()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja_sebenarnya()) + " Bulan");
            PekerjaanJabatan jabatan = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nuk_utama_selected);
            txtLabelWilayahTugas.setText(jabatan.getCabang().getNamacabang());
            txtLabelUnitKerja.setText(jabatan.getUnit().getNamaUnit());
            txtLabelJabatan.setText(jabatan.getJabatan().getNamajabatan());
        }
    }//GEN-LAST:event_TabelPegawaiUtamaBidangKerjaMouseClicked

    private void TabelPegawaiUtamaGolonganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPegawaiUtamaGolonganMouseClicked
        // TODO add your handling code here:
        int row = TabelPegawaiUtamaGolongan.getSelectedRow();
        System.out.println(row);
        if (row >= 0) {
            String nuk_utama_selected = TabelPegawaiUtamaGolongan.getValueAt(row, 0).toString();
            txtNUKUtama.setText(nuk_utama_selected);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk_utama_selected);
            txtLabelJenisKelamin.setText(pegawai.getJK());
            txtLabelTempatLahir.setText(pegawai.getTLahir());
            txtLabelTglLahir.setText(pegawai.getTglLahir());
            txtAgamaLabel.setText(pegawai.getAgama());
            txtKawinLabel.setText(pegawai.getStatusPerkawinan());
            txtStatusPegawaiLabel.setText(pegawai.getStatusPegawai());
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(nuk_utama_selected);
            txtLabelPangkat.setText(pangkat.getGolongan().getPangkat());
            txtLabelGolongan.setText(pangkat.getGolongan().getNamagolongan());
            txtMKGolongan.setText(String.valueOf(pangkat.getTahun_masa_kerja()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja()) + " Bulan");
            txtMKSebenarnya.setText(String.valueOf(pangkat.getTahun_masa_kerja_sebenarnya()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja_sebenarnya()) + " Bulan");
            PekerjaanJabatan jabatan = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nuk_utama_selected);
            txtLabelWilayahTugas.setText(jabatan.getCabang().getNamacabang());
            txtLabelUnitKerja.setText(jabatan.getUnit().getNamaUnit());
            txtLabelJabatan.setText(jabatan.getJabatan().getNamajabatan());
        }
    }//GEN-LAST:event_TabelPegawaiUtamaGolonganMouseClicked

    private void TabelPegawaiUtamaUnitKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPegawaiUtamaUnitKerjaMouseClicked
        // TODO add your handling code here:
        int row = TabelPegawaiUtamaUnitKerja.getSelectedRow();
        System.out.println(row);
        if (row >= 0) {
            String nuk_utama_selected = TabelPegawaiUtamaUnitKerja.getValueAt(row, 0).toString();
            txtNUKUtama.setText(nuk_utama_selected);
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk_utama_selected);
            txtLabelJenisKelamin.setText(pegawai.getJK());
            txtLabelTempatLahir.setText(pegawai.getTLahir());
            txtLabelTglLahir.setText(pegawai.getTglLahir());
            txtAgamaLabel.setText(pegawai.getAgama());
            txtKawinLabel.setText(pegawai.getStatusPerkawinan());
            txtStatusPegawaiLabel.setText(pegawai.getStatusPegawai());
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(nuk_utama_selected);
            txtLabelPangkat.setText(pangkat.getGolongan().getPangkat());
            txtLabelGolongan.setText(pangkat.getGolongan().getNamagolongan());
            txtMKGolongan.setText(String.valueOf(pangkat.getTahun_masa_kerja()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja()) + " Bulan");
            txtMKSebenarnya.setText(String.valueOf(pangkat.getTahun_masa_kerja_sebenarnya()) + " Tahun " + String.valueOf(pangkat.getBulan_masa_kerja_sebenarnya()) + " Bulan");
            PekerjaanJabatan jabatan = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(nuk_utama_selected);
            txtLabelWilayahTugas.setText(jabatan.getCabang().getNamacabang());
            txtLabelUnitKerja.setText(jabatan.getUnit().getNamaUnit());
            txtLabelJabatan.setText(jabatan.getJabatan().getNamajabatan());
        }
    }//GEN-LAST:event_TabelPegawaiUtamaUnitKerjaMouseClicked

    private void txtNUKUtamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNUKUtamaKeyReleased
        // TODO add your handling code here:
        String text = txtNUKUtama.getText();
        if (text.length() == 0) {
            rowSorterNUK.setRowFilter(null);
        } else {
            System.out.println("y");
            rowSorterNUK.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtNUKUtamaKeyReleased

    private void txtNamaUtamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaUtamaKeyReleased
        // TODO add your handling code here:
        String text = txtNamaUtama.getText();
        if (text.length() == 0) {
            rowSorterNAMA.setRowFilter(null);
        } else {
            System.out.println("y");
            rowSorterNAMA.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtNamaUtamaKeyReleased

    private void txtWilayahUtamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWilayahUtamaKeyReleased
        // TODO add your handling code here:
        String text = txtWilayahUtama.getText();
        if (text.length() == 0) {
            rowSorterWILAYAH.setRowFilter(null);
        } else {
            System.out.println("y");
            rowSorterWILAYAH.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtWilayahUtamaKeyReleased

    private void txtBidangKerjaUtamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBidangKerjaUtamaKeyReleased
        // TODO add your handling code here:
        String text = txtBidangKerjaUtama.getText();
        if (text.length() == 0) {
            rowSorterBIDANG.setRowFilter(null);
        } else {
            System.out.println("y");
            rowSorterBIDANG.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtBidangKerjaUtamaKeyReleased

    private void txtGolonganUtamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGolonganUtamaKeyReleased
        // TODO add your handling code here:
        String text = txtGolonganUtama.getText();
        if (text.length() == 0) {
            rowSorterGOLONGAN.setRowFilter(null);
        } else {
            System.out.println("y");
            rowSorterGOLONGAN.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtGolonganUtamaKeyReleased

    private void TabelPegawaiUtamaUnitKerjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelPegawaiUtamaUnitKerjaKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_TabelPegawaiUtamaUnitKerjaKeyReleased

    private void txtUnitKerjaUtamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnitKerjaUtamaKeyReleased
        // TODO add your handling code here:
        String text = txtUnitKerjaUtama.getText();
        if (text.length() == 0) {
            rowSorterUNIT.setRowFilter(null);
        } else {
            System.out.println("y");
            rowSorterUNIT.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtUnitKerjaUtamaKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nuk_utama_filled = txtNUKUtama.getText();
        if (!nuk_utama_filled.equalsIgnoreCase("")) {
            Session.setNUK(nuk_utama_filled);
            Insertpegawai i = new Insertpegawai();
            i.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan isikan NUK terlebih dahulu");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Pegawaiform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pegawaiform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pegawaiform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pegawaiform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pegawaiform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPegawaiUtama;
    private javax.swing.JTable TabelPegawaiUtamaBidangKerja;
    private javax.swing.JTable TabelPegawaiUtamaGolongan;
    private javax.swing.JTable TabelPegawaiUtamaNama;
    private javax.swing.JTable TabelPegawaiUtamaUnitKerja;
    private javax.swing.JTable TabelPegawaiUtamaWilayah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel txtAgamaLabel;
    private javax.swing.JTextField txtBidangKerjaUtama;
    private javax.swing.JTextField txtGolonganUtama;
    private javax.swing.JLabel txtJenjangPendidikan;
    private javax.swing.JLabel txtKawinLabel;
    private javax.swing.JLabel txtLabelGolongan;
    private javax.swing.JTextField txtLabelJabatan;
    private javax.swing.JLabel txtLabelJenisKelamin;
    private javax.swing.JLabel txtLabelPangkat;
    private javax.swing.JLabel txtLabelTempatLahir;
    private javax.swing.JLabel txtLabelTglLahir;
    private javax.swing.JLabel txtLabelUnitKerja;
    private javax.swing.JLabel txtLabelWilayahTugas;
    private javax.swing.JLabel txtMKGolongan;
    private javax.swing.JLabel txtMKSebenarnya;
    private javax.swing.JTextField txtNUKUtama;
    private javax.swing.JTextField txtNamaUtama;
    private javax.swing.JLabel txtStatusPegawaiLabel;
    private javax.swing.JLabel txtTglLulusPendidikanAkhir;
    private javax.swing.JLabel txtTotalRow;
    private javax.swing.JTextField txtUnitKerjaUtama;
    private javax.swing.JTextField txtWilayahUtama;
    // End of variables declaration//GEN-END:variables
}
