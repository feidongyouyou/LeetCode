/**
 * Created by Administrator on 2018/4/5.
 */
import java.util.Scanner;
public class RotateDigits {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();
        String[] nums = line.split(" ");

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        int[] number = new int[n + 1];
        number[0] = 0;

        int max = n / m;
        int sum = 0;
        sum = (max / 2) * m * m;
        System.out.println(sum);

//        int p = 1;
//        int q = m + 1;
//        for (int i = 0; i < max; i++) {
//            if (i % 2 == 0){
//                int j = 0;
//                for ( j = p; j < p + m && j < n + 1; j++) {
//                    number[j] = j - 2 * j;
//                }
//                p = j + m;
//            }else if (i % 2 != 0){
//                int k = 0;
//                for (k = q; k < k + m && k < n + 1; k++) {
//                    number[k] = k;
//                }
//                q = k + m;
//            }
//        }
//
//        int sum = 0;
//        for (int i = 1; i <= n  ; i++) {
//            System.out.print(number[i] + ",");
//            sum = sum + number[i];
//        }
//        System.out.println(sum);
    }
}

