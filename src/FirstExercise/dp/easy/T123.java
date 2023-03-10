package FirstExercise.dp.easy;


public class T123 {
    public int maxProfit(int[] prices) {

        //最多只能完成两笔交易
        //dp数组有五个状态
        //0：是无操作
        //1：第一次持有股票
        //2：第一次不持有股票
        //3：第二次持有股票
        //4：第二次不持有股票
        //tips: 持有不等于在该天买入
        int length = prices.length;
        int[][] dp = new int[length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[length - 1][4];
    }
}
