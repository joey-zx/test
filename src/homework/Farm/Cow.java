package homework.Farm;

public class Cow {

    private int age;

    public Cow(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cow bronCow() {
        if(this.age >= 5) {
            return new Cow(0);
        }
        this.setAge(this.getAge() + 1);
        return null;
    }
}
