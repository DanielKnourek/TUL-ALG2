package cz.knourekdaniel.cashbox.Items;

public abstract class Item extends Object implements Cloneable {

    private static String[] colNames;

    private final int id;
    private String Name;
    private double Price;
    private int DPH;
    private double qty;
    private String unit;
    private double count = 1;

    //extra
    private String[] keywords;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public double getCount(){
        return count;
    }

    public double getQty(){
        return qty;
    }

    public String getUnit(){
        return unit;
    }

    public int getDPH(){
        return DPH;
    }

    private String category;
    private String desc = "";

    public Item(int id, String name, double price, int dph, double qty, String unit){

        this.id = id;
        this.Name = name;
        this.Price = price;
        this.DPH = dph;
        this.qty = qty;
        this.unit = unit;
    }


    public void addCount(double amount){
        this.count += amount;
    }


    public void setKeywords(String keywords){
        if (keywords == null){
            this.keywords = this.Name.split(",");
        }else{
            this.keywords = keywords.split(",");
        }

    }

    public Object[] asArray(){
        return new Object[]{String.format("%06d",id), Name, Price, qty, unit, DPH, category};
    }

    public static void setColNames(String[] colNames){
        Item.colNames = colNames;
    }

    public static String[] getColNames(){
        return Item.colNames = colNames;
    }

    public Item clone() {
        try {
            return (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            //TODO log
            e.printStackTrace();
        }
        return this;
    }


    @Override
    public String toString() {
//        StringBuilder out = new StringBuilder();
//        out.append(this.Name);
//        return out.toString();
        //TODO remove prinln
//        System.out.println(String.format("|%30s  %5.2f x %5.2f   %3d|", Name, count, Price, DPH));
        return String.format("%9s %25s  %5.2fx %5.2f  %3d%%", (qty+unit), Name, count, Price, DPH);
    }


}
