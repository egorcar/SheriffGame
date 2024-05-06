package PaooGame;

import PaooGame.Object.OBJ_Shop;

import java.sql.Ref;

public class AssetSetter {

    private RefLinks refLink;
    public AssetSetter(RefLinks refLink){
        this.refLink = refLink;
    }

    public void setObject(){
        refLink.GetSuperObject()[0] = new OBJ_Shop(refLink);
        refLink.GetSuperObject()[0].worldX = 480;
        refLink.GetSuperObject()[0].worldY = 480;


    }

    /*public void setObject(){
        refLink.GetSuperObject();
    }*/
}
