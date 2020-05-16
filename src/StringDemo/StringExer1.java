package StringDemo;

import homework.Interfaces.AA;
import sun.awt.windows.ThemeReader;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringExer1 {

    public static void stringNum(String str) {
        char[] chars = str.toCharArray();

        int number = 0;

        for (char aChar : chars) {
            if (aChar >= 48 && aChar <= 57) {
                number += (aChar - 48);
            }
        }

        System.out.println(number);

    }


    public static void findTemplateInStr(String string, String tem, int num) {
        if (string.indexOf(tem, num) == -1) {
            return;
        }
        int index = string.indexOf(tem, num);
        System.out.println(index);
        findTemplateInStr(string, tem, index + 1);
    }


    public static void stringCut(String str, int begin, int last) {
        if (begin < 0 || last > str.length() - 1) {
            return;
        }

        if (begin > last) {
            return;
        }

        char[] chars = str.toCharArray();

        String string = new String(chars, begin, last - begin);

        System.out.println(string);

    }


    public static String StringCuts(String str, int num) throws Exception {

        byte[] bytes = str.getBytes("gbk");

        if (num < 0 || num > str.length()) {
            return null;
        }

        String str1 = new String(bytes, 0, num, "gbk");

       /* if(str.compareTo(str1) != str.length() - str1.length()) {
            str1 = str1.substring(0,str1.length() -1);
        }*/

        int index = str1.length() - 1;

        if (str.charAt(index) != str1.charAt(index)) {
            str1 = str1.substring(0, str1.length() - 1);
        }

        return str1;
    }


    public static boolean matchStr(String str) {

        if (str.length() < 8 || str.length() > 12) {
            return false;
        }


        if (str.matches("[^a-zA-Z0-9 ]")) {
            return false;
        }

        int num = 0;

        if (str.matches(".*[a-z].*")) {
            num++;
        }

        if (str.matches(".*[A-Z].*")) {
            num++;
        }

        if (str.matches(".*[0-9].*")) {
            num++;
        }

        if (str.matches(".* .*")) {
            num++;
        }

        return num == 2;

    }

    public static void sumNumStr(String str) {

        int latter, number, other;

        number = str.replaceAll("\\D", "").length();
        latter = str.replaceAll("[^a-zA-Z]", "").length();
        other = str.replaceAll("[a-zA-Z0-9]", "").length();

        System.out.println(latter);
        System.out.println(number);
        System.out.println(other);
    }

    public static void sumNumStrTime(String str) {

        char temp;

        while (str.length() > 0) {
            temp = str.charAt(0);
            //String singleStr = new String(new char[]{temp});
            //String reg = "[" + singleStr + "]";
            int length = str.length();
            str = str.replaceAll(temp + "", "");
            System.out.println(temp + " showtime " + (length - str.length()));
        }
    }

    public static int getAvargeLength(String str) {

        int number = 1;

        char c = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (c != str.charAt(i)) {
                c = str.charAt(i);
                number++;
            }
        }

        return str.length() / number;
    }

    //去重
    public static double getAvargeLength1(String str) {

        int number = str.replaceAll("(.)\\1+", "$1").length();
        return str.length() / number;
    }

    public static void main(String[] args) throws Exception {

       /* Integer integer = new Integer("15");

        System.out.println(integer);*/


//       System.out.println(getAvargeLength1("aabbcccdddef"));

        //stringNum("fs23423ss1");

        // stringCut("42131aa1][]sfs21",4,4);

        //findTemplateInStr("absfsabsfsgsfsgssaasabsfsgsfabdfgsjbfsjjjgjsfa","a",0);

       /* String s = "abcdefg";

        byte[] bs = s.getBytes("gbk");

        System.out.println(bs.length);

        String s1 = new String(bs,"UTF-8");

        System.out.println(s1);*/

        //System.out.println(StringCuts("大数据BigData",7));

        /*String string = "10.1242232123";

        System.out.println(string.matches("0\\.\\d+") || string.matches("[1-9]\\d*\\.\\d+"));
*/

      /*  String password = "avswsfsw11A";
        System.out.println(matchStr(password));
        */

//        sumNumStr("141sfs131[][31]..41");
       /* sumNumStrTime("akkaffqsgs1341ss");;*/

      /*  String string = "Cat Dog";

        System.out.println(string.replaceAll("^(Cat)(.*)(Dog)$","$3$2$1"));*/

      /*  System.out.println("aaaa".matches("^a+"));*/


       /* String s = "aabbccabdxc";

        System.out.println(s.replaceAll("(.)\\1+","$1"));




        String sss = "12.04123";

        System.out.println(sss.matches("0\\.\\d+") || sss.matches("[1-9]\\d*\\.\\d+"));*/

       /* Integer in1 = 300;
        Integer in2 = 300;

        System.out.println(in1 == in2);*/

       /* String string =  "51312931@qq.com";

        System.out.println(string.matches("\\w+@\\w+(\\.\\w+)$"));*/
     /*   String s = "15884487511";

        System.out.println(s.matches("1[0-9]{10}"));*/

       /* String reg = "aa";
        System.out.println(reg.matches("^a+"));*/

       /* System.out.println((int)(Math.random()*100));*/

/*
        Random random = new Random(12200);

        System.out.println(random.nextInt(100));
*/

        /*int i = 5;
        Integer integer = new Integer(5);

        System.out.println(i == integer);*/


        /*System.out.println((int)(Math.random() * (14)) + 5);

        BigDecimal b1 = new BigDecimal("14123141241231412351231231");
        BigDecimal b2 = new BigDecimal("141577867532426234234234252423423652342");

        System.out.println(b1.multiply(b2));*/

        /*String[] strings = new String[1];

        System.out.println(strings.getClass());*/

        Person person = new Teacher();

        System.out.println(person.getClass());

        System.out.println(Person.class);


    }

}

class Person {

}


class Teacher extends Person{

}