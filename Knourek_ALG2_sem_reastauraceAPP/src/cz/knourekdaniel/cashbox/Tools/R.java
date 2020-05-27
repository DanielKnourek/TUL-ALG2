package cz.knourekdaniel.cashbox.Tools;

import cz.knourekdaniel.cashbox.App_UI.MainView;
import cz.knourekdaniel.cashbox.Items.Item;
import cz.knourekdaniel.cashbox.Main;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Public class containing reference on loaded resources
 *  - img: hashmap of loaded images.
 */
public class R {
    private static boolean initialized = false;



    /**
     * Hashmap of loaded images.
     */
    public static ResourceHandler<Image> img;
    public static ResourceHandler<Item> item;


    /**
     * Assigns to all variables reference maps to resources.
     * Helps to launch loading resources whenever necessary.
     * Can be called only once.
     */
    public static void load(){
        if (initialized){

            MainView.app.exitError("Neočekávaná chyba při čtení souboru", false);
            return;
        }
        initialized = true;
        img = ResourceHandler.callLoader("ImageLoader");
        item = ResourceHandler.callLoader("ItemLoader");
    }

    /**
     * "#" as first character decides if you are opening file inside package or in local directory
     * @param filepath specifies path and name to the file
     * @return creates InputStream of specified File
     *
     *"#filepath" gives inputstream of file inside project.
     * Returned by Main.class.getResourceAsStream()
     *  exaple: "#/cz/knourekdaniel/cashbox/"
     *
     * "filepath" gives inputstream of file inside working directory.     *
     * Returned by FileInputStream()
     *  example: "./data/data.mv.db"
     */
    public static InputStream newFiS(String filepath){
        InputStream FiS = null;
        try {
            if (filepath.matches("#.*")) {
                FiS = Main.class.getResourceAsStream(filepath.substring(1));
            } else {
                FiS = new FileInputStream(filepath);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return FiS;
    }
}



