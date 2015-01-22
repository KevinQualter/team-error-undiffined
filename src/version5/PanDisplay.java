package version5;

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
import javax.swing.ImageIcon;

public class PanDisplay extends JPanel implements ActionListener {

    private Yeti yeti;
    ImageIcon imgGBG = new ImageIcon("GameBackground.png");
    Image iGBG;
    int nFrame = 0;
    int nBgX = 0;
    private Timer timer;
    int nLevel[] = new int[10];
    boolean bGenLevel = true;
    Image iRooms[] = new Image[6];
    ////
    int nNumRooms = 2;
    ////
    int nBgXEND = 1250 * (nNumRooms - 1);

    public PanDisplay() {

        super();
        iGBG = imgGBG.getImage();
        setBackground(Color.black);
        yeti = new Yeti();
        addKeyListener(new MovementChecker());
        setFocusable(true);
        timer = new Timer(80, this);
        ////This is a toggle, so that we dont constantly generate levels
        if (bGenLevel = true) {
            ////The '4' value determines how many rooms to generate
            GenerateLevel();
            bGenLevel = false;
        }
        ////Generates the platforms based on rooms
        for (int i = 0; i < 6; i++) {
            ImageIcon iiTemp = new ImageIcon("BG" + i + ".png");
            iRooms[i] = iiTemp.getImage();
        }
        timer.start();
    }

    ////Generates the level backgrounds
    public void GenerateLevel() {
        for (int i = 0; i < nNumRooms; i++) {
            ////the 4 is the # of room types
            ////For some reson it generates twice. This causes no problems, however.
            nLevel[i] = (int) (Math.random() * 4);

        }
        nLevel[0] = 4;
        nLevel[nNumRooms - 1] = 5;
    }
    ////Changes the BG's x-value

    public void MoveChar(int _CharX) {
        nBgX = _CharX;
    }

    public void actionPerformed(ActionEvent arg0) {
        yeti.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        ////Paints the Bg's
        try {
            nBgXEND -= 8;
            if (nBgXEND >= 0) {
                nBgX -= 8;
            }
            ////Room 1
            if (nNumRooms >= 1) {
                g2d.drawImage(iRooms[nLevel[0]], nBgX, 0, null);
            }
            ////Room 2

            if (nNumRooms >= 2) {
                g2d.drawImage(iRooms[nLevel[1]], nBgX + iRooms[nLevel[0]].getWidth(this), 0, null);

            }

            ////Room 3
            if (nNumRooms >= 3) {
                g2d.drawImage(iRooms[nLevel[2]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 2, 0, null);

            }
            ////Room 4
            if (nNumRooms >= 4) {
                g2d.drawImage(iRooms[nLevel[3]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 3, 0, null);

            }
            ////Room 5
            if (nNumRooms >= 5) {
                g2d.drawImage(iRooms[nLevel[4]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 4, 0, null);

            }
            ////Room 6
            if (nNumRooms >= 6) {
                g2d.drawImage(iRooms[nLevel[5]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 5, 0, null);
            }
            ////Room 7
            if (nNumRooms >= 7) {
                g2d.drawImage(iRooms[nLevel[6]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 6, 0, null);
            }
            ////Room 8
            if (nNumRooms >= 8) {
                g2d.drawImage(iRooms[nLevel[7]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 7, 0, null);
            }
            ////Room 9
            if (nNumRooms >= 9) {
                g2d.drawImage(iRooms[nLevel[8]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 8, 0, null);
            }
            ////Room 10
            if (nNumRooms >= 10) {
                g2d.drawImage(iRooms[nLevel[9]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 9, 0, null);
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }

        ////Paints the Character
        g2d.drawImage(yeti.getImage(), yeti.getX(), yeti.getY(), null);

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