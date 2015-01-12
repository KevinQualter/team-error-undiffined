package OptionPanelScratch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class PanInGameOptions extends JPanel {
//OptionsPanelBackground.png

    ImageIcon imgGBG = new ImageIcon("OptionsPanelBackground.png");
    Image iGBG;
   /* static final int VOL_MIN = 0;
    static final int VOL_MAX = 100;
    static final int VOL_INIT = 10;*/

    public PanInGameOptions() {
        super();
        //setLayout(null);
        setPreferredSize(new Dimension(100, 700));
        setBackground(Color.red);
        iGBG = imgGBG.getImage();
        /*JLabel lblVolume = new JLabel("Volume");
        JSlider volume = new JSlider(JSlider.VERTICAL,
                VOL_MIN, VOL_MAX, VOL_INIT);
        
        //Turn on labels at major tick marks.
        volume.setToolTipText("Volume Control");
        volume.setPaintTicks(true);
        volume.setPaintLabels(true);
        volume.setMajorTickSpacing(10);
        volume.setMinorTickSpacing(1);
        volume.setPaintTicks(true);
        volume.setPaintLabels(true);
        add(volume);*/
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(iGBG, 0, 0, null);
    }
}
