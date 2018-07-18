package NowCodeMoNi;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/5/23.
 */
public class XueGao03 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int types = cin.nextInt();
        int sum = 6;
        for (int i = 0; i < types; i++) {
            int day = cin.nextInt();
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            if (isEnough(a, b, c)){

                continue;
            }else System.out.println("false");
        }
    }

    public static boolean isEnough(int a, int b, int c){
        if (c >= 2){
            c -= 2;
        }else if (c == 1){
            c -= 1;
            if (b >= 1){
                b -= 1;
                if (a >= 1){
                    a -= 1;
                }
            }else a -= 3;
        }else{
            if (b >= 3){
                b -= 3;
            }else if (b == 2){
                b -= 2;
                a -= 2;
            }else if (b == 1){
                b -= 1;
                a -= 4;
            }else{
                a -= 6;
            }
        }
        return true;
    }
}
