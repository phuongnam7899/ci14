package game;

import tklibs.SpriteUtils;

public class Player extends GameObject {
    Sphere sphereLeft;
    Sphere shereRight;

    //methods

    //setup player
    public Player() {
        super();
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(200,400);
        this.shereRight = new Sphere();
        this.sphereLeft = new Sphere();
        this.updateSpherePosition();
    }

    private void updateSpherePosition() {
        this.sphereLeft.position.set(this.position).add(-20,30);
        this.shereRight.position.set(this.position).add(30,30);
    }

    //player run
    @Override
    public void run() {
        super.run();
        this.move();
        this.limitPosition();
        this.fire();
        this.updateSpherePosition();
    }

    //player fire
    int count; // TODO: continue editing
    private void fire() {
        count++;
        if(count > 20) {
            if(GameWindow.isFirePress) {
                float startAngle =  -(float)Math.PI / 4;
                float endAngle = -3 * (float)Math.PI / 4;
                float offset = (endAngle - startAngle) / 4;
                for (int i = 0; i < 5; i++) {
                    PlayerBullet bullet = new PlayerBullet();
                    bullet.position.set(this.position.x - 15, this.position.y);
                    bullet.velocity.setAngle(startAngle + offset * i);
                    this.count = 0;
                }
            }
        }
    }

    private void limitPosition() {
        if (this.position.y < 0) {
            this.position.y = 0;
        }
        if (this.position.y > 600 - this.image.getHeight()) {
            this.position.y = 600 - this.image.getHeight();
        }
        if (this.position.x < 0) {
            this.position.x = 0;
        }
        if (this.position.x > 384 - this.image.getWidth()) {
            this.position.x = 384 - this.image.getWidth();
        }
    }

    private void move() {
        float vX=0;
        float vY=0;
        if (GameWindow.isUpPress) {
            vY = -5;
        }
        if (GameWindow.isDownPress) {
            vY = 5;
        }
        if (GameWindow.isLeftPress) {
            vX = -5;
        }
        if (GameWindow.isRightPress) {
            vX = 5;
        }
        this.velocity.set(vX,vY).setLength(5);
    }
}
