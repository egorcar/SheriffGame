package PaooGame;

import PaooGame.Graphics.Assets;
import PaooGame.Object.OBJ_coin;
import PaooGame.Object.OBJ_potionH;
import PaooGame.States.MenuState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    RefLinks refLink;
    Font arial40;
    BufferedImage whiskeyGlassImage;
    BufferedImage heartImage;
    BufferedImage halfHeartImage;
    BufferedImage noHeartImage;
    public BufferedImage coinImage;
    BufferedImage key1Image;
    BufferedImage key2Image;
    BufferedImage noKeyImage;
    public boolean messageOn = false;
    public String message = " ";
    int messageCounter = 0;

    public UI(RefLinks refLink){
        this.refLink = refLink;
        arial40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_potionH potionH = new OBJ_potionH(refLink);
        OBJ_coin coin = new OBJ_coin(refLink);
        whiskeyGlassImage = potionH.img;
        try{
            heartImage = ImageIO.read(getClass().getResourceAsStream("/textures/heart.png"));
            halfHeartImage = ImageIO.read(getClass().getResourceAsStream("/textures/halfHeart.png"));
            noHeartImage = ImageIO.read(getClass().getResourceAsStream("/textures/noHeart.png"));
            coinImage = ImageIO.read(getClass().getResourceAsStream("/textures/coin.png"));
            key1Image = ImageIO.read(getClass().getResourceAsStream("/textures/key1.png"));
            key2Image = ImageIO.read(getClass().getResourceAsStream("/textures/key2.png"));
            noKeyImage = ImageIO.read(getClass().getResourceAsStream("/textures/nokey.png"));
        } catch (IOException e) {e.printStackTrace();}
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics g, RefLinks refLink){
        if(refLink.GetHero().life<=0){
            g.setColor(new Color(215, 153, 73));
            g.fillRect(0, 0, refLink.GetGame().GetWidth(), refLink.GetGame().GetHeight());
            g.setColor(new Color(0, 0, 0));
            g.setFont(g.getFont().deriveFont(Font.BOLD,96F));
            String text = "Game over";
            int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
            int x = refLink.GetGame().GetWidth()/2 - length/2;
            int y = Tile.TILE_HEIGHT*3;
            g.drawString(message, x, y);
            System.out.println("Game Over!");
            if(refLink.GetKeyManager().esc) System.exit(0);
        }
        else{
            g.setFont(arial40);
            g.setColor(Color.white);
        /*g.drawImage(whiskeyGlassImage, 0, (int) (Tile.TILE_HEIGHT*1), (int) (Tile.TILE_WIDTH*1.5), (int) (Tile.TILE_HEIGHT*1.5), null);
        g.drawString(" "+ this.refLink.GetHero().hasPotion, 55, 100);*/
            if(refLink.GetHero().hasCoin<10) g.drawString(" "+ this.refLink.GetHero().hasCoin, 730, 47);
            else g.drawString(" "+ this.refLink.GetHero().hasCoin, 710, 47);
            g.drawImage(coinImage, 760, 10, null);
            if(refLink.GetHero().hasKey==0) g.drawImage(noKeyImage, 750, 50, null);
            else g.drawImage(key2Image, 750, 50, null);
            if(refLink.GetHero().hasKey<=1) g.drawImage(noKeyImage, 750, 90, null);
            else g.drawImage(key1Image, 750, 90, null);


            int x = 5;
            //int y = Tile.TILE_HEIGHT/2;
            int i = 0;
            while (i<refLink.GetHero().DEFAULT_LIFE/2){
                g.drawImage(noHeartImage, x, 10, null);
                i++;
                x += Tile.TILE_WIDTH;
            }
            x = 5;
            //y = Tile.TILE_HEIGHT/2;
            i = 0;
            while (i<refLink.GetHero().life){
                g.drawImage(halfHeartImage, x, 10, null);
                i++;
                if(i<refLink.GetHero().life){
                    g.drawImage(heartImage, x, 10, null);
                }
                i++;
                x += Tile.TILE_WIDTH;
            }
            //if()



            if(messageOn){
                g.setFont(g.getFont().deriveFont(30F));
                g.drawString(message, 10, 140);
                messageCounter++;
            }
            if(messageCounter>120){
                messageCounter=0;
                messageOn = false;
            }
        }

    }
}
