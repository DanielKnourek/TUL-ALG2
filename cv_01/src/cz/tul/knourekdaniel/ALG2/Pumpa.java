package cz.tul.knourekdaniel.ALG2;

import java.util.ArrayList;
import java.util.List;

public class Pumpa {
    private String Name;

    private double capacity = 2500;
    private double inStorage = this.capacity;
    private double pricePerLiter = 30;
    public Pumpa(String name, double pricePerLiter, double capacity, double inStorage){
        this.Name = name;
        this.pricePerLiter = pricePerLiter;
        this.capacity = capacity;
        this.inStorage = inStorage;
    }

    public Pumpa(){
        this.Name = "none";
    }

    @Override
    public String toString() {
        return "Pumpa{" +
                "Name='" + Name + '\'' +
                ", capacity=" + capacity +
                ", inStorage=" + inStorage +
                ", pricePerLiter=" + pricePerLiter +
                '}';
    }

    public double buy(double budget){
        if (this.inStorage < (budget/this.pricePerLiter)){
            return -1;
        }
        this.inStorage = this.inStorage - (budget / this.pricePerLiter);
        return (budget / this.pricePerLiter);
    }
    public void buyPrint(double budget){
        double bought = buy(budget);
        if (bought < 0){
            System.out.println("Nebylo možné natankovat, není dostatečné množství.");
        }
        System.out.printf("Natankovalo se %.2f Litrů %s za %.2f %n",bought, this.Name, budget);
    }

    public double refuel(double litres){
        if (this.inStorage < litres){
            return -1;
        }
        this.inStorage = this.inStorage - litres;
        return (litres * this.pricePerLiter);
    }

    public void refuelPrint(double litres){
        double bought = refuel(litres);
        if (bought < 0){
            System.out.println("Nebylo možné natankovat, není dostatečné množství.");
        }        
        System.out.printf("Natankovalo se %.2f Litrů %s za %.2f %n",litres ,this.Name, bought);
    }
    public void restock(){
        this.inStorage = this.capacity;
    }
    
    
}
