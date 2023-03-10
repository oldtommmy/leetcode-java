package FirstExercise.dp.easy;

public class T714 {
    public int maxProfit(int[] prices, int fee) {
        
        //两个状态 
        // 0 持有 
        // 1 不持有
        int length = prices.length;
        int[][] dp = new int[length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }

        return dp[length - 1][1];
    }
}
