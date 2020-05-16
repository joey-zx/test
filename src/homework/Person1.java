package homework;

public class Person1 {
    private String name = "hhhhhhhh";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person1 {
    private String school;

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void getSuper() {
        System.out.println("super:" + super.getName());

    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                '}';
    }
}

class TestPerson {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");//1此句注释掉的话，3行和4行打印的都是:"hhhhhhhh"；否则都是"John"。
        student.setSchool("SCH");//2
        /*student.getSuper();//3
        System.out.println(student.getName());//4
        System.out.println(student.getSchool());//5*/

        Person person = new Person(){
            @Override
            public String toString() {
                return"aaa";
            }
        };

        System.out.println(person.toString());



    }
}