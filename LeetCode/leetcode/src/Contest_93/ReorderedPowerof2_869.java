package Contest_93;

/**
 * Created by Administrator on 2018/7/15.
 */
public class ReorderedPowerof2_869 {
    public static boolean reorderedPowerOf2(int N) {
        for (int i = 1; i < Math.pow(10, 9); i = i * 2) {
            if (equalAfterReorder(N, i)){
                return true;
            }
        }
        return false;
    }


    public static boolean equalAfterReorder(int num1, int num2){
        char[] str1 = Integer.valueOf(num1).toString().toCharArray();
        char[] str2 = Integer.valueOf(num2).toString().toCharArray();
        int[] nums = new int[10];
        for (char c : str1){
            nums[c - '0']--;
        }
        for (char c : str2){
            nums[c - '0']++;
        }
        for (int n : nums){
            if (n != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a = 1024;
        reorderedPowerOf2(1024);
    }
}
