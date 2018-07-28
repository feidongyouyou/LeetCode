package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/21.
 */
//青蛙跳台阶：一次可以跳1阶，也可以跳2阶
public class JumpFloor_9_I {
    public int JumpFloor(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        //青蛙第一次跳选择跳1阶，此时跳法数目为后面n - 1阶的跳法数目
        //青蛙第一次跳选择跳2阶，此时跳法数目为后面n - 2阶的跳法数目
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
