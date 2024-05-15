package PaooGame.States;

import PaooGame.Game;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    public int commandNum = 0;
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        state = "MenuState";
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        if(refLink.GetKeyManager().up){
            commandNum--;
            if(commandNum<0) commandNum=2;
        }
        if(refLink.GetKeyManager().down){
            commandNum++;
            if(commandNum>2) commandNum=0;
        }
        if(refLink.GetKeyManager().enter){
            if(commandNum==0){
                State.SetState(refLink.GetGame().playState);
            }
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        //Background color
        g.setColor(new Color(215, 153, 73));
        g.fillRect(0, 0, refLink.GetGame().GetWidth(), refLink.GetGame().GetHeight());

        g.setFont(g.getFont().deriveFont(Font.BOLD,96F));
        String text = "Sheriff";
        int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
        int x = refLink.GetGame().GetWidth()/2 - length/2;
        int y = Tile.TILE_HEIGHT*3;

        //Shadow
        g.setColor(Color.black);
        g.drawString(text, x+5, y+5);
        //Main text
        g.setColor(Color.white);
        g.drawString(text, x, y);
        //Sheriff image
        x = refLink.GetGame().GetWidth()/2;
        y =+ 4*Tile.TILE_HEIGHT;
        g.drawImage(refLink.GetHero().image, x-40, y, Tile.TILE_WIDTH*2, Tile.TILE_WIDTH*2, null);
        //Menu
        g.setFont(g.getFont().deriveFont(Font.BOLD,48F));
        g.drawString("Start", x=refLink.GetGame().GetWidth()/2 - (int)g.getFontMetrics().getStringBounds("Start", g).getWidth()/2, y+=4*Tile.TILE_HEIGHT);
        if(commandNum == 0){
            g.drawString(">", (int) (x-Tile.TILE_WIDTH*0.7), y);
        }
        g.drawString("Load game", x=refLink.GetGame().GetWidth()/2 - (int)g.getFontMetrics().getStringBounds("Load game", g).getWidth()/2, y+=1.3*Tile.TILE_HEIGHT);
        if(commandNum == 1){
            g.drawString(">", (int) (x-Tile.TILE_WIDTH*0.7), y);
        }
        g.drawString("Quit", x=refLink.GetGame().GetWidth()/2 - (int)g.getFontMetrics().getStringBounds("Quit", g).getWidth()/2, y+=1.3*Tile.TILE_HEIGHT);
        if(commandNum == 2){
            g.drawString(">", (int) (x-Tile.TILE_WIDTH*0.7), y);
        }
    }
}
