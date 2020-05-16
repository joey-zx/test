package homework;

import javax.swing.*;
import java.time.temporal.Temporal;
import java.util.Arrays;

public class Day5 {

    public static void selectSort(int arr[]) {

        int x,tmp;

        for(int i =0;i<arr.length -1; i++) {
            tmp = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[tmp] > arr[j]) {
                    tmp = j;
                }
            }
            x = arr[i];
            arr[i] = arr[tmp];
            arr[tmp] = x;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr={22,6,223,45,-19,32,29};
        selectSort(arr);
    }
}
