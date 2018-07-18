/**
 * Created by Administrator on 2017/12/12.
 */
public class DeleteAndEarn_740 {
    public static int deleteAndEarn(int[] nums){
        if(nums.length == 0 || nums == null) return 0;

        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }

        int[] extra = new int[max + 1];
        for(int j = 0; j < nums.length; j++){
            extra[nums[j]]++;
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = extra[1] * 1;
        for(int k = 2; k < max + 1; k++){
            if((dp[k-2] + extra[k] * k) > dp[k-1]) dp[k] = dp[k-2] + extra[k] * k;
            else dp[k] = dp[k-1];
        }

        return dp[max];
    }

    public static void main(String[] args){
        int[] nums = new int[]{8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4};
        System.out.println(deleteAndEarn(nums));
    }

}
