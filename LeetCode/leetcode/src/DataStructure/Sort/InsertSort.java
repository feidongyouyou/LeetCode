package DataStructure.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/12.
 */
public class InsertSort {
    public static void insertSort(int[] a){
        if (a == null) return;
        int len = a.length;

        for (int i = 1; i < len ; i++) {
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int key = a[i];
                while (j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = key;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,5,8,3,7,4,6,2};
//        int[] a = null;
        System.out.println(Arrays.toString(a));
        insertSort(a);
    }
}
