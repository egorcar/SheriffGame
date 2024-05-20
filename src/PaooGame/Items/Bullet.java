package PaooGame.Items;

import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Bullet extends Projectile{
    public Bullet(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        alive = false;
        getImage();
    }
    public void getImage(){
        try {
            imUp = ImageIO.read(getClass().getResourceAsStream("/textures/bulletUp.png"));
            imDown = ImageIO.read(getClass().getResourceAsStream("/textures/bulletDown.png"));
            imLeft = ImageIO.read(getClass().getResourceAsStream("/textures/bulletLeft.png"));
            imRight = ImageIO.read(getClass().getResourceAsStream("/textures/bulletRight.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
