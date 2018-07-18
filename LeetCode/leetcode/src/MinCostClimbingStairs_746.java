/**
 * Created by Administrator on 2017/12/17.
 */
public class MinCostClimbingStairs_746 {
    //从后往前动态规划
    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;

        int[] dp = new int[len];
        dp[len - 1] = cost[len - 1];
        dp[len - 2] = cost[len - 2];

        for (int i = len - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        if(dp[0] <= dp[1]) return dp[0];
        return dp[1];
    }
//从前往后动态规划
    public int minCostClimbingStairs02(int[] cost){


        int len = cost.length;
        int[] dp = new int[len + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len + 1; i++) {
            if(i == len) dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return  dp[len];
    }
//优化02
    public int minCostClimbingStairs03(int[] cost){
        int len = cost.length;
        int[] dp = new int[len];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return  Math.min(dp[len - 1], dp[len -2]);
    }
}
