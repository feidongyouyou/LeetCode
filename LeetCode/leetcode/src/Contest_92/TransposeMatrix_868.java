package Contest_92;

/**
 * Created by Administrator on 2018/7/8.
 */
public class TransposeMatrix_868 {
    public int[][] transpose(int[][] A) {
        if (A.length == 0) return null;
        int m = A.length;
        int n = A[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}
