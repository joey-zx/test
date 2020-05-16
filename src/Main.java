
public class Main {

    public static void quickSort(int[] arr,int low, int high) {

        int firstStep,finalStep,x,tmp;

        if(low>high){
            return;
        }

        firstStep = low;
        finalStep = high;

        //先选举一个基准，让左边数全部小于这个基准，右边的数全部大于这个基准
        tmp = arr[firstStep];

        for(;firstStep < finalStep; ) {

            // 从右边哨兵开始找到比基准数小的数，记录他的位置
            while(tmp <= arr[finalStep] && firstStep < finalStep) {
                finalStep --;
            }

            // 从左边边哨兵开始找到比基准数大的数，记录他的位置
            while(tmp >= arr[firstStep] && firstStep < finalStep) {
                firstStep ++;
            }

            //交换两个数的位置
            if(firstStep < finalStep) {
                x = arr[firstStep];
                arr[firstStep] = arr[finalStep];
                arr[finalStep] = x;
            }

        }

        arr[low] = arr[finalStep];
        arr[finalStep] = tmp;

        //递归处理左边的序列
        quickSort(arr,low,finalStep - 1);

        //递归处理右边的序列
        quickSort(arr,finalStep + 1,high);

    }

    public static void main(String[] args) {

        int[] arr = {6 ,1 ,2 ,7 ,9 ,8 ,4 ,5 ,10 ,8};
        quickSort(arr,0,arr.length -1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

