package cz.tul.knourekdaniel.ALG2.Bank;

import java.util.ArrayList;

public abstract class Client {
    protected String name = "N/A";
    protected ArrayList<Account> accounts = new ArrayList<Account>();

    public void addAccount(Account account){
        this.accounts.add(account);
    }
    public void addAccount(double amount){
        this.accounts.add(Account.createAccount(amount));
    }
    public double checkBalance(){
        double sum = 0;
        for (Account account : this.accounts) {
            sum += account.getBalance();
        }
        return sum;
    }
    public abstract String getClientInfo();
}
