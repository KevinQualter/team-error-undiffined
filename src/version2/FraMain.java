package version2;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FraMain extends JFrame {

    public FraMain() {
        add(new KevinScratch.PanMain());
        setTitle("Caged in");

        //Makes sure the frame is in the middle of the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //This obtains screensize; we probably will take out
        setSize(1250, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        /*Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int xSize = 1200;
        int ySize = ((int) tk.getScreenSize().getHeight());
        int ySize = 700;
        setSize(xSize, ySize);
        //http://www.coderanch.com/t/341780/GUI/java/set-Jframe-full-screen*/
        setVisible(true);
    }
}
