package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/23.
 */
public class BinaryMToBinaryN_10 {
    public static int binaryMToBinaryN(int m, int n){
        int res = m ^ n;
        int count = 0;
        while (res != 0){
            count++;
            res = res & (res - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 13;
        System.out.println(binaryMToBinaryN(m, n));
    }
}
