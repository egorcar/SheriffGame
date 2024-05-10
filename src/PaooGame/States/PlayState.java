package PaooGame.States;

import PaooGame.*;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Items.Hero;
import PaooGame.Object.SuperObject;
import PaooGame.Maps.Map;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

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

    public static Sound se;
    public static Sound music;
    public UI ui;
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

        music = new Sound();
        se = new Sound();

        ui = new UI(refLink);
        refLink.SetUI(ui);

        ///Construieste eroul
        hero = new Hero(refLink, GameWindow.GetHalfWidth(), GameWindow.GetHalfHeight());
        refLink.SetHero(hero);
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
        long drawStart = 0;
        drawStart = System.nanoTime();
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

        ui.draw(g, refLink);
        //Debug
        if(refLink.GetHero().checkDrawTime){
            long drawEnd = System.nanoTime();
            long passsed = drawEnd - drawStart;
            System.out.println(passsed);
        }
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }
    public static void playSE(int i){
        se.setFile(i);
        se.play();
    }


}
