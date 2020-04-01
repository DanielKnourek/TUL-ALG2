package cz.tul.knourekdaniel.ALG2;

import java.util.Arrays;

public class Digipig {
    private int[] coinVals = new int[]{1,2};
    private Integer[] coins = new Integer[this.coinVals.length];
    private String name;
    
    public Digipig(String name){
        this.name = validateName(name);
        Arrays.fill(this.coins,0);
    }
    public Digipig(String name, Integer... counts){
        this(name);
        this.coins = counts;
    }
    public Digipig(String name, int[] coinVals, Integer... counts){
        this(name, counts);
        this.coinVals = coinVals;
    }
    private String validateName(String name){
        if (name == ""){
            throw new IllegalArgumentException("Empty string");
        }
        return name;
    }
    
    public void setName(String name){
        this.name = validateName(name);
    }

    public double getBalance() {
        int sum = 0;
        for (int i = 0; i < this.coins.length; i++) {
            sum += this.coins[i] * this.coinVals[i];
        }
        return sum;
    }
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return "Digipig{" +
                "balance=" + getBalance() +
                ", name='" + name + '\'' +
                '}';
    }
    

    public void insertCoin(int value){
        int index = indexOfArray(this.coinVals, value);
        this.coins[index]++;
    }
    private int indexOfArray(int[] Array, int value){
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] == value){
                return i;
            }
        }
        return -1;
    }

    private void insertCoins(int value, int count){
        for (int i = 0; i < count; i++) {
            insertCoin(value);
        }
    }
    public void insertCoins(Integer... counts){
        for (int i = 0; i < counts.length; i++) {
            this.coins[i] += counts[i];
        }
    }
    

}
