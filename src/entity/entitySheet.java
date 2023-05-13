package entity;

import java.awt.image.BufferedImage;

public class entitySheet {
    public BufferedImage e_image;
    final int originalTileSize = 16; //16x16 times - default size for the characters, NPCs, etc.
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //16*3=48x48 tile
    public entitySheet(BufferedImage buffImg)
    {
        // In order to be able to read the images
        e_image = buffImg;
    }
    public BufferedImage crop(int x, int y) {
        return e_image.getSubimage(x * originalTileSize, y * originalTileSize, originalTileSize, originalTileSize);
    }
}
