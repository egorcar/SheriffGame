package PaooGame.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage heroStands;
    public static BufferedImage heroStandsRight;
    public static BufferedImage heroStands2;
    public static BufferedImage heroStandsRight2;
    public static BufferedImage heroAttacks1Left;
    public static BufferedImage heroAttacks1Right ;
    public static BufferedImage heroAttacks1Up ;
    public static BufferedImage heroAttacks1Down ;
    public static BufferedImage enemy1Stands;
    public static BufferedImage enemy1StandsRight;
    public static BufferedImage enemy1Stands2;
    public static BufferedImage enemy1StandsRight2;
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage cactus;
    public static BufferedImage cactusBroken;
    public static BufferedImage soil;
    public static BufferedImage sand;
    public static BufferedImage rock;
    public static BufferedImage townGrass;
    public static BufferedImage townGrassDestroyed;
    public static BufferedImage townSoil;
    public static BufferedImage water;
    public static BufferedImage rockUp;
    public static BufferedImage rockDown;
    public static BufferedImage rockLeft;
    public static BufferedImage rockRight;
    public static BufferedImage tree;
    public static BufferedImage hfence;
    public static BufferedImage vfence;
    public static BufferedImage tlfence;
    public static BufferedImage trfence;
    public static BufferedImage blfence;
    public static BufferedImage brfence;
    public static BufferedImage key1Image;
    public static BufferedImage key2Image;
    public static BufferedImage noKeyImage;
    public static BufferedImage hGate;
    public static BufferedImage vGate;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public void getPlayerImage(){

    }
    public static void Init()
    {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        //grass = sheet.crop(0, 0);
        //soil = sheet.crop(1, 0);
        water = sheet.crop(2, 0);
        //mountain = sheet.crop(3, 0);
        townGrass = sheet.crop(0, 1);
        townGrassDestroyed = sheet.crop(1, 1);
        townSoil = sheet.crop(2, 1);
        tree = sheet.crop(3, 1);
        heroLeft = sheet.crop(0, 2);
        heroRight = sheet.crop(1, 2);
        rockUp = sheet.crop(2, 2);
        rockDown = sheet.crop(3, 2);
        rockLeft = sheet.crop(0, 3);
        rockRight = sheet.crop(1, 3);

        try {
            heroStands = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroStands1.png"));
            heroStandsRight = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroStandsRight1.png"));
            heroStands2 = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroStands2.png"));
            heroStandsRight2 = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroStandsRight2.png"));
            heroAttacks1Left = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroAttacks1Right.png"));
            heroAttacks1Right = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroAttacks1Left.png"));
            heroAttacks1Up = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroAttacks1Up.png"));
            heroAttacks1Down = ImageIO.read(Assets.class.getResourceAsStream("/textures/heroAttacks1Down.png"));
            sand = ImageIO.read(Assets.class.getResourceAsStream("/textures/sand4.png"));
            rock = ImageIO.read(Assets.class.getResourceAsStream("/textures/sandstone.png"));
            hfence = ImageIO.read(Assets.class.getResourceAsStream("/textures/fenceHoriz.png"));
            vfence = ImageIO.read(Assets.class.getResourceAsStream("/textures/fenceVert.png"));
            tlfence = ImageIO.read(Assets.class.getResourceAsStream("/textures/fenceTopLeft.png"));
            trfence = ImageIO.read(Assets.class.getResourceAsStream("/textures/fenceTopRight.png"));
            blfence = ImageIO.read(Assets.class.getResourceAsStream("/textures/fenceBotLeft.png"));
            brfence = ImageIO.read(Assets.class.getResourceAsStream("/textures/fenceBotRight.png"));
            enemy1Stands = ImageIO.read(Assets.class.getResourceAsStream("/textures/enemy1Stands1.png"));
            enemy1StandsRight = ImageIO.read(Assets.class.getResourceAsStream("/textures/enemy1Stands1Right.png"));
            enemy1Stands2 = ImageIO.read(Assets.class.getResourceAsStream("/textures/enemy1Stands2.png"));
            enemy1StandsRight2 = ImageIO.read(Assets.class.getResourceAsStream("/textures/enemy1Stands2Right.png"));
            cactus = ImageIO.read(Assets.class.getResourceAsStream("/textures/cactus.png"));
            cactusBroken = ImageIO.read(Assets.class.getResourceAsStream("/textures/cactusBroken.png"));
            key1Image = ImageIO.read(Assets.class.getResourceAsStream("/textures/key1.png"));
            key2Image = ImageIO.read(Assets.class.getResourceAsStream("/textures/key2.png"));
            noKeyImage = ImageIO.read(Assets.class.getResourceAsStream("/textures/nokey.png"));
            hGate = ImageIO.read(Assets.class.getResourceAsStream("/textures/gateHoriz.png"));
            vGate = ImageIO.read(Assets.class.getResourceAsStream("/textures/gateVert.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
