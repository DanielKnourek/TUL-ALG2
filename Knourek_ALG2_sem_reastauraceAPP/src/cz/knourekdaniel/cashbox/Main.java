package cz.knourekdaniel.cashbox;

import cz.knourekdaniel.cashbox.App.Order;
import cz.knourekdaniel.cashbox.App_UI.MainView;
import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.DBhandler;
import cz.knourekdaniel.cashbox.Tools.R;

public class Main {

    /**
     *  Begginig of application, loading configurations & resources
     * @param args change program behavior
     *             <not yet implemented>
     */
    public static void main(String[] args){
        System.out.println("Hello world");
        Conf.load();
        R.load();
//        DBhandler dbtest = new DBhandler();
        Order.start();
    }

}
