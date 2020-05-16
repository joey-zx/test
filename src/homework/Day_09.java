package homework;

public class Day_09 {

    //题1
    public static void hundredMoneyBuyHundredChicken() {
        int gj, mj, xj;
        int money = 100;

        for (gj = 0; gj < 33; gj++) {
            for (mj = 0; mj < 50; mj++) {
                xj = 100 - gj - mj;
                if ((gj * 3 + mj * 2 + xj / 3 == money) && xj % 3 == 0) {
                    System.out.println("可买公鸡:" + gj);
                    System.out.println("可买母鸡:" + mj);
                    System.out.println("可买小鸡:" + xj);
                    break;
                }
            }
        }
    }

    //题2
    public static void printStars(int line) {

        int maxLineOfStars = line * 2 - 1;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < maxLineOfStars; j++) {
                if (j >= maxLineOfStars / 2 - i && j <= maxLineOfStars / 2 + i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    //题三
    public static void findRelatedNums(int maxNum) {

        for (int a = 1; a < maxNum; a++) {
            int b = findyinziSum(a);
            if (findyinziSum(b) == a && a < maxNum && b < maxNum && a != b) {
                System.out.println(a + " 和 " + b + " 互为亲密数！");
            }
        }
    }

    //计算当前数字的因字数的和
    public static int findyinziSum(int num) {
        int yinziSum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                yinziSum += i;
            }
        }
        return yinziSum;
    }

    //题四
    public static void findDistanceFortwoPoints(int[] point1, int[] point2) {

        if (point1.length != 2 || point2.length != 2) {
            System.out.println("Please input two points again");
            return;
        }
        int y = Math.abs((point2[1] - point1[1]) * (point2[1] - point1[1]));
        int x = Math.abs((point2[0] - point1[0]) * (point2[0] - point1[0]));

        double distance = Math.sqrt(y + x);

        System.out.println("两点之间x和y的距离为：" + distance);
    }

    //题5
    public static void luoxuan(int row, int col) {
        int[][] arr = new int[row][col];
        int count;
        int index = 1;

        if (row % 2 == 0) {
            count = row/2;
        } else {
            count = row /2 + 1;
        }

        for (int i = 0; i < count; i++) {
            //从左到右
            for (int j = i; j < col-i; j++) {
                arr[i][j] = index ++;
            }
            //从上到下
            for(int k=i+1;k<row-i;k++) {
                arr[k][col-i -1] = index ++;
            }
            //从右到左
            for(int l = col-i-2; l >=i; l--) {
                arr[row-1-i][l] = index ++;
            }
            //从下到上
            for(int n = row-i-2; n>i; n--) {
                arr[n][i] = index++;
            }
        }

        for(int i = 0; i < row; i++) //遍历输出
        {
            for(int j = 0; j < col; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //hundredMoneyBuyHundredChicken();
        //printStars(5);
        //findDistanceFortwoPoints(new int[] {3,4},new int[]{2,7});
        //findRelatedNums(3000);
        luoxuan(4, 5);
    }
}
