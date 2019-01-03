package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    //methods

    //create background and player
    public GamePanel(){
        new Background();
        new Player();
    }

    // draw b-ground and player
    @Override
    public void paint(Graphics g){
        GameObject.renderAll(g);
    }

    //run game
    public void gameLoop(){
        long lastLoop = 0;
        long delay = 1000/60;
        while (true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastLoop > delay){
                this.runAll();
                this.renderAll();
                lastLoop = currentTime;
            }
        }
    }

    //logic process
    private void runAll() {
        GameObject.runAll();
    }

    //graphics process
    private void renderAll() {
        this.repaint();
    }

}
