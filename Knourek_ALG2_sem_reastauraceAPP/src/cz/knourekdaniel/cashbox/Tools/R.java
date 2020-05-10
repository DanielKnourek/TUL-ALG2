package cz.knourekdaniel.cashbox.Tools;

import cz.knourekdaniel.cashbox.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

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

class ImageLoader extends HashMap<String, Image> {
    public static Image img_404 = null;
    ImageLoader(){


        if (img_404 == null){
//            try {
//                img_404 = ImageIO.read(R.newFiS(Conf.appFolder + "Assets/404.png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            img_404 = LoadImage(Conf.appFolder + "Assets/404.png");
        }
        this.put("404",img_404);

        Conf.images.forEach((key, file) -> this.put((String) key,LoadImage((String)file)) );

    }

    private Image LoadImage(String fileLocation) {
//        R.newFiS(file)
        Image img = null;

        try {
            InputStream FiS = R.newFiS(fileLocation);
            if (FiS != null){
                img = ImageIO.read(FiS);
                FiS.close();
            }else{
                img = img_404;
            }
        } catch (IOException e) {
            //TODO logging catch
            e.printStackTrace();
        }
        return img;
    }


}
