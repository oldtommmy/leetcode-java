package FirstExercise.dp.easy;

public class T309 {
    public int maxProfit(int[] prices) {

        //有三个状态
        //0今日处于冻结状态，不可买入股票
        //1持有股票
        //2不持有股票，保持卖出状态，可能前一天为冻结状态
        //3不持有股票，今日，卖出股票   
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0; 

        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0] - prices[i]));
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0]);    
            dp[i][3] = dp[i - 1][1] + prices[i]; 
        }
        return Math.max(Math.max(dp[len - 1][2], dp[len - 1][3]), dp[len - 1][0]);
    }
}
