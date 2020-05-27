package cz.knourekdaniel.TUL;

public class Hurrican {
    private int year;
    private String month;
    private double pressure;
    private double speed;
    private String name;

    public Hurrican(int year, String month, double pressure, double speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    public static Hurrican getInstance(int year, String month, double pressure, double speed, String name){
        Hurrican hurrican=new Hurrican(year,month,pressure,speed,name);
        return hurrican;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public double getPressure() {
        return pressure;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "year=" + year +
                        ", month='" + month + '\'' +
                        ", pressure=" + pressure +
                        ", speed=" + speed +
                        ", name='" + name + '\'';

    }
}