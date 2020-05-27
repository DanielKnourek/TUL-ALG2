package cz.knourekdaniel.cashbox.App;

import cz.knourekdaniel.cashbox.App_UI.MainView;

public interface ui_logic {


    /**
     * Creates or restarts View and all logic is done agin
     */
    static void start() {
        setVisible();
    }

    /**
     * Shows view in its current state.
     */
    static void setVisible() {
    }
}
