package cz.tul.knourekdaniel.ALG2.Bank;

public class Account {

    private String name = "N/A";
    private double balance = 0;

    private Account(String name, double startingBalance) {
        this.name = name;
        this.balance = startingBalance;
    }
    private Account(double startingBalance) {
        this.name = name;
        this.balance = startingBalance;
    }
    public static Account createAccount(String name, double startingBalance){
        return new Account(name, startingBalance);
    }
    public static Account createAccount(String name){
        return createAccount(name, 0);
    }
    public static Account createAccount(double balance){
        return new Account(balance);
    }
    public static Account createAccount(){
        return new Account(0);
    }
    public double getBalance(){
        return this.balance;
    }
    public double deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        }
        return this.getBalance();
    }
    public double withdraw(double amount){
        if (this.getBalance() >= amount){
            this.balance -= amount;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
