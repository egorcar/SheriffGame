package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.CollisionChecker;
import PaooGame.GameWindow.GameWindow;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;


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
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/


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
        normalBounds.x = 16;
        normalBounds.y = 16;
        normalBounds.width = 16;
        normalBounds.height = 32;

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
        //System.out.printf("x: %f, y: %f \n", this.worldX, this.worldY);
        //System.out.printf("scx: %f, scy: %f \n", this.screenX, this.screenY);
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
        /*else{
            if(image == Assets.heroStands){
                if(spriteNum==1)
                    image = Assets.heroStands;
                if(spriteNum==2)
                    image = Assets.heroStands2;
            }
            else if(image == Assets.heroStands2)
                image = Assets.heroStands;
            else if(image == Assets.heroStandsRight)
                image = Assets.heroStandsRight2;
            else if(image == Assets.heroStandsRight2)
                image = Assets.heroStandsRight;
        }*/
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
        if(refLink.GetKeyManager().up)
        {
            direction = "Up";
        }
        ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            direction = "Down";
        }
        ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            direction = "Left";
        }
        ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            //xMove = speed;
            direction = "Right";
        }

        //CHECK TILE COLLISION

        collisionON = false;
        cChecker.checkTile(this);
        System.out.println("Collision = "+ collisionON+" Direction = "+direction);

        if(!collisionON){
            if(refLink.GetKeyManager().up)
            {
                yMove = -speed;
            }
            if(refLink.GetKeyManager().down)
            {
                yMove = speed;
            }
            if(refLink.GetKeyManager().left)
            {
                xMove = -speed;
            }
            if(refLink.GetKeyManager().right)
            {
                xMove = speed;
            }
        }


    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)GameWindow.GetHalfWidth()-30, (int)GameWindow.GetHalfHeight()-10, width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        g.setColor(Color.blue);
        g.fillRect((int) screenX, (int) screenY, bounds.width, bounds.height);
    }

}
