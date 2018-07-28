package JianZhiOffer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/26.
 */
public class ReorderOddEven_14 {
    //类似partition思想，但奇数和奇数，偶数和偶数的相对位置会变
    public static void reorderOddEven(int[] array){
        if (array == null || array.length <= 0) return;

        int len = array.length;
        int low = 0, high = len - 1;
        while (low < high){
            while (low < high && isEven(array[high])){  //此处的判断条件可抽象成另外一个函数
                high--;
            }
            System.out.print("高：" + high);
            while (low < high && !isEven(array[low])){
                low++;
            }
            System.out.print("低：" + low);
            System.out.println();
            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
    }

    public static boolean isEven(int n){
        return (n & 1) == 0;
    }

    //先把奇数筛出来放一起，偶数筛出来放一起，再重置回原数组
    //奇数和奇数，偶数和偶数的相对次序不变
    public static void reorderOddEven_02(int[] array){
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int num :
                array) {
            if (num % 2 == 1) {
                odd.add(num);
            }else {
                even.add(num);
            }
        }

        for (int i = 0; i < odd.size(); i++) {
            array[i] = odd.get(i);
        }
        for (int i = odd.size(); i < array.length; i++) {
            array[i] = even.get(i - odd.size());
        }
    }

    public static void reorderOddEven_03(int[] array){
        if(array == null) return;
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                if (left == i){
                    left++;
                    continue;
                }
                int temp = array[i];
                for (int j = i; j > left; j--) {
                    array[j] = array[j - 1];
                }
                array[left++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,1,1,1,1,};
//        int[] arr = null;
        reorderOddEven_03(arr);
        for (int i:
             arr) {
            System.out.print(i + " ");
        }
    }
}
