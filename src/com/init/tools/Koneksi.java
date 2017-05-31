/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Koneksi {

    String url = "jdbc:mysql://localhost:3306/simpeg";
    String user = "root";
    String password = "";
    private Connection koneksi = null;
    private Statement st = null;

    public Koneksi() {
        FileInputStream fileInput = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //            System.out.println("Driver ditemukan");
                // TODO code application logic here
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            File file = new File("resource.xml");
            Properties properties;
            fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.loadFromXML(fileInput);
            //JOptionPane.showMessageDialog(null, "OKE EKSEKUSI DAB");
            String db = properties.getProperty("db");
            String host = properties.getProperty("host");
            String username = properties.getProperty("username");
            String passwordnya = properties.getProperty("password");
            user = username;
            password = passwordnya;
            url = "jdbc:mysql://" + host + ":3306/" + db + "";
            koneksi = DriverManager.getConnection(url, user, password);
            st = koneksi.createStatement();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInput.close();
            } catch (IOException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection bukaKoneksi() throws SQLException {
        koneksi = DriverManager.getConnection(url, user, password);
        return koneksi;
    }

    public Connection getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public void tutupKoneksi() throws SQLException {
        if (koneksi != null) {
            koneksi.close();
        }
    }

    public int updateData(String sql) throws SQLException {
        int i = 0;
        i = st.executeUpdate(sql);
        return i;
    }

    public ResultSet lihatData(String sql) throws SQLException {
        ResultSet rs = null;
        rs = st.executeQuery(sql);
        return rs;

    }

    public void executeData(String sql) throws SQLException {
        st.execute(sql);
    }

    public String getStatuc() throws SQLException {
        return koneksi.getWarnings().toString();
    }
}
