package main.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class One_Key extends MasterObject{
    public One_Key(){
        name = "Common Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/1_key.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
