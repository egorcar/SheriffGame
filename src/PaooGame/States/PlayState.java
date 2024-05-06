package PaooGame.States;

import PaooGame.AssetSetter;
import PaooGame.CollisionChecker;
import PaooGame.Game;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Items.Hero;
import PaooGame.Object.SuperObject;
import PaooGame.RefLinks;
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
        ///Construieste eroul
        hero = new Hero(refLink, GameWindow.GetHalfWidth(), GameWindow.GetHalfHeight());
        //cChecker = new CollisionChecker(refLink);
        assetSetter = new AssetSetter(refLink);

        obj = new SuperObject[]{new SuperObject(refLink)};
        refLink.SetSuperObject(obj);

        assetSetter.setObject();
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
        map.Draw(g, hero);
        hero.Draw(g);
    }
}
