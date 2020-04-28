package cz.knourekdaniel.SwingFun.Tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private String fileLocation;
    private String fileName;
    private Properties prop = new Properties();

    ConfigLoader(String fileLocation, String fileName){
        this.fileLocation = fileLocation;
        this.fileName = fileName;

        InputStream is = null;
        
        //TODO try catch
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    ConfigLoader(String fileName){
        this("./", fileName);
    }
}
