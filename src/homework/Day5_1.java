package homework;


import java.util.Arrays;

public class Day5_1 {

    public static void reverseArr(int[] arr) {

        int temp;

        for(int i=0; i<arr.length/2;i++) {
            temp = arr[i];
            arr[i] = arr[arr.length -1 -i];
            arr[arr.length -1 -i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void bubleSort(int[] arr) {
        int tmp;

        for(int i =0;i<arr.length -1;i++) {
            for(int j=arr.length-1; j > i; j--) {
                if(arr[j] < arr[j -1]) {
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int[] arr) {
        int x;

        for(int i =1; i< arr.length; i++) {
//            tmp = arr[i];
            for(int j=i; j>0;j--) {
                if(arr[j-1] > arr[j]) {
                    x = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = x;
                } else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int low, int high) {
        int first,last,tmp,x;

        if(low > high) {
            return;
        }

        first = low;

        last = high;

        tmp = arr[first];

        while(first < last) {

            while(tmp<=arr[last] && first < last) {
                last --;
            }

            while (tmp >=arr[first] && first < last) {
                first ++;
            }
            //交换
            if(first < last) {
                x = arr[first];
                arr[first] = arr[last];
                arr[last] = x;
            }
        }

        arr[low] = arr[first];
        arr[first] = tmp;

        //递归左边数列

        quickSort(arr,low,first -1);

        //递归右边数列

        quickSort(arr,first + 1,high);
    }

    public static void main(String[] args) {
        int[] arr = {66,3,-5,109,-99,17,129};
        //reverseArr(arr);
        bubleSort(arr);
        //quickSort(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
        //insertSort(arr);

    }
}
