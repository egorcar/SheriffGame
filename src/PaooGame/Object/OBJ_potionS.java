package PaooGame.Object;

import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.io.IOException;
public class OBJ_potionS extends SuperObject{
    public OBJ_potionS(RefLinks refLink){
        super(refLink);
        name = "PotionS";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/textures/beerBottle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
