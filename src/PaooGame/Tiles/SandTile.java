package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class SandTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SandTile(int id)
    {
            /// Apel al constructorului clasei de baza
        super(Assets.sand, id);
        //solid = false;
    }
}
