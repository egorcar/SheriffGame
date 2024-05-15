package PaooGame;
import PaooGame.Items.Character;
import PaooGame.Items.Item;
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

        int itemLeftWorldX = (int) (item.worldX + item.bounds.x/*-32*/);
        int itemRightWorldX = (int) (item.worldX + item.bounds.x + item.bounds.width/*-32*/);
        int itemTopWorldY = (int) (item.worldY + item.bounds.y);
        int itemBottomWorldY = (int) (item.worldY + item.bounds.y + item.bounds.height/*-20*/);

        int itemLeftCol = (int) (itemLeftWorldX/ Tile.TILE_WIDTH);
        int itemRightCol = (int) (itemRightWorldX/ Tile.TILE_WIDTH);
        int itemTopRow = (int) (itemTopWorldY/ Tile.TILE_HEIGHT);
        int itemBottomRow = (int) (itemBottomWorldY/ Tile.TILE_HEIGHT);

        int tileNum1, tileNum2;


        switch (item.direction){
            case "Up":
                itemTopRow = (int) (((itemTopWorldY-10) - item.speed)/Tile.TILE_HEIGHT);
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemTopRow, itemRightCol);
                Tile temp1 = Tile.tileMaker(tileNum1);
                Tile temp2 = Tile.tileMaker(tileNum2);

                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;

            case "Down":
                itemBottomRow = (int) ((itemBottomWorldY+10 + item.speed)/Tile.TILE_HEIGHT);
                tileNum1 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemRightCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "Left":
                itemLeftCol = (int) ((itemLeftWorldX-10 - item.speed)/Tile.TILE_HEIGHT);
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemLeftCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "Right":
                itemRightCol = (int) ((itemRightWorldX+10 + item.speed)/Tile.TILE_HEIGHT);
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemRightCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemRightCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "No":
                break;
        }
    }

    public void checkTileNPC(Character item){
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
                itemTopRow =((itemTopWorldY-10)/* - item.speed*/)/Tile.TILE_HEIGHT;
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemTopRow, itemRightCol);
                //System.out.println(itemLeftCol+","+itemTopRow);
                //System.out.println(itemRightCol+","+itemTopRow);
                Tile temp1 = Tile.tileMaker(tileNum1);
                Tile temp2 = Tile.tileMaker(tileNum2);
                //System.out.println(temp1 +" "+ temp2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;

            case "Down":
                itemBottomRow =(itemBottomWorldY+10/* + item.speed*/)/Tile.TILE_HEIGHT;
                tileNum1 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemRightCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                //System.out.println(temp1 +" "+ temp2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "Left":
                itemLeftCol =(itemLeftWorldX-10/* - item.speed*/)/Tile.TILE_HEIGHT;
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemLeftCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemLeftCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                //System.out.println(temp1 +" "+ temp2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "Right":
                itemRightCol = (int) ((itemRightWorldX+10/* + item.speed*/)/Tile.TILE_HEIGHT);
                tileNum1 = refLink.GetMap().MiddleEastMap(itemTopRow, itemRightCol);
                tileNum2 = refLink.GetMap().MiddleEastMap(itemBottomRow, itemRightCol);
                temp1 = Tile.tileMaker(tileNum1);
                temp2 = Tile.tileMaker(tileNum2);
                //System.out.println(temp1 +" "+ temp2);
                if(temp1.solid || temp2.solid){
                    item.collisionON = true;
                }
                break;
            case "No":
                break;
        }
    }
    public int checkObject(Character character, boolean hero){
        int index = 999;

        for(int i = 0; i<refLink.GetSuperObject().length; i++){
            if(refLink.GetSuperObject()[i] != null){
                character.bounds.x = (int) (character.worldX + character.bounds.x);
                character.bounds.y = (int) (character.worldY + character.bounds.y);

                refLink.GetSuperObject()[i].bounds.x = refLink.GetSuperObject()[i].worldX + refLink.GetSuperObject()[i].bounds.x;
                refLink.GetSuperObject()[i].bounds.y = refLink.GetSuperObject()[i].worldY + refLink.GetSuperObject()[i].bounds.y;

                switch (character.direction){
                    case "Up":
                        character.bounds.y -= character.speed;
                        if(character.bounds.intersects(refLink.GetSuperObject()[i].bounds)){
                            if (refLink.GetSuperObject()[i].collision == true){
                                character.collisionON = true;
                            }
                            if(hero == true){
                                index = i;
                            }
                        }
                        break;
                    case "Down":
                        character.bounds.y += character.speed;
                        if(character.bounds.intersects(refLink.GetSuperObject()[i].bounds)){
                            if (refLink.GetSuperObject()[i].collision == true){
                                character.collisionON = true;
                            }
                            if(hero == true){
                                index = i;
                            }
                        }

                        break;
                    case "Left":
                        character.bounds.x -= character.speed;
                        if(character.bounds.intersects(refLink.GetSuperObject()[i].bounds)){
                            if (refLink.GetSuperObject()[i].collision == true){
                                character.collisionON = true;
                            }
                            if(hero == true){
                                index = i;
                            }
                        }
                        break;
                    case "Right":
                        character.bounds.x += character.speed;
                        if(character.bounds.intersects(refLink.GetSuperObject()[i].bounds)){
                            if (refLink.GetSuperObject()[i].collision == true){
                                character.collisionON = true;
                            }
                            if(hero == true){
                                index = i;
                            }
                        }
                        break;
                }
                character.bounds.x = character.solidAreaDefaultX;
                character.bounds.y = character.solidAreaDefaultY;
                refLink.GetSuperObject()[i].bounds.x = refLink.GetSuperObject()[i].solidAreaDefaultX;
                refLink.GetSuperObject()[i].bounds.y = refLink.GetSuperObject()[i].solidAreaDefaultY;

            }
        }

        return index;
    }
}
