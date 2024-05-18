package PaooGame.Maps;

import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map2 {
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    public int[][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    public final int maxWorldCol = 44;
    public final int maxWorldRow = 44;
    public int tick;

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map2(RefLinks refLink) {
        this.refLink = refLink;
        LoadWorld();

    }
    public void Update() {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g, Hero hero) {
        int worldCol = 0;
        int worldRow = 0;
        //System.out.printf("X: %f, %f \nY: %f, %f\n", hero.worldX, hero.screenX, hero.worldY, hero.screenY);
        while (worldCol < maxWorldCol && worldRow < maxWorldRow) {
            int worldX = worldCol * Tile.TILE_WIDTH;
            int worldY = worldRow * Tile.TILE_HEIGHT;
            int screenX = (int) (worldX - hero.worldX + hero.screenX);
            int screenY = (int) (worldY - hero.worldY + hero.screenY);
            if(worldX + Tile.TILE_WIDTH > hero.worldX - hero.screenX &&
                    worldX - Tile.TILE_WIDTH < hero.worldX + hero.screenX &&
                    worldY + Tile.TILE_WIDTH > hero.worldY - hero.screenY &&
                    worldY - Tile.TILE_WIDTH < hero.worldY + hero.screenY){
                GetTile(worldCol, worldRow).Draw(g, screenX, screenY);
            }
            worldCol++;
            if (worldCol == maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y) {
        if(x < 0 || y < 0/*|| x >= width || y >= height*/)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[y][x]];
        if(t == null)
        {
            return Tile.mountainTile;
        }
        return t;
    }

    private void LoadWorld() {
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            tiles = new int[maxWorldRow][maxWorldCol]; // Corrected the array dimensions

            // Read each line from the map file
            for (int y = 0; y < maxWorldRow; y++) {
                String line = br.readLine();
                String[] numbers = line.split(" ");

                // Assign tile codes to the correct positions in the array
                for (int x = 0; x < maxWorldCol; x++) {
                    tiles[y][x] = Integer.parseInt(numbers[x]); // Corrected the indexing
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging purposes
        }
    }

}