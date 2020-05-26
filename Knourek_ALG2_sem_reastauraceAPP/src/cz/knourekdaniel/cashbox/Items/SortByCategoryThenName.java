package cz.knourekdaniel.cashbox.Items;

import java.util.Comparator;

public class SortByCategoryThenName implements Comparator<Item> {
    protected boolean isSortAsc;

    public SortByCategoryThenName(boolean isSortAsc){
        this.isSortAsc = isSortAsc;
    }
    public SortByCategoryThenName(){
        this(true);
    }

    @Override
    public int compare(Item o1, Item o2) {
        int CompareByCategory = o1.getCategory().compareTo(o2.getCategory());
        if (CompareByCategory != 0){
            return (isSortAsc) ? CompareByCategory : -CompareByCategory;
        }
        return (isSortAsc) ? o1.getName().compareTo(o2.getName()) : -o1.getName().compareTo(o2.getName());
    }
}
