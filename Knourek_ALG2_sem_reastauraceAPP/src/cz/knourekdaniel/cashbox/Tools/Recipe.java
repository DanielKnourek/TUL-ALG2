package cz.knourekdaniel.cashbox.Tools;

import cz.knourekdaniel.cashbox.Items.Item;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Recipe {
    private static final String name = "Restaurace Kázetko";
    private HashMap<Integer, Item> OrderedItemsMap = new HashMap<>();
    private double TotalPrice = 0;


    public Recipe(HashMap<Integer, Item> OrderedItemsMap) {
        this.OrderedItemsMap = OrderedItemsMap;

    }

    public Recipe(Item... items) {
        for (Item item : items) {
            this.OrderedItemsMap.put(item.getId(), item);
        }
    }

    @Override
    public String toString() {
        int width = 50;
//        AtomicReference<Double> TotalPrice = new AtomicReference<>((double) 0);

        StringBuilder recipe = new StringBuilder();

        final String br = "\r\n";
        final String line = String.format("%0" + (width - 2) + "d", 0).replace("0", "─");
        recipe.append("┌").append(line).append("┐").append(br);

        recipe.append("│").append(String.format("%30s", name)).append(String.format("%19s","│")).append(br);
        recipe.append("└").append(line).append("┘").append(br).append(br);

        recipe.append("      ").append(getDateTime("dd-MM-yyyy HH:mm:ss"));
        recipe.append(br);
        recipe.append(" ").append(line).append(" ").append(br);

        this.OrderedItemsMap.forEach((key, item) -> {
                    recipe.append(String.format("   %6.2f %2s  %30s    ",
                            item.getQty(), item.getUnit(), item.getName()));
                    recipe.append(br);

                    recipe.append(
                            String.format("  %3d%%    %5.2f x %8.2f  =  %8.2f",
                                    item.getDPH(), item.getCount(), item.getPrice(), item.getPrice() * item.getCount())
                    );
                    recipe.append(br);
                    recipe.append(br);

                    addToTotal(item.getPrice() * item.getCount());
                }
        );
        recipe.append(" ").append(line).append(" ").append(br);

        this.TotalPrice = Math.ceil(this.TotalPrice);
        recipe.append("          ").append("Celkem k zaplacení").append(String.format("%8.2fKč",this.TotalPrice)).append(br);
        recipe.append(" ").append(line).append(" ").append(br);

        return recipe.toString();
    }

    private String getDateTime(String pattern){
        LocalDateTime now = LocalDateTime.now();
        return LocalDateTime.now().format((DateTimeFormatter.ofPattern(pattern)));

    }

    private double addToTotal(double amount) {
        return this.TotalPrice += amount;
    }

    public void save() throws IOException {
        JFileChooser savefile = new JFileChooser();
        savefile.setSelectedFile(new File("Reciep_"+ getDateTime("dd_MM_yyyy_HH_mm_ss") +".txt"));
        BufferedWriter writer;
        int response = savefile.showSaveDialog(savefile);
        if (response == JFileChooser.APPROVE_OPTION){
            writer = new BufferedWriter(new FileWriter(savefile.getSelectedFile()));
            writer.write( this.toString());
            writer.close();
            JOptionPane.showMessageDialog(null, "Ukládání dokončeno!");

        }else if (response == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Ukládání zrušeno!");
        }
    }
}