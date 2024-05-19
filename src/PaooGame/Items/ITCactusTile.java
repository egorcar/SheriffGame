package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public class ITCactusTile extends InteractiveTile{

    public ITCactusTile(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
        this.worldX = Tile.TILE_WIDTH * x;
        this.worldY = Tile.TILE_HEIGHT * y;

        image = Assets.cactus;
        destructible = true;
    }

}
