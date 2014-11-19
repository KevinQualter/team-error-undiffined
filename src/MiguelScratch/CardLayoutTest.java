/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MiguelScratch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * MOVING ON TO NEW SCRATCH...
 * @author olivm7733
 */
public class CardLayoutTest extends JFrame implements ActionListener {

    JPanel panMaster;
    JButton btnOne, btnTwo, btnThree;
    JLabel lblOne, lbl2;
    ImageIcon image = new ImageIcon("H:\\NetBeansProjects\\QOW game\\src\\Images\\Game Menu Rough.jpg");
    JLabel imagelabel = new JLabel(image);
    //ImagePanel panimg = new ImagePanel();

    public CardLayoutTest() //This is the CONSTRUCTOR method
    {
        //The entry point into your program
        setLayout(new FlowLayout()); //Use this for now.\
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        setSize(xSize, ySize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Card Layout Example"); //Put Title on top of JFrame
        setResizable(false);
        btnOne = new JButton("THIS IS BUTTON 1");
        btnTwo = new JButton("THIS IS BUTTON 2");
        btnThree = new JButton("THIS IS BUTTON 3");
        lblOne = new JLabel("Menu");
        lbl2 = new JLabel("game");
        btnOne.addActionListener(this);
        btnTwo.addActionListener(this);
        btnThree.addActionListener(this);
        //Create the panMaster
        JPanel panOne = new JPanel(new FlowLayout());
        panOne.add(btnOne);
        panOne.add(imagelabel);
        //lblOne.setContentPane();
        panOne.add(lblOne);
        JPanel panTwo = new JPanel();
        panTwo.add(btnTwo);
        panTwo.add(lbl2);
        JPanel panThree = new JPanel();
        panThree.add(btnThree);
        /*panOne.setBackground(Color.yellow);
        panTwo.setBackground(Color.red);
        panThree.setBackground(Color.blue);*/
        //Create the panel that contains the "panMaster".
        panMaster = new JPanel(new CardLayout());
        //panMaster.add(imagelabel);
        panMaster.add(panOne, "One");
        panMaster.add(panTwo, "Two");
        panMaster.add(panThree, "Three");
        
        //panMaster.add(panimg, "four");
        getContentPane().add(panMaster);
        setVisible(true); //Make JFrame visible
    }

    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) panMaster.getLayout();
        cardLayout.next(panMaster);

    }
}
