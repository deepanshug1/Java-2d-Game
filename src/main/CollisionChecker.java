package main;

import entity.Entity;
import entity.Player;


public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldx + entity.solidArea.x;
        int entityRightWorldX = entity.worldx + entity.solidArea.x +entity.solidArea.width;
        int entityTopWorldY = entity.worldy + entity.solidArea.y;
        int entityBottomWorldY = entity.worldy + entity.solidArea.y +  entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY /gp.tileSize;
        int tileNum1, tileNum2;
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;

                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;

                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;

                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;

                }
                break;
        }
    }
    public int checkObj(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {

            if (gp.obj[i] != null) {

                entity.solidArea.x = entity.worldx + entity.solidArea.x;
                entity.solidArea.y = entity.worldy + entity.solidArea.y;

                (gp.obj[i]).solidArea.x = (gp.obj[i]).worldx + (gp.obj[i]).solidArea.x;
                (gp.obj[i]).solidArea.y = (gp.obj[i]).worldy + (gp.obj[i]).solidArea.y;
                String str;
                switch ((str = entity.direction).hashCode()) {
                    case 3739: if (!str.equals("up"))
                    break;
                    entity.solidArea.y -= entity.speed;
                    if (entity.solidArea.intersects((gp.obj[i]).solidArea)) {
                        if ((gp.obj[i]).collision) {
                            entity.collisionOn = true;
                        }if (player)
                            index = i;
                    }  break;
                    case 3089570:
                        if (!str.equals("down"))
                            break;
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects((gp.obj[i]).solidArea)) {
                            if ((gp.obj[i]).collision) {
                                entity.collisionOn = true;
                        }
                            if (player)
                                index = i;
                    }  break;
                    case 3317767:
                        if (!str.equals("left"))
                            break;
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects((gp.obj[i]).solidArea)) {
                            if ((gp.obj[i]).collision) {
                                entity.collisionOn = true;
                        }
                            if (player)
                                index = i;
                    }  break;
                    case 108511772:
                        if (!str.equals("right"))
                            break;
                                  entity.solidArea.x += entity.speed;
                                    if (entity.solidArea.intersects((gp.obj[i]).solidArea)) {
                                        if ((gp.obj[i]).collision) {
                                            entity.collisionOn = true;
                        }
                                   if (player) {
                            index = i;
                        }
                    }
                        break; }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                (gp.obj[i]).solidArea.x = (gp.obj[i]).solidAreaDefaultX;
                (gp.obj[i]).solidArea.y = (gp.obj[i]).solidAreaDefaultY;
            }
        }
        return index;
    }
    public int checkEntity(Entity entity,Entity[] target){

        int index = 999;

        for (int i = 0; i < target.length; i++) {

            if (target[i] != null) {

                entity.solidArea.x = entity.worldx + entity.solidArea.x;
                entity.solidArea.y = entity.worldy + entity.solidArea.y;

                (target[i]).solidArea.x = (target[i]).worldx + (target[i]).solidArea.x;
                (target[i]).solidArea.y = (target[i]).worldy + (target[i]).solidArea.y;
                String str;
                switch ((str = entity.direction).hashCode()) {
                    case 3739: if (!str.equals("up"))
                        break;
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects((target[i]).solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }  break;
                    case 3089570:
                        if (!str.equals("down"))
                            break;
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects((target[i]).solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }  break;
                    case 3317767:
                        if (!str.equals("left"))
                            break;
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects((target[i]).solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }  break;
                    case 108511772:
                        if (!str.equals("right"))
                            break;
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects((target[i]).solidArea)) {
                            entity.collisionOn = true;
                            index = i;

                        }
                        break; }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                (target[i]).solidArea.x = (target[i]).solidAreaDefaultX;
                (target[i]).solidArea.y = (target[i]).solidAreaDefaultY;
            }
        }
        return index;
    }
    public void checkPlayer(Entity entity){
        entity.solidArea.x = entity.worldx + entity.solidArea.x;
        entity.solidArea.y = entity.worldy + entity.solidArea.y;

        gp.player.solidArea.x = gp.player.worldx + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldy + gp.player.solidArea.y;
        String str;
        switch ((str = entity.direction).hashCode()) {
            case 3739: if (!str.equals("up"))
                break;
                entity.solidArea.y -= entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }  break;
            case 3089570:
                if (!str.equals("down"))
                    break;
                entity.solidArea.y += entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }  break;
            case 3317767:
                if (!str.equals("left"))
                    break;
                entity.solidArea.x -= entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }  break;
            case 108511772:
                if (!str.equals("right"))
                    break;
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;

                }
                break; }

        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;

    }
    }

