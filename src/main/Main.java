/* Lost in the Woods - Epic Odyssey to Reunite
Author: Razvan Ruxandari
Number of days worked: 21
Actual time spent: 57
Game's official OST: https://www.youtube.com/playlist?list=PLN8jvvZDAX7wY90-ux0yyEAl5XBNDA8Pf
*/
package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //so when we press X it actually closes
        window.setResizable(false); //we're not doing responsive websites here - we're making a fully functional game that I'd play!
        window.setTitle("Lost in the Woods - Epic Odyssey to Reunite");
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        window.setIconImage(icon);
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.SetupGame();
        gamePanel.startGameThread();
    }
}