package AshtonScratch;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanIcon extends JPanel {

    ImageIcon Img1 = new ImageIcon("Picture_1.png");
    ImageIcon Img2 = new ImageIcon("Picture_2.png");
    ImageIcon Img3 = new ImageIcon("Picture_3.png");
    ImageIcon Img4 = new ImageIcon("Picture_4.png");
    ////
    ImageIcon ImgBG = new ImageIcon("BackGround.jpg");
    ////
    ImageIcon Img5 = new ImageIcon("Picture_5.png");
    ImageIcon Img6 = new ImageIcon("Picture_6.png");
    ImageIcon Img7 = new ImageIcon("Picture_7.png");
    ImageIcon Img8 = new ImageIcon("Picture_8.png");
    public Image Images[][] = new Image[4][2];
    public Image BGImage;
    Timer timer;
    int nFrame = 0;
    int nCycle = 0;
    int nX = 0;
    int nY = 0;

    public PanIcon() {
        Images[0][0] = Img1.getImage();
        Images[1][0] = Img2.getImage();
        Images[2][0] = Img3.getImage();
        Images[3][0] = Img4.getImage();
        ////
        Images[0][1] = Img1.getImage();
        Images[1][1] = Img2.getImage();
        Images[2][1] = Img3.getImage();
        Images[3][1] = Img4.getImage();

        BGImage = ImgBG.getImage();

        timer = new Timer(500, updateImage);
        timer.start();
    }

    public void AnimationMutator(int _nCycle, int _nX, int _nY) {
        nCycle = _nCycle;
        nFrame = 0;
        nX = _nX;
        nY = _nY;
    }

    public void paintComponent(Graphics g) {
        //super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(BGImage, 0, 0, null);
        g.drawImage(Images[nFrame][nCycle], nX, nY, null);
        repaint();
    }
    ActionListener updateImage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            System.out.println(nFrame);
            nFrame++;
            if (nFrame == 3) {
                nFrame = 0;
            }
        }
    };
}