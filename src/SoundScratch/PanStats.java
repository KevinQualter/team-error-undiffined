package SoundScratch;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanStats extends JPanel {
////
    ImageIcon iiLoadNums;
    ImageIcon imgiTime = new ImageIcon("Time.png");
    ImageIcon imgiScore = new ImageIcon("Score.png");
    ImageIcon imgiLives = new ImageIcon("Lives.png");
    ImageIcon imgiCoins = new ImageIcon("Coins.png");
    ImageIcon imgUIBG = new ImageIcon("UIBackground.png");
    Image ariNumbers[] = new Image[10];
    Image iUIBG;
    Image imgTime;
    Image imgScore;
    Image imgLives;
    Image imgCoins;
    Image imgTimeCount1;
    Image imgTimeCount2;
    Image imgTimeCount3;
    ////
    Image iBG;
    int Time1 = 1;
    int Time2 = 8;
    int Time3 = 0;
    Boolean bStopTimer = false;
    Boolean bTimeChanged1;
    Boolean bTimeChanged2 = false;
    Timer timer;
    Boolean BTimeReset = false;
    Boolean bLifeLost = false;
    int nLife = 3;
    ////
    int nCoins1 = 0;
    int nCoins2 = 0;
    int nScore1 = 0;
    int nScore2 = 0;
    int nScore3 = 0;

    public PanStats() {
        setPreferredSize(new Dimension(1250, 75));
        ////
        for (int i = 0; i < 10; i++) {
            iiLoadNums = new ImageIcon("img" + i + ".png");
            ariNumbers[i] = iiLoadNums.getImage();
        }
        imgCoins = imgiCoins.getImage();
        iUIBG = imgUIBG.getImage();
        imgTime = imgiTime.getImage();
        imgScore = imgiScore.getImage();
        imgLives = imgiLives.getImage();
        ////
        timer = new Timer(1000, updateImage);
        timer.start();
    }
    public void ResetTime(Boolean _BTimeReset) {
        BTimeReset = _BTimeReset;
    }
    public void LooseALife(Boolean _bLifeLost) {
        bLifeLost = _bLifeLost;
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(iUIBG, 0, 0, null);
        g.drawImage(imgTime, 950, 10, null);
        g.drawImage(ariNumbers[(Time1)], 950 + imgTime.getWidth(this), 10, null);
        g.drawImage(ariNumbers[(Time2)], 950 + imgTime.getWidth(this) + 30, 10, null);
        g.drawImage(ariNumbers[(Time3)], 950 + imgTime.getWidth(this) + 60, 10, null);
        ////
        g.drawImage(imgLives, 10, 10, null);
        g.drawImage(ariNumbers[(nLife)], 10 + imgLives.getWidth(this), 10, null);
        ////
        g.drawImage(imgScore, 520, 10, null);
        g.drawImage(ariNumbers[(nScore1)], 520 + imgScore.getWidth(this) + 10, 10, null);
        g.drawImage(ariNumbers[(nScore2)], 520 + imgScore.getWidth(this) + 40, 10, null);
        g.drawImage(ariNumbers[(nScore3)], 520 + imgScore.getWidth(this) + 70, 10, null);
        ////
        g.drawImage(imgCoins, 230, 10, null);
        g.drawImage(ariNumbers[(nCoins1)], 230 + imgCoins.getWidth(this) + 10, 10, null);
        g.drawImage(ariNumbers[(nCoins2)], 230 + imgCoins.getWidth(this) + 40, 10, null);
        ////
    }
    ActionListener updateImage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            bTimeChanged1 = false;
            if (Time1 == 0 && Time2 == 0 && Time3 == 0) {
                bStopTimer = true;
                timer.stop();
            }
            if (bStopTimer !=true) {
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
                if (bLifeLost == true) {
                    nLife--;
                    bLifeLost = false;
                }
                Time3--;
            }
            repaint();
        }
    };
}