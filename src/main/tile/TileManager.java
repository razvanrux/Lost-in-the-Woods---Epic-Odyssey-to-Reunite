package main.tile;

import main.GamePanel;
import main.object.MasterObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public tile[] tile;
    public int[][][] mapTileNumber;
    public static int currentMap=0;
    public final int maxMaps = 5; //Number

    public TileManager(GamePanel gp)
    {
        this.gp=gp;
        tile = new tile[20]; //the max amount of tiles we can have - will increase it later ofc
        mapTileNumber= new int[maxMaps][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
       // loadMap("/maps/level4.txt");
        loadAllMaps();
    }

    public static int getMapID()
    {
        return currentMap;
    }

    public static void setMapID(int set)
    {
        currentMap=set;
    }



    public void getTileImage()
    {
        try{
            TileSet tiles = new TileSet(ImageIO.read(TileManager.class.getResourceAsStream("/tiles/Untitled.png")));

            tile[0]=new tile();
            tile[0].image= tiles.crop(0,0);

            tile[1]=new tile();
            tile[1].image=tiles.crop(1,0);
            tile[1].collision=true;

            tile[2]=new tile();
            tile[2].image= tiles.crop(2,0);
            tile[2].collision=true;

            tile[3]=new tile();
            tile[3].image= tiles.crop(3,0);

            tile[4]=new tile();
            tile[4].image= tiles.crop(4,0);

            tile[5]=new tile();
            tile[5].image= tiles.crop(5,0);
            tile[5].collision=true;

            tile[6]=new tile();
            tile[6].image= tiles.crop(0,1);
            tile[6].collision=true;

            tile[7]=new tile();
            tile[7].image= tiles.crop(1,1);
            tile[7].collision=true;

            tile[8]=new tile();
            tile[8].image= tiles.crop(2,1);
            tile[8].collision=true;

            tile[9]=new tile();
            tile[9].image= tiles.crop(3,1);
            tile[9].collision=true;

            tile[10]=new tile();
            tile[10].image= tiles.crop(4,1);
            tile[10].collision=true;

            tile[11]=new tile();
            tile[11].image= tiles.crop(5,1);
            tile[11].collision=true;

            tile[12]=new tile();
            tile[12].image= tiles.crop(0,2);
            tile[12].collision=true;

            tile[13]=new tile();
            tile[13].image= tiles.crop(1,2);
            tile[13].collision=false;

            tile[14]=new tile();                          //LAVA
            tile[14].image= tiles.crop(2,2);
            tile[14].collision=true;

            tile[15]=new tile();                          //TELEPORTER
            tile[15].image= tiles.crop(3,2);
            tile[15].collision=false;

            tile[16]=new tile();                          //SPAWNER
            tile[16].image= tiles.crop(4,2);
            tile[16].collision=false;

            tile[17]=new tile();                          //WOOD
            tile[17].image= tiles.crop(5,2);
            tile[17].collision=false;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String FilePath, int currentMap)
        {
            System.out.println(FilePath);
            MasterObject.load();
        try{
            InputStream is = getClass().getResourceAsStream(FilePath);
            BufferedReader br = new BufferedReader(new InputStreamReader((is)));
            int col=0;
            int row=0;
                while (col<gp.maxWorldCol && row< gp.maxWorldRow)
                {
                    String line = br.readLine(); //reading a line from the text
                    while (col<gp.maxWorldCol)
                    {
                        String[] numbers = line.split(" "); //extracting number by number, skipping the spaces
                        int num = Integer.parseInt(numbers[col]); // string <-> int
                        mapTileNumber[currentMap][col][row] = num;
                        col++;
                    }
                    if (col== gp.maxWorldCol)
                    {
                        col=0;
                        row++;
                    }
                }
            br.close();
        }

        catch(IOException e)
        {
        }
    }

    public void loadAllMaps() {
        for (int ceva = 0; ceva<maxMaps;ceva++)
        {
            loadMap("/maps/level"+ceva+".txt", ceva);
        }
    }

    public void draw(Graphics2D g2)
    {
        int worldCol=0;
        int worldRow=0;
        //making the camera work - the player is stuck in the center but the world moves around him
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNumb = mapTileNumber[getMapID()][worldCol][worldRow];
            int worldx= worldCol*gp.tileSize;
            int worldy=worldRow*gp.tileSize;
            int screenX=worldx-gp.player.worldX + gp.player.screenX;
            int screenY=worldy-gp.player.worldY+gp.player.screenY;

            if (
                    worldx + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldx - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldy + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldy - gp.tileSize < gp.player.worldY + gp.player.screenY
            )
            //drawing only around the player until it meets the screen edges, not more - for efficiency’s sake
            {
                g2.drawImage(tile[tileNumb].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;
            if (worldCol==gp.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
