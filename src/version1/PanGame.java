package version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class PanGame extends JPanel  implements ActionListener {
    private Yeti yeti;
    private int nCordX = 50;
    private int nCordY = 250;
    private Timer timer;
    

    public PanGame() {
        super();
        yeti = new Yeti();
        addKeyListener(new ActionListener());
        setFocusable(true);
        timer = new Timer(80, this);
        timer.start();
    }
public void actionPerformed(ActionEvent arg0) {
        yeti.move();
        repaint();
    }
   public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(yeti.getImage(), yeti.getX(), yeti.getY(), null);
   }

       private class ActionListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent k) {
            yeti.keyReleased(k);
        }

        @Override
        public void keyPressed(KeyEvent k) {
           yeti.keyPressed(k);
        }
    }
}