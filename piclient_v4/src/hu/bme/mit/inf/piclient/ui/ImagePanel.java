/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.piclient.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import hu.bme.mit.inf.piclient.Application;

/**
 *
 * @author zsoltmazlo
 */
public class ImagePanel extends JPanel {
    
    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(ImagePanel.class.getResource("/piclient/ui/main-logo_orig.png"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Application.pageBackground);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        System.out.println(getWidth());
        System.out.println(image.getWidth());
        
        float ratio = (float)getWidth()/(float)image.getWidth();
        System.out.println(String.format("ratio: %.8f", ratio));
        g.drawImage(image, 0, 0, getWidth(), (int)(image.getHeight()*ratio), null); // see javadoc for more info on the parameters            
    }
    
}
