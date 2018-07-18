package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/8.
 */
//面试题3：二维数组中的查找
// 数组中每一行从左到右递增，每一列从上到下递增
public class FindNumberInMatrix_3 {
    //将目标值与右上角的值比较，等于则返回true，小于则剔除列，大于则剔除行
    //运行时间：232ms，占用内存：17568k
    public static boolean Find(int target, int [][] array) {
        if (array == null) return false;
        int rows = array.length;
//        System.out.println(rows);
        if (rows == 0) return false;
        int columns = array[0].length;
//        System.out.println(columns);
        if (columns == 0){
            return false;
        }
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0){
            if (array[row][column] == target){
                return true;
            }else if (target < array[row][column]){
                column--;
            }else row++;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int[][] arr = null;
        int[][] arr = {{}};
        int tar = 20;
        System.out.println(Find(tar, arr));
    }

}
