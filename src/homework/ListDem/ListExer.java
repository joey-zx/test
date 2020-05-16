package homework.ListDem;

import java.util.ArrayList;
import java.util.List;

public class ListExer {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        Student s1 = new Student("Joey",22);
        Student s2 = new Student("David",22);
        Student s3 = new Student("Mark",22);
        Student s4 = new Student("Leon",22);
        Student s5 = new Student("Louis",22);


        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println(students);

    }
}
