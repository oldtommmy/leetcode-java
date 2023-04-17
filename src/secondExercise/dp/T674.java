package secondExercise.dp;

import java.util.Arrays;

public class T674 {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int length = nums.length;

        //dp[i] 表示以 nums[i] 结尾的最长递增序列的长度
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
