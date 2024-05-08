package PaooGame;

import PaooGame.Object.OBJ_Shop;
import PaooGame.Object.OBJ_potionH;

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

        refLink.GetSuperObject()[3] = new OBJ_potionH(refLink);
        refLink.GetSuperObject()[3].worldX = 24*TILE_WIDTH;
        refLink.GetSuperObject()[3].worldY = 16*TILE_HEIGHT;
    }

    /*public void setObject(){
        refLink.GetSuperObject();
    }*/
}
