package cz.knourekdaniel.cashbox.App_UI;

import cz.knourekdaniel.cashbox.Tools.R;

import javax.swing.*;

public class MainView {

    public static MainView app;
    public Order_View ORDER_VIEW = new Order_View();
    public Overview_View OVERVIEW_VIEW = new Overview_View();

    public JPanel activePane;

    public JFrame frame;
    private String name = "Cashbox Kázetko";
    private boolean shown = true;

    public MainView() {
        createFrame();

        frame.setVisible(this.shown);

    }

    private void createFrame() {
        this.frame = new JFrame(this.name);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setSize(1280,768);
        this.frame.setIconImage(R.img.get("icon-kazetko"));

        this.activePane = new JPanel();
        frame.add(this.activePane);

    }
    public void setTitle(String title){
        this.frame.setTitle(this.name +" - "+ title);
    }

    public void changeTo(ViewMaster view) {
        this.frame.remove(this.activePane);
        this.activePane = view.getMainPanel();
        this.frame.add(this.activePane);
        this.frame.revalidate();
        this.frame.repaint();
    }


    public static MainView start() {
        if( app == null){
            MainView.app = new MainView();
        }
        return MainView.app;
    }
}
