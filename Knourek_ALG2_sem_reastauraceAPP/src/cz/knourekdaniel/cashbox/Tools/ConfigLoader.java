package cz.knourekdaniel.cashbox.Tools;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads properties from app files and files in working directory.
 * App property values are overwritten with properties in working directory.
 */
public class ConfigLoader extends Properties {

    private String fileLocationLocal;
    private String fileLocationApp;

    /**
     * Property values of non overwritten default project values.
     */
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