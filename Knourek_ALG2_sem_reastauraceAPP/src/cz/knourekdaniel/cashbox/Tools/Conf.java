package cz.knourekdaniel.cashbox.Tools;

import cz.knourekdaniel.cashbox.App_UI.MainView;

/**
 * Public class containing reference on loaded configurations
 *  - conf: Properties of main configurations.
 *  - images: Properties of images filepaths.
 */
public class Conf {
    private static boolean initialized = false;

    /**
     * filepath to the package of Main.java
     */
    public static final String appFolder = "#/cz/knourekdaniel/cashbox/";

    /**
     * Properties of main configurations.
     */
    public static ConfigLoader conf ;

    /**
     * Properties of images filepaths.
     */
    public static ConfigLoader images ;

    /**
     * Assigns to all variables reference to property variables.
     * Helps to launch loading configuration whenever necessary.
     * Can be called only once.
     */
    public static void load(){
        if (initialized){

            MainView.app.exitError("Chyba při běhu programu: Conf already loaded", false);
            return;
        }
        initialized = true;
        conf = new ConfigLoader(Conf.appFolder + "Assets/Properties/","data/","Conf.xml");
        images = new ConfigLoader(Conf.appFolder + "Assets/Properties/","","Images.xml");
    }
}