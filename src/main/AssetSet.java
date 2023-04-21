package main;

import main.object.One_Chest;
import main.object.One_Key;
import main.object.One_Lock;

public class AssetSet {
    GamePanel gp;
    public AssetSet(GamePanel gp)
    {
        this.gp=gp;
    }
    public void setObject()
    {
        gp.obj[0]= new One_Key();
        gp.obj[0].worldX = 46 * gp.tileSize;
        gp.obj[0].worldY = 83 * gp.tileSize;
        gp.obj[1]= new One_Lock();
        gp.obj[1].worldX = 43 * gp.tileSize;
        gp.obj[1].worldY = 28 * gp.tileSize;
        gp.obj[2]= new One_Chest();
        gp.obj[2].worldX = 37 * gp.tileSize;
        gp.obj[2].worldY = 83 * gp.tileSize;
    }
}
