package FirstExercise.dp.easy;

public class T121 {
    public int maxProfit(int[] prices) {
        return greedy(prices);
    }

    /**
     * 贪心算法
     * @param prices 价格数组
     * @return result
     */
    private int greedy(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }

    /**
     * 动态规划
     * @param prices 价格数组
     * @return result
     */
    private int dp(int[] prices) {

        //dp[i][0]表示第i天不持有股票所能获得的最大利润
        //dp[i][1]表示第i天持有股票所能获得的最大利润
        int length = prices.length;
        int[][] dp = new int[length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return Math.max(dp[length][0], dp[length][1]);
    }
}
