package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.Random;

import static PaooGame.States.State.playSE;
import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class NPC_Enemy extends Character{
    private int shotAvailableCouter2;

    public NPC_Enemy(RefLinks refLink, float x, float y, int width, int height){
        super(refLink, x, y, width, height);
        //actionLockCounter = 0;
        speed = 2;
        image = Assets.enemy1Stands;
        projectile = new Bullet(refLink, 10, 10, 48, 48);
    }

    public void setAction(){
        actionLockCounter++;
        //System.out.println(this.direction);
        //System.out.println(refLink.GetNPC_Enemy().length);
        if(actionLockCounter == 60){
            Random random = new Random();
            int i = random.nextInt(125)+1;
            if(i<=25)             {this.direction = "Up";}
            if(i > 25 && i <= 50) {this.direction = "Down";}
            if(i > 50 && i <= 75) {this.direction = "Left";}
            if(i > 75 && i <= 100){this.direction = "Right";}
            if(i > 100){this.direction = "NA";}
            actionLockCounter = 0;
        }
        int i = new Random().nextInt(100)+1;
        if(i>90 && !projectile.alive/* && this.shotAvailableCouter2 == 30*/){
            projectile.set((int) worldX, (int) worldY, direction, true, this);
            refLink.GetProjectileList().add(projectile);
            this.shotAvailableCouter2 = 0;
        }
        this.shotAvailableCouter2++;
    }

    @Override
    public void Update() {
        super.Update();

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
            //System.out.printf("x: %f, y: %f \n", this.worldX, this.worldY);
            //System.out.printf("scx: %f, scy: %f \n", this.screenX, this.screenY);
            ///Actualizeaza imaginea
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
            if(dying){
                dyingAnimation((Graphics2D) g);
            }


            g.drawImage(image, screenX, screenY, (int) (TILE_WIDTH*1.2), (int) (TILE_HEIGHT*1.2), null);
            //g.setColor(Color.red);
            //g.fillRect(screenX+collisionBounds.x,screenY+collisionBounds.y, collisionBounds.width, collisionBounds.height);
        }
    }

    /*public void dyingAnimation(Graphics2D g) {
        dyingCounter++;
        if(dyingCounter <=5){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter >5 && dyingCounter <=10){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter >10 && dyingCounter <=15){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter >15 && dyingCounter <=20){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter >20 && dyingCounter <=25){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter >25 && dyingCounter <=30){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter >30 && dyingCounter <=35){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter >35 && dyingCounter <=40){
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter > 40){
            dying = false;
            alive = false;
        }
    }*/
    public void dyingAnimation(Graphics2D g) {
        dyingCounter++;
        Composite originalComposite = g.getComposite();

        if (dyingCounter <= 5) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            //playSE(5);
        } else if (dyingCounter <= 10) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        } else if (dyingCounter <= 15) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        } else if (dyingCounter <= 20) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        } else if (dyingCounter <= 25) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        } else if (dyingCounter <= 30) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        } else if (dyingCounter <= 35) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        } else if (dyingCounter <= 40) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        } else {
            dying = false;
            alive = false;
            refLink.GetHero().hasCoin++;
        }

        // Restore the original composite
        g.setComposite(originalComposite);
    }

}
