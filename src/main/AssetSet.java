package main;

import main.object.*;

// AssetSet is used to set different interactable objects on the maps
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

      //  gp.obj[3]= new One_Head();
       // gp.obj[3].worldX = 40 * gp.tileSize;
       // gp.obj[3].worldY = 33 * gp.tileSize;

      //  gp.obj[4]= new One_Chestplate();
     //   gp.obj[4].worldX = 42 * gp.tileSize;
      //  gp.obj[4].worldY = 33 * gp.tileSize;

      //  gp.obj[5]= new One_Boots();
     //   gp.obj[5].worldX = 44 * gp.tileSize;
      //  gp.obj[5].worldY = 33 * gp.tileSize;

      //  gp.obj[6]= new Two_Head();
     //   gp.obj[6].worldX = 40 * gp.tileSize;
      //  gp.obj[6].worldY = 36 * gp.tileSize;

       // gp.obj[7]= new Two_Chestplate();
    //    gp.obj[7].worldX = 42 * gp.tileSize;
      //  gp.obj[7].worldY = 36 * gp.tileSize;

      //  gp.obj[8]= new Two_Boots();
      //  gp.obj[8].worldX = 44 * gp.tileSize;
      //  gp.obj[8].worldY = 36 * gp.tileSize;

       // gp.obj[9]= new Three_Head();
       // gp.obj[9].worldX = 40 * gp.tileSize;
       // gp.obj[9].worldY = 39 * gp.tileSize;

       // gp.obj[10]= new Three_Chestplate();
      //  gp.obj[10].worldX = 42 * gp.tileSize;
      //  gp.obj[10].worldY = 39 * gp.tileSize;

       // gp.obj[11]= new Three_Boots();
      //  gp.obj[11].worldX = 44 * gp.tileSize;
       // gp.obj[11].worldY = 39 * gp.tileSize;

      //  gp.obj[12]= new Four_Head();
       // gp.obj[12].worldX = 40 * gp.tileSize;
       // gp.obj[12].worldY = 42 * gp.tileSize;

       // gp.obj[13]= new Four_Chestplate();
       // gp.obj[13].worldX = 42 * gp.tileSize;
       // gp.obj[13].worldY = 42 * gp.tileSize;

      //  gp.obj[14]= new Four_Boots();
       // gp.obj[14].worldX = 44 * gp.tileSize;
       // gp.obj[14].worldY = 42 * gp.tileSize;

    }
}
