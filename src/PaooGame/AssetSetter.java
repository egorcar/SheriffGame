package PaooGame;

import PaooGame.Items.NPC_Enemy;
import PaooGame.Object.OBJ_Shop;
import PaooGame.Object.OBJ_potionH;
import PaooGame.Object.OBJ_potionS;

import java.sql.Ref;

import static PaooGame.Tiles.Tile.TILE_HEIGHT;
import static PaooGame.Tiles.Tile.TILE_WIDTH;

public class AssetSetter {

    private RefLinks refLink;
    public AssetSetter(RefLinks refLink){
        this.refLink = refLink;
    }

    public void setObject(){
        refLink.GetSuperObject()[0] = new OBJ_Shop(refLink);
        refLink.GetSuperObject()[0].worldX = 33*TILE_WIDTH;
        refLink.GetSuperObject()[0].worldY = 23*TILE_HEIGHT;

        refLink.GetSuperObject()[1] = new OBJ_potionH(refLink);
        refLink.GetSuperObject()[1].worldX = 28*TILE_WIDTH;
        refLink.GetSuperObject()[1].worldY = 23*TILE_HEIGHT;

        refLink.GetSuperObject()[2] = new OBJ_potionH(refLink);
        refLink.GetSuperObject()[2].worldX = 17*TILE_WIDTH;
        refLink.GetSuperObject()[2].worldY = 19*TILE_HEIGHT;

        refLink.GetSuperObject()[3] = new OBJ_potionS(refLink);
        refLink.GetSuperObject()[3].worldX = 24*TILE_WIDTH;
        refLink.GetSuperObject()[3].worldY = 16*TILE_HEIGHT;

        refLink.GetSuperObject()[4] = new OBJ_potionS(refLink);
        refLink.GetSuperObject()[4].worldX = 21*TILE_WIDTH;
        refLink.GetSuperObject()[4].worldY = 23*TILE_HEIGHT;
    }

    public void setNpc(){
        refLink.GetNPC_Enemy()[0] = new NPC_Enemy(refLink, 17, 23, 48, 48);
        refLink.GetNPC_Enemy()[0].worldX = 17*TILE_WIDTH;
        refLink.GetNPC_Enemy()[0].worldY = 23*TILE_HEIGHT;

        refLink.GetNPC_Enemy()[1] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[1].worldX = 26*TILE_WIDTH;
        refLink.GetNPC_Enemy()[1].worldY = 21*TILE_HEIGHT;

        refLink.GetNPC_Enemy()[2] = new NPC_Enemy(refLink, 18, 19, 48, 48);
        refLink.GetNPC_Enemy()[2].worldX = 26*TILE_WIDTH;
        refLink.GetNPC_Enemy()[2].worldY = 17*TILE_HEIGHT;



    }
}
