/**
 * Created by Administrator on 2018/3/6.
 */
public class RotatedDigits_788 {
    public static int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            String str = i + "";
            if (is_good(str)) {
                System.out.print(i);
                count++;
            }
        }
        return count;
    }

    public static boolean is_good(String s){
        if(s.contains("3") || s.contains("4") || s.contains("7")) {
            return false;
        }
        if (!s.contains("2") && !s.contains("5") && !s.contains("6") && !s.contains("9")) {
            return false;
        }
        return true;
    }

    public static void main (String[] args){
        rotatedDigits(10);
    }
}
