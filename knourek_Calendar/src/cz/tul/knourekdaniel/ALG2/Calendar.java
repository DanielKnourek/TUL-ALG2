package cz.tul.knourekdaniel.ALG2;

public class Calendar {
    public static final String[] days = new String[]{"Pondělí","Úterý","Středa","Čtvrtek","Pátek","Sobota","Neděle"};
    private int day = 1;
    private int month = 1;
    private int year = 2000;

    private Calendar(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Calendar create(int day, int month, int year){
        if (day < 1 || day > 31){
            throw new IllegalArgumentException("Invalid day!");
        }
        if (month < 1 || month > 12){
            throw new IllegalArgumentException("Invalid month!");
        }


        return new Calendar(day, month, year);
    }

    public String getCurrentDayOfWeek(){
        return days[DayOfWeek(this.day, this.month, this.year)];
    }

    private int DayOfWeek(int day, int month, int year) {
        int monthval = month;
        int yearval = year;

        if (monthval == 1) {
            monthval = 13;
            yearval--;
        }
        if (monthval == 2) {
            monthval = 14;
            yearval--;
        }
        int q = day;
        int m = monthval;
        int k = yearval % 100;
        int j = yearval / 100;
        int h = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        return ((h + 5) % 7);
    }
}
