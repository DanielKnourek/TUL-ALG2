package cz.knourekdaniel.cashbox.Tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Conf {
    public static final String appFolder = "#/cz/knourekdaniel/cashbox/";
    private static boolean initialized = false;
    public static ConfigLoader conf ;
//    = new ConfigLoader(Conf.appFolder + "Properties/","","Conf.xml");
    public static ConfigLoader images ;
//    = new ConfigLoader(Conf.appFolder + "Properties/","","Images.xml");

    public static void load(){
        if (initialized){
            //TODO throw error
            return;
        }
        initialized = true;
        conf = new ConfigLoader(Conf.appFolder + "Properties/","","Conf.xml");
        images = new ConfigLoader(Conf.appFolder + "Properties/","","Images.xml");
    }
}

class ConfigLoader extends Properties{
    private String fileLocationLocal;
    private String fileLocationApp;
    public final Properties propApp = new Properties();

    ConfigLoader(String fileLocationApp, String fileLocationLocal, String fileName){
        this.fileLocationLocal = fileLocationLocal + fileName;
        this.fileLocationApp = fileLocationApp + fileName;

        this.propApp.putAll(CreateProperties(this.fileLocationApp));
        this.putAll(this.propApp);
        this.putAll(CreateProperties(this.fileLocationLocal));

    }

    ConfigLoader(String fileName){
        this( Conf.appFolder,"", fileName);
    }

    private Properties CreateProperties(String fileLocation) {
        Properties prop = new Properties();

        try {
            InputStream FiS = R.newFiS(fileLocation);
            if (FiS != null){
                prop.loadFromXML(FiS);
                FiS.close();
            }
        } catch (IOException e) {
            //TODO logging catch
            e.printStackTrace();
        }
        return prop;
    }
}