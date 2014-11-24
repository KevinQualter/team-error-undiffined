package KevinScratch;

import version1.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Yeti {

    private Image ImgYeti;
    int i, f;
    int x, y, bx, by, dx, dy;
    ImageIcon i1 = new ImageIcon("YetiWalkLeft1.png");
    ImageIcon i2 = new ImageIcon("YetiWalkRight1.png");
    Image arnRunning[] = new Image[2];
    public Image ImgMovement[][] = new Image[4][2];
    private final int SPEED = 8;
    boolean left, right, up, down;

    public Yeti() {
        ImgMovement[0][0] = i1.getImage();
        ImgMovement[0][1] = i2.getImage();
        arnRunning[0] = i1.getImage();
        arnRunning[1] = i2.getImage();
        x = 350;
        y = 238;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
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
            f = 0;
            if (f == 1) {
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
        if (code == KeyEvent.VK_A) {
            left = true;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_D) {
            right = true;
            dx = SPEED;
        } else if (code == KeyEvent.VK_W) {
            up = true;
            dy = -SPEED;
        } else if (code == KeyEvent.VK_S) {
            down = true;
            y=650;
        }
    }

    public void keyReleased(KeyEvent k) {
        int code = k.getKeyCode();
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
}
