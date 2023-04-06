package secondExercise.dp;

public class T343 {
    public int integerBreak(int n) {

        //dp[n]指n被拆分的最大乘积
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        //1.拆成 2 个数
        //2.拆成 >= 3个数
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }

        return dp[n];
    }
}
