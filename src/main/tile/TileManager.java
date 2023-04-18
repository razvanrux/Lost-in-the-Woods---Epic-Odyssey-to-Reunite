package main.tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public tile[] tile;
    public int[][] mapTileNumber;

    public TileManager(GamePanel gp)
    {
        this.gp=gp;
        tile = new tile[14]; //the max amount of tiles we can have - will increase it later ofc
        mapTileNumber= new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/1_TUTORIAL.txt");
    }
    public void getTileImage()
    {
        try{
            tile[0]=new tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tile[1]=new tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision=true;

            tile[2]=new tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[2].collision=true;

            tile[3]=new tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

            tile[4]=new tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/dirt.png"));

            tile[5]=new tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[5].collision=true;

            tile[6]=new tile();
            tile[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/apple_tree_full.png"));
            tile[6].collision=true;

            tile[7]=new tile();
            tile[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/apple_tree_half.png"));
            tile[7].collision=true;

            tile[8]=new tile();
            tile[8].image= ImageIO.read(getClass().getResourceAsStream("/tiles/apple_tree_empty.png"));
            tile[8].collision=true;

            tile[9]=new tile();
            tile[9].image= ImageIO.read(getClass().getResourceAsStream("/tiles/apple_tree_full-dirt.png"));
            tile[9].collision=true;

            tile[10]=new tile();
            tile[10].image= ImageIO.read(getClass().getResourceAsStream("/tiles/apple_tree_half-dirt.png"));
            tile[10].collision=true;

            tile[11]=new tile();
            tile[11].image= ImageIO.read(getClass().getResourceAsStream("/tiles/apple_tree_empty-dirt.png"));
            tile[11].collision=true;

            tile[12]=new tile();
            tile[12].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree-dirt.png"));
            tile[12].collision=true;

            tile[13]=new tile();
            tile[13].image= ImageIO.read(getClass().getResourceAsStream("/tiles/gravel.png"));
            tile[13].collision=false;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String FilePath)
        {
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
                    mapTileNumber[col][row] = num;
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
    public void draw(Graphics2D g2)
    {
        int worldCol=0;
        int worldRow=0;
        //making the camera work - the player is stuck in the center but the world moves around him
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNumb = mapTileNumber[worldCol][worldRow];
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
