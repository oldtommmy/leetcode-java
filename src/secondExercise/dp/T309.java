package secondExercise.dp;

public class T309 {
    public int maxProfit(int[] prices) {
        //状态
        //0 不持有股票 进入冷冻期 今天刚卖出
        //1 不持有股票 且不在冷冻期 即两天或者两天以上就已卖出
        //2 不持有股票 在冷冻期 昨天卖出的
        //3 持有股票
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][3] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0];
            dp[i][3] = Math.max(dp[i - 1][1] - prices[i],
                    Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]));
        }
        return Math.max(Math.max(dp[len - 1][1], dp[len - 1][0]), dp[len - 1][2]);
    }
}
