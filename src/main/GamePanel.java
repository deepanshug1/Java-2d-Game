package main;
import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import java.awt.*;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
    //for screen settings
    final int originalTileSize = 16;
    //this is for our tile size i.e., 16*16 pixel
    final int scale = 3;
    // to scale 16 by 3 = 48 pixels
    public int gameState;
    public final int playState=1;
    public final int pauseState=2;
    public final int endState = 3;

    public final int titleState = 0;
    public final int tileSize = originalTileSize*scale;
    // now its 48*48 pixels
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow;
    //World
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldwidth=tileSize*maxWorldRow;
    public final int worldheight=tileSize*maxWorldCol;


    //setting fps for our game
    int FPS = 60;
    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    sound music = new sound();
    sound sfz = new sound();

    public UI ui = new UI(this);
    public Player player = new Player(this,keyH);

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter asetter = new AssetSetter(this);
    public SuperObject obj[]= new SuperObject[10] ;

    public Entity npc[]= new Entity[10];
    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize((new Dimension(screenWidth,screenHeight)));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        asetter.setObject();
        asetter.setNPC();
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        playMusic(0);
        gameState= titleState;

    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        // as our time is in nano seconds so it will draw screen in every 16 million
        // nano seconds to give us 60 fps in 1 billion nano seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {


            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if(gameState==playState){
        //to change player position by speed jitne pixels
        player.update();
            for (int i =0;i<npc.length;i++){
                if (npc[i] != null){
                    npc[i].update();
                }}}
        if (gameState == pauseState) {
        }


    }
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            if (gameState == titleState) {
                ui.draw(g2);
            }
            else {
                tileM.draw(g2);

                for (int i = 0; i < obj.length; i++) {
                    if (obj[i] != null) {
                        obj[i].draw(g2, this);
                    }
                }

                for (int i = 0; i < npc.length; i++) {
                    if (npc[i] != null) {
                        npc[i].draw(g2);
                    }
                }

                player.draw(g2);
                ui.draw(g2);
                g2.dispose();

            }
        }
    public void playMusic(int i){
        music.setfile(i);
        music.start();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void sfx(int i){
        sfz.setfile(i);
        sfz.start();
    }
}

