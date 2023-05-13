package main;

import entity.Player;
import main.object.MasterObject;
import main.tile.TileManager;
import main.obs.Observer;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable , Observer{ //inherits JPanel
    //SCREEN SETTINGS
    //final int - you set a value for it - it won't change even if you try (and you get an error)

    final int originalTileSize = 16; //16x16 times - default size for the characters, NPCs, etc.
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //16*3=48x48 tile
    public final int maxScreenCol = 26;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    //48*26 = 1248 pixels
    //48*15 = 720 pixels
    //window will be 1248x720

    //WORLD settings
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;


    //FPS will be 60 so my shit $2 laptop can run it
    int FPS = 60;


    TileManager tileM= new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this,keyH);
    public CollisionChecker cChecker= new CollisionChecker(this);
    public AssetSet aSet = new AssetSet(this);
    public MasterObject obj[] = new MasterObject[20]; //the number of slots reserved for the assets you can see ingame
    //NOTE! This also represents how many objects can be seen on the screen at the same time!


    //SOUNDS
    Sound sound = new Sound();
    Sound sound_effects = new Sound();
    Sound walk_sounds = new Sound();
    //We need more Sound objects to play both music and effects at the same time


    public GamePanel()
    {

        this.setPreferredSize(new Dimension (screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // all drawing from this will be done offscreen
        this.addKeyListener(keyH);
        this.setFocusable(true);
        player.registerObserver(this);
    }
    public void SetupGame()
    {
        setMusic(0);
       // stopMusic(0);
        aSet.setObject();
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);

        gameThread.start();
    }

    @Override
    public void run() //creating a game loop
    {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        long lastTime = System.nanoTime();
        long timer=0;
        long currentTime;
        int drawCount=0;
        while (gameThread !=null)
        {
            // UPDATE : information such as player POV, etc.
            update();

            // DRAW : the screen with the up-to-date info
            repaint();

            drawCount++;
            currentTime = System.nanoTime();
            timer += (currentTime - lastTime);
            lastTime=currentTime;

            if (timer>=1000000000)
            {
                //System.out.println("X=" +Player.worldX);
              //  System.out.println("Y=" +Player.worldY);
               // System.out.println("MapID: " +TileManager.getMapID());
                drawCount=0;
                timer=0;
            }
            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime<0) //if we use all the allocated all the time there's no need to Sleep
                {
                    remainingTime=0;
                }

                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
    public void setMusic(int PlayingMusic)
    {
        playMusic(PlayingMusic);
    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //converting graphics to 2D

        //TILES
        tileM.draw(g2);

        //OBJECTS
        for (int i=0;i< obj.length;i++)
        {
            if (obj[i]!= null) //When the objects are not null, then we draw it! - or get the nullpointer error
            {
                obj[i].draw(g2, this);
            }
        }

        //PLAYER
        player.draw(g2);

        g2.dispose();
    }
    public void playMusic(int i)
    {
       // Sound sound = new Sound();
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(int i)
    {
        if (this.sound !=null) {
            sound.stop();
        }
    }
    public void playEffect(int i)
    {
        sound.setFile(i);
        sound.play();
    }

    public void ObserverUpdate() {
        int check = playerIsInCertainLocation();
       // System.out.println("Check= "+check);
        if (check != -1 )
        {
            TileManager.setMapID(check);
            sound.stop();
            setMusic(check);
        }
    }
    public int playerIsInCertainLocation() {
    //    System.out.println("Player Check");
        if (TileManager.getMapID()==0)
        {
            if (Player.worldX>=85*tileSize && Player.worldX<=86*tileSize && Player.worldY>=11*tileSize && Player.worldY<=13*tileSize)
            {
               // System.out.println("Yes");
                Player.setX(13*tileSize);
                Player.setY(11*tileSize);
                return 1;
            }
        }
        else if (TileManager.getMapID()==1)
        {

        }
        else if (TileManager.getMapID()==2)
        {

        }
        else if (TileManager.getMapID()==3)
        {

        }
        else if (TileManager.getMapID()==4)
        {

        }
        return -1;
    }
}
