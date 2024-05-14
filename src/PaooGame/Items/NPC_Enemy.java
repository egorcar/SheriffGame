package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class NPC_Enemy extends Character{
    public NPC_Enemy(RefLinks refLink, float x, float y, int width, int height){
        super(refLink, x, y, width, height);
        //speed = 3;
        image = Assets.enemy1Stands;
    }



    public void Update() {

    }

    @Override
    public void Draw(Graphics g) {

    }

    public void Draw(RefLinks refLink, Hero hero, Graphics g) {
        int screenX = (int) (worldX - hero.worldX + hero.screenX);
        int screenY = (int) (worldY - hero.worldY + hero.screenY);
        if(worldX + Tile.TILE_WIDTH > hero.worldX - hero.screenX &&
                worldX - Tile.TILE_WIDTH < hero.worldX + hero.screenX &&
                worldY + Tile.TILE_WIDTH > hero.worldY - hero.screenY &&
                worldY - Tile.TILE_WIDTH < hero.worldY + hero.screenY){
            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1)
                    spriteNum = 2;
                else if (spriteNum == 2)
                    spriteNum = 1;
                spriteCounter = 0;
            }

            if(direction == "Left")
            {
                if(spriteNum==1)
                    image = Assets.enemy1StandsRight;
                if(spriteNum==2)
                    image = Assets.enemy1StandsRight2;


            }
            if(direction == "Right") {
                if(spriteNum==1)
                    image = Assets.enemy1Stands;
                if(spriteNum==2)
                    image = Assets.enemy1Stands2;
            }
            if(direction == "Up")
            {
                if (image==Assets.heroStandsRight||image==Assets.heroStandsRight2){
                    if(spriteNum==1)
                        image = Assets.enemy1StandsRight2;
                    if(spriteNum==2)
                        image = Assets.enemy1StandsRight;
                }
                else{
                    if(spriteNum==1)
                        image = Assets.enemy1Stands2;
                    if(spriteNum==2)
                        image = Assets.enemy1Stands;
                }
            }

            if(direction == "Down") {
                if (image==Assets.enemy1StandsRight||image==Assets.enemy1StandsRight2){
                    if(spriteNum==1)
                        image = Assets.enemy1StandsRight2;
                    if(spriteNum==2)
                        image = Assets.enemy1StandsRight;
                }
                else{
                    if(spriteNum==1)
                        image = Assets.enemy1Stands2;
                    if(spriteNum==2)
                        image = Assets.enemy1Stands;
                }
            }
            g.drawImage(image, screenX, screenY, (int) (TILE_WIDTH*1.2), (int) (TILE_HEIGHT*1.2), null);
        }
    }
}
