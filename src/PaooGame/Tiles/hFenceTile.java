package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class hFenceTile extends Tile
{
    public hFenceTile(int id)
    {
        super(Assets.hfence, id);
        solid = true;
    }
}
