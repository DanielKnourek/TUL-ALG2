package cz.knourekdaniel.cashbox.Items;

public class Service extends Item {

    public Service(int id, String name, double price, double qty, String unit,
                   int dph, String category, String desc, String keywords) {

        super(id, name, price, dph, qty, unit);
        setKeywords(keywords);
        setCategory(category);
        setDesc(desc);
    }

}
