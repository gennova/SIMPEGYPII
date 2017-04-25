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
public class PanelImageAbout extends JPanel {

    private Image image;

    public PanelImageAbout() {
        image = new ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/LogoAbout.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
}
