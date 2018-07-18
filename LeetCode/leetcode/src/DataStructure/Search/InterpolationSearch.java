package DataStructure.Search;

/**
 * Created by Administrator on 2018/7/11.
 */
//插值查找
public class InterpolationSearch {
    public static int interpolationSearch(int[] a, int key){
        if (a == null) return -1;
        int low = 0, high = a.length - 1, mid;
        while (low <= high){
            //中间值的计算变化
            mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
            if (key < a[mid]){
                high = mid - 1;
            }else if (key > a[mid]){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int key = 3;
        System.out.println(interpolationSearch(a, key));
    }
}
