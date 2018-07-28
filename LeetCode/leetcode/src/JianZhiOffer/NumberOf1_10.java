package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/21.
 */
public class NumberOf1_10 {
    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
//        int c = 10;
        while (flag != 0){
            if ((n & flag) == flag){
                count++;
            }
            //flag左移
            flag = flag << 1;
//            c--;
//            System.out.println(flag);
        }
        return count;
    }
    //n和n - 1做位与&运算
    public static int NumberOf1_better(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 0;
        System.out.println(NumberOf1_better(n));
    }
}
