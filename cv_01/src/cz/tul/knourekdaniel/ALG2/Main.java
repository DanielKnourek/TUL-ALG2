package cz.tul.knourekdaniel.ALG2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var Diesel = new Pumpa("diesel", 28.9, 200 , 200);
        Diesel.buyPrint(2500);
        Diesel.refuelPrint(46.5);
        System.out.println(Diesel.toString());
        Diesel.buyPrint(2500);
        System.out.println(Diesel.toString());
        Diesel.refuelPrint(46.5);
        System.out.println(Diesel.toString());
        Diesel.restock();
        System.out.println(Diesel.toString());
        Diesel.buyPrint(2500);
        System.out.println(Diesel.toString());
        Diesel.refuelPrint(46.5);
        System.out.println(Diesel.toString());
    }
}
