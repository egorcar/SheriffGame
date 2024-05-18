package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Random;

/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    public BufferedImage image;
    public static final int DEFAULT_LIFE            = 10;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED         = 4.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 60;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 60;   /*!< Inaltimea implicita a imaginii caracterului.*/
    public String direction = "Down";

    public int life;     /*!< Retine viata caracterului.*/
    public float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

    public boolean attacking = false;

    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
        ///Apel constructor la clasei de baza
        super(refLink, x,y, width, height);
        //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        life    = DEFAULT_LIFE-3;
        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
        normalBounds.x = 20;
        normalBounds.y = 32;
        normalBounds.width = 12;
        normalBounds.height = 12;

        collisionBounds.x = 8;
        solidAreaDefaultX = 16;
        collisionBounds.y = 8;
        solidAreaDefaultY = 28;
        collisionBounds.width = 20;
        collisionBounds.height = 32;

    }

    public void Move() {
        MoveX();
        MoveY();
    }

    public void MoveX() {this.worldX += xMove;}
    public void MoveY() {this.worldY += yMove;}
    public void setAction(){

    }

    public void Update(){
        xMove = 0;
        yMove = 0;

        actionLockCounter++;
        //System.out.println(this.direction);
        //System.out.println(refLink.GetNPC_Enemy().length);
        if(actionLockCounter == 60){
            Random random = new Random();
            int i = random.nextInt(125)+1;
            if(i<=25)             {this.direction = "Up";}
            if(i > 25 && i <= 50) {this.direction = "Down";}
            if(i > 50 && i <= 75) {this.direction = "Left";}
            if(i > 75 && i <= 100){this.direction = "Right";}
            if(i > 100){this.direction = "No";}
            actionLockCounter = 0;
        }

        collisionON = false;

        cChecker.checkTile(this);
        cChecker.checkObject(this, false);
        cChecker.checkPlayer(this);

        if(!collisionON){
            if(direction == "Up") {yMove = -speed;}
            if(direction == "Down") {yMove = speed;}
            if(direction == "Left") {xMove = -speed;}
            if(direction == "Right") {xMove = speed;}
        }

        Move();
    }

    public int GetLife() {return life;}

    public float GetSpeed() {return speed;}

    public void SetLife(int life) {this.life = life;}

    public void SetSpeed(float speed) {this.speed = speed;}

    public float GetXMove() {return xMove;}

    public float GetYMove() {return yMove;}

    public void SetXMove(float xMove) {this.xMove = xMove;}

    public void SetYMove(float yMove) {this.yMove = yMove;}
}

