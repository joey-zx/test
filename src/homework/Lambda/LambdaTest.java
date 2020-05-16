package homework.Lambda;

public class LambdaTest {

    public static void main(String[] args) {
        System.out.println(new Add(){
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        }.add(3,5));
    }
}
