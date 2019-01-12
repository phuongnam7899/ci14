package game;

import game.enemy.Enemy;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;

import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    BoxColider boxColider;

    public PlayerBullet() {
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new Animation(images, 0);
        this.velocity.set(0, -7);
        this.boxColider = new BoxColider(this.position, 30, 30);

    }

    @Override
    public void run() {
        super.run();
        Enemy enemy = GameObject.findIntersected(Enemy.class, this.boxColider);
        this.limitPosition();
        if (enemy != null) {
            System.out.println("hit");
            enemy.deactive();
            new Enemy();
        }
    }
    private void limitPosition(){
        if (this.position.y < 0) {
            this.deactive();
        }
        if (this.position.y > 600 - 48) {
            this.deactive();
        }
        if (this.position.x < 0) {
            this.deactive();
        }
        if (this.position.x > 384 - 30) {
            this.deactive();
        }
    }


    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
