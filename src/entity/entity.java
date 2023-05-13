package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class entity {
    public BufferedImage entity_image;
    public static int worldX, worldY;
    public double speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, stand1, stand2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNumber=1;
    public Rectangle solid;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean collisionOn = false;
}
