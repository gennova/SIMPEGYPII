/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpeg;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tendy Developer
 */
public class SIMPEG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new PrintReport("./report/surat_pengangkatan.jasper", "nuknya", "2000");
        JFrame snakeFrame = new JFrame();
        snakeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setSize(50, 50);
        panel.setBounds(0, 0, 50, 50);
        panel.setBackground(Color.CYAN);
        File file;
        JFileChooser chooser = new JFileChooser();
        file = chooser.getSelectedFile();
        ImageIcon icon = new ImageIcon("image/womansamurai.jpg");  
        
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setSize(50, 50);
        label.setBounds(0, 0, 50, 50);
        panel.add(label);
        snakeFrame.add(panel);
        snakeFrame.setBounds(100, 200, 600, 600);
        snakeFrame.setVisible(true);
        //snakeFrame.pack();

    }
}
