package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_OldMan extends Entity{
    public NPC_OldMan(GamePanel gp){
        super(gp);
        direction="down";
        speed = 1;
        getNPCImage();
    }
    public void setAction(){
        actionLockCounter++;
        if (actionLockCounter==120){


            Random random = new Random();
            int i = random.nextInt(100)+1;//pickup a number from 1 to 100
            if(i<=25){
                direction= "up";
            }
            if(i>25 && i<=50){
                direction="down";
            }
            if (i>50 && i<=75){
                direction = "left";
            }
            if (i>75 && i<=100){
                direction="right";
            }actionLockCounter=0;
        }
    }}
