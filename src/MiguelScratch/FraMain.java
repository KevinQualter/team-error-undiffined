package MiguelScratch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Miguel
 */
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class FraMain extends JFrame {

    PanMainMenu panMainMenu = new PanMainMenu();
    PanGame panGame = new PanGame();
    PanPauseMenu panpausemenu = new PanPauseMenu();
    PanStats panstats = new PanStats();

    boolean hasDrawnPanGame, hasDrawnPanMainMenu, hasDrawnpanpausemenu, hasDrawnStats;

    public FraMain() {

        setTitle("Caged in");

        //Makes sure the frame is in the middle of the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //This obtains screensize; we probably will take out
        setSize(1250, 700);
        setVisible(true);
        setLocationRelativeTo(null);

        add(panMainMenu);

        // draws the main menu
        if (hasDrawnPanMainMenu == false) {
            add(panMainMenu);
            hasDrawnPanMainMenu = true;
        }
        panMainMenu.btnStats.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (hasDrawnStats == false) {
                    add(panstats);
                    hasDrawnStats = true;
                }
                panMainMenu.setVisible(false);
                panstats.setVisible(true);
            }
        });
        // mouse listener for the escape button on the game pannel
        /*panGame.btnPause.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (hasDrawnpanpausemenu == false) {
                    add(panpausemenu);
                    hasDrawnpanpausemenu = true;
                }

                panGame.setVisible(false);
                panpausemenu.setVisible(true);
            }
        });

        panpausemenu.btnBacktoGame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                panpausemenu.setVisible(false);
                panGame.setVisible(true);
            }
        });

        panpausemenu.btnMainMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                panpausemenu.setVisible(false);
                panMainMenu.setVisible(true);
            }
        });*/
        panMainMenu.btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                //this closes all components of the game running
            }
        });

        panMainMenu.btnPlay.addActionListener(switchListen);
    }

    class SwitchListen implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (hasDrawnPanGame == false) {
                add(panGame);
                hasDrawnPanGame = true;
            }
            panMainMenu.setVisible(false);
            panGame.setVisible(true);
        }
    }
    ActionListener switchListen = new SwitchListen();
}
