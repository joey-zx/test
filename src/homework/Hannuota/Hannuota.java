package homework.Hannuota;

public class Hannuota {
    public static void hanoi(int n, String a, String b,String c) {
        if (n == 1) {
            // 只有一个圆盘时直接从A石柱移动到C石柱
            move(n, a, c);
        } else {
            // 将前n-1个圆盘从石柱A移动到石柱B
            hanoi(n - 1, a, c, b);
            // 将第n号圆盘从石柱A移动到石柱C
            move(n, a, c);
            // 将前n-1个圆盘从石柱B移动到石柱C
            hanoi(n - 1, b, a, c);
            
        }
    }

    public static void move(int n, String i, String j) {
        System.out.println("第" + n + "个圆盘，" + "从" + i + "移动到" + j);
    }

    public static void main(String[] args) {
        hanoi(4,"A","B","C");
    }
}