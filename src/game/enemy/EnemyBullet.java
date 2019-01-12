package game.enemy;

import game.GameObject;
import game.Player;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {

    BoxColider boxColider;

    public EnemyBullet(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/green.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/red.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/white.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        this.renderer = new Animation(images);
//        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
//        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,3);
        this.boxColider = new BoxColider(this.position,30,30);
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersected(Player.class,this.boxColider);
        if (player != null){
            player.hpDecrease();
            this.deactive();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
