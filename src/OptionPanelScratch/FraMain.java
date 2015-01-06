package OptionPanelScratch;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class FraMain extends JFrame {


    PanMainMenu panMainMenu = new PanMainMenu();
    PanDisplay panGame = new PanDisplay();
    //PanPauseMenu panpausemenu = new PanPauseMenu();
    PanMain panMain = new PanMain();
    //PanStats panstats = new PanStats();

    boolean hasDrawnPanMain, hasDrawnPanMainMenu, hasDrawnpanpausemenu, hasDrawnStats;

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
            //drawing the main panel
            if (hasDrawnPanMain == false) {
                add(panMain);
                hasDrawnPanMain = true;
            }
            panMainMenu.setVisible(false);
            panGame.setVisible(true);
        }
    }
    ActionListener switchListen = new SwitchListen();
    // the listener to switch from the menu to the game
}
