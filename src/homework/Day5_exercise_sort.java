package homework;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

public class Day5_exercise_sort {

    public static void selectSort(int arr[]) {

        int tmp, x;

        for (int i = 0; i < arr.length; i++) {
            tmp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[tmp] > arr[j]) {
                    tmp = j;
                }
            }

            x = arr[tmp];
            arr[tmp] = arr[i];
            arr[i] = x;

        }

        System.out.println(Arrays.toString(arr));

    }

    public static void bubleSort(int arr[]) {

        int x;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    x = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = x;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int low, int high) {
        int first, last, tmp, x;

        if (low >= high) {
            return;
        }

        first = low;
        last = high;

        tmp = arr[first];

        while (first < last) {
            while (tmp < arr[last] && first < last) {
                last--;
            }

            while (tmp >= arr[first] && first < last) {
                first++;
            }

            if (first < last) {
                x = arr[first];
                arr[first] = arr[last];
                arr[last] = x;
            }
        }

        arr[low] = arr[first];
        arr[first] = tmp;

        quickSort(arr, low, first - 1);

        quickSort(arr, first + 1, high);

    }


    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        int temp;

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                temp = arr[i];

                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap /= 2;
        }
    }


    public static void insertSort(int[] arr) {
        int x;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    x = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = x;
                } else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int arr[] = {222,423,-123,42,91,-90,4,-78};
        //selectSort(arr);
        //bubleSort(arr);
        //quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        //insertSort(arr);

        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
