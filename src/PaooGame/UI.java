package PaooGame;

import java.awt.*;

public class UI {
    RefLinks refLink;
    Font arial40;

    public UI(RefLinks refLink){
        this.refLink = refLink;
        arial40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void draw(Graphics g, RefLinks refLink){
        g.setFont(arial40);
        g.setColor(Color.white);
        g.drawString("Potions = "+ this.refLink.GetHero().hasPotion, 50, 50);

    }
}
