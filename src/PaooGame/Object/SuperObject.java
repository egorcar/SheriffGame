package PaooGame.Object;

import PaooGame.RefLinks;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.sql.Ref;

public class SuperObject {
    public BufferedImage img;
    public String name;
    public boolean collision = false;
    public int worldX;
    public int worldY;
    private RefLinks refLink;

    public SuperObject(RefLinks refLink){
        this.refLink = refLink;
    }

}
