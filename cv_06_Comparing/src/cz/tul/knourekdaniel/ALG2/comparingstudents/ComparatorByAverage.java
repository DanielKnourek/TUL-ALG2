package cz.tul.knourekdaniel.ALG2.comparingstudents;

import java.util.Comparator;

public class ComparatorByAverage implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return ((s1.getAverage() > s2.getAverage()) ? 1 : 0);
    }
}
