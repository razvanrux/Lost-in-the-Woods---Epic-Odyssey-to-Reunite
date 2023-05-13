package main;

import java.awt.image.BufferedImage;

public class Sheet {
    public BufferedImage masterobject;
    final int originalTileSize = 16; //16x16 times - default size for the characters, NPCs, etc.
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //16*3=48x48 tile
    public Sheet(BufferedImage buffImg)
    {
        // In order to be able to read the images
        masterobject = buffImg;
    }
    public BufferedImage crop(int x, int y) {
        return masterobject.getSubimage(x * originalTileSize, y * originalTileSize, originalTileSize, originalTileSize);
    }
}
