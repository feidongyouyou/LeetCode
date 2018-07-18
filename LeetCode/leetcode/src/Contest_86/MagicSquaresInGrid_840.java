package Contest_86;

import java.util.HashSet;

/**
 * Created by Administrator on 2018/5/27.
 */
public class MagicSquaresInGrid_840 {
    public static int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        if (grid[0].length < 3 || grid.length < 3) return result;




//        if (grid[0].length == 3 && grid.length == 3){
//            if (isHuanFang(0, 0, grid)) return 1;
//            else return 0;
//        }
        int lenHang = grid.length -2;
        int lenLie = grid[0].length - 2;
        for (int i = 0; i < lenHang; i++) {
            for (int j = 0; j < lenLie; j++) {
                if (isHuanFang(i, j, grid)){
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean isHuanFang(int m, int n, int[][] N){

        HashSet<Integer> unrepeat = new HashSet<>();
        for (int i = m; i <= m + 2 ; i++) {
            for (int j = n; j <= n + 2; j++) {
                if (N[i][j] < 1 || N[i][j] > 9) return false;
                if (unrepeat.contains(N[i][j])) return false;
                else unrepeat.add(N[i][j]);
                
            }
        }


        int[] huan = new int[8];
        huan[0] = N[m][n] + N[m][n + 1] + N[m][n + 2];
        huan[1] = N[m + 1][n] + N[m + 1][n + 1] + N[m + 1][n + 2];
        huan[2] = N[m + 2][n] + N[m + 2][n + 1] + N[m + 2][n + 2];
        huan[3] = N[m][n] + N[m + 1][n] + N[m + 2][n];
        huan[4] = N[m][n + 1] + N[m + 1][n + 1] + N[m + 2][n + 1];
        huan[5] = N[m][n + 2] + N[m + 1][n + 2] + N[m + 2][n + 2];
        huan[6] = N[m][n] + N[m + 1][n + 1] + N[m + 2][n + 2];
        huan[7] = N[m + 2][n] + N[m + 1][n + 1] + N[m][n + 2];

        int target = huan[0];

        for (int i = 1; i < 8; i++) {
            if (target != huan[i])  return false;
        }


//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (huan[i] != huan[j])
//                    return false;
//            }
//        }
        return true;
    }

    public static void main(String[] args) {
        int[][] N = {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6}, {4, 3, 8, 2, 5
        }};
        System.out.println(numMagicSquaresInside(N));
    }

}
