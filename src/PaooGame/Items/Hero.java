package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.CollisionChecker;
import PaooGame.GameWindow.GameWindow;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.PlayState;
import PaooGame.Tiles.Tile;

import javax.imageio.ImageIO;


/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    //private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    public int hasPotion = 0;
    public boolean checkDrawTime = false;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza

        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        ///Seteaza imaginea de start a eroului
        image = Assets.heroLeft;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = -8;
        normalBounds.y = 20;
        normalBounds.width = 12;
        normalBounds.height = 12;
        solidAreaDefaultX = normalBounds.x;
        solidAreaDefaultY = normalBounds.y;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;
        worldX = 22*Tile.TILE_WIDTH;
        worldY = 25*Tile.TILE_HEIGHT;
        screenX = GameWindow.GetHalfWidth();
        screenY = GameWindow.GetHalfHeight();
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        ///Actualizeaza imaginea
        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteNum == 1)
                spriteNum = 2;
            else if (spriteNum == 2)
                spriteNum = 1;
            spriteCounter = 0;
        }

        if(refLink.GetKeyManager().left)
        {
            if(spriteNum==1)
                image = Assets.heroStandsRight;
            if(spriteNum==2)
                image = Assets.heroStandsRight2;


        }
        if(refLink.GetKeyManager().right) {
            if(spriteNum==1)
                image = Assets.heroStands;
            if(spriteNum==2)
                image = Assets.heroStands2;
        }
        if(refLink.GetKeyManager().up)
        {
            if (image==Assets.heroStandsRight||image==Assets.heroStandsRight2){
                if(spriteNum==1)
                    image = Assets.heroStandsRight2;
                if(spriteNum==2)
                    image = Assets.heroStandsRight;
            }
            else{
                if(spriteNum==1)
                    image = Assets.heroStands2;
                if(spriteNum==2)
                    image = Assets.heroStands;
            }
        }

        if(refLink.GetKeyManager().down) {
            if (image==Assets.heroStandsRight||image==Assets.heroStandsRight2){
                if(spriteNum==1)
                    image = Assets.heroStandsRight2;
                if(spriteNum==2)
                    image = Assets.heroStandsRight;
            }
            else{
                if(spriteNum==1)
                    image = Assets.heroStands2;
                if(spriteNum==2)
                    image = Assets.heroStands;
            }
        }
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().debug){
            if(!checkDrawTime) checkDrawTime = true;
            else checkDrawTime = false;
        }
        if(refLink.GetKeyManager().up) {direction = "Up";}
        ///Verificare apasare tasta "jos"
        else if(refLink.GetKeyManager().down) {direction = "Down";}
        ///Verificare apasare tasta "left"
        else if(refLink.GetKeyManager().left) {direction = "Left";}
        ///Verificare apasare tasta "dreapta"
        else if(refLink.GetKeyManager().right) {direction = "Right";}
        else direction = "No";

        //CHECK TILE COLLISION
        collisionON = false;
        cChecker.checkTile(this);

        //CHECK OBJECT COLLISION
        int objIndex = cChecker.checkObject(this, true);
        pickUpObject(objIndex);

        //CHECK NPC COLLISION
        int npcIndex = refLink.GetCChecker().checkCharacters(this, refLink.GetNPC_Enemy());
        interactNPC(npcIndex);

        if(!collisionON){
            if(direction == "Up") {yMove = -speed;}
            if(direction == "Down") {yMove = speed;}
            if(direction == "Left") {xMove = -speed;}
            if(direction == "Right") {xMove = speed;}
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    public void pickUpObject(int i){
        if(i!=999){
            String objectName = refLink.GetSuperObject()[i].name;
            switch (objectName){
                case"PotionH":
                    PlayState.playSE(1);
                    hasPotion++;
                    refLink.GetSuperObject()[i]=null;
                    //refLink.GetSuperObject()[i].img = nothing;
                    System.out.println(refLink.GetNPC_Enemy());
                    refLink.GetUI().showMessage("Yee haw!");
                    break;
                case "Shop":
                    if(hasPotion>0){
                        //refLink.GetSuperObject()[i]=null;
                        hasPotion--;
                        refLink.GetUI().showMessage("Easy there, cowboy!");
                    }
                    else
                        refLink.GetUI().showMessage("Get some booze, brother");

                    break;
                case "PotionS":
                    PlayState.playSE(1);
                    speed+=4;
                    refLink.GetSuperObject()[i]=null;
                    refLink.GetUI().showMessage("Slow down, cowboy!");
                    break;
            }
        }

    }

    public void interactNPC(int i){
        if(i!=999){
            System.out.println("You are hitting the "+i+" npc");
        }
    }
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)GameWindow.GetHalfWidth()-30, (int)GameWindow.GetHalfHeight()-10, width, height, null);
        g.setColor(Color.blue);
        g.fillRect((int) screenX+bounds.x, (int) screenY+bounds.y, bounds.width, bounds.height);
    }
}
