package homework.CompareTest;

import java.util.TreeSet;

public class CompareTest<T> {

    public T sum(T t) {
        return t;
    }


    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();


        treeSet.add(new Student("joey",18,new StudentComparator()));
        treeSet.add(new Student("joey",19,new StudentComparator()));
        treeSet.add(new Student("joey",20,new StudentComparator()));

        System.out.println(treeSet);


    }

}
