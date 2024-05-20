package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class ITCactusTile extends InteractiveTile{

    public ITCactusTile(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
        this.worldX = Tile.TILE_WIDTH * x;
        this.worldY = Tile.TILE_HEIGHT * y;

        image = Assets.cactus;
        destructible = true;
    }

    public void Draw(RefLinks refLink, Hero hero, Graphics g) {
        //System.out.println("Good");
        int screenX = (int) (worldX - hero.worldX + hero.screenX);
        int screenY = (int) (worldY - hero.worldY + hero.screenY);
        if(worldX + Tile.TILE_WIDTH > hero.worldX - hero.screenX &&
                worldX - Tile.TILE_WIDTH < hero.worldX + hero.screenX &&
                worldY + Tile.TILE_WIDTH > hero.worldY - hero.screenY &&
                worldY - Tile.TILE_WIDTH < hero.worldY + hero.screenY){
            if(alive) image = Assets.cactus;
            else image = Assets.cactusBroken;
            /*if(dying){
                dyingAnimation((Graphics2D) g);
            }*/


            g.drawImage(image, screenX, screenY, TILE_WIDTH, TILE_HEIGHT, null);
            //g.setColor(Color.red);
            //g.fillRect(screenX+collisionBounds.x,screenY+collisionBounds.y, collisionBounds.width, collisionBounds.height);
        }
    }

}
