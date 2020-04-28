package cz.knourekdaniel.SwingFun.GUI.Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private boolean shown = true;
    private Image bg;

    public Menu(int height, int width) {
        this.setSize(height, width);
        this.setBackground(Color.CYAN);

        this.setVisible(shown);

        //TODO TRY catch
        try {
            this.bg = ImageIO.read(getClass().getResourceAsStream("/cz/knourekdaniel.SwingFun/Assets/cookies.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

