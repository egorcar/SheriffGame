/*
package PaooGame;

import PaooGame.Maps.Map;
import PaooGame.Items.Character;
import PaooGame.Tiles.Tile;
import PaooGame.RefLinks;

//import static PaooGame.Tiles.Tile.tiles;

public class CollisionChecker {
    //Game game;
    private RefLinks refLink;

    public CollisionChecker(RefLinks refLink){
        //this.game = game;
        this.refLink = refLink;
    }
    public void checkTile(Character item){

        // THIS IS A FUNCTION THAT CHECKS A CHARACTER. CHARACTER'S NAME IS "item". item IT'S NOT AN ITEM, IT'S A CHARACTER!!

        float itemLeftWorldX = item.x + item.normalBounds.x;
        float itemRightWorldX = item.x + item.normalBounds.x + item.normalBounds.width;
        float itemTopWorldY = item.y + item.normalBounds.y;
        float itemBottomWorldY = item.y + item.normalBounds.y + item.normalBounds.height;

        int itemLeftCol = (int) (itemLeftWorldX/ Tile.TILE_WIDTH);
        int itemRightCol = (int) (itemRightWorldX/ Tile.TILE_WIDTH);
        int itemTopRow = (int) (itemTopWorldY/ Tile.TILE_HEIGHT);
        int itemBottomRow = (int) (itemBottomWorldY/ Tile.TILE_HEIGHT);

        int tileNum1, tileNum2;


        switch (item.direction){
            case "Up":
                itemTopRow = (int) ((itemTopWorldY - item.speed)/Tile.TILE_HEIGHT);
                tileNum1 = refLink.GetMap().MiddleEastMap(itemLeftCol,itemTopRow);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemRightCol,itemTopRow);
                Tile temp1 = new Tile(tileNum1);
                Tile temp2 = new Tile(tileNum2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "Down":
                break;
            case "Left":
                break;
            case "Right":
                break;
        }
    }
}
*/
