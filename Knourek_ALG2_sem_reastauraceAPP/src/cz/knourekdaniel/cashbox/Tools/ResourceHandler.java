package cz.knourekdaniel.cashbox.Tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Parent class for loading hashmap of loaded resources.
 * @param <V> Object type of hashmap value
 */
public class ResourceHandler<V> extends HashMap<String, Object> {

    /**
     *  Returns
     * @return hashmap class with <String> key of <V> values.
     */
    public static <V> V callLoader(){
//        Image.class.equals(new V());
////        if (V === Image){
//
//        System.out.println("Hello");
        return (V) new ImageLoader();
//        }
    }

    /**
     *
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     */
    public V get(String key){
        return (V) super.get(key);
    }

    /**
     *
     * @param key the key whose associated value is to be returned
     * @param defaultValue the default mapping of the key
     * @return the value to which the specified key is mapped,
     * or defaultValue if this map contains no mapping for the key
     */
    public V getOrDefault(String key, V defaultValue) {
        return this.getOrDefault(key, defaultValue);
    }
}

/**
 * Generates hashmap with Image values from properties Conf.images,
 * unreachable files are replaced with "img_404" not found image.
 */
class ImageLoader extends ResourceHandler<Image> {
    public static Image img_404 = null;
    ImageLoader(){
        if (img_404 == null){
            img_404 = LoadImage(Conf.appFolder + "Assets/404.png");
        }
        //TODO remove
        this.put("404",img_404);

        Conf.images.forEach((key, file) -> this.put((String) key,LoadImage((String)file)) );

    }

    private static Image LoadImage(String fileLocation) {
        Image img = null;

        try {
            InputStream FiS = R.newFiS(fileLocation);
            if (FiS != null){
                try {
                    img = ImageIO.read(FiS);
                } finally {
                    FiS.close();
                }
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

