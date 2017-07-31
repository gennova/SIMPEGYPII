/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.ui;

import code.init.pekerjaanjabatan.PekerjaanJabatan;
import com.init.bidangkerja.BidangKerja;
import com.init.cabang.Cabang;
import com.init.gaji.Gaji_pegawai;
import com.init.gaji.RiwayatGajiPegawai;
import com.init.golongan.Golongan;
import com.init.golonganpangkat.Pangkat;
import com.init.ijazah.IjazahAngkat;
import com.init.jabatan.Jabatan;
import com.init.pegawai.Pegawai;
import com.init.pendidikan_pegawai.PendidikanPegawai;
import com.init.pendidikanterakhir.PendidikanTerakhir;
import com.init.tools.DaoFactory;
import com.init.tools.Session;
import com.init.unit.Unit;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import simpeg.NewJFrame;

/**
 *
 * @author Tendy Developer
 */
public class Insertpegawai extends javax.swing.JFrame {

    private TableRowSorter rowSorter = null;

    /**
     * Creates new form Insertpegawai
     */
    public Insertpegawai() {
        initComponents();
        setLocationRelativeTo(null);
        initApp();
    }

    public void resetField() {
        NUK_teks.setText("");
        gelarTeks.setText("");
        tengahTeks.setText("");
        gelarbelakangTeks.setText("");
        aliasTeks.setText("");
        txtTempatLahir.setText("");
        txtAnakSeluruh.setText("0");
        txtAnakGaji.setText("0");
        fotoTeks.setText("");
        txtNomorSK.setText("");
        txtNomorKGB.setText("");
        txtTahunKerja.setText("0");
        txtBulanKerja.setText("");
        txtTahunKerjaBenar.setText("");
        txtBulanKerjaBenar.setText("");
        txtNomorSKJabatan.setText("");
        txtNamaJabatan.setText("");
        txtMasaJabatan.setText("0");
        txtGajiPokok.setText("0");
        txtTunjanganSuamiIstri.setText("0");
        txtTunjanganAnak.setText("0");
        txtTunjanganLain.setText("0");
        txtJumlahGaji.setText("0");
        txtTanggunganOrang.setText("");
        loadCombo();
        initUpdateApp();
    }

    private void initApp() {
        if (Session.getNUK() != null) {
            initUpdateApp();
        } else {
            loadCombo();
            tglLahirDate.setDate(GregorianCalendar.getInstance().getTime());
            tmtGolonganDate.setDate(GregorianCalendar.getInstance().getTime());
            nomorSKDate.setDate(GregorianCalendar.getInstance().getTime());
            tmtKGBDate.setDate(GregorianCalendar.getInstance().getTime());
            nomorKGBDate.setDate(GregorianCalendar.getInstance().getTime());
            tmtPekerjaan.setDate(GregorianCalendar.getInstance().getTime());
            tglSKJabatan.setDate(GregorianCalendar.getInstance().getTime());
            tglLulusSKPengangkatan.setDate(GregorianCalendar.getInstance().getTime());
            tglLulusSKPendidikanAkhir.setDate(GregorianCalendar.getInstance().getTime());
        }
    }

    private void initUpdateApp() {
        if (Session.getNUK() != "") {
            loadCombo();
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(Session.getNUK());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            NUK_teks.setText(pegawai.getNUK());
            gelarTeks.setText(pegawai.getGelarDepan());
            tengahTeks.setText(pegawai.getNama());
            gelarbelakangTeks.setText(pegawai.getGelarBelakang());
            aliasTeks.setText(pegawai.getAlias());
            String jenis_kelamin = pegawai.getJK();
            if (jenis_kelamin.equalsIgnoreCase("laki-laki")) {
                lakiRadio.setSelected(true);
            } else {
                ceweRadio.setSelected(true);
            }
            comboAgama.setSelectedItem(pegawai.getAgama());
            txtTempatLahir.setText(pegawai.getTLahir());
            try {
                tglLahirDate.setDate(sdf.parse(pegawai.getTglLahir())); //parse
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            comboKawin.setSelectedItem(pegawai.getStatusPerkawinan());
            txtAnakSeluruh.setText(String.valueOf(pegawai.getJumlahAnakSeluruh()));
            txtAnakGaji.setText(String.valueOf(pegawai.getJumlahAnakGaji()));
            ComboSttPeg.setSelectedItem(pegawai.getStatusPegawai());
            fotoTeks.setText(pegawai.getTeksFilename());
            //menampilkan fotonya bung
            ImageIcon imageIcon = new ImageIcon("image/" + pegawai.getTeksFilename());
            //System.out.println(pegawai.getTeksFilename());
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
            //displayPhotoTxt.setIcon(imageIcon);
            txtFotoDisplay.setIcon(new ImageIcon(newimg));
            //********************************************************************************//
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(Session.getNUK());
            comboGolonganPangkat.setSelectedItem(pangkat.getGolongan().getNamagolongan());
            try {
                tmtGolonganDate.setDate(sdf.parse(pangkat.getTMTGolongan())); //parse
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNomorSK.setText(pangkat.getNomor_sk()); //parse
            try {
                nomorSKDate.setDate(sdf.parse(pangkat.getTanggal_sk())); //parse
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tmtKGBDate.setDate(sdf.parse(pangkat.getTmt_kgb())); //parse
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNomorKGB.setText(pangkat.getNomor_kgb());
            try {
                nomorKGBDate.setDate(sdf.parse(pangkat.getTanggal_kgb())); //parse
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtTahunKerja.setText(String.valueOf(pangkat.getTahun_masa_kerja()));
            txtBulanKerja.setText(String.valueOf(pangkat.getBulan_masa_kerja()));
            txtTahunKerjaBenar.setText(String.valueOf(pangkat.getTahun_masa_kerja_sebenarnya()));
            txtBulanKerjaBenar.setText(String.valueOf(pangkat.getBulan_masa_kerja_sebenarnya()));
            //*************************************************************************************//
            PekerjaanJabatan pj = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(Session.getNUK());
            comboBidangKerja.setSelectedItem(pj.getBk().getNamabidangkerja());
            try {
                tmtPekerjaan.setDate(sdf.parse(pj.getTglTMTPekerjaan())); //parse
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNomorSKJabatan.setText(pj.getNomorSKPekerjaan());
            try {
                tglSKJabatan.setDate(sdf.parse(pj.getTglSKPekerjaan())); //parse
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            comboWIlayahTugas.setSelectedItem(pj.getCabang().getNamacabang());
            comboUnitKerja.setSelectedItem(pj.getUnit().getNamaUnit());
            comboNamaJabatan.setSelectedItem(pj.getBk().getNamabidangkerja());
            txtNamaJabatan.setText(pj.getNamaJabatan());
            txtMasaJabatan.setText(String.valueOf(pj.getMasaJabatan()));
            //************************************************************************************//
            PendidikanPegawai pendidikanPegawai = DaoFactory.getPendidikanPegawaiDao().getPendidikanPegawaiByNUK(Session.getNUK());
            comboIjazahPengangkatan.setSelectedItem(pendidikanPegawai.getIjazahAngkat().getNamaIjazahPengangkatan());
            try {
                tglLulusSKPengangkatan.setDate(sdf.parse(pendidikanPegawai.getTglLulusSKPengangkatan())); //parser
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            comboPendidikanAkhir.setSelectedItem(pendidikanPegawai.getPendidikanTerakhir().getNamapendidikanterakhir());
            try {
                tglLulusSKPendidikanAkhir.setDate(sdf.parse(pendidikanPegawai.getTglLulusSKPendidikanAkhir()));
            } catch (ParseException ex) {
                Logger.getLogger(Insertpegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
            //**********************************************************************************//
            Gaji_pegawai gjp = DaoFactory.getGaji_pegawai_dao().getGajiPegawaiByNUK(Session.getNUK());
            txtGajiPokok.setText(String.valueOf(gjp.getGaji_pokok()));
            txtTunjanganSuamiIstri.setText(String.valueOf(gjp.getTunjangan_suami_istri()));
            txtTunjanganAnak.setText(String.valueOf(gjp.getTunjangan_anak()));
            txtTunjanganLain.setText(String.valueOf(gjp.getTunjangan_lain()));
            txtJumlahGaji.setText(String.valueOf(gjp.getTotal_gaji()));
            txtTanggunganOrang.setText(String.valueOf(gjp.getTanggungan_orang()));
            txtKGBBerikutnya.setText(String.valueOf(gjp.getKgb_berikutnya()));

        }
    }

    private void loadCombo() {
        List<Golongan> golongans = DaoFactory.getGolonganDao().getAllGolongans();
        comboGolonganPangkat.removeAllItems();
        for (int i = 0; i < golongans.size(); i++) {
            comboGolonganPangkat.addItem(golongans.get(i).getNamagolongan());
        }

        List<BidangKerja> bids = DaoFactory.getBidangKerjaDao().getAllBidangKerja();
        comboBidangKerja.removeAllItems();
        for (int i = 0; i < bids.size(); i++) {
            comboBidangKerja.addItem(bids.get(i).getNamabidangkerja());
        }

        List<Cabang> cabangs = DaoFactory.getCabangDao().getAllCabang();
        comboWIlayahTugas.removeAllItems();
        for (int i = 0; i < cabangs.size(); i++) {
            comboWIlayahTugas.addItem(cabangs.get(i).getNamacabang());
        }

        List<Unit> units = DaoFactory.getUnitDao().getAllUnit();
        comboUnitKerja.removeAllItems();
        for (int i = 0; i < units.size(); i++) {
            comboUnitKerja.addItem(units.get(i).getNamaUnit());
        }

        List<Jabatan> jabatans = DaoFactory.getJabatanDao().getAllJabatan();
        comboNamaJabatan.removeAllItems();
        for (int i = 0; i < jabatans.size(); i++) {
            comboNamaJabatan.addItem(jabatans.get(i).getNamajabatan());
        }

        List<IjazahAngkat> angkats = DaoFactory.getIjazahAngkatDao().getAllIjazahPengangkatan();
        comboIjazahPengangkatan.removeAllItems();
        for (int i = 0; i < angkats.size(); i++) {
            comboIjazahPengangkatan.addItem(angkats.get(i).getNamaIjazahPengangkatan());
        }

        List<PendidikanTerakhir> terakhirs = DaoFactory.getPendidikanTerakhirDao().getAllPendidikan();
        comboPendidikanAkhir.removeAllItems();
        for (int i = 0; i < terakhirs.size(); i++) {
            comboPendidikanAkhir.addItem(terakhirs.get(i).getNamapendidikanterakhir());
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

        kelaminGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        NUK_teks = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gelarTeks = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        aliasTeks = new javax.swing.JTextField();
        lakiRadio = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        ceweRadio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        comboAgama = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboKawin = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        ComboSttPeg = new javax.swing.JComboBox();
        jButton9 = new javax.swing.JButton();
        tglLahirDate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        fotoTeks = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        tengahTeks = new javax.swing.JTextField();
        gelarbelakangTeks = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtAnakSeluruh = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtAnakGaji = new javax.swing.JTextField();
        txtTempatLahir = new javax.swing.JTextField();
        txtFotoDisplay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tmtGolonganDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txtNomorSK = new javax.swing.JTextField();
        nomorSKDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        tmtKGBDate = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txtNomorKGB = new javax.swing.JTextField();
        nomorKGBDate = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        txtTahunKerja = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtBulanKerja = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTahunKerjaBenar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtBulanKerjaBenar = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comboGolonganPangkat = new javax.swing.JComboBox<>();
        txtPangkat = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tmtPekerjaan = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        txtNomorSKJabatan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        tglSKJabatan = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtMasaJabatan = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtNamaJabatan = new javax.swing.JTextField();
        comboBidangKerja = new javax.swing.JComboBox<>();
        comboWIlayahTugas = new javax.swing.JComboBox<>();
        comboUnitKerja = new javax.swing.JComboBox<>();
        comboNamaJabatan = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tglLulusSKPengangkatan = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        tglLulusSKPendidikanAkhir = new com.toedter.calendar.JDateChooser();
        comboIjazahPengangkatan = new javax.swing.JComboBox<>();
        comboPendidikanAkhir = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtGajiPokok = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtTunjanganSuamiIstri = new javax.swing.JTextField();
        txtTunjanganAnak = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtTunjanganLain = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtJumlahGaji = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtTanggunganOrang = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtKGBBerikutnya = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel53 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ButtonSave = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 255));
        setForeground(new java.awt.Color(255, 51, 204));
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(102, 255, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        NUK_teks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUK_teksActionPerformed(evt);
            }
        });

        jLabel1.setText("NUK");

        jLabel2.setText("Nama");

        jLabel3.setText("Alias");

        kelaminGroup.add(lakiRadio);
        lakiRadio.setText("Laki-laki");
        lakiRadio.setOpaque(false);

        jLabel4.setText("JK");

        kelaminGroup.add(ceweRadio);
        ceweRadio.setText("Perempuan");
        ceweRadio.setOpaque(false);

        jLabel5.setText("Agama");

        comboAgama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Katholik", "Protestasn", "Islam", "Hindu", "Budha", "Konghucu", "Lainnya" }));

        jLabel6.setText("T.Lahir");

        jLabel7.setText("Tgl.Lahir");

        jLabel8.setText("Status");

        comboKawin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KAWIN", "BELUM KAWIN", "JANDA", "DUDA" }));

        jLabel9.setText("Stt. Peg");

        ComboSttPeg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DPK", "TETAP", "KONTRAK", "TUGAS BELAJAR", "CUTI LT YAYASAN", "PINDAH", "PENSIUN", "BERHENTI", "MENINGGAL" }));

        jButton9.setText("SK. Pegawai");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel10.setText("FOTO");

        jButton8.setText("Cari");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel48.setText("Anak Seluruh");

        txtAnakSeluruh.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAnakSeluruh.setText("0");
        txtAnakSeluruh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnakSeluruhActionPerformed(evt);
            }
        });

        jLabel49.setText("Anak Gaji");

        txtAnakGaji.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAnakGaji.setText("0");

        txtFotoDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFotoDisplay.setText("Photo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboKawin, 0, 160, Short.MAX_VALUE)
                                    .addComponent(ComboSttPeg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAnakSeluruh)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel49))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(51, 51, 51)
                                .addComponent(fotoTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAnakGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NUK_teks, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aliasTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lakiRadio)
                                .addGap(18, 18, 18)
                                .addComponent(ceweRadio))
                            .addComponent(comboAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(gelarTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tengahTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gelarbelakangTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTempatLahir, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tglLahirDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                        .addGap(4, 4, 4)
                        .addComponent(txtFotoDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ComboSttPeg, comboAgama, comboKawin, tglLahirDate});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NUK_teks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(gelarTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tengahTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gelarbelakangTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(aliasTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lakiRadio)
                            .addComponent(jLabel4)
                            .addComponent(ceweRadio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtFotoDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tglLahirDate, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboKawin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48)
                                .addComponent(txtAnakSeluruh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel49))
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ComboSttPeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fotoTeks)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtAnakGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64))
                        .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {NUK_teks, aliasTeks, fotoTeks, gelarTeks, gelarbelakangTeks, jButton8, jLabel48, jLabel49, tengahTeks, txtAnakGaji, txtAnakSeluruh});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboKawin, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboAgama, txtTempatLahir});

        jTabbedPane1.addTab("A. Umum", jPanel1);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel11.setText("Golongan / Pangkat");

        jLabel12.setText("TMT Golongan");

        jLabel13.setText("Nomor SK");

        jLabel14.setText("TMT KGB");

        jLabel15.setText("Nomor KGB");

        jLabel16.setText("Masa Kerja Golongan");

        txtTahunKerja.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTahunKerja.setText("0");

        jLabel17.setText("Tahun");

        txtBulanKerja.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBulanKerja.setText("0");

        jLabel18.setText("Bulan");

        jLabel19.setText("Masa Kerja Sebenarnya");

        txtTahunKerjaBenar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTahunKerjaBenar.setText("0");
        txtTahunKerjaBenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTahunKerjaBenarActionPerformed(evt);
            }
        });

        jLabel20.setText("Tahun");

        txtBulanKerjaBenar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBulanKerjaBenar.setText("0");

        jLabel21.setText("Bulan");

        comboGolonganPangkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboGolonganPangkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGolonganPangkatActionPerformed(evt);
            }
        });

        txtPangkat.setText("Pangkat");

        jButton7.setText("Kenaikan Pangkat");
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        jLabel36.setText("Tombol ini hanya digunakan untuk perubahan / kenaikan pangkat");

        jLabel39.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        jLabel39.setText("Untuk perubahan data biasa silahkan gunakan tombol save disamping kiri");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tmtKGBDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboGolonganPangkat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tmtGolonganDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNomorSK)
                            .addComponent(txtNomorKGB, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(nomorSKDate, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(nomorKGBDate, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel36)
                            .addComponent(jButton7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTahunKerja, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                    .addComponent(txtTahunKerjaBenar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBulanKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBulanKerjaBenar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboGolonganPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPangkat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tmtGolonganDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomorSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(nomorSKDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6))
                    .addComponent(tmtKGBDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomorKGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(nomorKGBDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTahunKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtBulanKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTahunKerjaBenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtBulanKerjaBenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboGolonganPangkat, jLabel17, jLabel18, jLabel20, jLabel21, nomorKGBDate, nomorSKDate, tmtGolonganDate, tmtKGBDate, txtBulanKerja, txtBulanKerjaBenar, txtNomorKGB, txtNomorSK, txtTahunKerja, txtTahunKerjaBenar});

        jTabbedPane1.addTab("B. Gol/Pangkat", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 102, 255));

        jLabel22.setText("Bidang Pekerjaan");

        jLabel24.setText("TMT Pekerjaan");

        jLabel25.setText("Nomor SK");

        jLabel26.setText("Tgl");

        jLabel27.setText("Wilayah Tugas");

        jLabel28.setText("Unit Kerja");

        jLabel29.setText("Jabatan");

        jButton15.setText("SK Jabatan");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel30.setText("Masa Jabatan");

        jLabel31.setText("Nama Jabatan");

        jLabel32.setText("Nama Wilayah");

        jLabel33.setText("Nama Unit Kerja");

        txtMasaJabatan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMasaJabatan.setText("0");

        jLabel34.setText("Tahun");

        comboBidangKerja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboWIlayahTugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboUnitKerja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboNamaJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel50.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        jLabel50.setText("Untuk perubahan data biasa silahkan gunakan tombol save disamping kiri");

        jButton10.setText("Pergantian Jabatan");
        jButton10.setOpaque(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        jLabel51.setText("Tombol ini hanya digunakan untuk perubahan / pergantian jabatan pegawai");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jButton10)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMasaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel34))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNomorSKJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tglSKJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tmtPekerjaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addComponent(comboBidangKerja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboNamaJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboUnitKerja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboWIlayahTugas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton15)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(324, 324, 324))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboNamaJabatan, comboUnitKerja, comboWIlayahTugas, txtNamaJabatan});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBidangKerja, tmtPekerjaan, txtNomorSKJabatan});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tglSKJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(comboBidangKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(tmtPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(txtNomorSKJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(comboWIlayahTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(comboUnitKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(comboNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtMasaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboBidangKerja, comboNamaJabatan, comboUnitKerja, comboWIlayahTugas, jButton15, jLabel22, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30, jLabel31, jLabel32, jLabel33, tglSKJabatan, tmtPekerjaan, txtMasaJabatan, txtNamaJabatan, txtNomorSKJabatan});

        jTabbedPane1.addTab("C.Pekerjaan/Jabatan", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 102, 51));

        jLabel35.setText("Ijazah pada SK Pengangkatan");

        jLabel37.setText("Tgl. Lulus");

        jLabel38.setText("Pendidikan Terakhir");

        jLabel40.setText("Tgl. Lulus");

        comboIjazahPengangkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboPendidikanAkhir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel38)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboIjazahPengangkatan, 0, 271, Short.MAX_VALUE)
                            .addComponent(comboPendidikanAkhir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(18, 18, 18)
                                .addComponent(tglLulusSKPengangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(tglLulusSKPendidikanAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tglLulusSKPendidikanAkhir, tglLulusSKPengangkatan});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(comboIjazahPengangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tglLulusSKPengangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(comboPendidikanAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tglLulusSKPendidikanAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel37, jLabel40, tglLulusSKPendidikanAkhir, tglLulusSKPengangkatan});

        jTabbedPane1.addTab("D.Pendidikan", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 102, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Rincian Gaji");

        jLabel41.setText("Gaji Pokok");

        txtGajiPokok.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGajiPokok.setText("0");
        txtGajiPokok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGajiPokokFocusLost(evt);
            }
        });
        txtGajiPokok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGajiPokokKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGajiPokokKeyReleased(evt);
            }
        });

        jLabel42.setText("Tunjangan Suami / Istri");

        jLabel43.setText("Tunjangan Anak");

        txtTunjanganSuamiIstri.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganSuamiIstri.setText("0");
        txtTunjanganSuamiIstri.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTunjanganSuamiIstriFocusLost(evt);
            }
        });

        txtTunjanganAnak.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganAnak.setText("0");
        txtTunjanganAnak.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTunjanganAnakFocusLost(evt);
            }
        });

        jLabel44.setText("Tunjangan Lain-lain");

        txtTunjanganLain.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganLain.setText("0");
        txtTunjanganLain.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTunjanganLainFocusLost(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Jumlah");

        txtJumlahGaji.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtJumlahGaji.setText("0");
        txtJumlahGaji.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJumlahGajiFocusGained(evt);
            }
        });
        txtJumlahGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahGajiActionPerformed(evt);
            }
        });

        jLabel46.setText("Tanggungan ");

        txtTanggunganOrang.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTanggunganOrang.setText("0");

        jLabel47.setText("Orang");

        jLabel52.setText("KGB Berikutnya");

        txtKGBBerikutnya.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtKGBBerikutnya.setText("2");

        jLabel53.setText("Tahun yang akan datang");

        jButton11.setText("Pindahkan gaji ke riwayat");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel23))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel45)
                                .addComponent(jLabel44))
                            .addComponent(jLabel46))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTunjanganSuamiIstri)
                            .addComponent(txtTunjanganAnak)
                            .addComponent(txtTunjanganLain)
                            .addComponent(txtGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtJumlahGaji, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTanggunganOrang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel47))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel52)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtKGBBerikutnya, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53))
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77))
            .addComponent(jSeparator1)
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton11, txtGajiPokok, txtTanggunganOrang, txtTunjanganAnak, txtTunjanganLain, txtTunjanganSuamiIstri});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtTunjanganSuamiIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtTunjanganAnak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtTunjanganLain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlahGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtTanggunganOrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtKGBBerikutnya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton11, txtGajiPokok, txtJumlahGaji, txtKGBBerikutnya, txtTanggunganOrang, txtTunjanganAnak, txtTunjanganLain, txtTunjanganSuamiIstri});

        jTabbedPane1.addTab("E.Gaji", jPanel5);

        jButton1.setText("F. Alamat Rumah");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("G. Kartu Identitas");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("H. Ket Badan");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("I. Data Keluarga");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("J. Nama Foto");
        jButton5.setEnabled(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ButtonSave.setText("SAVE");
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        ButtonCancel.setText("CANCEL");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        jButton6.setText("CLEAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ButtonCancel, ButtonSave, jButton1, jButton2, jButton3, jButton4, jButton5, jButton6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(ButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonSave, jButton6});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String nuks = NUK_teks.getText();
        String nuk = NUK_teks.getText();
        if (nuk.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Data NUK Kosong, siliahkan dipilih/isi");
        } else {
            Pegawai pegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuks);
            if (pegawai != null) {
                Session.setNUK(nuk);
                String data = (String) ComboSttPeg.getItemAt(ComboSttPeg.getSelectedIndex());
                InsertSK insertSK = new InsertSK(data);
                insertSK.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Silahkan klik simpan terlebih dahulu");
            }
        }


    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String nuk = NUK_teks.getText();
        if (nuk.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Data NUK Kosong, siliahkan dipilih/isi");
        } else {
            Pegawai cekpegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(NUK_teks.getText());
            Session.setPegawai(cekpegawai);
            InsertAlamatRumah iar = new InsertAlamatRumah();
            iar.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nuk = NUK_teks.getText();
        if (nuk.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Data NUK Kosong, siliahkan dipilih/isi");
        } else {
            Pegawai cekpegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(NUK_teks.getText());
            Session.setPegawai(cekpegawai);
            CardIdentity ci = new CardIdentity();
            ci.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nuk = NUK_teks.getText();
        if (nuk.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Data NUK Kosong, siliahkan dipilih/isi");
        } else {
            Pegawai cekpegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(NUK_teks.getText());
            Session.setPegawai(cekpegawai);
            JOptionPane.showMessageDialog(null, "Data Pegawai :" + cekpegawai.getNama());
            Badan b = new Badan();
            b.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String nuk = NUK_teks.getText();
        if (nuk.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Data NUK Kosong, siliahkan dipilih/isi");
        } else {
            Pegawai cekpegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(NUK_teks.getText());
            Session.setPegawai(cekpegawai);
            DataKeluarga dk = new DataKeluarga();
            dk.setVisible(true);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        // TODO add your handling code here:
        //ini start data umum /tab umum//
        String nukya = NUK_teks.getText();
        if (nukya.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Data NUK Kosong, siliahkan dipilih/isi");
        } else {
            Pegawai cekpegawai = DaoFactory.getPegawaiDao().getPegawaiByNUK(NUK_teks.getText());
            //System.out.println("cek pegawai " + cekpegawai.getNUK());
            if (cekpegawai == null) { // START INSERT DATA
                Pegawai p = new Pegawai();
                p.setNUK(NUK_teks.getText()); //1
                String gelar, nama, gelarbelakang;
                gelar = gelarTeks.getText();
                nama = tengahTeks.getText();
                String jumlahanakseluruh, jumlahanakgaji;
                jumlahanakseluruh = txtAnakSeluruh.getText();
                jumlahanakgaji = txtAnakGaji.getText();
                String tempatlahir = txtTempatLahir.getText();
                gelarbelakang = gelarbelakangTeks.getText();
                p.setGelarDepan(gelar);//2
                p.setNama(nama);//3
                p.setGelarBelakang(gelarbelakang); //4
                p.setAlias(aliasTeks.getText()); //5
                if (lakiRadio.isSelected()) {
                    p.setJK("Laki-laki"); //6
                } else if (ceweRadio.isSelected()) {
                    p.setJK("Perempuan"); //6
                } else {
                    p.setJK("Laki-laki"); //6
                }
                p.setAgama(comboAgama.getSelectedItem().toString()); //7
                p.setTLahir(tempatlahir);//8
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String tanggal = df.format(tglLahirDate.getDate());
                String tanggal_lahir_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
                p.setTglLahir(tanggal); //9
                p.setStatusPerkawinan(comboKawin.getSelectedItem().toString()); //10
                p.setJumlahAnakSeluruh(Integer.parseInt(jumlahanakseluruh)); //11
                p.setJumlahAnakGaji(Integer.parseInt(jumlahanakgaji)); //12
                p.setStatusPegawai(ComboSttPeg.getSelectedItem().toString()); //13
                p.setTeksFilename(fotoTeks.getText()); // 14
                p.setTanggalLahirIndo(tanggal_lahir_indo); //15
                System.out.println("Cek Data hasilnya apa : " + p.getStatusPegawai());
                //ini end dari data umum /tab umum//
                //*********************************************************************//
                //ini start data pangkat golonga /tab pangkat golongan//
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Golongan golongan = DaoFactory.getGolonganDao().getGolonganByNamaGolongan(comboGolonganPangkat.getSelectedItem().toString());
                String Tmt_golongan = sdf.format(tmtGolonganDate.getDate());
                String Nomor_sk = txtNomorSK.getText();
                String Tgl_nomor_sk = sdf.format(nomorSKDate.getDate());
                String Tgl_tmt_kgb = sdf.format(tmtKGBDate.getDate());
                String Nomor_kgb = txtNomorKGB.getText();
                String Tgl_nomor_kgb = sdf.format(nomorKGBDate.getDate());
                String Tmt_golongan_indo = DaoFactory.FormatTanggalIndonesia(Tmt_golongan);
                String Tgl_nomor_sk_indo = DaoFactory.FormatTanggalIndonesia(Tgl_nomor_sk);
                String Tgl_tmt_kgb_indo = DaoFactory.FormatTanggalIndonesia(Tgl_tmt_kgb);
                String Tgl_nomor_kgb_indo = DaoFactory.FormatTanggalIndonesia(Tgl_nomor_kgb);
                int Tahun_kerja = Integer.parseInt(txtTahunKerja.getText());
                int Bulan_kerja = Integer.parseInt(txtBulanKerja.getText());
                int Tahun_kerja_benar = Integer.parseInt(txtTahunKerjaBenar.getText());
                int Bulan_kerja_benar = Integer.parseInt(txtTahunKerjaBenar.getText());
                Pangkat pangkat = new Pangkat();
                pangkat.setPegawai(p);
                pangkat.setGolongan(golongan);
                pangkat.setTMTGolongan(Tmt_golongan);// tanggal tmt golongan
                pangkat.setNomor_sk(Nomor_sk);
                pangkat.setTanggal_sk(Tgl_nomor_sk);
                pangkat.setTmt_kgb(Tgl_tmt_kgb);
                pangkat.setNomor_kgb(Nomor_kgb);
                pangkat.setTanggal_kgb(Tgl_nomor_kgb);
                pangkat.setTahun_masa_kerja(Tahun_kerja);
                pangkat.setBulan_masa_kerja(Bulan_kerja);
                pangkat.setTahun_masa_kerja_sebenarnya(Tahun_kerja_benar);
                pangkat.setBulan_masa_kerja_sebenarnya(Bulan_kerja_benar);
                pangkat.setTMTGolongan_indo(Tmt_golongan_indo); // Tgl TMT Golongan Format INDO
                pangkat.setTanggal_sk_indo(Tgl_nomor_sk_indo); //Tgl SK Format Indo
                pangkat.setTmt_kgb_indo(Tgl_tmt_kgb_indo); // TMT KGB Format Indo
                pangkat.setTanggal_kgb_indo(Tgl_nomor_kgb_indo); //Nomor KGB Format Indor
                Calendar calendar = GregorianCalendar.getInstance();
                calendar.setTime(nomorSKDate.getDate());
                calendar.add(Calendar.YEAR, 2);
                pangkat.setNaik_pangkat_yad(sdf.format(calendar.getTime()));
                pangkat.setNaik_pangkat_yad_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(calendar.getTime())));
                //ini end dari pangkat golongan /tab pangkat golongan//
                //*********************************************************************//
                //ini start data Pekerjaan Jabatan /tab Pekerjaan Jabatan//
                PekerjaanJabatan pkj = new PekerjaanJabatan();
                pkj.setPegawai(p);
                pkj.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByNamaBidangKerja(comboBidangKerja.getSelectedItem().toString()));
                pkj.setTglTMTPekerjaan(sdf.format(tmtPekerjaan.getDate()));
                pkj.setTglTMTPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tmtPekerjaan.getDate()))); // Format Indo
                pkj.setNomorSKPekerjaan(txtNomorSKJabatan.getText());
                pkj.setTglSKPekerjaan(sdf.format(tglSKJabatan.getDate()));
                pkj.setTglSKPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglSKJabatan.getDate()))); // Format indo
                pkj.setCabang(DaoFactory.getCabangDao().getCabangByNamaCabang(comboWIlayahTugas.getSelectedItem().toString()));
                pkj.setUnit(DaoFactory.getUnitDao().getUnitByNama(comboUnitKerja.getSelectedItem().toString()));
                pkj.setJabatan(DaoFactory.getJabatanDao().getJabatanByNama(comboNamaJabatan.getSelectedItem().toString()));
                pkj.setNamaJabatan(txtNamaJabatan.getText());
                pkj.setMasaJabatan(Integer.parseInt(txtMasaJabatan.getText()));
                //ini end dari Pekerjaan Jabatan /tab Pekerjaan Jabatan//
                //*********************************************************************//
                //ini start data Pendidikan pegawai//
                PendidikanPegawai pendidikanPegawai = new PendidikanPegawai();
                pendidikanPegawai.setPegawai(p);
                pendidikanPegawai.setIjazahAngkat(DaoFactory.getIjazahAngkatDao().getIjazahAngkatByNama(comboIjazahPengangkatan.getSelectedItem().toString()));
                pendidikanPegawai.setTglLulusSKPengangkatan(sdf.format(tglLulusSKPengangkatan.getDate()));
                pendidikanPegawai.setTglLulusSKPengangkatan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglLulusSKPengangkatan.getDate()))); // format indo
                pendidikanPegawai.setPendidikanTerakhir(DaoFactory.getPendidikanTerakhirDao().getPendidikanByNama(comboPendidikanAkhir.getSelectedItem().toString()));
                pendidikanPegawai.setTglLulusSKPendidikanAkhir(sdf.format(tglLulusSKPendidikanAkhir.getDate()));
                pendidikanPegawai.setTglLulusSKPendidikanAkhir_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglLulusSKPendidikanAkhir.getDate()))); // format indo
                //ini end dari Pendidikan Pegawa//
                //*********************************************************************//
                //ini start data Gaji Pegawai//
                Gaji_pegawai gaji_pegawai = new Gaji_pegawai();
                gaji_pegawai.setPegawai(p);
                gaji_pegawai.setGaji_pokok(Double.parseDouble(txtGajiPokok.getText()));
                gaji_pegawai.setTunjangan_suami_istri(Double.parseDouble(txtTunjanganSuamiIstri.getText()));
                gaji_pegawai.setTunjangan_anak(Double.parseDouble(txtTunjanganAnak.getText()));
                gaji_pegawai.setTunjangan_lain(Double.parseDouble(txtTunjanganLain.getText()));
                gaji_pegawai.setTotal_gaji(Double.parseDouble(txtJumlahGaji.getText()));
                gaji_pegawai.setTanggungan_orang(Integer.parseInt(txtTanggunganOrang.getText()));
                gaji_pegawai.setKgb_berikutnya(Integer.parseInt(txtKGBBerikutnya.getText()));
                Calendar c = GregorianCalendar.getInstance();
                c.setTime(tmtKGBDate.getDate());
                c.add(Calendar.YEAR, Integer.parseInt(txtKGBBerikutnya.getText()));
                gaji_pegawai.setKbg_yad_date(sdf.format(c.getTime()));
                gaji_pegawai.setKgb_yad_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(c.getTime())));
                //ini end dari Gaji Pegawai//
                //*********************************************************************//

                DaoFactory.getPegawaiDao().InsertPegawai(p);
                DaoFactory.getPangkatDao().InsertPangkatPegawai(pangkat);
                DaoFactory.getPekerjaanJabatanDao().InsertPekerjaanJabatan(pkj);
                DaoFactory.getPendidikanPegawaiDao().InsertPendidikanPegawai(pendidikanPegawai);
                DaoFactory.getGaji_pegawai_dao().InsertGajiPegawai(gaji_pegawai);
                Session.setPegawai(p);
            } else { // START UPDATE DATA
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
                Pegawai p = new Pegawai();
                p.setNUK(NUK_teks.getText()); //1
                String gelar, nama, gelarbelakang;
                gelar = gelarTeks.getText();
                nama = tengahTeks.getText();
                String jumlahanakseluruh, jumlahanakgaji;
                jumlahanakseluruh = txtAnakSeluruh.getText();
                jumlahanakgaji = txtAnakGaji.getText();
                String tempatlahir = txtTempatLahir.getText();
                gelarbelakang = gelarbelakangTeks.getText();
                p.setGelarDepan(gelar);//2
                p.setNama(nama);//3
                p.setGelarBelakang(gelarbelakang); //4
                p.setAlias(aliasTeks.getText()); //5
                if (lakiRadio.isSelected()) {
                    p.setJK("Laki-laki"); //6
                } else if (ceweRadio.isSelected()) {
                    p.setJK("Perempuan"); //6
                } else {
                    p.setJK("Laki-laki"); //6
                }
                p.setAgama(comboAgama.getSelectedItem().toString()); //7
                p.setTLahir(tempatlahir);//8
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String tanggal = df.format(tglLahirDate.getDate());
                String tanggal_indo = DaoFactory.FormatTanggalIndonesia(tanggal);
                p.setTglLahir(tanggal); //9
                p.setStatusPerkawinan(comboKawin.getSelectedItem().toString()); //10
                p.setJumlahAnakSeluruh(Integer.parseInt(jumlahanakseluruh)); //11
                p.setJumlahAnakGaji(Integer.parseInt(jumlahanakgaji)); //12
                p.setStatusPegawai(ComboSttPeg.getSelectedItem().toString()); //13
                p.setTeksFilename(fotoTeks.getText()); // 14
                p.setTanggalLahirIndo(tanggal_indo); // 15
                System.out.println("Cek Data hasilnya apa : " + p.getStatusPegawai());
                //ini end dari data umum /tab umum//
                //*********************************************************************//
                //ini start data pangkat golonga /tab pangkat golongan//
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Golongan golongan = DaoFactory.getGolonganDao().getGolonganByNamaGolongan(comboGolonganPangkat.getSelectedItem().toString());
                String Tmt_golongan = sdf.format(tmtGolonganDate.getDate());
                String Nomor_sk = txtNomorSK.getText();
                String Tgl_nomor_sk = sdf.format(nomorSKDate.getDate());
                String Tgl_tmt_kgb = sdf.format(tmtKGBDate.getDate());
                String Nomor_kgb = txtNomorKGB.getText();
                String Tgl_nomor_kgb = sdf.format(nomorKGBDate.getDate());
                int Tahun_kerja = Integer.parseInt(txtTahunKerja.getText());
                int Bulan_kerja = Integer.parseInt(txtBulanKerja.getText());
                int Tahun_kerja_benar = Integer.parseInt(txtTahunKerjaBenar.getText());
                int Bulan_kerja_benar = Integer.parseInt(txtTahunKerjaBenar.getText());
                String Tmt_golongan_indo = DaoFactory.FormatTanggalIndonesia(Tmt_golongan);
                String Tgl_nomor_sk_indo = DaoFactory.FormatTanggalIndonesia(Tgl_nomor_sk);
                String Tgl_tmt_kgb_indo = DaoFactory.FormatTanggalIndonesia(Tgl_tmt_kgb);
                String Tgl_nomor_kgb_indo = DaoFactory.FormatTanggalIndonesia(Tgl_nomor_kgb);
                Pangkat pangkat = new Pangkat();
                pangkat.setPegawai(p);
                pangkat.setGolongan(golongan);
                pangkat.setTMTGolongan(Tmt_golongan);// tanggal tmt golongan
                pangkat.setNomor_sk(Nomor_sk);
                pangkat.setTanggal_sk(Tgl_nomor_sk);
                pangkat.setTmt_kgb(Tgl_tmt_kgb);
                pangkat.setNomor_kgb(Nomor_kgb);
                pangkat.setTanggal_kgb(Tgl_nomor_kgb);
                pangkat.setTahun_masa_kerja(Tahun_kerja);
                pangkat.setBulan_masa_kerja(Bulan_kerja);
                pangkat.setTahun_masa_kerja_sebenarnya(Tahun_kerja_benar);
                pangkat.setBulan_masa_kerja_sebenarnya(Bulan_kerja_benar);
                pangkat.setTMTGolongan_indo(Tmt_golongan_indo); // Tgl TMT Golongan Format INDO
                pangkat.setTanggal_sk_indo(Tgl_nomor_sk_indo); //Tgl SK Format Indo
                pangkat.setTmt_kgb_indo(Tgl_tmt_kgb_indo); // TMT KGB Format Indo
                pangkat.setTanggal_kgb_indo(Tgl_nomor_kgb_indo); //Nomor KGB Format Indor
                Calendar calendar = GregorianCalendar.getInstance();
                calendar.setTime(nomorSKDate.getDate());
                calendar.add(Calendar.YEAR, 2);
                pangkat.setNaik_pangkat_yad(sdf.format(calendar.getTime()));
                pangkat.setNaik_pangkat_yad_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(calendar.getTime())));
                //ini end dari pangkat golongan /tab pangkat golongan//
                //*********************************************************************//
                //ini start data Pekerjaan Jabatan /tab Pekerjaan Jabatan//
                PekerjaanJabatan pkj = new PekerjaanJabatan();
                pkj.setPegawai(p);
                pkj.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByNamaBidangKerja(comboBidangKerja.getSelectedItem().toString()));
                pkj.setTglTMTPekerjaan(sdf.format(tmtPekerjaan.getDate()));
                pkj.setTglTMTPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tmtPekerjaan.getDate()))); // Format Indo
                pkj.setNomorSKPekerjaan(txtNomorSKJabatan.getText());
                pkj.setTglSKPekerjaan(sdf.format(tglSKJabatan.getDate()));
                pkj.setTglSKPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglSKJabatan.getDate()))); // Format indo
                pkj.setCabang(DaoFactory.getCabangDao().getCabangByNamaCabang(comboWIlayahTugas.getSelectedItem().toString()));
                pkj.setUnit(DaoFactory.getUnitDao().getUnitByNama(comboUnitKerja.getSelectedItem().toString()));
                pkj.setJabatan(DaoFactory.getJabatanDao().getJabatanByNama(comboNamaJabatan.getSelectedItem().toString()));
                pkj.setNamaJabatan(txtNamaJabatan.getText());
                pkj.setMasaJabatan(Integer.parseInt(txtMasaJabatan.getText()));
                //ini end dari Pekerjaan Jabatan /tab Pekerjaan Jabatan//
                //*********************************************************************//
                //ini start data Pendidikan pegawai//
                PendidikanPegawai pendidikanPegawai = new PendidikanPegawai();
                pendidikanPegawai.setPegawai(p);
                pendidikanPegawai.setIjazahAngkat(DaoFactory.getIjazahAngkatDao().getIjazahAngkatByNama(comboIjazahPengangkatan.getSelectedItem().toString()));
                pendidikanPegawai.setTglLulusSKPengangkatan(sdf.format(tglLulusSKPengangkatan.getDate()));
                pendidikanPegawai.setTglLulusSKPengangkatan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglLulusSKPengangkatan.getDate()))); // format indo
                pendidikanPegawai.setPendidikanTerakhir(DaoFactory.getPendidikanTerakhirDao().getPendidikanByNama(comboPendidikanAkhir.getSelectedItem().toString()));
                pendidikanPegawai.setTglLulusSKPendidikanAkhir(sdf.format(tglLulusSKPendidikanAkhir.getDate()));
                pendidikanPegawai.setTglLulusSKPendidikanAkhir_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglLulusSKPendidikanAkhir.getDate()))); // format indo
                //ini end dari Pendidikan Pegawa//
                //*********************************************************************//
                //ini start data Gaji Pegawai//
                Gaji_pegawai gaji_pegawai = new Gaji_pegawai();
                gaji_pegawai.setPegawai(p);
                gaji_pegawai.setGaji_pokok(Double.parseDouble(txtGajiPokok.getText()));
                gaji_pegawai.setTunjangan_suami_istri(Double.parseDouble(txtTunjanganSuamiIstri.getText()));
                gaji_pegawai.setTunjangan_anak(Double.parseDouble(txtTunjanganAnak.getText()));
                gaji_pegawai.setTunjangan_lain(Double.parseDouble(txtTunjanganLain.getText()));
                gaji_pegawai.setTotal_gaji(Double.parseDouble(txtJumlahGaji.getText()));
                gaji_pegawai.setTanggungan_orang(Integer.parseInt(txtTanggunganOrang.getText()));
                gaji_pegawai.setKgb_berikutnya(Integer.parseInt(txtKGBBerikutnya.getText()));
                Calendar c = GregorianCalendar.getInstance();
                c.setTime(tmtKGBDate.getDate());
                c.add(Calendar.YEAR, Integer.parseInt(txtKGBBerikutnya.getText()));
                gaji_pegawai.setKbg_yad_date(sdf.format(c.getTime()));
                gaji_pegawai.setKgb_yad_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(c.getTime())));
                //ini end dari Gaji Pegawai//
                //*********************************************************************//

                DaoFactory.getPegawaiDao().InsertPegawai(p);
                DaoFactory.getPangkatDao().InsertPangkatPegawai(pangkat);
                DaoFactory.getPekerjaanJabatanDao().InsertPekerjaanJabatan(pkj);
                DaoFactory.getPendidikanPegawaiDao().InsertPendidikanPegawai(pendidikanPegawai);
                DaoFactory.getGaji_pegawai_dao().InsertGajiPegawai(gaji_pegawai);
                Session.setPegawai(p);
            }
        }
    }//GEN-LAST:event_ButtonSaveActionPerformed

    private void comboGolonganPangkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGolonganPangkatActionPerformed
        // TODO add your handling code here:
        //System.out.println(comboGolonganPangkat.getItemCount());
        if (comboGolonganPangkat.getItemCount() >= 1) {
            //System.out.println("oke");
            Golongan golongan = DaoFactory.getGolonganDao().getGolonganByNamaGolongan(comboGolonganPangkat.getSelectedItem().toString());
            txtPangkat.setText(golongan.getPangkat());
        }

    }//GEN-LAST:event_comboGolonganPangkatActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        //*********************************************************************//
        //ini start data Pekerjaan Jabatan /tab Pekerjaan Jabatan//
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PekerjaanJabatan pkj = new PekerjaanJabatan();
        Pegawai p = DaoFactory.getPegawaiDao().getPegawaiByNUK(NUK_teks.getText());
        pkj.setPegawai(p);
        pkj.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByNamaBidangKerja(comboBidangKerja.getSelectedItem().toString()));
        pkj.setTglTMTPekerjaan(sdf.format(tmtPekerjaan.getDate()));
        pkj.setTglTMTPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tmtPekerjaan.getDate()))); // Format Indo
        pkj.setNomorSKPekerjaan(txtNomorSKJabatan.getText());
        pkj.setTglSKPekerjaan(sdf.format(tglSKJabatan.getDate()));
        pkj.setTglSKPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglSKJabatan.getDate()))); // Format indo
        pkj.setCabang(DaoFactory.getCabangDao().getCabangByNamaCabang(comboWIlayahTugas.getSelectedItem().toString()));
        pkj.setUnit(DaoFactory.getUnitDao().getUnitByNama(comboUnitKerja.getSelectedItem().toString()));
        pkj.setJabatan(DaoFactory.getJabatanDao().getJabatanByNama(comboNamaJabatan.getSelectedItem().toString()));
        pkj.setNamaJabatan(txtNamaJabatan.getText());
        pkj.setMasaJabatan(Integer.parseInt(txtMasaJabatan.getText()));
        //ini end dari Pekerjaan Jabatan /tab Pekerjaan Jabatan//
        //*********************************************************************//
        if (p != null) {
            Session.setPekerjaanJabatan(pkj);
            NaikJabatanUI njui = new NaikJabatanUI();
            njui.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Data Pegawai Tidak Ditemukan/Cek Nuk", "Peringatan", 3);
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtAnakSeluruhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnakSeluruhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnakSeluruhActionPerformed

    private void txtTahunKerjaBenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTahunKerjaBenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTahunKerjaBenarActionPerformed

    private void txtGajiPokokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGajiPokokKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtGajiPokokKeyTyped

    private void txtGajiPokokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGajiPokokKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtGajiPokokKeyReleased

    private void txtJumlahGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahGajiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtJumlahGajiActionPerformed

    private void txtJumlahGajiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJumlahGajiFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txtJumlahGajiFocusGained

    private void txtGajiPokokFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGajiPokokFocusLost
        // TODO add your handling code here:
        double pokok = Double.parseDouble(txtGajiPokok.getText());
        double suamiistri = Double.parseDouble(txtTunjanganSuamiIstri.getText());
        double t_anak = Double.parseDouble(txtTunjanganAnak.getText());
        double t_lain = Double.parseDouble(txtTunjanganLain.getText());
        double total = pokok + suamiistri + t_anak + t_lain;
        txtJumlahGaji.setText(String.valueOf(total));
    }//GEN-LAST:event_txtGajiPokokFocusLost

    private void txtTunjanganSuamiIstriFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTunjanganSuamiIstriFocusLost
        // TODO add your handling code here:
        double pokok = Double.parseDouble(txtGajiPokok.getText());
        double suamiistri = Double.parseDouble(txtTunjanganSuamiIstri.getText());
        double t_anak = Double.parseDouble(txtTunjanganAnak.getText());
        double t_lain = Double.parseDouble(txtTunjanganLain.getText());
        double total = pokok + suamiistri + t_anak + t_lain;
        txtJumlahGaji.setText(String.valueOf(total));
    }//GEN-LAST:event_txtTunjanganSuamiIstriFocusLost

    private void txtTunjanganAnakFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTunjanganAnakFocusLost
        // TODO add your handling code here:
        double pokok = Double.parseDouble(txtGajiPokok.getText());
        double suamiistri = Double.parseDouble(txtTunjanganSuamiIstri.getText());
        double t_anak = Double.parseDouble(txtTunjanganAnak.getText());
        double t_lain = Double.parseDouble(txtTunjanganLain.getText());
        double total = pokok + suamiistri + t_anak + t_lain;
        txtJumlahGaji.setText(String.valueOf(total));
    }//GEN-LAST:event_txtTunjanganAnakFocusLost

    private void txtTunjanganLainFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTunjanganLainFocusLost
        // TODO add your handling code here:
        double pokok = Double.parseDouble(txtGajiPokok.getText());
        double suamiistri = Double.parseDouble(txtTunjanganSuamiIstri.getText());
        double t_anak = Double.parseDouble(txtTunjanganAnak.getText());
        double t_lain = Double.parseDouble(txtTunjanganLain.getText());
        double total = pokok + suamiistri + t_anak + t_lain;
        txtJumlahGaji.setText(String.valueOf(total));
    }//GEN-LAST:event_txtTunjanganLainFocusLost

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Session.setPegawai(null);
        Session.setNUK("");
        resetField();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fotoTeks.setText(file.getName());
            Path to = Paths.get("image/" + file.getName());
            System.out.println(file.toPath());
            //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("emp.jpg"))); // NOI18N
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            try {
                Files.copy(file.toPath(), to, options);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
            //displayPhotoTxt.setIcon(imageIcon);
            txtFotoDisplay.setIcon(new ImageIcon(newimg));
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        String nuk = NUK_teks.getText();
        if (nuk.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Data NUK Kosong, siliahkan dipilih/isi");
        } else {
            Pegawai p = new Pegawai();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //ini start data Pekerjaan Jabatan /tab Pekerjaan Jabatan//
            PekerjaanJabatan pkj = new PekerjaanJabatan();
            pkj.setPegawai(p);
            pkj.setBk(DaoFactory.getBidangKerjaDao().getBidangKerjaByNamaBidangKerja(comboBidangKerja.getSelectedItem().toString()));
            pkj.setTglTMTPekerjaan(sdf.format(tmtPekerjaan.getDate()));
            pkj.setTglTMTPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tmtPekerjaan.getDate()))); // Format Indo
            pkj.setNomorSKPekerjaan(txtNomorSKJabatan.getText());
            pkj.setTglSKPekerjaan(sdf.format(tglSKJabatan.getDate()));
            pkj.setTglSKPekerjaan_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(tglSKJabatan.getDate()))); // Format indo
            pkj.setCabang(DaoFactory.getCabangDao().getCabangByNamaCabang(comboWIlayahTugas.getSelectedItem().toString()));
            pkj.setUnit(DaoFactory.getUnitDao().getUnitByNama(comboUnitKerja.getSelectedItem().toString()));
            pkj.setJabatan(DaoFactory.getJabatanDao().getJabatanByNama(comboNamaJabatan.getSelectedItem().toString()));
            pkj.setNamaJabatan(txtNamaJabatan.getText());
            pkj.setMasaJabatan(Integer.parseInt(txtMasaJabatan.getText()));
            //ini end dari Pekerjaan Jabatan /tab Pekerjaan Jabatan//
            Session.setPekerjaanJabatan(pkj);
            SK_JABATAN_UI sk_jabatan_ui = new SK_JABATAN_UI();
            sk_jabatan_ui.setVisible(true);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void NUK_teksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUK_teksActionPerformed
        // TODO add your handling code here:
        String nuk = NUK_teks.getText();
        Pegawai p = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk);
        if (p != null) {
            Session.setNUK(nuk);
            initUpdateApp();
        }

    }//GEN-LAST:event_NUK_teksActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String nuk = NUK_teks.getText();
        Pegawai p = DaoFactory.getPegawaiDao().getPegawaiByNUK(nuk);
        if (p != null) {
            Session.setNUK(nuk);
            Session.setPegawai(p);
            //*********************************************************************//
            //ini start data pangkat golonga /tab pangkat golongan//
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Golongan golongan = DaoFactory.getGolonganDao().getGolonganByNamaGolongan(comboGolonganPangkat.getSelectedItem().toString());
            String Tmt_golongan = sdf.format(tmtGolonganDate.getDate());
            String Nomor_sk = txtNomorSK.getText();
            String Tgl_nomor_sk = sdf.format(nomorSKDate.getDate());
            String Tgl_tmt_kgb = sdf.format(tmtKGBDate.getDate());
            String Nomor_kgb = txtNomorKGB.getText();
            String Tgl_nomor_kgb = sdf.format(nomorKGBDate.getDate());
            String Tmt_golongan_indo = DaoFactory.FormatTanggalIndonesia(Tmt_golongan);
            String Tgl_nomor_sk_indo = DaoFactory.FormatTanggalIndonesia(Tgl_nomor_sk);
            String Tgl_tmt_kgb_indo = DaoFactory.FormatTanggalIndonesia(Tgl_tmt_kgb);
            String Tgl_nomor_kgb_indo = DaoFactory.FormatTanggalIndonesia(Tgl_nomor_kgb);
            int Tahun_kerja = Integer.parseInt(txtTahunKerja.getText());
            int Bulan_kerja = Integer.parseInt(txtBulanKerja.getText());
            int Tahun_kerja_benar = Integer.parseInt(txtTahunKerjaBenar.getText());
            int Bulan_kerja_benar = Integer.parseInt(txtTahunKerjaBenar.getText());
            Pangkat pangkat = new Pangkat();
            pangkat.setPegawai(p);
            pangkat.setGolongan(golongan);
            pangkat.setTMTGolongan(Tmt_golongan);// tanggal tmt golongan
            pangkat.setNomor_sk(Nomor_sk);
            pangkat.setTanggal_sk(Tgl_nomor_sk);
            pangkat.setTmt_kgb(Tgl_tmt_kgb);
            pangkat.setNomor_kgb(Nomor_kgb);
            pangkat.setTanggal_kgb(Tgl_nomor_kgb);
            pangkat.setTahun_masa_kerja(Tahun_kerja);
            pangkat.setBulan_masa_kerja(Bulan_kerja);
            pangkat.setTahun_masa_kerja_sebenarnya(Tahun_kerja_benar);
            pangkat.setBulan_masa_kerja_sebenarnya(Bulan_kerja_benar);
            pangkat.setTMTGolongan_indo(Tmt_golongan_indo); // Tgl TMT Golongan Format INDO
            pangkat.setTanggal_sk_indo(Tgl_nomor_sk_indo); //Tgl SK Format Indo
            pangkat.setTmt_kgb_indo(Tgl_tmt_kgb_indo); // TMT KGB Format Indo
            pangkat.setTanggal_kgb_indo(Tgl_nomor_kgb_indo); //Nomor KGB Format Indor
            //ini end dari pangkat golongan /tab pangkat golongan//
            //*********************************************************************//
            Session.setPangkat(pangkat);
            NaikPangkatUI i = new NaikPangkatUI();
            i.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int statusOpsi = JOptionPane.showConfirmDialog(null, "Yakin menambahkan data gaji ke riwayat gaji?", "KGB Gaji / Riwayat", JOptionPane.OK_CANCEL_OPTION);
        if (statusOpsi == JOptionPane.OK_OPTION) {
            //*********************************************************************//
            //ini start data Gaji Pegawai//
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Pegawai p = DaoFactory.getPegawaiDao().getPegawaiByNUK(NUK_teks.getText());
            Pangkat pangkat = DaoFactory.getPangkatDao().getPangkatByNUK(Session.getNUK());
            PekerjaanJabatan pekerjaanJabatan = DaoFactory.getPekerjaanJabatanDao().getPekerjaanJabatanByNUK(Session.getNUK());
            if (p != null) {
                RiwayatGajiPegawai gaji_pegawai = new RiwayatGajiPegawai();
                gaji_pegawai.setPegawai(p);
                gaji_pegawai.setGaji_pokok(Double.parseDouble(txtGajiPokok.getText()));
                gaji_pegawai.setTunjangan_suami_istri(Double.parseDouble(txtTunjanganSuamiIstri.getText()));
                gaji_pegawai.setTunjangan_anak(Double.parseDouble(txtTunjanganAnak.getText()));
                gaji_pegawai.setTunjangan_lain(Double.parseDouble(txtTunjanganLain.getText()));
                gaji_pegawai.setTotal_gaji(Double.parseDouble(txtJumlahGaji.getText()));
                gaji_pegawai.setTanggungan_orang(Integer.parseInt(txtTanggunganOrang.getText()));
                gaji_pegawai.setKgb_berikutnya(Integer.parseInt(txtKGBBerikutnya.getText()));
                gaji_pegawai.setPangkat(pangkat);
                gaji_pegawai.setPekerjaanJabatan(pekerjaanJabatan);
                Calendar c = GregorianCalendar.getInstance();
                c.setTime(tmtKGBDate.getDate());
                c.add(Calendar.YEAR, Integer.parseInt(txtKGBBerikutnya.getText()));
                gaji_pegawai.setKbg_yad_date(sdf.format(c.getTime()));
                gaji_pegawai.setKgb_yad_indo(DaoFactory.FormatTanggalIndonesia(sdf.format(c.getTime())));
                DaoFactory.getRiwayat_Gaji_pegawai_dao().InsertGajiPegawaiRiwayat(gaji_pegawai); // simpan riwayat
                JOptionPane.showMessageDialog(null, "Data riwayat pegawai berhasil disimpan");
            } else {
                JOptionPane.showMessageDialog(null, "Data pegawai tidak ditemukan");
            }
            //ini end dari Gaji Pegawai//
            //*********************************************************************//
        }
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(Insertpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Insertpegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JComboBox ComboSttPeg;
    private javax.swing.JTextField NUK_teks;
    private javax.swing.JTextField aliasTeks;
    private javax.swing.JRadioButton ceweRadio;
    private javax.swing.JComboBox comboAgama;
    private javax.swing.JComboBox<String> comboBidangKerja;
    private javax.swing.JComboBox<String> comboGolonganPangkat;
    private javax.swing.JComboBox<String> comboIjazahPengangkatan;
    private javax.swing.JComboBox comboKawin;
    private javax.swing.JComboBox<String> comboNamaJabatan;
    private javax.swing.JComboBox<String> comboPendidikanAkhir;
    private javax.swing.JComboBox<String> comboUnitKerja;
    private javax.swing.JComboBox<String> comboWIlayahTugas;
    private javax.swing.JTextField fotoTeks;
    private javax.swing.JTextField gelarTeks;
    private javax.swing.JTextField gelarbelakangTeks;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton15;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.ButtonGroup kelaminGroup;
    private javax.swing.JRadioButton lakiRadio;
    private com.toedter.calendar.JDateChooser nomorKGBDate;
    private com.toedter.calendar.JDateChooser nomorSKDate;
    private javax.swing.JTextField tengahTeks;
    private com.toedter.calendar.JDateChooser tglLahirDate;
    private com.toedter.calendar.JDateChooser tglLulusSKPendidikanAkhir;
    private com.toedter.calendar.JDateChooser tglLulusSKPengangkatan;
    private com.toedter.calendar.JDateChooser tglSKJabatan;
    private com.toedter.calendar.JDateChooser tmtGolonganDate;
    private com.toedter.calendar.JDateChooser tmtKGBDate;
    private com.toedter.calendar.JDateChooser tmtPekerjaan;
    private javax.swing.JTextField txtAnakGaji;
    private javax.swing.JTextField txtAnakSeluruh;
    private javax.swing.JTextField txtBulanKerja;
    private javax.swing.JTextField txtBulanKerjaBenar;
    private javax.swing.JLabel txtFotoDisplay;
    private javax.swing.JTextField txtGajiPokok;
    private javax.swing.JTextField txtJumlahGaji;
    private javax.swing.JTextField txtKGBBerikutnya;
    private javax.swing.JTextField txtMasaJabatan;
    private javax.swing.JTextField txtNamaJabatan;
    private javax.swing.JTextField txtNomorKGB;
    private javax.swing.JTextField txtNomorSK;
    private javax.swing.JTextField txtNomorSKJabatan;
    private javax.swing.JLabel txtPangkat;
    private javax.swing.JTextField txtTahunKerja;
    private javax.swing.JTextField txtTahunKerjaBenar;
    private javax.swing.JTextField txtTanggunganOrang;
    private javax.swing.JTextField txtTempatLahir;
    private javax.swing.JTextField txtTunjanganAnak;
    private javax.swing.JTextField txtTunjanganLain;
    private javax.swing.JTextField txtTunjanganSuamiIstri;
    // End of variables declaration//GEN-END:variables
}
