/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package version2;

import version1.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author qualk2343
 */
public class PanMain extends JPanel{
    PanGame pangame = new PanGame();
    PanStats panstats = new PanStats();
    public PanMain(){
        
        setLayout(new BorderLayout());
        add(pangame, BorderLayout.CENTER);
        add(panstats, BorderLayout.SOUTH);
    }
}
