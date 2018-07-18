package DataStructure.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/13.
 */
public class QuickSort {
    public static void quickSort(int[] a, int low, int high){
        int pivot;
        if (low < high){
            pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
        System.out.println(Arrays.toString(a));
    }

    public static int partition(int[] a, int low, int high){
        int key = a[low];
        while (low < high){
            while (low < high && a[high] > key){
                high--;
            }
            swap(a, low, high);
            while (low < high && a[low] < key){
                low++;
            }
            swap(a, low, high);
        }
        return low;
    }

    static void swap(int[] a,int left,int right){
        if (left == right)  return;
        int t;
        t = a[left];
        a[left] = a[right];
        a[right] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,5,8,3,7,4,6,2};
//        int[] a = null;
        quickSort(a, 0, a.length - 1);
    }
}
