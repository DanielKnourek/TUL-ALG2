package cz.knourekdaniel.cashbox.Items;

import java.util.Comparator;

public class SortByPriceThenName implements Comparator<Item> {
    protected boolean isSortAsc;

    public SortByPriceThenName(boolean isSortAsc){
        this.isSortAsc = isSortAsc;
    }
    public SortByPriceThenName(){
        this(true);
    }

    @Override
    public int compare(Item o1, Item o2) {
        if ( (int)(o1.getPrice() - o2.getPrice()) != 0){
            return (isSortAsc) ? (int)(o1.getPrice() - o2.getPrice()) : -(int)(o1.getPrice() - o2.getPrice());
        }
        return (isSortAsc) ? o1.getName().compareTo(o2.getName()) : -o1.getName().compareTo(o2.getName());
    }
}
