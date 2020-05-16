package homework.Day10;

import java.util.Objects;

public class Person implements Play{
    private String name;
    private int age;
    static int eyes = 2;

    static{
        System.out.println("Class init!!");
    }

    public Person() {
        System.out.println("Constructor");
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void finalize() {

    }

   /* @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if(o == null) {
            return false;
        }

        if(this.getClass() != o.getClass() ) {
            return false;
        }

        Person p = (Person) o;

        if(this.age != p.age) {
            return false;
        }


        if(this.name == null) {
            if(p.name != null) {
                return false;
            }
        }else if(!this.name.equals(p.name)) {
            return false;
        }

        return true;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public void play() {

    }
}
