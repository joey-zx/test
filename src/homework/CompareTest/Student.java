package homework.CompareTest;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    private Comparator<Student> studentComparator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age,Comparator<Student> comparator) {
        this.name = name;
        this.age = age;
        this.studentComparator = comparator;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return studentComparator.compare(this,o);
    }
}
