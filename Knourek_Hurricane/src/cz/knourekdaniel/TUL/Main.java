package cz.knourekdaniel.TUL;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Hurrican> hurricanes;
    private static Scanner sc;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        String path="";
        while(path=="") {
            System.out.println("Zadej cestu k souboru.");
            if (sc.hasNextLine()) {
                path = sc.nextLine().split(" ")[0];
            }
            hurricanes = Data.load(path);
        }
        int startYear=0;
        int endYear=0;
        while(startYear==0 && endYear==0) {
            System.out.println("Zadej počáteční rok");
            if (sc.hasNextInt()) {
                startYear=sc.nextInt();
                sc.nextLine();
            }
            System.out.println("Zadej konečný rok");
            if (sc.hasNextInt()) {
                endYear=sc.nextInt();
                sc.nextLine();
            }
            getHurricanesByYear(startYear,endYear,hurricanes);
        }
        String name="";
        while(name=="") {
            System.out.println("Zadej jmeno hurikanu.");
            if (sc.hasNextLine()) {
                name = sc.nextLine().split(" ")[0];
                getHurricanesByName(name,hurricanes);
            }
        }
        System.out.println("Pro pokračování stikněte enter");
        if (sc.hasNextLine())
        {
            sort(hurricanes,new CompareBySpeed());
            print(hurricanes);
        }
    }

    final static Double KNOT=1.852;
    private static double toKilometersPerHour(Double knotsPerHour){
        return knotsPerHour*KNOT;
    }
    private static void getHurricanesByYear(int yearStart, int yearEnd, ArrayList<Hurrican> hurricanes){
        for (Hurrican hur:hurricanes) {
            if (hur.getYear() >= yearStart && hur.getYear()<= yearEnd){
                System.out.println(hur.toString()+"\r\n");
            }
        }
    }
    private static void getHurricanesByName(String name, ArrayList<Hurrican> hurricanes){
        for (Hurrican hur:hurricanes) {
            if (hur.getName().equals(name)){
                double speed=toKilometersPerHour(hur.getSpeed());
                System.out.println(speed+" km/h");
                System.out.println("category "+getCategory(speed));
            }
        }
    }
    private static int getCategory(double speed){
        int flooredSpeed=(int)Math.floor(speed);
        if (flooredSpeed>=252)
        {return 5;}
        if (flooredSpeed>=209)
        {return 4;}
        if (flooredSpeed>=178)
        {return 3;}
        if (flooredSpeed>=154)
        {return 2;}
        if (flooredSpeed>=119)
        {return 1;}
        return 0;
    }
    private static void sort(ArrayList<Hurrican> arrayList, ComparatorTemplate o){
        for (int i = 0; i < arrayList.size() ; i++) {
            for (int j = 1; j < arrayList.size()-i; j++) {
                if (o.isBigger(arrayList.get(i),arrayList.get(j))){
                    Hurrican temp=arrayList.get(i);
                    arrayList.set(i,arrayList.get(j));
                    arrayList.set(j,temp);

                }
            }
        }
    }
    private static void print(ArrayList<Hurrican> arrayList){
        for (Hurrican hur:arrayList) {
            System.out.println(hur.toString());
        }
    }
}

