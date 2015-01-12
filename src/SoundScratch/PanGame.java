package SoundScratch;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;

public class PanGame extends JPanel implements ActionListener {

    private Yeti yeti;
    ImageIcon imgGBG = new ImageIcon("GameBackground.png");
    File BackGroundMusic = new File("BackGroundMusic.wav");
    AudioClip BGMusic;
    Image iGBG;
    int nFrame = 0;
    int i = 0;
    private Timer timer, timer2;

    public PanGame() {

        super();
        try {
            BGMusic = Applet.newAudioClip(BackGroundMusic.toURL());

        } catch (Exception e) {
        }
        BGMusic.play();
        iGBG = imgGBG.getImage();
        setBackground(Color.black);
        yeti = new Yeti();
        addKeyListener(new MovementChecker());
        addKeyListener(new AttackChecker());
        setFocusable(true);
        timer = new Timer(80, this);
        timer.start();
        timer2 = new Timer(80, this);
        timer2.start();

    }

    public void actionPerformed(ActionEvent arg0) {
        yeti.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(iGBG, 0, 0, null);
        g2d.drawImage(yeti.getImage(), yeti.getX(), yeti.getY(), null);
        //System.out.println(yeti.getX() + " is x and y is " + yeti.getY());
    }

    private class MovementChecker extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent k) {
            yeti.keyReleased(k);
        }

        @Override
        public void keyPressed(KeyEvent k) {
            yeti.keyPressed(k);
        }
    }

    private class AttackChecker extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent k2) {
            yeti.keyReleased2(k2);
        }

        @Override
        public void keyPressed(KeyEvent k2) {
            yeti.keyPressed2(k2);
        }
    }
}