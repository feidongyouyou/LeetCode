package DataStructure.Search;

/**
 * Created by Administrator on 2018/7/11.
 */
//二分查找，折半查找
public class BinarySearch {
    public static int binarySearch(int[] a, int key){
        if (a == null || a.length == 0) return -1;
        int low = 0, high = a.length - 1, mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (key < a[mid]){
                high = mid -1;
            }else if (key > a[mid]){
                low = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {};
        int key = 4;
        System.out.println(binarySearch(a, key));
    }
}
