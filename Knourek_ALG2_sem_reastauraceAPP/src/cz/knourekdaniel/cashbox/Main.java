package cz.knourekdaniel.cashbox;

import cz.knourekdaniel.cashbox.GUI.MainView;
import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.R;

import java.awt.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello world");

        Conf.load();
        R.load();
        MainView.start();
        HashMap<String, Image> my = new HashMap<>();

    }

}
