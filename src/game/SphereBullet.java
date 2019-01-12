package game;

import game.enemy.Enemy;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SphereBullet extends GameObject implements Physics {

    BoxColider boxColider;

    public SphereBullet() {
//        BufferedImage image = SpriteUtils.loadImage("assets/images/sphere-bullets/0.png");
//        this.renderer = new SingleImageRenderer(image);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/3.png"));
        this.renderer = new Animation(images);
        this.velocity.set(0, -7);
        this.boxColider = new BoxColider(this.position,30,30);
    }

    @Override
    public void run() {
        super.run();
        Enemy enemy = GameObject.findIntersected(Enemy.class,this.boxColider);
        if (enemy != null){
            enemy.deactive();
            new Enemy();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.getBoxColider();
    }
}
