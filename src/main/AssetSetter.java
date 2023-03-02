package main;

import entity.NPC_OldMan;
import object.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0]= new apple();
        gp.obj[0].worldx=23*gp.tileSize;
        gp.obj[0].worldy=7*gp.tileSize;

        gp.obj[1] = new key();
        gp.obj[1].worldx = 23 * gp.tileSize;
        gp.obj[1].worldy = 40 * gp.tileSize;

        gp.obj[2] = new door();
        gp.obj[2].worldx = 10 * gp.tileSize;
        gp.obj[2].worldy = 11 * gp.tileSize;

        gp.obj[3] = new chest();
        gp.obj[3].worldx = 10 * gp.tileSize;
        gp.obj[3].worldy = 7 * gp.tileSize;

        gp.obj[4] = new monster();
        gp.obj[4].worldx = 10 * gp.tileSize;
        gp.obj[4].worldy = 12 * gp.tileSize;

        gp.obj[5] = new Sword();
        gp.obj[5].worldx = 36 * gp.tileSize;
        gp.obj[5].worldy = 8 * gp.tileSize;


    }

    public void setNPC(){
        gp.npc[0]=new NPC_OldMan(gp);
        gp.npc[0].worldx=gp.tileSize*21;
        gp.npc[0].worldy=gp.tileSize*21;



    }
}
