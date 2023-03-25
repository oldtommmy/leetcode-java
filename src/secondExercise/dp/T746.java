package secondExercise.dp;

public class T746 {
    public int minCostClimbingStairs(int[] cost) {

        int length = cost.length;
        int[] dp = new int[length + 1];
        //dp[i]是指到i层所需最小花费
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[length];
    }
}
