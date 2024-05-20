package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import javax.swing.text.html.parser.Entity;
import java.awt.*;

import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class Projectile extends Character{
    Character user;

    public Projectile(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
    }
    public void set(int worldX, int worldY, String direction, boolean alive, Character user){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;
    }

    public void Update(){
        if(user == refLink.GetHero()){
            //refLink.GetCChecker().checkTile(this);
            int npcIndex = refLink.GetCChecker().checkCharacters(this, refLink.GetNPC_Enemy());
            if(npcIndex!=999){
                refLink.GetHero().damageNPC(npcIndex);
                alive = false;
            }
        }
        else{
            boolean contactPlayer = refLink.GetCChecker().checkPlayer(user);
            if(!refLink.GetHero().invincible && contactPlayer){
                damagePlayer();
            }
        }
        switch (direction){
            case "Up": worldY -= this.speed; break;
            case "Down": worldY += this.speed; break;
            case "Right": worldX += this.speed; break;
            case "Left": worldX -= this.speed; break;
        }

        life--;

        if(life<=0) alive = false;
    }

    public void Draw(RefLinks refLink, Graphics g) {
        Draw(refLink, refLink.GetHero(), g);
    }
    public void Draw(RefLinks refLink, Hero hero, Graphics g) {
        System.out.println("Neg");
        int screenX = (int) (worldX - hero.worldX + hero.screenX);
        int screenY = (int) (worldY - hero.worldY + hero.screenY);
        if(worldX + TILE_WIDTH > hero.worldX - hero.screenX &&
                worldX - TILE_WIDTH < hero.worldX + hero.screenX &&
                worldY + TILE_WIDTH > hero.worldY - hero.screenY &&
                worldY - TILE_WIDTH < hero.worldY + hero.screenY){
                switch (direction){
                    case "Up": image = imUp; break;
                    case "Down": image = imDown; break;
                    case "Left": image = imLeft; break;
                    case "Right": image = imRight; break;
                }
                g.drawImage(image, screenX, screenY, TILE_WIDTH, TILE_HEIGHT, null);
                //g.setColor(Color.red);
                //g.fillRect(screenX+collisionBounds.x,screenY+collisionBounds.y, collisionBounds.width, collisionBounds.height);
        }
    }


}
