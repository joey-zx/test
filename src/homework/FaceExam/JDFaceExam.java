package homework.FaceExam;

import java.util.Arrays;

public class JDFaceExam {


    public static void sum(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                result[i + j] += arr1[i] * arr2[j];
            }
        }

        for (int i = 0; i < result.length -1; i++) {
            int j = result[i];
            result[i] = j % 10;
            result[i + 1] += j / 10;
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr1 = {5,2,3};
        int[] arr2 = {1,1,1};
        sum(arr1,arr2);
    }

}
