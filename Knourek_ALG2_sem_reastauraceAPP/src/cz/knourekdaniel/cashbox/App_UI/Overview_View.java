package cz.knourekdaniel.cashbox.App_UI;

import cz.knourekdaniel.cashbox.App.Order;
import cz.knourekdaniel.cashbox.Items.Item;
import cz.knourekdaniel.cashbox.App.Recipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class Overview_View extends ViewMaster{
    private JPanel ContentPanel;
    private JButton btn_back;
    private JList OrderedItems;

    private JPanel MainPanel;
    private JTextArea RecipeExample;
    private JButton btn_save;
    private JButton btn_new;
    private JButton btn_saveANDnew;

    HashMap<Integer, Item> OrderedItemsMap = new HashMap<>();
    Recipe recipe;

    public Overview_View() {
        addListeners();

    }

    private void addListeners() {
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order.setVisible();
            }
        });
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveOrder();
            }
        });
        btn_saveANDnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveOrder();
                newOrder();
            }
        });
        btn_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newOrder();
            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return this.MainPanel;
    }

    public void Update(){
        recreateList();
        this.recipe = new Recipe(this.OrderedItemsMap);
        RecipeExample.setText(this.recipe.toString());
    }

    public void UpdateOrderedItemsMap(HashMap<Integer, Item> OrderedItemsMap){
        this.OrderedItemsMap = OrderedItemsMap;
    }


    private void recreateList() {
        DefaultListModel List = new DefaultListModel();
        OrderedItemsMap.forEach((key, item) -> List.addElement(item.toString()));
        OrderedItems.setModel(List);

    }

    private void newOrder(){
        Order.start();
    }
    private void saveOrder(){
        try {
            recipe.save();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ukládání selhalo!");
        }
    }
}
