package version1;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class FraMain extends JFrame {

    public FraMain() {
        add(new PanMain());

        Toolkit tk = Toolkit.getDefaultToolkit();
        //int xSize = ((int) tk.getScreenSize().getWidth());
        int xSize = 500;
        //int ySize = ((int) tk.getScreenSize().getHeight());
        int ySize = 500;
        setSize(xSize, ySize);
        //http://www.coderanch.com/t/341780/GUI/java/set-Jframe-full-screen

        //setResizable(false);
        setTitle("insert name here");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
