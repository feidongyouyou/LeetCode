package NowCodeMoNi;

import java.util.Arrays;
import java.util.Scanner;

public class GuPiao02 {
    public static void main(String[] args) {
        int result = 0;
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        int money = cin.nextInt();
        GuPiao[] gu = new GuPiao[num];
        int[] difference = new int[num];
        for (int i = 0; i < num; i++) {
            int in = cin.nextInt();
            int out = cin.nextInt();
            int differ = out - in;
            gu[i] = new GuPiao(in, out, differ);
            difference[i] = differ;
        }


    }
}

class GuPiao{
    int in;
    int out;
    int differ = out - in;

    public GuPiao(int in, int out, int differ) {
        this.in = in;
        this.out = out;
        this.differ = differ;
    }
}