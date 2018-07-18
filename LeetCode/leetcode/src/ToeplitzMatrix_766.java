/**
 * Created by Administrator on 2018/1/29.
 */
public class ToeplitzMatrix_766 {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int len = matrix.length;
        int l = matrix[0].length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 1; j < len; j++) {
                if(matrix[0][i] != matrix[j][j]) return false;
            }
        }


        return true;
    }

    public static void main(String[] args){
        int[][] a = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};

        System.out.print(isToeplitzMatrix(a));
    }
}
