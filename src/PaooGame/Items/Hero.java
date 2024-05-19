package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.GameWindow.GameWindow;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

import static PaooGame.States.State.playSE;


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

    int soundCounter;
    public boolean checkDrawTime = false;
    private java.awt.Graphics2D Graphics2D;

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
        attackBounds.x = 0;
        attackBounds.y = 0;
        attackBounds.width = 38;
        attackBounds.height = 38;
        worldX = 22*Tile.TILE_WIDTH;
        worldY = 35*Tile.TILE_HEIGHT;
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
        if(attacking){
            attack();
        } else {
            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1)
                    spriteNum = 2;
                else if (spriteNum == 2)
                    spriteNum = 1;
                spriteCounter = 0;
            }
        }
        if(invincible){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }


        ///Actualizeaza imaginea

    }

    private void attack() {
        spriteCounter++;
        if(spriteCounter<2)playSE(3);
        if(spriteCounter <= /*5*/25){
            spriteNum = 1;
            //Save current state
            float currentWorldX = worldX;
            float currentWorldY = worldY;
            int boundsWidth = bounds.width;
            int boundsHeight = bounds.height;

            switch (direction){
                case "Up": worldY -= attackBounds.height; break;
                case "Down": worldY += attackBounds.height; break;
                case "Left": worldX -= attackBounds.height; break;
                case "Right": worldX += attackBounds.height; break;
            }

            bounds.width = attackBounds.width;
            bounds.height = attackBounds.height-10;

            int NPCIndex = refLink.GetCChecker().checkCharacters(this, refLink.GetNPC_Enemy());
            damageNPC(NPCIndex);

            int iTileIndex = cChecker.checkCharacters(this, refLink.GetInteractiveTile());
            damageInteractiveTile(iTileIndex);

            worldX = currentWorldX;
            worldY = currentWorldY;
            bounds.width = boundsWidth;
            bounds.height = boundsHeight;

        }
        //if(spriteCounter > 5 && spriteCounter <=25) spriteNum = 2;
        if(spriteCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }

    private void damageNPC(int i) {
        if(i!=999){
            if(!refLink.GetNPC_Enemy()[i].invincible){
                if(!refLink.GetNPC_Enemy()[i].dying) playSE(2);
                System.out.println("Hit");
                /*refLink.GetNPC_Enemy()[i].life-=5;
                refLink.GetNPC_Enemy()[i].invincible = true;*/
                refLink.GetNPC_Enemy()[i].dying = true;
                if(refLink.GetNPC_Enemy()[i].life <= 0){
                    //refLink.GetNPC_Enemy()[i] = null;
                    refLink.GetNPC_Enemy()[i].dying = true;
                }
            }
        }
        else
            System.out.println("Miss");
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
        //else direction = "No";

        //CHECK TILE COLLISION
        collisionON = false;
        cChecker.checkTile(this);

        //CHECK INTERACTIVE TILE COLLISION
        //cChecker.checkCharacters(this, refLink.GetInteractiveTile());
        int iTileIndex = cChecker.checkCharacters(this, refLink.GetInteractiveTile());

        //CHECK OBJECT COLLISION
        int objIndex = cChecker.checkObject(this, true);
        pickUpObject(objIndex);

        //CHECK NPC COLLISION
        int npcIndex = refLink.GetCChecker().checkCharacters(this, refLink.GetNPC_Enemy());
        contactEnemy(npcIndex);
        interactNPC(npcIndex);

        if(!collisionON){
            if(direction == "Up" && refLink.GetKeyManager().up) {yMove = -speed;}
            if(direction == "Down"&&refLink.GetKeyManager().down) {yMove = speed;}
            if(direction == "Left"&&refLink.GetKeyManager().left) {xMove = -speed;}
            if(direction == "Right"&&refLink.GetKeyManager().right) {xMove = speed;}
        }
    }

    private void damageInteractiveTile(int i) {
        if(i!=999&&refLink.GetInteractiveTile()[i].destructible){
            refLink.GetInteractiveTile()[i].image = Assets.cactusBroken;
            refLink.GetInteractiveTile()[i].alive = false;
            refLink.GetInteractiveTile()[i].collisionI = false;
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
                    playSE(1);
                    life++;
                    refLink.GetSuperObject()[i]=null;
                    //System.out.println(refLink.GetNPC_Enemy());
                    refLink.GetUI().showMessage("Yee haw!");
                    break;
                case "Shop":
                    if(hasPotion>0){
                        //refLink.GetSuperObject()[i]=null;
                        hasPotion--;
                        refLink.GetUI().showMessage("Easy there, cowboy!");
                    }
                    else
                        refLink.GetUI().showMessage("Easy there, cowboy!");

                    break;
                case "PotionS":
                    playSE(1);
                    speed+=4;
                    hasPotion++;
                    refLink.GetSuperObject()[i]=null;
                    refLink.GetUI().showMessage("Slow down, cowboy!");
                    break;
            }
        }

    }

    public void interactNPC(int i){
        if(refLink.GetKeyManager().enter){
            if(i!=999){
                System.out.println("You are hitting the "+i+" npc");
            }
            else {
                attacking = true;
            }
        }
    }


    public void contactEnemy(int i){
        if(i != 999){
            if(!invincible){
                life -=1;
                playSE(4);
                invincible = true;
            }
        }
    }





    @Override
    public void Draw(RefLinks refLink, Graphics g)
    {
        System.out.println(direction);
        BufferedImage attackAnimation = null;
        //if(refLink.GetKeyManager().left)
        if(direction=="Left")
        {
            image = Assets.heroAttacks1Left;
            if(spriteNum==1)
                image = Assets.heroStandsRight;
            if(spriteNum==2)
                image = Assets.heroStandsRight2;
            if(attacking)
                attackAnimation = Assets.heroAttacks1Left;

        }
        if(direction=="Right") {
            if(spriteNum==1)
                image = Assets.heroStands;
            if(spriteNum==2)
                image = Assets.heroStands2;
            if(attacking)
                attackAnimation = Assets.heroAttacks1Right;
        }
        if(direction == "Up")
        {
            if (image==Assets.heroStandsRight||image==Assets.heroStandsRight2){
                if(spriteNum==1)
                    image = Assets.heroStandsRight2;
                if(spriteNum==2)
                    image = Assets.heroStandsRight;
                if(attacking){
                    if(spriteNum==1)
                        attackAnimation = Assets.heroAttacks1Up;
                    if(spriteNum==2)
                        attackAnimation = Assets.heroAttacks1Up;
                }
            }
            else{
                if(spriteNum==1)
                    image = Assets.heroStands2;
                if(spriteNum==2)
                    image = Assets.heroStands;
                if(attacking)
                    attackAnimation = Assets.heroAttacks1Up;
            }
        }

        if(direction == "Down") {
            if (image==Assets.heroStandsRight||image==Assets.heroStandsRight2){
                if(spriteNum==1)
                    image = Assets.heroStandsRight2;
                if(spriteNum==2)
                    image = Assets.heroStandsRight;
                if(attacking)
                    attackAnimation = Assets.heroAttacks1Down;
            }
            else{
                if(spriteNum==1)
                    image = Assets.heroStands2;
                if(spriteNum==2)
                    image = Assets.heroStands;
                if(attacking)
                    attackAnimation = Assets.heroAttacks1Down;
            }

        }
        BufferedImage transparentImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2 = (Graphics2D) g;
        if(invincible) {
            //Hz
        }

        if(attackAnimation == null){
            g.drawImage(image, (int)GameWindow.GetHalfWidth()-30, (int)GameWindow.GetHalfHeight()-10, width, height, null);
            g.setColor(Color.blue);
            g.fillRect((int) screenX+bounds.x, (int) screenY+bounds.y, bounds.width, bounds.height);
        }
        else{
            if (attackAnimation.equals(Assets.heroAttacks1Up)) {
                g.drawImage(attackAnimation, (int)GameWindow.GetHalfWidth()-30, (int) GameWindow.GetHalfHeight() - 70, width, 2*height, null);
            }
            else if (attackAnimation.equals(Assets.heroAttacks1Down)) {
                g.drawImage(attackAnimation, (int)GameWindow.GetHalfWidth()-30, (int) GameWindow.GetHalfHeight() - 10, width, 2*height, null);
            }
            else if (attackAnimation.equals(Assets.heroAttacks1Left)) {
                g.drawImage(attackAnimation, (int)GameWindow.GetHalfWidth()-90, (int) GameWindow.GetHalfHeight() - 10, width*2, height, null);
            }
            else if (attackAnimation.equals(Assets.heroAttacks1Right)) {
                g.drawImage(attackAnimation, (int)GameWindow.GetHalfWidth()-30, (int) GameWindow.GetHalfHeight() - 10, width*2, height, null);
            }
        }


        /*BufferedImage attackAnimation = null;
        if (direction.equals("Left")) {
            attackAnimation = Assets.heroAttacks1Left;
        } else if (direction.equals("Right")) {
            attackAnimation = Assets.heroAttacks1Right;
        } else if (direction.equals("Up")) {
            attackAnimation = Assets.heroAttacks1Up;
        } else if (direction.equals("Down")) {
            attackAnimation = Assets.heroAttacks1Down;
        }*/



        // Draw the bounding box for debugging purposes
        //g.setColor(Color.blue);
        //g.fillRect((int) screenX + bounds.x, (int) screenY + bounds.y, bounds.width, bounds.height);




    }
}
