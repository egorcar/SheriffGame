package PaooGame.Object;

import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.io.IOException;
public class OBJ_coin extends SuperObject{
    public OBJ_coin(RefLinks refLink){
        super(refLink);
        name = "PotionH";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/textures/coin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
