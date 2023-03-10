package FirstExercise.dp.easy;

import java.util.Arrays;

public class T674 {
    public int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
