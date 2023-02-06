package FirstExercise.array.slidingWindow;

@SuppressWarnings({"all"})
public class T209 {
    public int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE, sum = 0;
        for (int i = 0, j = 0; i < nums.length || j < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                sum -= nums[j];
                j++;
                result = result > (i - j + 2) ? (i - j + 2) : result;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
}
