/**
 * Created by Administrator on 2017/12/31.
 */
public class ReachaNumber_754 {
    public static int reachNumber(int target) {
        if (target < 0) target = -target;

        int len = (int) Math.sqrt(target * 2);
        while (len * (len + 1) >  2 * target){
            len--;
        }

        int moved = len * (len + 1) / 2 ;
        if (moved == target)    return len;

        for (;;) {
            len++;
            moved += len;
            if (((moved - target) & 1) == 0)    return len;

        }
    }

    public static void main(String[] args){
        System.out.println(reachNumber(13));
    }
}
