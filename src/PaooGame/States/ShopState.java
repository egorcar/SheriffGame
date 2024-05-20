package PaooGame.States;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class ShopState extends State
{
    public boolean buyTentative = false;
    public int shopCounter = 0;

    public ShopState(RefLinks refLink)
    {
        super(refLink);
        state = "ShopState";
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update() {
        if (refLink.GetKeyManager().esc) {
            buyTentative = false;
            State.SetState(refLink.GetGame().playState);
        }
        shopCounter++;
        if (refLink.GetKeyManager().enter) {
            buyTentative = true;
            if(refLink.GetHero().hasKey == 0){
                if (refLink.GetHero().hasCoin >= 5) {
                    refLink.GetHero().hasCoin -= 5;
                    refLink.GetHero().hasKey = 1;
                }
            }
            else if(refLink.GetHero().hasKey == 1){
                if (refLink.GetHero().hasCoin >= 10) {
                    refLink.GetHero().hasCoin -= 10;
                    refLink.GetHero().hasKey = 2;
                }
            }
        }
    }
    @Override
    public void Draw(Graphics g) {
        if (refLink.GetHero().hasKey == 0) {
            g.setColor(new Color(215, 153, 73));
            g.fillRect(0, 0, refLink.GetGame().GetWidth(), refLink.GetGame().GetHeight());

            g.setFont(g.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Shop";
            int length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
            int x = refLink.GetGame().GetWidth() / 2 - length / 2;
            int y = Tile.TILE_HEIGHT * 3;

            //Shadow
            g.setColor(Color.black);
            g.drawString(text, x + 5, y + 5);
            //Main text
            g.setColor(Color.white);
            g.drawString(text, x, y);

            g.setFont(g.getFont().deriveFont(Font.BOLD, 40F));
            text = "Press ENTER to buy the silver key";
            length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
            x = refLink.GetGame().GetWidth() / 2 - length / 2;
            y = Tile.TILE_HEIGHT * 5;

            //Shadow
            g.setColor(Color.black);
            g.drawString(text, x + 5, y + 5);
            //Main text
            g.setColor(Color.white);
            g.drawString(text, x, y);

            g.setFont(g.getFont().deriveFont(Font.BOLD, 60F));
            text = refLink.GetHero().hasCoin + "/5";
            length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
            x = refLink.GetGame().GetWidth() / 2 - length / 2 - 30;
            y = Tile.TILE_HEIGHT * 7;

            //Shadow
            g.setColor(Color.black);
            g.drawString(text, x + 5, y + 5);
            //Main text
            g.setColor(Color.white);
            g.drawString(text, x, y);
            g.drawImage(refLink.GetUI().coinImage, x + 100, y - 70, Tile.TILE_WIDTH * 2, Tile.TILE_WIDTH * 2, null);

            if (buyTentative) {
                if (refLink.GetHero().hasKey == 1) {
                    g.setFont(g.getFont().deriveFont(Font.BOLD, 60F));
                    text = "Silver key bought!";
                } else if (refLink.GetHero().hasKey == 0) {
                    g.setFont(g.getFont().deriveFont(Font.BOLD, 50F));
                    text = "Not enough coins, cowboy!";
                }
                length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
                x = refLink.GetGame().GetWidth() / 2 - length / 2 - 30;
                y = Tile.TILE_HEIGHT * 9;
                g.setColor(Color.black);
                g.drawString(text, x + 5, y + 5);
                //Main text
                g.setColor(Color.white);
                g.drawString(text, x, y);
            }
        } else if (refLink.GetHero().hasKey > 0) {
            g.setColor(new Color(215, 153, 73));
            g.fillRect(0, 0, refLink.GetGame().GetWidth(), refLink.GetGame().GetHeight());

            g.setFont(g.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Shop";
            int length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
            int x = refLink.GetGame().GetWidth() / 2 - length / 2;
            int y = Tile.TILE_HEIGHT * 3;

            //Shadow
            g.setColor(Color.black);
            g.drawString(text, x + 5, y + 5);
            //Main text
            g.setColor(Color.white);
            g.drawString(text, x, y);

            g.setFont(g.getFont().deriveFont(Font.BOLD, 40F));
            text = "Press ENTER to buy the golden key";
            length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
            x = refLink.GetGame().GetWidth() / 2 - length / 2;
            y = Tile.TILE_HEIGHT * 5;

            //Shadow
            g.setColor(Color.black);
            g.drawString(text, x + 5, y + 5);
            //Main text
            g.setColor(Color.white);
            g.drawString(text, x, y);

            g.setFont(g.getFont().deriveFont(Font.BOLD, 60F));
            text = refLink.GetHero().hasCoin + "/10";
            length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
            x = refLink.GetGame().GetWidth() / 2 - length / 2 - 30;
            y = Tile.TILE_HEIGHT * 7;

            //Shadow
            g.setColor(Color.black);

            //g.drawString(text, x+5, y+5);
            if (refLink.GetHero().hasCoin > 9) g.drawString(text, x - 20, y + 5);
            else g.drawString(text, x + 5, y + 5);
            //Main text
            g.setColor(Color.white);
            if (refLink.GetHero().hasCoin > 9) g.drawString(text, x - 25, y);
            else g.drawString(text, x, y);
            g.drawImage(refLink.GetUI().coinImage, x + 110, y - 70, Tile.TILE_WIDTH * 2, Tile.TILE_WIDTH * 2, null);

            if (buyTentative) {
                if (refLink.GetHero().hasKey == 2) {
                    g.setFont(g.getFont().deriveFont(Font.BOLD, 60F));
                    text = "Golden key bought!";
                    length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
                    x = refLink.GetGame().GetWidth() / 2 - length / 2 - 30;
                    y = Tile.TILE_HEIGHT * 9;
                    g.setColor(Color.black);
                    g.drawString(text, x + 5, y + 5);
                    //Main text
                    g.setColor(Color.white);
                    g.drawString(text, x, y);
                    buyTentative = false;
                }
            }
            if (buyTentative) {
                if (refLink.GetHero().hasKey < 2) {
                    g.setFont(g.getFont().deriveFont(Font.BOLD, 50F));
                    text = "Not enough coins, cowboy!";
                    length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
                    x = refLink.GetGame().GetWidth() / 2 - length / 2 - 30;
                    y = Tile.TILE_HEIGHT * 9;
                    g.setColor(Color.black);
                    g.drawString(text, x + 5, y + 5);
                    //Main text
                    g.setColor(Color.white);
                    g.drawString(text, x, y);
                }

            }
        }
    }
}
