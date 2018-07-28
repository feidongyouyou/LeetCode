package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/23.
 */
//面试题11：数值的整数次方
    //考虑各种可能性
public class Power_11 {
    static boolean withError;
    public static double Power(double base, int exponent){
        withError = false;
        if (base == 0 && exponent == 0){
            return 0.0;
        }
        if (base == 0 && exponent < 0){
            withError = true;
            return 0.0;
        }
        if (exponent < 0){
            return 1.0 / fasterPowerOfUnsignedExponent(base, -exponent);
        }else if(exponent > 0){
            return fasterPowerOfUnsignedExponent(base, exponent);
        }else {
            return 1.0;
        }

    }

    public static double fasterPowerOfUnsignedExponent(double base, int exponent){
        double res = 1.0;
        if (exponent == 0) return 1.0;
        if (exponent == 1) return base;

        res = fasterPowerOfUnsignedExponent(base, exponent >> 1);
        res *= res;
        if ((exponent & 1) == 1){
            res *= base;
        }
        return res;

    }

    public static double powerOfUnsignedExponent(double base, int exponent){
        System.out.println("*****");
        double res = 1.0;
        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = 6;
        System.out.println(Power(base, exponent));

    }
}
