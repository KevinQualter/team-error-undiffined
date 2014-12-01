package KevinScratch;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Yeti {

    private Image ImgYeti;
    int i, f;
    int x, y, bx, by, dx, dy;
    ImageIcon ir1 = new ImageIcon("YetiWalkLeft1.png");
    ImageIcon il1 = new ImageIcon("YetiWalkRight1.png");
    ImageIcon ir2 = new ImageIcon("YetiWalkLeft2.png");
    ImageIcon il2 = new ImageIcon("YetiWalkRight2.png");
    ImageIcon ir3 = new ImageIcon("YetiWalkLeft3.png");
    ImageIcon il3 = new ImageIcon("YetiWalkRight3.png");
    ImageIcon ir4 = new ImageIcon("YetiWalkLeft4.png");
    ImageIcon il4 = new ImageIcon("YetiWalkRight4.png");
    ImageIcon ir5 = new ImageIcon("YetiWalkLeft5.png");
    ImageIcon il5 = new ImageIcon("YetiWalkRight5.png");
    Image arnRunning[] = new Image[2];
    public Image ImgMovement[][] = new Image[5][2];
    private final int SPEED = 8;
    boolean left, right, up, down,canJump = true, isWalking = false;
    Timer MovementTimer;
    Timer GravTimer;
    Timer JumpTimer;

    public Yeti() {
        ImgMovement[0][0] = ir1.getImage();
        ImgMovement[0][1] = il1.getImage();
        ImgMovement[1][0] = ir2.getImage();
        ImgMovement[1][1] = il2.getImage();
        ImgMovement[2][0] = ir3.getImage();
        ImgMovement[2][1] = il3.getImage();
        ImgMovement[3][0] = ir4.getImage();
        ImgMovement[3][1] = il4.getImage();
        ImgMovement[4][0] = ir5.getImage();
        ImgMovement[4][1] = il5.getImage();
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
                System.out.println("Right");
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
            if (y<500){
                y = 500;
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
