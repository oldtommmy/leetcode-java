package FirstExercise.dp.easy;

public class T518 {
    public int change(int amount, int[] coins) {

        //dp[j]表示组成j的方式
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //组合问题
        //先物品 后背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];

    }
}
