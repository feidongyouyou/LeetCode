package DataStructure.Search;

/**
 * Created by Administrator on 2018/7/11.
 */
public class FibonacciSearch {
    static int[] F = {0,1,1,2,3,5,8,13,21,34,55};
    public static int fibonacciSearch(int[] a, int key){
        if (a == null || a.length == 0) return -1;
        int len = a.length;
        int low = 0, high = len - 1, mid;
        int k = 0;
        while (len > F[k] - 1){
            k++;
        }
        for (int i = len; i < F[k] - 2; i++) {
            a[i] = a[len - 1];
        }

        while (low <= high){
            mid = low + F[k - 1] - 1;
            if (key < a[mid]){
                high = mid - 1;
                k = k - 1;
            }else if (key > a[mid]){
                low = mid + 1;
                k = k - 2;
            }else {
                if (mid < len){
                    return mid;
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int key = 6;
        System.out.println(fibonacciSearch(a, key));
    }
}
