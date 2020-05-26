package cz.knourekdaniel.cashbox;

import cz.knourekdaniel.cashbox.App.Order;
import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.R;

public class Main {

    /**
     *  Begginig of application, loading configurations & resources
     * @param args change program behavior
     *             <not yet implemented>
     */
    public static void main(String[] args){
        Conf.load();
        R.load();
        Order.start();
    }

}
