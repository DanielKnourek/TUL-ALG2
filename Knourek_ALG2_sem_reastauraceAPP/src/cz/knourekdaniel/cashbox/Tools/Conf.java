package cz.knourekdaniel.cashbox.Tools;

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
            //TODO throw error
            return;
        }
        initialized = true;
        conf = new ConfigLoader(Conf.appFolder + "Assets/Properties/","data/","Conf.xml");
        images = new ConfigLoader(Conf.appFolder + "Assets/Properties/","","Images.xml");
    }
}