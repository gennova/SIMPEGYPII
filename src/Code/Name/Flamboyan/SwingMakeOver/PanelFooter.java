/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Name.Flamboyan.SwingMakeOver;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PresdirTendy
 */
public class PanelFooter extends JPanel{
     private Image image;

    public PanelFooter() {
        image = new ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/bgFooter.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();        
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        

        gd.dispose();
    }
}
