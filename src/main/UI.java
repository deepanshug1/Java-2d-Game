package main;

import java.awt.*;

import java.awt.Color;

public class UI {
    GamePanel gp;

    Graphics2D g2;

    Font arial_40,arial_80B;

    public int comnum=0;

    public boolean messageOn = false;
    public String message = "";
    public boolean messageOn1 = false;
    public String message1 = "";
    public int messagecounter=0;
    public int messagecounter1=0;

    public UI(GamePanel gp){
        this.gp=gp;

        arial_40= new Font("Arial",Font.PLAIN, 40);
    }
    public void showMessage(String text) {
        message = text;
        messageOn = true;

    }
    public void showMessage2(String text) {
        message1 = text;
        messageOn1 = true;

    }

    public void draw(Graphics2D g2){
         this.g2= g2;
         g2.setFont(arial_40);
         g2.setColor(Color.BLACK);

        if(messageOn){
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
            g2.setColor(Color.white);
            g2.drawString(message, gp.tileSize*7, gp.tileSize*5);
            messagecounter++;
            if (messagecounter>90){
                messageOn= false;
                messagecounter=0;
            }

        }
        if(messageOn1){
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.setColor(Color.white);
            g2.drawString(message1, gp.tileSize*6, gp.tileSize*6);
            messagecounter1++;
            if (messagecounter1>90){
                messageOn1= false;
                messagecounter1=0;
            }

        }
        if (gp.gameState==gp.pauseState){
            drawpauseScreen();
        }
        if (gp.gameState==gp.titleState){
            drawtitleScreen();
        }
        if (gp.gameState==gp.endState){
            drawendScreen();
        }
        else if (gp.gameState==gp.playState) {
        }


    }

    public void drawpauseScreen(){
        this.g2=g2;
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        String text1= "PAUSED";
        int x1= centerx(text1);
        int y1= gp.screenHeight/2;
        g2.drawString(text1,x1,y1);
    }

    public void drawendScreen(){
        this.g2=g2;
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        String text1= "THE END!!!";
        int x1= centerx(text1);
        int y1= gp.screenHeight/2;
        g2.drawString(text1,x1,y1);
    }

    public void drawtitleScreen() {

        g2.setColor(new Color(0,150,120));
        g2.fillRect(0,0, gp.screenWidth, 2*(gp.screenHeight/3)-30);

        g2.setColor(new Color(102,90,60));
        g2.fillRect(0,2*gp.screenHeight/3-30, gp.screenWidth, gp.screenHeight/3+50);


        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        g2.setColor(Color.white);
        String text2 = "Max's Adventure";
        int x2= centerx(text2);
        int y2= gp.tileSize*2;
        g2.drawString(text2,x2,y2);

        g2.setColor(Color.black);
        g2.drawString(text2,x2+2,y2+2);

        //character images
        x2=gp.screenWidth/2-120;
        y2+=gp.tileSize;
        g2.drawImage(gp.player.right1,x2,y2,gp.tileSize*5,gp.tileSize*5,null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        g2.setColor(Color.white);
        text2 ="NEW GAME";
        x2= centerx(text2);
        y2 += gp.tileSize*5.8;
        g2.drawString(text2,x2,y2);
        if (comnum==0){
            g2.drawString(">",x2-gp.tileSize,y2);
        }

        text2 ="QUIT";
        x2= centerx(text2);
        y2 += gp.tileSize*1.8;
        g2.drawString(text2,x2,y2);
        if (comnum==1){
            g2.drawString(">",x2-gp.tileSize,y2);
        }

    }
    public int centerx(String text){
        int length= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2-length/2;
        return x;
    }

}

