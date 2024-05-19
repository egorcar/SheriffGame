package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class InteractiveTile extends Character{
    public boolean destructible = false;

    public InteractiveTile(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
    }


    public void Update() {
        //super.Update();
    }

    @Override
    public void Draw(RefLinks refLink, Graphics g) {

    }

    public void Draw(RefLinks refLink, Hero hero, Graphics g) {
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
