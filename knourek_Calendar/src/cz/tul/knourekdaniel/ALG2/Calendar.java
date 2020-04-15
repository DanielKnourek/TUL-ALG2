package cz.tul.knourekdaniel.ALG2;

import com.sun.net.httpserver.Authenticator;

import java.util.Arrays;

public class Calendar {
    public static final String[] months = new String[]{"Leden","Únor","Březen","Duben","Květen","Červen","Červenec","Srpen","Zaří","Říjen","Listopad","Prosinec"};
    public static final String[] days = new String[]{"Pondělí","Úterý","Středa","Čtvrtek","Pátek","Sobota","Neděle"};
    public static final String[] daysShort = new String[]{"Po","Út","St","Čt","Pá","So","Ne"};
    private int day = 1;
    private int month = 1;
    private int year = 2000;

    private Calendar(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Calendar create(int day, int month, int year){
        if (validateDate(day, month, year)){
            return new Calendar(day, month, year);
        }else{
            throw new IllegalArgumentException("Invalid combination of D/M/Y !");
        }

    }
    private static boolean validateDate(int day, int month, int year){
        boolean validDate = true;
        if (month < 1 || month > 12){
            validDate = false;
//            throw new IllegalArgumentException("Invalid month!");
        }


        if (day > lengthOfMonth(month,year)){
            validDate = false;
//            throw new IllegalArgumentException("Invalid day!");
        }
        return validDate;
    }
    private static Boolean isLeap(int year){
        boolean isLeap = false;
        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    isLeap = true;
                else
                    isLeap = false;
            }
            else
                isLeap = true;
        }
        else {
            isLeap = false;
        }
        return isLeap;
    }
    private static int lengthOfMonth(int month, int year){
        int length = 31;
        if (month == 2){
            length = (isLeap(year)) ? 29 : 28;
        }
        if (month != 2 && month % 2 == 0) {
            length = 30;
        }

        return length;
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

    public String showCurrentMonth(){
        StringBuilder tableView = new StringBuilder();
        tableView.append(String.format("%22s",months[month-1])).append("\r\n");
        tableView.append("|");
        for (String d : daysShort) {
            tableView.append(d).append("|");
        }
        tableView.append("\r\n");

        String[] cells = new String[42];
        Arrays.fill(cells, "  ");
        int r = DayOfWeek(1, this.month, this.year);
        for (int i = r; i < lengthOfMonth(this.month, this.year) + r; i++) {
            cells[i] = String.format("%2d",(i - r + 1));
        }
        for (int i = 0; i < cells.length; i++) {
            if (i % 7 == 0){
                tableView.append("|");
            }
            tableView.append(cells[i]);
            if (DayOfWeek(this.day, this.month, this.year) == i % 7 && i / 7 == (this.day / 7)+1){
                tableView.append("◄");
//                tableView.append("┤");
            }else{
                tableView.append("|");
            }
            if (i % 7 == 6){
                tableView.append("\r\n");
            }
        }

        return tableView.toString();
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
