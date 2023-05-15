package main;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL [50];

    public Sound()
    {
        //implementing sounds
        //ID 0-19 game music
        soundURL[0] = getClass().getResource("/res/sound/tutorial.wav");
        soundURL[1] = getClass().getResource("/res/sound/Abandoned City.wav");
        soundURL[2] = getClass().getResource("/res/sound/1st.wav");
        soundURL[3] = getClass().getResource("/res/sound/1st.wav");
        soundURL[4] = getClass().getResource("/res/sound/1st.wav");
        soundURL[5] = getClass().getResource("/res/sound/1st.wav");
        soundURL[6] = getClass().getResource("/res/sound/main menu.wav");
        //ID 20-39 - sound effects
        soundURL[20]=getClass().getResource("/res/sound/lock.wav");
        soundURL[21]=getClass().getResource("/res/sound/keys.wav");
        //ID 39+ other (like walk sounds maybe?)
    }
    public void setFile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (IOException e)
        {

        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        if (clip !=null) {
            clip.stop();
        }
    }
}
