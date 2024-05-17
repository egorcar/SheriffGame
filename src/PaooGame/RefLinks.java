package PaooGame;

import PaooGame.Items.Hero;
import PaooGame.Items.NPC_Enemy;
import PaooGame.Maps.Map2;

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
    private Map2 map;            /*!< Referinta catre harta curenta.*/

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
    public KeyManager GetKeyManager() {return game.GetKeyManager();}

    public int GetWidth() { return game.GetWidth(); }

    public int GetHeight() { return game.GetHeight(); }


    public Game GetGame()
    {
        return game;
    }

    public void SetGame(Game game)
    {
        this.game = game;
    }

    public Map2 GetMap()
    {
        return map;
    }
    public void SetMap(Map2 map)
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
