/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author qualk2343
 */
public class PanMain extends JPanel{
    PanStats panstats = new PanStats();
    PanGame pangame = new PanGame();
    public PanMain(){
        setLayout(new BorderLayout());
        add(panstats, BorderLayout.SOUTH);
        add(pangame, BorderLayout.CENTER);
    }
}
