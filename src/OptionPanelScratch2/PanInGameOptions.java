package OptionPanelScratch2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;

public class PanInGameOptions extends JPanel {
//OptionsPanelBackground.png

    ImageIcon imgGBG = new ImageIcon("OptionsPanelBackground.png");
    Image iGBG;
    
    static final int VOL_MIN = 0;
    static final int VOL_MAX = 100;
    static final int VOL_INIT = 10;
    
    public PanInGameOptions() {
        
        setLayout(null);
        setPreferredSize(new Dimension(100, 700));
        setBackground(Color.red);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(10,10,10,10);
        add(btnExit);
    }

    public void paint(Graphics g) {
       super.paintComponent(g);
       g.drawImage(iGBG, 0, (- 10), null);
    }
}
