package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;

public class GamePanel extends JPanel {

    // attributes

    BufferedImage backgroundImage;
    int backgroundX;
    int backgroundY;
    BufferedImage playerImage;
    int playerX;
    int playerY;

    //methods

    //create background and player
    public GamePanel(){
        this.backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        this.playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        backgroundX = 0;
        backgroundY = 600 - this.backgroundImage.getHeight();
        playerX = 200;
        playerY = 400;
    }


    // draw b-ground and player
    @Override
    public void paint(Graphics g){
//      g.draw3DRect(100,100,50,50,true);
        g.drawImage(backgroundImage,this.backgroundX,this.backgroundY,null);
        g.drawImage(playerImage,this.playerX,this.playerY,null);
    }


    //main
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
        // background up
        if (this.backgroundY < 0){
        this.backgroundY++;
        }

        // control player
        if((GameWindow.isUpPress == true) && (this.playerY >= 5 )){
            this.playerY -= 5;
        }
        if((GameWindow.isDownPress == true) && ((playerImage.getHeight() + this.playerY) <= 558)){
            this.playerY += 5;
        }
        if((GameWindow.isLeftPress == true) && (this.playerX  >= this.backgroundX)){
            this.playerX -= 5;
        }
        if((GameWindow.isRightPress == true) && (playerImage.getWidth() + this.playerX  <= backgroundImage.getWidth()+2)){
            this.playerX += 5;
        }
    }


    //
    private void renderAll() {
        this.repaint();
    }
}
