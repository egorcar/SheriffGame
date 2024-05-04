package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/
    public boolean solid;

    /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
    /// o singura data in memorie
    public static Tile grassTile        = new SandTile(0);     /*!< Dala de tip iarba*/
    public static Tile mountainTile     = new RockTile(1);  /*!< Dala de tip munte/piatra*/
    public static Tile blFenceTile      = new blFenceTile(4);
    public static Tile brFenceTile      = new brFenceTile(5);
    public static Tile trFenceTile      = new trFenceTile(6);
    public static Tile tlFenceTile      = new tlFenceTile(7);
    public static Tile vFenceTile       = new vFenceTile(8);
    public static Tile hFenceTile       = new hFenceTile(9);
    /*public static Tile waterTile        = new WaterTile(2);     *//*!< Dala de tip apa*//*
    public static Tile treeTile         = new TreeTile(3);      *//*!< Dala de tip copac*//*
    public static Tile soilTile         = new SoilTile(4);      *//*!< Dala de tip sol/pamant*/
    //public static Tile sandTile         = new SandTile(4);      /*!< Dala de tip sol/pamant*/

    public static final int TILE_WIDTH  = 48;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 48;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean IsSolid()
    {
        return solid;
    }

    public int GetId()
    {
        return id;
    }
}
