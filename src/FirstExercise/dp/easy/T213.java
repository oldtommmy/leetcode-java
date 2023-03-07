package FirstExercise.dp.easy;


class T213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int res1 = robAction(nums, 0, length - 2);
        int res2 = robAction(nums, 1, length - 1);
        return Math.max(res1, res2);

    }

    private int robAction(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int length = nums.length;
        //dp[j]是指前j个房子可偷窃的最大价值
        int[] dp = new int[length];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(dp[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[right];
    }
}