/**
 * Created by Administrator on 2018/3/29.
 */
public class MIncreasetoKeepCitySkyline_807 {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        int len = grid.length;
        int[] leftToRight = new int[len];
        int[] topToBottom = new int[len];

        for (int i = 0; i < len; i++) {
            leftToRight[i] = findMax(grid[i]);
        }

        for (int j = 0; j < len; j++) {
            int[] column = new int[len];
            for (int k = 0; k < len; k++) {
                column[k] = grid[k][j];
            }
            topToBottom[j] = findMax(column);
        }

        int[][] skyLine = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                skyLine[i][j] = Math.min(leftToRight[i], topToBottom[j]);
                if(grid[i][j] < skyLine[i][j]){
                    result += skyLine[i][j] - grid[i][j];
                }
            }
        }

        return result;

    }

    public static int findMax(int[] compare){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < compare.length; i++) {
            if(compare[i] > max){
                max = compare[i];
            }
        }
        return max;
    }

}
