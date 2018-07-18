package DataStructure.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/13.
 */
public class HeapSort {
    public static void heapSort(int[] a) {
        if (a == null) return;
        int len = a.length;
        //从最后一个有孩子的结点开始构建大顶堆
        for (int i = (len - 1)/ 2; i >= 0 ; i--) {
            adjustHeap(a, i, len - 1);
        }
//        System.out.println(Arrays.toString(a));


        for (int i = len - 1; i > 0 ; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);
            System.out.println(Arrays.toString(a));

        }

    }

    public static void adjustHeap(int[] a, int start, int end){
        if (start == end) return;
        int key = a[start], j;
        for (j = 2 * start + 1; j <= end; j = 2 * j + 1) {
            if (j < end && a[j] < a[j + 1]){
                j++;
            }
            if (key >= a[j]){
                break;
            }
            a[start] = a[j];
            start = j;
        }
        a[start] = key;
    }
    public static void main(String[] args) {
        int[] a = new int[]{9,1,5,8,3,7,4,6,2};
//        int[] a = null;
        System.out.println(Arrays.toString(a));
        heapSort(a);
    }







}
