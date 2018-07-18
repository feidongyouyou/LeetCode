import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/27.
 */
public class NiuNiu {
    public static int[] clock(int number, int[][] clock, int time, int hour, int minute){
        int[] result = new int[2];
        int rminute = 0;
        int rhour = 0;
        if(time <= minute) {rminute = minute - time; rhour = hour;}
        else if (time <= minute + 100) {
            if (hour > 0){
                rhour = hour - 1;
            }else rhour = hour + 12 - 1;

            rminute = minute + 100 - time;
        }
        else {
            if (hour > 1){
                rhour = hour -2;
            }else rhour = hour + 12 -2;

            rminute = 120 + minute - time;
        }

        result[0] = rhour;
        result[1] = rminute;
        System.out.println(rhour);
        System.out.println(rminute);

        return result;
    }

    public static void main(String[] args){
        int n = 3;
        int[][] c= new int[3][2];
        int ti = 59;
        int h = 6,m = 59;
        System.out.print(clock(n,c,ti,h,m));
    }
}
