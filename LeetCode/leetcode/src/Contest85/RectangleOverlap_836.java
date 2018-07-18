package Contest85;

/**
 * Created by Administrator on 2018/5/20.
 */
public class RectangleOverlap_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int a1 = rec2[0], b1 = rec2[1], a2 = rec2[2], b2 = rec2[3];
        if ((x2 <= a1)||(a2 <= x1)||(y2 <= b1)||(b2 <= y1)) return false;
        return true;
    }
}
