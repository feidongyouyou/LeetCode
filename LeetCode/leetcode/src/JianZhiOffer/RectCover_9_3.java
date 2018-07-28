package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/21.
 */
//矩阵覆盖：用n个2*1的矩阵无重叠地覆盖一个2*n的大矩阵
public class RectCover_9_3 {
    public int RectCover(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        //第一个小矩阵选择：竖着覆盖               横着覆盖
        return RectCover(target - 1) + RectCover(target - 2);

    }
}
