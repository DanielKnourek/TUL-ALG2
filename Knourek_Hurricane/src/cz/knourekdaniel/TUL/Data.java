package cz.knourekdaniel.TUL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    public static ArrayList<Hurrican> load(String path){
        ArrayList<Hurrican> hurricans=new ArrayList<>();
        try {
            File file = new File(path);
            file.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] input;
            String line = "";
            while ((line = br.readLine()) != null) {
                input = line.split("\\s+");
                hurricans.add(Hurrican.getInstance(Integer.parseInt(input[0]),input[1],Double.parseDouble(input[2]),Double.parseDouble(input[3]),input[4]));
            }
            br.close();
        }catch (IOException e){
            System.out.println("Data load error!");
        }

        return hurricans;
    }
}