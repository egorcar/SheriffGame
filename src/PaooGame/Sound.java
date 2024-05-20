package PaooGame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    public Sound(){
        soundURL[0] = getClass().getResource("/sounds/TheGoodtheBadandtheUgly.wav");
        soundURL[1] = getClass().getResource("/sounds/plop3.wav");
        soundURL[2] = getClass().getResource("/sounds/knifeStab.wav");
        soundURL[3] = getClass().getResource("/sounds/knifeSwing.wav");
        soundURL[4] = getClass().getResource("/sounds/hurt.wav");
        soundURL[5] = getClass().getResource("/sounds/death.wav");
        soundURL[6] = getClass().getResource("/sounds/shot1.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
        }
    }

    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
