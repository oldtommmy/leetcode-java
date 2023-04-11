package secondExercise.dp;

public class T300 {
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int ans = 1;
        //dp[i]指以 nums[i]结尾的最长子序列长度
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
