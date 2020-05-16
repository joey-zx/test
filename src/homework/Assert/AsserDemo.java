package homework.Assert;

import java.util.Scanner;

public class AsserDemo {
    public static void main(String[] args) {

        System.out.println("请输入一个大于10的数");

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        n += 5;

        assert n > 15;

        n *= 3;

        System.out.println(n);

    }
}
