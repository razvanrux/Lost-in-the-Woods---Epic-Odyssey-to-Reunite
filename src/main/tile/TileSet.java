package main.tile;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class TileSet {
    public BufferedImage TileSetImage;
    final int originalTileSize = 16; //16x16 times - default size for the characters, NPCs, etc.
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //16*3=48x48 tile
    public TileSet (BufferedImage cv)
    {
        TileSetImage=cv;
    }
    public BufferedImage crop (int x, int y)
    {
        return TileSetImage.getSubimage(x* originalTileSize, y* originalTileSize, originalTileSize, originalTileSize);
    }
}
