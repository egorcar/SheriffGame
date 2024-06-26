package PaooGame;

//import PaooGame.Items.Cactus;
import PaooGame.Items.NPC_Enemy;
import PaooGame.Object.OBJ_Shop;
import PaooGame.Object.OBJ_potionH;
import PaooGame.Object.OBJ_potionS;
import PaooGame.States.PlayState;
import PaooGame.Items.ITCactusTile;
import PaooGame.Tiles.Tile;

import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class AssetSetter {

    private RefLinks refLink;
    public AssetSetter(RefLinks refLink){
        this.refLink = refLink;
    }

    public void setObject(){
        int i = 0;
        refLink.GetSuperObject()[i] = new OBJ_Shop(refLink);
        refLink.GetSuperObject()[i].worldX = 62*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 76*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_Shop(refLink);
        refLink.GetSuperObject()[i].worldX = 80*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 38*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_Shop(refLink);
        refLink.GetSuperObject()[i].worldX = 29*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 33*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_potionH(refLink);
        refLink.GetSuperObject()[i].worldX = 39*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 76*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_potionH(refLink);
        refLink.GetSuperObject()[i].worldX = 34*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 24*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_potionH(refLink);
        refLink.GetSuperObject()[i].worldX = 80*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 28*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_potionH(refLink);
        refLink.GetSuperObject()[i].worldX = 80*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 39*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_potionS(refLink);
        refLink.GetSuperObject()[i].worldX = 62*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 68*TILE_HEIGHT;
        i++;
        refLink.GetSuperObject()[i] = new OBJ_potionS(refLink);
        refLink.GetSuperObject()[i].worldX = 20*TILE_WIDTH;
        refLink.GetSuperObject()[i].worldY = 35*TILE_HEIGHT;
    }

    public void setNpc(){
        int i = 0;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 17, 23, 48, 48);
        refLink.GetNPC_Enemy()[0].worldX = 50*TILE_WIDTH-30;
        refLink.GetNPC_Enemy()[i].worldY = 77*TILE_HEIGHT;
        refLink.GetNPC_Enemy()[i].moving = false;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 56*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 75*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 58*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 75*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 47*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 75*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 40*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 72*TILE_HEIGHT;
        i++;

        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 80*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 35*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 76*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 38*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 76*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 35*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 76*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 31*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 61*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 31*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 61*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 34*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 61*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 35*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 61*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 36*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 61*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 37*TILE_HEIGHT;

        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;
        i++;
        refLink.GetNPC_Enemy()[i] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[i].worldX = 15*TILE_WIDTH;
        refLink.GetNPC_Enemy()[i].worldY = 30*TILE_HEIGHT;

    }

    public void setInteractiveTile(){
        int i = 0;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 30, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 34* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 25* TILE_HEIGHT;
        //refLink.GetInteractiveTile()[i].bounds.width = 25* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 31, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 31* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 25* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 32, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 32* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 25* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 33* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 25* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 35* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 64* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 58* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 40* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 60* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 71* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 61* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 71* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 62* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 71* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 63* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 71* TILE_HEIGHT;
        i++;
        refLink.GetInteractiveTile()[i] = new ITCactusTile(refLink, 33, 25, 48, 48);
        refLink.GetInteractiveTile()[i].worldX = 44* TILE_WIDTH;
        refLink.GetInteractiveTile()[i].worldY = 75* TILE_HEIGHT;
    }
}
