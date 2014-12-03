package version2;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Yeti {

    private Image ImgYeti;
    int i, f;
    int x, y, bx, by, dx, dy;
    KevinScratch.LoadImages loadImage = new KevinScratch.LoadImages();
    Image ImgMovement[][] = loadImage.GetYeti();
    private final int SPEED = 8;
    boolean left, right, up, down,canJump = true, isWalking = false;
    Timer MovementTimer;
    Timer GravTimer;
    Timer JumpTimer;

    public Yeti() {
        x = 350;
        y = 238;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        JumpTimer = new Timer(500,jumpingCheck);
        JumpTimer.start();
        GravTimer = new Timer(25, GravDrop);
        GravTimer.start();
        MovementTimer = new Timer(100, updateImage);
        MovementTimer.start();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        ImgYeti = ImgMovement[i][f];
        if (right == true) {
            if (f == 0) {
            }
        } else if (left == true) {
            f = 1;
            if (f == 0) {
                System.out.println("Left");
            }
        } else if (up == true) {
            System.out.println("is jumping");
        } else if (down == true) {
            System.out.println("Down");
        }
        return ImgYeti;
    }

    public void keyPressed(KeyEvent k) {
        int code = k.getKeyCode();
        isWalking = true;
        AnimationMutator();
        if (code == KeyEvent.VK_A) {
            left = true;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_D) {
            right = true;
            dx = SPEED;
        } else if (code == KeyEvent.VK_W) {
            if(canJump == true){
                up = true;                    
                dy = -45;
            canJump = false;
            }
            
        } else if (code == KeyEvent.VK_S) {
            down = true;
            if (y<450){
                y = 450;
            }
        }
    }

    public void keyReleased(KeyEvent k) {
        int code = k.getKeyCode();
        isWalking = false;
        i = 0;
        if (code == KeyEvent.VK_A) {
            left = false;
            if (right) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_D) {
            right = false;
            if (left) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_W) {
            up = false;
            if (up) {
            } else {
                dy = 0;
            }
        } else if (code == KeyEvent.VK_S) {
            down = false;
            if (up) {
            } else {
                dy = 0;
            }
        }
    }
    public void AnimationMutator() {
        if(right == true){
           f = 1; 
        }
        else if(left == true){
           f = 0; 
        }
    }
    
    ActionListener updateImage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(isWalking == true){
                    i++;
               if (i >=4){
                   i=0;
               }
                }
                
            }
        };
    ActionListener GravDrop = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(up == false){
                    if(y<450){
                    y+=1;
                }
                }
                
                
            }
        };
    ActionListener jumpingCheck = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                canJump = true;
            }
        };
}
