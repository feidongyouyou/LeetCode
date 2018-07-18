/**
 * Created by Administrator on 2018/1/8.
 */
public class FindAnagramMappings_760 {
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;
        int[] result = new int[len];

        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len; j++) {
                if(A[i] == B[j]) result[i] = j;
            }
        }

        return result;
    }
}
