package cz.knourekdaniel.cashbox.App;

import cz.knourekdaniel.cashbox.App_UI.MainView;
import cz.knourekdaniel.cashbox.App_UI.Order_View;
import cz.knourekdaniel.cashbox.Items.Item;
import cz.knourekdaniel.cashbox.Tools.R;

import java.util.Arrays;

public class Order implements ui_logic {
    static MainView app;

    public static void start() {
        if (app == null){
            app = MainView.start();
        }
        app.ORDER_VIEW = new Order_View();
        LoadToTable();


        setVisible();
    }

    public static void setVisible(){
        app.changeTo(app.ORDER_VIEW);
        app.setTitle("Objednávka");
    }

    private static void LoadToTable() {
        //TODO Coll names!
        app.ORDER_VIEW.CreateTable(Arrays.copyOf(Item.getColNames(),Item.getColNames().length-2));
        R.item.forEach((key, item) -> app.ORDER_VIEW.addTableEntry(((Item) item).asArray()));
    }
}
