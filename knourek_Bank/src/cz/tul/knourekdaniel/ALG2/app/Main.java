package cz.tul.knourekdaniel.ALG2.app;

import cz.tul.knourekdaniel.ALG2.Bank.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        Person pekar = new Person("Pekar");
        pekar.addAccount(1000);
        pekar.addAccount(500);
        clients.add(pekar);

        Person svecova = new Person("Svecova");
        svecova.addAccount(1200);
        clients.add(svecova);

        Company skoda = new Company("Skoda");
        skoda.addAccount(120);
        clients.add(skoda);

        for(Client client: clients){
            System.out.println(client.getClientInfo() + ": " + client.checkBalance());
        }
    }
}
