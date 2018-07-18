package Contest_93;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/7/15.
 */
public class AdvantageShuffle_870 {
    public static int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        HashMap<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            bMap.put(B[i], i);
        }

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = len - 1; i >= 0; i--) {
            if (A[i] < B[i]){
                int exchange = A[i];
                for (int j = i; j > 0 ; j--) {
                    A[j] = A[j - 1];
                }
                A[0] = exchange;
                i++;
            }
        }
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[bMap.get(B[i])] = A[i];
        }
        return a;
    }


    public static void main(String[] args) {
        int[] A = new int[]{12,24,8,32};
        int[] B = new int[]{13,25,32,11};
        for (int n : advantageCount(A, B)) {
            System.out.print(n + " ");
        }
    }
}
