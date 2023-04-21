package main.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class One_Chest extends MasterObject{
    public One_Chest(){
        name = "Common Chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/1_chest.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
