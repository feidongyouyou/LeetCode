package DataStructure.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/12.
 */
public class BubbleSort {
    public static void bubbleSort01(int[] a){
        if (a == null) return;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));

    }

    //第i趟确定第i个位置的值，j从后向前循环
    public static void bubbleSort(int[] a){
        if (a == null) return;
        int len = a.length;
//        System.out.println(len);
        for (int i = 0; i < len - 1 ; i++) { //只需要跑n - 1趟，第i趟确定第i个位置的值
            for (int j = len - 2; j >= i; j--) {
//                System.out.println(a[j]);
//                System.out.println(a[j + 1]);
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
//                System.out.println(a[j]);
//                System.out.println(a[j + 1]);
//                System.out.println();
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //没有数据交换，说明已经有序，因此不用继续排序
    public static void bubbleSortWithFlag(int[] a){
        if (a == null) return;
        boolean flag = true;
        int len = a.length;
        for (int i = 0; i < len - 1 && flag == true; i++) {//上一次没有数据交换说明已有序
            for (int j = len - 2; j >= i ; j--) {
                flag = false;
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(a));
        bubbleSortWithFlag(a);
    }
}
