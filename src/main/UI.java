package main;

import entity.Player;
import main.object.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font omegle;
    BufferedImage /* OH BOY HERE WE GO */
    one_key, two_key, three_key, four_key,
    one_lock, two_lock, three_lock, four_lock,
    one_head, two_head, three_head, four_head,
    one_chestplate, two_chestplate, three_chestplate, four_chestplate,
    one_boots, two_boots, three_boots, four_boots;

    public UI(GamePanel gp)
    {
        this.gp=gp;
        omegle = new Font("OMEGLE", Font.PLAIN, 40);

        One_Key ok = new One_Key();
        one_key=ok.image;

        Two_Key tk = new Two_Key();
        two_key=tk.image;

        Three_Key thk = new Three_Key();
        three_key=thk.image;

        Four_Key fk = new Four_Key();
        four_key=fk.image;

        One_Lock ol = new One_Lock();
        one_lock=ol.image;

        Two_Lock tl=new Two_Lock();
        two_lock=tl.image;

        Three_Lock thl = new Three_Lock();
        three_lock=thl.image;

        Four_Lock fl = new Four_Lock();
        four_lock=fl.image;

        One_Head oh = new One_Head();
        one_head=oh.image;

        Two_Head th= new Two_Head();
        two_head=th.image;

        Three_Head thh = new Three_Head();
        three_head=thh.image;

        Four_Head fh = new Four_Head();
        four_head=fh.image;

        One_Chestplate oc =new One_Chestplate();
        one_chestplate=oc.image;

        Two_Chestplate tc = new Two_Chestplate();
        two_chestplate=tc.image;

        Three_Chestplate thc = new Three_Chestplate();
        three_chestplate=thc.image;

        Four_Chestplate fc = new Four_Chestplate();
        four_chestplate=fc.image;

        One_Boots ob = new One_Boots();
        one_boots=ob.image;

        Two_Boots tb = new Two_Boots();
        two_boots=tb.image;

        Three_Boots thb = new Three_Boots();
        three_boots=thb.image;

        Four_Boots fb = new Four_Boots();
        four_boots=fb.image;
    }
    public void drawImage(Graphics2D g2, int identifier)
    {
        g2.setFont(omegle);
        g2.setColor(Color.white);
        switch (identifier) {

            case 1:                                    //Tier 1 Key
                if (gp.gethelper()<3) {
                    g2.drawString("Picked up Common Key!", 400, 710);
                }
                g2.drawImage(one_key, gp.tileSize/4, gp.tileSize/4, gp.tileSize, gp.tileSize, null);
                g2.drawString("x "+gp.player.getCommon_Key(), 74, 50);
                break;

            case 2:                                    //Tier 1 Lock
                if (gp.gethelper()<3) {
                    g2.drawString("Common key used!", 440, 710);
                    if (gp.player.getCommon_Key()!=0)
                    {
                        g2.drawImage(one_key, gp.tileSize/4, gp.tileSize/4, gp.tileSize, gp.tileSize, null);
                        g2.drawString("x "+gp.player.getCommon_Key(), 74, 50);
                    }
                }
                break;

            case 3:                                    //No Key for Tier 1 Lock
                if (gp.gethelper()<3) {
                    g2.drawString("You need a common key to open this Lock!", 220, 710);
                }
                break;

            case 4:                                    //Tier 2 Key
                if (gp.gethelper()<3) {
                    g2.drawString("Picked up Uncommon Key!", 380, 710);
                }
                g2.drawImage(one_key, gp.tileSize/4, gp.tileSize/4, gp.tileSize, gp.tileSize, null);
                g2.drawString("x "+gp.player.getUncommon_Key(), 74, 50);
                break;

            case 5:                                    //Tier 2 Lock
                if (gp.gethelper()<3) {
                    g2.drawString("Uncommon key used!", 440, 710);
                    if (gp.player.getCommon_Key()!=0)
                    {
                        g2.drawImage(two_key, gp.tileSize/4, gp.tileSize/4, gp.tileSize, gp.tileSize, null);
                        g2.drawString("x "+gp.player.getUncommon_Key(), 74, 50);
                    }
                }
                break;

            case 6:                                    //No Key for Tier 2 Lock

                break;

            case 7:                                    //Tier 3 Key

                break;

            case 8:                                    //Tier 3 Lock

                break;
            case 9:                                    //No Key for Tier 3 Lock

                break;
            case 10:                                    //Tier 4 Key

                break;
            case 11:                                    //Tier 4 Lock

                break;
            case 12:                                    //No Key for Tier 4 Lock

                break;

        }
        // Line to test new UI elements added
        g2.drawImage(three_key, gp.tileSize/4, gp.tileSize*2+gp.tileSize/4+4, gp.tileSize, gp.tileSize, null);
        g2.drawImage(four_key, gp.tileSize/4, gp.tileSize*3+gp.tileSize/4+6, gp.tileSize, gp.tileSize, null);
    }
}
