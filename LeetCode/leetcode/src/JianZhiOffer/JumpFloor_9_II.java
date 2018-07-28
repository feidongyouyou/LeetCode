package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/21.
 */
//变态青蛙跳台阶：n级台阶，一次可以跳1阶，也可以跳2阶。。。也可以跳n阶
public class JumpFloor_9_II {
    public int JumpFloorII(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        //f(n) = f(n - 1) + f(n - 2) + f(n - 3) + ... + f(1) + 1，最后的1为一次跳n阶只有一种跳法
        int result = 0;
        for(int i = target - 1; i > 0; i--){
            result = result + JumpFloorII(i);
        }
        result = result + 1;
        return result;
    }
}
