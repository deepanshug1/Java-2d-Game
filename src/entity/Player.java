package entity;
import main.GamePanel;
import main.KeyHandler;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenx;
    public final int screeny;
    public int hasKey=0;
    public int hasSword=0;


    public Player(GamePanel gp,KeyHandler keyH){

        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenx = gp.screenWidth/2- (gp.tileSize/2);
        screeny = gp.screenHeight/2- (gp.tileSize/2);
        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = 18;
        solidArea.width = 16;
        solidArea.height = 16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        setDefaultValues();
        getPlayerImage();
        getPlayerattImage();
    }
    public void setDefaultValues(){
        worldx = gp.tileSize*23;
        worldy = gp.tileSize*21;
        speed = 4;
    direction = "down";  //default direction so any is fine

    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/maxb1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/maxb2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/maxf2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/maxf3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/maxl.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/maxl1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/maxr.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/maxr1.png"));
            deepanshi = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void getPlayerattImage(){
        try{
            attu = ImageIO.read(getClass().getResourceAsStream("/player/attd.png"));
            attd = ImageIO.read(getClass().getResourceAsStream("/player/attu.png"));
            attl = ImageIO.read(getClass().getResourceAsStream("/player/attl.png"));
            attr = ImageIO.read(getClass().getResourceAsStream("/player/attr.png"));
        }catch(IOException e){
            e.printStackTrace();
        }}

    public void update(){
        if(keyH.attacking){
            attacking();
        }
        else if (keyH.downPressed || keyH.leftPressed || keyH.upPressed || keyH.rightPressed){
        if (keyH.upPressed){
            direction = "up";
        }
        else if(keyH.downPressed){
            direction = "down";
        }
        else if(keyH.leftPressed){
            direction = "left";
        }
        else if(keyH.rightPressed) {
            direction = "right";
        }

            //check collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            int objIndex = gp.cChecker.checkObj(this, true);
            pickupObj(objIndex);

            int npcIndex=gp.cChecker.checkEntity(this,gp.npc);
            interactNPC(npcIndex);
            //if collision is false player moves
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
    }}
    public void attacking(){
        spriteCounter++;
     if (spriteCounter>25){
         keyH.attacking=false;
     }

    }
    public void pickupObj(int i){
        if (i!=999){
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "key":
                    hasKey++;
                    this.gp.ui.showMessage("You got a key!");
                    gp.obj[i] = null;
                    System.out.println("key: "+hasKey) ;
                    break;
                case "door":
                    if (hasKey > 0){
                        gp.obj[i] = null;
                        hasKey--;
                        this.gp.ui.showMessage("You opened the door!");
                        this.gp.ui.showMessage2("Here comes the Boss!!!");
                    }
                    else{
                    this.gp.ui.showMessage("You need a key!");}
                    System. out. println ("key: "+hasKey) ;
                    break;
                case "apple":
                    speed+= 3;
                    this.gp.ui.showMessage("Speed up!");
                    this.gp.ui.showMessage2("Apples are my favourite");
                    gp.obj[i] = null;
                    break;
                case "chest":
                    this.gp.ui.showMessage("You found Deepanshi!");
                    this.gp.ui.showMessage2("Game Over");
                    gp.obj[i] = null;
                    gp.gameState= gp.endState;
                    break;

                case "monster":
                    if (hasSword > 0){
                        gp.obj[i] = null;
                        hasSword--;
                    this.gp.ui.showMessage("Boss Defeated!");}
                    else{
                        this.gp.ui.showMessage("You need your sword!");}
                    System. out. println ("Sword destroyed") ;
                    break;

                case "Sword":
                    hasSword++;
                    this.gp.ui.showMessage("Found my Sword!");
                    this.gp.ui.showMessage2("lets defeat those monsters");
                    gp.obj[i] = null;
                    System.out.println("Sword") ;
                    break;
        }
    }}
    public void interactNPC(int i){
        if(i!=999){
            System.out.println("YOU ARE HITTING AN NPC!!");
        }
    }
    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(x,y,gp.titleSize,gp.titleSize);

        BufferedImage image = null;
        switch (direction){
            case "up":
                if (keyH.attacking==false){
                if(spriteNum ==1){image = up1;}
                if(spriteNum == 2){image = up2;}}
                else if (keyH.attacking==true){
                    image= attu;}


                break;
            case "down":
                if (keyH.attacking==false){
                if(spriteNum == 1){image = down1;}
                if(spriteNum == 2){image = down2;}}
                else if (keyH.attacking==true){
                    image= attd;}

                break;
            case "left":
                if (keyH.attacking==false){
                if(spriteNum == 1){image = left1;}
                if(spriteNum == 2){image = left2;}}
                else if (keyH.attacking==true){
                    image= attl;}

                break;
            case "right":
                if (keyH.attacking==false){
                if(spriteNum == 1){image = right1;}
                if (spriteNum == 2){image = right2;}}
                else if (keyH.attacking==true){
                    image= attr;}

                break;
        }
        g2.drawImage(image,screenx,screeny,gp.tileSize,gp.tileSize,null);

    }



}

