package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject{

    //methods

    //set-up b-ground
    public Background(){
        super();
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position.set(0,600 -this.image.getHeight());
        this.velocity.set(0,1);
    }

    //b-ground up
    @Override
    public void run(){
        super.run();
        this.limitPosition();
    }


    public void limitPosition() {
        if (this.position.y >= 0){
            this.position.y = 0;
        }
    }
}
