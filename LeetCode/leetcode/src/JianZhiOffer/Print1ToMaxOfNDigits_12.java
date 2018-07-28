package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/24.
 */
public class Print1ToMaxOfNDigits_12 {


    public static void print1ToMaxOfNDigits(int n){
        if(n <= 0) return;
        int[] number = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            number[i] = 0;
        }
        number[n] = 1;
        while (number[0] != 1){
            printNum(number);
            increment(number, n);
//            System.out.println("*****");


        }
    }

    public static void increment(int[] num, int index){
        if (num[index] == 9){
            increment(num, index - 1);
            num[index] = 0;
        }else {
            num[index] += 1;
        }
    }

    public static void printNum(int[] num){
        int index = 0;
        int len = num.length;
        for (int i = 0; i < len; i++) {
            if (num[i] != 0){
                index = i;
                break;
            }
        }
        int sum = 0;
        for (int i = index; i < len; i++) {
            sum += num[i] * Math.pow(10, len - 1 - i);
//            System.out.println(sum);
        }
        System.out.print(sum + " ");
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }
}
