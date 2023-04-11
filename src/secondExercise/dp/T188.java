package secondExercise.dp;

public class T188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][k + 1];
        dp[0][0] = 0;
        for (int i = 1; i < len; i += 2) {
            dp[0][i] = -prices[i];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                if (j % 2 != 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[len - 1][k];
    }
}
