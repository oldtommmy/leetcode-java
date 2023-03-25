package secondExercise.greedy;

public class T376 {
    public int wiggleMaxLength(int[] nums) {
        return byGreedy(nums);
    }

    private int byGreedy(int[] nums) {
        int length = nums.length;
        int pre = 0;
        int cur = 0;
        int ans = 1;
        for (int i = 0; i < length; i++) {
            cur = nums[i + 1] - nums[i];
            if ((pre <= 0 && cur > 0) || (pre >= 0 && cur < 0)) {
                ans++;
                pre = cur;
            }
        }
        return ans;
    }

    private int byDp(int[] nums) {
        int length = nums.length;
        //dp[i][1]表示前i个数，第i个作为山峰的最长长度
        //dp[i][0]表示前i个数，第i个作为山谷的最长长度
        int[][] dp = new int[length][2];
        dp[0][1] = 1;
        dp[0][0] = 1;
        for (int i = 0; i < length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
