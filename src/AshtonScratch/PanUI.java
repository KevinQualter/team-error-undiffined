package AshtonScratch;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanUI extends JPanel {
    
    ImageIcon imgiTime = new ImageIcon("Time.png");
    ImageIcon imgiScore = new ImageIcon("Score.png");
    ImageIcon imgiLives = new ImageIcon("Lives.png");
    ImageIcon imgiCoins = new ImageIcon("Coins.png");
    ImageIcon img0 = new ImageIcon("img0.png");
    ImageIcon img1 = new ImageIcon("img1.png");
    ImageIcon img2 = new ImageIcon("img2.png");
    ImageIcon img3 = new ImageIcon("img3.png");
    ImageIcon img4 = new ImageIcon("img4.png");
    ImageIcon img5 = new ImageIcon("img5.png");
    ImageIcon img6 = new ImageIcon("img6.png");
    ImageIcon img7 = new ImageIcon("img7.png");
    ImageIcon img8 = new ImageIcon("img8.png");
    ImageIcon img9 = new ImageIcon("img9.png");
    ImageIcon imgBG = new ImageIcon("Background.png");
    public Image iBG;
    public Image ariNumbers[] = new Image[10];
    public Image imgTime;
    public Image imgScore;
    public Image imgLives;
    public Image imgCoins;
    public Image imgTimeCount1;
    public Image imgTimeCount2;
    public Image imgTimeCount3;
    public int Time1 = 9;
    public int Time2 = 9;
    public int Time3 = 9;
    public Boolean bTimeChanged1;
    public Boolean bTimeChanged2 = false;    
    Timer timer;
    Boolean BTimeReset = false;
    Boolean bLifeLost = false;
    int nLife = 3;
    ////
    int nCoins1 = 0;
    int nCoins2 = 0;
    public int nScore1 = 0;
    public int nScore2 = 0;
    public int nScore3 = 0;

    public PanUI() {
        
        ////
        iBG = imgBG.getImage();
        ////
        
        ariNumbers[0] = img0.getImage();
        ariNumbers[1] = img1.getImage();
        ariNumbers[2] = img2.getImage();
        ariNumbers[3] = img3.getImage();
        ariNumbers[4] = img4.getImage();
        ariNumbers[5] = img5.getImage();
        ariNumbers[6] = img6.getImage();
        ariNumbers[7] = img7.getImage();
        ariNumbers[8] = img8.getImage();
        ariNumbers[9] = img9.getImage();
        imgTime = imgiTime.getImage();
        imgScore = imgiScore.getImage();
        imgLives = imgiLives.getImage();
        imgCoins = imgiCoins.getImage();
        timer = new Timer(1000, updateImage);
        timer.start();
        if (Time1 == 0 && Time2 == 0 && Time3 == 0) {
            System.out.println("Didit");
            timer.stop();
        }
    }
    
    public void ResetTime(Boolean _BTimeReset) {
        BTimeReset = _BTimeReset;
    }

    public void LooseALife(Boolean _bLifeLost) {
        bLifeLost = _bLifeLost;
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        ////
        g.drawImage(iBG,0,0,null);
        ////
        
        
        g.drawImage(imgTime, 950, 0, null);
        g.drawImage(imgLives, 0, 475, null);
        g.drawImage(imgScore, 0, 475 + (imgLives.getHeight(this)), null);
        g.drawImage(imgCoins, 0, 475 + imgScore.getHeight(this) + (imgLives.getHeight(this)), null);
        ////
        g.drawImage(ariNumbers[(Time1)], 950 + imgTime.getWidth(this), 0, null);
        g.drawImage(ariNumbers[(Time2)], 950 + imgTime.getWidth(this) + 30, 0, null);
        g.drawImage(ariNumbers[(Time3)], 950 + imgTime.getWidth(this) + 60, 0, null);
        ////
        g.drawImage(ariNumbers[(nLife)], imgScore.getWidth(this)+10, 475, null);   
        ////
        g.drawImage(ariNumbers[(nScore1)], imgScore.getWidth(this)+10, 475 + (imgLives.getHeight(this)), null);  
        g.drawImage(ariNumbers[(nScore2)], imgScore.getWidth(this) + 40, 475 + (imgLives.getHeight(this)), null);
        g.drawImage(ariNumbers[(nScore3)], imgScore.getWidth(this) + 70, 475 + (imgLives.getHeight(this)), null);
        ////
        g.drawImage(ariNumbers[(nCoins1)], imgCoins.getWidth(this)+10, 475 + imgScore.getHeight(this) + (imgLives.getHeight(this)), null);  
        g.drawImage(ariNumbers[(nCoins2)], imgCoins.getWidth(this) + 40, 475 + imgScore.getHeight(this) + (imgLives.getHeight(this)), null);
        ////
        
        
    }
    ActionListener updateImage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            System.out.println(Time1 + "/" + Time2 + "/" + Time3);
            bTimeChanged1 = false;
            if (Time1 == 0 && Time3 == 0) {
                bTimeChanged2 = true;
            }
            if (Time3 == 0 && bTimeChanged1 != true) {
                Time2 -= 1;
                Time3 += 10;
                bTimeChanged1 = true;
            }
            if (Time2 == 0 && bTimeChanged2 != true) {
                Time1 -= 1;
                Time2 += 9;
                bTimeChanged1 = true;
            }
            if (BTimeReset == true) {
                Time1 = 1;
                Time2 = 2;
                Time3 = 0;
                BTimeReset = false;
            }
            Time3 --;
            repaint();
        }
    };
}