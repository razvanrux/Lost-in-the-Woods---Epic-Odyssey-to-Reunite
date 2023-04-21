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

    public int checkObject(entity entity, boolean player)
    {
        int index=999;
        for (int i=0; i<=gp.obj.length-1;i++)
        {
            if (gp.obj[i] != null )
            {
                // Selecting the entity's solid area POS
                entity.solid.x= entity.worldX + entity.solid.x;
                entity.solid.y= entity.worldY + entity.solid.y;

                // Selecting the specific object's area POS
                gp.obj[i].solidArea.x=gp.obj[i].worldX+gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y=gp.obj[i].worldY+gp.obj[i].solidArea.y;

                switch(entity.direction)
                {
                    case "up":
                        entity.solid.y -= entity.speed;
                        //this if function checks when the two rectangles intersect
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "up-right":
                        entity.solid.y -= entity.speed;
                        entity.solid.x += entity.speed;
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "up-left":
                        entity.solid.y -= entity.speed;
                        entity.solid.x -= entity.speed;
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }

                        }
                        break;

                    case "down":
                        entity.solid.y += entity.speed;
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "down-right":
                        entity.solid.y += entity.speed;
                        entity.solid.x += entity.speed;
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "down-left":
                        entity.solid.y += entity.speed;
                        entity.solid.x -= entity.speed;
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solid.x -= entity.speed;
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solid.x += entity.speed;
                        if (entity.solid.intersects(gp.obj[i].solidArea))
                        {
                            //if the object has collision then this sets it to true
                            if (gp.obj[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            //we're only allowing the player to use the items, NPCs, enemies etc. are not able to do so
                            if (player==true)
                            {
                                index = i;
                            }
                        }
                        break;

                }
                //we're resetting the values so they don't just increase everytime
                entity.solid.x=entity.solidAreaDefaultX;
                entity.solid.y=entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x=gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y=gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}
