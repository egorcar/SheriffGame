package PaooGame.Object;

import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.io.IOException;
public class OBJ_potionH extends SuperObject{
    public OBJ_potionH(RefLinks refLink){
        super(refLink);
        name = "PotionH";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/textures/whiskeyGlass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
