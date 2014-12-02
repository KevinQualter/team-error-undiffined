/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KevinScratch;

import version1.*;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author qualk2343
 */
public class PanMain extends JPanel{
    PanGame pangame = new PanGame();
    PanStats panstats = new PanStats();
    ImageIcon imgiTime = new ImageIcon("Time.png");
    public PanMain(){
        
        setLayout(new BorderLayout());
        //add(panstats, BorderLayout.SOUTH);
        add(pangame, BorderLayout.CENTER);
    }
}
