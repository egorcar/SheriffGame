package PaooGame;

import PaooGame.Object.OBJ_potionH;
import PaooGame.States.MenuState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    RefLinks refLink;
    Font arial40;
    BufferedImage whiskeyGlassImage;
    public boolean messageOn = false;
    public String message = " ";
    int messageCounter = 0;

    public UI(RefLinks refLink){
        this.refLink = refLink;
        arial40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_potionH potionH = new OBJ_potionH(refLink);
        whiskeyGlassImage = potionH.img;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics g, RefLinks refLink){
        g.setFont(arial40);
        g.setColor(Color.white);
        g.drawImage(whiskeyGlassImage, 0, 0, (int) (Tile.TILE_WIDTH*1.5), (int) (Tile.TILE_HEIGHT*1.5), null);
        g.drawString(" = "+ this.refLink.GetHero().hasPotion, 55, 50);
        if(messageOn){
            g.setFont(g.getFont().deriveFont(30F));
            g.drawString(message, 10, 100);
            messageCounter++;
        }
        if(messageCounter>120){
            messageCounter=0;
            messageOn = false;
        }
    }
}
