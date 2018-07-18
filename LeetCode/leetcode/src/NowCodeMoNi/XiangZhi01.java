package NowCodeMoNi;

import java.util.Scanner;

public class XiangZhi01 {
    public static void main(String[] args) {
        int count = 0;
        Scanner cin = new Scanner(System.in);
        long N = cin.nextLong();
        if (N == 1) {
            System.out.println(count);
        }
        else {
            while (N > 1) {
                if (N % 2 == 0) {
                    N = N / 2;
                    count++;
                } else {
                    N += 1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
