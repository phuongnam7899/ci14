package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {

    //atributes

    public GamePanel gamePanel;
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;

    //methods

    //main
    public GameWindow(){
        this.setupWindow();
        this.creatGamePanel();
        this.setupListener();

        this.setVisible(true);
    }


    // key listen
    private void setupListener() {
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                //TODO:an phim
                if(e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //TODO:nha phim
                if(e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = false;
                }
            }
        });
    }


    private void creatGamePanel() {
//        GamePanel panel = new GamePanel();
        this.gamePanel = new GamePanel();
        this.gamePanel.setPreferredSize(new Dimension(800,600));
        this.add(this.gamePanel);
        this.pack();
    }


    private void setupWindow() {
//        this.setSize(800,600);

        this.setTitle("touhou");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
