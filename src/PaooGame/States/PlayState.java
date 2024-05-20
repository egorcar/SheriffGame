package PaooGame.States;

import PaooGame.*;
import PaooGame.DataBase.DataBaseHelper;
import PaooGame.GameWindow.GameWindow;
//import PaooGame.Items.Cactus;
import PaooGame.Graphics.Assets;
import PaooGame.Items.Character;
import PaooGame.Items.Hero;
import PaooGame.Items.NPC_Enemy;
import PaooGame.Object.SuperObject;
import PaooGame.Maps.Map2;
import PaooGame.Items.InteractiveTile;

import java.awt.*;
import java.util.ArrayList;

// import static PaooGame.DataBase.DataBaseHelper.createTables;


/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map2 map;    /*!< Referinta catre harta curenta.*/
    public AssetSetter assetSetter;
    public CollisionChecker cChecker;
    public SuperObject []obj;
    public NPC_Enemy[] npc;
    public InteractiveTile[] iTIle;

    public ArrayList<Character> projectileList;

    public UI ui;
    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
        state = "PlayState";
        ///Construieste harta jocului
        map = new Map2(refLink);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);

        cChecker = new CollisionChecker(refLink);
        refLink.SetCChecker(cChecker);

        music = new Sound();
        se = new Sound();

        ui = new UI(refLink);
        refLink.SetUI(ui);

        ///Construieste eroul
        hero = new Hero(refLink, GameWindow.GetHalfWidth(), GameWindow.GetHalfHeight());
        refLink.SetHero(hero);

        //Construieste obiectele
        assetSetter = new AssetSetter(refLink);
        obj = new SuperObject[10];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = new SuperObject(refLink);
        }
        refLink.SetSuperObject(obj);
        assetSetter.setObject();

        //Construieste npc-urile
        npc = new NPC_Enemy[30];
        for (int i = 0; i < npc.length; i++) {
            npc[i] = new NPC_Enemy(refLink, 10, 10, 48, 48);
        }
        refLink.SetNPC_Enemy(npc);
        assetSetter.setNpc();

        //Construiesc tile-urile interactive
        iTIle = new InteractiveTile[50];
        for (int i = 0; i < iTIle.length; i++) {
            iTIle[i] = new InteractiveTile(refLink, 10, 10, 48, 48);
        }
        refLink.SetInteractiveTile(iTIle);
        assetSetter.setInteractiveTile();

        projectileList = new ArrayList<>();
        refLink.SetProjectileList(projectileList);

        //Porneste muzica
        //playMusic(0);
    }

    public void InitState(){
        {
            ///Apel al constructorului clasei de baza
            state = "PlayState";
            ///Construieste harta jocului
            map = new Map2(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
            refLink.SetMap(map);

            cChecker = new CollisionChecker(refLink);
            refLink.SetCChecker(cChecker);

            music = new Sound();
            se = new Sound();

            ui = new UI(refLink);
            refLink.SetUI(ui);

            ///Construieste eroul
            hero = new Hero(refLink, GameWindow.GetHalfWidth(), GameWindow.GetHalfHeight());
            refLink.SetHero(hero);

            //Construieste obiectele
            assetSetter = new AssetSetter(refLink);
            obj = new SuperObject[10];
            for (int i = 0; i < obj.length; i++) {
                obj[i] = new SuperObject(refLink);
            }
            refLink.SetSuperObject(obj);
            assetSetter.setObject();

            //Construieste npc-urile
            npc = new NPC_Enemy[30];
            for (int i = 0; i < npc.length; i++) {
                npc[i] = new NPC_Enemy(refLink, 10, 10, 48, 48);
            }
            refLink.SetNPC_Enemy(npc);
            assetSetter.setNpc();

            //Construiesc tile-urile interactive
            iTIle = new InteractiveTile[50];
            for (int i = 0; i < iTIle.length; i++) {
                iTIle[i] = new InteractiveTile(refLink, 10, 10, 48, 48);
            }
            refLink.SetInteractiveTile(iTIle);
            assetSetter.setInteractiveTile();

            projectileList = new ArrayList<>();
            refLink.SetProjectileList(projectileList);

            // createTables();
            DataBaseHelper db = refLink.getDatabase();
            // if(db != null) {
            db.loadProgress();
            hero.worldY = db.worldY;
            hero.worldX = db.worldX;
            hero.life = db.life;
            hero.hasKey = db.hasKey;
            hero.hasCoin = db.hasCoin;
            hero.direction = db.direction;
            // }
            //Porneste muzica
            //playMusic(0);
        }
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        for(int i = 0; i< npc.length; i++){
            if(npc[i] != null){
                if(npc[i].alive && !npc[i].dying){
                    npc[i].Update();
                }
                if(!npc[i].alive){
                    npc[i] = null;
                }
            }
        }

        for(int i = 0; i< projectileList.size(); i++){
            if(projectileList.get(i) != null){
                if(projectileList.get(i).alive){
                    projectileList.get(i).Update();
                }
                if(!projectileList.get(i).alive){
                    projectileList.remove(i);
                }
            }
        }


        for(int i = 0; i<iTIle.length; i++){
            /*if(iTIle[i]!=null){
                iTIle[i].Update();
            }*/
            iTIle[i].Update();
        }
        /*if(refLink.GetHero().hasCoin==3) {
            State.SetState(refLink.GetGame().menuState);
            refLink.GetHero().hasCoin=0;
        }*/

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
        //Draw interactive tiles:
        for(int i = 0; i<iTIle.length; i++){
            if(this.iTIle!=null){
                this.iTIle[i].Draw(refLink, hero, g);
            }
        }
        //Draw objects:
        for(int i = 0; i<this.obj.length; i++){
            if(this.obj[i]!=null){
                this.obj[i].Draw(refLink, hero, g);
            }
        }
        //Draw hero:
        hero.Draw(refLink, g);

        //Draw npcs;
        for(int i = 0; i<this.npc.length; i++){
            if(this.npc[i]==null){
                //System.out.println(i);
            }
            else this.npc[i].Draw(refLink, hero, g);
        }

        for(int i = 0; i<this.projectileList.size(); i++){
            if(refLink.GetProjectileList().get(i) != null){
                refLink.GetProjectileList().get(i).Draw(refLink, g);
            }
        }

        //Draw ui:
        ui.draw(g, refLink);

        //Debug
        if(refLink.GetHero().checkDrawTime){
            long drawEnd = System.nanoTime();
            long passsed = drawEnd - drawStart;
            System.out.println(passsed);
        }
    }




}
