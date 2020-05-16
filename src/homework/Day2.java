package homework;

import java.util.Scanner;

public class Day2 {

    private static Scanner scanner = new Scanner(System.in);

    // 1. 获取用户输入的整数，并判断奇偶性
    public static boolean judeOdd() {
        int input = scanner.nextInt();

        if(input % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 2. 获取用户输入的三个整数，输出最大值

    public static int selectMaxNum() {
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        int input3 = scanner.nextInt();

        return input1 > input2 ? (input1 > input3 ? input1:input3) : (input2 > input3 ? input2 : input3);
    }

    // 3. 获取用户输入的学生的成绩，根据成绩的范围，输出该学生成绩的等级
    public static String selectStudentGrade() {
        int score = scanner.nextInt();
        String grade;

        if(score < 0 || score > 100) {
            return "请输入0-100的分数";
        }

        if(score < 60) {
            grade = Grade.GRADE_FIVE.getMsg();
        } else if(score < 70) {
            grade = Grade.GRADE_FOUR.getMsg();
        } else if(score < 80) {
            grade = Grade.GRADE_THREE.getMsg();
        } else if(score < 90) {
            grade = Grade.GREAD_TWO.getMsg();
        } else {
            grade = Grade.GRADE_ONE.getMsg();
        }
        return grade;
    }

    // 4获取用户输入的月份，根据月份输出该月份对应的季节
    public static String getSeason () {
        int month = scanner.nextInt();
        if(month < 1 && month > 12) {
            return "请输入正确的月份";
        }
        if( month >= 3 && month <=5 ) {
            return "该月份是春季";
        } else if(month >= 6 && month <=8) {
            return "该月份是夏季";
        } else if(month >= 9 && month <=11) {
            return "该月份是秋季";
        } else {
            return "该月份是冬季";
        }
    }

    public static void main(String[] args) {


        System.out.println("您输入的数字是：" + (judeOdd() ? "偶数":"奇数"));
        System.out.println("最大的数字是：" + selectMaxNum());
        System.out.println("学生等级是：" + selectStudentGrade());
        System.out.println();
        scanner.close();
    }
}
