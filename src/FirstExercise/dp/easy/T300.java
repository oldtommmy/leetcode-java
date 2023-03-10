package FirstExercise.dp.easy;

import java.util.Arrays;

public class T300 {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        int result = 1;
        //dp[i] 指以nums[i]结尾的最长公共子序列的长度
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = result > dp[i] ? result : dp[i];
        }
        return result;
    }
}
