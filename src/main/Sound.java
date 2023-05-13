package main;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL [30];

    public Sound()
    {
        //implementing sounds
        soundURL[0] = getClass().getResource("/res/sound/main menu.wav");

        soundURL[1] = getClass().getResource("/res/sound/Abandoned City.wav");
        soundURL[2] = getClass().getResource("/res/sound/1st.wav");
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
