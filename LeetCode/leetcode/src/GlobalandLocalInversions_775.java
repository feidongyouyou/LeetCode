import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/28.
 */
public class GlobalandLocalInversions_775 {
    public static boolean isIdealPermutation(int[] A) {
//        for(int i = 0; i < A.length; i++){               //第一种解法
//            if(Math.abs(A[i] - i) >= 2) return false;
//        }
//        return true;
        int len = A.length;                                //第二种解法
        int localNum = 0;
        for (int i = 0; i < len - 1; i++) {     //计算局部逆序对
            if(A[i] > A[i + 1]) localNum++;
        }

        count = 0;
        mergeSort(A, 0, len - 1);        //用归并排序计算全局逆序对

        if(count != localNum) return false;
        return true;

    }
    public static int count = 0;     //递归 -》相当于全局变量
    public static void mergeSort(int[] arr, int l , int r){
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);     //已经有序的前半部分数组
            mergeSort(arr, m + 1, r);   //已经有序的后半部分数组

            merge(arr, l, m, r);        //合并两个有序数组
        }// 9 6 7 5 8 3 1 2

    }

    public static void merge(int[] arr, int p, int q, int r){
//        int count = 0;
        int n1 = q - p + 1, n2 = r - q; //数组长度
        int[] L = new int[n1+1]; //创建两个新数组
        int[] R = new int[n2+1];
        int i, j,k;
        for (i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = arr[q+1+j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        i = 0;
        j = 0;
        k = p;
        while (L[i] != Integer.MAX_VALUE && R[j] != Integer.MAX_VALUE){
            if (L[i] <= R[j]){
                arr[k++] = L[i++];
            }
            else{
                count += n1 - i;          //L数组中从L【i】到最后都比R【j】大，都是逆序对
                arr[k++] = R[j++];
            }
        }
        while (L[i] != Integer.MAX_VALUE){        //R数组走到头
            arr[k++] = L[i++];
        }
        while (R[j] != Integer.MAX_VALUE){        //L数组走到头
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args){
        int[] B = new int[]{1,2,0};
        System.out.print(isIdealPermutation(B));
    }


}
