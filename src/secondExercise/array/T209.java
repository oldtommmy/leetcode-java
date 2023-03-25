package secondExercise.array;

public class T209 {
    public int minSubArrayLen(int target, int[] nums) {
        int fast = 0, slow = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while (fast < nums.length) {
            sum += nums[fast];
            while (sum >= target) {
                ans = Math.min(ans, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
