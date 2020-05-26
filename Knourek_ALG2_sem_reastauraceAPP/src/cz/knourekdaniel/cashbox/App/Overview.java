package cz.knourekdaniel.cashbox.App;

import cz.knourekdaniel.cashbox.App_UI.MainView;
import cz.knourekdaniel.cashbox.App_UI.Overview_View;
import cz.knourekdaniel.cashbox.Items.Item;

import java.util.HashMap;

public class Overview implements ui_logic {
    static MainView app;

    private HashMap<Integer, Item> OrderedItemsMap = new HashMap<>();

    public static void start() {
        if (app == null){
            app = MainView.start();
        }
        app.OVERVIEW_VIEW = new Overview_View();
        setVisible();
    }

    public static void setVisible(){
        app.OVERVIEW_VIEW.setOrderedItemsMap(app.ORDER_VIEW.getOrderedItemsMap());

        app.OVERVIEW_VIEW.Update();
        app.changeTo(app.OVERVIEW_VIEW);
        app.setTitle("Přehled");
    }
}
