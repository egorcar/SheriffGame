package PaooGame;
import PaooGame.Items.Character;
import PaooGame.States.PlayState;
import PaooGame.Tiles.Tile;

import java.sql.Ref;

//import static PaooGame.Tiles.Tile.tiles;

public class CollisionChecker {
    private RefLinks refLink;

    public CollisionChecker(RefLinks refLink){
        this.refLink = refLink;
    }
    public void checkTile(Character item){

        // THIS IS A FUNCTION THAT CHECKS A CHARACTER. CHARACTER'S NAME IS "item". item IT'S NOT AN ITEM, IT'S A CHARACTER!!

        int itemLeftWorldX = (int) (item.worldX + item.bounds.x);
        int itemRightWorldX = (int) (item.worldX + item.bounds.x + item.bounds.width);
        int itemTopWorldY = (int) (item.worldY + item.bounds.y);
        int itemBottomWorldY = (int) (item.worldY + item.bounds.y + item.bounds.height);

        int itemLeftCol = (int) (itemLeftWorldX/ Tile.TILE_WIDTH);
        int itemRightCol = (int) (itemRightWorldX/ Tile.TILE_WIDTH);
        int itemTopRow = (int) (itemTopWorldY/ Tile.TILE_HEIGHT);
        int itemBottomRow = (int) (itemBottomWorldY/ Tile.TILE_HEIGHT);

        int tileNum1, tileNum2;


        switch (item.direction){
            case "Up":
                itemTopRow =(itemTopWorldY/* - item.speed*/)/Tile.TILE_HEIGHT;
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemTopRow, itemRightCol);
                System.out.println(itemLeftCol+","+itemTopRow);
                System.out.println(itemRightCol+","+itemTopRow);
                Tile temp1 = Tile.tileMaker(tileNum1);
                Tile temp2 = Tile.tileMaker(tileNum2);
                System.out.println(temp1 +" "+ temp2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;

            case "Down":
                itemBottomRow =(itemBottomWorldY/* + item.speed*/)/Tile.TILE_HEIGHT;
                tileNum1 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemRightCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "Left":
                itemLeftCol =(itemLeftWorldX/* - item.speed*/)/Tile.TILE_HEIGHT;
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemLeftCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "Right":
                itemRightCol = (int) ((itemRightWorldX + item.speed)/Tile.TILE_HEIGHT);
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemRightCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemRightCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
        }
    }
}
