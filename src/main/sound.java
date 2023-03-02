package main;

import java.net.URL;
import javax.sound.sampled.*;
public class sound {
    Clip clip;
    URL soundURL[]= new URL[20];
    public sound(){
        soundURL[0]=getClass().getResource("/sound/Max's Adventure.wav");

    }
    public void setfile(int i){
        try{AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip= AudioSystem.getClip();
            clip.open(ais);

        }catch(Exception e){

    }}
    public void start(){
    clip.start();
    }

    public void loop(){
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
    clip.stop();
    }
}
