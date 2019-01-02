package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    // attributes
    Background background;
    Player player;
    static ArrayList<PlayerBullet> bullets;//TODO:fix later
//    BufferedImage backgroundImage;
//    int backgroundX;
//    int backgroundY;

//    BufferedImage playerImage;
//    int playerX;
//    int playerY;

    //methods

    //create background and player
    public GamePanel(){
        this.background = new Background();
//        this.backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
//        backgroundX = 0;
//        backgroundY = 600 - this.backgroundImage.getHeight();
        this.player = new Player();
//        this.playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        playerX = 200;
//        playerY = 400;
        this.bullets = new ArrayList<>();
//        this.bullets.add();
//        this.bullets.size();
//        this.bullets.get();
    }


    // draw b-ground and player
    @Override
    public void paint(Graphics g){
//      g.draw3DRect(100,100,50,50,true);
        this.background.render(g);
//        g.drawImage(backgroundImage,this.backgroundX,this.backgroundY,null);
        this.player.render(g);
//        g.drawImage(playerImage,this.playerX,this.playerY,null);
        for(int i = 0;i<this.bullets.size(); i++){
            PlayerBullet bullet = this.bullets.get(i);
            bullet.render(g);

        }
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
        this.background.run();
        this.player.run();
        // background up
//        if (this.backgroundY < 0){
//        this.backgroundY++;
//        }

        // control player
//        if((GameWindow.isUpPress == true) && (this.playerY >= 5 )){
//            this.playerY -= 5;
//        }
//        if((GameWindow.isDownPress == true) && ((this.playerImage.getHeight() + this.playerY) <= 600)){
//            this.playerY += 5;
//        }
//        if((GameWindow.isLeftPress == true) && (this.playerX  >= 0)){
//            this.playerX -= 5;
//        }
//        if((GameWindow.isRightPress == true) && (this.playerImage.getWidth() + this.playerX  <= 384+2)){
//            this.playerX += 5;
        for (int i =0;i<this.bullets.size();i++){
            PlayerBullet bullet = this.bullets.get(i);
            bullet.run();
        }
    }



    //
    private void renderAll() {
        this.repaint();
    }
}
