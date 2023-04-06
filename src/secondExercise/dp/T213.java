package secondExercise.dp;

public class T213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int start = getMoney(nums, 0, nums.length - 2);
        int end = getMoney(nums, 1, nums.length - 1);
        return Math.max(start, end);
    }

    public int getMoney(int[] nums, int left, int right) {

        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[right];
    }
}
