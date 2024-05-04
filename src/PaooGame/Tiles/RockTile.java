package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class MountainTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip munte sau piatra.
 */
public class RockTile extends Tile {

    public RockTile(int id)
    {
            /// Apel al constructorului clasei de baza
        super(Assets.rock, id);
        solid = true;
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */

}
