package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/26.
 */
//还没写完
public class AddTwoBigNum_12 {
    public static int addTwoBigNum(int n, int m){
        if (n == 0 && m != 0) return m;
        if (m == 0 && n != 0) return n;
        if (n == 0 && m == 0) return 0;
        int ln = 0, lm = 0;
        while (n != 0){
            ln++;
            n = n / 10;
        }
        while (m != 0){
            lm++;
            m = m / 10;
        }
        int len = Math.max(ln, lm);
        int[] N = new int[len];
        int[] M = new int[len];
        int[] res = new int[len + 1];
        int i = len - 1;
        while (n != 0){
            N[i--] = n % 10;
            n = n / 10;
        }
        i = len - 1;
        while (m != 0){
            M[i--] = m % 10;
            m = m / 10;
        }
        int extra = 0;
        if (n > 0 && m > 0){
            for (int j = len - 1; j >= 0 ; j--) {

                int sum = N[j] + M[j] + extra;
                if (j == 0 && sum > 10){
                    res[j + 1] = sum % 10;
                    res[j] = sum / 10;
                }
                if (sum < 10){
                    extra = 0;
                    res[j + 1] = sum;
                }else {
                    extra = 1;
                    res[j + 1] = sum % 10;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
