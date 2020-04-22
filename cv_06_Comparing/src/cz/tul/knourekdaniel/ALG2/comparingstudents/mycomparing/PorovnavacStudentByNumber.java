package cz.tul.knourekdaniel.ALG2.comparingstudents.mycomparing;

import cz.tul.knourekdaniel.ALG2.comparingstudents.Student;

/**
 *
 * @author janvit
 */
public class PorovnavacStudentByNumber implements ComparatorInterface{

    @Override
    public boolean bigger(Object o1, Object o2) {
        return ((Student)o1).getStudentNumber() > ((Student)o2).getStudentNumber();
    }    
}
