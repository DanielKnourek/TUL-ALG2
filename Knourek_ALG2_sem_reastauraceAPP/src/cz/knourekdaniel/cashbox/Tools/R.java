package cz.knourekdaniel.cashbox.Tools;

import cz.knourekdaniel.cashbox.Main;

import java.io.FileInputStream;
import java.io.InputStream;

public class R {
    private static boolean initialized = false;

    public static ImageLoader img;

    public static void load(){
        if (initialized){
            //TODO throw error
            return;
        }
        initialized = true;
        img = new ImageLoader();

    }

    /**
     * "#" as first character decides if you are opening file inside package or in local directory
     * @param file specifies path and name to the file
     * @return creates InputStream of specified File
     */
    public static InputStream newFiS(String file){
        InputStream FiS = null;
        try {
            if (file.matches("#.*")) {
                FiS = Main.class.getResourceAsStream(file.substring(1));
            } else {
                FiS = new FileInputStream(file);
            }
        } catch (Exception e) {
            //TODO log exeption
//            e.printStackTrace();
        }
        return FiS;
    }
}

