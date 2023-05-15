package main.object;

import main.GamePanel;
import main.Sheet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MasterObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;


    //Locks & Keys
    public static BufferedImage
    One_Key, Two_Key, Three_Key, Four_Key,
    One_Lock, Two_Lock, Three_Lock, Four_Lock;


    //Armour
    public static BufferedImage
    One_Head, Two_Head, Three_Head, Four_Head,
    One_Chestplate, Two_Chestplate, Three_Chestplate, Four_Chestplate,
    One_Boots, Two_Boots, Three_Boots, Four_Boots;

    // Load the assets

    public static void load()   
    {
        try {
            Sheet keys_lock = new Sheet (ImageIO.read(MasterObject.class.getResourceAsStream("/objects/key_lock.png")));
            One_Key= keys_lock.crop(0,0);
            Two_Key= keys_lock.crop(0,1);
            Three_Key= keys_lock.crop(0,2);
            Four_Key= keys_lock.crop(0,3);
            One_Lock= keys_lock.crop(1,0);
            Two_Lock= keys_lock.crop(1,1);
            Three_Lock= keys_lock.crop(1,2);
            Four_Lock= keys_lock.crop(1,3);

            Sheet armour = new Sheet (ImageIO.read(MasterObject.class.getResourceAsStream("/objects/armour_set.png")));
            One_Head= armour.crop(0,0);
            Two_Head= armour.crop(1,0);
            Three_Head= armour.crop(2,0);
            Four_Head= armour.crop(3,0);
            One_Chestplate= armour.crop(0,1);
            Two_Chestplate= armour.crop(1,1);
            Three_Chestplate= armour.crop(2,1);
            Four_Chestplate= armour.crop(3,1);
            One_Boots= armour.crop(0,2);
            Two_Boots= armour.crop(1,2);
            Three_Boots= armour.crop(2,2);
            Four_Boots= armour.crop(3,2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX=worldX-gp.player.worldX + gp.player.screenX;
        int screenY=worldY-gp.player.worldY+gp.player.screenY;

        if (
                worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY
            )
            //drawing only around the player until it meets the screen edges, not more - for efficiency’s sake
            {
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
        }
    }
