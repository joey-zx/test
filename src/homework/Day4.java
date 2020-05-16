package homework;

public class Day4 {

    public static void printEven(int from, int to) {
        for (int i = from; i < to; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void printPrime(int from, int to) {
        boolean flag;

        for (int i = from; i < to; i++) {
            flag = true;
            for (int j = 2; j <= i - 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    public static void printNarcissusNum(int from, int to) {

        if (from < 100 || to > 999) {
            throw new NumerException("The number should be from 100 to 999");
        }

        for (int i = from; i < to; i++) {
            int baiwei = i / 100;
            int shiwei = (i - baiwei * 100) / 10;
            int gewei = i - (baiwei * 100) - (shiwei * 10);
            if ((baiwei * baiwei * baiwei + shiwei * shiwei * shiwei + gewei * gewei * gewei) == i) {
                System.out.println(i);
            }
        }
    }

    public static void printFib(int from, int to) {

        int firstNum = 1;
        int SeconNum = 1;
        int thirdNum;

        System.out.print(firstNum + "\t" + SeconNum + "\t");

        for (int i = 3; i < to; i++) {
            thirdNum = firstNum + SeconNum;
            firstNum = SeconNum;
            SeconNum = thirdNum;
            System.out.print(thirdNum + "\t");
        }
    }

    public static void printFib1() {

        int firstNum = 1;
        int SeconNum = 1;
        int thirdNum;

        System.out.print(firstNum + "\t" + SeconNum + "\t");
        int num = 0;
         while(num < 10) {
            thirdNum = firstNum + SeconNum;
            firstNum = SeconNum;
            SeconNum = thirdNum;
            System.out.print(thirdNum + "\t");
            num ++;
        }
    }

    public static void printTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j  + "*" + i + " = " + i*j);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        //printEven(0,100);
        printPrime(2,100);
        //printNarcissusNum(100,999);
        //printFib(1, 10);
        //printTable();
        //printFib1();
    }
}
