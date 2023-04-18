package main;
import entity.entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp)
    {
        this.gp=gp;
    }
    public void checkTile(entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.solid.x;
        int entityRightWorldX = entity.worldX + entity.solid.x + entity.solid.width;
        int entityTopWorldY = entity.worldY + entity.solid.y;
        int entityBottomWorldY = entity.worldY + entity.solid.y + entity.solid.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow= entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) //HERE COMES THE DIAGONAL MADNESS
        {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;

            case "up-right":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;

            case "up-left":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;


            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;

            case "down-right":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;

            case "down-left":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }

                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;
        }
    }
}
