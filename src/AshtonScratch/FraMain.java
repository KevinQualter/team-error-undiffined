package AshtonScratch;

import javax.swing.JFrame;

public class FraMain extends JFrame {

    
    public FraMain() {
        setSize(1250, 700);
        setTitle("Animation Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new PanUI());
        //Puting \/ below adding PanUI is important :3
        setVisible(true);
    }
}