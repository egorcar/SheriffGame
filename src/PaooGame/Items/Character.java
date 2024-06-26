package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Random;

import static PaooGame.States.State.playSE;
import static java.lang.Math.sqrt;

/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    public BufferedImage image;
    public BufferedImage imUp;
    public BufferedImage imDown;
    public BufferedImage imLeft;
    public BufferedImage imRight;
    public static final int DEFAULT_LIFE            = 10;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED         = 4.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 60;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 60;   /*!< Inaltimea implicita a imaginii caracterului.*/
    public String direction = "Down";
    public boolean alive = true;
    public boolean dying = false;
    public int dyingCounter;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public int shotAvailableCouter;
    public boolean moving = true;
    boolean contactHero = false;
    public int life;     /*!< Retine viata caracterului.*/
    public float speed;  /*!< Retine viteza de deplasare caracterului.*/
    public int maxLife;
    public int maxMana;
    public int mana;
    public int attack = 1;
    public Projectile projectile;

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
        life    = DEFAULT_LIFE;
        maxLife = DEFAULT_LIFE;
        speed   = 4;
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

    public void MoveX() {
        if(yMove!=0) worldX += xMove / sqrt(2);
        else worldX += xMove;
    }
    public void MoveY() {
        if(xMove!=0) worldY += yMove / sqrt(2);
        else worldY += yMove;
    }
    public void setAction(){

    }

    public void Update(){
        xMove = 0;
        yMove = 0;

        setAction();


        collisionON = false;

        refLink.GetCChecker().checkTile(this);
        refLink.GetCChecker().checkObject(this, false);
        if(this!=refLink.GetHero()) contactHero = refLink.GetCChecker().checkPlayer(this);
        System.out.println(contactHero);

        if(!collisionON){
            if(direction == "Up") {yMove = -speed;}
            if(direction == "Down") {yMove = speed;}
            if(direction == "Left") {xMove = -speed;}
            if(direction == "Right") {xMove = speed;}
        }
        collisionON = false;
        refLink.GetCChecker().checkCharacters(refLink.GetHero(), refLink.GetNPC_Enemy());
        if(collisionON){
            System.out.println(this.worldX/48+" "+this.worldY/48);
            damagePlayer();
        }
        if(this.moving) Move();
    }

    public void damagePlayer(){
        if(!refLink.GetHero().invincible){
            int damage = attack;
            if(damage<0) damage = 0;
            refLink.GetHero().life -= damage;
            playSE(4);
            refLink.GetHero().invincible = true;
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

