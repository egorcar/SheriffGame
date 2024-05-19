package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class vGateTile extends Tile
{
    public vGateTile(int id)
    {
        super(Assets.vGate, id);
        solid = true;
    }
}