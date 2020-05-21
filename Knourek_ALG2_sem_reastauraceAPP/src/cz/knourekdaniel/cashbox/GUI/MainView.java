package cz.knourekdaniel.cashbox.GUI;

import cz.knourekdaniel.cashbox.GUI.Components.Menu;
import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.R;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainView {
public static MainView app;
private String name = "Window";
private boolean shown = true;

    public MainView(){


        JFrame frame = new JFrame(this.name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 1000);
        frame.setTitle("new Name");
            frame.setIconImage(R.img.get("icon-kazetko"));
            




        frame.add(new Menu(200, 200));
        List<String[]> cols = new ArrayList<>();

        for (String s : Conf.conf.stringPropertyNames().toString().split(",")) {
            cols.add(new String[]{s,""});
        }
        for (int i = 0; i < Conf.conf.values().toString().split(",").length; i++) {
            cols.get(i)[1] = Conf.conf.values().toString().split(",")[i];
        }



        String[] colNames = {"Key","Value"};
        String[][] data = Arrays.copyOf(cols.toArray(), cols.toArray().length, String[][].class);
        JTable table = new JTable(data,colNames);
        table.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);

        frame.setVisible(this.shown);

    }

    public static void start(){
        MainView.app = new MainView();
    }
}
