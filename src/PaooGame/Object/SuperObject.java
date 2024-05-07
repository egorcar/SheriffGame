package PaooGame.Object;

import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class SuperObject {
    public BufferedImage img;
    public String name;
    public boolean collision = false;
    public int worldX;
    public int worldY;
    private RefLinks refLink;

    public SuperObject(RefLinks refLink){
        this.refLink = refLink;
    }

    public void Draw(RefLinks refLink, Hero hero, Graphics g){
        int screenX = (int) (worldX - hero.worldX + hero.screenX);
        int screenY = (int) (worldY - hero.worldY + hero.screenY);
        if(worldX + Tile.TILE_WIDTH > hero.worldX - hero.screenX &&
                worldX - Tile.TILE_WIDTH < hero.worldX + hero.screenX &&
                worldY + Tile.TILE_WIDTH > hero.worldY - hero.screenY &&
                worldY - Tile.TILE_WIDTH < hero.worldY + hero.screenY){
            g.drawImage(img, screenX, screenY, TILE_WIDTH, TILE_HEIGHT, null);
        }
    }


}
