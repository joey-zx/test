package homework;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Day6 {
    public static void func(int[][] arr) {
        for(int i=0; i<=arr.length -1; i++) {
            arr[i] = new int[i+1];
            for(int j=0;j<=i;j++) {
                if(j==0 || j ==i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][];
        func(arr);

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
