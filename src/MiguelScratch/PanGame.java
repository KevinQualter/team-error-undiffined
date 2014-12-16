//This code is based on chris and petes

package MiguelScratch;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Miguel
 */
public class PanGame extends JPanel{
     JButton btnPause = new JButton("Pause");

    public PanGame() {
        setLayout(null);
        setBackground(Color.ORANGE);
       //position and size of a button
        //btnPause.setBounds(20, 20, 100, 50);
        
        // add the button
        //add(btnPause);
    }
}
