package Contest_87;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/6/3.
 */
public class LongestMountaininArray_845 {
    public static int longestMountain2(int[] A) {
        if (A.length <= 2)  return 0;

        int len = A.length;
        int[] increaseToX = new int[len];
        int[] decreaseFromX = new int[len];
        LinkedList<Integer> results = new LinkedList<>();

        increaseToX[0] = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1]){
                increaseToX[i] = increaseToX[i - 1] + 1;
            }
            else{
                increaseToX[i] = 1;
            }
        }

        decreaseFromX[len - 1] = 1;
        for (int i = len - 2; i >= 0 ; i--) {
            if (A[i] > A[i + 1]){
                decreaseFromX[i] = decreaseFromX[i + 1] + 1;
            }
            else{
                decreaseFromX[i] = 1;
            }
        }

        for (int i = 0; i < len; i++) {
            if (increaseToX[i] == 1 || decreaseFromX[i] == 1)   continue;
            results.add(increaseToX[i] + decreaseFromX[i] - 1);
        }

        if (results.size() == 0)    return 0;
        Collections.sort(results);
        return results.getLast();
    }


        public static int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int result = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int count = 0;
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                //System.out.println(A[i]);
                count = 3;

                for (int k = i + 2; k < A.length; k++) {
                    //System.out.println(A[k]);
                    //System.out.println(A[k - 1]);
                    if (A[k] < A[k - 1]) {
                        count++;

                        //System.out.println(count);
                    }
                    else break;
                }
                for (int j = i - 2; j >= 0; j--) {
                    if (A[j] < A[j + 1]) {
                        count++;
                        //System.out.println(count);
                    }
                    else break;
                }


            }
            if (count > result) result = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,1,4,7,3,2,5};
        System.out.println(longestMountain(a));
    }
}
