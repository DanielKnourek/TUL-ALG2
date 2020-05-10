package cz.knourekdaniel.cashbox.GUI;

import cz.knourekdaniel.cashbox.GUI.Components.Menu;
import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.R;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class MainView {

private String name = "Window";
private boolean shown = true;

    public MainView(){


        JFrame frame = new JFrame(this.name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 1000);
        frame.setTitle("new Name");
//        getClass().getClassLoader().getResource()
        try {
            frame.setIconImage(ImageIO.read(getClass().getResourceAsStream("/cz/knourekdaniel/cashbox/Assets/logo_Kazetko.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(new Menu(200, 200));

        frame.setVisible(this.shown);

    }

    public static void start(){
        new MainView();
    }
}
