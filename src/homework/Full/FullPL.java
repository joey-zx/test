package homework.Full;

import java.util.Scanner;

public class FullPL {

    public static void main(String[] args) {
        fullPL();
    }

    private static void fullPL() {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");

        String str = sc.next();

        char[] chars = str.toCharArray();
        fullQPL(chars,0,chars.length);

    }

    private static void fullQPL(char[] chars, int start, int end) {

        if(start == end) {
            System.out.println(new String(chars));
        } else {
            for (int i = start; i < end; i++) {
                swap(chars,start,i);
                fullQPL(chars, start + 1, end);
                swap(chars,i,start);
            }
        }
    }

    private static void swap(char[] chars, int start, int i) {
        char temp = chars[start];
        chars[start] = chars[i];
        chars[i] = temp;
    }
}
