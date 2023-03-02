package main;

import entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed,attacking;

    public KeyHandler(GamePanel gp){
        this.gp=gp;
    }

    UI ui = new UI(gp);
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_H){
            attacking=true;
        }
        if(code == KeyEvent.VK_W){
            upPressed=true;
        }
        if(code == KeyEvent.VK_S){
            downPressed= true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed=true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed= true;
        }
        if(code == KeyEvent.VK_P){
           if (gp.gameState== gp.playState){
               gp.gameState=gp.pauseState;
           }
           else if (gp.gameState== gp.pauseState) {
               gp.gameState=gp.playState;
           }
        }
        if (gp.gameState==gp.titleState){

        if(code == KeyEvent.VK_W){
            gp.ui.comnum--;
            if(gp.ui.comnum<0){
                gp.ui.comnum=1;
            }
        }
        if(code == KeyEvent.VK_S){
            gp.ui.comnum++;
            if(gp.ui.comnum>1){
                gp.ui.comnum=0;
            }
        }
            if(code == KeyEvent.VK_ENTER){
                if (gp.ui.comnum==0){
                    gp.gameState=gp.playState;
                }
                if (gp.ui.comnum==1){
                    System.exit(0);
                }

            }
        }
        }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

//        if(code == KeyEvent.VK_H){
//            attacking=false;}

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed= false;
        }
    }
}
