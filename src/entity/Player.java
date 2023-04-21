package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int Common_Key=0;


    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);

        solid = new Rectangle(0,0,48,48); //this is for the player collision - it also has X, Y, etc. variables
        solid.x=8;
        solid.y=16;
        solid.width=32;
        solid.height=32;
        solidAreaDefaultX= solid.x;
        solidAreaDefaultY= solid.y;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues()
    {
        worldX = 910;
        worldY = 4300;
        speed=10;
        direction="stand";
    }
    public void getPlayerImage()
    {
        try{
            stand1=ImageIO.read(getClass().getResourceAsStream("/player/player_stand1.png"));
            stand2=ImageIO.read(getClass().getResourceAsStream("/player/player_stand2.png"));
            up1=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_up1.png"));
            up2=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_up2.png"));
            down1=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_down1.png"));
            down2=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_down2.png"));
            left1=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_left1.png"));
            left2=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_left2.png"));
            right1=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_right1.png"));
            right2=ImageIO.read(getClass().getResourceAsStream("/player/player_walk_right2.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed)
        {
            if (keyH.upPressed)
            {
                if (keyH.rightPressed)
                {
                    direction="up-right";
                }
                else if (keyH.leftPressed)
                {
                    direction="up-left";
                }
                else {
                    direction = "up";
                }
            }
            else if (keyH.downPressed)
            {
                if (keyH.rightPressed)
                {
                    direction="down-right";
                }
                else if (keyH.leftPressed)
                {
                    direction="down-left";
                }
                else {
                    direction = "down";
                }

            }
            else if (keyH.leftPressed)
            {
                direction="left";
            }
            else if (keyH.rightPressed)
            {
                direction="right";
            }
        }
        else {
            direction="stand";
        }


        // Collision checker heheh
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //Check the collision with the objects
        int objIndex = gp.cChecker.checkObject(this, true);
        pickupObject(objIndex);

        //Collision is false, the player can freely move
        if (!collisionOn)
        {
            switch(direction)
            {
                case "up":
                    worldY -= speed;
                    break;
                case "up-right":
                    worldX +=(speed/1.2);
                    worldY -=(speed/1.2);
                    break;

                case "up-left":
                    worldX -=(speed/1.2);
                    worldY -=(speed/1.2);
                    break;

                case "down":
                    worldY += speed;
                    break;

                case "down-right":
                    worldX +=speed/1.2;
                    worldY +=speed/1.2;
                    break;

                case "down-left":
                    worldX -=speed/1.2;
                    worldY +=speed/1.2;
                    break;

                case "left":
                    worldX -=speed;
                    break;

                case "right":
                    worldX +=speed;
                    break;

            }
        }

        spriteCounter++; //updating the spriteCounter which is updating FPS times per second
        if (spriteCounter>20)
        {
            if (spriteNumber==1)
            {
                spriteNumber=2;
            }
            else if (spriteNumber==2)
            {
                spriteNumber=1;
            }
            spriteCounter=0;
        }
        //by making the spriteCounter hit 20 we change the image once per 1/3 second (0.33)
    }
    public void pickupObject(int i)
    {
        if (i!=999)
        {
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Common Key":
                    Common_Key++;
                    System.out.println();
                    System.out.println("Picked up a Common Key!");
                    System.out.println("Common Key count: "+Common_Key);
                    gp.obj[i]=null;
                    break;
                case "Common Chest":
                    break;
                case "Common Lock":
                    if (Common_Key>0)
                    {
                        gp.obj[i]=null;
                        Common_Key--;
                        System.out.println();
                        System.out.println("Common Key used!");
                        System.out.println("Common Key count: "+Common_Key);
                    }
                    break;
            }
        }
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image=null;
        switch(direction)
        {
            case "up":
                if (spriteNumber==1)
                {
                    image=up1;
                }
                if (spriteNumber==2)
                {
                    image=up2;
                }
                break;
            case "down":
                if (spriteNumber==1)
                {
                    image=down1;
                }
                if (spriteNumber==2)
                {
                    image=down2;
                }
                break;
            case "left", "down-left", "up-left":
                if (spriteNumber==1)
                {
                    image=left1;
                }
                if (spriteNumber==2)
                {
                    image=left2;
                }
                break;
            case "right", "down-right", "up-right":
                if (spriteNumber==1)
                {
                    image=right1;
                }
                if (spriteNumber==2)
                {
                    image=right2;
                }
                break;


            case "stand":
                if (spriteNumber==1)
                {
                    image=stand1;
                }
                if (spriteNumber==2)
                {
                    image=stand2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); // null is image observer
    }


}
