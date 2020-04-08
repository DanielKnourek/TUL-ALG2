package cz.tul.knourekdaniel.ALG2;

import cz.tul.knourekdaniel.ALG2.Bank.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Account test1 = Account.createAccount("testAcc",200);
        System.out.println(test1.deposit(123));
        System.out.println(test1.withdraw(500));
        System.out.println(test1.toString());
    }
}
