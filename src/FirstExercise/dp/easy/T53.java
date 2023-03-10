package FirstExercise.dp.easy;

public class T53 {
    public int maxSubArray(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length + 1];
        int res = Integer.MIN_VALUE;
        //dp[i]的含义是nums[i - 1]结尾的最大连续子序列的和

        for (int i = 1; i <= length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i - 1];
            } else {
                dp[i] = nums[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
