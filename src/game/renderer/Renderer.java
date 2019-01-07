package game.renderer;

import game.GameObject;

import java.awt.*;

public abstract class Renderer {
    /**
     * Ve 1 anh // SingleImageRenderer
     * Ve hoat anh // Animation
     * Ve text // TextRenderer
     * ..
     * @param g
     * @param master
     */
    abstract public void render(Graphics g, GameObject master);
}
