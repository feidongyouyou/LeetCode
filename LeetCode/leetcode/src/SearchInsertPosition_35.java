/**
 * Created by Administrator on 2018/3/18.
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
}
