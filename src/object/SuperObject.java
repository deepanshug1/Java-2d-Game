package object;

import main.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision= false;
    public Rectangle solidArea = new Rectangle (0, 0, 48, 48) ;
    public int solidAreaDefaultX= 0;
    public int solidAreaDefaultY =0;
    public int worldx,worldy;

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldx-gp.player.worldx +gp.player.screenx;
        int screenY = worldy-gp.player.worldy +gp.player.screeny;

        if (worldx + gp.tileSize> gp.player.worldx - gp.player.screenx &&
                worldx - gp.tileSize<gp.player.worldx + gp.player.screenx &&
                worldy + gp.tileSize> gp.player.worldy - gp.player.screeny &&
                worldy - gp.tileSize< gp.player.worldy + gp.player.screeny){
            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize, null);}
    }

}
