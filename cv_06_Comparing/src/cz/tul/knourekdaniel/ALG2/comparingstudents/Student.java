package cz.tul.knourekdaniel.ALG2.comparingstudents;

import cz.tul.knourekdaniel.ALG2.comparingstudents.mycomparing.CompareInterface;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author janvit
 */
public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int studentNumber;
    ArrayList<Double> grades = new ArrayList<>();

    public Student(String firstName, String lastName, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getAverage(){
        double average = 0;
        for (Double grade : grades) {
            average += grade;
        }
        return (grades.size() > 0) ? (average / grades.size()) : 0;
    }
    protected void addGrade(Double grade){
        if (grade >= 1 && grade <= 5){
            grades.add(grade);
        }
    }
    
    @Override
    public String toString() {
        return String.format("%10s%10s%10d",firstName, lastName, studentNumber);
    }

    public boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber;
    }

    //potrebne pro MyComparing
    @Override
    public boolean isBigger(CompareInterface o) {
        return this.studentNumber > ((Student)o).studentNumber;
    }

    /*@Override
    public int compareTo(Object o) {
        return this.studentNumber - ((Student)o).studentNumber;
    }*/

    //potrebne pro Comparing
    @Override
    public int compareTo(Student o) {
        return this.studentNumber - o.studentNumber;
    }
    
    //pri zmene equals zmenit i hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + this.studentNumber;
        return hash;
    }
    
    //default in Object 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
}
