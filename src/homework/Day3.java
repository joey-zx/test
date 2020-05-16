package homework;

import java.nio.charset.Charset;
import java.util.Scanner;

public class Day3 {

    private static Scanner scanner = new Scanner(System.in);

    public static int operator() {
        System.out.println("请输入第一个数");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数");
        int num2 = scanner.nextInt();
        System.out.println("请输入运算方法");
        String operator = scanner.next();

        int score;

        switch (operator) {
            case "+":
                score = num1 + num2;
                break;
            case "-":
                score = num1 - num2;
                break;
            case "*":
                score = num1 * num2;
                break;
            case "/":
                score = num1 / num2;
                break;
            default:
                score = -1;
        }
        return score;

    }


    public static void main(String[] args) {
        Object obj = new Object() {
            public int hashCode() {
                return 42;
            }
        };
        System.out.println(obj.hashCode());
    }
}
