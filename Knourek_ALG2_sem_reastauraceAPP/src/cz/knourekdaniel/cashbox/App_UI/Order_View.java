package cz.knourekdaniel.cashbox.App_UI;

import cz.knourekdaniel.cashbox.App.Order;
import cz.knourekdaniel.cashbox.App.Overview;
import cz.knourekdaniel.cashbox.Items.Item;
import cz.knourekdaniel.cashbox.Items.SortByCategoryThenName;
import cz.knourekdaniel.cashbox.Items.SortByPriceThenName;
import cz.knourekdaniel.cashbox.Tools.R;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class Order_View extends ViewMaster {
    private JPanel MainPanel;
    private JTextField SearchBar;
    private JButton btn_restart;
    private JScrollPane TableScrollPane;
    private JPanel ContentPanel;
    private JTable ItemTable;
    private JList OrderedItems;
    private JButton btn_Add;
    private JButton btn_Remove;
    private JButton btn_continue;

    private HashMap<Integer, Item> OrderedItemsMap = new HashMap<>();

    public HashMap<Integer, Item> getOrderedItemsMap() {
        return OrderedItemsMap;
    }

    public Order_View() {
        btn_Add.setIcon(new ImageIcon(R.img.get("icon-plus").getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        btn_Add.setText("");
        btn_Remove.setIcon(new ImageIcon(R.img.get("icon-minus").getScaledInstance(30, 30, Image.SCALE_FAST)));
        btn_Remove.setText("");

        addListeners();



    }

    private void addListeners() {
        SearchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filter(SearchBar.getText());
            }
        });
        btn_Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToList(1);
            }
        });

        btn_restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order.start();
            }
        });

        btn_Remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToList(-1);
            }
        });
        SearchBar.addKeyListener(new KeyAdapter() {


            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_PLUS:
                    case KeyEvent.VK_ENTER:
                        addToList(1);
                        break;
                    case KeyEvent.VK_MINUS:
                    case KeyEvent.VK_DELETE:
                        addToList(-1);
                        break;
                    case KeyEvent.VK_DOWN:
                        if (ItemTable.getSelectedRows()[0] < ItemTable.getRowCount()-1){
                            ItemTable.setRowSelectionInterval(
                                    ItemTable.getSelectedRow()+1,
                                    ItemTable.getSelectedRow()+1);
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (ItemTable.getSelectedRows()[0] > 0){
                            ItemTable.setRowSelectionInterval(
                                    ItemTable.getSelectedRow()-1,
                                    ItemTable.getSelectedRow()-1);
                        }
                        break;

                    default:

                        break;
                }
            }
        });

        btn_continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Overview.start();
            }
        });
        ItemTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    addToList(1);
                }
            }
        });

        OrderedItems.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    addToList(-1);
                }
                SearchBar.requestFocus();
            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        revalidate();
        return this.MainPanel;
    }

    private void revalidate() {
        this.ItemTable.getTableHeader().setVisible(true);
        setPreferredColumnWidth(50, 300, 100, 50, 50, 50, 150, 0, 0);
        this.ItemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ItemTable.setRowSelectionInterval(0,0);
        SearchBar.requestFocus();
    }

    public void addTableEntry(Object[]... data) {
        DefaultTableModel model = (DefaultTableModel) this.ItemTable.getModel();
        for (Object[] row : data) {
            model.addRow(row);
        }
        this.ItemTable.setModel(model);


    }

    public void CreateTable(Object[] colNames) {
        DefaultTableModel TableModel = new DefaultTableModel(colNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        this.ItemTable.setModel(TableModel);
        TableRowSorter tableRowSorter = new TableRowSorter(ItemTable.getModel());
        tableRowSorter.setComparator(6, new SortByCategoryThenName(false));
        tableRowSorter.setComparator(2, new SortByPriceThenName(true));
    }

    private void setPreferredColumnWidth(int... values) {
        for (int i = 0; i < values.length && i < ItemTable.getColumnModel().getColumnCount(); i++) {
            this.ItemTable.getColumnModel().getColumn(i).setPreferredWidth(values[i]);


        }
    }

    void addToList(double amount) {
        int rowIndex = ItemTable.getSelectedRow();
        if (rowIndex <0){ return;}
        int index = ItemTable.getRowSorter().convertRowIndexToModel(rowIndex);
        Item entry = R.item.get(Integer.parseInt(this.ItemTable.getModel().getValueAt(index, 0).toString())+"");
        if (OrderedItemsMap.putIfAbsent(entry.getId(), entry.clone()) != null) {
            OrderedItemsMap.get(entry.getId()).addCount(amount);
        } else if (amount < 0) {
            OrderedItemsMap.get(entry.getId()).addCount(-1 + amount);
        }

        DefaultListModel List = new DefaultListModel();
        OrderedItemsMap.forEach((key, item) -> List.addElement(item.toString()));
        OrderedItems.setModel(List);

    }

    void filter(String query){
        StringBuilder editedquery = new StringBuilder();
        //^(?=.*one)(?=.*two)(?=.*three).*$ regex example for "one two three"
        editedquery.append("^");
        String[] queryArr = query.split(" ");
        for (String s : queryArr) {
            editedquery.append("(?=.*").append(s).append(")");
        }
        editedquery.append(".*$");

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>((DefaultTableModel) ItemTable.getModel());
        ItemTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(editedquery.toString()));
    }

}
