package cz.knourekdaniel.cashbox.Tools;

import cz.knourekdaniel.cashbox.Items.Beverage;
import cz.knourekdaniel.cashbox.Items.Item;
import cz.knourekdaniel.cashbox.Items.Meal;
import cz.knourekdaniel.cashbox.Items.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Parent class for loading hashmap of loaded resources.
 * @param <V> Object type of hashmap value
 */
public abstract class ResourceHandler<V> extends HashMap<String, Object> {

    /**
     *  Returns
     * @return hashmap class with <String> key of <V> values.
     */
    public static <V> V callLoader(String clazz){
        V Loader = null;

        if (clazz.matches("ImageLoader")){
            return (V) new ImageLoader();
        }

        if (clazz.matches("ItemLoader")){
            return (V) new ItemLoader();
        }
        return null;
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

class ItemLoader extends ResourceHandler<Item>{
    public static final String[] colNames = "ID,NAME,PRICE,QTY,UNIT,DPH,CATEGORY,DESCRIPTION,KEYWORDS".split(",");


    public ItemLoader(){
        Item.setColNames(colNames);

        DBhandler db = new DBhandler();
        String query = DBhandler.getSelectSQL("ITEMS", colNames);

        try {
            ResultSet rs = db.executeQuery(query);
            while(rs.next()){
                Item item;
                switch (rs.getString(7).trim().toUpperCase()){
                    case "BEVERAGE":
                        item = new Beverage(rs.getInt("ID"),
                                rs.getString("NAME"), rs.getDouble("PRICE"),
                                rs.getDouble("QTY"), rs.getString("UNIT"),
                                rs.getInt("DPH"), rs.getString("CATEGORY"),
                                rs.getString("DESCRIPTION"), rs.getString("KEYWORDS"));
                        break;
                    case "MEAL":
                        item = new Meal(rs.getInt("ID"),
                                rs.getString("NAME"), rs.getDouble("PRICE"),
                                rs.getDouble("QTY"), rs.getString("UNIT"),
                                rs.getInt("DPH"), rs.getString("CATEGORY"),
                                rs.getString("DESCRIPTION"), rs.getString("KEYWORDS"));
                        break;
                    case "SERVICE":
                    default:
                        item = new Service(rs.getInt("ID"),
                                rs.getString("NAME"), rs.getDouble("PRICE"),
                                rs.getDouble("QTY"), rs.getString("UNIT"),
                                rs.getInt("DPH"), rs.getString("CATEGORY"),
                                rs.getString("DESCRIPTION"), rs.getString("KEYWORDS"));
                        break;
                }
                this.put(rs.getString("ID"), item);
            }
        } catch (SQLException e) {
            //TODO log
            e.printStackTrace();
        }
    }
}

