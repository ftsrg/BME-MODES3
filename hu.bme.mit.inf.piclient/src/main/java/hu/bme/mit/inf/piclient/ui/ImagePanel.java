package hu.bme.mit.inf.piclient.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import hu.bme.mit.inf.piclient.Application;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;

/**
 *
 * @author zsoltmazlo, benedekh
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(ImagePanel.class.getResource(
                    "/hu/bme/mit/inf/piclient/ui/main-logo_orig.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Application.pageBackground);
        g.fillRect(0, 0, getWidth(), getHeight());

        logInfoMessage(getClass().getName(), String.valueOf(getWidth()));
        logInfoMessage(getClass().getName(), String.valueOf(image.getWidth()));

        float ratio = (float) getWidth() / (float) image.getWidth();
        logInfoMessage(getClass().getName(), String.format("ratio: %.8f", ratio));
        g.drawImage(image, 0, 0, getWidth(), (int) (image.getHeight() * ratio),
                null); // see javadoc for more info on the parameters            
    }

}
