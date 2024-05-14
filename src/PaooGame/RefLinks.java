package PaooGame;

import PaooGame.Items.Hero;
import PaooGame.Items.NPC_Enemy;
import PaooGame.Maps.Map;

import PaooGame.Input.KeyManager;
import PaooGame.Object.SuperObject;

/*! \class public class RefLinks
    \brief Clasa ce retine o serie de referinte ale unor elemente pentru a fi usor accesibile.

    Altfel ar trebui ca functiile respective sa aiba o serie intreaga de parametri si ar ingreuna programarea.
 */
public class RefLinks
{
    private Hero hero;
    private Game game;          /*!< Referinta catre obiectul Game.*/
    private Map map;            /*!< Referinta catre harta curenta.*/

    private CollisionChecker cChecker;
    private AssetSetter assetSetter;
    private SuperObject []obj;
    private Sound sound;
    private UI ui;
    private NPC_Enemy[] npc1;


    /*! \fn public RefLinks(Game game)
        \brief Constructorul de initializare al clasei.

        \param game Referinta catre obiectul game.
     */
    public RefLinks(Game game)
    {
        this.game = game;
    }

    /*! \fn public KeyManager GetKeyManager()
        \brief Returneaza referinta catre managerul evenimentelor de tastatura.
     */
    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }

    /*! \fn public int GetWidth()
        \brief Returneaza latimea ferestrei jocului.
     */
    public int GetWidth() { return game.GetWidth(); }

    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei jocului.
     */
    public int GetHeight() { return game.GetHeight(); }

    /*! \fn public Game GetGame()
        \brief Intoarce referinta catre obiectul Game.
     */
    public Game GetGame()
    {
        return game;
    }

    /*! \fn public void SetGame(Game game)
        \brief Seteaza referinta catre un obiect Game.

        \param game Referinta obiectului Game.
     */
    public void SetGame(Game game)
    {
        this.game = game;
    }

    /*! \fn public Map GetMap()
        \brief Intoarce referinta catre harta curenta.
     */
    public Map GetMap()
    {
        return map;
    }

    /*! \fn public void SetMap(Map map)
        \brief Seteaza referinta catre harta curenta.

        \param map Referinta catre harta curenta.
     */
    public void SetMap(Map map)
    {
        this.map = map;
    }
    public Hero GetHero(){return hero;}
    public void SetHero(Hero hero){this.hero = hero;}

    public CollisionChecker GetCChecker(){return cChecker;}
    public void SetCChecker(CollisionChecker cChecker){this.cChecker = cChecker;}

    public SuperObject[] GetSuperObject(){return obj;}
    public  void SetSuperObject(SuperObject []obj){this.obj = obj;}

    public Sound GetSound(){return sound;}
    public void SetSound(Sound sound){this.sound = sound;}

    public UI GetUI(){return ui;}
    public void SetUI(UI ui){this.ui = ui;}

    public NPC_Enemy[] GetNPC_Enemy(){return npc1;}
    public void SetNPC_Enemy(NPC_Enemy[] npc1){this.npc1 = npc1;}
}
