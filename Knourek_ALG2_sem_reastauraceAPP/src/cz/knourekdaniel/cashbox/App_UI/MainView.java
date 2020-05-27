package cz.knourekdaniel.cashbox.App_UI;

import cz.knourekdaniel.cashbox.Tools.Conf;
import cz.knourekdaniel.cashbox.Tools.R;

import javax.swing.*;

/**
 * Class that creates JFrame and handles changing different Views of View type
 * Always access as MainView.app.
 */
public class MainView {

    public static MainView app;
    public Order_View ORDER_VIEW = new Order_View();
    public Overview_View OVERVIEW_VIEW = new Overview_View();

    public JPanel activePane;

    public JFrame frame;
    private String name = "Cashbox";
    private boolean shown = true;

    private MainView() {
        createFrame();

        frame.setVisible(this.shown);

    }

    private void createFrame() {
        this.frame = new JFrame(this.name);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setSize(1280,768);
        this.frame.setIconImage(R.img.get("icon-kazetko"));

        this.name = "Cashbox "+ Conf.conf.get("facility-name");
        this.frame.setTitle(this.name);

        this.activePane = new JPanel();
        frame.add(this.activePane);

    }
    public void setTitle(String title){
        this.frame.setTitle(this.name +" - "+ title);
    }

    /**
     * Changes App's main panel to specified view of type View.
     * @param view desired view to be shown.
     */
    public void changeTo(View view) {
        this.frame.remove(this.activePane);
        this.activePane = view.getMainPanel();
        this.frame.add(this.activePane);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * @return returns instance of MainView if not present it is created.
     */
    public static MainView start() {
        if( app == null){
            MainView.app = new MainView();
        }
        return MainView.app;
    }

    /**
     * Show basic alert window with specified message.
     * @param errorMessage message inside alert popup window.
     */
    public void exitError(String errorMessage){
        exitError(errorMessage, false);
    }

    /**
     * Show basic alert window with specified message.
     * @param errorMessage message inside alert popup window.
     * @param exit if true app will close after showing message.
     */
    public void exitError(String errorMessage,boolean exit){
        JOptionPane.showMessageDialog(null,errorMessage);
        if (exit){
            app.frame.dispose();
        }
    }
}
