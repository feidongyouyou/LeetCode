package DataStructure.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/12.
 */
public class ShellSort {
    public static void shellSort(int[] a){
        if (a == null) return;
        int len = a.length;
        int increment = len;
        while (increment > 1) {
            increment = increment / 3 + 1;
            for (int i = increment; i < len; i = i + increment ) {
                if (a[i - increment] > a[i]){
                    int key = a[i];
                    int j;
                    for (j = i - increment; j >= 0 && a[j] > key ; j = j - increment) {
                        a[j + increment] = a[j];
                    }
                    a[j + increment] = key;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,5,8,3,7,4,6,2};
//        int[] a = null;
        System.out.println(Arrays.toString(a));
        shellSort(a);
    }
}
