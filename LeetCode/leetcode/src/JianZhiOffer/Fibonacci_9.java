package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/15.
 */
public class Fibonacci_9 {
    //递归，重复计算导致效率低
    public static long Fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //循环，保存计算过的数
    public static long Fibonacci01(int n){
        int[] result = {0,1};
        if (n < 2) return result[n];
        long before = 0;
        long after = 1;
        long fib = 0;
        for (int i = 2; i <= n ; i++) {
            fib = before + after;
            before = after;
            after = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        String k = new String();
        k = "hello";
        String m = new String("hello");
        char[] c = {'h','e','l','l','o'};
//        System.out.println(s == t);  //true,直接量存到常量池
//        System.out.println(s == k);     //true
//        System.out.println(s == m);     //false,m中不是直接量
//        System.out.println(m == k);     //false

//        System.out.println(Math.pow(2,5));
//        System.out.println(Math.sqrt(16));
//        System.out.println(Math.round(1.4));

        System.out.println(Math.random());
//        System.out.println(s == c);


//        System.out.println(Fibonacci01(100));
    }
}
