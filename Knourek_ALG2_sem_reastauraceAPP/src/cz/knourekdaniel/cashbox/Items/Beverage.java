package cz.knourekdaniel.cashbox.Items;

public class Beverage extends Item{
    public Beverage(int id, String name, double price, double qty, String unit,
                    int dph, String category, String desc, String keywords) {

        super(id, name, price, dph, qty, unit);
        setKeywords(keywords);
        setCategory(category);
        setDesc(desc);
    }
}
