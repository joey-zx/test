package homework.Farm;

public class Test {
    public static void main(String[] args) {
        Farm farm = new Farm();

        for (int i = 1; i <= 20; i++) {
            farm.bronCow();
        }

        System.out.println(farm.getCowsNum());
    }
}
