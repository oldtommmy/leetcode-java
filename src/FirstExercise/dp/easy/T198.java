package FirstExercise.dp.easy;

public class T198 {
    public int rob(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        //dp[j]是指前j个房子可偷窃的最大价值
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
