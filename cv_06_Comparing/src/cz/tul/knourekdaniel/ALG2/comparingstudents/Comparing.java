package cz.tul.knourekdaniel.ALG2.comparingstudents;

import cz.tul.knourekdaniel.ALG2.comparingstudents.mycomparing.MyComparing;
import java.text.Collator;
import java.util.*;

/**
 * Vyuziti metody sort z tridy Arrays nebo Collections a interface Comparable
 * @author janvit
 */
public class Comparing {
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        students[2].addGrade((double) 5);
        students[2].addGrade((double) 5);
        students[2].addGrade((double) 5);
        students[1].addGrade((double) 2);
        students[0].addGrade((double) 3);
        //test shodnosti objektu - chceme: nemusi byt stejny objekt, staci, kdyz ma stejna data
        System.out.println(students[0].equals(students[1]));
        
        //pouziti Comparable interface
        MyComparing.print(students);
        System.out.println("Sort by number");
        Arrays.sort(students); //students musi byt typove kompatibilni s interface Comparable
        MyComparing.print(students);
        
        List<Student> students1 = Datasource.loadDataAsList();
        MyComparing.print(students1);
        System.out.println("Sort by number");
        Collections.sort(students1); //students musi byt typove kompatibilni s interface Comparable
        MyComparing.print(students);
        
        //pouziti Comparator interface
        System.out.println("Sort by firstname");
        Arrays.sort(students, new ComparatorByFirstName());
        MyComparing.print(students);
        
        System.out.println("Sort by lastname");
        Arrays.sort(students, new Comparator<Student>() { //anonymni trida implementujici Comparator interface
            @Override
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs","CZ")); //tovarni metoda
                return col.compare(o1.getLastName(), o2.getLastName());
                //return o1.getLastName().compareTo(o2.getLastName()); //trideni Stringu podle ASCII 
            }
        });
        MyComparing.print(students);
        
        //Arrays.sort(students, (Student o1, Student o2) -> o1.getLastName().compareTo(o2.getLastName()) //lambda vyraz
        //); 

        for (Student student : students) {
            System.out.println(student.getAverage());
        }

        System.out.println("Sort by average");
        Arrays.sort(students, new ComparatorByAverage());

        MyComparing.print(students);

        for (Student student : students) {
            System.out.println(student.getAverage());
        }
    }
}
