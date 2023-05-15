package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UI;
import main.obs.LocationObserver;
import main.obs.Observer;
import main.tile.TileManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends entity implements LocationObserver {
    private ArrayList<Observer> observers;
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    //Item checker
    public static int verify=0;

    UI ui = new UI(gp);


    //HELMET
    public BufferedImage
one_head_stand1, one_head_stand2,
one_head_down1, one_head_down2,
one_head_up1, one_head_up2,
one_head_left1, one_head_left2,
one_head_right1, one_head_right2; //Leather

    public BufferedImage
two_head_stand1, two_head_stand2,
two_head_down1, two_head_down2,
two_head_up1, two_head_up2,
two_head_left1, two_head_left2,
two_head_right1, two_head_right2; //Iron

    public BufferedImage
three_head_stand1, three_head_stand2,
three_head_down1, three_head_down2,
three_head_up1, three_head_up2,
three_head_left1, three_head_left2,
three_head_right1, three_head_right2; //Golden

    public BufferedImage
four_head_stand1, four_head_stand2,
four_head_down1, four_head_down2,
four_head_up1, four_head_up2,
four_head_left1, four_head_left2,
four_head_right1, four_head_right2; //PurpleMov



    //Chestplate
    public BufferedImage
one_chestplate_stand1, one_chestplate_stand2,
one_chestplate_down1, one_chestplate_down2,
one_chestplate_up1, one_chestplate_up2,
one_chestplate_left1, one_chestplate_left2,
one_chestplate_right1, one_chestplate_right2; //Leather

    public BufferedImage
two_chestplate_stand1, two_chestplate_stand2,
two_chestplate_down1, two_chestplate_down2,
two_chestplate_up1, two_chestplate_up2,
two_chestplate_left1, two_chestplate_left2,
two_chestplate_right1, two_chestplate_right2; //Iron

    public BufferedImage
three_chestplate_stand1, three_chestplate_stand2,
three_chestplate_down1, three_chestplate_down2,
three_chestplate_up1, three_chestplate_up2,
three_chestplate_left1, three_chestplate_left2,
three_chestplate_right1, three_chestplate_right2; //Golden

    public BufferedImage
four_chestplate_stand1, four_chestplate_stand2,
four_chestplate_down1, four_chestplate_down2,
four_chestplate_up1, four_chestplate_up2,
four_chestplate_left1, four_chestplate_left2,
four_chestplate_right1, four_chestplate_right2; //PurpleMov again



    //Boots
    public BufferedImage
one_boots_stand1, one_boots_stand2,
one_boots_down1, one_boots_down2,
one_boots_up1, one_boots_up2,
one_boots_left1, one_boots_left2,
one_boots_right1, one_boots_right2; //Leather

    public BufferedImage
two_boots_stand1, two_boots_stand2,
two_boots_down1, two_boots_down2,
two_boots_up1, two_boots_up2,
two_boots_left1, two_boots_left2,
two_boots_right1, two_boots_right2; //Iron

    public BufferedImage
three_boots_stand1, three_boots_stand2,
three_boots_down1, three_boots_down2,
three_boots_up1, three_boots_up2,
three_boots_left1, three_boots_left2,
 three_boots_right1, three_boots_right2; //Golden

    public BufferedImage
four_boots_stand1, four_boots_stand2,
 four_boots_down1, four_boots_down2,
 four_boots_up1, four_boots_up2,
four_boots_left1, four_boots_left2,
four_boots_right1, four_boots_right2; //kappa


    int Common_Key=0;
    int Uncommon_Key=0;
    int Rare_Key=0;
    int Ancient_Key=0;
    int aj=0;

    int one_h, one_c, one_b, two_h, two_c, two_b, three_h, three_c, three_b, four_h, four_c, four_b=0;


    public Player(GamePanel gp, KeyHandler keyH){
        observers = new ArrayList<Observer>();
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
        //UI ui = new UI(gp);
    }

    public static void setX(int cv)
    {
        worldX=cv;
    }
    public static void setY(int cv)
    {
        worldY=cv;
    }

    public void setDefaultValues()
    {
        worldX = 16*gp.tileSize;
        worldY = 90*gp.tileSize-10;
        speed=10;                                 //6 //SPEEDSET
        direction="stand";
    }
    public void getPlayerImage()
    {
        try {
            entitySheet player_movement = new entitySheet (ImageIO.read(Player.class.getResourceAsStream("/res/player/player.png")));
            stand1=player_movement.crop(0,0);
            stand2=player_movement.crop(1,0);
            down1=player_movement.crop(2,0);
            down2=player_movement.crop(3,0);
            left1=player_movement.crop(4,0);
            left2=player_movement.crop(5,0);
            right1=player_movement.crop(6,0);
            right2=player_movement.crop(7,0);
            up1=player_movement.crop(8,0);
            up2=player_movement.crop(9,0);
            one_head_stand1=player_movement.crop(0,1);
            one_head_stand2=player_movement.crop(1,1);
            one_head_down1=player_movement.crop(2,1);
            one_head_down2=player_movement.crop(3,1);
            one_head_left1=player_movement.crop(4,1);
            one_head_left2=player_movement.crop(5,1);
            one_head_right1=player_movement.crop(6,1);
            one_head_right2=player_movement.crop(7,1);
            one_head_up1=player_movement.crop(8,1);
            one_head_up2=player_movement.crop(9,1);
            one_chestplate_stand1=player_movement.crop(0,2);
            one_chestplate_stand2=player_movement.crop(1,2);
            one_chestplate_down1=player_movement.crop(2,2);
            one_chestplate_down2=player_movement.crop(3,2);
            one_chestplate_left1=player_movement.crop(4,2);
            one_chestplate_left2=player_movement.crop(5,2);
            one_chestplate_right1=player_movement.crop(6,2);
            one_chestplate_right2=player_movement.crop(7,2);
            one_chestplate_up1=player_movement.crop(8,2);
            one_chestplate_up2=player_movement.crop(9,2);
            one_boots_stand1=player_movement.crop(0,3);
            one_boots_stand2=player_movement.crop(1,3);
            one_boots_down1=player_movement.crop(2,3);
            one_boots_down2=player_movement.crop(3,3);
            one_boots_left1=player_movement.crop(4,3);
            one_boots_left2=player_movement.crop(5,3);
            one_boots_right1=player_movement.crop(6,3);
            one_boots_right2=player_movement.crop(7,3);
            one_boots_up1=player_movement.crop(8,3);
            one_boots_up2=player_movement.crop(9,3);
            two_head_stand1=player_movement.crop(0,4);
            two_head_stand2=player_movement.crop(1,4);
            two_head_down1=player_movement.crop(2,4);
            two_head_down2=player_movement.crop(3,4);
            two_head_left1=player_movement.crop(4,4);
            two_head_left2=player_movement.crop(5,4);
            two_head_right1=player_movement.crop(6,4);
            two_head_right2=player_movement.crop(7,4);
            two_head_up1=player_movement.crop(8,4);
            two_head_up2=player_movement.crop(9,4);
            two_chestplate_stand1=player_movement.crop(0,5);
            two_chestplate_stand2=player_movement.crop(1,5);
            two_chestplate_down1=player_movement.crop(2,5);
            two_chestplate_down2=player_movement.crop(3,5);
            two_chestplate_left1=player_movement.crop(4,5);
            two_chestplate_left2=player_movement.crop(5,5);
            two_chestplate_right1=player_movement.crop(6,5);
            two_chestplate_right2=player_movement.crop(7,5);
            two_chestplate_up1=player_movement.crop(8,5);
            two_chestplate_up2=player_movement.crop(9,5);
            two_boots_stand1=player_movement.crop(0,6);
            two_boots_stand2=player_movement.crop(1,6);
            two_boots_down1=player_movement.crop(2,6);
            two_boots_down2=player_movement.crop(3,6);
            two_boots_left1=player_movement.crop(4,6);
            two_boots_left2=player_movement.crop(5,6);
            two_boots_right1=player_movement.crop(6,6);
            two_boots_right2=player_movement.crop(7,6);
            two_boots_up1=player_movement.crop(8,6);
            two_boots_up2=player_movement.crop(9,6);
            three_head_stand1=player_movement.crop(0,7);
            three_head_stand2=player_movement.crop(1,7);
            three_head_down1=player_movement.crop(2,7);
            three_head_down2=player_movement.crop(3,7);
            three_head_left1=player_movement.crop(4,7);
            three_head_left2=player_movement.crop(5,7);
            three_head_right1=player_movement.crop(6,7);
            three_head_right2=player_movement.crop(7,7);
            three_head_up1=player_movement.crop(8,7);
            three_head_up2=player_movement.crop(9,7);
            three_chestplate_stand1=player_movement.crop(0,8);
            three_chestplate_stand2=player_movement.crop(1,8);
            three_chestplate_down1=player_movement.crop(2,8);
            three_chestplate_down2=player_movement.crop(3,8);
            three_chestplate_left1=player_movement.crop(4,8);
            three_chestplate_left2=player_movement.crop(5,8);
            three_chestplate_right1=player_movement.crop(6,8);
            three_chestplate_right2=player_movement.crop(7,8);
            three_chestplate_up1=player_movement.crop(8,8);
            three_chestplate_up2=player_movement.crop(9,8);
            three_boots_stand1=player_movement.crop(0,9);
            three_boots_stand2=player_movement.crop(1,9);
            three_boots_down1=player_movement.crop(2,9);
            three_boots_down2=player_movement.crop(3,9);
            three_boots_left1=player_movement.crop(4,9);
            three_boots_left2=player_movement.crop(5,9);
            three_boots_right1=player_movement.crop(6,9); //nice
            three_boots_right2=player_movement.crop(7,9);
            three_boots_up1=player_movement.crop(8,9);
            three_boots_up2=player_movement.crop(9,9);
            four_head_stand1=player_movement.crop(0,10);
            four_head_stand2=player_movement.crop(1,10);
            four_head_down1=player_movement.crop(2,10);
            four_head_down2=player_movement.crop(3,10);
            four_head_left1=player_movement.crop(4,10);
            four_head_left2=player_movement.crop(5,10);
            four_head_right1=player_movement.crop(6,10);
            four_head_right2=player_movement.crop(7,10);
            four_head_up1=player_movement.crop(8,10);
            four_head_up2=player_movement.crop(9,10);
            four_chestplate_stand1=player_movement.crop(0,11);
            four_chestplate_stand2=player_movement.crop(1,11);
            four_chestplate_down1=player_movement.crop(2,11);
            four_chestplate_down2=player_movement.crop(3,11);
            four_chestplate_left1=player_movement.crop(4,11);
            four_chestplate_left2=player_movement.crop(5,11);
            four_chestplate_right1=player_movement.crop(6,11);
            four_chestplate_right2=player_movement.crop(7,11);
            four_chestplate_up1=player_movement.crop(8,11);
            four_chestplate_up2=player_movement.crop(9,11);
            four_boots_stand1=player_movement.crop(0,12);
            four_boots_stand2=player_movement.crop(1,12);
            four_boots_down1=player_movement.crop(2,12);
            four_boots_down2=player_movement.crop(3,12);
            four_boots_left1=player_movement.crop(4,12);
            four_boots_left2=player_movement.crop(5,12);
            four_boots_right1=player_movement.crop(6,12);
            four_boots_right2=player_movement.crop(7,12);
            four_boots_up1=player_movement.crop(8,12);
            four_boots_up2=player_movement.crop(9,12);


           // entitySheet player_attacks = new entitySheet (ImageIO.read(Player.class.getResourceAsStream("/res/player/attacks.png")));
        } catch (IOException e) {
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
                    playerMoved();
                    break;
                case "up-right":
                    worldX +=(speed/1.2);
                    worldY -=(speed/1.2);
                    playerMoved();
                    break;

                case "up-left":
                    worldX -=(speed/1.2);
                    worldY -=(speed/1.2);
                    playerMoved();
                    break;

                case "down":
                    worldY += speed;
                    playerMoved();
                    break;

                case "down-right":
                    worldX +=speed/1.2;
                    worldY +=speed/1.2;
                    playerMoved();
                    break;

                case "down-left":
                    worldX -=speed/1.2;
                    worldY +=speed/1.2;
                    playerMoved();
                    break;

                case "left":
                    worldX -=speed;
                    playerMoved();
                    break;

                case "right":
                    worldX +=speed;
                    playerMoved();
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
    public int getCommon_Key()
    {
        return Common_Key;
    }
    public int getUncommon_Key()
    {
        return Uncommon_Key;
    }
    public int getRare_Key()
    {
        return Rare_Key;
    }
    public int getAncient_Key()
    {
        return Ancient_Key;
    }


    public void pickupObject(int i)
    {

        if (i!=999)
        {
            String objectName = gp.obj[TileManager.getMapID()][i].name;

            switch (objectName) {
                case "Common Key":
                    gp.setHelper(0);
                    gp.playEffect(21);
                    Common_Key++;
                    verify=1;
                    System.out.println();
                    System.out.println("Picked up a Common Key!");
                    System.out.println("Common Key count: "+Common_Key);
                    gp.obj[TileManager.getMapID()][i]=null;
                    break;
                case "Common Chest":
                    break;
                case "Common Lock":
                    gp.setHelper(0);
                    if (Common_Key>0)
                    {
                        gp.playEffect(20);
                        gp.obj[TileManager.getMapID()][i]=null;
                        verify=2;
                        Common_Key--;
                        System.out.println();
                        System.out.println("Common Key used!");
                        System.out.println("Common Key count: "+Common_Key);
                    }
                    else
                    {
                        gp.setHelper(0);
                        aj++;
                        verify=3;
                        if (aj==10) {
                            System.out.println("You need a Common Key to open this Lock!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    break;

                case "Uncommon Key":
                    gp.setHelper(0);
                    gp.playEffect(21);
                    Uncommon_Key++;
                    verify=4;
                    System.out.println();
                    System.out.println("Picked up a Common Key!");
                    System.out.println("Common Key count: "+Common_Key);
                    gp.obj[TileManager.getMapID()][i]=null;
                    break;

                case "Uncommon Lock":
                    gp.setHelper(0);
                    if (Uncommon_Key>0)
                    {
                        gp.playEffect(20);
                        gp.obj[TileManager.getMapID()][i]=null;
                        verify=5;
                        Uncommon_Key--;
                        System.out.println();
                        System.out.println("Uncommon Key used!");
                        System.out.println("Uncommon Key count: "+Uncommon_Key);
                    }
                    else
                    {
                        gp.setHelper(0);
                        aj++;
                        verify=3;
                        if (aj==10) {
                            System.out.println("You need a Common Key to open this Lock!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    break;

                case "Rare Key":
                    break;

                case "Rare Lock":
                    break;

                case "Ancient Key":
                    break;

                case "Ancient Lock":
                    break;




                case "Leather Helmet":
                    if (four_h==1 || three_h==1 || two_h==1 || one_h==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have a nicer Helmet or this one equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        one_h=1;
                        System.out.println();
                        System.out.println("Equipped Leather Helmet!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Leather Chestplate":
                    if (four_c==1 || three_c==1 || two_c==1 || one_c==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have a nicer Chestplate or this one equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        one_c=1;
                        System.out.println();
                        System.out.println("Equipped Leather Chestplate!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Leather Boots":
                    if (four_b==1 || three_b==1 || two_b==1 || one_b==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have nicer Boots or these ones equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        speed=speed+1/2;
                        one_b=1;
                        System.out.println();
                        System.out.println("Equipped Leather Boots!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Iron Helmet":
                    if (four_h==1 || three_h==1 || two_h==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have a nicer Helmet or this one equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        two_h=1;
                        System.out.println();
                        System.out.println("Equipped Iron Helmet!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Iron Chestplate":
                    if (four_c==1 || three_c==1 || two_c==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have a nicer Chestplate or this one equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                    two_c=1;
                    System.out.println();
                    System.out.println("Equipped Iron Chestplate!");
                    gp.obj[i]=null;
                    }
                    break;

                case "Iron Boots":
                    if (four_b==1 || three_b==1 || two_b==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have nicer Boots or these ones equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        speed=speed+1/2;
                        two_b=1;
                        System.out.println();
                        System.out.println("Equipped Iron Boots!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Golden Helmet":
                    if (four_h==1 || three_h==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have a nicer Helmet or this one equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        three_h=1;
                        System.out.println();
                        System.out.println("Equipped Golden Helmet!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Golden Chestplate":
                    if (four_c==1 || three_c==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have a nicer Chestplate or the same one equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        three_c=1;
                        System.out.println();
                        System.out.println("Equipped Golden Chestplate!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Golden Boots":
                    if (four_b==1 || three_b==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have nicer Boots or these ones equipped!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        speed=speed+1/2;
                        three_b=1;
                        System.out.println();
                        System.out.println("Equipped Golden Boots!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Unobtainium Helmet":
                    if (four_h==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have this Helmet!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else {
                        four_h = 1;
                        System.out.println();
                        System.out.println("Equipped Unobtainium Helmet!");
                        gp.obj[i] = null;
                    }
                    break;

                case "Unobtainium Chestplate":
                    if (four_c==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have this Chestplate!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        four_c=1;
                        System.out.println();
                        System.out.println("Equipped Unobtainium Chestplate!");
                        gp.obj[i]=null;
                    }
                    break;

                case "Unobtainium Boots":
                    if (four_b==1)
                    {
                        aj++;
                        if (aj==10) {
                            System.out.println("You already have these Boots!");
                        }
                        if (aj==100)
                        {
                            aj=0;
                        }
                    }
                    else
                    {
                        four_b=1;
                        speed=speed+2;
                        System.out.println();
                        System.out.println("Equipped Unobtainium Boots!");
                        gp.obj[i]=null;
                    }
                    break;

            }
        }
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image=null;
        BufferedImage head=null;
        BufferedImage chestplate=null;
        BufferedImage boots=null;
        switch(direction)
        {
            case "up":

                if (four_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=four_head_up1;
                    }
                    if (spriteNumber==2)
                    {
                        head=four_head_up2;
                    }
                }
                else if (three_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=three_head_up1;
                    }
                    if (spriteNumber==2)
                    {
                        head=three_head_up2;
                    }
                }
                else if (two_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=two_head_up1;
                    }
                    if (spriteNumber==2)
                    {
                        head=two_head_up2;
                    }
                }
                else if (one_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=one_head_up1;
                    }
                    if (spriteNumber==2)
                    {
                        head=one_head_up2;
                    }
                }

                if (four_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=four_boots_up1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=four_boots_up2;
                    }
                }
                else if (three_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=three_boots_up1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=three_boots_up2;
                    }
                }
                else if (two_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=two_boots_up1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=two_boots_up2;
                    }
                }
                else if (one_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=one_boots_up1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=one_boots_up2;
                    }
                }


                if (four_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=four_chestplate_up1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=four_chestplate_up2;
                    }
                }
                else if (three_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=three_chestplate_up1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=three_chestplate_up2;
                    }
                }
                else if (two_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=two_chestplate_up1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=two_chestplate_up2;
                    }
                }
                else if (one_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=one_chestplate_up1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=one_chestplate_up2;
                    }
                }


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

                if (four_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=four_head_down1;
                    }
                    if (spriteNumber==2)
                    {
                        head=four_head_down2;
                    }
                }
                else if (three_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=three_head_down1;
                    }
                    if (spriteNumber==2)
                    {
                        head=three_head_down2;
                    }
                }
                else if (two_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=two_head_down1;
                    }
                    if (spriteNumber==2)
                    {
                        head=two_head_down2;
                    }
                }
                else if (one_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=one_head_down1;
                    }
                    if (spriteNumber==2)
                    {
                        head=one_head_down2;
                    }
                }

                if (four_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=four_boots_down1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=four_boots_down2;
                    }
                }
                else if (three_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=three_boots_down1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=three_boots_down2;
                    }
                }
                else if (two_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=two_boots_down1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=two_boots_down2;
                    }
                }
                else if (one_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=one_boots_down1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=one_boots_down2;
                    }
                }


                if (four_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=four_chestplate_down1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=four_chestplate_down2;
                    }
                }
                else if (three_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=three_chestplate_down1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=three_chestplate_down2;
                    }
                }
                else if (two_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=two_chestplate_down1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=two_chestplate_down2;
                    }
                }
                else if (one_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=one_chestplate_down1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=one_chestplate_down2;
                    }
                }

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

                if (four_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=four_head_left1;
                    }
                    if (spriteNumber==2)
                    {
                        head=four_head_left2;
                    }
                }
                else if (three_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=three_head_left1;
                    }
                    if (spriteNumber==2)
                    {
                        head=three_head_left2;
                    }
                }
                else if (two_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=two_head_left1;
                    }
                    if (spriteNumber==2)
                    {
                        head=two_head_left2;
                    }
                }
                else if (one_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=one_head_left1;
                    }
                    if (spriteNumber==2)
                    {
                        head=one_head_left2;
                    }
                }

                if (four_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=four_boots_left1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=four_boots_left2;
                    }
                }
                else if (three_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=three_boots_left1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=three_boots_left2;
                    }
                }
                else if (two_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=two_boots_left1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=two_boots_left2;
                    }
                }
                else if (one_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=one_boots_left1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=one_boots_left2;
                    }
                }


                if (four_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=four_chestplate_left1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=four_chestplate_left2;
                    }
                }
                else if (three_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=three_chestplate_left1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=three_chestplate_left2;
                    }
                }
                else if (two_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=two_chestplate_left1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=two_chestplate_left2;
                    }
                }
                else if (one_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=one_chestplate_left1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=one_chestplate_left2;
                    }
                }

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

                if (four_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=four_head_right1;
                    }
                    if (spriteNumber==2)
                    {
                        head=four_head_right2;
                    }
                }
                else if (three_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=three_head_right1;
                    }
                    if (spriteNumber==2)
                    {
                        head=three_head_right2;
                    }
                }
                else if (two_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=two_head_right1;
                    }
                    if (spriteNumber==2)
                    {
                        head=two_head_right2;
                    }
                }
                else if (one_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=one_head_right1;
                    }
                    if (spriteNumber==2)
                    {
                        head=one_head_right2;
                    }
                }

                if (four_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=four_boots_right1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=four_boots_right2;
                    }
                }
                else if (three_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=three_boots_right1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=three_boots_right2;
                    }
                }
                else if (two_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=two_boots_right1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=two_boots_right2;
                    }
                }
                else if (one_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=one_boots_right1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=one_boots_right2;
                    }
                }


                if (four_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=four_chestplate_right1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=four_chestplate_right2;
                    }
                }
                else if (three_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=three_chestplate_right1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=three_chestplate_right2;
                    }
                }
                else if (two_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=two_chestplate_right1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=two_chestplate_right2;
                    }
                }
                else if (one_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=one_chestplate_right1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=one_chestplate_right2;
                    }
                }

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
                if (four_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=four_head_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        head=four_head_stand2;
                    }
                }
                else if (three_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=three_head_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        head=three_head_stand2;
                    }
                }
                else if (two_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=two_head_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        head=two_head_stand2;
                    }
                }
                else if (one_h==1)
                {
                    if (spriteNumber==1)
                    {
                        head=one_head_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        head=one_head_stand2;
                    }
                }

                if (four_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=four_boots_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=four_boots_stand2;
                    }
                }
                else if (three_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=three_boots_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=three_boots_stand2;
                    }
                }
                else if (two_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=two_boots_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=two_boots_stand2;
                    }
                }
                else if (one_b==1)
                {
                    if (spriteNumber==1)
                    {
                        boots=one_boots_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        boots=one_boots_stand2;
                    }
                }


                if (four_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=four_chestplate_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=four_chestplate_stand2;
                    }
                }
                else if (three_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=three_chestplate_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=three_chestplate_stand2;
                    }
                }
                else if (two_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=two_chestplate_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=two_chestplate_stand2;
                    }
                }
                else if (one_c==1)
                {
                    if (spriteNumber==1)
                    {
                        chestplate=one_chestplate_stand1;
                    }
                    if (spriteNumber==2)
                    {
                        chestplate=one_chestplate_stand2;
                    }
                }

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

        // Drawing the armour
        // If the player doesn't have any armour then the 3 BufferImages will be drawn, but they are null
        g2.drawImage(head, screenX, screenY, gp.tileSize, gp.tileSize, null);
        g2.drawImage(chestplate, screenX, screenY, gp.tileSize, gp.tileSize, null);
        g2.drawImage(boots, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    public void playerMoved() {
     // System.out.println("playerMoved");
        notifyObservers();
    }


    public void notifyObservers() {
        //System.out.println("notifyObservers");
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.ObserverUpdate();
        }
    }

}
