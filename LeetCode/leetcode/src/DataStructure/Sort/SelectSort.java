package DataStructure.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/12.
 */
public class SelectSort {
    public static void selectSort(int[] a){
        if (a == null) return;
        int min;
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min]){
                    min = j;
                }
            }
            if (i != min){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,5,8,3,7,4,6,2};
//        int[] a = null;
        System.out.println(Arrays.toString(a));
        selectSort(a);
    }
}
