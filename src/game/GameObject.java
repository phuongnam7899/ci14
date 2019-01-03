package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // static: quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void addNew(GameObject object) {
        gameObjects.add(object);
    }

    public static void clearAll() {
        gameObjects.clear();
    }

    public static void runAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i); // GameObject, Player, Background
            object.run(); // GameObject.run() || Player.run() || Background.run()
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.render(g);
        }
    }

    // dinh nghia doi tuong
    BufferedImage image;
    Vector2D position;
    Vector2D velocity;

    public GameObject() { //ham tao rong
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        addNew(this); // cho gameObject vao mang quan li
    }

    public void run() {
        this.position.add(this.velocity);
    }



    public void render(Graphics g) {
        if(this.image != null) {
            g.drawImage(this.image
                    , (int)this.position.x
                    , (int)this.position.y
                    , null);
        }
    }
}