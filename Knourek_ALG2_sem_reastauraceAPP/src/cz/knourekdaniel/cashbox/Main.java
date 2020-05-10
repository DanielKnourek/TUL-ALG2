package cz.knourekdaniel.cashbox;

import cz.knourekdaniel.cashbox.GUI.MainView;
import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.ImageLoader;
import cz.knourekdaniel.cashbox.Tools.R;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello world");

        Conf.load();
        R.load();
        MainView.start();

        System.out.println("Hello world");

    }

}
