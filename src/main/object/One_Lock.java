package main.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class One_Lock extends MasterObject{
    public One_Lock(){
        name = "Common Lock";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/1_lock.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}
