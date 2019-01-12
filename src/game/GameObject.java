
package game;

import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {

    // thuoc tinh
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public boolean isActive;

    //static: quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void addNew(GameObject object) {
        gameObjects.add(object);
    }

    public static void clearAll() {
        gameObjects.clear();
    }

    public static void runAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if ( object.isActive){
                object.run();
            }
            else {
                if(object.getClass() == Player.class){
                    Player player = (Player)object;
                    player.deActiveSphere();
                }
            }
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.isActive){
                object.render(g);
            }
        }
    }



    //methods

    public GameObject() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.isActive = true;
        addNew(this); //cu tao moi thi cho gameobject vao mang quan li
    }

    public void run() {
        this.position.add(this.velocity);
    }

    public void render(Graphics g) {
        if(this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

    public static <E extends GameObject> E findIntersected (Class<E> cls, BoxColider boxColider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if ( cls.isAssignableFrom(object.getClass()) //class you want?
                && object instanceof Physics // physics?
                && ((Physics) object).getBoxColider().intersected(boxColider)// intersect?
                && object.isActive){
            return (E) object;
        }
    }
        return null;
    }
    public void deactive(){
        this.isActive = false;
    }
}