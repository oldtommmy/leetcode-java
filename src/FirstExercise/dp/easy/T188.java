package FirstExercise.dp.easy;

public class T188 {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2 * k + 1];
        for (int i = 1; i < 2 * k; i+=2) {
            dp[0][i] = -prices[0];
        }

        //dp[i][1]，表示的是第i天，第一次买入股票的状态
        //dp[i][2]，表示的是第i天，第一次没买入股票的状态
        //...
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[length - 1][2 * k];
    }
}
