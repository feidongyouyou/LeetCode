package DataStructure.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/13.
 */
public class MergeSort {
    public static void mergeSort(int[] a, int start, int end){
        if (a == null) return;
        if(start == end) return;
        int len = a.length;
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] a, int start, int middle, int end){

        //将数组分成左右2个数组
        int lenLeft = middle - start + 2;
        int lenRight = end - middle + 1;
        int[] left = new int[lenLeft];
        int[] right = new int[lenRight];
        for (int i = start; i <= middle; i++) {
            left[i - start] = a[i];
        }
        for (int i = middle + 1; i <= end; i++) {
            right[i - middle - 1] = a[i];
        }
        left[lenLeft - 1] = Integer.MAX_VALUE;
        right[lenRight - 1] = Integer.MAX_VALUE;

        int j = 0, k = 0;
        for (int i = start; i <= end; i++) {
            if (left[j] < right[k]) a[i] = left[j++];
            else                    a[i] = right[k++];
        }

    }


    //非递归解法
    public static void mergeSort02(int[] a){
        int k = 1;
        while (k < a.length){
            mergePass(a, k);
            k *= 2;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void mergePass(int[] a, int k){
        int i;
        for (i = 0; i + 2 * k - 1 < a.length; i = i + 2 * k) {
            merge(a, i, i + k - 1, i + 2 * k - 1);
        }
        System.out.println(i);
        if (a.length - 1 > i + k - 1){
            merge(a,i,i + k - 1,a.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,5,8,3,7,4,6,2,0};
//        int[] a = null;
        mergeSort02(a);
    }
}
