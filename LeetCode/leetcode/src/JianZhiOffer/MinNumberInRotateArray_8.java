package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/15.
 */
//面试题8：旋转数组的最小数字
//输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素，
// 例如；{3,4,5,1,2}是{1,2,3,4,5}的一个旋转
public class MinNumberInRotateArray_8 {
    //二分查找（注意：1、数组中只有1个元素 2、可能为原数组 3、可能三个值都相等）
    public static int minNumberInRotateArray(int[] array){
        if (array == null || array.length <= 0) return Integer.MIN_VALUE;
        int len = array.length;
        //数组中只有一个元素
        if (len == 1) return array[0];
        //旋转了0个元素，仍为原数组
        if (array[0] < array[len - 1]) return array[0];
        int low = 0, mid, high = len - 1;
        while (low < high - 1){
            mid = (low + high) / 2;
            //前、后、中间三个值都相等，则采用顺序查找最小值
            if (array[low] == array[high] && array[mid] == array[low]){
                return findMinNum(array, low, high);
            }
            if (array[mid] >= array[low]){
                low = mid;
            }
            if (array[mid] <= array[high]){
                high = mid;
            }
        }
        return array[high];
    }

    public static int findMinNum(int[] a, int start, int end){
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end ; i++) {
            if (a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    //第一对前面数字比后面数组大，后面数字即为最小元素
    public static int minNumberInRotateArray02(int[] array){
        if (array == null) return Integer.MIN_VALUE;
        int len = array.length;
        if (len == 1) return array[0];
        if (array[0] < array[len - 1]) return array[0];
        int i;
        for (i = 0; i < len - 1; i++) {
            if (array[i] > array[i + 1]){
               break;

            }
        }
        return array[i + 1];
    }

    public static void main(String[] args) {
        int[] a = new int[]{3};
        System.out.println(minNumberInRotateArray02(a));
    }
}
