package cz.knourekdaniel.cashbox;

import cz.knourekdaniel.cashbox.App.Order;
import cz.knourekdaniel.cashbox.App.Overview;
import cz.knourekdaniel.cashbox.App_UI.MainView;
import cz.knourekdaniel.cashbox.App_UI.Order_View;
import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.R;

import java.awt.event.KeyEvent;

public class TestUnit {
    public static void main(String[] args){
        Conf.load();
        R.load();
        Order.start();

        SimUser();
    }

    private static void SimUser() {
        try {
            Thread.sleep(500);
            MainView.app.ORDER_VIEW.KeyboardClick(KeyEvent.VK_DOWN);
            MainView.app.ORDER_VIEW.addToList(1);
            MainView.app.ORDER_VIEW.addToList(1);

            Thread.sleep(500);
            MainView.app.ORDER_VIEW.addToList(1);
            MainView.app.ORDER_VIEW.KeyboardClick(KeyEvent.VK_DOWN);
            MainView.app.ORDER_VIEW.KeyboardClick(KeyEvent.VK_DOWN);
            MainView.app.ORDER_VIEW.KeyboardClick(KeyEvent.VK_DOWN);

            Thread.sleep(500);
            MainView.app.ORDER_VIEW.addToList(1);
            MainView.app.ORDER_VIEW.KeyboardClick(KeyEvent.VK_DOWN);
            MainView.app.ORDER_VIEW.addToList(1);

            Thread.sleep(500);
            MainView.app.ORDER_VIEW.filter("B");
            Thread.sleep(500);
            MainView.app.ORDER_VIEW.filter("Bi");
            Thread.sleep(500);
            MainView.app.ORDER_VIEW.filter("Bo");
            Thread.sleep(500);
            MainView.app.ORDER_VIEW.filter("Bo 250");
            Thread.sleep(500);
            MainView.app.ORDER_VIEW.KeyboardClick(KeyEvent.VK_DOWN);
            MainView.app.ORDER_VIEW.addToList(1);
            MainView.app.ORDER_VIEW.addToList(1);

            Thread.sleep(500);
            Overview.start();
            Thread.sleep(500);





























        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
