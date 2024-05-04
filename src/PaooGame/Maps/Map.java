package PaooGame.Maps;

import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.SpriteSheet;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map {
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int[][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    public final int maxWorldCol = 25;
    public final int maxWorldRow = 25;
    //public final int maxScreenCol = ;
    //public final int maxScreenRow = ;
    public final int worldWidth = Tile.TILE_HEIGHT * maxWorldCol;
    public final int worldLength = Tile.TILE_WIDTH * maxWorldRow;

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink) {
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld();
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public void Update() {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g, Hero hero)
    {
        int worldCol = 0;
        int worldRow = 0;
        //System.out.printf("X: %f, %f \nY: %f, %f\n", hero.worldX, hero.screenX, hero.worldY, hero.screenY);
        while(worldCol< maxWorldCol && worldRow < maxWorldRow){

            int worldX = worldCol * Tile.TILE_WIDTH;
            int worldY = worldRow * Tile.TILE_HEIGHT;
            int screenX = (int) (worldX - hero.worldX + hero.screenX);
            int screenY = (int) (worldY - hero.worldY + hero.screenY);
            GetTile(worldCol, worldRow).Draw(g, screenX, screenY);
            worldCol++;

            if(worldCol == maxWorldCol){
                worldCol = 0;
                worldRow++;
            }

        }


        /*int worldX;
        int worldY;
        int toDrawX = (int) (worldWidth - refLink.GetHero().worldX - refLink.GetHero().screenX);
        int toDrawY = (int) (worldLength - refLink.GetHero().worldY + refLink.GetHero().screenY);
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)toDrawX * Tile.TILE_HEIGHT, (int)toDrawX * Tile.TILE_WIDTH);
            }
        }*/
        //float b = refLink.GetHero().screenY;
        //Sanek:
        /*for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++) {
            worldY = y*Tile.TILE_HEIGHT;
            float screenY = worldY - refLink.GetHero().worldY + refLink.GetHero().screenY;
            //float screenY = refLink.GetHero().worldY - refLink.GetHero().screenY;
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                worldX = x * Tile.TILE_WIDTH;
                float screenX = worldX - refLink.GetHero().worldX + refLink.GetHero().screenX;
                //float screenX = refLink.GetHero().worldX - refLink.GetHero().screenX;
                if(worldX + Tile.TILE_WIDTH > refLink.GetHero().worldX - refLink.GetHero().screenX-32 &&
                        worldY + Tile.TILE_HEIGHT > refLink.GetHero().worldY - refLink.GetHero().screenY-32 &&
                        worldX - Tile.TILE_WIDTH < refLink.GetHero().worldX + refLink.GetHero().screenX+32 &&
                        worldY - Tile.TILE_HEIGHT < refLink.GetHero().worldY + refLink.GetHero().screenY+32){
                    GetTile(x, y).Draw(g, (int)screenX, (int)screenY);
                }
            }
        }*/


        //GPT 1
        /*int heroScreenX = (int) (refLink.GetHero().worldX - refLink.GetHero().screenX);
        int heroScreenY = (int) (refLink.GetHero().worldY - refLink.GetHero().screenY);

        for(int y = 0; y < maxWorldRow; y++) {
            for(int x = 0; x < maxWorldCol; x++) {
                worldX = x * Tile.TILE_WIDTH;
                worldY = y * Tile.TILE_HEIGHT;

                if(worldX + Tile.TILE_WIDTH >= heroScreenX - 32 &&
                        worldY + Tile.TILE_HEIGHT >= heroScreenY - 32 &&
                        worldX <= heroScreenX + refLink.GetGame().GetWidth() + 32 &&
                        worldY <= heroScreenY + refLink.GetGame().GetHeight() + 32) {
                    float screenX = worldX - heroScreenX;
                    float screenY = worldY - heroScreenY;
                    GetTile(x, y).Draw(g, (int)screenX, (int)screenY);
                }
            }
        }*/

        //GPT 2
        /*int heroScreenX = (int) GameWindow.GetWWidth(); // Assuming hero starts at the center of the screen
        int heroScreenY = (int) GameWindow.GetHalfHeigth(); // Assuming hero starts at the center of the screen

        for(int y = 0; y < maxWorldRow; y++) {
            for(int x = 0; x < maxWorldCol; x++) {
                worldX = x * Tile.TILE_WIDTH;
                worldY = y * Tile.TILE_HEIGHT;

                // Calculate the distance between the tile and the hero
                float distanceX = Math.abs(worldX - heroScreenX);
                float distanceY = Math.abs(worldY - heroScreenY);

                // Draw tiles only if they are within a certain range from the hero
                if (distanceX < refLink.GetGame().GetWidth() / 2 && distanceY < refLink.GetGame().GetHeight() / 2) {
                    float screenX = worldX - heroScreenX + refLink.GetGame().GetWidth() / 2;
                    float screenY = worldY - heroScreenY + refLink.GetGame().GetHeight() / 2;
                    GetTile(x, y).Draw(g, (int)screenX, (int)screenY);
                }
            }
        }*/

        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        /*for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }*/
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0/*|| x >= width || y >= height*/)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.mountainTile;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    private void LoadWorld()
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        //width = 20;
        ///Se stabileste inaltimea hartii in numar de dale
        //height = 10;
        ///Se construieste matricea de coduri de dale
        tiles = new int[maxWorldCol][maxWorldRow];
        //Se incarca matricea cu coduri
        for(int y = 0; y < maxWorldCol; y++)
        {
            for(int x = 0; x < maxWorldRow; x++)
            {
                tiles[x][y] = MiddleEastMap(y, x);
            }
        }
    }

    private int MiddleEastMap(int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        final int map[][] = {
                {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        return map[x][y];
    }
}