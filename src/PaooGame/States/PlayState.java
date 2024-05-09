package PaooGame.States;

import PaooGame.*;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Items.Hero;
import PaooGame.Object.SuperObject;
import PaooGame.Maps.Map;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    public AssetSetter assetSetter;
    //public CollisionChecker cChecker;
    public SuperObject []obj;

    public static Sound sound;
    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
        ///Construieste harta jocului
        map = new Map(refLink);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);

        sound = new Sound();

        ///Construieste eroul
        hero = new Hero(refLink, GameWindow.GetHalfWidth(), GameWindow.GetHalfHeight());
        //cChecker = new CollisionChecker(refLink);
        assetSetter = new AssetSetter(refLink);
        obj = new SuperObject[10];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = new SuperObject(refLink);
        }
        refLink.SetSuperObject(obj);
        assetSetter.setObject();
        playMusic(0);









    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        //Draw map:
        map.Draw(g, hero);
        //Draw objects:
        for(int i = 0; i<this.obj.length; i++){
            if(this.obj[i]!=null){
                this.obj[i].Draw(refLink, hero, g);
            }
        }
        //Draw hero:
        hero.Draw(g);
    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }
    public static void playSE(int i){
        sound.setFile(i);
        sound.play();
    }


}
