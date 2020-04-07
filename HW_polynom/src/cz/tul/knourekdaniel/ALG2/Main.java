package cz.tul.knourekdaniel.ALG2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Polynom p1 = Polynom.getInstanceDescending(0,0,-191,3);
        Polynom p2 = Polynom.getInstanceAscending(0,0,-191,3);

        System.out.println(p1.toString());
        System.out.println(p1.derivate().toString());
        System.out.println(p2.toString());
    }
}
