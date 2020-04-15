package cz.tul.knourekdaniel.ALG2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Calendar calendar1 = Calendar.create(13,4,2020);
        System.out.println(calendar1.getCurrentDayOfWeek());
        System.out.println(calendar1.toString());
        System.out.println(calendar1.showCurrentMonth());

        Calendar calendar2 = Calendar.create(31,3,2020);
        System.out.println(calendar2.getCurrentDayOfWeek());
        System.out.println(calendar2.showCurrentMonth());
    }
}
