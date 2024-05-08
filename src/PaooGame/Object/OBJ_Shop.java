package PaooGame.Object;

import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Shop extends SuperObject{
    public OBJ_Shop(RefLinks refLink){
        super(refLink);
        name = "Shop";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/textures/shop.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
