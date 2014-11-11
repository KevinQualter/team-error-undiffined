package version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanGame extends JPanel {
    private Image image;
    private int nCordX = 50;
    private int nCordY = 250;
    public PanGame() {
        setBackground(Color.BLUE);
        try {
            image = ImageIO.read(new File("yeti.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
        g.drawImage(image, nCordX, nCordY, null);
    }
}