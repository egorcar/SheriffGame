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
    public String direction = "Up";

    protected int life;     /*!< Retine viata caracterului.*/
    public float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

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
        life    = DEFAULT_LIFE;
        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
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
        setAction();
        collisionON = false;
        cChecker.checkTileNPC(this);
        //refLink.GetCChecker().checkTileNPC(this);
        //System.out.println(direction);
        if(!collisionON){
            Move();
            if(direction == "Up") {yMove = -speed;}
            if(direction == "Down") {yMove = speed;}
            if(direction == "Left") {xMove = -speed;}
            if(direction == "Right") {xMove = speed;}
        }
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

