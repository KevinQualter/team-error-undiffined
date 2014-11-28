/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MiguelScratch;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Miguel
 */
public class PanPauseMenu extends JFrame{
    
    JButton btnBacktoGame = new JButton("Go Back");
    JButton btnMainMenu = new JButton("Main Menu");
    
    public PanPauseMenu(){
                setLayout(null);
        setBackground(Color.green);
        btnBacktoGame.setBounds(400, 400, 200, 50);

        btnMainMenu.setBounds(15, 20, 100, 40);
        
        // add the buttons
        add(btnBacktoGame);
        add(btnMainMenu);
    }
}
