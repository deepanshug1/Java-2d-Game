package entity;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

// this class will be used for characters in our game
public class Entity {

    GamePanel gp;
    public int worldx,worldy;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,deepanshi;

    public BufferedImage attu,attd,attr,attl;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX,solidAreaDefaultY;
    public boolean collisionOn = false;
    public Entity(GamePanel gp){
        this.gp=gp;
    }
    public void setAction(){}
    public int actionLockCounter = 0 ;
    public void update(){
        setAction();
        collisionOn=false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObj(this, false);
        gp.cChecker.checkPlayer(this);
        if (collisionOn== false) {
            switch (direction) {
                case "up" -> worldy -= speed;
                case "down" -> worldy += speed;
                case "left" -> worldx -= speed;
                case "right" -> worldx += speed;
            }
        }
        spriteCounter++;
        if(spriteCounter > 12){
            if (spriteNum == 1){
                spriteNum =2;

            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;
        int screenX = worldx-gp.player.worldx +gp.player.screenx;
        int screenY = worldy-gp.player.worldy +gp.player.screeny;

        if (worldx + gp.tileSize> gp.player.worldx - gp.player.screenx &&
                worldx - gp.tileSize<gp.player.worldx + gp.player.screenx &&
                worldy + gp.tileSize> gp.player.worldy - gp.player.screeny &&
                worldy - gp.tileSize< gp.player.worldy + gp.player.screeny){
            switch (direction){
                case "up":
                    if(spriteNum ==1){
                        image = up1;
                    }
                    if(spriteNum == 2){
                        image = up2;
                    }

                    break;
                case "down":
                    if(spriteNum == 1){
                        image = down1;}
                    if(spriteNum == 2){
                        image = down2;

                    }

                    break;
                case "left":
                    if(spriteNum == 1){
                        image = left1;}
                    if(spriteNum == 2){
                        image = left2;
                    }
                    break;
                case "right":
                    if(spriteNum == 1){
                        image = right1;
                    }
                    if (spriteNum == 2){
                        image = right2;
                    }

                    break;

            }
            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize, null);}
    }
    public void getNPCImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_right_2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }





}
