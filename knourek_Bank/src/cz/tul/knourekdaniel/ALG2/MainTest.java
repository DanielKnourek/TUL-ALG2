package cz.tul.knourekdaniel.ALG2;

import cz.tul.knourekdaniel.ALG2.Bank.*;

public class MainTest {

    public static void main(String[] args) {
	// write your code here

        Account test1 = Account.createAccount("testAcc",200);
        System.out.println(test1.deposit(123));
        System.out.println(test1.withdraw(500));
        System.out.println(test1.toString());

        Person markova = new Person("Marková");
        markova.addAccount(200);
        System.out.println(markova.checkBalance());
        System.out.println(markova.getClientInfo());
        Person ferkl = new Person("Ferkl");
        ferkl.addAccount(200);
        System.out.println(ferkl.checkBalance());
        System.out.println(ferkl.getClientInfo());
    }
}
